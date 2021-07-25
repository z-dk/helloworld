package jdk9to11;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Jdk10NewFeatures {
    public static void main(String[] args) {
        // varKeyWord();
        // collectionNewAPI();
        // propertiesNewAPI();
        collectionNewAPI();
    }

    /**
     * 输出:
     * [hello，world！, 1, 1.01]
     */
    public static void varKeyWord() {
        // 这里最好带上泛型,否则list就什么都可以装了
        var list = new ArrayList<>();
        list.add("hello，world！");
        list.add(1);
        list.add(1.01);
        System.out.println(list);
    }

    public static void byteArrayOutputStreamAPI() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        
    }

    /**
     * 按照其迭代顺序返回一个不可修改的列表、映射或包含给定集合的元素的集合。
     */
    public static void collectionNewAPI() {
        var list = new ArrayList<String>();
        list.add("hello");
        list.add("world");

        // copyOf返回的集合为不可变,不能增删元素
        var newCopyList = List.copyOf(list);
        // 这里add方法会抛出异常:java.lang.UnsupportedOperationException
        // newCopyList.add("zdk");
        System.out.println(newCopyList);
    }

    /**
     * 新增int入参的构造方法和重载的replace方法
     */
    public static void propertiesNewAPI() {
        // 新增int参数的构造函数,初始化大小,默认为8
        var properties = new Properties(8);
        properties.setProperty("host", "localhost");
        
        // 只有当前值为localhost时才会替换,替换成功返回true
        properties.replace("host", "localhost", "baidu.com");
        System.out.println(properties);
    }

    /**
     * 输出:
     * [hello, world]
     */
    public static void collectorsNewAPI() {
        var list = new ArrayList<String>();
        list.add("hello");
        list.add("world");

        var unmodifiableList = list.stream().collect(Collectors.toUnmodifiableList());
        // 不可修改的list,这里add/remove操作不会抛出异常,但add/remove不会生效
        unmodifiableList.add("hello2");
        System.out.println(unmodifiableList);
    }

}
