package LinkedList;

public class LinkedList {
    private Link firstRef;
    private Link lastRef;

    public LinkedList(){
        firstRef = null;
        lastRef = null;
    }

    public boolean isEmpty(){
        boolean isEmpty = false;
        if (firstRef == null){
            isEmpty = true;
        }
        return isEmpty;
    }

    public void insertFirst(int id){
        Link newLink = new Link(id);

        if (firstRef == null){
            lastRef = newLink;
        }
        newLink.next = firstRef;
        firstRef = newLink;

    }

    public void insertLast (int id){
        Link newLink = new Link(id);

        if (firstRef == null){
            firstRef = newLink;
        }
        else {
            lastRef.next = newLink;
            lastRef = newLink;
        }
    }

    public void insertAt(int ref , int data){
        Link obj = new Link(data);

        Link n = firstRef;
        for (int i = 0 ; i < ref-1 ; i++){
            n = n.next;
        }
        obj.next = n.next;
        n.next = obj;
    }

    public void displayList(){
        System.out.println("List (first --> last): ");
        Link current = firstRef;

        while ( current != null ){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public void delete(int index){

        if (index == 0){
            firstRef = firstRef.next;
        }
        else {
            Link n = firstRef;
            for (int i = 0 ; i < index-1 ; i++){
                n = n.next;
            }
            n.next = n.next.next;
        }
    }

    public boolean find(int key){
        Link current = firstRef;
        boolean present = false;

        while (current.iData != key){
            if (current.next == null){
                present = false;
                break;
            }
            else {
                current = current.next;
            }
        }
        if (current.iData == key){
            present = true;
        }
        return present;
    }

    public static void main(String[] args) {
        LinkedList obj = new LinkedList();

        obj.insertFirst(33);
        obj.insertFirst(22);
        obj.insertFirst(11);

        obj.displayList();

        obj.insertLast(55); // insert at rear
        obj.insertLast(66);
        obj.insertLast(77);

        obj.displayList();

        obj.insertAt(3,44);

        obj.displayList();

        obj.delete(3);

        obj.displayList();

    }
}
