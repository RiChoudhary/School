
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import javax.swing.border.EmptyBorder;
//****************************************************
// Class:   EnterRequestNumber
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: GUI that asks to enter request number
//          looks through the dictionary to find that request
//          If it exists, cancels room from 2D array and then sends
//          that request to cancelFulfilled GUI, which will remove 
//          it from the dictionary
//          If not goes to CancelNotFulfilled GUI
//****************************************************
public class EnterRequestNumber extends JFrame {

	private JPanel contentPane;
	private Request request1;
	private Building A;
	private Building B;
	private Building C;
	private int requestNumberU;
	private Request removedRequest;
	Dictionary<Request, Integer> requestsDictionary;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public EnterRequestNumber(Request request, Building buldA, Building buldB, Building buldC,
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
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(321, 36, 0, 0);
		contentPane.add(label);

		JLabel lblEnterRequestNumber = new JLabel("Enter your request number:");
		lblEnterRequestNumber.setBounds(118, 36, 197, 20);
		contentPane.add(lblEnterRequestNumber);

		JButton btnNext = new JButton("Next");
		btnNext.setBounds(169, 194, 96, 30);
		contentPane.add(btnNext);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(135, 119, 156, 26);
		contentPane.add(spinner);

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = (Integer) spinner.getValue();
				if (btnNext.isEnabled()) {
					requestNumberU = value;

					boolean cancelled = false;
					// Go through dictionary and find the match request Number
					// Call Another Dialog box that says Cancellation successful or unsuccessful,
					// Both of which will call the repeat method.
					
					for (Enumeration request = allRequests.keys(); request.hasMoreElements();) {
						Request currentRequest = (Request) request.nextElement();

						// Find which request number matches with one of the keys for another request
						if (requestNumberU == allRequests.get(currentRequest)) {
							

							// Find which building it is the request booked and according cancel
							// room from that building at that particular time and date
							if (currentRequest.getBuildingBooked().equals("BuldA")) {
								
								System.out.println(currentRequest.getRoomBooked());
								cancelled = buldA.cancelRoomInBuilding(currentRequest.getRoomBooked(),
										currentRequest.getDateBooked(), currentRequest.getTimeBooked());
								if(cancelled == true) {
									System.out.println();
									System.out.println("Cancellation Request");
									buldA.printBuilding();
									buldB.printBuilding();
									buldC.printBuilding();
									removedRequest = currentRequest;
								}
							}

							if (currentRequest.getBuildingBooked().equals("BuldB")) {
								cancelled = buldB.cancelRoomInBuilding(currentRequest.getRoomBooked(),
										currentRequest.getDateBooked(), currentRequest.getTimeBooked());
								if(cancelled == true) {
									System.out.println();
									System.out.println("Cancellation Request");
									buldA.printBuilding();
									buldB.printBuilding();
									buldC.printBuilding();
									removedRequest = currentRequest;
								}

							}

							if (currentRequest.getBuildingBooked().equals("BuldC")) {
								cancelled = buldC.cancelRoomInBuilding(currentRequest.getRoomBooked(),
										currentRequest.getDateBooked(), currentRequest.getTimeBooked());
								if(cancelled == true) {
									
									removedRequest = currentRequest;
									
								}

							}
						}

						
						
					}
					
					request1.setReasonFailed("Entered Unidentified Request Key");

					if (cancelled == true) {
						CancelFulfilled cancelTrue = new CancelFulfilled(request1, A, B, C, requestsDictionary, removedRequest);
						cancelTrue.setVisible(true);
						setVisible(false);
					} 
					else {
						CancelNotFulfilled cancelTrue = new CancelNotFulfilled(request1, A, B, C, requestsDictionary);
						cancelTrue.setVisible(true);
						setVisible(false);

					}

				}

			}
		});

	}

	public void display() {
		this.setVisible(true);
	}

}
