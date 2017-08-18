package Multithreading;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by Meyttt on 17.08.2017.
 */
public class CounterThread implements Runnable{
    SynchronousQueue synchronousQueueGet;
    SynchronousQueue synchronousQueuePut;

    public CounterThread(SynchronousQueue synchronousQueueGet, SynchronousQueue synchronousQueuePut) {
        this.synchronousQueueGet = synchronousQueueGet;
        this.synchronousQueuePut = synchronousQueuePut;
    }

    @Override
    public void run() {
        Long counter = new Long("0");
        while(true){
            try {
                int a= (int) synchronousQueueGet.take();
                a=0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(++counter);
            try {
                synchronousQueuePut.put(counter.intValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
