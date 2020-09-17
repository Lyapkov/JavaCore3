package Lesson7;

import Lesson7.Annotations.AfterSuite;
import Lesson7.Annotations.BeforeSuite;
import Lesson7.Annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        testRun(TestClass.class);
    }

    private static void testRun(Class cl) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = cl.getMethods();
        boolean isAfter = false;
        boolean isBefore = false;
        Method after = findAfter(methods);
        Method before = findBefore(methods);
        Method[] methodsRun = sortMethod(methods);

        for (Method method: methodsRun) {
            before.invoke(null);
            method.invoke(null);
            after.invoke(null);
        }
    }

    private static Method findBefore(Method[] methods) {
        boolean isBefore = false;
        Method before = null;
        for (Method method: methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (isBefore)
                    throw new RuntimeException();
                before = method;
                isBefore = true;
            }
        }
        if (isBefore)
            throw new RuntimeException();
        return before;
    }

    private static Method findAfter(Method[] methods) {
        boolean isAfter = false;
        Method after = null;
        for (Method method: methods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (isAfter)
                    throw new RuntimeException();
                after = method;
                isAfter = true;
            }
        }
        if (isAfter)
            throw new RuntimeException();
        return after;
    }

    private static Method[] sortMethod(Method[] methods) {
        int countMethods = 0;
        for (Method method: methods) {
            if (method.isAnnotationPresent(Test.class)) {
                countMethods++;
            }
        }

        Method[] methodsRun = new Method[countMethods];

        int counter = 0;
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(Test.class)) {
                methodsRun[counter] = methods[i];
                counter++;
            }
        }

        Method itMethod = null;
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < methodsRun.length; i++) {
                if (methodsRun[i].getAnnotation(Test.class).priority() < methodsRun[i - 1].getAnnotation(Test.class).priority()) {
                    itMethod = methodsRun[i];
                    methodsRun[i] = methodsRun[i - 1];
                    methodsRun[i - 1] = itMethod;
                    needIteration = true;
                }
            }
        }
        return methodsRun;
    }

}
