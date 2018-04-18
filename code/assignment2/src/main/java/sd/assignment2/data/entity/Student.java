package sd.assignment2.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId=0;

    @Column(name="student_name")
    private String studentName="";

    @Column(name="pnc")
    private int pnc=0;

    @Column(name="card_number")
    private int cardNumber=0;

    @Column(name="groupp")
    private int group=0;
    //optional
    @Column(name="email")
    private String email="";

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(
            name="enrollments",
            joinColumns = {@JoinColumn(name="student_id")},
            inverseJoinColumns={@JoinColumn(name="course_id")})
    private List<Course> courses;


    public Student(StudentBuilder studentBuilder)
    {
        this.studentId=studentBuilder.studentId;
        this.studentName=studentBuilder.studentName;
        this.cardNumber=studentBuilder.cardNumber;
        this.pnc=studentBuilder.pnc;
        this.group=studentBuilder.group;
        this.email=studentBuilder.email;
        this.courses=new ArrayList<Course>();
    }

    public Student()
    { }

    public int getStudentId() {
        return studentId; }

    public String getStudentName() {
        return studentName; }

    public int getPnc() {
        return pnc; }

    public int getCardNumber() {
        return cardNumber; }

    public int getGroup() {
        return group; }

    public List<Course> getCourses() {
        return courses;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {

        return this.email; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId &&
                pnc == student.pnc &&
                cardNumber == student.cardNumber &&
                group == student.group &&
                Objects.equals(studentName, student.studentName) &&
                Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(studentId, studentName, pnc, cardNumber, group, email);
    }

    @Override
    public String toString() {
        return "Student " +
                "studentId=" + studentId +
                ", studentName='" + studentName +
                ", pnc=" + pnc +
                ", cardNumber=" + cardNumber +
                ", group=" + group +
                ", email=" + email ;

    }

    public static class StudentBuilder
    {
        private int studentId;
        private String studentName;
        private int pnc;
        private int cardNumber;
        private int group;
        //optional
        private String email;

       public StudentBuilder setStudentId(int studentId)
       { this.studentId=studentId; return this;}

        public StudentBuilder setStudentName(String studentName)
        { this.studentName=studentName; return this;}

        public StudentBuilder setCardNumber(int cardNumber)
        { this.cardNumber=cardNumber; return this;}

        public StudentBuilder setPnc(int pnc)
        { this.pnc=pnc; return this;}

        public StudentBuilder setGroup(int group)
        { this.group=group; return this;}

        public StudentBuilder setEmail(String email)
        { this.email=email; return this;}

        public Student build()
        {
            return new Student(this);
        }
    }





}