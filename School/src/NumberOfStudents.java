import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Dictionary;

import javax.swing.JTextPane;
import javax.swing.JSpinner;
//****************************************************
// Class:   NumberOfStudents
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: Ask user how many students they need 
//          room for and then calls, store in request object
//          Then calls ChooseTime GUI
//****************************************************
public class NumberOfStudents extends JFrame {

	private JPanel contentPane;
	private Request request1;
	private static int numberOfStudentRequestedU;
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
	public NumberOfStudents(Request request, Building buldA, Building buldB, Building buldC, Dictionary<Request, Integer> allRequests) {
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

		JLabel label = new JLabel("");
		label.setBounds(321, 36, 0, 0);
		contentPane.add(label);

		JLabel lblEnterNumberOf = new JLabel("Enter number of students you need room for:");
		lblEnterNumberOf.setBounds(55, 46, 324, 20);
		contentPane.add(lblEnterNumberOf);

		JButton btnNext = new JButton("Next");
		btnNext.setBounds(156, 199, 115, 29);
		contentPane.add(btnNext);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(135, 119, 156, 26);
		contentPane.add(spinner);

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int value = (Integer) spinner.getValue();

				if (btnNext.isEnabled() && (value > 0) && (value <=100)) { 
					numberOfStudentRequestedU = value;
					request1.setNumberOfStudentsRequested(numberOfStudentRequestedU);
					ChooseTime time = new ChooseTime(request1, A, B, C, requestsDictionary);
					time.setVisible(true);
					setVisible(false);

				}
			}
		});

	}
}
