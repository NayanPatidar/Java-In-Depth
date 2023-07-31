import java.awt.desktop.AppForegroundListener;

enum Apple{
    Jonathan(10), GoldenDel(15), RedDel(12), WinesAp(8) , Cortland(50);

    private int price;
    Apple(int p) {
        this.price = p;
    }

    int getPrice(){
        return price;
    }
}
public class enumDemo1 {
    public static void main(String[] args) {
        Apple ap;

        System.out.println("Price of Jonathan : " +
                Apple.Jonathan.getPrice());

    }
}
