package annotAndReflectLection;

import jnr.ffi.annotations.In;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by Meyttt on 08.10.2017.
 */
public class ReflectionSimple {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object ob= "String";
        System.out.println(ob.getClass());

        System.out.println(int.class);

        System.out.println((new Integer[10]).getClass().getCanonicalName());
        System.out.println((new Integer[10]).getClass().getName());
        System.out.println((new Integer[1][10]).getClass().getName());
        System.out.println((new Integer[1][10]).getClass().getSimpleName());
        System.out.println((new Integer[1][10]).getClass().getCanonicalName());
        System.out.println((new int[10]).getClass().getCanonicalName());
        System.out.println((new int[10]).getClass().getCanonicalName());
        System.out.println((new int[10]).getClass().getName());
        System.out.println(new Integer(10).getClass().getSimpleName());


        Stream.of("a","b","c","d");
        Predicate<String> pred=(string -> string.equals("a"));
        System.out.println(pred.getClass().getCanonicalName());
        Object obj = new Object(){};
        System.out.println(obj.getClass().getCanonicalName());//null
        System.out.println(obj.getClass().getName());//annotAndReflectLection.ReflectionSimple$1
        System.out.println(obj.getClass().getSimpleName());//

        Constructor[] constructors= Integer.class.getDeclaredConstructors();
        Constructor constructor2= Integer.class.getDeclaredConstructor(int.class);
        System.out.println(constructor2.newInstance(1));
        System.out.println(String.class.getDeclaredMethod("equals", Object.class).invoke("hello","hello"));
        System.out.println(String.class.getDeclaredMethod("equals", Object.class).invoke("hello","hello"));
        System.out.println(String.class.getDeclaredMethod("valueOf", int.class).invoke(null,1));
        System.out.println(String.class.getDeclaredMethod("valueOf", int.class).invoke(null,1).getClass().getCanonicalName());
        /*
        System.out.println(String.class.getDeclaredMethod("valueOf", int.class).invoke(1));//Exception in thread "main" java.lang.IllegalArgumentException: wrong number of arguments
        */

    }
}
