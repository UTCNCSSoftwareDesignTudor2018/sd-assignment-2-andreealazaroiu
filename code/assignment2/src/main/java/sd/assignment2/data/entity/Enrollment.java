package sd.assignment2.data.entity;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollmentId;

    @ManyToOne()
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne()
    @JoinColumn(name="course_id")
    private Course course;

    @Column(name="grade")
    private int grade;


    public Enrollment(){}

    public Enrollment(Student students, Course courses, int grade) {
        this.student = students;
        this.course = courses;
        this.grade = grade;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudents(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourses(Course course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return enrollmentId == that.enrollmentId &&
                grade == that.grade &&
                Objects.equals(student, that.student) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {

        return Objects.hash(enrollmentId, student, course, grade);
    }

    @Override
    public String toString() {
        return "Enrollment " +
                "enrollmentId=" + enrollmentId +
                //", students=" + student +
                ", courses=" + course +
                ", grade=" + grade
                ;
    }
}
