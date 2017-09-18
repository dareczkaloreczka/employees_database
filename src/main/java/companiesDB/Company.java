package companiesDB;

import exceptions.NegativeNumberException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private int numberOfEmployees;

    public Company(int id, String name, String address, int numberOfEmployees) throws NegativeNumberException {
        if (numberOfEmployees< 0) {
            throw new NegativeNumberException("Number of employees must be a positive number.");
        }
            this.id = id;
            this.name = name;
            this.address = address;
            this.numberOfEmployees = numberOfEmployees;

    }

    public Company() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (numberOfEmployees != company.numberOfEmployees) return false;
        if (!name.equals(company.name)) return false;
        return address.equals(company.address);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + numberOfEmployees;
        return result;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
