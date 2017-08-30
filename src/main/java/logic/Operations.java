package logic;

/**
 * Created by Meyttt on 29.08.2017.
 */
public class Operations {
    public static void main(String[] args) {
        int a=0;
        boolean b=false;
        System.out.println((b&(a++<9)));
        System.out.println(a);
        System.out.println((b&&(a++<9)));
        System.out.println(a);
    }
}
