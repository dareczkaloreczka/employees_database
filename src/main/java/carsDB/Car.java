package carsDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "cars")
public class Car {

    @Column(name="CarId", unique=true)
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "Brand")
    private String brand;
    @Column(name = "Model")
    private String model;
    @Column (name = "ProductionYear")
    private String productionYear;
    @Column (name = "RegBoard")
    private String regBoard;

    public Car(int id, String brand, String model, String productionYear, String regBoard) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.regBoard = regBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (!brand.equals(car.brand)) return false;
        if (!model.equals(car.model)) return false;
        if (!productionYear.equals(car.productionYear)) return false;
        return regBoard.equals(car.regBoard);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + brand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + productionYear.hashCode();
        result = 31 * result + regBoard.hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public String getRegBoard() {
        return regBoard;
    }
}
