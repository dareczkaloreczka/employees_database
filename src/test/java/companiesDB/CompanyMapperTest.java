package companiesDB;

import exceptions.CompanyMapperException;
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
        Company company2 = null;
        try {
            assertEquals(null, companyMapper.companyToString(company2));
        } catch (NullPointerException npe) {
            System.out.println("Null object cannot be converted into string");
            company2 = new Company(0, "", "", 0);
            assertEquals("0///0", companyMapper.companyToString(company2));
        }

    }

    @Test
    public void stringToCompany() throws Exception {
        String companyString = "9/JavaMasters/Coding Street 8, 965 Melbourne, AUSTRALIA/15";
        assertEquals(new Company(9, "JavaMasters", "Coding Street 8, 965 Melbourne, AUSTRALIA", 15),
                companyMapper.stringToCompany(companyString));
        String companyString2 = "10/Coders Republic/Java Street 9, 524 Chicago, US/much";
        try {
            assertEquals(new Company(10, "Coders Republic", "Java Street 9, 524 Chicago, US", 1000),
                    companyMapper.stringToCompany(companyString2));
        } catch (NumberFormatException nfe) {
            String nOfE = companyString2.split("/")[3];
            System.out.println(nOfE + " cannot be converted to a number");
            nOfE = "1000";
            companyString2 = companyString2.split("/")[0] + "/" + companyString2.split("/")[1]
                    + "/" + companyString2.split("/")[2] + "/" + nOfE;
            assertEquals(new Company(10, "Coders Republic", "Java Street 9, 524 Chicago, US", 1000),
                    companyMapper.stringToCompany(companyString2));
        }
        String companyString3 = "11/JavaMasters/115";
        try {
            assertEquals(null, companyMapper.stringToCompany(companyString3));
        } catch (CompanyMapperException cme){
            System.out.println("Source file does not contain essential information to create an Object. ");
        }
    }
}
