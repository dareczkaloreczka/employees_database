
import carsDB.Car;
import companiesDB.Company;
import employeesDB.Employee;
import exceptions.NegativeNumberException;
import gui.EmployeeView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employeesDB");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EmployeeView listaUserow = new EmployeeView();
                listaUserow.setVisible(true);
            }
        });

        entityManager.close();
        entityManagerFactory.close();
    }
}
