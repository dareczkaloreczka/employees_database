package employeesDB;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EmployeeMapperTest {

    EmployeeMapper employeeMapper;

    @Before
    public void setUp() throws Exception {
        employeeMapper = new EmployeeMapper();
    }

    @Test
    public void employeeToString() throws Exception {
        Employee employee = new Employee(1, "Korek", "Laurek", 8, 1,2);
        assertEquals("1/Korek/Laurek/8/1/2", employeeMapper.employeeToString(employee));
    }

    @Test
    public void stringtoEmployee() throws Exception {
        String employeeString =  "7/Dudu/Laurek/6/5/3";
        assertEquals(new Employee(7, "Dudu", "Laurek", 6, 5, 3),
                employeeMapper.stringtoEmployee(employeeString));

    }

}