package sd.assignment2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sd.assignment2.business.EnrollmentService;
import sd.assignment2.business.StudentService;
import sd.assignment2.data.entity.Admin;
import sd.assignment2.data.entity.Course;
import sd.assignment2.data.entity.Student;
import sd.assignment2.data.repository.AdminRepository;
import sd.assignment2.data.repository.CourseRepository;
import sd.assignment2.data.repository.EnrollmentRepository;
import sd.assignment2.data.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Assignment2ApplicationTests {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentService studentService;

	@Autowired
	private EnrollmentService enrollmentService;

	@SuppressWarnings("deprecation")
	@Test
	public void findNotEmpty()
	{
		List<Admin> al=adminRepository.findAll();
		Assert.notEmpty(al);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void findNotEmptyStud()
	{
		List<Student> al=studentRepository.findAll();
		Assert.notEmpty(al);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void findGrade()
	{
		Optional<Student> s=studentRepository.findById(1);
		Optional<Course> c=courseRepository.findById(1);

		int grade=enrollmentRepository.getGradeByStudentAndCourse(s.get(),c.get());
		System.out.println(grade);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void verifyStudentView()
	{
		Optional<Student> s=studentRepository.findById(1);
		System.out.println(studentService.viewPersonalInformation(s.get().getStudentName()).toString());


	}

	@SuppressWarnings("deprecation")
	@Test
	public void verifyStudentUpdate()
	{
		//Optional<Student> s=studentRepository.findById(1);

		//String stud=s.get().getStudentName();
		studentService.updateEmail("Emanuel Cinca","emacinca@yahoo.com");

		//Optional<Student> s2=studentRepository.findById(1);
		//System.out.println(s2.get().getEmail());

	}

	@SuppressWarnings("deprecation")
	@Test
	public void verifyEnrollmentDelete()
	{
		enrollmentService.deleteEnrollment("Luta Marin","Software Design");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void verifyEnrollmentGetGrade()
	{
		System.out.println(enrollmentService.getGrade("Emanuel Cinca","Software Design"));
	}

	/*Worked
	@SuppressWarnings("deprecation")
	@Test
	public void verifySetGrade()
	{enrollmentService.setGrade("Emanuel Cinca","Software Design",9);}*/

	/*worked
	@SuppressWarnings("deprecation")
	@Test
	public void verifyDeleteStudent()
	{studentService.deletePersonalInformation("Luta Marin");}*/


	/*@SuppressWarnings("deprecation")
	@Test
	public void verifyGetAllCourses()
	{
		List<Course> c=studentService.viewCourses("Emanuel Cinca");
		for(Course a:c)
		System.out.println(a.getCourseName()+" ");
	}*/
}
