package step7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    void test(){
        step7.StringCalculator obj = new step7.StringCalculator();
        assertEquals(10, obj.add("1,2,3,4"));
        assertEquals(0, obj.add(""));
        assertEquals(6, obj.add("1\n2,3"));
        assertEquals(0, obj.add("120, -34"));
        assertEquals(0, obj.add("1,\n"));
        assertEquals(0, obj.add("wdfg"));
        assertEquals(0, obj.add("1,"));
        assertEquals(0, obj.add("1\n"));
        assertEquals(3, obj.add("//;\n1;2"));
        assertEquals(12, obj.add("//*\n1*2,4\n5"));
        assertEquals(0, obj.add("\n"));
        assertEquals(0, obj.add(","));
        assertEquals(0, obj.add("//;\n-34,56\n-234\n9;-1"));
        assertEquals(0, obj.add("//;\n-34,76\n"));
        assertEquals(1999, obj.add("1000, 999, 1001"));
        assertEquals(2000, obj.add("//;\n1000;999\n1001, 1"));
        assertEquals(23, obj.add("//n\n4n8,9\n2"));
        assertEquals(6, obj.add("//*%\n1*2%3"));
        assertEquals(11, obj.add("//*\n3***2*1**5"));
        assertEquals(11, obj.add("//*\n3***2*1**5"));
        assertEquals(17, obj.add("//;\n3,5;2\n7"));
        assertEquals(18, obj.add("//)\n4)3)2,9"));

    }
}
