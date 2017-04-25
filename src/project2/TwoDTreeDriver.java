/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Raj92
 */
public class TwoDTreeDriver {

    private final TwoDTree twoDObject;
    public static final String FILE_PATH = "CrimeLatLonXY.csv";
    public static final Scanner INPUT = new Scanner(System.in);

    public TwoDTreeDriver() {
        twoDObject = new TwoDTree(FILE_PATH);
    }

    private void handleInOrder() {
        twoDObject.inOrderPrint();
    }

    private void handlePreOrder() {
        twoDObject.preOrderPrint();
    }

    private void handleLevelOrder() {
        twoDObject.levelOrderPrint();
    }

    private void handlePostOrder() {
        twoDObject.postOrderPrint();
    }

    private void handleReverseLevelOrder() {
        twoDObject.reverseLevelOrderPrint();
    }

    private void handleSearchPoints() {
        System.out.println("Enter a rectangle bottom left (X1,Y1) and top right (X2, Y2) as four doubles each separated by a space.");
        String x1 = INPUT.next();
        String y1 = INPUT.next();
        String x2 = INPUT.next();
        String y2 = INPUT.next();
        ListOfCrimes list = twoDObject.findPointsInRange(new BigDecimal(x1), new BigDecimal(y1), new BigDecimal(x2), new BigDecimal(y2));
        System.out.println("Searching for points within " + "(" + x1 + "," + y1 + ")" + " and " + "(" + x2 + "," + y2 + ")");
        System.out.println("Examined " + list.getNodesTraversed() + " nodes during search.");
        System.out.println("Found " + list.getListSize() + " crimes.");
        System.out.println("\n" + list);
        //generate kml file
        KMLUtility.createKMLFile(list.toKML());
        System.out.println("\nThe crime data has been written to PGHCrimes.KML. It is viewable in Google Earth Pro.");
    }

    private void handleNearestNeighbor() {
        System.out.println("Enter a point to find nearest crime. Separate with a space.");
        String x1 = INPUT.next();
        String y1 = INPUT.next();
        Neighbor n = twoDObject.nearestNeighbor(new BigDecimal(x1), new BigDecimal(y1));
        System.out.println("Looked at " + n.getNodesTraversed() + " nodes in tree.");
        System.out.println("Found the nearest crime at: ");
        System.out.println(n.getNeighbor().getRecord());
    }

    public static void main(String args[]) {
        TwoDTreeDriver driver = new TwoDTreeDriver();
        int choice;
        boolean isExit = false;
        while (!isExit) {
            System.out.println("\n\nWhat would you like to do?");
            System.out.println("1: Inorder");
            System.out.println("2: Preorder");
            System.out.println("3: Levelorder");
            System.out.println("4: Postorder");
            System.out.println("5: Reverse Levelorder");
            System.out.println("6: Search for points within rectangle");
            System.out.println("7: Search for nearest neighbor");
            System.out.println("8: Quit");
            choice = INPUT.nextInt();
            switch (choice) {
                case 1:
                    driver.handleInOrder();
                    break;
                case 2:
                    driver.handlePreOrder();
                    break;
                case 3:
                    driver.handleLevelOrder();
                    break;
                case 4:
                    driver.handlePostOrder();
                    break;
                case 5:
                    driver.handleReverseLevelOrder();
                    break;
                case 6:
                    driver.handleSearchPoints();
                    break;
                case 7:
                    driver.handleNearestNeighbor();
                    break;
                case 8:
                    System.out.println("Thank you for exploring Pittsburgh crimes in the 1990’s.");
                    isExit = true;
                    break;
                default:
                    System.out.println("Please enter a valid input (1 to 8)");
            }
        }
    }

}
