package sd.assignment2.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sd.assignment2.business.EnrollmentService;
import sd.assignment2.business.StudentService;
import sd.assignment2.data.entity.Course;
import sd.assignment2.data.entity.Enrollment;
import sd.assignment2.data.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentEnterNameController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private EnrollmentService enrollmentService;

    private ModelAndView mv;

    @GetMapping("StudentPage")
    public ModelAndView getActualStudent(@RequestParam("username") String username)
    {
        Student student=studentService.getStudent(username);
        mv=new ModelAndView("StudentPage");
        mv.addObject("student",student);
        List<Course> courses=studentService.viewCourses(student);
        mv.addObject("courses",courses);
        return mv;

    }

    @PostMapping(value="StudentPage",params="buttonChangeEmail")
    public String changeEmail(@RequestParam("changeEmail")String changeEmail,
                                    RedirectAttributes attributes) {
        Student s=(Student)mv.getModel().get("student");
        studentService.updateEmail(s.getStudentName(),changeEmail);
        attributes.addAttribute("username",s.getStudentName());
        return "redirect:StudentPage";
    }

    @PostMapping(value="StudentPage",params="buttonView")
    public ModelAndView viewEnrollments()
    {
        List<Enrollment> e = enrollmentService.getEnrollments((Student)mv.getModel().get("student"));
        mv.addObject("enrollments", e);

        return mv;
    }

    @PostMapping(value="StudentPage",params="deleteEnrollment")
    public ModelAndView deleteEnrollment(@RequestParam("nameCourse") String nameCourse)
    {
       Student stud=(Student)mv.getModel().get("student");
        System.out.println(stud.getStudentName()+""+nameCourse);
        enrollmentService.deleteEnrollment(stud.getStudentName(), nameCourse);
        return mv;
    }
    @PostMapping(value="StudentPage",params="enroll")
    public ModelAndView enroll(@RequestParam("nameCourse") String nameCourse)
    {
        Student stud=(Student)mv.getModel().get("student");
        enrollmentService.createEnrollment(stud.getStudentName(),nameCourse);
        return mv;
    }

}
