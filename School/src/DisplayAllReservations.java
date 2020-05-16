import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;

//****************************************************
// Class:   DisplayAllReservations
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: GUI that displays all the current booking requests 
//          in the school and also has reset data for previous day's data
//          radio button to clear booking for last day, which needs 
//          to be done at beginning of each day
//          Take user back to the Name GUI when next is pressed
//****************************************************
public class DisplayAllReservations extends JFrame {

	
	private JPanel contentPane;
	private JTable table;
	private Request request1;
	private Building A;
	private Building B; 
	private Building C;
	private String[][] array = new String[100][7];
	private String result = "";

	Dictionary <Request, Integer> requestsDictionary;
	
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DisplayAllReservations(Request request, Building buldA, Building buldB, Building buldC,
			Dictionary<Request, Integer> allRequests) {
		setBackground(Color.BLUE);
		A = buldA;
		B = buldB;
		C = buldC;
		request1 = request;
		requestsDictionary = allRequests;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 120, 480, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout());
		
		//Get today's Date and store as today's date
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new Date());
		String todayDate = c1.get(Calendar.MONTH) + 1 + "/" + c1.get(Calendar.DAY_OF_MONTH) + "/" + c1.get(Calendar.YEAR); 
		
		//For all the items in dictionary if today's date is greater than 
		//the room booking date, remove that request from dictionary 
		//as we don't need to see all the old requests
		for (Enumeration requestD = allRequests.keys(); requestD.hasMoreElements();) {
			Request currentRequest = (Request) requestD.nextElement();
			
			if(todayDate.compareTo(currentRequest.getwhichOverallDateBooked()) > 0) {
			//Removed that request from the dictionary
				allRequests.remove(currentRequest);
			}
		}
		
		
		
	
		
		for (Enumeration requestD = allRequests.keys(); requestD.hasMoreElements();) {
			Request currentRequest = (Request) requestD.nextElement();
			
				for (int i = 0; i < array.length; i++) {
					//Check if the row is empty, if it not add stuff to the columns
					if(array[i][0]==null) {
						array[i][0]=(requestsDictionary.get(currentRequest)).toString();
						array[i][1]=currentRequest.getNameOfRequestor();
						array[i][2]=currentRequest.getBuildingBooked();
						array[i][3]=currentRequest.getwhichOverallDateBooked();
						array[i][4]=currentRequest.getDateBooked();
						array[i][5]=currentRequest.getTimeBooked();
						array[i][6]=currentRequest.getRoomBooked();
						break;
					}
										
				}
		}
		
		
		String[] columnName = {"Request Number", "Name", "Building Booked", "Date Booked", "Day Booked", "Time Booked", "Room Booked"};
		
		JTable table = new JTable(array, columnName);
		table.setPreferredScrollableViewportSize(new Dimension(400, 200));
		JScrollPane scrollPane = new JScrollPane(table);
		
		contentPane.add(scrollPane);
		
		JRadioButton rdbtnResetValues = new JRadioButton("Reset Previous Day");
		contentPane.add(rdbtnResetValues);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(159, 199, 115, 29);
		contentPane.add(btnNext);
		
		//This should be changed later just for the testing it is to keep everything connected
		btnNext.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		         if (btnNext.isEnabled() ){ 
		        	 
		        	 if( rdbtnResetValues.isSelected()) {
		        		 //Reset vale for previous day
		        		 Calendar c2 = Calendar.getInstance();
		        		 c2.setTime(new Date());
		        		 
		        		 if(c2.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
		        			 buldA.buildingRoomResetFriday();
		        			 buldB.buildingRoomResetFriday();
		        			 buldC.buildingRoomResetFriday();
		        		 }
		        		 else if (c2.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY){
		        			 buldA.buildingRoomResetMonday();
		        			 buldB.buildingRoomResetMonday();
		        			 buldC.buildingRoomResetMonday();
		        		 }
		        		 else if (c2.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY){
		        			 buldA.buildingRoomResetTuesday();
		        			 buldB.buildingRoomResetTuesday();
		        			 buldC.buildingRoomResetTuesday();
		        		 }
		        		 else if (c2.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY){
		        			 buldA.buildingRoomResetWednesday();
		        			 buldB.buildingRoomResetWednesday();
		        			 buldC.buildingRoomResetWednesday();
		        		 }
		        		 else if (c2.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY){
		        			 buldA.buildingRoomResetThursday();
		        			 buldB.buildingRoomResetThursday();
		        			 buldC.buildingRoomResetThursday();
		        		 }
		        		 else if (c2.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
		        			 buldA.buildingRoomResetFriday();
		        			 buldB.buildingRoomResetFriday();
		        			 buldC.buildingRoomResetFriday();
		        		 }
		        		 else if (c2.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
		        			 buldA.buildingRoomResetFriday();
		        			 buldB.buildingRoomResetFriday();
		        			 buldC.buildingRoomResetFriday();
		        		 }
		        	 }
		        	Request request2 = new Request(); 
		        	Name requestA = new Name(request2, A, B, C, requestsDictionary);
		        	requestA.setVisible(true);
					setVisible(false);
		        }
		        
		    }
		});
		
	}
}
