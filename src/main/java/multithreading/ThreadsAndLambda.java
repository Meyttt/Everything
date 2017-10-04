package multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Meyttt on 27.09.2017.
 */
public class ThreadsAndLambda {
    public static void main(String[] args) throws InterruptedException {

        List<Callable<String>> calls = Arrays.asList(
                ()->"Result of first",
                ()->"Result of second",
                ()->"Result of third"
        );
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.invokeAll(calls).stream().map(stringFuture ->{
                    try {
                        return stringFuture.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

        );

    }
}
