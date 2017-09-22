package simple;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by Meyttt on 20.09.2017.
 */

public class Flower{
    String color;

    public Flower(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    void changeFlower(@ForestFlower Flower this, String newColor){
        this.setColor(newColor);
    }

    public static void main(String[] args) {
        Flower flower= new Flower("pink");
        System.out.println(flower);
        flower.changeFlower("blue");
        System.out.println(flower);

    }
}
@Target({ElementType.TYPE_USE})
@interface ForestFlower{}

