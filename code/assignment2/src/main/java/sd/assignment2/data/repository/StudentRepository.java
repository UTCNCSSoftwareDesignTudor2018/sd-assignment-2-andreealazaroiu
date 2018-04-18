package sd.assignment2.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sd.assignment2.data.entity.Course;
import sd.assignment2.data.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    public Student getByStudentName(String name);

    @Query("SELECT s.courses from Student s where s.studentName=:sn")
    public List<Course> getCourses(@Param("sn")String studentName);



}
