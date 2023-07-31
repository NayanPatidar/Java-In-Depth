import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface  About{
    String str() default "An annotation";
    int val() default 0;

}
@Retention(RetentionPolicy.RUNTIME)
@interface Level{
    String itsLevel();
}