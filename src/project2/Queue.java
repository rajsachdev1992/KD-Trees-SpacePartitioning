package project2;

/**
 * This class models a Queue which can hold nodes of the Two d tree.
 */
public class Queue {

    private ListNode front;
    private ListNode rear;
    private int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }
    
    /**
     * Inserts 2D tree nodes at the back the queue.
     * @param treeRecord 
     * Complexity: Theta(1)
     * Precondition: treeRecord should not be null.
     * PostCondition: The treeRecord will be inserted in the back of the Queue.
     */
    public void insert(TreeNode treeRecord) {
        ListNode tmp = new ListNode(treeRecord, null);
        if (isEmpty()) {
            front = tmp;
            rear = tmp;
        } else {
            rear.setNext(tmp);
            rear = tmp;
        }
        size++;
    }
    
    
    /**
     * Removes and returns the Node at the front of the queue.
     * @return TreeNode
     * Complexity: Theta(1)
     * PreCondition: The queue should have at least one element.
     * PostCondition: The element at the front of the queue will be deleted and returned.
     */
    public TreeNode remove() {
        if (isEmpty()) {
            throw new NullPointerException("Queue is empty");
        }
        TreeNode node = front.getTreeNode();
        front = front.getNext();
        size--;
        return node;
    }
    
    /**
     * Returns the element at the front of the queue without deleting it.
     * @return TreeNode
     * Complexity: Theta(1)
     * PreCondition: Queue should not be empty
     * PostCondition: The element at the front of the queue will be returned.
     */
    public TreeNode peek() {
        if (front == null) {
            throw new NullPointerException("Queue is empty");
        }
        return front.getTreeNode();
    }
    
    /**
     * Checks if the queue is empty.
     * @return Boolean
     * Complexity: Theta(1)
     */
    public boolean isEmpty() {
        //System.out.println(size);
        return (size == 0);
    }
}
