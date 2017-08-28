package postgresql.database;


import postgresql.database.utils.QuerySelect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Dmitriy Bulynenkov <d.bulynenkov@voskhod.ru>
 *         created 24.05.16.
 *         qa-test-utils
 */

public interface DBI {
    /**
     * Получить новый Statement.
     *
     * @return
     * @throws SQLException
     */
    Statement getStatement() throws SQLException;

    /**
     * Возращает установленное соединение.
     *
     * @return
     */
    Connection getConnection();

    /**
     * Метод упрощающий вывод данныйх из БД.
     *
     * @param sqlQuery SQL запрос.
     * @return
     */
    QuerySelect getQuerySelect(String sqlQuery);

    /**
     * Закрыть соединение с БД.
     */
    void close();
}
