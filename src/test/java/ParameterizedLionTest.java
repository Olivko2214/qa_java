import com.example.Feline;
import com.example.Lion;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class ParameterizedLionTest {

    @Mock
    Feline feline;

    private AutoCloseable mockitoClosable;

    private final String sex;
    private final boolean doesHaveManeExpectedResult;

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    public ParameterizedLionTest(String sex, boolean doesHaveManeExpectedResult) {
        this.sex = sex;
        this.doesHaveManeExpectedResult = doesHaveManeExpectedResult;
    }

    @Before
    public void init() {
        mockitoClosable = MockitoAnnotations.openMocks(this);
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, this.sex);
        Assert.assertEquals(
                "Наличие гривы не соответствует заданному полу",
                this.doesHaveManeExpectedResult,
                lion.doesHaveMane()
        );
    }

    @After
    public void shutDown() throws Exception {
        mockitoClosable.close();
    }
}
