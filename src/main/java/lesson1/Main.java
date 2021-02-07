package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //1. Написать метод, который меняет два элемента массива местами
        // (массив может быть любого ссылочного типа);
        Integer[] intArray = new Integer[2];
        intArray[0] = 2;
        intArray[1] = 3;
        // строковое представление массива (до изменений)
        System.out.println(Arrays.deepToString(intArray));
        swap(intArray,0,1);
        // строковое представление массива (после изменений)
        System.out.println(Arrays.deepToString(intArray));
        //2. Написать метод, который преобразует ArrayList  в массив
        ArrayList<Integer> arrList = toArrayList(intArray);
        // 3. работа с фруктами
        // создадим фрукты
        // яблоки
        Apple ap1 = new Apple(1);
        Apple ap2 = new Apple(2);
        Apple ap3 = new Apple(3);
        // апельсины
        Orange or1 = new Orange(4);
        Orange or2 = new Orange(5);
        Orange or3 = new Orange(6);
        // создадим коробки
        Box<Apple> box1 = new Box<Apple>(ap1,ap2,ap3);
        Box<Orange> box2 = new Box<Orange>(or1,or2,or3);

        System.out.println((box1.compare(box2))?"Коробки одинакового веса":"Коробки отличаются по весу");

        //пересыпка
        Box<Orange> box3 = new Box<Orange>();
        box2.poureOver(box3);
    }

    private static <T> ArrayList<T> toArrayList(T[] intArray) {
        return new ArrayList<T>(Arrays.asList(intArray));
    }

    private static void swap(Integer[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
