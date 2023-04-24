import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "age")
    private int age;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "city_id")
    private int city;

    public Employee() {
    }

    public Employee(int age, String first_name, String last_name, String gender, int city) {
        this.age = age;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.city = city;
    }

    public Employee(int id, int age, String first_name, String last_name, String gender, int city) {
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

    public int getCity() {
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

    public void setCity(int city) {
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
