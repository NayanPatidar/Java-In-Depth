package SortingBasic;

public class InsertionSort {
    private int nElem;
    private int[] arr;


    public InsertionSort(int maxSize){
        arr = new int[maxSize];
        nElem = 0;
    }
    public void display(){
        for (int i = 0 ; i < nElem ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void insert(int value){
        arr[nElem] = value;
        nElem ++;
    }

    public void insertionSort(){
        int  in,out,temp;
        for (out = 1 ; out < nElem ; out++ ){
         temp = arr[out];
         in = out;
            while (in > 0 && arr[in-1] > temp ){
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
    }


    public static void main(String[] args) {
        InsertionSort arr = new InsertionSort(10);
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

        arr.display();

        arr.insertionSort();

        arr.display();

    }
}
