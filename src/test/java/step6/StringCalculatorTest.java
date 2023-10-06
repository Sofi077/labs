package step6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    void test_1(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("1,2,3,4");
        assertEquals(10, sum);
    }
    @Test
    void test_2(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("");
        assertEquals(0, sum);
    }
    @Test
    void test_3(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("1\n2,3");
        assertEquals(6, sum);
    }
    @Test
    void test_4(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("120, -34");
        assertEquals(0, sum);
    }
    @Test
    void test_5(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("1,\n");
        assertEquals(0, sum);
    }
    @Test
    void test_6(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("wdfg");
        assertEquals(0, sum);
    }
    @Test
    void test_7(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("1,");
        assertEquals(0, sum);
    }
    @Test
    void test_8(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("1\n");
        assertEquals(0, sum);
    }
    @Test
    void test_9(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("//;\n1;2");
        assertEquals(3, sum);
    }
    @Test
    void test_10(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("//*\n1*2,4\n5");
        assertEquals(12, sum);
    }
    @Test
    void test_11(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("\n");
        assertEquals(0, sum);
    }
    @Test
    void test_12(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add(",");
        assertEquals(0, sum);
    }
    @Test
    void test_13(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("120, -34");
        assertEquals(0, sum);
    }
    @Test
    void test_14(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("//;\n-34,56\n-234\n9;-1");
        assertEquals(0, sum);
    }
    @Test
    void test_15(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("//;\n-34,76\n");
        assertEquals(0, sum);
    }
    @Test
    void test_16(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("1000, 999, 1001");
        assertEquals(1999, sum);
    }
    @Test
    void test_17(){
        step6.StringCalculator obj = new step6.StringCalculator();
        int sum = obj.add("//;\n1000;999\n1001, 1");
        assertEquals(2000, sum);
    }
}
