package step5;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    void test_1(){
        step5.StringCalculator obj = new step5.StringCalculator();
        int sum = obj.add("1,2,3,4");
        assertEquals(10, sum);
    }
    @Test
    void test_2(){
        step5.StringCalculator obj = new step5.StringCalculator();
        int sum = obj.add("");
        assertEquals(0, sum);
    }
    @Test
    void test_3(){
        step5.StringCalculator obj = new step5.StringCalculator();
        int sum = obj.add("1\n2,3");
        assertEquals(6, sum);
    }
    @Test
    void test_4(){
        step5.StringCalculator obj = new step5.StringCalculator();
        int sum = obj.add("120, -34");
        assertEquals(0, sum);
    }
    @Test
    void test_5(){
        step5.StringCalculator obj = new step5.StringCalculator();
        int sum = obj.add("1,\n");
        assertEquals(0, sum);
    }
    @Test
    void test_6(){
        step5.StringCalculator obj = new step5.StringCalculator();
        int sum = obj.add("wdfg");
        assertEquals(0, sum);
    }
    @Test
    void test_7(){
        step5.StringCalculator obj = new step5.StringCalculator();
        int sum = obj.add("1,");
        assertEquals(0, sum);
    }
    @Test
    void test_8(){
        step5.StringCalculator obj = new step5.StringCalculator();
        int sum = obj.add("1\n");
        assertEquals(0, sum);
    }
    @Test
    void test_9(){
        step5.StringCalculator obj = new step5.StringCalculator();
        int sum = obj.add("//;\n1;2");
        assertEquals(3, sum);
    }
    @Test
    void test_10(){
        step5.StringCalculator obj = new step5.StringCalculator();
        int sum = obj.add("//*\n1*2,4\n5");
        assertEquals(12, sum);
    }
    @Test
    void test_11(){
        step5.StringCalculator obj = new step5.StringCalculator();
        int sum = obj.add("\n");
        assertEquals(0, sum);
    }
    @Test
    void test_12(){
        step5.StringCalculator obj = new step5.StringCalculator();
        int sum = obj.add(",");
        assertEquals(0, sum);
    }
    @Test
    void test_13(){
        step5.StringCalculator obj = new step5.StringCalculator();
        int sum = obj.add("120, -34");
        assertEquals(0, sum);
    }
    @Test
    void test_14(){
        step5.StringCalculator obj = new step5.StringCalculator();
        int sum = obj.add("//;\n-34,56\n-234\n9;-1");
        assertEquals(0, sum);
    }
    @Test
    void test_15(){
        step5.StringCalculator obj = new step5.StringCalculator();
        int sum = obj.add("//;\n-34,76\n");
        assertEquals(0, sum);
    }
}
