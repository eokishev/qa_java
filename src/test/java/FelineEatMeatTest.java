import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class FelineEatMeatTest {
    private final String animalKind;
    private final List<String> food;

    public FelineEatMeatTest(String animalKind, List<String> food) {
        this.animalKind = animalKind;
        this.food = food;
    }

    @Parameterized.Parameters
    public static Object[][] animalKind() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void successGetFoodWithDifferentAnimalKind() throws Exception {
        Feline feline = new Feline();
        List<String> result = feline.getFood(animalKind);
        Assert.assertEquals(food, result);
    }
    public static class FelineExceptionTest {

        @Test
        public void UnknownAnimalKindException() {
            Feline feline = new Feline();
            try {
                feline.getFood("Неизвестно");
                Assert.fail("Ожидается, что будет выдано исключение");
            } catch (Exception e) {
                Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
            }
        }
    }
}