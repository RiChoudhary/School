import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
//****************************************************
// Class:   MainRequest
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: Asks user if want to cancel or reserve room
//          store what type they want in request object
//          If cancel room call EnterRequestNumber GUI otherwise 
//          call RequestType GUI
//****************************************************
public class MainRequest {

	public JFrame frame;
	private String requestTypeU; 
	private Request request1;
	private Building A;
	private Building B; 
	private Building C;
	Dictionary <Request, Integer> requestsDictionary;
	
	/**
	 * Create the application.
	 */
	public MainRequest(Request request, Building buldA, Building buldB, Building buldC, Dictionary<Request, Integer> allRequests) {
		A = buldA;
		B = buldB; 
		C = buldC;
		requestsDictionary = allRequests;
		initialize();
		request1 = request;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 11));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPleaseSelectA = new JLabel("Please select a request:");
		lblPleaseSelectA.setBounds(135, 33, 164, 20);
		frame.getContentPane().add(lblPleaseSelectA);
		
		JRadioButton reserveRoom = new JRadioButton("Reserve a Room");
		reserveRoom.setBounds(21, 80, 147, 29);
		frame.getContentPane().add(reserveRoom);
		
		JRadioButton cancelRoom = new JRadioButton("Cancel a Room Request");
		cancelRoom.setBounds(21, 129, 199, 29);
		frame.getContentPane().add(cancelRoom);
		
		ButtonGroup group = new ButtonGroup();
		group.add(reserveRoom);
		group.add(cancelRoom);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(156, 199, 115, 29);
		frame.getContentPane().add(btnNext);
			

		
	

	
		// Options for buttons
		btnNext.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (btnNext.isEnabled() && cancelRoom.isSelected()) {// cancel request
		        	requestTypeU = "Cancel Request";
		        	request1.setRequestType(requestTypeU);
		        	EnterRequestNumber cancel = new EnterRequestNumber(request1, A, B, C, requestsDictionary);
					cancel.setVisible(true);
					frame.setVisible(false);// close old window
					
		        }
		        else if (btnNext.isEnabled() && reserveRoom.isSelected()){ // request room
		        	requestTypeU = "Book Room";
		        	request1.setRequestType(requestTypeU);
		        	RequestType requestType = new RequestType(request1, A, B, C, requestsDictionary);
					requestType.setVisible(true);
					frame.setVisible(false); // close old window
		        }
		        
		    }
		});
			
	}// end of initialize()
	

}




