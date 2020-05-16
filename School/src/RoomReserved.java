import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Random;

//****************************************************
// Class:   RoomReserved
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: GUI that displays reservation number
//          date, time, and room booked. 
//          Takes you to repeat GUI
//****************************************************
public class RoomReserved extends JFrame {

	private JPanel contentPane;
	private Request request1;
	private Building A;
	private Building B; 
	private Building C;
	Dictionary <Request, Integer> requestsDictionary;
	private int keyWithThisRequest;

	
	public RoomReserved(Request request, Building buldA, Building buldB, 
		Building buldC, Dictionary<Request, Integer> allRequests, int requestKey) {
		A = buldA;
		B = buldB; 
		C = buldC;
		request1 = request;
		requestsDictionary = allRequests;
		keyWithThisRequest = requestKey;
	
    	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThankYouYour = new JLabel("Thank You! Your room was reserved. Click Next to Confirm.");
		lblThankYouYour.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblThankYouYour.setBounds(26, 37, 398, 42);
		contentPane.add(lblThankYouYour);
		
		JLabel lblThankYou = new JLabel("Room: " + request1.getRoomBooked() + " Building: "  + request1.getBuildingBooked() +
				" Day: " + request1.getDateBooked()  + " Time: " + request1.getTimeBooked());
		lblThankYou.setFont(new Font("Verdana", Font.PLAIN, 9));
		lblThankYou.setBounds(26, 131, 398, 42);
		contentPane.add(lblThankYou);
		

		JLabel lbl = new JLabel("Your Request Number: " +  keyWithThisRequest);
		lbl.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbl.setBounds(26, 90, 398, 42);
		contentPane.add(lbl);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(156, 199, 115, 29);
		contentPane.add(btnNext);
	
	
	btnNext.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        if (btnNext.isEnabled() ) { 
	        	
				
	        	//*********************************************************************************
	        	//Print out the buildings and dictionary for People to see the Back-end
	        	// ***********************************************************************************
	        			
	        		System.out.println();
	        		System.out.println("Booking Request");
	        		buldA.printBuilding();
	        		System.out.println();
	        		buldB.printBuilding();
	        		System.out.println();
	        		buldC.printBuilding();
	        		System.out.println();
	        		//Print the dictionary for testing purposes
	            	for(Enumeration request = requestsDictionary.keys(); request.hasMoreElements();) 
	            	{
	        			Request currentRequest = (Request)request.nextElement();
	            		System.out.print("Requestor: ");
	            		currentRequest.printRequest();
	            		System.out.println("Number: " + requestsDictionary.get(currentRequest)); 
	            	}
	            	
	        		//*******************************************************************
	            	//*********************************************************************
	            	
	            	
	        	Repeat repeat = new Repeat(request1, A, B, C, requestsDictionary);
				repeat.setVisible(true);
				setVisible(false);
	        }    
	    }
	});
	}
	
	
}
