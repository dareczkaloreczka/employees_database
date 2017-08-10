package carsDB;

public class Car {

    private int id;
    private String brand;
    private String model;
    private String productionYear;
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
