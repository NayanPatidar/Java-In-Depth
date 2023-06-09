public class Box4 {
    public static void main(String[] args) {
        Box boxOne = new Box(10,10,10);
        Box boxTwo = new Box(20,20);

/*        System.out.println(boxOne.volume());
        System.out.println(boxTwo.volume());*/


    }

    public static int box1(){
        int i = 0 ;
        for (int j = 0 ; j < 5 ; j++){
            i=j;
            System.out.println(i);
        }
        return i;
    }

    public void  box2(){
         box1();
    }
}
