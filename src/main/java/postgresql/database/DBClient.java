package postgresql.database;


import org.apache.commons.dbcp2.BasicDataSource;
import postgresql.database.utils.QuerySelect;
import postgresql.database.utils.query.DefaultQuerySelect;


import java.net.URI;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Dmitriy Bulynenkov <d.bulynenkov@voskhod.ru>
 *         created 24.05.16.
 *         qa-test-utils
 */

/**
 * Клиент для подлючения к БД.
 *
 */
public class DBClient implements DBI {
    private final String url;
    private final String user;
    private final String password;
    private final String dialect;

    private BasicDataSource bds;
    private Connection connection;

    public DBClient(final String url) {
        this(url, null, null);
    }
    public DBClient(final String url, final String user) {
        this(url, user, null);
    }

    /**
     * Конструктор подлючения к БД.
     *
     * @param url URL-адреса соединения. Пример jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
     * @param user Имя пользователя, для соединения с БД.
     * @param password Пароль от учетной записи пользователя.
     */
    public DBClient(final String url, final String user, final String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.dialect = getDialect(url);
        bds = new BasicDataSource();
        bds.setDriverClassName(DBType.valueOf(dialect).getDriverClassName());
        bds.setUrl(url);
        bds.setUsername(user);
        bds.setPassword(password);
        try {
            connection = bds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public QuerySelect getQuerySelect(String sqlQuery) {
        return new DefaultQuerySelect(DBType.valueOf(dialect), connection, sqlQuery);
    }

    private String getDialect(String url) {
        return URI.create(url.substring(5)).getScheme().toLowerCase();
    }

    @Override
    public Statement getStatement() throws SQLException {
        return connection.createStatement();
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    public String getDialect() {
        return dialect;
    }

    @Override
    public void close() {
        try {
            connection.close();
            bds.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
