package JsonWorks;

/**
 * Created by Meyttt on 15.08.2017.
 */
public class DataStruct {
    String title;
    String data;
    String metainf;

    public DataStruct(String title, String data, String metainf) {
        this.title = title;
        this.data = data;
        this.metainf = metainf;
    }

    public String getMetainf() {
        return metainf;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
