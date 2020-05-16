import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
//****************************************************
// Class:   CancelNotFulfilled
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: cancelNotFulfilled GUI, which states room
//          couldn't be cancelled and calls repeat GUI
//****************************************************
public class CancelNotFulfilled extends JFrame {

	private JPanel contentPane;
	private Request request1;
	private Building A;
	private Building B;
	private Building C;
	Dictionary<Request, Integer> requestsDictionary;

	/**
	 * Shows a message when the cancel request was not fulfilled. It also 
	 * gives a reason as to why it did not work.
	 * @param request
	 * @param buldA
	 * @param buldB
	 * @param buldC
	 * @param allRequests
	 */
	public CancelNotFulfilled(Request request, Building buldA, Building buldB, Building buldC,
			Dictionary<Request, Integer> allRequests) {
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
	

		JButton btnNext = new JButton("Next");
		btnNext.setBounds(156, 199, 115, 29);
		contentPane.add(btnNext);
		
		JLabel lblCancelRoomRequest = new JLabel("Error: Could not find the "
				+ "request number." );
		lblCancelRoomRequest.setBounds(15, 60, 398, 42);
		contentPane.add(lblCancelRoomRequest);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNext.isEnabled()) {
					
					//**********************************************************************
		        	//Print out the buildings and dictionary for People to see the Back-end
		        	// *********************************************************************
		        			
		        		System.out.println();
		        		System.out.println("Booking Request");
		        		buldA.printBuilding();
		        		System.out.println();
		        		buldB.printBuilding();
		        		System.out.println();
		        		buldC.printBuilding();
		        		System.out.println();
		        		//Print the dictionary for testing purposes
		            	for(Enumeration request = requestsDictionary.keys(); 
		            			request.hasMoreElements();) 
		            	{
		        			Request currentRequest = (Request)request.nextElement();
		            		System.out.print("Requestor: ");
		            		currentRequest.printRequest();
		            		System.out.println("Number: " + 
		            		requestsDictionary.get(currentRequest)); 
		            	}
		            	
		        		//*****************************************************
		            	//*****************************************************
		            	
					Repeat repeat = new Repeat(request1, A, B, C,requestsDictionary);
					repeat.setVisible(true);
					setVisible(false);
				}

			}
		});
	}

}
