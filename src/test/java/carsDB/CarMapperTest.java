package carsDB;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarMapperTest {

    CarMapper carMapper;
    @Before
    public void setUp() throws Exception {
        carMapper = new CarMapper();
    }

    @Test
    public void carToString() throws Exception {
        Car car = new Car(7, "Bentley", "Continental", "2010", "CALIFORNIA 2302");
        Car car2 = null;
        assertEquals("7/Bentley/Continental/2010/CALIFORNIA 2302", carMapper.carToString(car));
        try{
            assertEquals(null,carMapper.carToString(car2)) ;
        }catch (NullPointerException npe){
            System.out.println("Null object cannot be converted into string");
            car2 = new Car(0, "", "", "", "");
            assertEquals("0////", carMapper.carToString(car2));
        }
    }

    @Test
    public void stringToCar() throws Exception {
        String carString = "8/Rolls Royce/Phantom/2011/NY 1108";
        assertEquals(new Car(8, "Rolls Royce", "Phantom", "2011", "NY 1108"),
                carMapper.stringToCar(carString));
        String carString2 = "XXX/Fiat/126P/1994/BDG 5698";
        try {
        assertEquals(new Car(0, "Fiat","126P", "1994", "BDG 5698"),
                carMapper.stringToCar(carString2));
    } catch (NumberFormatException nfe){
            String idString = carString2.substring(0, carString2.indexOf("/"));
            System.out.println(idString + " cannot be converted to ID");

        }
    }

}