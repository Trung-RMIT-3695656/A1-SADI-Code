package Information;

public class Course {
    private String courseId;
    private String name;
    private int numberOfCredit;

    private static Course course;

    public Course(String courseId, String name, int numberOfCredit) {
        this.courseId = courseId;
        this.name = name;
        this.numberOfCredit = numberOfCredit;
    }

    public static Course getInstance(String id, String name, int numberOfCredit) {
        if (null == course) {
            course = new Course(id, name, numberOfCredit);
        }
        return course;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCredit() {
        return numberOfCredit;
    }

    public void setNumberOfCredit(int numberOfCredit) {
        this.numberOfCredit = numberOfCredit;
    }
}
