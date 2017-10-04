package generics;

import java.util.ArrayList;

/**
 * Created by Meyttt on 22.09.2017.
 */
public class Greenhouse {
    void wash(Class<? extends Plant> plant){
        System.out.println("I've wash "+plant);
    }
    static <T extends Planteble> void plant (T plant){
        System.out.println("I've plant "+plant);
    }
    public static void main(String[] args) {
        plant(new Flower());
    }
    //МЕТАСИМВОЛЬНЫЙ АРГУМЕНТ ИСПОЛЬЗОВАТЬ ДЛЯ ВЛОЖЕННОЙ ТИПИЗАЦИИ
    //public <T extends Number> void printArray(ArrayList<T extends Number>)
}
