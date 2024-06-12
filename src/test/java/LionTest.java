import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        int expectedValue = 1;
        Mockito.when(feline.getKittens()).thenReturn(expectedValue);
        Assert.assertEquals("Количество котят не соответствует ожидаемому", expectedValue, lion.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        String predator = "Хищник";
        Mockito.when(feline.getFood(predator)).thenReturn(expectedFood);
        Assert.assertEquals("Список доступной еды не соответствует ожидаемому", lion.getFood(), expectedFood);
        Mockito.verify(feline, Mockito.times(1)).getFood(predator);
    }

    @Test
    public void exceptionalTest() {
        Assert.assertThrows(
                "Метод не выбросил ожидаемое исключение",
                Exception.class,
                () -> new Lion(feline, "Некорретный пол")
        );
    }
}
