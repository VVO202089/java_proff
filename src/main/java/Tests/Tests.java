package Tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tests {

    public static void main(String[] args) {
        try{
            return;
        }finally {
            System.out.println("Finally");
        }
        /*Tests tests = new Tests();
        try {
            new Thread(() -> tests.myMethod1()).start();
            new Thread(() -> tests.myMethod1()).start();
            new Thread(() -> tests.meMethod2()).start();
        }catch (NullPointerException| IOException e){
            e.printStackTrace();
        }*/
    }

    public synchronized void myMethod1() {
        System.out.println("my method 1 start");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("my method 1 end");
    }

    public synchronized void meMethod2() {
        System.out.println("my method 2 start");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
