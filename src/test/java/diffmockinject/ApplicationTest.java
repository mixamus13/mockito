package diffmockinject;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.asm.util.CheckClassAdapter;

import static com.sun.tools.doclint.Entity.times;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    @InjectMocks
    MainClass mainClass;

    @Mock
    DatabaseDAO dependentClassOne;

    @Mock
    NetworkDAO dependentClassTwo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validateTest() {
        boolean saved = mainClass.save("temp.txt");
        assertEquals(true, saved);

        verify(dependentClassOne, times(1)).save("temp.txt");
        verify(dependentClassTwo, times(1)).save("temp.txt");
    }
}