package Stack;

public class StackX {
    private int maxSize;
    private char[] arr;
    private  int top;


    // Constructor
    public StackX(int max){
        maxSize = max;
        arr = new char[max];
        top = -1;
    }

    // Push
    public void push(char value){
        arr[++top] = value;
    }

    // Pop
    public char pop(){
        return arr[top--];
    }

    // Peek
    public char peek(){
        return arr[top];
    }

    public boolean isFull(){
        boolean isFull = false;
        if (maxSize-1 == top){
            isFull = true;
        }
       return isFull;
    }

    public boolean isEmpty(){

      return (top == -1);
    }
}
