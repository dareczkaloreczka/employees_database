package carsDB;

public class CarMapper {

    public String carToString(Car car){
        String carLine = car.getId()+ "/" + car.getBrand() + "/"+ car.getModel()+ "/"+ car.getProductionYear()+"/"+car.getRegBoard();
        return carLine;
    }

    public Car stringToCar(String line){
        String [] carArray = line.split("/");
        Car car = new Car(Integer.parseInt(carArray[0]), carArray[1], carArray[2], carArray[3], carArray[4]);
        return car;
    }
}
