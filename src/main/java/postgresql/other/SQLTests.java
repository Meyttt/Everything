package postgresql.other;

import postgresql.database.DBClient;
import postgresql.sql.SqlManager;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Meyttt on 23.08.2017.
 */
public class SQLTests {
    public static void main0(String[] args) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DBClient dbClient = new DBClient("jdbc:postgresql://localhost:5432/main","customuser","123456");
        dbClient.getQuerySelect("set schema 'smevMain';");
        HashMap<String, Object> res=dbClient.getQuerySelect("select * from message;").first();
        for(String key:res.keySet()){
            System.out.println(key+": "+res.get(key));
        }


    }

    public static void main(String[] args) throws SQLException {
        SqlManager sqlManager = new SqlManager("jdbc:postgresql://localhost:5432/main","customuser","123456");
        sqlManager.REQUEST("set schema 'smevMain';");
        sqlManager.INSERT("insert into message values (DEFAULT, 'messageId','origMessageId','originalId','lkId',1,'xml',1,'statusDetails','smevStatus','qname',1,now(),false,'transactionCode',1);");
        List<HashMap<String, Object>> all = SqlManager.map(1000,sqlManager.SELECT("select * from message;"));
        System.out.println(all.size());
        for(HashMap<String,Object> res:all){
            for(String key:res.keySet()){
                System.out.print(key+": "+res.get(key)+"; ");
            }
            System.out.println();
        }


    }
}
