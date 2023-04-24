import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addEmployee(Employee employee) {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getById(int id) {
        Employee employee = new Employee();
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            employee = entityManager.find(Employee.class, 2);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = null;
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            employeeList = entityManager.createQuery("select m from Employee m").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }


    @Override
    public void updateEmployee(int id, Employee employee) {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Employee testEmp = entityManager.find(Employee.class, id);
            testEmp.setAge(employee.getAge());
            testEmp.setFirst_name(employee.getFirst_name());
            testEmp.setLast_name(employee.getLast_name());
            testEmp.setGender(employee.getGender());
            entityManager.merge(testEmp);
            entityManager.clear();
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Employee tempEmployee = EnManFacUt.getEntityManager().find(Employee.class, id);
            entityManager.remove(tempEmployee);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
