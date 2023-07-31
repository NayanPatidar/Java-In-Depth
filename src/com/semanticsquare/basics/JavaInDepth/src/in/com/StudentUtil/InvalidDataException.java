package in.com.StudentUtil;

public class InvalidDataException extends Throwable {
    public InvalidDataException(MissingGradeException e) {
        System.out.println("Here in IDE");
    }
}
