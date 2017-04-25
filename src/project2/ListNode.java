/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 * This class defines a node for the linked list used to model the Stack and Queue classes.
 */
public class ListNode {

    private TreeNode treeNode;      //2D tree node to be inserted into the stack or queue
    private ListNode next;          //link to the next node

    public ListNode() {
        //default constructor
    }

    public ListNode(TreeNode treeNode, ListNode next) {
        this.treeNode = treeNode;
        this.next = next;
    }

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}
