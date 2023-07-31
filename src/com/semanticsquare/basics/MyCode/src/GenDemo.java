class GenDemo{
    public static void main(String[] args) {
        Gen<Integer , String> obj = new Gen<Integer,String>(88,"Hello World");
        obj.ShowTypes();

        int i = obj.ob1;
        System.out.println("Val of Integer object : " + i);
        String str = obj.ob2;
        System.out.println("Val of String object : " + str);
    }
}