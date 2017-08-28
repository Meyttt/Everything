package postgresql.database.utils.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * @author Dmitriy Bulynenkov <d.bulynenkov@voskhod.ru>
 *         created 25.05.16.
 *         qa-test-utils
 */

public interface ResultSetMapper {
    List<HashMap<String, Object>> map(int rowLimit, ResultSet r) throws SQLException;
}
