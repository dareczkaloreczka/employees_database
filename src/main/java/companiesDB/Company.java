package companiesDB;

public class Company {

    private int id;
    private String name;
    private String address;
    private int numberOfEmployees;

    public Company(int id, String name, String address, int numberOfEmployees) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.numberOfEmployees = numberOfEmployees;
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
}
