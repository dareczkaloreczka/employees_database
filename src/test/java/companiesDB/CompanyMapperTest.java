package companiesDB;

import exceptions.CompanyMapperException;
import exceptions.NegativeNumberException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompanyMapperTest {

    CompanyMapper companyMapper;


    @Before
    public void setUp() throws Exception {
        companyMapper = new CompanyMapper();
    }

    @Test
    public void companyToString() throws Exception {
        Company company = new Company(9, "JavaMasters", "Coding Street 8, 965 Melbourne, AUSTRALIA", 15);
        assertEquals("9/JavaMasters/Coding Street 8, 965 Melbourne, AUSTRALIA/15", companyMapper.companyToString(company));
    }

    @Test(expected = NullPointerException.class)
    public void testCompanyToStringThrowsNPException()  {
        Company company2 = null;
        assertEquals(null, companyMapper.companyToString(company2));
    }

    @Test
    public void stringToCompany() throws Exception {
        String companyString = "9/JavaMasters/Coding Street 8, 965 Melbourne, AUSTRALIA/15";
        assertEquals(new Company(9, "JavaMasters", "Coding Street 8, 965 Melbourne, AUSTRALIA", 15),
                companyMapper.stringToCompany(companyString));

    }
    @Test(expected = NegativeNumberException.class)
    public void testStringToCompanyThrowsNNException() throws CompanyMapperException, NegativeNumberException {
        String companyString = "9/JavaMasters/Coding Street 8, 965 Melbourne, AUSTRALIA/-15";
        assertEquals(new Company(9, "JavaMasters", "Coding Street 8, 965 Melbourne, AUSTRALIA", -15),
                companyMapper.stringToCompany(companyString));

    }

    @Test(expected = CompanyMapperException.class)
    public void testStringToCompanyThrowsCMException() throws CompanyMapperException{
        String companyString3 = "11/JavaMasters/115";
        assertEquals(null, companyMapper.stringToCompany(companyString3));
    }

    @Test
    public void testStringToCompanyThrowsNFException() throws CompanyMapperException, NegativeNumberException {
        String companyString2 = "10/Coders Republic/Java Street 9, 524 Chicago, US/much";
        try {
            assertEquals(new Company(10, "Coders Republic", "Java Street 9, 524 Chicago, US", 1000),
                    companyMapper.stringToCompany(companyString2));
            fail("expected exception was not occured");
        } catch (NumberFormatException nfe) {
        }
    }
}
