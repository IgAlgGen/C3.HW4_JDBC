public class City {
    int city_id;
    String city_name;

    public City(int city_id, String city_name) {
        this.city_id = city_id;
        this.city_name = city_name;
    }

    //region Getter - Setter
    public int getCity_id() {
        return city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
    //endregion


    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}
