package commandLine;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Meyttt on 29.08.2017.
 */
public class CommandLineInput {
    public static void main(String[] args) throws IOException {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello!");
        while (true) {
            do {
                System.out.println("What day of the week is it?");
                System.out.println("Type the number from 1 to 7, for example 1-Sunday,2-Monday, 3-Tuesday, 4-Wednesday, 5-Thursday, 6-Friday, 7-Saturday");
                choice=scanner.nextInt();

            } while (!((choice < 7) && (choice > 0)));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            if (calendar.get(Calendar.DAY_OF_WEEK) != choice) {
                System.out.println("Sorry, you're wrong. Today is " + CommandLineTests.convertDay(calendar.get(Calendar.DAY_OF_WEEK)));
            } else {
                System.out.println("Yes! You're right! Today is " + CommandLineTests.convertDay(choice));
                break;
            }
        }
        int a=0;
        read(a);
        float b=0;
        read(b);

    }
    static void read(double a){
        System.out.println("double "+a);
    }
//    static  void read(int a){
//        System.out.println("int "+a);
//    }
    static void read (){
        System.out.println("nothing to read(");
    }
}
