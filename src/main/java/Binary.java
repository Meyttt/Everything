/**
 * Created by Meyttt on 13.09.2017.
 */
public class Binary {
    public static String binaryToString(String binary) {
        String[] numbers = binary.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i], 2);
            stringBuilder.append(new Character((char) number).toString());
            stringBuilder.append((i == (numbers.length - 1)) ? "." : " ");
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        System.out.println(binaryToString("01010010 01010100 01000110 01001101"));
    }
}
