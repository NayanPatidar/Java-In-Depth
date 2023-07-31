package Queues;

public class PriorityQueue {
    private int[] arr;
    private int nElem;
    private int maxSize;

    public PriorityQueue(int max){
        maxSize = max;
        arr = new int[maxSize];
        nElem = 0 ;
    }

    public void enQueue(int value){
        int i;

        if(nElem == 0){
            arr[nElem++] = value;
        }
        else {
            for ( i = nElem - 1; i >= 0; i--) {
                if (value > arr[i]) {
                    arr[i + 1] = arr[i];
                } else {
                    break;
                }
            }
            arr[i + 1] = value;
            nElem++;
        }
    }

    public int deQueue(){
        return arr[--nElem];
    }

    public void show(){
        for (int i = 0 ; i < nElem ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue obj = new PriorityQueue(5);

        obj.enQueue(30);
        obj.enQueue(20);
        obj.enQueue(10);
        obj.enQueue(50);
        obj.enQueue(40);

        obj.show();

        obj.deQueue();
        obj.deQueue();
        obj.deQueue();

        obj.show();
    }
}
