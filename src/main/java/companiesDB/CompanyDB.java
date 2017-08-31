package companiesDB;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDB {
    List<Company> companyList;
    CompanyMapper companyMapper = new CompanyMapper();
    private static final String COMPANIES = "companies.txt";
    private static File source = new File(COMPANIES);

    public List<Company> getCompanyListFromDB(){
        companyList = new ArrayList<>();
        String line;
        try (BufferedReader companyReader = new BufferedReader(new FileReader(source))) {
            while ((line = companyReader.readLine()) != null) {
                companyList.add(companyMapper.stringToCompany(line));
            }
            companyReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companyList;
    }
    public void saveCompanyToDB(Company company){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(source));
            for (Company comp : companyList){
                writer.write(companyMapper.companyToString(comp));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}