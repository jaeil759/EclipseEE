package connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class StrongDriver implements Driver{
	private StrongDriver() {
		System.out.println("StringDriver기본생성자");
	}
	/*
	 * 정적메소드 : 클래스 로딩되면 객체와 관계없이 생성되는 메소드블록
	 */
	static {
		/*
		 * 정적블록 : 클래스로딩 되면 최초로 실행되는 블록
		 */
		try {
			System.out.println("1.StrongDriver객체생성");
			Driver driver = new StrongDriver();
			System.out.println("2.StrongDriver객체생성");
			DriverManager.deregisterDriver(driver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean jdbcCompliant() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
