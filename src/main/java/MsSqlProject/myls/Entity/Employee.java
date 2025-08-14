package MsSqlProject.myls.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    private String id;
    @Column(nullable = false)
    @Size(min = 3)
    @NotEmpty(message = "NAME CAM NOT BE EMPTY")
    private String name;

    @Column(nullable = false)
    @Size(min = 3)
    @NotEmpty(message = "CITY FILED CAN NOT BE EMPTY")
    private String city;

    @Column(nullable = false)
    @NotEmpty
    private String department;

    public Employee() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
