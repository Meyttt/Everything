package postgresql.database.utils.query;



import postgresql.database.DBType;
import postgresql.database.utils.QuerySelect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


public class DefaultQuerySelect extends Query implements QuerySelect {

    private StringBuffer sqlBuffer;
    private ResultSetMapper mapper;

    /**
     * SQL запрос
     *
     * @param dbType Потдерживаемые БД
     * @param connection Соединения с БД
     * @param sqlQuery SQL запрос
     */
    public DefaultQuerySelect(DBType dbType, Connection connection, String sqlQuery) {
        super(dbType, connection);
        sqlBuffer  = new StringBuffer(sqlQuery);
        mapper = new DefaultMapper();
    }

    /**
     * Добавить в основной SQL запроос.
     *
     * @param sqlQuery Добавление к основному запросу
     * @return
     */
    @Override
    public QuerySelect querySelect(String sqlQuery) {
        sqlBuffer.append(sqlQuery);
        return this;
    }

    /**
     * Первый результат запроса
     *
     * @return
     * @throws SQLException
     */
    @Override
    public HashMap<String,Object> first() throws SQLException {
        return mapper.map(1, connection.createStatement().executeQuery(sqlBuffer.toString())).get(0);
    }

    /**
     * Возращает все строки запроса.
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<HashMap<String, Object>> list() throws SQLException {
        return mapper.map(0, connection.createStatement().executeQuery(sqlBuffer.toString()));
    }

    /**
     * Возращает заданное количество строк запроса.
     *
     * @todo Не верный подход к лимитированию. (https://en.wikipedia.org/wiki/Select_%28SQL%29#Result_limits)
     * @param rowLimit Количество строк
     * @return заданное количество строк
     * @throws SQLException
     */
    @Override
    public List<HashMap<String, Object>> list(int rowLimit) throws SQLException {
        return mapper.map(rowLimit, connection.createStatement().executeQuery(sqlBuffer.toString()));
    }

    @Override
    public String toString(){
        return sqlBuffer.toString();
    }
}
