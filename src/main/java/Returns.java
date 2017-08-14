/**
 * Created by Meyttt on 14.08.2017.
 */
public class Returns {
    public static void main(String[] args) {
        System.out.println(getColor());
    }
    public static String getColor(){
        String[] colors = new String[]{"Red","Blue","Green"};
        for (String color:colors){
            return color;
        }
        return null;
    }
    //Берет первое значение из списка, если он пуст - дальнейшая обработка

}
