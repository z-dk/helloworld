package jdk9to11;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Jdk9NewFeatures {
    public static void main(String[] args) throws IOException {
        // collectionFactoryTest();
        // privateMethodInterface();
        // processAPI();
        // streamAPI();
        optionalAPI();
    }

    /**
     * Java 9 List，Set 和 Map 接口中，新的静态工厂方法可以创建这些集合的不可变实例。
     * 之前的方式:set = Collections.unmodifiableSet(set);
     */
    public static void collectionFactoryTest() {
        var set = Set.of("set1", "set2");
        System.out.println(set);

        // set为不可变集合,这里新增元素会抛出异常:java.lang.UnsupportedOperationException
        // set.add("e");

        Map<String, String> map = Map.of("A","Apple","B","Boy","C","Cat");
        System.out.println(map);

        // 之前的不可变类实现方式
        // Collections.unmodifiableList(new ArrayList())
    }

    /**
     * 在 Java 9 中，一个接口中能定义如下几种变量/方法：
     * 常量
     * 抽象方法
     * 默认方法
     * 静态方法
     * 私有方法(新)
     * 私有静态方法(新)
     */
    final static class MySqlLogging implements Logging {}
    public static void privateMethodInterface() {
        MySqlLogging mySqlLogging = new MySqlLogging();
        mySqlLogging.logInfo("this is MySql Log");
    }

    /**
     * Java9 改进的进程API
     * @throws IOException io异常
     */
    public static void processAPI() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        String np = "Not Present";
        Process p = pb.start();
        ProcessHandle.Info info = p.info();
        System.out.printf("Process ID : %s%n", p.pid());
        System.out.printf("Command name : %s%n", info.command().orElse(np));
        System.out.printf("Command line : %s%n", info.commandLine().orElse(np));

        var infoInstant = info.startInstant().map(i -> i.atZone(ZoneId.systemDefault()).toLocalDateTime().toString()).orElse(np);
        System.out.printf("Start time: %s%n", infoInstant);

        var infoArguments = info.arguments().map(i -> Stream.of(i).collect(Collectors.joining(" "))).orElse(np);
        System.out.printf("Arguments : %s%n", infoArguments);

        System.out.printf("User : %s%n", info.user().orElse(np));
    }

    /**
     * takeWhile() 方法使用一个断言作为参数，返回给定 Stream 的子集直到断言语句第一次返回 false。如果第一个值不满足断言条件，将返回一个空的 Stream。
     * takeWhile() 方法在有序的 Stream 中，takeWhile 返回从开头开始的尽量多的元素；
     * 在无序的 Stream 中，takeWhile 返回从开头开始的符合 Predicate 要求的元素的子集。
     * 输出:
     * takeWhile:abc
     * dropWhile:efhi
     * iterator:369
     * ofNullable:0
     */
    public static void streamAPI() {
        System.out.print("takeWhile:");
        Stream.of("a","b","c","","e","f").takeWhile(s->!s.isEmpty()).forEach(System.out::print);

        System.out.print("\ndropWhile:");
        Stream.of("a","b","c","","e","f","","h","i").dropWhile(s->!s.isEmpty()).forEach(System.out::print);

        System.out.print("\niterator:");
        IntStream.iterate(3, x -> x < 10, x -> x + 3).forEach(System.out::print);
    
        System.out.print("\nofNullable:");
        System.out.println(Stream.ofNullable(null).count());
    }

    /**
     * 输出:
     * [A, B]
     * Not Present.
     * Present Value:A
     * Not Present.
     * Present Value:B
     * Optional[Not Present.]
     * Optional[A]
     * Optional[Not Present.]
     * Optional[B]
     */
    public static void optionalAPI() {
        List<Optional<String>> optionalList = Arrays.asList (Optional.empty(), Optional.of("A"), Optional.empty(), Optional.of("B"));
        
        // stream
        List<String> stringList = optionalList.stream().flatMap(Optional::stream).collect(Collectors.toList());
        System.out.println(stringList);

        // ifPresentOrElse
        optionalList.forEach(optional -> optional.ifPresentOrElse(o -> System.out.println("Present Value:" + o), 
            () -> System.out.println("Not Present.")));

        // or
        optionalList.forEach(optional -> System.out.println(optional.or(() -> Optional.of("Not Present."))));
    }

    public static void computableFutureAPI() {
        CompletableFuture<String> future = new CompletableFuture<>();

        CompletableFuture.delayedExecutor(5, TimeUnit.SECONDS);
        future.completeOnTimeout("timeout value", 30, TimeUnit.SECONDS);

        CompletableFuture.failedStage(new RuntimeException());

        

        future.newIncompleteFuture();
    }
}