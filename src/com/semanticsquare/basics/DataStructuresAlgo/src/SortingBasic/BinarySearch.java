package SortingBasic;

public class BinarySearch {
    private int[] array;
    private int nElements;

    //-------------------------------------------------------

    //Constructor
    public BinarySearch(int sizeArray){
        array = new int[sizeArray];
        nElements  = 0;
    }

    //-----------------------------------

    //Display
    public void display(){
        for (int i = 0 ; i < nElements ; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int size(){
        return nElements;
    }

    public void find(double searchKey){
        int upperBand = nElements - 1;
        int lowerBand = 0;
        int curIn;
        boolean isPresent = false;

        do{
            curIn = (lowerBand + upperBand) / 2;
            if (array[curIn] == searchKey){
                System.out.println("We found the searchKey: " + searchKey);
                isPresent = true;

            }
            else if (lowerBand > upperBand){
                System.out.println("Key Not Found!");
                break;
            }
            else {
                if (array[curIn] < searchKey){
                    lowerBand = curIn + 1;
                }
                else if (array[curIn] > searchKey){
                    upperBand = curIn -1;
                }
            }
        }while (!isPresent);
    }


    public void delete(int value ){
        int i ;
        for ( i = 0 ; i < nElements ; i++){
            if (array[i] == value){
                break;
            }
        }

        for (int j = i ; j < nElements ; j++ ){
            array[j] = array[j+1];
        }
        nElements--;
    }

    public void insert(int value){
        int k ;
        for ( k = 0 ; k  < nElements ; k++){
            if (array[k] > value){
                break;
            }
        }
        for (int j = nElements ; j > k ; j--){
            array[j] = array[j-1];
        }
        array[k]= value;
        nElements++;
    }

    public static void main(String[] args) {
        BinarySearch arr = new BinarySearch(10);
        arr.insert(92);
        arr.insert(83);
        arr.insert(71);
        arr.insert(6);
        arr.insert(57);
        arr.insert(3);


        arr.display();

        arr.delete(6);
        arr.delete(83);


        arr.find(92);


        arr.display();

    }

    }


