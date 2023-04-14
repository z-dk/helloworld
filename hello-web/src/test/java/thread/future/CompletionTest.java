package thread.future;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletionTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletionService<String> service = new ExecutorCompletionService<>(executorService);
        service.submit(() -> "5");
        service.take();

        executorService.shutdown();
    }

}
