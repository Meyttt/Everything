package lambda;

/**
 * Created by Meyttt on 24.09.2017.
 */
public class Simple {
    public static void main(String[] args) {
        IsEven isEven=(n)->n%2==0;
        Simple simple = new Simple();
        System.out.println(isEven.check(111));
        System.out.println(isEven.check(1110));
        Factorial<Integer> factorial=(n -> {
            int res=1;
            for(int i=1;i<=n;i++){
                res*=i;
            }
            return res;
        });
        System.out.println(factorial.getFactorial(3));
        System.out.println(factorial.getFactorial(4));

        String hello="Hello, world!";
        System.out.println(format((inputString -> inputString.toUpperCase()),hello));
        System.out.println(format(Simple::customFormat,hello));
        System.out.println(format(simple::nonStaticFomat,hello));


    }
    static String format (StringFormatter stringFormatter, String string){
        return stringFormatter.operator(string);
    }
    static String customFormat(String string){
        return string.replace(" ","");
    }
    String nonStaticFomat(String string){
        return string.concat(" concated!");
    }

}

interface IsEven{
    boolean check(int m);
}
interface Factorial<T extends Number>{
    T getFactorial(T n);
}
interface StringFormatter{
    String operator (String inputString);
}