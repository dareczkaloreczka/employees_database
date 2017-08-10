package companiesDB;

public class CompanyMapper {


    public String companyToString(Company company){
        String companyLine = company.getId() + "/" + company.getName()+"/"+ company.getAddress()+"/"+ company.getNumberOfEmployees();
        return companyLine;
    }

    public Company stringToCompany(String line){
        String[] companyArray = line.split("/");
        Company company = new Company(Integer.parseInt(companyArray[0]), companyArray[1], companyArray[2], Integer.parseInt(companyArray[3]));

        return company;
    }
}
