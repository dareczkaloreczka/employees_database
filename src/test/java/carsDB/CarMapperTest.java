package carsDB;

import exceptions.CarMapperException;
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

    @Test(expected = NullPointerException.class)
    public void testCarToStringThrowsNPException() {
        Car car2 = null;
        assertEquals(null, carMapper.carToString(car2));
    }

    @Test
    public void stringToCar() throws Exception {
        String carString = "8/Rolls Royce/Phantom/2011/NY 1108";
        assertEquals(new Car(8, "Rolls Royce", "Phantom", "2011", "NY 1108"),
                carMapper.stringToCar(carString));
    }

    @Test(expected = CarMapperException.class)
    public void testStringToCarThrowsCMException() throws CarMapperException {
        String carString3 = "8/Rolls/Ghost/2014";
        assertEquals(null, carMapper.stringToCar(carString3));
    }

    @Test
    public void testStringToCarThrowsNFException() throws CarMapperException {
        String carString2 = "XXX/Fiat/126P/1994/BDG 5698";
        try {
            assertEquals(new Car(0, "Fiat", "126P", "1994", "BDG 5698"),
                    carMapper.stringToCar(carString2));
            fail("expected exception was not occured");
        } catch (NumberFormatException nfe) {
        }

    }
}