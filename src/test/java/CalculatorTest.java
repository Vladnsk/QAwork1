import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Created by Владислав on 25.07.2017.
 */
public class CalculatorTest {

    @Test
    public void checkDevWithError() throws Exception {
        ArrayList<String> testMass = new ArrayList<String>();
        testMass.add("123");
        testMass.add("321abs");
        testMass.add("111");

        for(int i = 0; i < testMass.size() - 1; i++){
            assertTrue(Calculator.checkDev(testMass.get(i),testMass.get(testMass.size() - 1 - i)));
        }
    }

    @Test
    public void checkDevWithOutError() throws Exception {
        ArrayList<String> testMass = new ArrayList<String>();
        testMass.add("123");
        testMass.add("-1");
        testMass.add("999999");

        for(int i = 0; i < testMass.size() - 1; i++){
            assertTrue(Calculator.checkDev(testMass.get(i),testMass.get(testMass.size() - 1 - i)));
        }
    }

    @Test
    public void checkDev() throws Exception{

        assertEquals("5.0", Calculator.devS("10","2"));
        assertEquals("-5.0", Calculator.devS("-10","2"));
        assertEquals("-5.0", Calculator.devS("10","-2"));
        assertEquals(null, Calculator.devS("10","0"));


    }




}