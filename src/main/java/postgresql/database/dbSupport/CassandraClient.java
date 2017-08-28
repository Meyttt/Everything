package postgresql.database.dbSupport;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SocketOptions;


/**
 * @author Dmitriy Bulynenkov <d.bulynenkov@voskhod.ru>
 *         created 25.05.16.
 *         qa-test-utils
 */

/**
 * Socket options:
 *  *  https://datastax.github.io/java-driver/manual/socket_options/
 */
public class CassandraClient {
    private Cluster cluster;
    private Session session;

    public CassandraClient(String host, int port, String keyspace, String loginUserName, String password) {
        cluster = Cluster.builder().withSocketOptions(new SocketOptions().setConnectTimeoutMillis(2500)).withCredentials(loginUserName, password).withPort(port).addContactPoint(host).build();
        connect(keyspace);
    }

    public CassandraClient(String host, int port, String keyspace, String loginUserName, String password, int connectTimeout) {
        cluster = Cluster.builder().withSocketOptions(new SocketOptions().setConnectTimeoutMillis(connectTimeout)).withCredentials(loginUserName, password).withPort(port).addContactPoint(host).build();
        connect(keyspace);
    }

    public CassandraClient(String host, int port, String keyspace) {
        cluster = Cluster.builder().withSocketOptions(new SocketOptions().setConnectTimeoutMillis(2500)).withPort(port).addContactPoint(host).build();
        connect(keyspace);
    }

    public CassandraClient(String host, int port, String keyspace, int connectTimeout) {
        cluster = Cluster.builder().withSocketOptions(new SocketOptions().setConnectTimeoutMillis(connectTimeout)).withPort(port).addContactPoint(host).build();
        connect(keyspace);

    }

    private void connect(String keyspace) {
        session = cluster.connect(keyspace);
    }

    public Cluster getCluster() {
        return cluster;
    }

    public Session getSession() {
        return session;
    }

    public void close() {
        if (session != null) {
            session.close();
        }
        if (cluster != null) {
            cluster.close();
        }
    }
}
