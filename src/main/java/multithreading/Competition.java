package multithreading;

/**
 * Created by Meyttt on 04.10.2017.
 */
public class Competition {
}
class Compute implements Runnable{
    Double[] nums;
    int maxCount=1000;

    public Compute(Double[] nums) {
        this.nums = nums;
    }

    @Override
    public void run() {

    }
}
