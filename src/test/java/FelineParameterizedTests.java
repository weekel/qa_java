import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineParameterizedTests {

    private Feline feline;

    private final int inputKittens;
    private final int expectedKittens;

    public FelineParameterizedTests(int inputKittens, int expectedKittens) {
        this.inputKittens = inputKittens;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensCount() {
        return new Object[][] {
                {0, 0},
                {1, 1},
                {3, 3},
                {10, 10},
                {100, 100}
        };
    }

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void getKittensWithParameterReturnsCorrectValue() {
        int actualKittens = feline.getKittens(inputKittens);
        Assert.assertEquals("Метод getKittens(int kittensCount) вернул неверное значение",
                expectedKittens, actualKittens);
    }
}
