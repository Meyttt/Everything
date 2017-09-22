package simple;

import java.util.Date;

/**
 * Created by Meyttt on 22.09.2017.
 */
public class ThisConstructor {
    String name;
    Date date;
    String purpose;

    public ThisConstructor(String name, Date date, String purpose) {
        this.name = name;
        this.date = date;
        this.purpose = purpose;
    }

    public ThisConstructor(String name) {
        this(name,new Date(),null);
    }

    public static void main(String[] args) {
        ThisConstructor thisConstructor= new ThisConstructor("MyConstructor");
        System.out.println(thisConstructor);
    }
}
