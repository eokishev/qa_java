import com.example.Alex;
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
public class AlexTests {
    @Mock
    Feline feline;
    Alex alex;

    @Before
    public void createAlex() throws Exception {
        alex = new Alex(feline);
    }

    @Test
    public void successGetFriendsAlex() {
        List<String> friends = List.of("Марти", "Глория", "Мелман");
        List<String> result = alex.getFriends();
        Assert.assertEquals(friends, result);
    }

    @Test
    public void successGetPlaceOfLivingAlex() {
        String result = alex.getPlaceOfLiving();
        Assert.assertEquals("Нью-Йоркский зоопарк", result);
    }

    @Test
    public void successGetKittensAlex() {
        int alexKittens = 0;
        int result = alex.getKittens();
        Assert.assertEquals(alexKittens, result);
    }

    @Test
    public void successDoesHaveManeAlex() {
        boolean result = alex.doesHaveMane();
        Assert.assertTrue(result);
    }

    @Test
    public void successGetFoodAlexWithMock() throws Exception {
        List<String> result = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(result);
        List<String> food = alex.getFood();
        Mockito.verify(feline).getFood("Хищник");
        Assert.assertEquals(result, food);
    }
}
