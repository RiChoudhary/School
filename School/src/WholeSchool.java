//****************************************************
// Class:   WholeSchool
// Date:	4/2018
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: Holds an array of 3 buildings
//****************************************************
public class WholeSchool {

	Building[] array;

	public WholeSchool() {
	Building buldA = new Building("Building A");
	Building buldB = new Building("Building B");
	Building buldC = new Building("Building C");
	
	// Building A K - 5th
	buldA.addRoom("Library", 100, false, false, false, true, false, false);
	buldA.addRoom("Gym", 100, false, false, false, false, true, false);
	buldA.addRoom("Art", 30, true, false, false, false, false, false);
	buldA.addRoom("Music Room", 30, false, true, false, false, false, false);
	buldA.addRoom("100", 30, false, false, false, false, false, false);
	buldA.addRoom("101", 30, false, false, false, false, false, false);
	buldA.addRoom("102", 30, false, false, false, false, false, false);
	buldA.addRoom("103", 30, false, false, false, false, false, false);
	buldA.addRoom("104", 30, false, false, false, false, false, false);
	buldA.addRoom("105", 30, false, false, false, false, false, false);
	buldA.addRoom("106", 30, false, false, false, false, false, false);
	buldA.addRoom("107", 30, false, false, false, false, false, false);
	buldA.addRoom("108", 30, false, false, false, false, false, false);
	buldA.addRoom("109", 30, false, false, false, false, false, false);
	buldA.addRoom("110", 30, false, false, false, false, false, false);
	buldA.addRoom("111", 30, false, false, false, false, false, false);
	buldA.addRoom("112", 30, false, false, false, false, false, false);
	buldA.addRoom("113", 30, false, false, false, false, false, false);
	buldA.addRoom("114", 30, false, false, false, false, false, false);
	buldA.addRoom("115", 30, false, false, false, false, false, false);
	
	
	// Building B 6th - 8th
	buldB.addRoom("Library", 100, false, false, false, true, false, false);
	buldB.addRoom("Gym", 100, false, false, false, false, true, false);
	buldB.addRoom("Art", 30, true, false, false, false, false, false);
	buldB.addRoom("Music Room", 30, false, true, false, false, false, false);
	buldB.addRoom("Computer Lab", 50, false, false, true, false, false, false);
	buldB.addRoom("Science Lab", 30, false, false, false, false, false, true);
	buldB.addRoom("100", 30, false, false, false, false, false, false);
	buldB.addRoom("101", 30, false, false, false, false, false, false);
	buldB.addRoom("102", 30, false, false, false, false, false, false);
	buldB.addRoom("103", 30, false, false, false, false, false, false);
	buldB.addRoom("104", 30, false, false, false, false, false, false);
	buldB.addRoom("105", 30, false, false, false, false, false, false);
	buldB.addRoom("106", 30, false, false, false, false, false, false);
	buldB.addRoom("107", 30, false, false, false, false, false, false);
	buldB.addRoom("108", 30, false, false, false, false, false, false);
	buldB.addRoom("109", 30, false, false, false, false, false, false);
	buldB.addRoom("110", 30, false, false, false, false, false, false);
	buldB.addRoom("111", 30, false, false, false, false, false, false);
	buldB.addRoom("112", 30, false, false, false, false, false, false);
	buldB.addRoom("113", 30, false, false, false, false, false, false);
	buldB.addRoom("114", 30, false, false, false, false, false, false);
	buldB.addRoom("115", 30, false, false, false, false, false, false);
	
	
	
	// Building C High School;
	buldC.addRoom("Library", 100, false, false, false, true, false, false);
	buldC.addRoom("Gym", 100, false, false, false, false, true, false);
	buldC.addRoom("Art", 30, true, false, false, false, false, false);
	buldC.addRoom("Music Room", 30, false, true, false, false, false, false);
	buldC.addRoom("Computer Lab", 50, false, false, true, false, false, false);
	buldC.addRoom("Science Lab", 30, false, false, false, false, false, true);
	buldC.addRoom("100", 30, false, false, false, false, false, false);
	buldC.addRoom("101", 30, false, false, false, false, false, false);
	buldC.addRoom("102", 30, false, false, false, false, false, false);
	buldC.addRoom("103", 30, false, false, false, false, false, false);
	buldC.addRoom("104", 30, false, false, false, false, false, false);
	buldC.addRoom("105", 30, false, false, false, false, false, false);
	buldC.addRoom("106", 30, false, false, false, false, false, false);
	buldC.addRoom("107", 30, false, false, false, false, false, false);
	buldC.addRoom("108", 30, false, false, false, false, false, false);
	buldC.addRoom("109", 30, false, false, false, false, false, false);
	buldC.addRoom("110", 30, false, false, false, false, false, false);
	buldC.addRoom("111", 30, false, false, false, false, false, false);
	buldC.addRoom("112", 30, false, false, false, false, false, false);
	buldC.addRoom("113", 30, false, false, false, false, false, false);
	buldC.addRoom("114", 30, false, false, false, false, false, false);
	buldC.addRoom("115", 30, false, false, false, false, false, false);
	
	array = new Building[3];
	array[0]=buldA;
	array[1]=buldB;
	array[2]=buldC;
	}
	/**
	 * 
	 * @return the first Building buldA in school
	 */
	public Building getBuldA(){
		return array[0];
	}
	
	/**
	 * 
	 * @return 2nd Building buldB in school
	 */
	public Building getBuldB(){
		return array[1];
	}
	
	/**
	 * 
	 * @return 3rd Building buldC in school
	 */
	public Building getBuldC(){
		return array[2];
	}
}
