package lesson6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalcTestTwo {

    private int[] in;
    private boolean out;

    public CalcTestTwo(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> dataForTest(){
        return Arrays.asList(new Object[][]{
                {new int[]{1, 4, 3, 4, 2, 1, 4, 1, 6}, false},
                {new int[]{4, 2, 2, 7, 9, 5, 2, 2, 2, 1}, true},
                {new int[]{1, 3, 7, 5, 4, 4, 3, 2, 7, 9, 1}, true},
        });
    }

    @Test
    public void testCheskMas(){
        Assert.assertEquals(Calc.checkMas(in),out);
    }

}