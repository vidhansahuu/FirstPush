package MsSqlProject.myls.Repository;

import MsSqlProject.myls.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository extends JpaRepository<Employee ,String> {
}
