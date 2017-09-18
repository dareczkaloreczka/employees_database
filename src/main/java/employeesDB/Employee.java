package employeesDB;
import carsDB.Car;
import companiesDB.Company;
import exceptions.NegativeNumberException;
import javax.persistence.*;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;
    @OneToOne
    @JoinColumn
    private Company company;
    @OneToOne
    @JoinColumn
    private Car car;

    public Employee() {
    }

    @Override
    public String toString() {
        return  name + "   " + surname + "   " +  age + "\n";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) throws NegativeNumberException{
        if ( age < 0 ) {
            throw new NegativeNumberException("Age must be a positive number.");
        }
        this.age = age;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void turnInto(Employee employee) throws NegativeNumberException {
        setName(employee.name);
        setSurname(employee.surname);
        setAge(employee.age);
        setCar(employee.car);
        setCompany(employee.company);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (age != employee.age) return false;
        if (!name.equals(employee.name)) return false;
        if (!surname.equals(employee.surname)) return false;
        if (company.getId() != (employee.company.getId())) return false;
        return (car.getId()) == (employee.car.getId());
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;
        result = 31 * result + company.getId();
        result = 31 * result + car.getId();
        return result;
    }
}
