package step1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    void test_1(){
        StringCalculator obj = new StringCalculator();
        int sum = obj.add("1, 2");
        assertEquals(3, sum);
    }
    @Test
    void test_2(){
        StringCalculator obj = new StringCalculator();
        int sum = obj.add(" ");
        assertEquals(0, sum);
    }
    @Test
    void test_3(){
        StringCalculator obj = new StringCalculator();
        int sum = obj.add("1, 2, 3");
        assertEquals(0, sum);
    }
    @Test
    void test_4(){
        StringCalculator obj = new StringCalculator();
        int sum = obj.add("1000, -20");
        assertEquals(980, sum);
    }
    @Test
    void test_5(){
        StringCalculator obj = new StringCalculator();
        int sum = obj.add("10");
        assertEquals(10, sum);
    }


}
