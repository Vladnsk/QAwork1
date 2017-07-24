import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Владислав on 25.07.2017.
 */
public class CalculatorTest {
    @Test
    public void checkKeysWithError() throws Exception {
        ArrayList<String> testMass = new ArrayList<String>();
                testMass.add("123");
                testMass.add("asd");
                testMass.add("123asd");

        for(int i = 0; i < testMass.size() - 1; i++){
            assertTrue(Calculator.checkKeys(testMass.get(i)));
        }
    }

    @Test
    public void checkKeysWithoutError() throws Exception {
        ArrayList<String> testMass = new ArrayList<String>();
        testMass.add("123");
        testMass.add("321");
        testMass.add("999999");

        for(int i = 0; i < testMass.size() - 1; i++){
            assertTrue(Calculator.checkKeys(testMass.get(i)));
        }

    }

    @Test
    public void del() throws Exception {
        assertEquals(10, Calculator.del(20,2));
    }

    @Test(expected = ArithmeticException.class)
    public void delWithException() {
        Calculator.del(15,0);
    }


}