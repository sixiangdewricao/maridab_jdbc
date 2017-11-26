package maridab_jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.sun.org.apache.xpath.internal.operations.Bool;
public class networksafe_sql {
	private static String start_time=null;
	private static String end_time=null;
	private static String ipv4=null;
	private static String ipv6=null;
	private static String table=null;
	
	//**************************************************************************************************
	//������:ResultSet querry
	//�������ܣ����ݿ��ѯ
	//������
	//String start_time
	//String end_time
	//String ipv4
	//String ipv6
	//String table
	//����ֵ����ѯ����ResultSet
	//**************************************************************************************************
	public static ResultSet querry(String start_time,String end_time,String ipv4,String ipv6,String table) throws SQLException{
		//String sql_string="select start_time,end_time,ipv4,ipv6 from "+table+
				//" where start_time=\""+start_time+"\"";
		//System.out.println(sql_string);
		try {
			mariadb_sql.connection_mysql();
			if(null!=mariadb_sql.statement)
			{
				ResultSet result=mariadb_sql.statement.executeQuery("select start_time from w_list"); 
				//ResultSet result=mariadb_sql.statement.executeQuery(sql_string); 
				System.out.println("querry is succesful!");
				/*while(result.next())
				{
					System.out.println(result.getString("start_time"));
				}*/
				return result;
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
	
	
	
	//**************************************************************************************************
	//������:Boolean delete;
	//�������ܣ����ݿ�ɾ��
	//������
	//String start_time
	//String end_time
	//String ipv4
	//String ipv6
	//String table
	//����ֵ��Boolean
	//**************************************************************************************************
	public static Boolean delete(String start_time,String end_time,String ipv4,String ipv6,String table) throws SQLException{
		String sql_string="DELETE FROM "+table+" WHERE start_time="+"\""+start_time+"\"";
		//System.out.println(sql_string);
		try {
			mariadb_sql.connection_mysql();
			if(null!=mariadb_sql.statement)
			{
				//ResultSet result=mariadb_sql.statement.executeQuery("select start_time from w_list  where start_time='2017:11:7'"); 
				//ResultSet result=mariadb_sql.statement.executeQuery(sql_string); 
				Boolean bool_result=mariadb_sql.statement.execute(sql_string);
				return bool_result;
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
		return false;
	}
	
	
	//**************************************************************************************************
	//������:Boolean insert;
	//�������ܣ����ݿ����
	//������
	//String start_time
	//String end_time
	//String ipv4
	//String ipv6
	//String table
	//����ֵ��Boolean
	//**************************************************************************************************
	public static Boolean insert(String start_time,String end_time,String ipv4,String ipv6,String table) throws SQLException{
		//String sql_string="select start_time,end_time,ipv4,ipv6 from "+table+
			//	" where start_time=\""+start_time+"\"";
		String sql_string="insert into "+table+"(start_time,end_time,ipv4,ipv6) values ("+"\""+ start_time+ "\","+"\""+end_time+"\","+"\""+ipv4+"\","+"\""+ipv6+"\")";
		
		System.out.println(sql_string);
		try {
			mariadb_sql.connection_mysql();
			if(null!=mariadb_sql.statement)
			{
				//ResultSet result=mariadb_sql.statement.executeQuery("select start_time from w_list  where start_time='2017:11:7'"); 
				//ResultSet result=mariadb_sql.statement.executeQuery(sql_string); 
				Boolean bool_result=mariadb_sql.statement.execute(sql_string);
				return bool_result;
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
		return false;
	}
	
	
	
	//**************************************************************************************************
	//������:main;
	//�������ܣ����Ժ���
	//����ֵ��void
	//**************************************************************************************************
	public static void main(String[] args) throws SQLException {
		ResultSet resultSet;
		String start_time="2017:11:7";
		String end_time=null;
		String ipv4=null;
		String ipv6=null;
		String table="w_list";
		
		System.out.println("ѡ�����ݿ����");
		System.out.println("����1��insert");
		System.out.println("����2��querry");
		System.out.println("����3��delete");
		System.out.println("����0����������");
		System.out.println("ѡ�����ݿ����");
		Scanner in=new Scanner(System.in); //ʹ��Scanner�ඨ����� 
		int choose=in.nextInt(); //������������;
		while(choose>0)
		{
			/************************************************************************/
			switch (choose)
			{
				case 1:
					{
						Boolean bool=insert(start_time, end_time, ipv4, ipv6,table);
						resultSet=null;
						resultSet=querry(start_time,end_time,ipv4,ipv6,table);
						while(resultSet.next())
						{
							System.out.println(resultSet.getString("start_time"));
						}
						break;
					}
				
				case 2:
					{
						resultSet=null;
						resultSet=querry(start_time,end_time,ipv4,ipv6,table);
						while(resultSet.next())
						{
							System.out.println(resultSet.getString("start_time"));
						}
						break;
					}
				case 3:
					{
						Boolean bool_result=delete(start_time,end_time,ipv4,ipv6,table);
						if(false==bool_result)
						{
							System.out.println("delete is successful!");
							resultSet=querry(start_time,end_time,ipv4,ipv6,table);
							while(resultSet.next())
							{
								System.out.println(resultSet.getString("start_time"));
							}
						}
						else
						{
							System.out.println("delete is faild!");
						}
						break;
					}
				default:
					{
						System.out.println("sql nothing to do!");
						break;
					}
			}
			/************************************************************************/
			
			System.out.println("ѡ�����ݿ����");
			choose=in.nextInt(); //������������;
		}
		
		if(choose==0)
		{
			System.out.println("sql nothing to do!");
			System.out.println("��������");
		}
		
	}
}
