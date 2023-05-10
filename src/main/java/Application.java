import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        EmployeeDAOImpl emEmployee = new EmployeeDAOImpl();
        CityDaoImpl emCityDaoImpl = new CityDaoImpl();

        City city1 = new City(8, "Большие Васюки");
        Employee empl1 = new Employee(25, "Ильф", "Петров", "male", city1);
        Employee empl2 = new Employee(26, "Мадам", "Грицацуева", "female", city1);
        List<Employee> emplList = new ArrayList<Employee>();
        emplList.add(empl1);
        emplList.add(empl2);

        City city2 = new City("Малые Васюки", emplList);

        emCityDaoImpl.addCity(city2);
        emCityDaoImpl.deleteCity(8);


    }
}
