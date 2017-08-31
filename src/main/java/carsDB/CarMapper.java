package carsDB;

import exceptions.CarMapperException;
import exceptions.NegativeNumberException;

public class CarMapper {

    private static final int ID_IDX = 0;
    private static final int BRAND_IDX = 1;
    private static final int MODEL_IDX = 2;
    private static final int YEAR_IDX = 3;
    private static final int BOARD_IDX = 4;


    public String carToString(Car car){
        String carLine = car.getId()+ "/" + car.getBrand() + "/"+ car.getModel()+ "/"+ car.getProductionYear()+"/"+car.getRegBoard();
        return carLine;
    }

    public Car stringToCar(String line) throws CarMapperException {
        String [] carArray = line.split("/");
        if (carArray.length != 5){
            throw new CarMapperException("Invalid data format.");
        }
        Car car = null;
        car = new Car(Integer.parseInt(carArray[ID_IDX]), carArray[BRAND_IDX],
                carArray[MODEL_IDX], carArray[YEAR_IDX], carArray[BOARD_IDX]);
        return car;
    }
}
