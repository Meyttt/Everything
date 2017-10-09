package aboutStreams;


import bookSimples.Array;
import jnr.ffi.annotations.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Meyttt on 05.10.2017.
 */
public class SimpleStreams {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[]{3,8,1,19,20,4,6,2,7}));
        Stream<Integer> stream=list.stream();

        stream.forEach((n)-> System.out.print(n+"; "));
        System.out.println();
        System.out.println();

        stream=list.stream();
        Optional<Integer> min= stream.min(Integer::compare);
        if(min.isPresent()) {
            System.out.println(min.get());
        }
        System.out.println();

        stream=list.stream();
        Optional<Integer> max = stream.max(Integer::compare);
        if(max.isPresent()){
            System.out.println(max.get());
        }
        System.out.println();

        stream=list.stream();
        stream.sorted(Integer::compare).forEach((n)-> System.out.print(n+"; "));
        System.out.println();
        System.out.println();

        stream=list.stream();
        stream.sorted(Integer::compare).filter((n)->n%2==0).forEach((n)-> System.out.print(n+"; "));
        System.out.println();
        System.out.println();

        stream=list.stream();
        stream.sorted(Integer::compare).filter((n)->n%2==0).filter((n)->n>5).forEach((n)-> System.out.print(n+"; "));

        stream=list.stream();
        ArrayList<Integer> newList = new ArrayList<>();
//        stream.reduce((n)->newList.contains(n));
    }
}
