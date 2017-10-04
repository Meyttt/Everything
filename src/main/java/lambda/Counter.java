package lambda;

/**
 * Created by Meyttt on 25.09.2017.
 */
public class Counter {
    public static<T> int count(T[] array,T ob){
        int count=0;
        for(T t:array){
            if(t.equals(ob))
                count++;
        }
        return count;
    }
    public static void printStatement( Object...args){
        String mainString= "Массив %s содержит %s элементов \"%s\"";
        String res = String.format(mainString, args);
        System.out.println(res);
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        String[] array=new String[]{"Cat","Dog","Cow","Humster","Cat","Bird"};
        int count = counter.myOp(Counter::count,array,"Cat");
        myPrint(Counter::printStatement,array,count,"Cat");

        Integer[] intArray=new Integer[]{1,2,3,4,2,1,1};
        count= counter.myOp(Counter::count,intArray,1);
        myPrint(Counter::printStatement,intArray,count,1);

    }
    public <T> int myOp(CustomFunc func, T[] objects, T object){
        return func.executeFunc(objects,object);
    }
    public static void myPrint(Printer printer,Object...objects){
        printer.print(objects);
    }
}
interface CustomFunc<T>{
    int executeFunc(T[] objects, T object);
}
interface Printer{
    void print(Object...args);
}