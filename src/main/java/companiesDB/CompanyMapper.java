package companiesDB;

import exceptions.CompanyMapperException;
import exceptions.NegativeNumberException;

import javax.swing.*;

public class CompanyMapper {

    private static final int ID_IDX = 0;
    private static final int NAME_IDX = 1;
    private static final int ADDRESS_IDX = 2;
    private static final int NOE_IDX = 3;


    public String companyToString(Company company){
        String companyLine = company.getId() + "/" + company.getName()+"/"+ company.getAddress()+"/"+ company.getNumberOfEmployees();
        return companyLine;
    }

    public Company stringToCompany(String line) throws CompanyMapperException {
        String[] companyArray = line.split("/");
        if (companyArray.length != 4){
            throw new CompanyMapperException("Invalid data format");
        }
        Company company = null;
        try {
            company = new Company(Integer.parseInt(companyArray[ID_IDX]), companyArray[NAME_IDX],
                    companyArray[ADDRESS_IDX], Integer.parseInt(companyArray[NOE_IDX]));
        } catch (NegativeNumberException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return company;
    }
}
