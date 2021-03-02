
package lesson7;

import lesson7.ann.AfterSuite;
import lesson7.ann.BeforeSuite;
import lesson7.ann.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TestClass {

    public static <T> void start(Class<T> tClass) {
        performTest(tClass);
    }

    private static <T> void performTest(Class<T> tClass) throws RuntimeException {

        TestClass testingObject;

        try {
            // получаем конструктор
            testingObject = (TestClass) tClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Method beforeMethod = null;
        Method afterMethod = null;
        // получаем методы
        Method[] methods = tClass.getMethods();
        // массив приоритетов
        List<MethodsPriority> testingMethods = new ArrayList<>();

        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (beforeMethod != null) {
                    throw new RuntimeException("@BeforeSuite присутствует более чем в 1 экземпляре");
                }
                beforeMethod = method;
            } else if (method.getAnnotation(AfterSuite.class) != null) {
                if (afterMethod != null) {
                    throw new RuntimeException("@AfterSuite присутствует более чем в 1 экземпляре");
                }
                afterMethod = method;
            } else if (method.getAnnotation(Test.class) != null) {
                Test annotationTst = method.getAnnotation(Test.class);
                testingMethods.add(new MethodsPriority(method, annotationTst.priority()));
            }

            testingMethods.sort(Comparator.comparing(MethodsPriority::getPriority));

            try {
                if (beforeMethod != null) {
                    beforeMethod.invoke(testingObject);
                }
                for (MethodsPriority methodsPriority : testingMethods) {
                    methodsPriority.method.invoke(testingObject);
                }
                if (afterMethod != null) {
                    afterMethod.invoke(testingObject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @BeforeSuite
    public void beforeAll() {
        System.out.println("Метод выполняется до тестов");
    }

    @Test(priority = 3)
    public void thirdTest() {
        System.out.println("Приоритет №3");
    }

    @Test(priority = 2)
    public void secondTest() {
        System.out.println("Приоритет №2");
    }

    @Test(priority = 5)
    public void fightTest()
    {
        System.out.println("Приоритет №5");
    }

    @Test(priority = 4)
    public void fourthTest() {
        System.out.println("Приоритет №4");
    }

    @Test(priority = 7)
    public void sevenTest() {
        System.out.println("Приоритет №7");
    }

    @AfterSuite
    public void afterAll() {
        System.out.println("Метод выполняется после теста");
    }
}
