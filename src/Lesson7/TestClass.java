package Lesson7;

import Lesson7.Annotations.AfterSuite;
import Lesson7.Annotations.BeforeSuite;
import Lesson7.Annotations.Test;

public class TestClass {

    @BeforeSuite
    public static void beforeTest() {
        System.out.println("Предварительный тест");
    }

    @AfterSuite
    public static void afterTest() {
        System.out.println("Заключительный тест");
    }

    @Test(priority = 1)
    public static void testNumber1() {
        System.out.println("Тест 1");
    }

    @Test(priority = 2)
    public static void testNumber2() {
        System.out.println("Тест 2");
    }

}
