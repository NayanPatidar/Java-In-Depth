package in.com.StudentUtil;

public class DemoMain
{
    public int studentId = 0;

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }
    public static void main(String[] args) throws Throwable {
        int[] studentIdList = new int[] {1001,1002,1003};
        char[][] studentsGrades = new char[][]{ { 'A', 'A', 'A', 'C' },{'A', 'C', 'B'},{' ', 'B', 'C'} };

        StudentUtil.getStudentsByGPA(3.6, 3.7, studentIdList,studentsGrades);

        DemoMain obj = new DemoMain();

        obj.setStudentId(5);
        System.out.println(obj.getStudentId());



    }
}
