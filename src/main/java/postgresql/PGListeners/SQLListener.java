package postgresql.PGListeners;

import org.postgresql.Driver;
import org.postgresql.PGConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Meyttt on 28.08.2017.
 */
public class SQLListener {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection lconnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/main","customuser","123456");
        Listener listener = new Listener(lconnection);
        listener.start();
    }
}
