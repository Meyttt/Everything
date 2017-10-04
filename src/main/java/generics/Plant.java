package generics;

import java.lang.management.PlatformLoggingMXBean;

/**
 * Created by Meyttt on 22.09.2017.
 */
public class Plant {
    String color;
}
interface Planteble{
    default boolean canPlant(){
        return true;
    }
}
class Flower extends Plant implements Planteble{

}
class Tree extends Plant{}
class Shrub extends Plant implements Planteble{}

