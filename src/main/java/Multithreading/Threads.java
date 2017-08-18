package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Meyttt on 17.08.2017.
 */
public class Threads {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue();
        SynchronousQueue<Integer> queue2 = new SynchronousQueue();
        CounterThread counterThread = new CounterThread(queue,queue2);
        PoetThread poetThread = new PoetThread(queue2,queue);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(counterThread);
        executorService.execute(poetThread);
        queue.put(0);

    }
}
