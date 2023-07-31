public class HighArray {
    private int[] array;
    private int nElem;

    // -------------------------------------------

    //Constructor
    public HighArray(int sizeArray){
        array = new int[sizeArray];
        nElem  = 0;
    }

    //------------------------------------------

    //Find

    public void find(int SearchKey){
        int i = 0;
        for ( i = 0 ; i < array.length ; i++){
            if( array[i] == SearchKey ) {
                break;
            }
        }
        if (array[i] == SearchKey){
            System.out.println("We found SearchKey: " + SearchKey);
        }
        else{
            System.out.println("SearchKey not found!");
        }
    }

    //-----------------------------------

    //Display

    public void display(){
        for (int i = 0 ; i < nElem ; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //--------------------------------------------------

    //Delete

    public void delete(double value){
        int j ;
        for ( j = 0 ; j < nElem; j++){
            if(array[j] == value){
                break;
            }
        }
        if (array[j] == value){
            for (int k = j ; k < nElem ; k++){
                array[k] = array[k + 1];
            }
            nElem--;
        }
        else {
            System.out.println("No such value found!");
        }
    }

    //----------------------------------------------------

    //Insert

    public void insert(int value){
        array[nElem] = value;
        nElem++;
    }

    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr = new HighArray(maxSize);

        arr.insert(11);
        arr.insert(22);
        arr.insert(33);
        arr.insert(44);
        arr.insert(55);
        arr.insert(66);
        arr.insert(77);
        arr.insert(88);

        arr.display();


        arr.delete(55);
        arr.display();
        arr.insert(12);
        arr.display();


    }
}
