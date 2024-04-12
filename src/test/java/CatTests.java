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
    @Mock
    Feline feline;
    Cat cat;

    @Before
    public void createCat() {
        cat = new Cat(feline);
    }

    @Test
    public void successGetSoundCat() {
        String sound = cat.getSound();
        Assert.assertEquals( "Мяу",sound);
    }

    @Test
    public void successGetFoodCatWithMock() throws Exception {
        List<String> result = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(result);
        List<String> food = cat.getFood();
        Mockito.verify(feline).eatMeat();
        Assert.assertEquals(result, food);
    }
}
