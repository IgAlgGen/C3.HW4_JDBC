import java.util.List;

public interface CityDao {
    void addCity(City city);

    City getById(int id);

    List<City> getAllCity();

    void updateCity(int id, City city);

    void deleteCity(int id);
}
