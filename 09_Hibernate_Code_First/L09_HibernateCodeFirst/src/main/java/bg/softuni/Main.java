package bg.softuni;

import bg.softuni.entities.Bike;
import bg.softuni.entities.Car;
import bg.softuni.entities.Plane;
import bg.softuni.entities.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("relations");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Vehicle car = new Car("Ford Focus", "Petrol", 5);
        Vehicle bike = new Bike();
        Vehicle plane = new Plane("AirBus", "Petrol", 200);

        entityManager.persist(car);
        entityManager.persist(bike);
        entityManager.persist(plane);


        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
