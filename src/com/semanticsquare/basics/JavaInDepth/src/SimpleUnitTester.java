import java.lang.reflect.Method;

public class SimpleUnitTester {
    public int execute(Class clazz) throws Exception {
        int failedCount = 0;

        Object object = null;
        try {
            object = clazz.newInstance(); // MUST HAVE DEFAULT CONSTRUCTOR
        } catch(InstantiationException e) {
            System.out.println("Can't instantiate ...");
        } catch (IllegalAccessException e) {
            System.out.println("Can't access ...");
        }

        for (Method m : clazz.getDeclaredMethods()) {
            if (m.getName().startsWith("test")){
                Object val = m.invoke(object);
                if (m.invoke(object).equals(false)){
                    failedCount++;
                }
            }
        }
        return failedCount;
    }

    public static void main(String[] args) throws Exception {
        SimpleUnitTester obj = new SimpleUnitTester();
        System.out.println(obj.execute(Reflection.class));
    }
}
