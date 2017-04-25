package project2;

import java.math.BigDecimal;

/**
 *This class models the object that will store the result of the nearest neighbor. 
 */
public class Neighbor {

    private BigDecimal distance;        //distance of the neighbor from the query point 
    private TreeNode neighbor;          //points to the tree node of the neighbor
    private int nodesTraversed;         //number of nodes traversed to find the nearest neighbor
    private BigDecimal xMax;            //stores the max possible value of neighbor on the right of the query point
    private BigDecimal xMin;            //stores the min possible value of neighbor on the left of the query point
    private BigDecimal yMax;            //stores the max possible value of neighbor above the query point
    private BigDecimal yMin;            //stores the min possible value of neighbor below the query point
    public static final BigDecimal MAX_LIMIT = new BigDecimal(Double.MAX_VALUE);    //constant to initialize maximum values
    public static final BigDecimal MIN_LIMIT = new BigDecimal(Double.MIN_VALUE);    //constant to initialize minimum values

    public Neighbor() {
        //default constructor
    }

    public Neighbor(BigDecimal distance, TreeNode neighbor) {
        this.distance = distance;
        this.neighbor = neighbor;
        nodesTraversed = 0;
        xMax = MAX_LIMIT;
        yMax = MAX_LIMIT;
        xMin = MIN_LIMIT;
        yMin = MIN_LIMIT;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public TreeNode getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(TreeNode neighbor) {
        this.neighbor = neighbor;
    }

    public int getNodesTraversed() {
        return nodesTraversed;
    }

    public void setNodesTraversed(int nodesTraversed) {
        this.nodesTraversed = nodesTraversed;
    }

    public BigDecimal getxMax() {
        return xMax;
    }

    public void setxMax(BigDecimal xMax) {
        this.xMax = xMax;
    }

    public BigDecimal getxMin() {
        return xMin;
    }

    public void setxMin(BigDecimal xMin) {
        this.xMin = xMin;
    }

    public BigDecimal getyMax() {
        return yMax;
    }

    public void setyMax(BigDecimal yMax) {
        this.yMax = yMax;
    }

    public BigDecimal getyMin() {
        return yMin;
    }

    public void setyMin(BigDecimal yMin) {
        this.yMin = yMin;
    }

}
