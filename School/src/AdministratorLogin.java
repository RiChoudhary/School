import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
//****************************************************
// Class:   AdministratorLogin
// Date:    4/2018 
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: Ask administrator for username and password
//		    If true, take them to administrator page, where
//          they can see all the bookings and reset previous 
//          day's data
//          If wrong, take them to invalid username/password GUI
//****************************************************


public class AdministratorLogin extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblAdministratorLogin;
	private Request request1;
	private Building A;
	private Building B; 
	private Building C;
	Dictionary <Request, Integer> requestsDictionary;
	private JTextField textField_1;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AdministratorLogin(Request request, Building buldA, Building buldB, Building buldC, Dictionary<Request, Integer> allRequests)  {
		A = buldA;
		B = buldB; 
		C = buldC;
		request1 = request;
		requestsDictionary = allRequests;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		
		textField_1.setBounds(171, 75, 104, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField_1 = new JPasswordField("0000");
		passwordField_1.setBounds(171, 128, 104, 20);
		contentPane.add(passwordField_1);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(47, 78, 114, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(47, 131, 95, 14);
		contentPane.add(lblPassword);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(156, 199, 115, 29);
		contentPane.add(btnNext);
		
		btnNext.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (btnNext.isEnabled()) {
		    	if ((textField_1.getText()).equals("Admin")) {
						DisplayAllReservations admin = new DisplayAllReservations(request1, A, B, C, requestsDictionary);
						admin.setVisible(true);
						setVisible(false);
						
				}
		    	else {
		    		InvalidUserNameOrPassword window = new InvalidUserNameOrPassword(request1, A, B, C, requestsDictionary);
					window.setVisible(true);
					setVisible(false);
		    	}
		    	}
		    }
		});	
		
	}
}
