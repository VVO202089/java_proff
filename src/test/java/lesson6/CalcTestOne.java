package lesson6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalcTestOne {

    private int[] inMas;
    private int[] outMas;

    //private Calc main;

    public CalcTestOne(int[] inMas, int[] outMas) {
        this.inMas = inMas;
        this.outMas = outMas;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> dataForTest(){
        return Arrays.asList(new Object[][]{
                {new int[]{1, 4, 3, 4, 2, 1, 4, 1, 6}, new int[]{1, 6}},
                {new int[]{4, 2, 2, 7, 9, 5, 2, 2, 2, 1}, new int[]{2, 2, 7, 9, 5, 2, 2, 2, 1}},
                {new int[]{1, 3, 7, 5, 4, 4, 3, 2, 7, 9, 1}, new int[]{3, 2, 7, 9, 2}},
        });
    }

    @Test
    public void testCompilation() throws RuntimeException{
        Assert.assertArrayEquals(outMas,Calc.compilation(inMas));
    }

}