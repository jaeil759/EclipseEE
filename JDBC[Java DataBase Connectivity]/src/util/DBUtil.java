package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnection() {
		try {
			String driverClass = "oracle.jdbc.OracleDriver";
			String url = "jdbc:oracle:thin:@192.168.15.12:1521:XE";
			String user = "scott";
			String password = "tiger";
			Class.forName(driverClass);
			return DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
}
		return null;
	}
}
