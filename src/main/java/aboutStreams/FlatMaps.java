package aboutStreams;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Meyttt on 05.10.2017.
 */
public class FlatMaps {

    public static void main(String[] args) throws NoSuchMethodException {
        ArrayList<Flower> flowers = new ArrayList<>(Arrays.asList(new Flower[]{
                new Flower("rose","red"),
                new Flower("peony","white"),
                new Flower("sunflower","yellow"),
                new Flower("cornflower","blue"),
                new Flower("lily","white")
        }));

        flowers.stream().forEach((p)-> System.out.println(p));

        Stream<Stream<String>> stream=flowers.stream().map((p)->Stream.of(p.getName(),p.getColor()));

        flowers.stream().flatMap((p)-> Stream.of(p.getName(),p.getColor())).forEach((p)-> System.out.println(p));

        System.out.println(Math.ceil(1.208));
        System.out.println(Math.ceil(12.6608));

        List<Flower> flowerList= flowers.stream().collect(Collectors.toList());

        flowers.parallelStream().filter((n)->n.getColor().equals("white")).collect(()->new ArrayList<>(),
                (list,element)->list.add(element),
                (listA,listB)->listA.addAll(listB)).forEach(n-> System.out.println(n));

        HashSet<Flower> flowerHashSet= flowerList.parallelStream().collect(HashSet::new,HashSet::add,HashSet::addAll);
        flowerHashSet.forEach((f)-> System.out.println(f));

        Constructor<HashSet> function=HashSet.class.getConstructor();

//        HashSet<Flower> flowerHashSet1=flowerList.parallelStream().collect(function,HashSet::add,HashSet::addAll);





    }
}
class Flower{
    @Override
    public String toString() {
        return this.getName()+": "+this.getColor()+"; ";
    }

    String name;
    String color;

    public Flower(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
