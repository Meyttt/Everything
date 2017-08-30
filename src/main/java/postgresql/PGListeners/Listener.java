package postgresql.PGListeners;

import org.postgresql.PGConnection;
import org.postgresql.PGNotification;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Meyttt on 28.08.2017.
 */
public class Listener extends Thread {
    private Connection connection;
    private PGConnection pgConnection;

    public Listener(Connection connection, String channel) throws SQLException {
        this.connection = connection;
        this.pgConnection = (PGConnection) connection;
        Statement statement= connection.createStatement();
        statement.execute("LISTEN "+channel);
        statement.close();
    }
    public void run(){
        while (true){
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet=statement.executeQuery("SELECT 1");
                resultSet.close();
                statement.close();

                PGNotification[] notifications= pgConnection.getNotifications();
                if(notifications!=null){
                    for (PGNotification notification:notifications){
                        System.out.println("Got notification: "+notification.getName());
                        System.out.println(notification.getParameter());
                    }
                }
                Thread.sleep(500);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
