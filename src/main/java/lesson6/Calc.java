package lesson6;

import java.util.Arrays;

public class Calc {

    public static void main(String[] args) {

        //6.2
        int[] mas = {1,2,3,4,5,6,4,8,7};
        int[] result = compilation(mas);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        //6.3
        System.out.println(checkMas(mas));
    }

    public static int[] compilation(int[] mas) throws RuntimeException {

        boolean found = false;

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == 4){
                found = true;
                break;
            }
        }
        if (!found){
           throw new RuntimeException("Цифра 4 отсутствует в массиве");
        }
        // получим индекс, где последний раз встречается цифра 4
        int indexFour = getLastIndex(mas,4);
        // создадим новый массив, согласно задания
        return Arrays.copyOfRange(mas,indexFour + 1,mas.length);
    }

    private static int getLastIndex(int[] mas, int s) {

        int index = -1;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == s){
                index = i;
            }
        }
        return index;
    }

    public static boolean checkMas(int[] mas){

        boolean checkfour = false;
        boolean checkOne = false;

        for (int i = 0; i < mas.length; i++) {

            if (mas[i] == 1){
                checkOne = true;
                break;
            }
        }

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == 4){
                checkfour = true;
                break;
            }
        }
        return checkOne&checkfour;
    }
}
