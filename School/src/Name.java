import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import javax.swing.JRadioButton;
//****************************************************
// Class:   Main
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: GUI to asks user for Name and takes 
//          them to type of request they would like to make (MainRequest GUI)
//          Store the name in the request object
//          They can also choose to enter program as administrator
//****************************************************
public class Name extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String nameOfRequestorU; 
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
	public Name(Request request, Building buldA, Building buldB, Building buldC, Dictionary<Request, Integer> allRequests) {
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
		
		
		JLabel lblPleaseEnterYour = new JLabel("Please Enter Your Name:");
		lblPleaseEnterYour.setBounds(125, 32, 177, 20);
		contentPane.add(lblPleaseEnterYour);
		
		JLabel label = new JLabel("");
		label.setBounds(190, 127, 0, 0);
		contentPane.add(label);
		
		textField = new JTextField();
		
		textField.setBounds(109, 112, 209, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(156, 199, 115, 29);
		contentPane.add(btnNext);
		
		JRadioButton rdbtnAdministratorLogin = new JRadioButton("Administrator Login");
		rdbtnAdministratorLogin.setBounds(125, 156, 233, 23);
		contentPane.add(rdbtnAdministratorLogin);
		
		
		btnNext.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (btnNext.isEnabled() && ((textField.getText().length() > 0) ||rdbtnAdministratorLogin.isSelected())) { 
		        	
		        	if((textField.getText().length() > 0) && !(rdbtnAdministratorLogin.isSelected())) {
		        	nameOfRequestorU = textField.getText();
		        	request1.setNameOfRequestor(nameOfRequestorU);
		        	MainRequest requestType = new MainRequest(request1, A, B, C, requestsDictionary);
		        	requestType.frame.setVisible(true);
					setVisible(false);
		        	}
		        	else if(rdbtnAdministratorLogin.isSelected()) {
		        		AdministratorLogin window = new AdministratorLogin(request1, A, B, C, requestsDictionary);
						window.setVisible(true);
						setVisible(false);
		        	}
		        	
					
		        }
		       
		        
		    }
		});
	}
}
