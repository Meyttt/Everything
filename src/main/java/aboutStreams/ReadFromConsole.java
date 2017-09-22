package aboutStreams;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Meyttt on 20.09.2017.
 */
public class ReadFromConsole {
    public static void main(String[] args) throws Exception {
        System.out.println("Print stop to stop.");
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        String read;
        do{
            read=bufferedReader.readLine();
            System.out.println("You`ve typed \""+read+"\"");
        }while (!(read.equals("stop")));
    }
}
