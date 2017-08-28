package postgresql.database.utils;

import org.apache.commons.configuration.XMLConfiguration;

/**
 * @author Dmitriy Bulynenkov <d.bulynenkov@voskhod.ru>
 *         created 03.04.17.
 *         qa-test-utils
 */
/**
 * Select database from database list, by default is first found
 */
public interface DBConfig {

    String getAutoCommit();

    String getStopOnError();

    String getName();

    String getUrl();

    String getUser();

    String getPassword();

    XMLConfiguration getConfig();


}
