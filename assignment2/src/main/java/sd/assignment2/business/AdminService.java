package sd.assignment2.business;


import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.assignment2.data.entity.Course;
import sd.assignment2.data.entity.Enrollment;
import sd.assignment2.data.repository.AdminRepository;
import sd.assignment2.data.repository.StudentRepository;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EnrollmentService enrollmentService;


    /*public void generateReport(String nameStudent)
    {}*/

    public void deleteEnrollment(String nameStudent,String courseName,int grade)
    { enrollmentService.deleteEnrollment(nameStudent,courseName);}

    public void setGrade(String studentName,String courseName,int grade)
    { enrollmentService.setGrade(studentName,courseName,grade);}

    public List<Course> viewEnrollments(String nameStudent)
    { return studentService.viewCourses(nameStudent);}

}
