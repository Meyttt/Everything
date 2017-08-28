package postgresql.database.utils.query;



import postgresql.database.DBType;

import java.sql.Connection;

public class Query {
    static DBType dbType;
    Connection connection;

    public Query(DBType pdbType, Connection connection) {
        this.connection = connection;
        dbType = pdbType;

    }

    /**
     * Изменения относительно диалекта БД
     *
     * @todo добавитьв enum (DBType)
     * @param pQueryBuffer
     * @param pInput
     * @return
     */
    static StringBuffer escape(StringBuffer pQueryBuffer, String pInput) {
        if (dbType == DBType.mysql) {
            pQueryBuffer.append(pInput/*.replace("'","\\'")*/);
        } else if (dbType == DBType.postgresql) {
            pQueryBuffer.append(pInput);
        }
        return pQueryBuffer;
    }

    /**
     * Лимит возращаемых строк
     *
     *
     * https://en.wikipedia.org/wiki/Select_%28SQL%29#Result_limits
     *
     * @param rowLimit Колличество строк
     * @param sqlBuffer Буфер SQL запроса
     * @return Обработаный sql запрос
     */
    static StringBuffer limit(int rowLimit, StringBuffer sqlBuffer) {
        return sqlBuffer;
    }
}
