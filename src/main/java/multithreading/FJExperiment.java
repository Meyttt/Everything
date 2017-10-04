package multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Meyttt on 03.10.2017.
 */
public class FJExperiment {
    public static void main(String[] args) {
        //сделать цикл!

        double[] nums = new double[200_000_000];
        for (int j=1;j<20;j++) {
            int sum=0;
            for(int k=0;k<20;k++) {
                ForkJoinPool forkJoinPool = new ForkJoinPool(j);
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = (double) i;
                }
                SqrtTransform sqrtTransform = new SqrtTransform(nums, 0, nums.length - 1);
//        forkJoinPool.invoke(sqrtTransform);
                long before, after;
                before = System.currentTimeMillis();
                forkJoinPool.invoke(sqrtTransform);
                after = System.currentTimeMillis();
                sum += after - before;
            }
            System.out.println("Parallelism: "+j+"; time "+(sum/20));
        }

    }


}
class SqrtTransform extends RecursiveAction{
    int seqThreshold=1000;
    double[] data;
    int start, end;

    public SqrtTransform(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if((end-start)<seqThreshold){
            for (int i=start;i<end;i++){
                data[i]=Math.sqrt(data[i]);
            }
        }else{
            int middle=(end+start)/2;
            invokeAll(new SqrtTransform(data,start,middle),
                    new SqrtTransform(data,middle,end));
        }
    }
}
