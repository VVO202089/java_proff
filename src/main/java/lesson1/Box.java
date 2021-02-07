package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {

    private ArrayList<T> fruits;

    public Box(T... fruits) {
        this.fruits = new ArrayList<T>(Arrays.asList(fruits));
    }

    // добавление фруктов
    public void add(T... fruits ){
        this.fruits.addAll(Arrays.asList(fruits));
    }
    //удаление фруктов
    public void remove(T... fruits){
        for (T fr:fruits){
            this.fruits.remove(fr);
        }
    }
    // очистка списка фруктов
    public void clear(){
        this.fruits.clear();
    }
    // вес коробки
    public float getWeight(){
        float weight = 0;
        if (this.fruits.size() == 0){
            return weight;
        }
        for (T fr: fruits){
            weight+=fr.getWeight();
        }
        return weight;
    }
    // сравнение коробок
    public boolean compare(Box box){
        return this.getWeight() == box.getWeight();
    }
    // пересыпка из одной коробки в другую
    public void poureOver(Box<? super T> box){
        box.fruits.addAll(this.fruits);
        clear();
    }
}
