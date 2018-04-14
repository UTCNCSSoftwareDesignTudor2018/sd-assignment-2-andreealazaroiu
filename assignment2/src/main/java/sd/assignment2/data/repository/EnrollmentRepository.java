package sd.assignment2.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sd.assignment2.data.entity.Course;
import sd.assignment2.data.entity.Enrollment;
import sd.assignment2.data.entity.Student;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {

    @Query("SELECT e.grade FROM Enrollment e where e.student=:s and e.course=:c")
    public int getGradeByStudentAndCourse(@Param("s")Student student, @Param("c")Course course);

    @Query("SELECT e FROM Enrollment e where e.student=:s and e.course=:c")
    public Enrollment getEnrollment(@Param("s")Student student, @Param("c")Course course);
}
