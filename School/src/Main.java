import java.awt.EventQueue;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Dictionary;
import java.util.Hashtable;
//****************************************************
// Class:   Main
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: Main Class that Runs the School Project. 
//****************************************************

public class Main {
	public static void main(String[] args) {
		
		Dictionary<Request, Integer> allRequests = new Hashtable<Request,Integer>();
		Request request1 = new Request();
		WholeSchool school = new WholeSchool();
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Name frame = new Name(request1, school.getBuldA(), school.getBuldB(), school.getBuldC(), allRequests);
					frame.setVisible(true);	
				} 
					
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}	