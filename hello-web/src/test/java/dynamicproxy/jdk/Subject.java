package dynamicproxy.jdk;

public interface Subject {
    
    void request();

    /**
     * java8新支持接口内静态方法,该方法为接口使用,无法被实现类覆盖,提高内聚;动态代理同样无法对其进行代理
     */
    static void prepare() {
        System.out.println("I'm a subject interface static method => prepare");
    }
    
}
