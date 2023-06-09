package Queues;

public class CircularQueues {
    private int[] arr;
    private int nElem;
    private int rear;
    private int front;
    private int maxSize;

    public CircularQueues(int max){
        maxSize = max;
        arr = new int[maxSize];
        rear = -1;
        front = 0;
        nElem = 0;
    }

    public void enQueue(int value){
        if (rear == maxSize-1){
            rear = -1;
        }
        rear = rear + 1;
        arr[rear] = value;
        nElem++;
    }

    public int deQueue(){
        int data = arr[front];
        front++;
        nElem--;
        if (front == maxSize){
            front = 0;
        }
        return data;
    }

    public int peek(){
        return arr[front];
    }

    public static void main(String[] args) {
        CircularQueues obj = new CircularQueues(5);
        obj.enQueue(1);
        obj.enQueue(2);
        obj.enQueue(3);
        obj.enQueue(4);
        obj.enQueue(5);
        System.out.println(obj.peek());

        obj.deQueue();
        obj.deQueue();
        obj.deQueue();
        System.out.println(obj.peek());

        obj.enQueue(6);
        obj.enQueue(7);
        obj.enQueue(8);
        System.out.println(obj.peek());

        obj.deQueue();
        obj.deQueue();
        System.out.println(obj.peek());
    }
}
