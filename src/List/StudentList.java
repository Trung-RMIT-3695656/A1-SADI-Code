package List;

import Information.Student;

import java.util.Scanner;

public class StudentList {
    private Scanner userInput = new Scanner(System.in);
    private static StudentList StudentList;

    public static StudentList getInstance() {
        if (StudentList == null)
            StudentList = new StudentList();

        return StudentList;
    }

    public Student userInput() {
        System.out.print("Type student id:");
        String studentId = userInput.nextLine();
        System.out.print("Type student name:");
        String studentName = userInput.nextLine();
        System.out.print("Type student birthday:");
        String studentBirthday = userInput.nextLine();
        return new Student(studentId, studentName, studentBirthday);
    }
}
