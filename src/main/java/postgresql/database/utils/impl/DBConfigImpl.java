package postgresql.database.utils.impl;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.tree.xpath.XPathExpressionEngine;
import postgresql.database.utils.DBConfig;

import java.util.List;

/**
 * @author Dmitriy Bulynenkov <d.bulynenkov@voskhod.ru>
 *         created 03.04.17.
 *         qa-test-utils
 */

public class DBConfigImpl implements DBConfig {

    private XMLConfiguration config;
    private String name;
    private String url;
    private String user;
    private String password;
    private String autoCommit;
    private String stopOnError;

    private DBConfigImpl() {
    }

    public DBConfigImpl(String pathToXML) {
        this(pathToXML, null);
    }

    public DBConfigImpl(final String pathToXML, final String databaseName) {
        try {
            XMLConfiguration.setDefaultExpressionEngine(new XPathExpressionEngine());
            config = new XMLConfiguration(pathToXML);
        } catch (ConfigurationException e) {
            e.getLocalizedMessage();
        }
        getDatabaseByName(databaseName);

    }

    /**
     * Select database from database list, by default is first found
     * @param name name of database
     */
    private void getDatabaseByName(final String name) {
        if (null == name || "".equals(name)) {
            this.name = config.getString("databases/database/@name");
        } else {
            this.name = name;
        }
        url = config.getString(String.format("databases/database[@name='%s']/@url", this.name));
        user = config.getString(String.format("databases/database[@name='%s']/@user", this.name));
        password = config.getString(String.format("databases/database[@name='%s']/@password", this.name));
        autoCommit = config.getString(String.format("databases/database[@name='%s']/@autoCommit", this.name), "true");
        stopOnError = config.getString(String.format("databases/database[@name='%s']/@stopOnError", this.name), "false");

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public XMLConfiguration getConfig() {
        return config;
    }


    public String getAutoCommit() {
        return autoCommit;
    }

    public String getStopOnError() {
        return stopOnError;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DBConfigImpl dbConfig = (DBConfigImpl) o;

        if (!config.equals(dbConfig.config)) return false;
        if (!name.equals(dbConfig.name)) return false;
        if (!url.equals(dbConfig.url)) return false;
        if (!user.equals(dbConfig.user)) return false;
        if (password != null ? !password.equals(dbConfig.password) : dbConfig.password != null) return false;
        if (!autoCommit.equals(dbConfig.autoCommit)) return false;
        return stopOnError.equals(dbConfig.stopOnError);

    }

    @Override
    public int hashCode() {
        int result = config.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + autoCommit.hashCode();
        result = 31 * result + stopOnError.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DBConfigImpl{" +
                "config=" + config.getBasePath() +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", autoCommit='" + autoCommit + '\'' +
                ", stopOnError='" + stopOnError + '\'' +
                '}';
    }
}

