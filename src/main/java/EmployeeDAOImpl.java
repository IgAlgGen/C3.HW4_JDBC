import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee getById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
           return session.get(Employee.class, id);
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Employee").list();
        }
    }


    @Override
    public void updateEmployee(int id, Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            employee.setId(id);
            session.update(employee);
            transaction.commit();
        }

    }

    @Override
    public void deleteEmployee(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(session.find(Employee.class,id));
            transaction.commit();
        }
    }


}
