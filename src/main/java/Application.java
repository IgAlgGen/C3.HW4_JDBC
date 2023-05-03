import javax.persistence.*;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        EmployeeDAOImpl em = new EmployeeDAOImpl();
        Employee empl = new Employee(40, "Alex", "Yang", "male", 3);

        em.addEmployee(empl);

        System.out.println((em.getById(6)));

        for (Employee employee : em.getAllEmployee()) {
            System.out.println(employee);
        }

        em.updateEmployee(15, empl);

        em.deleteEmployee(16);

    }
}
