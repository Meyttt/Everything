package multithreading;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by Meyttt on 27.09.2017.
 */
public class ExecutorTests {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(()->{
            System.out.println("Hello, world!");
                }
        );
        Callable task = ()->{
            TimeUnit.SECONDS.sleep(5);
            return new Date();
        };
        Future<Date> future= service.submit(task);
        while (!future.isDone());
        System.out.println(future.get(1,TimeUnit.SECONDS));
        stopService(service);

    }
    static void stopService(ExecutorService service){
        try{
            service.shutdown();
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            if(!service.isTerminated()) {
                System.err.println("Service will be stopped hardly!");
            }
            service.shutdownNow();
            System.out.println("Shoutdown finished");
        }
    }
}
