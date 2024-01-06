package dynamicproxy.reflect;

import java.lang.reflect.Method;

public class DeclareTest {

    public static void main(String[] args) {
        try {
            declareMethodTest();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void declareMethodTest() throws NoSuchMethodException {
        Method toString = String.class.getMethod("hashCode");
        // 这里返回的是String类而非Object类
        System.out.println(toString.getDeclaringClass());
        Object o = new Object();
        Method hashCode = o.getClass().getMethod("hashCode");
        System.out.println(hashCode.getDeclaringClass());
    }

}
