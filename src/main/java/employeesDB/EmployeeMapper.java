package employeesDB;

public class EmployeeMapper {


    public String employeeToString(Employee employee){
        String employeeLine = employee.getId() + "/" + employee.getName()+"/"+ employee.getSurname()+"/"+
                employee.getAge()+"/"+ employee.getCompany().getId()+"/"+ employee.getCar().getId();
        return employeeLine;
    }

    public Employee stringtoEmployee(String line){
        String[] employeeArray = line.split("/");
        Employee employee = new Employee(Integer.parseInt(employeeArray[0]), employeeArray[1], employeeArray[2], Integer.parseInt(employeeArray[3]),
                Integer.parseInt(employeeArray[4]),Integer.parseInt(employeeArray[5]));

        return employee;
    }
}
