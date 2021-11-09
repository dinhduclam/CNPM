package Lab4.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Lab4.Controller.Controller;

import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import Lab4.Controller.*;
public class LoginView implements ActionListener, KeyListener {

	public JFrame frame;
	private JTextField username;
	private JTextField password;

	public LoginView() {
//		initialize('');
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("Login Form - Nhom 1");
		frame.setBounds(100, 100, 575, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon image = new ImageIcon("src/Lab4/View/Logo_Hust.png");
		
		JLabel label = new JLabel();
		label.setIcon(image);
		label.setBounds(0, 0, 222, 301);
		frame.getContentPane().add(label);
		
		JButton submit = new JButton("Submit");
		submit.setContentAreaFilled(false);
		submit.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		submit.setBackground(Color.WHITE);
		submit.addActionListener(this);
		submit.setBounds(423, 230, 108, 33);
		frame.getContentPane().add(submit);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(257, 139, 83, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(257, 186, 83, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBackground(UIManager.getColor("TextField.disabledBackground"));
		username.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		username.setBounds(350, 137, 181, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBackground(UIManager.getColor("TextField.disabledBackground"));
		password.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		password.setBounds(350, 184, 181, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		username.addKeyListener(this);
		password.addKeyListener(this);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN FORM");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setBounds(257, 56, 197, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		frame.setVisible(true);
	}
	
	
	public void loginFail() {
		JOptionPane.showMessageDialog(frame, "Dang nhap that bai!!");
	}
	
	public void loginSuccessful() {
		JOptionPane.showMessageDialog(frame, "Dang nhap thanh cong!!");
	}
	
	public void sthWrong() {
		JOptionPane.showMessageDialog(frame, "Co loi xay ra!!");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Controller.login(username.getText(), password.getText());
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) 
			Controller.login(username.getText(), password.getText());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
