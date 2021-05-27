package calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    private MathApplication mathApplicationClass;

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    private CalculatorService calculatorServiceInterface;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void add() {

        //add the behavior of calc service to add two numbers
        when(calculatorServiceInterface.add(10.0, 20.0)).thenReturn(30.0);

        assertEquals(mathApplicationClass.add(10.0, 20.0), 30.0, 0);
    }

    @Test
    public void subtract() {

        when(calculatorServiceInterface.add(50.5, 20.0))
                .thenReturn(30.0);
        assertEquals(mathApplicationClass.subtract(50.5, 40.0), 10.5, 0);
    }

    @Test
    public void multiply() {

        when(calculatorServiceInterface.multiply(5.0, 4.0))
                .thenReturn(20.0);
        assertEquals(mathApplicationClass.multiply(3.0, 8.0), 24.0, 0);
    }

    @Test
    public void divide() {

        when(calculatorServiceInterface.divide(10.0, 2.0))
                .thenReturn(5.0);
        assertEquals(mathApplicationClass.divide(100.0, 20.0), 5, 0);
    }
}