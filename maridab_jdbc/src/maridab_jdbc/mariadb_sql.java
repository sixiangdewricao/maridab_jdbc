package maridab_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mariadb_sql {
	private static String URL=null;//���ӵ����ݿ�
	private static String USER="null";//�û�
	private static String PASSWORD=null;//����
	static Statement statement = null;
	//���ݿ�����
	public static void connection_mysql()throws ClassNotFoundException, SQLException{
		if( null == statement){
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			URL = "jdbc:mysql://address=(protocol=tcp)(host=2001:da8:a0:500::1:10)(port=3306)/networksafe";//���ӵ����ݿ�
			USER="root";//�û�
			PASSWORD="123456";//����
			//��������
			Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
			//�������ݿ�
			statement=conn.createStatement();
		}
	}
	
	//���ݿ�ִ��
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
