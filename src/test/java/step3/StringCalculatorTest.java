package step3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    void test_1(){
        step3.StringCalculator obj = new step3.StringCalculator();
        int sum = obj.add("1,2,3,4");
        assertEquals(10, sum);
    }
    @Test
    void test_2(){
        step3.StringCalculator obj = new step3.StringCalculator();
        int sum = obj.add("");
        assertEquals(0, sum);
    }
    @Test
    void test_3(){
        step3.StringCalculator obj = new step3.StringCalculator();
        int sum = obj.add("1\n2,3");
        assertEquals(6, sum);
    }
    @Test
    void test_4(){
        step3.StringCalculator obj = new step3.StringCalculator();
        int sum = obj.add("1000, -20");
        assertEquals(980, sum);
    }
    @Test
    void test_5(){
        step3.StringCalculator obj = new step3.StringCalculator();
        int sum = obj.add("1,\n");
        assertEquals(0, sum);
    }
    @Test
    void test_6(){
        step3.StringCalculator obj = new step3.StringCalculator();
        int sum = obj.add("wdfg");
        assertEquals(0, sum);
    }
    @Test
    void test_7(){
        step3.StringCalculator obj = new step3.StringCalculator();
        int sum = obj.add("1,");
        assertEquals(0, sum);
    }
    @Test
    void test_8(){
        step3.StringCalculator obj = new step3.StringCalculator();
        int sum = obj.add("1\n");
        assertEquals(0, sum);
    }


}