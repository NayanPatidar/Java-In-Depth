package in.com.StudentUtil;

public class MissingGradeException extends Throwable {
     public int studentId ;
    public MissingGradeException(int i) {
        this.studentId = i;
        System.out.println("Id: " + studentId);
    }
    public int getStudentId() {
        return studentId;
    }
}
