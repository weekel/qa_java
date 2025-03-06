import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    private Feline feline;
    private Cat cat;

    @Mock
    private Feline mockFeline;

    @Before
    public void setUp() {
        feline = new Feline();
    }


    //Тесты конструктора класса Cat
    @Test
    public void testCatConstuctor() {
        cat = new Cat(feline);
        Assert.assertNotNull("Объект Cat не был создан", cat);
    }



    //Тесты метода getFood()
    @Test
    public void getFoodMethodCallsOnce() throws Exception {
        cat = new Cat(mockFeline);
        cat.getFood();
        Mockito.verify(mockFeline, Mockito.times(1)).eatMeat();

    }

    @Test
    public void testGetFoodReturnsCorrectList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(expectedFood);
        cat = new Cat(mockFeline);

        Assert.assertEquals("Ожидался список еды хищника", expectedFood, cat.getFood());
    }



    //Тесты метода getSound()
    @Test
    public void getSoundReturnsCorrectString() {
        String expectedString = "Мяу";
        cat = new Cat(feline);
        Assert.assertEquals("Кот должен издавать 'Мяу'", expectedString, cat.getSound());

    }
}
