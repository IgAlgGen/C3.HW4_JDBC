import java.sql.*;
import java.util.ListIterator;

public class Application {
    public static void main(String[] args) {
        final String user = "postgres";
        final String password = "12345";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee RIGHT JOIN city ON employee.city_id = city.city_id WHERE id = (?)")) {
            statement.setInt(1, 4);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                int ageOfEmployee = resultSet.getInt("age");
                String nameOfEmployee = resultSet.getString("first_name");
                String surnameOfEmployee = resultSet.getString("last_name");
                String genderOfEmployee = resultSet.getString("gender");
                String cityOfEmployee = resultSet.getString("city_name");

                System.out.printf("id = %d, Имя = %s, Фамилия = %s, пол = %s, возраст = %d, город = %s%n", idOfEmployee, nameOfEmployee, surnameOfEmployee, genderOfEmployee, ageOfEmployee, cityOfEmployee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//Проверить корректность работы всех методов в классе Application.
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

//Создаем тестового employee
        Employee testEmployee1 = new Employee(20, "asdasd", "asdasd", "male", new City(1, "Самара"));

//тест addEmployee
        employeeDAO.addEmployee(testEmployee1);
//тест getById
        System.out.println(employeeDAO.getById(6));

//тест getAllEmployee
        for (ListIterator<Employee> it = employeeDAO.getAllEmployee().listIterator(); it.hasNext(); ) {
            Employee employee = it.next();
            System.out.println(employee);
        }
//тест updateEmployee
        testEmployee1.setFirst_name("Nick");
        testEmployee1.setLast_name("Smith");
        employeeDAO.updateEmployee(18, testEmployee1);

//тест deleteEmployee
        employeeDAO.deleteEmployee(18);
    }


}
