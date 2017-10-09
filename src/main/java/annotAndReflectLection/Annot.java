package annotAndReflectLection;

import com.sun.istack.internal.NotNull;

import java.util.Date;

/**
 * Created by Meyttt on 08.10.2017.
 */
public class Annot {

    // TODO: 08.10.2017 annotation proccessing java
    // TODO: 08.10.2017 findBugs @NotNull
    public static void main(String[] args) {
        System.out.println("Hello,world!");
        System.out.println(getDate(null));
    }
    public static @NotNull Date getDate(@NotNull String strDate){
        return null;
    }
}
