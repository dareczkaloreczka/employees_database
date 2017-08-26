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
    private static final String TEMP = "users2.txt";

    public List<Employee> getEmployeeListFromDB() {
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

    public void saveEmployeeToDB(Employee employee) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(EMPLOYEES));
            for (Employee u : employeeList) {
                writer.write(employeeMapper.employeeToString(u));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void removeEmployeeFromDB(Employee employee) {
        File origin = new File(EMPLOYEES);
        File temp = new File(TEMP);

        try {
            String line;
            String toBeRemoved = employeeMapper.employeeToString(employee);
            BufferedReader reader = new BufferedReader(new FileReader(EMPLOYEES));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TEMP)); // zmienic plik na temp
            while ((line = reader.readLine()) != null) {
                if (!(line.equals(toBeRemoved))) {
                    int currentIndex = Integer.parseInt(line.split("/")[0]);
                    int newIndex = currentIndex-1;
                    if (currentIndex < employee.getId()){
                        writer.write(line);
                        writer.write("\n");
                    } else{
                        writer.write(newIndex + (line.substring(line.indexOf("/"))));
                        writer.write("\n");
                    }
                }
            }
            writer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean successfull = origin.delete();
        boolean successfull2 = temp.renameTo(origin);
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
