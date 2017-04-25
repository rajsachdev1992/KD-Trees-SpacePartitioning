/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 * This class models the node of a 2D tree.
 */
public class TreeNode {

    private CrimeRecord record;
    private TreeNode right;
    private TreeNode left;

    public TreeNode() {
        //default constructor
    }

    public TreeNode(CrimeRecord record, TreeNode right, TreeNode left) {
        this.record = record;
        this.right = right;
        this.left = left;
    }

    public CrimeRecord getRecord() {
        return record;
    }

    public void setRecord(CrimeRecord record) {
        this.record = record;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

}
