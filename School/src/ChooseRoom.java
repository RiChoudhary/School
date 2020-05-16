import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
//****************************************************
// Class:   ChooseRoom
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: Ask user what room they want and store in 
//          request object. Then call ChooseTime GUI
//****************************************************
public class ChooseRoom extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Request request1;
	private String requestedRoomU;
	private String requestedBuildingU;
	private Building A;
	private Building B; 
	private Building C;
	Dictionary <Request, Integer> requestsDictionary;
	
	/**
	 * 
	 * @param request
	 * @param buldA
	 * @param buldB
	 * @param buldC
	 * @param allRequests
	 */
	public ChooseRoom(Request request, Building buldA, Building buldB, Building buldC, Dictionary<Request, Integer> allRequests) {
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
		
		JLabel lblEnterRoomex = new JLabel("Enter Room (ex. 200A, LibraryC, "
				+ "GymB, etc.)");
		lblEnterRoomex.setBounds(51, 13, 331, 20);
		contentPane.add(lblEnterRoomex);
		
		textField = new JTextField();
		textField.setBounds(73, 77, 288, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(159, 199, 115, 29);
		contentPane.add(btnNext);
		
		JTextPane txtpnRoomsLibrary = new JTextPane();
		txtpnRoomsLibrary.setText("Rooms: 100-115, Library, Gym, Computer Lab, "
				+ "Music Room, Art, and Science Lab");
		txtpnRoomsLibrary.setBounds(67, 137, 315, 46);
		contentPane.add(txtpnRoomsLibrary);
		
		btnNext.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (btnNext.isEnabled() && (textField.getText().length() > 0)) { 
		        	requestedRoomU = textField.getText().substring(0, textField.getText().length()-1);
		        	//This should only take all the letters except the A, B, C
		        	request1.setRequestedRoom(requestedRoomU);
		        	
		        	//Find out what is the last letter...fix it
		        	if (textField.getText().substring(textField.getText().length()-1).equalsIgnoreCase("A")) {
		        		requestedBuildingU = "BuldA";
		        	}
		        	else if (textField.getText().substring(textField.getText().length()-1).equalsIgnoreCase("B")) {
		        		requestedBuildingU = "BuldB";
		        	}
		        	
		        	else if (textField.getText().substring(textField.getText().length()-1).equalsIgnoreCase("C")) {
		        		requestedBuildingU = "BuldC";
		        	}
		        	
		        	request1.setReasonFailed("Entered Room Name Wrong. Make "
		        			+ "sure it is in format: 100A roomBuildingLetter");
		        	request1.setRequestedBuiliding(requestedBuildingU);
		        	
		        	ChooseTime time3 = new ChooseTime(request1, A, B, C, requestsDictionary);
					time3.setVisible(true);
					setVisible(false);
					
					
		        }
		       
		        
		    }
		});

		}
}
