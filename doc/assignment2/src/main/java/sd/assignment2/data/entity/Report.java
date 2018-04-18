package sd.assignment2.data.entity;

import java.util.Objects;


public class Report {


    private int id;
    private String nameStudent;
    private String nameCourse;
    private int grade;
    private int exam;

    public Report(int id, String nameStudent, String nameCourse, int grade, int exam) {
        this.id = id;
        this.nameStudent = nameStudent;
        this.nameCourse = nameCourse;
        this.grade = grade;
        this.exam = exam;
    }
    public Report(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return id == report.id &&
                grade == report.grade &&
                exam == report.exam &&
                Objects.equals(nameStudent, report.nameStudent) &&
                Objects.equals(nameCourse, report.nameCourse);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nameStudent, nameCourse, grade, exam);
    }

    @Override
    public String toString() {
        return "Report" +
                "id=" + id +
                ", nameStudent='" + nameStudent+
                ", nameCourse='" + nameCourse +
                ", grade=" + grade +
                ", exam=" + exam
                ;
    }
}
