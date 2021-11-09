package Lab4.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class MemberListModel {
	public static ResultSet getMember(){
		try {
			String url = "jdbc:mysql://localhost/lab2";
			Connection con = DriverManager.getConnection(url, "root", "");
			if (con == null) throw new SQLException(); 
			
			ResultSet rs = con.createStatement().executeQuery("SELECT TEN, MSSV, EMAIL FROM thanhvien");
			DefaultTableModel model = new DefaultTableModel();
			
			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
