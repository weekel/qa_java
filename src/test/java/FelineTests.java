import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {

    private Feline feline;

    @Spy
    private Feline spyFeline;

    @Before
    public void setUp() {
        feline = new Feline();
    }


    // Тесты метода eatMeat()
    @Test
    public void eatMeatCallsGetFoodWithPredatorArgument() throws Exception {
        spyFeline = Mockito.spy(feline);
        spyFeline.eatMeat();
        Mockito.verify(spyFeline).getFood("Хищник");
    }

    @Test
    public void eatMeatReturnsCorrectFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        System.out.println("Реальный результат: " + actualFood);
        Assert.assertEquals("Метод eatMeat() вернул неверный список еды", expectedFood, actualFood);
    }



    // Тесты метода getFamily()
    @Test
    public void getFamilyReturnCorrectValue() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        Assert.assertEquals("Метод getFamily() вернул неверное семейство", expectedFamily, actualFamily);
    }



    // Тесты метода getKittens() без аргументов
    @Test
    public void getKittensWithNoParametersCallsGetKittens() {
        spyFeline = Mockito.spy(feline);
        spyFeline.getKittens();
        Mockito.verify(spyFeline).getKittens(1);
    }
}
