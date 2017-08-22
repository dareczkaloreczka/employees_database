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
        Employee employee2 = null;
        assertNull(employee2);
        assertTrue(employee2 == null);
        try {
            assertEquals(null, employeeMapper.employeeToString(employee2));
        } catch (NullPointerException npe){
            System.out.println("Null cannot be converted to String");
        }
    }

    @Test
    public void stringtoEmployee() throws Exception {
        String employeeString =  "7/Dudu/Laurek/6/5/3";
        assertEquals(new Employee(7, "Dudu", "Laurek", 6, 5, 3),
                employeeMapper.stringtoEmployee(employeeString));
        String employeeString2 = "8/Jan/Kowalski/X/Y/Z";
       try {
            assertEquals(null, employeeMapper.stringtoEmployee(employeeString2));
        } catch (NumberFormatException nfe) {
           System.out.println(employeeString2.split("/")[0] + " cannot be converted to number OR ");
           System.out.println(employeeString2.split("/")[3] + " cannot be converted to number OR");
           System.out.println(employeeString2.split("/")[4] + " cannot be converted to number OR");
           System.out.println(employeeString2.split("/")[5] + " cannot be converted to number. ");
           }
       }


    }