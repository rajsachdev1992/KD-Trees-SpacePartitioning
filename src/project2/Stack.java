package project2;

/**
 * This class models a stack to hold 2D TreeNodes.
 */
public class Stack {

    private ListNode front;
    int size;

    public Stack() {
        front = null;
        size = 0;
    }
    
    /**
     * Pushes an element on the top of the stack
     * @param treeNode 
     * Complexity: Theta(1)
     * Precondition: treeNode should not be null.
     * Postcondition: The treeNode will be inserted on top of the stack.
     */
    public void push(TreeNode treeNode) {
        ListNode tmp = new ListNode();
        tmp.setTreeNode(treeNode);
        if (isEmpty()) {
            tmp.setNext(null);
        } else {
            tmp.setNext(front);
        }
        front = tmp;
        size++;
    }
    
    /**
     * Deletes and returns the element from the top of the stack.
     * @return TreeNode
     * Complexity: Theta(1)
     * Precondition: The stack should not be empty.
     * Postcondition: Deletes and returns the element from the top of the stack.
     */
    public TreeNode pop() {
        if (isEmpty()) {
            throw new NullPointerException("The stack is empty.");
        }
        TreeNode poppedNode = front.getTreeNode();
        front = front.getNext();
        size--;
        return poppedNode;
    }
    
    /**
     * Returns the element from the top of the stack.
     * @return TreeNode
     * Complexity: Theta(1)
     * Precondition: The stack should not be empty.
     * Postcondition: Returns the element from the top of the stack.
     */
    public TreeNode peek() {
        if (isEmpty()) {
            throw new NullPointerException("The stack is empty.");
        }
        return front.getTreeNode();
    }
    
    /**
     * Checks if the stack is empty.
     * @return Boolean
     * Complexity: Theta(1)
     */
    public boolean isEmpty() {
        return (size == 0);
    }
}
