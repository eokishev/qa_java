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
    @Mock
    Feline feline;
    Lion lion;

    @Before
    public void createLion() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void successGetFoodLionWithMock() throws Exception {
        List<String> result = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(result);
        List<String> food = lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
        Assert.assertEquals(result, food);
    }

    @Test
    public void successGetKittensLionWithMock() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int kittens = lion.getKittens();
        Mockito.verify(feline).getKittens();
        Assert.assertEquals(1, kittens);
    }

    @Test
    public void successDoesHaveManeLion() {
        boolean hasMane = lion.doesHaveMane();
        Assert.assertTrue(hasMane);
    }
}
