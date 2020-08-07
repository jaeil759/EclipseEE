package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.common.ConnectionFactory;

public class AccountService {
	
	
	public void transfer() {
		Connection con=null;
		PreparedStatement pstmt=null;
		String updateSqlA=
				"update accounta set acc_balance  = acc_balance - ? where acc_no=?";
		String updateSqlB=
				"update232132 accountb set acc_balance  = acc_balance + ? where acc_no=?";
		String selectSqlA="select acc_balance from accounta where acc_no=?";
		try {
			con=ConnectionFactory.getConnection();
			/*
			 * 1. con.setAutoCommit(false)
			 */
			con.setAutoCommit(false);
			/*
			 * transaction start
			 */
			int acc_no=10000;
			int money=5000;
			pstmt=con.prepareStatement(updateSqlA);
			pstmt.setInt(1, money);
			pstmt.setInt(2, acc_no);
			int rowCount=pstmt.executeUpdate();
			System.out.println("1.accuntA "+ acc_no+" 계좌잔고 "+ money+" 원감소(update):"+rowCount);
			pstmt.close();
			pstmt=con.prepareStatement(updateSqlB);
			pstmt.setInt(1, money);
			pstmt.setInt(2, acc_no);
			rowCount=pstmt.executeUpdate();
			System.out.println("1.accuntB "+ acc_no+" 계좌잔고 "+ money+" 원증가(update):"+rowCount);
			
			
		}catch (Exception e) {
			
			try {
				con.rollback();
				System.out.println("99.rollback(Exception)");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}
	
}
