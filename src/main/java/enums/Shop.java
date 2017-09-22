package enums;

/**
 * Created by Meyttt on 19.09.2017.
 */
public class Shop {
    public static void main(String[] args) {
        String apple = "Pineapple";
        System.out.println("The price of "+ apple+" is "+ getPrice(apple));
    }
    static int getPrice(String name){
        return Apple.valueOf(name).getPrice();
    }
}
enum Apple{
    gala(100),pinkLady(120),golden(90);
    int price;

    public int getPrice() {
        return price;
    }

    Apple(int price) {
        this.price = price;
    }
}
