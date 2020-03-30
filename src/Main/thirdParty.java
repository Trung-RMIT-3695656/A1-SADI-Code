package Main;

import List.EnrollmentList;

import java.util.Scanner;

public class thirdParty {
    private Scanner userInput = new Scanner(System.in);
    private EnrollmentList enrollmentList = EnrollmentList.getInstance();

    public void Use() {
        int choice;
        label:
        while (true) {
            try{
                System.out.print("Type 1 enrol student \n" +
                        "Type 2 to show all enrolment\n" +
                        "Type 3 to show an enrolment \n" +
                        "Type 4 to delete enrolment \n" +
                        "Type 5 to show enrolments of a student \n" +
                        "Type 6 to show enrolments in 1 semester \n" +
                        "Type 0 to exit \n" +
                        "Choice:");
                String user_choice = userInput.nextLine();
                choice = Integer.parseInt(user_choice);
                switch (choice) {
                    case 0:
                        break label;
                    case 1:
                        enrollmentList.add();
                        break;
                    case 2:
                        enrollmentList.showAll();
                        break;
                    case 3:
                        enrollmentList.showOne();
                        break;
                    case 4:
                        enrollmentList.delete();
                        break;
                    case 5:
                        enrollmentList.showByStudent();
                        break;
                    case 6:
                        enrollmentList.showBySemester();
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Something wrong please try again");
            }
        }
   }
}

