package LinkedListPractice;

public class Link {
    private int iData;
    private int dData;
    private String sData;
    public Link next;

    public Link(int i ,int d, String s ){
        iData = i;
        dData = d;
        sData = s;
    }

    public void displayLink(){
        System.out.print("{ " + iData + ", " + dData + ", " + sData + "} ");
    }
}
