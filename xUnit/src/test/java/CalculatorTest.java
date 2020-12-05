import classes.Calculator;
import exception.CalculatorException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void addTwoNumbersTest() throws CalculatorException {
        int expected = 10;
        int actual = calculator.addTwoNumbers(5,5);
        Assert.assertEquals(actual, expected);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionAddTwoNumbersTest() throws CalculatorException {
        calculator.addTwoNumbers(Integer.MAX_VALUE, 1);
    }

    @Test
    public void subTwoNumbersTest() throws CalculatorException {
        int expected = 100;
        int actual = calculator.subTwoNumbers(99, -1);
        Assert.assertEquals(actual, expected);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionSubTwoNumbersTest() throws CalculatorException {
        calculator.subTwoNumbers(Integer.MIN_VALUE, 1);
    }

    @Test
    public void multiTwoNumbersTest() throws CalculatorException {
        int expected = 0;
        int actual = calculator.multiplyTwoNumbers(0, 100);
        Assert.assertEquals(actual, expected);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionMultiTwoNumbersTest() throws CalculatorException {
        calculator.multiplyTwoNumbers(Integer.MAX_VALUE, 100);
    }

    @Test
    public void divideTwoNumbersTest() throws CalculatorException {
        int expected = -5;
        int actual = calculator.divideTwoNumbers(25, -5);
        Assert.assertEquals(actual, expected);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionDivideTwoNumbersTest() throws CalculatorException {
        calculator.divideTwoNumbers(10, 0);
    }

    @Test
    public void divideWithRemainderTwoNumbersTest() throws CalculatorException {
        int expected = 10;
        int actual = calculator.divideTwoNumbers(-20, -2);
        Assert.assertEquals(actual, expected);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionDivideWithRemainderTwoNumbersTest() throws CalculatorException {
        calculator.divideTwoNumbers(-20, 0);
    }
}
