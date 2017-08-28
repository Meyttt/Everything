package multithreading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Meyttt on 17.08.2017.
 */
public class PoetThread implements Runnable {
    SynchronousQueue synchronousQueueGet;
    SynchronousQueue synchronousQueuePut;

    public PoetThread(SynchronousQueue synchronousQueueGet, SynchronousQueue synchronousQueuePut) {
        this.synchronousQueueGet = synchronousQueueGet;
        this.synchronousQueuePut = synchronousQueuePut;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        try {

            bufferedReader = new BufferedReader(new FileReader("data/hamlet.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true){
           try {
               int b= (int) synchronousQueueGet.take();
               b=0;
               System.out.println( bufferedReader.readLine());
               Thread.sleep(1000);
               synchronousQueuePut.put(0);
           } catch (IOException e) {
               try {
                   bufferedReader.close();
                   break;
               } catch (IOException e1) {
                   e1.printStackTrace();
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }

    }
}
