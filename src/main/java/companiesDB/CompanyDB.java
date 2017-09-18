package companiesDB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CompanyDB {
    List<Company> companyList;
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employeesDB");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public List<Company> getCompanyListFromDB(){
        companyList = new ArrayList<>();
        TypedQuery<Company> query = entityManager.createQuery("select c from Company c", Company.class);
        companyList = query.getResultList();

        return companyList;
    }
    public void saveCompanyToDB(Company company){
        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();

    }
    public  Company getCompanyById (int id){
        entityManager.getTransaction().begin();
        Company company = entityManager.find(Company.class, id);
        entityManager.getTransaction().commit();
        return company;
    }
}