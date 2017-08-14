package catLoader;

import java.util.ServiceLoader;

/**
 * Created by Meyttt on 14.08.2017.
 */
public class Loaders {
    public static void main(String[] args) {
        ServiceLoader<Cat> cats = ServiceLoader.load(Cat.class);
        for (Cat cat:cats){
            System.out.println(cat.getName());
        }
    }


}
interface Cat{
    String getName();
}
interface PrettyCat extends Cat{
    String getPrettyName();
}
interface AwesomeCat extends Cat{
    String getAwesomeName();
}

