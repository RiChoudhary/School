import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;

import javax.swing.JLabel;

//****************************************************
// Class:   InvalidUserNameOrPassword
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: GUI that tells user invalid username and password
//          and takes to the name (beginning) GUI
//****************************************************
public class InvalidUserNameOrPassword extends JFrame {

	private JPanel contentPane;
	private Request request1;
	private Building A;
	private Building B; 
	private Building C;
	Dictionary <Request, Integer> requestsDictionary;
	

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public InvalidUserNameOrPassword(Request request, Building buldA, Building buldB, Building buldC, Dictionary<Request, Integer> allRequests)  {
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
		
		JLabel lblInvalidUsernameOr = new JLabel("Invalid username or password. Please try again.");
		lblInvalidUsernameOr.setBounds(15, 81, 398, 29);
		contentPane.add(lblInvalidUsernameOr);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(156, 199, 115, 29);
		contentPane.add(btnNext);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNext.isEnabled()) {
					Request request2 = new Request();
		        	Name requestA = new Name(request2, A, B, C, requestsDictionary);
		        	requestA.setVisible(true);
					setVisible(false);
				}

			}
		});
		
	}

}
