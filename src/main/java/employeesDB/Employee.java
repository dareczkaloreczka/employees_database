package employeesDB;
import carsDB.Car;
import companiesDB.Company;
import exceptions.NegativeNumberException;

public class Employee {

    private int id;
    private String name;
    private String surname;
    private int age;
    private Company company;
    private Car car;
    private EmployeeDataBase employeeDataBase = new EmployeeDataBase();

    public Employee(int id, String name, String surname, int age, int companyId, int carId)  throws NegativeNumberException {
        if (id <= 0 || age < 0 || companyId <=0 || carId <= 0) {
            throw new NegativeNumberException("Id's and age must be positive numbers.");
        }
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.company = employeeDataBase.idToCompany(companyId);
        this.car = employeeDataBase.idToCar(carId);
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

    public void setNewValue(Employee employee)throws NegativeNumberException{
        if (id <= 0 || age < 0 ) {
            throw new NegativeNumberException("Id and age must be positive numbers.");
        }
        this.id = employee.id;
        this.name = employee.name;
        this.surname = employee.surname;
        this.car = employee.car;
        this.company = employee.company;
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
