import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

//****************************************************
// Class:   ChooseTime
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: Ask user what time they want to book room and store in 
//          request object. Then search through to find what type 
//          of search user wanted and book correct room at that 
//          time in the 2D array in that room.
//          If successful, put request in dictionary and call 
//          RoomReserved GUI Otherwise call  RoomNotReserved GUI
//****************************************************
public class ChooseTime extends JFrame {

	private JPanel contentPane;
	private Request request1;
	private String dateRequestedU; //the day of the week
	private String timeRequestedU;
	private String fullDateRequestedU; //The actual date like May 3, 2018
	private Building buldA;
	private Building buldB; 
	private Building buldC;
	Dictionary <Request, Integer> requestsDictionary;
	
	
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ChooseTime(Request request, Building buildA, Building buildB, Building buildC, Dictionary<Request, Integer> allRequests) {
		buldA = buildA;
		buldB = buildB; 
		buldC = buildC;
		request1 = request;
		requestsDictionary = allRequests;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox timeComboBox = new JComboBox();
		timeComboBox.setBounds(28, 150, 372, 26);
		contentPane.add(timeComboBox);
		timeComboBox.addItem("3pm-4pm");
		timeComboBox.addItem("4pm-5pm");
		timeComboBox.addItem("5pm-6pm");
		timeComboBox.addItem("6pm-7pm");
		timeComboBox.addItem("7pm-8pm");
		
	
		//Get the Next Monday Date
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new Date());
		if(c1.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
			 c1.add(Calendar.DATE, 7);
		}
		else {
			while ((c1.get(Calendar.DAY_OF_WEEK)) != Calendar.MONDAY) {
			   c1.add(Calendar.DATE, 1);
			}
		}
			
		String result1 = c1.get(Calendar.MONTH) + 1 + "/" + c1.get(Calendar.DAY_OF_MONTH) + "/" + c1.get(Calendar.YEAR); 
		
		
		//Get the Next Tuesday Date
		Calendar c2 = Calendar.getInstance();
		c2.setTime(new Date());
		
		if(c2.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY){
			 c2.add(Calendar.DATE, 7);
		}
		else {
			while ((c2.get(Calendar.DAY_OF_WEEK)) != Calendar.TUESDAY) {
			   c2.add(Calendar.DATE, 1);
			}
		}
			
		String result2 = c2.get(Calendar.MONTH) + 1 + "/" + c2.get(Calendar.DAY_OF_MONTH) + "/" + c2.get(Calendar.YEAR); 
		
		//Get the Next Wednesday
		Calendar c3 = Calendar.getInstance();
		c3.setTime(new Date());
		if(c3.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY){
			 c3.add(Calendar.DATE, 7);
		}
		else{
			while ((c3.get(Calendar.DAY_OF_WEEK)) != Calendar.WEDNESDAY) {
				c3.add(Calendar.DATE, 1);
			}
		}
					
		String result3 = c3.get(Calendar.MONTH) + 1 + "/" + c3.get(Calendar.DAY_OF_MONTH) + "/" + c3.get(Calendar.YEAR); 
		
		
		//Get the Next Thursday
		Calendar c4 = Calendar.getInstance();
		c4.setTime(new Date());
		if(c4.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY){
			 c4.add(Calendar.DATE, 7);
		}
		else {
			while ((c4.get(Calendar.DAY_OF_WEEK)) != Calendar.THURSDAY) {
				c4.add(Calendar.DATE, 1);
			}
		}
							
		String result4 = c4.get(Calendar.MONTH) + 1 + "/" + c4.get(Calendar.DAY_OF_MONTH) + "/" + c4.get(Calendar.YEAR); 
				
		
		//Get the Next Friday
		Calendar c5 = Calendar.getInstance();
		c5.setTime(new Date());
		if(c5.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY){
			 c5.add(Calendar.DATE, 7);
		}
		else {
			while ((c5.get(Calendar.DAY_OF_WEEK)) != Calendar.FRIDAY) {
				 c5.add(Calendar.DATE, 1);
			}
		}
									
		String result5 = c5.get(Calendar.MONTH) + 1 + "/" + c5.get(Calendar.DAY_OF_MONTH) + "/" + c5.get(Calendar.YEAR); 
		
		JComboBox dateComboBox = new JComboBox();
		dateComboBox.setBounds(28, 95, 372, 26);
		contentPane.add(dateComboBox);
		dateComboBox.addItem("Monday " + result1 );
		dateComboBox.addItem("Tuesday " + result2 );
		dateComboBox.addItem("Wednesday " + result3);
		dateComboBox.addItem("Thursday " + result4);
		dateComboBox.addItem("Friday" + result5);
		
	
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(198, 69, 32, 20);
		contentPane.add(lblDate);
		
		//Figure out which one of these are selected and then set it to the requested time
		
		
		
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(196, 126, 36, 20);
		contentPane.add(lblTime);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(156, 199, 115, 29);
		contentPane.add(btnNext);
		
		// get current date and time
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		JLabel lblNewLabel = new JLabel("Todays Date " + sdf.format(currentDate) );
		lblNewLabel.setBounds(85, 33, 257, 20);
		contentPane.add(lblNewLabel);
		
		
		
		btnNext.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		    	if (btnNext.isEnabled() ) { 
		    		String date = dateComboBox.getSelectedItem().toString();
		    		
		    		if (date.startsWith("Monday")) {
		    			dateRequestedU = "Monday";
		    			fullDateRequestedU = result1;
		    		}
		    		else if (date.startsWith("Tuesday")) {
		    			dateRequestedU = "Tuesday";
		    			fullDateRequestedU = result2;
		    		}
		    		else if (date.startsWith("Wednesday")) {
		    			dateRequestedU = "Wednesday";
		    			fullDateRequestedU = result3;
		    		}
		    		else if (date.startsWith("Thursday")) {
		    			dateRequestedU = "Thursday";
		    			fullDateRequestedU = result4;
		    		}
		    		else if (date.startsWith("Friday")) {
		    			dateRequestedU = "Friday";
		    			fullDateRequestedU = result5;
		    		}
		    		request1.setDateRequested(dateRequestedU);
		    		request1.setwhichOverallDateBookedRequested(fullDateRequestedU);
		    		
		    		String time = timeComboBox.getSelectedItem().toString();
		    		if (time.equals("3pm-4pm")) {
		    			timeRequestedU = "3-4pm";
		    		}
		    		else if (time.equals("4pm-5pm")) {
		    			timeRequestedU = "4-5pm";
		    		}
		    		else if (time.equals("5pm-6pm")) {
		    			timeRequestedU = "5-6pm";
		    		}
		    		else if (time.equals("6pm-7pm")) {
		    			timeRequestedU = "6-7pm";
		    		}
		    		else if (time.equals("7pm-8pm")) {
		    			timeRequestedU ="7-8pm";
		    		}
		    		
		    		request1.setTimeRequested(timeRequestedU);
		    		
		    		getFinal();
					
		        }
		       
		    }
		});
	}
	
	/**
	 * books the room/ displays right GUI according to whether its booked or not
	 */
	public void getFinal() {
 		boolean booked= false;
 			
			if(request1.getSearchType().equalsIgnoreCase("requestByBuilding")) {
				booked = getRequestByBuld();
				
			}
			
			else if((request1).getSearchType().equalsIgnoreCase("requestByRoom")) {
				booked = getRequestByRoom();
				
			}
			
			else if(request1.getSearchType().equalsIgnoreCase("requestBySize")) {
				booked = getRequestBySize();
				
			}
		
    	
    	
		
		//Final GUI displaying if the request was successfully completed or not
		if (booked == true) {
			
			//Get a random number for the request and store it as a temp key
			int random = getRequestKey();
			
			//Go through entire Dictionary to check if it is used
        	//If not use that temp key or generate a new Key
			//Loop through to make sure this key is not taken, if it is give another one
			for(Enumeration request = requestsDictionary.keys(); request.hasMoreElements();) 
			{
    			Request key = (Request)request.nextElement();
    			while (random == requestsDictionary.get(key)) 
    			{
    				random = getRequestKey();
    			}
    			
			}
			
			//Put the random number in with the request
        	requestsDictionary.put(request1, random);
        	
        	
			
			RoomReserved frame = new RoomReserved(request1, buldA, buldB, buldC, requestsDictionary, random);
			frame.setVisible(true);
			setVisible(false);
			
		}
		else 
		{
			RoomNotReserved frame = new RoomNotReserved(request1, buldA, buldB, buldC, requestsDictionary);
			frame.setVisible(true);
			setVisible(false);
			
		}
	}
		
	/**
	 * Request By Room means they know what room and building they 
	 * want to book. This searches through all the building and rooms to find 
	 * the right room, and books it if available
	 * @return Boolean true if booking successful/ false if not
	 */
	
	private boolean getRequestByRoom() {
		boolean booked = false;
		if(request1.getRequestedBuilding().equalsIgnoreCase("BuldA")) {
			
			
			if(request1.getRequestedRoom().equalsIgnoreCase("Library")) {
				booked =buldA.bookRoomInBuilding("Library", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			
			else if(request1.getRequestedRoom().equalsIgnoreCase("Gym")) {
				booked =buldA.bookRoomInBuilding("Gym", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("Art")) {
				booked =buldA.bookRoomInBuilding("Art", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("Music Room")) {
				booked =buldA.bookRoomInBuilding("Music Room", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("ComputerLab")) {
				//Does not exist in Building A*******************************************************************************************************
				booked =buldA.bookRoomInBuilding("Computer Lab", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("Science Lab")) {
				//Does not exist in Building A*******************************************************************************************************
				booked =buldA.bookRoomInBuilding("Science Lab", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("100")) {
				booked =buldA.bookRoomInBuilding("100", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("101")) {
				booked =buldA.bookRoomInBuilding("101", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("102")) {
				booked =buldA.bookRoomInBuilding("102", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("103")) {
				booked =buldA.bookRoomInBuilding("103", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("104")) {
				booked =buldA.bookRoomInBuilding("104", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("105")) {
				booked =buldA.bookRoomInBuilding("105", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("106")) {
				booked =buldA.bookRoomInBuilding("106", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("107")) {
				booked =buldA.bookRoomInBuilding("107", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("108")) {
				booked =buldA.bookRoomInBuilding("108", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("109")) {
				booked =buldA.bookRoomInBuilding("109", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("110")) {
				booked =buldA.bookRoomInBuilding("110", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("111")) {
				booked =buldA.bookRoomInBuilding("111", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("112")) {
				booked =buldA.bookRoomInBuilding("112", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("113")) {
				booked =buldA.bookRoomInBuilding("113", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("114")) {
				booked =buldA.bookRoomInBuilding("114", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("115")) {
				booked =buldA.bookRoomInBuilding("115", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked
				if(booked == true) {
					request1.setBuildingBooked("BuldA");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
		}
		
		else if(request1.getRequestedBuilding().equalsIgnoreCase("BuldB")) {
			if(request1.getRequestedRoom().equalsIgnoreCase("Library")) {
				booked =buldB.bookRoomInBuilding("Library", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("Gym")) {
				booked =buldB.bookRoomInBuilding("Gym", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("Art")) {
				booked =buldB.bookRoomInBuilding("Art", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
					}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("Music Room")) {
				booked =buldB.bookRoomInBuilding("Music Room", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
					}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("ComputerLab")) {
				booked =buldB.bookRoomInBuilding("Computer Lab", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
					}

			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("Science Lab")) {
				booked =buldB.bookRoomInBuilding("Science Lab", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("100")) {
				booked =buldB.bookRoomInBuilding("100", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("101")) {
				booked =buldB.bookRoomInBuilding("101", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("102")) {
				booked =buldB.bookRoomInBuilding("102", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("103")) {
				booked =buldB.bookRoomInBuilding("103", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("104")) {
				booked =buldB.bookRoomInBuilding("104", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("105")) {
				booked =buldB.bookRoomInBuilding("105", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("106")) {
				booked =buldB.bookRoomInBuilding("106", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("107")){
				booked =buldB.bookRoomInBuilding("107", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("108")) {
				booked =buldB.bookRoomInBuilding("108", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("109")) {
				booked =buldB.bookRoomInBuilding("109", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("110")) {
				booked =buldB.bookRoomInBuilding("110", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("111")) {
				booked =buldB.bookRoomInBuilding("111", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("112")) {
				booked =buldB.bookRoomInBuilding("112", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("113")) {
				booked =buldB.bookRoomInBuilding("113", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("114")) {
				
				booked =buldB.bookRoomInBuilding("114", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("115")) {
				
				booked =buldB.bookRoomInBuilding("115", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldB");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
		}
		
		else if(request1.getRequestedBuilding().equalsIgnoreCase("BuldC")) {
			if(request1.getRequestedRoom().equalsIgnoreCase("Library")) {
				booked =buldC.bookRoomInBuilding("Library", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("Gym")) {
				booked =buldC.bookRoomInBuilding("Gym", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("Art")) {
				booked =buldC.bookRoomInBuilding("Art", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("Music Room")) {
				booked =buldC.bookRoomInBuilding("Music Room", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("ComputerLab")) {
				booked =buldC.bookRoomInBuilding("Computer Lab", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("Science Lab")) {
				booked =buldC.bookRoomInBuilding("Science Lab", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("100")) {
				booked =buldC.bookRoomInBuilding("100", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("101")) {
				booked =buldC.bookRoomInBuilding("101", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("102")) {
				booked =buldC.bookRoomInBuilding("102", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("103")) {
				booked =buldC.bookRoomInBuilding("103", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("104")) {
				booked =buldC.bookRoomInBuilding("104", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("105")) {
				booked =buldC.bookRoomInBuilding("105", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("106")) {
				booked =buldC.bookRoomInBuilding("106", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("107")) {
				booked =buldC.bookRoomInBuilding("107", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("108")) {
				booked =buldC.bookRoomInBuilding("108", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("109")) {
				booked =buldC.bookRoomInBuilding("109", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("110")) {
				booked =buldC.bookRoomInBuilding("110", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("111")) {
				booked = buldC.bookRoomInBuilding("111", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("112")) {
				booked =buldC.bookRoomInBuilding("112", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("113")) {
				booked =buldC.bookRoomInBuilding("113", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
					request1.setBuildingBooked("BuldC");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
			}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("114")) {
				//Does not exist in Building C**********************************************************************************************************
				booked =buldC.bookRoomInBuilding("114", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
			else if(request1.getRequestedRoom().equalsIgnoreCase("115")) {
				//Does not exist in Building C**********************************************************************************************************
				booked =buldC.bookRoomInBuilding("115", request1.getDateRequested(),request1.getTimeRequested(), request1);
				//If booking was successful, set which building and date was booked 
				if(booked == true) {
						request1.setBuildingBooked("BuldC");
						request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				}
			}
		
		}
		return booked;
	}
		
	/**
	 * If they requested room by size, Doesn't matter what room or building they get
	 * try to book first available room in building A at 
	 * given date and time, if not check building B, if not book in building C
	 * FirstAvalibleRoom only books room if the capacity of room is greater than 
	 * number Of students they need room for
	 * @return Boolean true if booking successful/ false if not
	 */
	
	private boolean getRequestBySize() {
		boolean booked = false;
		//Tries to book a room in Building A
		booked=buldA.bookFirstAvalibleRoom(request1.getDateRequested(), request1.getTimeRequested(), request1);
		if(booked == true) {
			request1.setBuildingBooked("BuldA");
			request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
		}
		//If could not book a room in Building A, book a room in Building B
		if(!booked) {
			booked=buldB.bookFirstAvalibleRoom(request1.getDateRequested(), request1.getTimeRequested(), request1);
			if(booked == true) {
				request1.setBuildingBooked("BuldB");
				request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
			}
		}
		//If could not book a room in Building B, book a room in Building C
		if(!booked) {
			booked=buldC.bookFirstAvalibleRoom(request1.getDateRequested(), request1.getTimeRequested(), request1);
			if(booked == true) {
				request1.setBuildingBooked("BuldC");
				request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
			}
		}
		return booked;
	}
	
	/**
	 * If they requested room by building, go to requested building and book first available
	 * room in that building at that date and time requested
	 @return Boolean true if booking successful/ false if not
	 */
	
	private boolean getRequestByBuld(){
		boolean booked = false;
		if(request1.getRequestedBuilding().equalsIgnoreCase("BuldA")){
			booked=buldA.bookFirstAvalibleRoom(request1.getDateRequested(), request1.getTimeRequested(), request1);
			//If booking was successful, set which building and date was booked
			if(booked == true) {
				request1.setBuildingBooked("BuldA");
				request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
			}
		}
		
		if(request1.getRequestedBuilding().equalsIgnoreCase("BuldB")) {
			booked=buldB.bookFirstAvalibleRoom(request1.getDateRequested(), request1.getTimeRequested(), request1);
			//If booking was successful, set which building and date was booked 
			if(booked == true) {
					request1.setBuildingBooked("BuldB");
					request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
				
			}
		}
	
		if(request1.getRequestedBuilding().equalsIgnoreCase("BuldC")) {
			booked=buldC.bookFirstAvalibleRoom(request1.getDateRequested(), request1.getTimeRequested(), request1);
			//If booking was successful, set which building and date was booked 
			
			if (booked == true) {
				request1.setBuildingBooked("BuldC");
				request1.setwhichOverallDateBooked(request1.getwhichOverallDateBookedRequested());
			}
		}
		return booked;
	}
			
	/**
	 * Gets a random number that can be used
	 * as a request number for a request object
	 * @return int: random number
	 */
	public int getRequestKey() {
		int requestnum;
		Random rand = new Random();
		requestnum=(int)(rand.nextDouble() * 100000);
		return requestnum;
	}
}
