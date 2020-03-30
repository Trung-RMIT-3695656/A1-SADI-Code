package Enrollment;

import Information.Enrollment;

import java.util.ArrayList;

public interface EnrollmentManager {
    void add();

    void update();

    Enrollment getOne(Enrollment userInput);

    ArrayList<Enrollment> getAll();

}
