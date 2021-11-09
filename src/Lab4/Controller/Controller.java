package Lab4.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Lab4.Model.LoginModel;
import Lab4.Model.MemberListModel;
import Lab4.View.LoginView;
import Lab4.View.MemberListView;

public class Controller {
	
	static LoginView loginView = new LoginView();
	static MemberListView memberListView = new MemberListView();
	public static void login(String username, String password) {
		int log = LoginModel.login(username, password);
		if (log == 1) {
			loginView.loginSuccessful();
			memberListView.initialize((new MemberListModel()).getMember());
		}
		else if (log == 0) loginView.loginFail();
		else loginView.sthWrong();
	}
	
	public static void main(String[] args) {
		loginView.initialize();
	}
}
