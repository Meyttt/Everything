package packages.pack2;

import packages.pack1.A;

/**
 * Created by Meyttt on 15.09.2017.
 */
public class E extends A {
    public static void main(String[] args) {
        B b = new B();
        B.SimpleB sb= b.new SimpleB();
        B.ProtectedB bp= b.new ProtectedB();
    }
}
