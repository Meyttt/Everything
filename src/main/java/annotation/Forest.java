package annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * Created by Meyttt on 19.09.2017.
 */
public class Forest {
    @complexity(value = 10)
    public plants findTree(){

        return plants.Tree;
    }
    @complexity(50)
    plants findFlower(){return plants.flower;}
    @isNeeded
    @complexity(value = 30)
    plants findMushroom(){return plants.mushroom;}


    public static void main(String[] args) throws NoSuchMethodException {
        Forest forest=new Forest();
        System.out.println(forest.findTree());
        Class<?> mainClass = forest.getClass();
        Method finder=mainClass.getMethod("findTree");
        System.out.println(finder.getAnnotation(complexity.class));
    }
}
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface complexity{
    int value() default 100;
}
enum plants{
    Tree, mushroom, flower;
}
@Retention(RetentionPolicy.RUNTIME)
@interface isNeeded{}//todo: перевод