package mockitodemo;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class MathTest {
 
    @Mock
    private MathService mathServiceMock; // Creates a mock

    @InjectMocks
    private Calculator calculator; // Creates an instance of Calculator with the mock MathService injected

    @Test
    public void testFactorial() { // Test factorial calculation
        when(mathServiceMock.factorial(5)).thenReturn(120); // Mock behavior
        calculator.factorial(5); // Execute the method to be tested
        verify(mathServiceMock).factorial(5); // Verify that the factorial method was called with the correct argument
    }
    
    @Test
    public void testSquare() { // Test square calculation
        when(mathServiceMock.square(4)).thenReturn(16);
        calculator.square(4);
        verify(mathServiceMock).square(4);
    }

    @Test
    public void testSquareRoot() { // Test square root calculation
        when(mathServiceMock.squareRoot(16)).thenReturn(4.0);
        calculator.squareRoot(16);
        verify(mathServiceMock).squareRoot(16);
    }
}
