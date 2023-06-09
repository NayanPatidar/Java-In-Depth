package LinkedListPractice;

public class LinkedList {
    private Link firstRef;
    private Link lastRef;


    public LinkedList(){
        firstRef = null;
        lastRef = null;
    }

    public void insertFirst(int i, int d, String s){
        Link obj = new Link(i, d, s);

        if (firstRef == null){
            lastRef = obj;
        }
        obj.next = firstRef;
        firstRef = obj;
    }

    public void insertLast(int i, int d, String s){
        Link obj = new Link(i, d, s);

        if (firstRef == null){
            lastRef = obj;
        }
        else {
            lastRef.next = obj;
            lastRef = obj;
        }
    }

    public void insertAt(int index ,int i, int d, String s ){
        Link obj = new Link(i, d, s);

        if (index == 0){
            firstRef = obj.next;
        }
        else {
            Link n = firstRef;
            for (int m = 0 ; m < index -1 ; m++){
                n = n.next;
            }
            obj.next = n.next;
            n.next = obj;
        }
    }

    public void displayLinkedList(){
        Link current = firstRef;

        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public void deleteLast(){
        Link current = firstRef;
        while (current.next != lastRef){
            current = current.next;
        }
        lastRef = current;
        current.next = null;
    }

    public void deleteFirst(){
        Link current = firstRef;

        firstRef = null;
        firstRef = current.next;

    }

    public void deleteAt(int index){

        Link n = firstRef;
        for (int m = 0 ; m < index -1 ; m++){
            n = n.next;
        }
        n.next = n.next.next;

    }

    public static void main(String[] args) {
        LinkedList  theList = new LinkedList();

        theList.insertFirst(2,22,"Second"); // insert at front
        theList.insertFirst(4,44,"Fourth");
        theList.insertFirst(6,66,"Sixth");
        theList.insertLast(1,11,"First"); // insert at rear
        theList.insertLast(3,33,"Third");
        theList.insertLast(5,55,"Fifth");
        theList.displayLinkedList(); // display the list
        theList.deleteFirst(); // delete first two items
        theList.deleteFirst();

        theList.displayLinkedList(); // display the list

    }
}
