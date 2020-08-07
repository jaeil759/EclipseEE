package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddressDeleteByNoMain {

	public static void main(String[] args) throws Exception{
		/************** DB접속정보얻기**************/
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@192.168.15.12:1521:XE";
		String user="scott";
		String password="tiger";
		
		String deleteSql=
				"delete address where no >= 20";
		
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		Statement stmt=con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(rowCount+ " 행 delete..");

		stmt.close();
		con.close();

	}

}
