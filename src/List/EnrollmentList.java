package List;

import Enrollment.EnrollmentManager;
import Information.Course;
import Information.Enrollment;
import Information.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class EnrollmentList implements EnrollmentManager {
    private Scanner userInput = new Scanner(System.in);
    private static EnrollmentList enrolmentList;
    private StudentList students = StudentList.getInstance();
    private CourseList courses = CourseList.getInstance();
    private ArrayList<Enrollment> enrolments = new ArrayList<>();

    public static EnrollmentList getInstance() {
        if (enrolmentList == null) {
            enrolmentList = new EnrollmentList();
        }
        return enrolmentList;
    }

    public void add() {
        Enrollment enrollment = userInputEnrollment();
        try {
            enrolments.add(enrollment);
            System.out.println("Added successfully!!");
        }
        catch(Exception e){
            System.out.println("Something wrong");
        }
    }

    public void update() {

    }

    public Enrollment getOne(Enrollment userInput) {
        for (Enrollment enrolment : enrolments) {
            if (userInput == enrolment) {
                return enrolment;
            }
        }
        return null;
    }

    public ArrayList<Enrollment> getAll() {
        return enrolments;
    }

    public Boolean isExistStudent(Student student){
        for (Enrollment enrolment : enrolments) {
            if (enrolment.getStudent() == student) {
                return true;
            }
        }
        return false;
    }

    public void delete() {
        Enrollment userInput = userInputEnrollment();
        enrolments.remove(userInput);
    }

    public Enrollment userInputEnrollment() {
        Student student = students.userInput();
        Course course = courses.userInput();
        System.out.print("Semester:");
        String semester = userInput.nextLine();
        return new Enrollment(student, course, semester);
    }

    public void showAll() {
        for (int i = 0; i < getAll().size(); i++) {
            if (enrolments.isEmpty()){
                System.out.println("There is no enrolment, cannot display !!");
            }
            else {
                System.out.println("Enrolment " + i + ": \n"
                        + "Student name:" + enrolments.get(i).getStudentName() + "\n"
                        + "Course:" + enrolments.get(i).getCourseName() + "\n"
                        + "Semester:" + enrolments.get(i).getSemester());
            }
        }
    }

    public void showOne() {
        Enrollment userInput = userInputEnrollment();
        if (getOne(userInput) != null) {
            System.out.println("Enrolment information: \n"
                    + "Student ID:" + userInput.getStudentID() + "\n"
                    + "Student name:" + userInput.getStudent().getName() + "\n"
                    + "Course ID" + userInput.getCourseID() + "\n"
                    + "Course name:" + userInput.getCourse().getName());
        }
    }

    public void showEnrolmentByStudent(Student student){
        System.out.println("The course list:");
        for (Enrollment enrolment : enrolments) {
            if (student == enrolment.getStudent()){
                System.out.println("ID:"+ enrolment.getCourseID() +"\n"
                        + " Name:" + enrolment.getCourseName() +"\n"
                        + " Number of credit:" + enrolment.getCourse().getNumberOfCredit() +"\n"
                        + " Semester:" +enrolment.getSemester());
            }
        }
    }

    public void showByStudent() {
        System.out.println("Please type student information to check:");
        Student student = students.userInput();
        if (!isExistStudent(student)) {
            System.out.println("Cannot find this student!!");
        }
        else {
            showEnrolmentByStudent(student);
        }
    }

    public void showBySemester(){
        System.out.print("Semester you want to find");
        String inputSemester = userInput.nextLine();
        for (Enrollment enrolment : enrolments) {
            if (inputSemester.equals(enrolment.getSemester())) {
                System.out.println("Enrolment information in" + inputSemester +"semester" + ":\n" +
                        "StudentID:" + enrolment.getStudentID() + "\n" +
                        "CourseID:" + enrolment.getCourseID());
            }
        }
    }
}
