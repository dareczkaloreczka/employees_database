package employeesDB;

import carsDB.Car;
import carsDB.CarDB;
import companiesDB.Company;
import companiesDB.CompanyDB;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDataBase {

    List<Employee> employeeList;
    List<Company> companyList;
    List<Car> carList;
    EmployeeMapper employeeMapper = new EmployeeMapper();
    CompanyDB companyDB = new CompanyDB();
    CarDB carDB = new CarDB();
    private static final String EMPLOYEES = "users.txt";

    public List<Employee> getEmployeeListFromDB(){
        employeeList = new ArrayList<>();
        String line;
        try (BufferedReader employeeReader = new BufferedReader(new FileReader(EMPLOYEES))) {
            while ((line = employeeReader.readLine()) != null) {
                employeeList.add(employeeMapper.stringtoEmployee(line));
            }
            employeeReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
    public void saveEmployeeToDB(Employee employee){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(EMPLOYEES));
            for (Employee u : employeeList){
                writer.write(employeeMapper.employeeToString(u));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    public Company idToCompany(int id){
        companyList = companyDB.getCompanyListFromDB();
        Company employeeCompany = null;
        for (Company company : companyList){
            if (company.getId() == id){
                employeeCompany = company;
            }
        }
        return employeeCompany;
    }
    public Car idToCar(int id){
        carList = carDB.getCarListFromDB();
        Car employeeCar = null;
        for (Car car : carList){
            if (car.getId() == id){
                employeeCar = car;
            }
        }
        return employeeCar;
    }
}
