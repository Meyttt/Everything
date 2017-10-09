package simple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Meyttt on 08.10.2017.
 */
public class Conferention {
    Integer[] integers= (new Random(1)).ints().boxed().toArray(Integer[]::new);
    //todo: аннотации benchmark
    //todo:VM options (useParallelGC )

    public static void main(String[] args) throws IOException {
        /*
        int[] perm = {5,4,3,-1,2,1};
        Stream.iterate(0,i->perm[i]).skip(1).limit(perm.length).forEach(System.out::println);
        Stream.iterate(0,i->perm[i]).limit(perm.length).forEach(System.out::println);
        */
        Map<String,String> userPasswords=null;
        try(Stream<String> stream= Files.lines(Paths.get("data/passwords"))){
            userPasswords=stream.map(str->str.split(":")).collect(Collectors.toMap(arr->arr[0],arr->arr[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(userPasswords);

        Map<String,String> userPasswords1=Stream.of(Files.lines(Paths.get("data/passwords")))
                .flatMap(f->f).map(s->s.split(":")).collect(Collectors.toMap(arr->arr[0],arr->arr[1]));
        System.out.println(userPasswords1);

    }
    OptionalInt getAny(){
        return IntStream.rangeClosed(0,1_000_000).filter((n)->n==1_000_000).findAny();
    }
}
