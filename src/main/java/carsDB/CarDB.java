package carsDB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CarDB {
    List<Car> carList;
    EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("employeesDB");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Car> getCarListFromDB(){
        carList = new ArrayList<>();
        TypedQuery <Car> query = entityManager.createQuery("select c from Car c ", Car.class);
        carList = query.getResultList();

        return carList;
    }
    public void saveCarToDB(Car car){
        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.getTransaction().commit();

    }

    public Car getCarById(int id){
        entityManager.getTransaction().begin();
        Car car = entityManager.find(Car.class, id);
        entityManager.getTransaction().commit();

        return car;
    }
}

