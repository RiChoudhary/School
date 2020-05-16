import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;

import javax.swing.JRadioButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
//****************************************************
// Class:   Repeat
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: Ask user if would like to repeat again or not
//          If yes, take back to Name(main) gui
//****************************************************
public class Repeat extends JFrame {

	private JPanel contentPane;
	private boolean repeat;
	private Building A;
	private Building B; 
	private Building C;
	private Request request1;
	Dictionary <Request, Integer> requestsDictionary;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Repeat(Request request, Building buldA, Building buldB, Building buldC,  Dictionary<Request, Integer> allRequests) {
		request1 = request;
		A = buldA; 
		B = buldB; 
		C = buldC;
		requestsDictionary = allRequests;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWouldYouLike = new JLabel("Would you like make another request?");
		lblWouldYouLike.setBounds(20, 36, 387, 20);
		contentPane.add(lblWouldYouLike);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBounds(185, 101, 57, 29);
		contentPane.add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(185, 138, 57, 29);
		contentPane.add(rdbtnNo);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(166, 194, 96, 30);
		contentPane.add(btnNext);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNo);
		group.add(rdbtnYes);
		
		btnNext.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (btnNext.isEnabled() && rdbtnNo.isSelected()) {
		        	repeat = false;
					setVisible(false);
					//DisplayAllReservations reservation = new DisplayAllReservations(request1, A, B, C, requestsDictionary);
		        	//reservation.setVisible(true);
		        }
		        
		        else if (btnNext.isEnabled() && rdbtnYes.isSelected()){ 
		        	Request request2 = new Request();
		        	Name requestA = new Name(request2, A, B, C, requestsDictionary);
		        	requestA.setVisible(true);
		        	repeat = true;
					setVisible(false);
		        }
		        
		    }
		});
	}
	
	public boolean repeatAgain() {
		return repeat;
	}
}
