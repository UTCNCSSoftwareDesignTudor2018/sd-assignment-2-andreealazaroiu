package sd.assignment2.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sd.assignment2.business.AdminService;
import sd.assignment2.business.EnrollmentService;
import sd.assignment2.business.StudentService;
import sd.assignment2.data.entity.Admin;
import sd.assignment2.data.entity.Course;
import sd.assignment2.data.entity.Enrollment;
import sd.assignment2.data.entity.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class AdminController {

    private ModelAndView mv;

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EnrollmentService  enrollmentService;

    @GetMapping("AdminPage")
    public ModelAndView putCourses()
    {
        mv=new ModelAndView("AdminPage");
        List<Course> courses=new ArrayList<Course>();
        courses=adminService.getCourses();
        List<Student> students=new ArrayList<Student>();
        students=studentService.getStudents();
        mv.addObject("courses",courses);
        mv.addObject("students",students);

        return mv;
    }

    @PostMapping(value= "AdminPage",params="addCourse")
    public String addCourse(@RequestParam("enterCourseName")String courseName,@RequestParam("dateExam")String dateExam)
    {
        Optional<Admin> a=adminService.getAdmin();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date=LocalDate.parse(dateExam, formatter);
        System.out.println(courseName);
        int id=adminService.getIDCourse();
        Course c=new Course(id,courseName,date,a.get());

        adminService.addCourse(c);
        return "redirect:AdminPage";
    }
    @PostMapping(value="AdminPage",params="viewStudent")
    public ModelAndView viewStudent(@RequestParam("putStudentName")String studentName)
    {
        Student student=studentService.getStudent(studentName);
        String viewStudent=student.toString();
        mv.addObject("viewStudent",viewStudent);
        List<Enrollment> enrollments=new ArrayList<Enrollment>();
        enrollments=enrollmentService.getEnrollments(student);
        mv.addObject("enrollments",enrollments);

        return mv;
    }

    @PostMapping(value="AdminPage",params="gradeStudent")
    public ModelAndView grade(@RequestParam("putStudentName")String studentName,@RequestParam("courseName")String courseName,@RequestParam("enterGrade")String enterGrade)
    {
        //Student student=studentService.getStudent(studentName);
        int grade=Integer.parseInt(enterGrade);
        System.out.println(courseName);
        adminService.setGrade(studentName,courseName,grade);
        return mv;
    }
}
