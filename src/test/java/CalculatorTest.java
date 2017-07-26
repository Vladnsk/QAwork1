import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Created by Владислав on 25.07.2017.
 */
public class CalculatorTest {

    @Test
    public void checkDevWithIncorrectA() throws Exception {
            assertEquals("Incorrect input",Calculator.devS("123abc","10"));
    }
    @Test
    public void checkDevWithIncorrectB() throws Exception {
        assertEquals("Incorrect input",Calculator.devS("123","10abc"));
    }
    @Test
    public void checkDevWithIncorrectZero() throws Exception {
        assertEquals("Incorrect input",Calculator.devS("123","0"));
    }
    @Test
    public void devSPlusPlus() throws Exception{
        assertEquals("10.0", Calculator.devS("100","10"));
    }
    @Test
    public void devSPlusMinus() throws Exception{
        assertEquals("-25.0", Calculator.devS("50","-2"));
    }
    @Test
    public void devSMinusPlus() throws Exception{
        assertEquals("-10.0", Calculator.devS("-100","10"));
    }
    @Test
    public void devSIntDouble() throws Exception{
        assertEquals("2.0", Calculator.devS("21","10.5"));
    }

    @Test
    public void devSDoubleInt() throws Exception{
        assertEquals("4.3", Calculator.devS("21.5","5"));
    }
}