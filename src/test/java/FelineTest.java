import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline felineSpy;

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(
                "Список доступной еды не соответствует ожидаемому",
                expectedFood,
                felineSpy.eatMeat()
        );
        Mockito.verify(felineSpy).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        Assert.assertEquals("Семейство не соответствует ожидаемому", "Кошачьи", felineSpy.getFamily());
    }

    @Test
    public void getKittensTest() {
        Feline felineSpy = Mockito.spy(new Feline());
        int expectedValue = 1;
        Assert.assertEquals(
                "Количество котят не соответствует ожидаемому",
                expectedValue,
                felineSpy.getKittens()
        );
        Mockito.verify(felineSpy).getKittens(1);
    }

    @Test
    public void getKittensWithArgTest() {
        int expected = 2;
        Assert.assertEquals(
                "Результат работы метода не соответствует заявленному параметру",
                expected,
                felineSpy.getKittens(expected)
        );
    }
}
