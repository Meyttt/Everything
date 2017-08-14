/**
 * Created by Meyttt on 03.08.2017.
 */
public class Increment {
    public static void main(String[] args) {
        double x=0;
        double y=0;
        double z=0;
        for(x=1;x<10000;x++){
            for(y=1;y<10000;y++){
                for(z=1;z<10000;z++){
                    if((x*y*(x+y)+z*x*(x+z)+z*y*(z+y))==(4*x*y*z)){
                        System.out.println("y="+y+"; x="+x+"; z="+z);
                    }
                }
            }
        }
    }
}
