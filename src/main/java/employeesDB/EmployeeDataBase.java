package employeesDB;

import carsDB.Car;
import carsDB.CarDB;
import companiesDB.Company;
import companiesDB.CompanyDB;
import exceptions.EmployeeMapperException;

import javax.swing.*;
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
    private static final String TEMP = "users2.txt";
    private static File source = new File(EMPLOYEES);
    private static File temp = new File(TEMP);

    public List<Employee> getEmployeeListFromDB() {
        employeeList = new ArrayList<>();
        String line;
        try (BufferedReader employeeReader = new BufferedReader(new FileReader(source))) {
            while ((line = employeeReader.readLine()) != null) {
                employeeList.add(employeeMapper.stringtoEmployee(line));
            }
            employeeReader.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Requested file does not exist.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Access denied.");
        } catch (EmployeeMapperException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return employeeList;
    }

    public void saveEmployeeToDB(Employee employee) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(source));
            for (Employee u : employeeList) {
                writer.write(employeeMapper.employeeToString(u));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "Access denied.");
        }
    }

    public void removeEmployeeFromDB(Employee employee) {

        try {
            String line;
            String toBeRemoved = employeeMapper.employeeToString(employee);
            BufferedReader reader = new BufferedReader(new FileReader(source));
            BufferedWriter writer = new BufferedWriter(new FileWriter(temp)); // zmienic plik na temp
            while ((line = reader.readLine()) != null) {
                int currentId = Integer.parseInt(line.split("/")[0]);
                if (currentId != employee.getId()){
                    writer.write(line);
                    writer.write("\n");
                }
            }
            writer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Requested file does not exist.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Access denied.");
        }
        boolean successfull = source.delete();
        boolean successfull2 = temp.renameTo(source);
    }

    public Company idToCompany(int id) {
        companyList = companyDB.getCompanyListFromDB();
        Company employeeCompany = null;
        for (Company company : companyList) {
            if (company.getId() == id) {
                employeeCompany = company;
            }
        }
        return employeeCompany;
    }

    public Car idToCar(int id) {
        carList = carDB.getCarListFromDB();
        Car employeeCar = null;
        for (Car car : carList) {
            if (car.getId() == id) {
                employeeCar = car;
            }
        }
        return employeeCar;
    }
}
