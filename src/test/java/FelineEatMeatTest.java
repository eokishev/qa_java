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
                {"Неизвестно", List.of("Неизвестный вид животного, используйте значение Травоядное или Хищник")},
        };
    }

    @Test
    public void successGetFoodWithDifferentAnimalKind() {
        List<String> result;
        try {
            Feline feline = new Feline();
            result = feline.getFood(animalKind);
        } catch (Exception exception) {
            result = List.of(exception.getMessage());
        }
        Assert.assertEquals(food, result);
    }
}
