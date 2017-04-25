package project2;

/**
 *This class defines the node for the linked list of type ListOfNodes.
 */
public class CrimeListNode {

    private CrimeRecord record; //stores all the info of a crime
    private CrimeListNode next; //stores the next node

    public CrimeListNode() {
        //default constructor
    }

    public CrimeListNode(CrimeRecord record, CrimeListNode next) {
        this.record = record;
        this.next = next;
    }

    public CrimeRecord getRecord() {
        return record;
    }

    public void setRecord(CrimeRecord record) {
        this.record = record;
    }

    public CrimeListNode getNext() {
        return next;
    }

    public void setNext(CrimeListNode next) {
        this.next = next;
    }
}
