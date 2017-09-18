/*
package employeesDB;

import exceptions.EmployeeMapperException;
import exceptions.NegativeNumberException;
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
        Employee employee = new Employee(1, "Korek", "Laurek", 8, 1, 2);
        assertEquals("1/Korek/Laurek/8/1/2", employeeMapper.employeeToString(employee));
    }

    @Test(expected = NullPointerException.class)
    public void testEmployeeToStringThrowsNPException() {
        Employee employee2 = null;
        assertNull(employee2);
        assertTrue(employee2 == null);
        assertEquals(null, employeeMapper.employeeToString(employee2));
    }

    @Test
    public void stringtoEmployee() throws Exception {
        String employeeString = "7/Dudu/Laurek/6/5/3";
        assertEquals(new Employee(7, "Dudu", "Laurek", 6, 5, 3),
                employeeMapper.stringtoEmployee(employeeString));
    }
    @Test(expected = NegativeNumberException.class)
    public void testStringToEmployeeThrowsNNException() throws EmployeeMapperException, NegativeNumberException {
        String employeeString = "7/Dudu/Laurek/-6/5/3";
        assertEquals(new Employee(7, "Dudu", "Laurek", -6, 5, 3),
                employeeMapper.stringtoEmployee(employeeString));

    }

    @Test(expected = EmployeeMapperException.class)
    public void testStringToEmployeeThrowsCMException() throws EmployeeMapperException{
        String employeeString3 = "9/Karol/Nowak/2/1";
        assertEquals(null, employeeMapper.stringtoEmployee(employeeString3));
    }

    @Test
    public void testStringToEmployeeThrowsNFException() throws EmployeeMapperException, NegativeNumberException {
        String employeeString2 = "8/Jan/Kowalski/X/Y/Z";
        try {
            assertEquals(null, employeeMapper.stringtoEmployee(employeeString2));
            fail("expected exception was not occured");
        } catch (NumberFormatException nfe) {

        }
    }


}*/
