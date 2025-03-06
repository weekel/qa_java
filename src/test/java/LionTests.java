import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    private Feline feline;
    private Lion lion;

    @Mock
    private Feline mockFeline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    //Тесты конструктора класса Lion
    @Test
    public void testLionConstructorMale() throws Exception {
        lion = new Lion("Самец", feline);
        Assert.assertTrue("У самца должна быть грива", lion.doesHaveMane());
    }

    @Test
    public void testLionConstructorFemale() throws Exception {
        lion = new Lion("Самка", feline);
        Assert.assertFalse("У самки не должно быть гривы", lion.doesHaveMane());
    }

    @Test
    public void testLionConstructorInvalidSexThrowsExeption() {
        Exception exception = null;

        try {
            new Lion("Не указанно", feline);
        } catch (Exception e) {
            exception = e;
        }
        Assert.assertNotNull("Ожидалось исключение при недопустимом поле", exception);
    }



    // Тесты метода getKittens()
    @Test
    public void testGetKittensMethodCalledOnce() throws Exception {
        lion = new Lion("Самец", mockFeline);
        lion.getKittens();
        Mockito.verify(mockFeline, Mockito.times(1)).getKittens();
    }

    @Test
    public void testGetKittensReturnsCorrectValue() throws Exception {
        int expectedKittensCount = 5;
        Mockito.when(mockFeline.getKittens()).thenReturn(expectedKittensCount);
        lion = new Lion("Самец", mockFeline);
        Assert.assertEquals("Количество детенышей должно быть 5",expectedKittensCount, lion.getKittens());
    }



    //Тесты метода doesHaveMane()
    @Test
    public void testDoesHaveManeReturnsTrueForMale() throws Exception {
        lion = new Lion("Самец", feline);
        Assert.assertTrue("У самца должна быть грива", lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeReturnsFalseForFemale() throws Exception {
        lion = new Lion("Самка", feline);
        Assert.assertFalse("У самки не должно быть гривы", lion.doesHaveMane());
    }



    //Тесты метода getFood()
    @Test
    public void getFoodMethodCallsOnce() throws Exception {
        lion = new Lion("Самец", mockFeline);
        lion.getFood();
        Mockito.verify(mockFeline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);
        lion = new Lion("Самец", mockFeline);
        Assert.assertEquals("Ожидался список еды хищника", expectedFood, lion.getFood());
    }

}
