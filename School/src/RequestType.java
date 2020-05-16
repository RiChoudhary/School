import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
//****************************************************
// Class:   RequestType
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: Asks user what type of request they would like to make
//          and stores that in request. If request by building go to 
//          ChooseBuilding GUI, if request by room number, go to 
//          ChooseRoom GUI, if request by room size, go to NumberOfStudent GUI
//****************************************************
public class RequestType extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private String searchTypeU;
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
	public RequestType(Request request, Building buldA, Building buldB, Building buldC,  Dictionary<Request, Integer> allRequests) {
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
		
		JLabel lblTypeOfRequest = new JLabel("Type of Request");
		lblTypeOfRequest.setBounds(159, 13, 115, 20);
		contentPane.add(lblTypeOfRequest);
		
		JRadioButton rdbtnRequestRoomByBuilding = new JRadioButton("Request Room by Building");
		rdbtnRequestRoomByBuilding.setBounds(14, 66, 414, 29);
		contentPane.add(rdbtnRequestRoomByBuilding);
		
		JRadioButton rdbtnRequestRoomByRoom = new JRadioButton("Request Room by Room Number");
		rdbtnRequestRoomByRoom.setBounds(14, 103, 414, 29);
		contentPane.add(rdbtnRequestRoomByRoom);
		
		JRadioButton rdbtnRequestRoomBySize = new JRadioButton("Request Room By Room Size");
		rdbtnRequestRoomBySize.setBounds(14, 144, 414, 29);
		contentPane.add(rdbtnRequestRoomBySize);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnRequestRoomByBuilding);
		group.add(rdbtnRequestRoomByRoom);
		group.add(rdbtnRequestRoomBySize);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(159, 199, 115, 29);
		contentPane.add(btnNext);
		// Options for buttons
		
		btnNext.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (btnNext.isEnabled() && rdbtnRequestRoomByBuilding.isSelected()) { 
		        	searchTypeU = "requestByBuilding";
		        	request.setSearchType(searchTypeU);
		        	ChooseBuilding building = new ChooseBuilding(request1, A, B, C, requestsDictionary);
					building.setVisible(true);
					setVisible(false);
		        }
		        else if (btnNext.isEnabled() && rdbtnRequestRoomByRoom.isSelected()){ 
		        	searchTypeU = "requestByRoom";
		        	request1.setSearchType(searchTypeU);
		        	ChooseRoom room = new ChooseRoom (request1, A, B, C,  requestsDictionary);
					room.setVisible(true);	
					setVisible(false);
		        }
		        else if(btnNext.isEnabled() && rdbtnRequestRoomBySize.isSelected()) {
		        	searchTypeU = "requestBySize";
		        	request1.setSearchType(searchTypeU);
		        	NumberOfStudents student = new NumberOfStudents (request1, A, B, C, requestsDictionary);
					student.setVisible(true);
					setVisible(false);
		        }
		        
		    }
		});
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
}
