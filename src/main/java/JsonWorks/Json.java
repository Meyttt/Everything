package JsonWorks;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by Meyttt on 15.08.2017.
 */
public class Json {
    static public void write(Object object, File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.writerWithDefaultPrettyPrinter().writeValue(file,object);
    }

    static public <T> Object readValue(Class<T> _class, File file) throws IOException {
        Object object = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        objectMapper.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY);
        object=objectMapper.readValue(file,_class);
        return object;

    }

    public static void main(String[] args) throws IOException {
        DataStruct dataStruct = new DataStruct("Title","Data","MetaInformation");
        Json.write(dataStruct,new File("JsonOutput/output.txt"));
        Json.write(new DataStruct[]{new DataStruct("Title1","Data1","MetaInf1"),new DataStruct("Title2","Data2","MetaInf2")},
                new File("JsonOutput/output2.txt"));

    }
}
