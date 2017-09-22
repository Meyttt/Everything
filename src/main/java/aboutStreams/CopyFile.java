package aboutStreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Meyttt on 21.09.2017.
 */
public class CopyFile {
    public static void main(String[] args) {
        if(args.length!=2){
            System.err.println("Введите 2 аргумента: исходный и результирующий файлы.");
            return;
        }
        int i=0;
        try(FileInputStream fileInputStream= new FileInputStream(args[0]); FileOutputStream fileOutputStream=new FileOutputStream(args[1]);){
            do{
                i=fileInputStream.read();
                if(i!=-1)fileOutputStream.write(i);
            }while (i!=-1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
