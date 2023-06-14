public class Employee {
    private int id, age;
    private String first_name, last_name, gender;
    private City city;

    public Employee() {
    }

    public Employee(int age, String first_name, String last_name, String gender, City city) {
        this.age = age;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.city = city;
    }

    public Employee(int id, int age, String first_name, String last_name, String gender, City city) {
        this.id = id;
        this.age = age;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.city = city;
    }

    //region Getter - Setter
    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public City getCity() {
        return city;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCity(City city) {
        this.city = city;
    }
    //endregion Getter - Setter


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", city=" + city +
                '}';
    }
}
