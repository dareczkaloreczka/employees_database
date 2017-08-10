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
        assertEquals("7/Bentley/Continental/2010/CALIFORNIA 2302", carMapper.carToString(car));
    }

    @Test
    public void stringToCar() throws Exception {
        String carString = "8/Rolls Royce/Phantom/2011/NY 1108";
        assertEquals(new Car(8, "Rolls Royce", "Phantom", "2011", "NY 1108"),
                carMapper.stringToCar(carString));
    }

}