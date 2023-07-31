package SortingBasic;

public class BubbleSort {
    private int[] arr;
    private int maxSize;


    // Constructor
    public BubbleSort(int maxSize){
        arr = new int[maxSize];
        maxSize = 0;
    }

    //Display
    public void Display(){
        for (int i = 0; i < maxSize ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //Inert
    public void insert(int value){
        arr[maxSize] = value;
        maxSize++;
    }

    //Topics.SelectionSort

    public void BubbleSort(){
        int i, j;
        
        for ( i = maxSize-1 ; i > 0 ; i-- ){
            for (j = 0 ; j < i ; j++){
                if (arr[j] > arr[j+1]){
                    swap( j , j+1);
                }
            }
        }

    }

    //Swap

    public void swap(int one , int two){
        int store = arr[two];
        arr[two] = arr[one];
        arr[one] = store;

    }

    public static void main(String[] args) {
        BubbleSort arr = new BubbleSort(10);


        arr.insert(77); // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(00);
        arr.Display(); // display items
        arr.BubbleSort(); // bubble sort them
        arr.Display();
    }
}
