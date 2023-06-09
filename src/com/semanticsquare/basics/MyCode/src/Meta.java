import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@About(str = "An Annotation of Class" , val = 1)
@Level(itsLevel = "Upper")
class Meta {

    @About()
    @Level(itsLevel = "Lower")
    public static void myMethOne()
    {
        Meta obj = new Meta();

        try {
            Method m = obj.getClass().getMethod("myMethOne");
            About anno = m.getAnnotation(About.class);
            System.out.println(anno.val());
            System.out.println(anno.str());


        } catch (NoSuchMethodException e ) {
            System.out.println("Method not found");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        myMethOne();
    }
}