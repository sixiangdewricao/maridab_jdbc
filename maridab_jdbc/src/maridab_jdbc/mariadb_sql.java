package maridab_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mariadb_sql {
	private static String URL=null;//连接的数据库
	private static String USER="null";//用户
	private static String PASSWORD=null;//密码
	static Statement statement = null;
	//数据库连接
	public static void connection_mysql()throws ClassNotFoundException, SQLException{
		if( null == statement){
			//加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			URL = "jdbc:mysql://address=(protocol=tcp)(host=2001:da8:a0:500::1:10)(port=3306)/networksafe";//连接的数据库
			USER="root";//用户
			PASSWORD="123456";//密码
			//建立连接
			Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
			//操作数据库
			statement=conn.createStatement();
		}
	}
	
	//数据库执行
	public static ResultSet execute(String sql_string) throws SQLException{
		sql_string="select start_time from w_list";
		try {
			connection_mysql();
			if(null!=statement)
			{
				//ResultSet result=statement.executeQuery("select start_time from w_list"); 
				ResultSet result=statement.executeQuery(sql_string); 
				return result;
				/*while(result.next())
				{
					System.out.println(result.getString("start_time"));
				}*/
			}
			else
			{
				System.out.println("sql connection not secessful!");
				
			}
		} 
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
