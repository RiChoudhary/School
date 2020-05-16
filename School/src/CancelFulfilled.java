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
// Class:   CancelFulfilled
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: cancelFulfilled GUI, which will remove particular
//          request from dictionary that was passed to it
//          Calls repeat GUI
//****************************************************
public class CancelFulfilled extends JFrame {

	private JPanel contentPane;
	private Request request1;
	private Building A;
	private Building B;
	private Building C;
	private Request requestToRemove;
	Dictionary<Request, Integer> requestsDictionary;

	/**
	 * Window confirming that the cancel request was fulfilled and no errors 
	 * were encountered
	 * @param request
	 * @param buldA
	 * @param buldB
	 * @param buldC
	 * @param allRequests
	 * @param rmvRequest
	 */
	public CancelFulfilled(Request request, Building buldA, Building buldB, 
			Building buldC, Dictionary<Request, Integer> allRequests, 
			Request rmvRequest) {
		requestToRemove= rmvRequest;
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
		
		JLabel lblCancellationSucessful = new JLabel("Cancellation Sucessful");
		lblCancellationSucessful.setBounds(0, 0, 0, 0);
		contentPane.add(lblCancellationSucessful);
		

		JButton btnNext = new JButton("Next");
		btnNext.setBounds(156, 199, 115, 29);
		contentPane.add(btnNext);
		
		JLabel lblCancelRoomRequest = new JLabel("Cancel Room Request Fulfilled");
		lblCancelRoomRequest.setBounds(126, 61, 193, 64);
		contentPane.add(lblCancelRoomRequest);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNext.isEnabled()) {	
					requestsDictionary.remove(requestToRemove);
					
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
