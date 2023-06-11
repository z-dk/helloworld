package jdk.classload;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader(ClassLoader.getSystemClassLoader());
        Thread.currentThread().setContextClassLoader(myClassLoader);
        Class<?> clazz = Class.forName("zdk.ccc", true, myClassLoader);
    }

    public static void header() {
        String[] str = new String[10];
        //System.out.println(ClassLay.parseInstance(str).toPrintable());
    }

}
