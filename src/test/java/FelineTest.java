import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Список доступной еды не соответствует ожидаемому", feline.eatMeat(), expectedFood);
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        Assert.assertEquals("Семейство не соответствует ожидаемому", "Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTest() {
       Feline feline = new Feline();
       int expectedValue = 1;
       Assert.assertEquals("Количество котят не соответствует ожидаемому", expectedValue, feline.getKittens());
    }

    @Test
    public void getKittensWithArgTest() {
        Feline feline = new Feline();
        int expected = 2;
        Assert.assertEquals(
                "Результат работы метода не соответствует заявленному параметру",
                expected,
                feline.getKittens(expected)
        );
    }
}
