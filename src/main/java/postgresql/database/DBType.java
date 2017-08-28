package postgresql.database;

/**
 * @author Dmitriy Bulynenkov <d.bulynenkov@voskhod.ru>
 *         created 24.05.16.
 *         qa-test-utils
 */

/**
 * О драйверах
 * https://www.soapui.org/jdbc/reference/jdbc-drivers.html
 */
public enum DBType {
    db2("COM.ibm.db2.jdbc.app.DB2Driver"),                  //Vendor:IBM DB2
    odbc("sun.jdbc.odbc.JdbcOdbcDriver"),                   //Vendor:JDBC-ODBC Bridge & Microsoft Access
    weblogic("weblogic.jdbc.mssqlserver4.Driver"),          //Vendor:Microsoft SQL Server
    oracle("oracle.jdbc.driver.OracleDriver"),              //Vendor:Oracle Thin
    pointbase("com.pointbase.jdbc.jdbcUniversalDriver"),    //Vendor:PointBase Embedded Server
    cloudscape("COM.cloudscape.core.JDBCDriver"),           //Vendor:Cloudscape
    firebirdsql("org.firebirdsql.jdbc.FBDriver"),           //Vendor:Firebird (JCA/JDBC Driver)
    ids("ids.sql.IDSDriver"),                               //Vendor:IDS Server
    idb("org.enhydra.instantdb.jdbc.idbDriver"),            //Vendor:InstantDB (v3.14 and later)
    interbase("interbase.interclient.Driver"),              //Vendor:Interbase (InterClient Driver)
    hypersonicsql("org.hsql.jdbcDriver"),                   //Vendor:Hypersonic SQL (v1.3 and later)
    jturbo("com.ashna.jturbo.driver.Driver"),               //Vendor:Microsoft SQL Server (JTurbo Driver)
    inetdae("com.inet.tds.TdsDriver"),                      //Vendor:Microsoft SQL Server (Sprinta Driver)
    microsoft("com.microsoft.jdbc.sqlserver.SQLServerDriver"),//Vendor:Microsoft SQL Server 2000 (Microsoft Driver)
    sybase("com.sybase.jdbc.SybDriver"),                    //Vendor:Sybase
    h2("org.h2.Driver"),                                    //
    postgresql("org.postgresql.Driver"),                      //Vendor:PostgreSQL
    derby("org.apache.derby.jdbc.ClientDriver"),            //
    mysql("com.mysql.jdbc.Driver");                         //Vendor:MySQL

    private final String DRIVER_CLASS_NAME;

    DBType(String DRIVER_CLASS_NAME) {
        this.DRIVER_CLASS_NAME = DRIVER_CLASS_NAME;
    }

    public String getDriverClassName() {
        return DRIVER_CLASS_NAME;
    }
}
