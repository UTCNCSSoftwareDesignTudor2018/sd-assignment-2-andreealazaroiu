package sd.assignment2.data.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name="courses")
public class Course
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column(name="course_name")
    private String courseName;

    @Column(name="date_exam",columnDefinition = "DATE")
    private LocalDate dateExam;

    @ManyToOne(targetEntity = Admin.class)
    @JoinColumn(name="admin_id")
    private Admin admin;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;


    public Course(int courseId, String courseName, LocalDate dateExam, Admin a) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.dateExam = dateExam;
        this.admin=a;
        this.students=new ArrayList<Student>();
    }

    public Course( String courseName, LocalDate dateExam,Admin admin) {
    }
    public Course(){}


    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getDateExam() {
        return dateExam;
    }

    public void setDateExam(LocalDate dateExam) {
        this.dateExam = dateExam;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Student> getStudents() {
        return students; }

    public void setStudents(List<Student> students) {
        this.students = students; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId == course.courseId &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(dateExam, course.dateExam) &&
                Objects.equals(admin, course.admin);
    }

    @Override
    public int hashCode() {

        return Objects.hash(courseId, courseName, dateExam, admin);
    }

    @Override
    public String toString() {
        return "Course " +
                "courseId=" + courseId +
                " ,courseName='" + courseName +
                ", dateExam=" + dateExam +
                ", grade="  +
                ", admin=" + admin
                ;
    }

    @Converter(autoApply = true)
    public static  class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

        @Override
        public Date convertToDatabaseColumn(LocalDate locDate) {
            return (locDate == null ? null : Date.valueOf(locDate));
        }

        @Override
        public LocalDate convertToEntityAttribute(Date sqlDate) {
            return (sqlDate == null ? null : sqlDate.toLocalDate());
        }
    }

}
