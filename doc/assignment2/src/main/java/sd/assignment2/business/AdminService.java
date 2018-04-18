package sd.assignment2.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.assignment2.data.entity.Admin;
import sd.assignment2.data.entity.Course;
import sd.assignment2.data.repository.AdminRepository;
import sd.assignment2.data.repository.CourseRepository;
import sd.assignment2.data.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private CourseRepository courseRepository;


    /*public void generateReport(String nameStudent)
    {}*/

    public void deleteEnrollment(String nameStudent,String courseName,int grade)
    { enrollmentService.deleteEnrollment(nameStudent,courseName);}

    public void setGrade(String studentName,String courseName,int grade)
    { enrollmentService.setGrade(studentName,courseName,grade);}

    public List<Course> getCourses()
    {
        return courseRepository.findAll();
    }
    public Optional<Admin> getAdmin()
    {
        return adminRepository.findById(1);
    }
    public void addCourse(Course course)
    {
        courseRepository.save(course);
    }
    public int getIDCourse()
    {
       List<Course> c= new ArrayList<Course>();
       c=courseRepository.findAll();
       return c.size()+1;

    }
}
