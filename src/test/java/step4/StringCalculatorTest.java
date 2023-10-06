package step4;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    void test_1(){
        step4.StringCalculator obj = new step4.StringCalculator();
        int sum = obj.add("1,2,3,4");
        assertEquals(10, sum);
    }
    @Test
    void test_2(){
        step4.StringCalculator obj = new step4.StringCalculator();
        int sum = obj.add("");
        assertEquals(0, sum);
    }
    @Test
    void test_3(){
        step4.StringCalculator obj = new step4.StringCalculator();
        int sum = obj.add("1\n2,3");
        assertEquals(6, sum);
    }
    @Test
    void test_4(){
        step4.StringCalculator obj = new step4.StringCalculator();
        int sum = obj.add("1000, -20");
        assertEquals(980, sum);
    }
    @Test
    void test_5(){
        step4.StringCalculator obj = new step4.StringCalculator();
        int sum = obj.add("1,\n");
        assertEquals(0, sum);
    }
    @Test
    void test_6(){
        step4.StringCalculator obj = new step4.StringCalculator();
        int sum = obj.add("wdfg");
        assertEquals(0, sum);
    }
    @Test
    void test_7(){
        step4.StringCalculator obj = new step4.StringCalculator();
        int sum = obj.add("1,");
        assertEquals(0, sum);
    }
    @Test
    void test_8(){
        step4.StringCalculator obj = new step4.StringCalculator();
        int sum = obj.add("1\n");
        assertEquals(0, sum);
    }
    @Test
    void test_9(){
        step4.StringCalculator obj = new step4.StringCalculator();
        int sum = obj.add("//;\n1;2");
        assertEquals(3, sum);
    }
    @Test
    void test_10(){
        step4.StringCalculator obj = new step4.StringCalculator();
        int sum = obj.add("//*\n1*2,4\n5");
        assertEquals(12, sum);
    }
    @Test
    void test_11(){
        step4.StringCalculator obj = new step4.StringCalculator();
        int sum = obj.add("\n");
        assertEquals(0, sum);
    }
    @Test
    void test_12(){
        step4.StringCalculator obj = new step4.StringCalculator();
        int sum = obj.add(",");
        assertEquals(0, sum);
    }
}
