package Lab4.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginModel {
	public static int login(String username, String password) {
		try {
			String url = "jdbc:mysql://localhost/lab2";
			Connection con = DriverManager.getConnection(url, "root", "");
			if (con == null) throw new SQLException(); 
			
			ResultSet rs = con.createStatement().executeQuery(
					"SELECT * FROM thanhvien WHERE username='" + username
							+ "' AND password='" + password + "'");
	
			if (rs.next()) return 1;
			else return 0;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
}
