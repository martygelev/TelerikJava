package exe.demo.models;

public class Course {
    private String course;
    private int credits;
    private String fieldOfStudy;

    public Course(String course, int credits, String fieldOfStudy) {
        this.course = course;
        this.credits = credits;
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }
}
