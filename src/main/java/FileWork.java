import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Meyttt on 12.08.2017.
 */
public class FileWork {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\test");
        File files[] = file.listFiles();
        String readed = "";
        for(File one:files){
            readed=FileUtils.readFileToString(one,"utf-8");
        }
        System.out.println(readed);
        System.out.println(FileUtils.readFileToString(file,"utf-8"));

    }
}
