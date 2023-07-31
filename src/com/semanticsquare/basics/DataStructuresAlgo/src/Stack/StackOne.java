package Stack;

public class StackOne {
    private int maxSize;
    private int[] arr;
    private  int top;


    // Constructor
    public StackOne(int max){
        maxSize = max;
        arr = new int[max];
        top = -1;
    }

    // Push
    public void push(int value){
        arr[++top] = value;
    }

    // Pop
    public int pop(){
        return arr[top--];
    }

    // Peek
    public int peek(){
        return arr[top];
    }

    public void isFull(){
        if (maxSize-1 == top){
            System.out.println("Stack is Full");
        }
        else {
            System.out.println("Stack is not full");
        }
    }

    public void isEmpty(){
        if (top == -1){
            System.out.println("Stack is Empty");
        }
        else {
            System.out.println("Stack is not Empty");
        }
    }


    public static void main(String[] args) {
        StackOne obj = new StackOne(5);

        obj.isFull();

        obj.push(5);
        obj.push(4);
        obj.push(3);
        obj.push(2);
        obj.push(1);

        obj.isEmpty();
        obj.isFull();

        System.out.println(obj.pop());
        System.out.println(obj.peek());
    }
 }
