import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@About(str = "This annotation is for class AnnoDemo" , value = 1)
public class AnnoDemo {

    @About(str = "This annotation is for method MethodOne ", value = 2)
    public void MethodOne(){
        //Blank
    }

    public static void main(String[] args) {
        AnnoDemo obj = new AnnoDemo();

        Annotation[] annotation = obj.getClass().getAnnotations();
        for (Annotation anno : annotation){
            System.out.println(anno);
        }
    }
}