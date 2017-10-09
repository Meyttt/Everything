package aboutStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Meyttt on 05.10.2017.
 */
public class Reducers {
    public static void main(String[] args) {
        ArrayList <Double> list= new ArrayList<>(Arrays.asList(
                new Double[]{Double.valueOf(4), Double.valueOf(4), Double.valueOf(4), Double.valueOf(4), Double.valueOf(4),
                Double.valueOf(4), Double.valueOf(4), Double.valueOf(4), Double.valueOf(4), Double.valueOf(4)}));
        Stream<Double> stream=list.parallelStream();
        System.out.println(stream.reduce(Double.valueOf(0),(a, b)->a+Math.sqrt(b)));

        stream=list.parallelStream();
        //Объединение частичных результатов
        System.out.println(stream.reduce(Double.valueOf(1),(a,b)->a*Math.sqrt(b),(a,b)->a*b));

        stream=list.parallelStream();
        //Объединение частичных результатов
        System.out.println(stream.reduce(Double.valueOf(1),(a,b)->a*Math.sqrt(b),(a,b)->a+b));

        stream=list.parallelStream();
        //Объединение частичных результатов
        System.out.println(stream.reduce((a,b)->a*Math.sqrt(b)));

    }
}
