package companiesDB;

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

    @Test
    public void stringToCompany() throws Exception {
        String companyString = "9/JavaMasters/Coding Street 8, 965 Melbourne, AUSTRALIA/15";
        assertEquals(new Company(9, "JavaMasters", "Coding Street 8, 965 Melbourne, AUSTRALIA", 15),
                companyMapper.stringToCompany(companyString));
    }
}
