package packages.pack2;

import java.io.ByteArrayInputStream;

/**
 * Created by Meyttt on 14.09.2017.
 */
public class C extends B {
    static B b = new B();
    static  B.ProtectedB protectedB= b.new ProtectedB();

    public static void main (String[] args) throws Exception{
        C c = new C();
        c.tests();
    }
    void tests() throws Exception{
        ProtectedB protectedB= this.new ProtectedB();
        Class[] bclasses=B.class.getDeclaredClasses();
        Class enclosing=B.class.getEnclosingClass();
        for (Class bclass:bclasses){
            if(bclass.getName().contains("Private")){

            }
        }

        moreB moreB = new moreB();
         B.SimpleB bb=this.new SimpleB();



    }
}
