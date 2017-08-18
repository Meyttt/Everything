/**
 * Created by Meyttt on 16.08.2017.
 */
public class Interfaces extends Object{
    String va = "val";

    public static void main(String[] args) {
        Interfaces interfaces= new Interfaces();
        //all false
        System.out.println(interfaces.getClass().isInstance(Object.class));
        System.out.println(interfaces.getClass().isMemberClass());
        System.out.println(interfaces.getClass().isPrimitive());


    }
}
