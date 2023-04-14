package thread.future;

import java.util.concurrent.CompletableFuture;

public class CompletableTest {

    public static void main(String[] args) {
        CompletableFuture<Integer> numFuture = CompletableFuture.supplyAsync(() -> 5);

    }




}
