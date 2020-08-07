package dao.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import util.DBUtil;

public class AddressDao3 {
	/************** DB접속정보 **************/
	Connection con = DBUtil.getConnection();
	//	String driverClass = "oracle.jdbc.OracleDriver";
//	String url = "jdbc:oracle:thin:@192.168.15.12:1521:XE";
//	String user = "scott";
//	String password = "tiger";
//	
	public int create(Address address) throws Exception{
		//Class.forName(driverClass);
		//Connection con = DriverManager.getConnection(url, user, password);
		String insertSql = 
			"insert into address values(address_no_seq.nextval, ?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(insertSql);
		pstmt.setString(1, address.getId());
		pstmt.setString(2, address.getName());
		pstmt.setString(3, address.getPhone());
		pstmt.setString(4, address.getAddress());
		int insertRowCount = pstmt.executeUpdate();
		pstmt.close();
	//	con.close();
		return insertRowCount;
	}
	
	public int delete(int no) throws Exception {
		String deleteSql = "delete address where no =" + no;
		System.out.println("deleteSql:" + deleteSql);
		//Class.forName(driverClass);
		//Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(rowCount + " 행 delete..");

		stmt.close();
		//con.close();
		return rowCount;
	}
	public int update(Address updateAddress)  throws Exception{
		
		//Class.forName(driverClass);
		//Connection con = DriverManager.getConnection(url, user, password);
		String updateSql = 
			"update address set id = ?, name = ?,phone = ?,address = ? where no = ?";
		PreparedStatement pstmt = con.prepareStatement(updateSql);
		pstmt.setString(1, updateAddress.getId());
		pstmt.setString(2, updateAddress.getName());
		pstmt.setString(3, updateAddress.getPhone());
		pstmt.setString(4, updateAddress.getAddress());
		pstmt.setInt(5, updateAddress.getNo());
		int updateRowCount = pstmt.executeUpdate();
		pstmt.close();
	//	con.close();
		return updateRowCount;
	}
	
	public Address selectByNo(int fno) throws Exception {
		
		Address address = new Address();
		//Class.forName(driverClass);
		//Connection con=DriverManager.getConnection(url, user, password);
		String selectSql="select * from address where no= ?";
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		pstmt.setInt(1, fno);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {

			int no = rs.getInt("no");
			String id=rs.getString("id");
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String address1=rs.getString("address");
			address = new Address(no,id,name,phone,address1);
		}
		rs.close();
		pstmt.close();
	//	con.close();
		return address;
	}
	public ArrayList<Address> selectAll() throws Exception {
		ArrayList<Address> selectaddressList = new ArrayList<Address>();
		//Class.forName(driverClass);
		//Connection con=DriverManager.getConnection(url, user, password);
		String selectSql="select * from address";
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Address tempAddress = new Address();
			tempAddress.setNo(rs.getInt("no"));
			tempAddress.setId(rs.getString("id"));
			tempAddress.setName(rs.getString("name"));
			tempAddress.setPhone(rs.getString("phone"));
			tempAddress.setAddress(rs.getString("address"));
			selectaddressList.add(tempAddress);
			
		
		}
		rs.close();
		pstmt.close();
	//	con.close();
		return selectaddressList;
	}

	String driverClass = "oracle.jdbc.OracleDriver";
}
