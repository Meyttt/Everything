package postgresql.database.utils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * @author Dmitriy Bulynenkov <d.bulynenkov@voskhod.ru>
 *         created 25.05.16.
 *         qa-test-utils
 */

public interface QuerySelect {
    /**
     * Добавить текст к основному SQL запроос.
     *
     * @param sqlQuery Добавление к основному запросу
     * @return
     */
    QuerySelect querySelect(String sqlQuery);

    /**
     * Первая строка из ответа на SQL запрос.
     *
     * @return Первый ответ на запрос.
     * @throws SQLException
     */
    HashMap<String,Object> first() throws SQLException;

    /**
     * Список из строк с ответом на SQL запрос.
     *
     * @return Список ответов на запрос.
     * @throws SQLException
     */
    List<HashMap<String, Object>> list() throws SQLException;

    /**
     * Список из строк с ответом на SQL запрос, с заданным колличеством строк.
     *
     * @param rowLimit Ограничение колличества возращаемых строк.
     * @return Огранниченный список ответов на запрос.
     * @throws SQLException
     */
    List<HashMap<String, Object>> list(int rowLimit) throws SQLException;

}
