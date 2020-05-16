import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
//****************************************************
// Class:   ChooseBuilding
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: Ask user to choose building and store it in 
//          request object then call NumberOfStudent GUI 
//****************************************************
public class ChooseBuilding extends JFrame {

	private JPanel contentPane;
	private Request request1;
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
	public ChooseBuilding(Request request, Building buldA, Building buldB, Building buldC,  Dictionary<Request, Integer> allRequests) {
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
		
		JLabel chooseTheBuilding = new JLabel("Choose the Building you want ");
		chooseTheBuilding.setBounds(106, 16, 216, 20);
		contentPane.add(chooseTheBuilding);
		
		JRadioButton kToFifthGradeBuilding = new JRadioButton("K - 5th Grade (Building A)");
		kToFifthGradeBuilding.setBounds(14, 59, 405, 29);
		contentPane.add(kToFifthGradeBuilding);
		
		JRadioButton sixToEighthGradeBuilding = new JRadioButton("6th - 8th Grade (Building B)");
		sixToEighthGradeBuilding.setBounds(14, 96, 405, 29);
		contentPane.add(sixToEighthGradeBuilding);
		
		JRadioButton highSchoolBuilding = new JRadioButton("High School (Building C)");
		highSchoolBuilding.setBounds(14, 137, 405, 29);
		contentPane.add(highSchoolBuilding);
		
		ButtonGroup group = new ButtonGroup();
		group.add(kToFifthGradeBuilding);
		group.add(sixToEighthGradeBuilding);
		group.add(highSchoolBuilding);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(156, 199, 115, 29);
		contentPane.add(btnNext);
		
		btnNext.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		      
		    	// K to 5th grade building (Building A)
		    	if (btnNext.isEnabled() && kToFifthGradeBuilding.isSelected()) {
		    		requestedBuildingU="BuldA";
		    		request1.setRequestedBuiliding(requestedBuildingU);
		        	NumberOfStudents student2 = new NumberOfStudents(request1, A, B, C,requestsDictionary );
					student2.setVisible(true);
					setVisible(false);
		        }
		    	
		        // 6th to 8th grade building (Building B)
		        else if (btnNext.isEnabled() && sixToEighthGradeBuilding.isSelected()) { 
		        	requestedBuildingU="BuldB";
		        	request1.setRequestedBuiliding(requestedBuildingU);
		        	NumberOfStudents student2 = new NumberOfStudents(request1, A, B, C, requestsDictionary );
					student2.setVisible(true);
					setVisible(false);
		        }
		    	
		    	// High School grade building (Building C)
		        else if (btnNext.isEnabled() && highSchoolBuilding.isSelected()) {
		        	requestedBuildingU="BuldC";
		        	request1.setRequestedBuiliding(requestedBuildingU);
		        	NumberOfStudents student2 = new NumberOfStudents(request1, A, B, C, requestsDictionary );
					student2.setVisible(true);
					setVisible(false);
 }
		    }
		});
		}
		
		
	}
