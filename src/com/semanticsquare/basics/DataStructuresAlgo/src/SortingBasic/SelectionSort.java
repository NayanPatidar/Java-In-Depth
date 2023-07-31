package SortingBasic;

public class SelectionSort {

    private int[] arr;
    private int maxSize;


    // Constructor
    public SelectionSort(int maxSize){
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

    //Insert
    public void insert(int value){
        arr[maxSize] = value;
        maxSize++;
    }

    //Topics.SelectionSort

    public void SelectSort(){
        int i, j, min ;
        for (i = 0 ; i < maxSize ; i++){
            min = i;
            for (j = i ; j < maxSize ; j++){
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            swap(i , min);
        }
    }

    //Swap
    public void swap(int min , int org){
        int store = arr[org];
        arr[org] = arr[min];
        arr[min] = store;

    }

    public static void main(String[] args) {
        SelectionSort obj = new SelectionSort(10);

        obj.insert(77); // insert 10 items
        obj.insert(99);
        obj.insert(44);
        obj.insert(55);
        obj.insert(22);
        obj.insert(88);
        obj.insert(11);
        obj.insert(00);
        obj.insert(66);
        obj.insert(33);
        obj.Display(); // display items
        obj.SelectSort(); // selection-sort them
        obj.Display();
    }
}




