package sd.assignment2.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sd.assignment2.data.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
