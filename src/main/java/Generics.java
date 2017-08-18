import java.util.*;

/**
 * Created by Meyttt on 16.08.2017.
 */
public class Generics<T> {
    private T value;

    public Generics(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
//        Generics<String> stringGenerics = new Generics<>("Cat");
//        String val = stringGenerics.getValue();
//
//        Generics<Integer> integerGenerics = new Generics<>(666);
//        Integer a = integerGenerics.getValue();
//        List intList = new ArrayList();
//        intList.add(1);
//        intList.add("cat");

//        List<? extends Object> intList = new ArrayList<>();
//        intList.add(new String("hello, world!")); //ошибка компиляции!

        List<Complication> complications= new LinkedList<>();
        complications.addAll(Arrays.asList(new Complication(), new Complication()));
        print(complications);
        print2(complications);
        print3(complications);

    }
    static <T>void print(List<T> list){
        for (T object:list){
            System.out.println(object.toString());
        }
    }

    static void print2(List<?> list){
        for( Object o:list){
            System.out.println(o);
        }
    }
    static void print3(List<? extends Object> list){
        for(Object object:list){
            System.out.println(object);
        }
    }

}
    class Complication{
            String first = "first";
            String second = "second";
            Exception exception = new Exception("too complicated!");
            HashMap hashMap = new HashMap();

        public Complication() {
            hashMap.put("First","second");
            hashMap.put(first,second);
        }
        @Override
        public String toString(){
            return "Its "+exception.getMessage()+" I have "+ first+", "+second+", and even "+hashMap;
        }
    }
