package jdk9to11;

import com.alibaba.fastjson.JSON;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("unused")
public class Jdk11NewFeatures {
    public static void main(String[] args) throws InterruptedException {
        /// stringNewAPI();
        // inputStreamAPI();
        clientAPI();
    }

    /**
     * 字符串加强
     */
    public static void stringNewAPI() {
        // 判断是否为空
        System.out.println(" ".isBlank());
        // 去除首尾空格
        System.out.println(" Java ".strip());
        // 去除首空格
        System.out.println(" Java ".stripLeading());
        // 去除尾空格
        System.out.println(" Java ".stripTrailing());
        // 复制字符串
        System.out.println("=Java=".repeat(3));
        // 按行(\n,\r,\r\n三种)分割转为stream流
        var mulLineStr = "java1\njavajjj2\rjava3\r\njava4\n\rjava5";
        System.out.println("[" + mulLineStr + "]\n行数为:" + mulLineStr.lines().count());
    }

    /**
     * InputStream 加强
     * InputStream 新增一个非常有用的方法：transferTo，可以用来将数据直接传输到 OutputStream
     */
    public static void inputStreamAPI() {
        var path = Path.of("D:/Desktop/java11.txt");
        var file = path.toFile();

        try (var out = new FileOutputStream(file); var inputStream = new ByteArrayInputStream("hello world transfer".getBytes())) {
            // 1. InputStream新增transferTo方法,可直接将数据传输到OutputStream
            inputStream.transferTo(out);

            // 2. Files类新增writeString方法,可直接向文件路径中写入字符串
            Files.writeString(path, "write hello world", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * java.net.http包下的 HTTP Client API
     */
    public static void clientAPI() throws InterruptedException {
        var httpClient = HttpClient.newHttpClient();

        // 创建get请求
        var getReq = HttpRequest.newBuilder(URI.create("http://localhost:8080/hello/user/get?id=1"))
                // 这里GET可省略,默认为get请求
                .GET()
                .build();
        
        // post请求参数
        Map<String,String> postParam = new HashMap<>(16);
        postParam.put("pagingFlag", "true");
        postParam.put("page", "1");
        postParam.put("rows", "5");
        
        // 创建post请求
        var postReq = HttpRequest
                .newBuilder()
                .uri(URI.create("http://localhost:8080/hello/user/list"))
                .POST(HttpRequest.BodyPublishers.ofString(JSON.toJSONString(postParam)))
                .setHeader("Content-Type", "application/json")
                .build();

        try {
            // 发送get请求
            HttpResponse<String> getResponse = httpClient.send(getReq, HttpResponse.BodyHandlers.ofString());
            System.out.println(getResponse.body());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 异步发生post请求
        var postResponse = httpClient.sendAsync(postReq, HttpResponse.BodyHandlers.ofString())
                .exceptionally(throwable -> {
                    throwable.printStackTrace();
                    return null;
                });
        System.out.println(postResponse.join().body());

        // 异步发生get请求
        CompletableFuture<HttpResponse<String>> cf = httpClient.sendAsync(getReq, HttpResponse.BodyHandlers.ofString());
        // 等待请求结果的过程交由线程池异步处理
        ExecutorService executor = Executors.newFixedThreadPool(1);
        cf.thenApplyAsync(HttpResponse::body).thenAcceptAsync(System.out::print, executor);

        System.out.println("请求已全部提交");
        while (!cf.isDone()) {
            Thread.sleep(3000L);
        }
    }
}
