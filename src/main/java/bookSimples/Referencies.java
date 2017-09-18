package bookSimples;

import sun.nio.cs.ext.IBM037;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Meyttt on 31.08.2017.
 */
public class  Referencies{
    void change(int i){i+=1;}
    void change(List<Integer> list){list.add(1);}

    public static void main(String[] args) {
        int i=0;
        Referencies referencies = new Referencies();
        referencies.change(i);
        System.out.println(i);

        LinkedList<Integer> integers = new LinkedList<>();
        System.out.println(integers);
        referencies.change(integers);
        System.out.println(integers);

        /*
        Примитивные типы передаются по значению. Иначе говоря, в методе происходит работа со значением по ссылке, а не самой сылкой.
        Ссылочные типы же передаются по ссылке. Все операции проводятся по ссылке и изменяют объект.
        Примитивы как бы копируют содержимое и изменяют только копию, ссылочные - работают с оригиналом.
         */
    }
}
