package jvm;

import org.openjdk.jol.info.ClassLayout;

public class MarkWord {

    public static void main(String[] args) {
        testMarkWord();
    }

    /**
     * 验证对象头markword空间占用
     */
    public static void testMarkWord() {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        //System.out.println(o.hashCode());
        //System.out.println(ClassLayout.parseInstance(o).toPrintable());
        //synchronized (o) {
        //    System.out.println(ClassLayout.parseInstance(o).toPrintable());
        //}
        Long l = 5L;
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
    }

}
