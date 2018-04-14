package sd.assignment2.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.assignment2.data.entity.Enrollment;
import sd.assignment2.data.repository.CourseRepository;
import sd.assignment2.data.repository.EnrollmentRepository;
import sd.assignment2.data.repository.StudentRepository;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public int getGrade(String studentName,String courseName)
    { return enrollmentRepository.getGradeByStudentAndCourse(studentRepository.getByStudentName(studentName),courseRepository.getByCourseName(courseName)); }

    public void setGrade(String studentName,String courseName,int grade)
    {
        Enrollment e=enrollmentRepository.getEnrollment(studentRepository.getByStudentName(studentName),courseRepository.getByCourseName(courseName));
        e.setGrade(grade);
        enrollmentRepository.save(e);
    }

    public void createEnrollment(String nameStudent,String nameCourse)
    { enrollmentRepository.save(new Enrollment(studentRepository.getByStudentName(nameStudent),courseRepository.getByCourseName(nameCourse),0)); }

    public void deleteEnrollment(String nameStudent,String nameCourse)
    { enrollmentRepository.delete(enrollmentRepository.getEnrollment(studentRepository.getByStudentName(nameStudent),courseRepository.getByCourseName(nameCourse)));}
}
