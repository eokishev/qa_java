import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class CreateLionObjectTest {
    private final String gender;
    private final String hasMane;
    @Mock
    Feline feline;

    public CreateLionObjectTest(String gender, String hasMane) {
        this.gender = gender;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getGender() {
        return new Object[][]{
                {"Самец", "true"},
                {"Самка", "false"},
                {"Неизвестно", "Используйте допустимые значения пола животного - самец или самка"},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void successCreateLionObjectWithDifferentGender() {
        String result;
        try {
            Lion lion = new Lion(gender, feline);
            result = String.valueOf(lion.doesHaveMane());
        } catch (Exception exception) {
            result = exception.getMessage();
        }
        Assert.assertEquals(hasMane, result);
    }
}
