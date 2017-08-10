package employeesDB;

public class EmployeeMapper {

    private static final int ID_IDX = 0;
    private static final int NAME_IDX = 1;
    private static final int SURNAME_IDX = 2;
    private static final int AGE_IDX = 3;
    private static final int COMPANY_IDX = 4;
    private static final int CAR_IDX = 5;



    public String employeeToString(Employee employee){
        String employeeLine = employee.getId() + "/" + employee.getName()+"/"+ employee.getSurname()+"/"+
                employee.getAge()+"/"+ employee.getCompany().getId()+"/"+ employee.getCar().getId();
        return employeeLine;
    }

    public Employee stringtoEmployee(String line){
        String[] employeeArray = line.split("/");
        Employee employee = new Employee(Integer.parseInt(employeeArray[ID_IDX]), employeeArray[NAME_IDX], employeeArray[SURNAME_IDX], Integer.parseInt(employeeArray[AGE_IDX]),
                Integer.parseInt(employeeArray[COMPANY_IDX]),Integer.parseInt(employeeArray[CAR_IDX]));

        return employee;
    }
}