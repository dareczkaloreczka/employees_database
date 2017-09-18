package employeesDB;

import exceptions.NegativeNumberException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {

    List<Employee> employeeList;
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employeesDB");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public List<Employee> getEmployeeListFromDB() {
        employeeList = new ArrayList<>();
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e", Employee.class);
        employeeList = query.getResultList();

        return employeeList;
    }

    public void saveEmployeeToDB(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

    }

    public void removeEmployeeFromDB(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Employee.class, employee.getId()));
        entityManager.getTransaction().commit();
    }

    public Employee getEmployeeById(int id){
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.getTransaction().commit();
        return employee;
    }
    public void updateEmployee(Employee employee) throws NegativeNumberException {
        entityManager.getTransaction().begin();
        Employee updated = entityManager.find(Employee.class, employee.getId());
        updated.turnInto(employee);
        entityManager.getTransaction().commit();
    }
}
