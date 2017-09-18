package bookSimples;

/**
 * Created by Meyttt on 31.08.2017.
 */
public class Array {
    public static void main(String[] args) {
        String[] strings = {"Mouse","Dog","Cat"};
        System.out.println(strings.getClass()); //class [Ljava.lang.String;
        System.out.println("cat".getClass()); // class java.lang.String

    }
}
class Main{
    String smth;

    class InnerClass{
        String smth;
//        static void read(){
//        }
//        static String innerSmth;
        public String innerMethod(){return smth;}
    }
    static class StaticClass{
        static  String staticSmth;
        static void doSmrthStatic(){};

//        String doSmthNonStatic0(){return smth;};
        String doSmthNonStatic(){return staticSmth;};
    }

}
