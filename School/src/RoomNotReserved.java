import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//****************************************************
// Class:   RoomNotReserved
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: GUI that displays room not reserved
//          Takes you to repeat GUI
//****************************************************
public class RoomNotReserved extends JFrame {

	private JPanel contentPane;
	private Request request1;
	private Building A;
	private Building B;
	private Building C;
	Dictionary <Request, Integer> requestsDictionary;

	public RoomNotReserved(Request request, Building buldA, Building buldB, Building buldC, Dictionary<Request, Integer> allRequests) {
		request1 = request;
		A = buldA;
		B = buldB;
		C = buldC;
		requestsDictionary = allRequests;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JLabel lblThankYouYour = new JLabel("Sorry, your room could not be reserved.");
		lblThankYouYour.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblThankYouYour.setBounds(89, 11, 292, 203);
		contentPane.add(lblThankYouYour, BorderLayout.NORTH);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(156, 199, 115, 29);
		contentPane.add(btnNext);
		
		JLabel label = new JLabel("");
		contentPane.add(label, BorderLayout.CENTER);

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNext.isEnabled()) {
					
					
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
				    	
				    	
					Repeat repeat = new Repeat(request1, A, B, C,requestsDictionary);
					repeat.setVisible(true);
					setVisible(false);
				}

			}
		});
	}

}
