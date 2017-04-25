package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class defines a 2D tree and perform special
 *
 * @author Raj92
 */
public class TwoDTree {

    TreeNode root;

    /**
     * Initializes a 2D tree from the file at the given path.
     *
     * @param crimeDataLocation 
     * Complexity: Theta(n log(n)) 
     * PreCondition: There
     * should be a file at crimeDataLocation with crime records as defined in
     * the format. 
     * PostCondition: A 2D tree will be created containing all the
     * records in the file.
     */
    public TwoDTree(String crimeDataLocation) {
        root = null;
        String recordEntry;
        String[] recordTokens;
        CrimeRecord recordObject;
        long count = 0;
        try (Scanner input = new Scanner(new File(crimeDataLocation))) {
            input.nextLine();
            while (input.hasNextLine()) {
                recordEntry = input.nextLine().trim();
                recordTokens = recordEntry.split(",");
                recordObject = new CrimeRecord(new BigDecimal(recordTokens[0].trim()), new BigDecimal(recordTokens[1].trim()),
                        Long.parseLong(recordTokens[2].trim()), recordTokens[3].trim(), recordTokens[4].trim(), recordTokens[5].trim(),
                        Long.parseLong(recordTokens[6].trim()), new BigDecimal(recordTokens[7].trim()),
                        new BigDecimal(recordTokens[8].trim()));
                this.insert(recordObject);
                count++;
            }
            System.out.println("Crime file loaded into 2d tree with " + count + " records");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TwoDTree.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private TwoDTree(TreeNode root) {
        this.root = root;
    }

    /**
     * Inserts a crime record into the 2D tree.
     *
     * @param root 
     * Complexity: Theta(log(n)) 
     * PreCondition: record should not be null.
     * PostCondition: A crime record will be inserted in the 2D tree.
     */
    private void insert(CrimeRecord record) {
        TreeNode insertNode = new TreeNode(record, null, null);
        if (root == null) {
            root = insertNode;
        } else {
            TreeNode cur = root;
            int level = 0;
            while (true) {
                if (level % 2 == 0) {
                    if (insertNode.getRecord().getX().compareTo(cur.getRecord().getX()) >= 0) {
                        if (cur.getRight() == null) {
                            cur.setRight(insertNode);
                            break;
                        } else {
                            cur = cur.getRight();
                            level++;
                        }
                    } else {
                        if (cur.getLeft() == null) {
                            cur.setLeft(insertNode);
                            break;
                        } else {
                            cur = cur.getLeft();
                            level++;
                        }
                    }
                } else {
                    if (insertNode.getRecord().getY().compareTo(cur.getRecord().getY()) >= 0) {
                        if (cur.getRight() == null) {
                            cur.setRight(insertNode);
                            break;
                        } else {
                            cur = cur.getRight();
                            level++;
                        }
                    } else {
                        if (cur.getLeft() == null) {
                            cur.setLeft(insertNode);
                            break;
                        } else {
                            cur = cur.getLeft();
                            level++;
                        }
                    }
                }
            }
        }
    }
    /**
     * PreCondition: The tree should not be null.
     * PostCondition: Traverses the two d tree in preorder fashion.
     */
    public void preOrderPrint() {
        if (root != null) {
            System.out.println(root.getRecord());
            if (root.getLeft() != null) {
                new TwoDTree(root.getLeft()).preOrderPrint();
            }
            if (root.getRight() != null) {
                new TwoDTree(root.getRight()).preOrderPrint();
            }
        }
    }
    
    /**
     * PreCondition: The tree should not be null.
     * PostCondition: Traverses the two d tree in in order fashion.
     */
    public void inOrderPrint() {
        if (root != null) {
            if (root.getLeft() != null) {
                new TwoDTree(root.getLeft()).inOrderPrint();
            }
            System.out.println(root.getRecord());
            if (root.getRight() != null) {
                new TwoDTree(root.getRight()).inOrderPrint();
            }
        }
    }
    
    /**
     * PreCondition: The tree should not be null.
     * PostCondition: Traverses the two d tree in post order fashion.
     */
    public void postOrderPrint() {
        if (root != null) {
            if (root.getLeft() != null) {
                new TwoDTree(root.getLeft()).postOrderPrint();
            }
            if (root.getRight() != null) {
                new TwoDTree(root.getRight()).postOrderPrint();
            }
            System.out.println(root.getRecord());
        }

    }

     /**
     * PreCondition: The tree should not be null.
     * PostCondition: Traverses the two d tree in level order fashion.
     */
    public void levelOrderPrint() {
        Queue q = new Queue();
        TreeNode cur;
        if (root != null) {
            q.insert(root);
        }
        while (!q.isEmpty()) {
            cur = q.remove();
            System.out.println(cur.getRecord());
            if (cur.getLeft() != null) {
                q.insert(cur.getLeft());
            }
            if (cur.getRight() != null) {
                q.insert(cur.getRight());
            }
        }
    }
    
    /**
     * PreCondition: Tree should not be null.
     * PostCondition: The 2D tree will be traversed in a post order fashion.
     * Complexity: O(n) , Omega(n), Theta(n)
     */
    public void reverseLevelOrderPrint() {
        Queue q = new Queue();
        Stack s = new Stack();
        TreeNode cur;
        if (root != null) {
            q.insert(root);
        }
        while (!q.isEmpty()) {
            cur = q.remove();
            s.push(cur);
            if (cur.getRight() != null) {
                q.insert(cur.getRight());
            }
            if (cur.getLeft() != null) {
                q.insert(cur.getLeft());
            }
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop().getRecord());
        }
    }

    /**
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return ListOfCrimes
     * PreCondition: x1 < x2, y1 < y2
     * PostCondition: A list of crimes that lie within the query rectangle will be returned.
     */
    public ListOfCrimes findPointsInRange(BigDecimal x1, BigDecimal y1, BigDecimal x2, BigDecimal y2) {
        ListOfCrimes listOfCrimes = new ListOfCrimes();
        listOfCrimes = traverseCrimes(x1, y1, x2, y2, 0, listOfCrimes);
        return listOfCrimes;
    }

    /**
     * Helper function for findPointsInRange(). Pre and post conditions same
     * as that.
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param level
     * @param listOfCrimes
     * @return 
     */
    private ListOfCrimes traverseCrimes(BigDecimal x1, BigDecimal y1,
            BigDecimal x2, BigDecimal y2, int level, ListOfCrimes listOfCrimes) {
        boolean checkLeft = false;
        boolean checkRight = false;
        if (listOfCrimes == null) {
            listOfCrimes = new ListOfCrimes();
        }
        listOfCrimes.setNodesTraversed(listOfCrimes.getNodesTraversed() + 1);
        if (root.getRecord().getX().compareTo(x1) >= 0
                && root.getRecord().getX().compareTo(x2) <= 0
                && root.getRecord().getY().compareTo(y1) >= 0
                && root.getRecord().getY().compareTo(y2) <= 0) {
            listOfCrimes.addCrime(root.getRecord());
        }
        if (level % 2 == 0) {
            if (root.getRecord().getX().compareTo(x1) < 0) {
                checkRight = true;
            }
            if (root.getRecord().getX().compareTo(x2) > 0) {
                checkLeft = true;
            }
        } else {
            if (root.getRecord().getY().compareTo(y1) < 0) {
                checkRight = true;
            }
            if (root.getRecord().getY().compareTo(y2) > 0) {
                checkLeft = true;
            }
        }
        if (!checkLeft && !checkRight) {
            if (root.getLeft() != null) {
                listOfCrimes = new TwoDTree(root.getLeft()).traverseCrimes(x1, y1, x2, y2, level + 1, listOfCrimes);
            }
            if (root.getRight() != null) {
                listOfCrimes = new TwoDTree(root.getRight()).traverseCrimes(x1, y1, x2, y2, level + 1, listOfCrimes);
            }
        } else if (checkLeft) {
            //line on the right/above the rectangle
            if (root.getLeft() != null) {
                listOfCrimes = new TwoDTree(root.getLeft()).traverseCrimes(x1, y1, x2, y2, level + 1, listOfCrimes);
            }
        } else {
            //line on the left/below the rectangle
            if (root.getRight() != null) {
                listOfCrimes = new TwoDTree(root.getRight()).traverseCrimes(x1, y1, x2, y2, level + 1, listOfCrimes);
            }
        }
        return listOfCrimes;
    }
    
    /**
     * Finds the nearest neighbor to the query point.
     * @param x1
     * @param y1
     * @return Neighbor
     * PreCondition: x1, y1 should not be null.
     * PostCondiition: The node on the tree which is closest to the query point (x1,y1)
     * is returned.
     */
    public Neighbor nearestNeighbor(BigDecimal x1, BigDecimal y1) {

        Neighbor neighbor = new Neighbor(Neighbor.MAX_LIMIT, null);
        neighbor = traverseNeighbors(x1, y1, 0, neighbor);
        return neighbor;
    }

     /**
      * Helper method for the nearestNeighbor() method
      * @param x1
      * @param y1
      * @param level
      * @param nearestNode
      * @return 
      * PreCondition: x1, y1 should not be null.
      * PostCondiition: The node on the tree which is closest to the query point (x1,y1)
      * is returned.
      */
    private Neighbor traverseNeighbors(BigDecimal x1, BigDecimal y1, int level,
            Neighbor nearestNode) {
        BigDecimal distance = findDistance(x1, y1, root.getRecord().getX(), root.getRecord().getY());
        nearestNode.setNodesTraversed(nearestNode.getNodesTraversed() + 1);

        //find distance
        if (distance.compareTo(nearestNode.getDistance()) < 0) {
            //found new champion
            nearestNode.setDistance(distance);
            nearestNode.setNeighbor(root);

            nearestNode.setxMax(x1.add(distance));
            nearestNode.setxMin(x1.subtract(distance));
            nearestNode.setyMax(y1.add(distance));
            nearestNode.setyMin(y1.subtract(distance));
        }

        if (level % 2 == 0) {
            if (root.getRecord().getX().compareTo(x1) >= 0) {
                if (root.getLeft() != null && root.getRecord().getX().compareTo(nearestNode.getxMin()) > 0) {
                    //move to the left
                    nearestNode = new TwoDTree(root.getLeft()).traverseNeighbors(x1, y1, level + 1, nearestNode);
                }
                if (root.getRight() != null && root.getRecord().getX().compareTo(nearestNode.getxMax()) <= 0) {
                    nearestNode = new TwoDTree(root.getRight()).traverseNeighbors(x1, y1, level + 1, nearestNode);
                }
            } else {
                if (root.getRight() != null && root.getRecord().getX().compareTo(nearestNode.getxMax()) < 0) {
                    nearestNode = new TwoDTree(root.getRight()).traverseNeighbors(x1, y1, level + 1, nearestNode);
                }
                if (root.getLeft() != null && root.getRecord().getX().compareTo(nearestNode.getxMin()) >= 0) {
                    //move to the left
                    nearestNode = new TwoDTree(root.getLeft()).traverseNeighbors(x1, y1, level + 1, nearestNode);
                }
            }
        } else {
            if (root.getRecord().getY().compareTo(y1) >= 0) {
                if (root.getLeft() != null && root.getRecord().getY().compareTo(nearestNode.getyMin()) > 0) {
                    //move to the left
                    nearestNode = new TwoDTree(root.getLeft()).traverseNeighbors(x1, y1, level + 1, nearestNode);
                }
                if (root.getRight() != null && root.getRecord().getY().compareTo(nearestNode.getyMax()) <= 0) {
                    nearestNode = new TwoDTree(root.getRight()).traverseNeighbors(x1, y1, level + 1, nearestNode);
                }
            } else {
                if (root.getRight() != null && root.getRecord().getY().compareTo(nearestNode.getyMax()) < 0) {
                    nearestNode = new TwoDTree(root.getRight()).traverseNeighbors(x1, y1, level + 1, nearestNode);
                }
                if (root.getLeft() != null && root.getRecord().getY().compareTo(nearestNode.getyMin()) >= 0) {
                    //move to the left
                    nearestNode = new TwoDTree(root.getLeft()).traverseNeighbors(x1, y1, level + 1, nearestNode);
                }
            }
        }
        return nearestNode;
    }
    
    /**
     * Helper method to find distance between 2 points
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return BigDecimal : distance between the  points.
     */
    private BigDecimal findDistance(BigDecimal x1, BigDecimal y1, BigDecimal x2, BigDecimal y2) {
        double xDiff = x1.subtract(x2).pow(2).doubleValue();
        double yDiff = y1.subtract(y2).pow(2).doubleValue();
        double result = xDiff + yDiff;
        result = Math.sqrt(result);
        return new BigDecimal(result);
    }

}
