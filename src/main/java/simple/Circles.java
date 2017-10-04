package simple;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Meyttt on 27.09.2017.
 */
public class Circles {
    public static void main(String[] args) {
        Random random = new Random();
        int i;
        do{
            i=random.nextInt(20);
        }while (i==16);
        System.out.println(i);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ss");
        while (Integer.parseInt(simpleDateFormat.format(new Date()))%2==0);
        System.out.println("Нечетная секунда!");
        while (true);

    }
}
