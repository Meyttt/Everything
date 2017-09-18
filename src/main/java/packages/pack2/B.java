package packages.pack2;

/**
 * Created by Meyttt on 14.09.2017.
 */
public class B {
    protected  String n="n";
    private  String nn="nn";
    public String nnn="nnn";
    String nnnn="nnnn";
    protected ProtectedB getProtectedB(){return  new ProtectedB();}
    protected class ProtectedB {
        public PrivateB privateB= new PrivateB();
    }
    private class PrivateB {}
    class SimpleB{}
}
class moreB{
    public static void main(String[] args) {

    }

}


