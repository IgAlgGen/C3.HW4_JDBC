import javax.persistence.*;
import java.util.List;


public class Application {
    public static void main(String[] args) {
      EmployeeDAOImpl em = new EmployeeDAOImpl();
      Employee empl = new Employee(40, "Alex", "Yang", "male", 3);
//      em.addEmployee(empl);

//      Employee newone = em.getById(3);
//        System.out.println(newone);

        List<Employee> emplList = em.getAllEmployee();
        for (Employee employee: emplList) {
            System.out.println(employee);
        }

        em.updateEmployee(12, empl);

        em.deleteEmployee(12);

    }
}
