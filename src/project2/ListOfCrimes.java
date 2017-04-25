package project2;

/**
 * This class is used to define the linked list which stores crime records.
 * It provides methods to add and retrieve crime records from the list.
 */
public class ListOfCrimes {

    private CrimeListNode head;     //head of the list
    private int listSize;           //number of records in the list
    private int nodesTraversed;     //number of nodes traveresed in the 2D trees to generate te final list of crimes.

    public ListOfCrimes() {
        head = null;
        listSize = 0;
        nodesTraversed = 0;
    }
    
    /**
     * Adds a crime record to the list.
     * @param crime 
     * Complexity: Theta(n)
     * Pre-Condition: crime record should not be null.
     * Post-Condition: crime record is added at the end of list.
     */
    public void addCrime(CrimeRecord crime) {
        CrimeListNode tmp = new CrimeListNode(crime, null);
        if (head == null) {
            head = tmp;
        } else {
            CrimeListNode cur = head;
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            cur.setNext(tmp);
        }
        listSize++;
    }

    /**
     * @param index
     * @return CrimeRecord at index i
     * Complexity: Theta(n)
     * Precondition: index should be within the bounds of the list size.
     * Post-Condition: The crime record at index i will be returned.
     */
    public CrimeRecord getCrime(int index) {
        if (index >= listSize) {
            //TODO: Index out of bounds
            throw new IndexOutOfBoundsException("Index out of bound: " + index);
        }
        CrimeListNode cur = head;
        for (int i = 0; i < listSize - 1; i++) {
            cur = cur.getNext();
        }
        return cur.getRecord();
    }
    
    /**
     * Returns the list of crimes as a string.
     * @return String
     * Complexity: Theta(n)
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        CrimeListNode cur = head;
        while (cur != null) {
            s.append(cur.getRecord());
            s.append("\n");
            cur = cur.getNext();
        }
        return s.toString();
    }
    
    /**
     * Returns the list of crimes as the content of a KML file.
     * @return String : content of the KML file
     * Complexity: Theta(n)
     */
    public String toKML() {
        return KMLUtility.createKMLContent(this);
    }

    public int getNodesTraversed() {
        return nodesTraversed;
    }

    public void setNodesTraversed(int nodesTraversed) {
        this.nodesTraversed = nodesTraversed;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }

    public CrimeListNode getHead() {
        return head;
    }
}
