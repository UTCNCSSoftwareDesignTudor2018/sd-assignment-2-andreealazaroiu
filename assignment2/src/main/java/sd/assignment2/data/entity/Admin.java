package sd.assignment2.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="admins")
public class Admin {

    @Id
    @Column(name="admin_id")
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int adminId;

    @Column(name="admin_name")
    private String adminName;

    @OneToMany(mappedBy="admin",fetch=FetchType.EAGER)
    private List<Course> courses;

    public Admin(int adminId,String name) {
    }

    public Admin() {
        this.adminId = 0;
        this.adminName="";
        this.courses=new ArrayList<Course>();
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName; }

    public void setAdminName(String adminName) {
        this.adminName = adminName; }

    public List<Course> getCourses() {
        return courses; }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return adminId == admin.adminId &&
                Objects.equals(adminName, admin.adminName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(adminId, adminName);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", courses=" + courses +
                '}';
    }
}
