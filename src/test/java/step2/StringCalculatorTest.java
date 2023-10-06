package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    void test_1(){
        step2.StringCalculator obj = new step2.StringCalculator();
        int sum = obj.add("1,2,3,4");
        assertEquals(10, sum);
    }
    @Test
    void test_2(){
        step2.StringCalculator obj = new step2.StringCalculator();
        int sum = obj.add("");
        assertEquals(0, sum);
    }
    @Test
    void test_3(){
        step2.StringCalculator obj = new step2.StringCalculator();
        int sum = obj.add("1, 2, 3");
        assertEquals(6, sum);
    }
    @Test
    void test_4(){
        step2.StringCalculator obj = new step2.StringCalculator();
        int sum = obj.add("1000, -20");
        assertEquals(980, sum);
    }
    @Test
    void test_5(){
        step2.StringCalculator obj = new step2.StringCalculator();
        int sum = obj.add("10");
        assertEquals(10, sum);
    }
    @Test
    void test_6(){
        step2.StringCalculator obj = new step2.StringCalculator();
        int sum = obj.add("wdfg");
        assertEquals(0, sum);
    }


}

