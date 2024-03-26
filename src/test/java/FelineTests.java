import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {
    @Spy
    Feline feline = new Feline();

    @Test
    public void successGetFamilyFeline() {
        String family = feline.getFamily();
        Assert.assertEquals("Кошачьи", family);
    }

    @Test
    public void successGetKittensFelineWithoutCount() {
        int kittens = feline.getKittens();
        Mockito.verify(feline).getKittens(1);
        Assert.assertEquals(1, kittens);
    }

    @Test
    public void successGetKittensFelineWithCount() {
        int count = feline.getKittens(2);
        Assert.assertEquals(2, count);
    }

    @Test
    public void successEatMeatFeline() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        List<String> result = feline.eatMeat();
        Assert.assertEquals(food, result);
    }
}
