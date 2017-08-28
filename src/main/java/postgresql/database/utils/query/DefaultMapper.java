package postgresql.database.utils.query;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Dmitriy Bulynenkov <d.bulynenkov@voskhod.ru>
 *         created 25.05.16.
 *         qa-test-utils
 */

public class DefaultMapper implements ResultSetMapper {
    /**
     * https://en.wikipedia.org/wiki/Select_%28SQL%29#Result_limits
     */
    public List<HashMap<String, Object>> map(int rowLimit, ResultSet resultSet) throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
        while (resultSet.next()) {
            HashMap<String, Object> row = new DefaultResultMap();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                String key = resultSetMetaData.getColumnName(i);
                String alias = resultSetMetaData.getColumnLabel(i);
                Object value = resultSet.getObject(i);
                row.put(alias != null ? alias : key, value);
            }
            if (--rowLimit == 0) {
                    list.add(row);
                    return list;
            }

            list.add(row);
        }
        resultSet.getStatement().close();
        return list;
    }


    private static class DefaultResultMap extends HashMap<String, Object> {
        public static final long serialVersionUID = 1L;

        @Override
        public Object get(Object o)
        {
            return super.get(((String)o).toLowerCase());
        }

        @Override
        public Object put(String key, Object value)
        {
            return super.put(key.toLowerCase(), value);
        }

        @Override
        public boolean containsKey(Object key)
        {
            return super.containsKey(((String)key).toLowerCase());
        }

    }
}
