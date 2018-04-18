package sd.assignment2.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.assignment2.data.entity.Course;
import sd.assignment2.data.entity.Student;
import sd.assignment2.data.repository.CourseRepository;
import sd.assignment2.data.repository.EnrollmentRepository;
import sd.assignment2.data.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Student viewPersonalInformation(String nameStudent)
    { return studentRepository.getByStudentName(nameStudent); }


    ;public void updateEmail(String nameStudent,String email)
    {
        Student s=studentRepository.getByStudentName(nameStudent);
        s.setEmail(email);
        studentRepository.save(s);
    }

    public void deletePersonalInformation(String nameStudent)
    { studentRepository.delete(studentRepository.getByStudentName(nameStudent)); }

    public List<Course> viewCourses(Student student)
    {
        List<Course> studentCourses=studentRepository.getCourses(student.getStudentName());
        List<Course> allCourses=courseRepository.findAll();
        allCourses.removeAll(studentCourses);
        return allCourses;
    }

    public Student getStudent(String username)
    {
        return studentRepository.getByStudentName(username);
    }
    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }
}
