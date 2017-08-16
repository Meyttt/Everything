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
        Generics<String> stringGenerics = new Generics<>("Cat");
        String val = stringGenerics.getValue();

        Generics<Integer> integerGenerics = new Generics<>(666);
        Integer a = integerGenerics.getValue();


    }
}
