package Lab2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsingDatabase {
	public static void main(String[] args) {
		try {
			String url = "jdbc:sqlserver://localhost; databaseName=Lab2;";
			Connection con = DriverManager.getConnection(url, "root", " ");
			if (con != null) System.out.println("Connection successful");
			
			Statement st = con.createStatement();
			st.execute("INSERT INTO thanhvien VALUES "
					+ "('Dinh Duc Lam', 20198236, '2001/04/08', 'lam.dd198236@sis.hust.edu.vn'),"
					+ "('Do Hoang Viet', 20198272, '2001/06/02', 'viet.dh198272@sis.hust.edu.vn'),"
					+ "('Tran Duc Viet', 20198275, '2001/12/30', 'viet.td198275@sis.hust.edu.vn')");
			
			ResultSet rs = st.executeQuery("SELECT * FROM thanhvien");
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			
			st.execute("UPDATE thanhvien SET ten='Lam Dinh' WHERE MSSV = 20198236");
			System.out.println("Ten sau khi update:");
			rs = st.executeQuery("SELECT * FROM thanhvien");
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			
//			st.execute("DELETE FROM thanhvien");
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
