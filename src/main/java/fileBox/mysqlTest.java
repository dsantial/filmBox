package fileBox;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class mysqlTest {

    public static void  connect(String stringObject){
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String databaseName = "test";// 已经在MySQL数据库中创建好的数据库。
            String userName = "root";// MySQL默认的root账户名
            String password = "123456";// root账户密码
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, userName, password);

            /*
            private String irank;
            private String movieName;
            private String sumBoxOffice;
            private String movieDay;
            private String boxPer;
            private String time;*/
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE if not exist filmBox(irank varchar(32),movieName char(32),sumBoxOffice varchar(32)," +
                    "movieDay int,boxPer float,time varchar(32))";
            int result = stmt.executeUpdate(sql);

            JSONObject json=JSONObject.parseObject(stringObject);

            JSONArray array =json.getJSONArray("data");

            List<DataInfo> dataInf=new ArrayList<DataInfo>();
            for (int i=0 ;i<array.size();i++){
                JSONObject jo=array.getJSONObject(i);
                DataInfo dataInfo =JSON.parseObject(jo.toJSONString(),DataInfo.class);
//                System.out.println(dataInfo.getMovieName());

                sql = "INSERT INTO filmBox(irank,movieName,sumBoxOffice,movieDay,boxPer,time) VALUES('1','somebody1')";
                result = stmt.executeUpdate(sql);

            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }





    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String databaseName = "test";// 已经在MySQL数据库中创建好的数据库。
            String userName = "root";// MySQL默认的root账户名
            String password = "123456";// root账户密码
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, userName, password);

            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE person(uid varchar(32),name char(32))";

            // 创建数据库中的表，
            int result = stmt.executeUpdate(sql);

            if (result != -1) {
                System.out.println("创建数据表成功");

                sql = "INSERT INTO person(uid,name) VALUES('1','somebody1')";
                result = stmt.executeUpdate(sql);

                sql = "INSERT INTO person(uid,name) VALUES('2','somebody2')";
                result = stmt.executeUpdate(sql);

                sql = "SELECT * FROM person";

                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("uid\t姓名");

                while (rs.next()) {
                    System.out.println(rs.getString(1) + "\t" + rs.getString(2));
                }
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



