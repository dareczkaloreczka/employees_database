package carsDB;

import companiesDB.Company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarDB {
    List<Car> carList;
    CarMapper carMapper = new CarMapper();
    private static final String CARS = "cars.txt";
    private static File source = new File(CARS);

    public List<Car> getCarListFromDB(){
        carList = new ArrayList<>();
        String line;
        try (BufferedReader carReader = new BufferedReader(new FileReader(source))) {
            while ((line = carReader.readLine()) != null) {
                carList.add(carMapper.stringToCar(line));
            }
            carReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return carList;
    }
    public void saveCarToDB(Car car){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(source));
            for (Car ca : carList){
                writer.write(carMapper.carToString(ca));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

