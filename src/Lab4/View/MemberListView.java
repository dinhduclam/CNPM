package Lab4.View;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class MemberListView {

	private JFrame frame;
	private JTable table;

	public void initialize(ResultSet rs) {
		frame = new JFrame();
		frame.setBounds(100, 100, 507, 317);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MEMBER LIST");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(161, 11, 168, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 471, 181);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = new DefaultTableModel();
		String []colName = {"Ho ten", "MSSV", "Email"};
		model.setColumnIdentifiers(colName);
		table.setModel(model);
		
		try {
			while (rs.next()) {
				String member[] = new String[3];
				for (int i=0; i<3; i++) {
					
					member[i] = rs.getString(i+1);
					System.out.println(member[i]);
				}
				model.addRow(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		frame.setVisible(true);
	}
}
