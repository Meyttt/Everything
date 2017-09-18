package interfaces8;

/**
 * Created by Meyttt on 16.09.2017.
 */
public interface DayOfWeek {
    default void sayHello(int day){
        System.out.println("default hello!");
    }
    static void sayGoodBye(){
        System.out.println("Static GoodBye :)");
    }

}
