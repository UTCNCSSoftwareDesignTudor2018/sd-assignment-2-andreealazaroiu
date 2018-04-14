package sd.assignment2.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sd.assignment2.data.entity.Course;
import sd.assignment2.data.entity.Student;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    public Course getByCourseName(String courseName);

}
