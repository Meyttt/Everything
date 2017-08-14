import org.apache.log4j.Logger;

/**
 * Created by Meyttt on 26.07.2017.
 */
public class Logging {
    static Logger logger = Logger.getLogger(Logging.class);

    public static void main(String[] args) throws Exception {
        logger.info("Hello! I want to show you something...");
        throw  new Exception("Helloworld exception :(");
    }
}
