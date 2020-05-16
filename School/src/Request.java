
import java.util.Dictionary;
import java.util.Random;
//****************************************************
// Class:   Request
// Date:    4/2018 
// Author:  Gilda Rodriguez & Riddhi Choudhary
// Purpose: Holds all the information gathered from 
//user of what type of request they want and 
//updates fields to when and where and what room
//was booked
//****************************************************
public class Request {

	private String requestType; //cancel or booking request
	private String searchType; //search room by building, room, or size
	private int numberOfStudentRequested; //number of students they need room for
	private String timeRequested; //the time user wants room
	private String requestedRoom; //the specific room user wants
	private int requestNumber; //the request number of the request
	private String dateRequested; //the day user wants room: monday, tuesday etc
	public String whichOverallDateBookedRequested; //the date this request booked
	private String requestedBuilding; //the building user requested booked
	private String nameOfRequestor; //name
	private String dateBooked; // the day room was booked: monday, tuesday, etc
	public String timeBooked;  // the time booked
	public String roomBooked; //the room that was eventually booked
	public String buildingBooked; //the building that was eventually booked
	public String reasonFailed; // the reason request was not successful
	public String whichOverallDateBooked; //the date that request was booked
	
	/**
	 * constructor
	 */
	public Request( ) {
		requestType=null;
		searchType = null;
		numberOfStudentRequested=0;
		timeRequested=null;
		requestedRoom= null;
		requestNumber=0;
		dateRequested = null;
		requestedBuilding= null;
		nameOfRequestor=null;
		dateBooked = null;
		timeBooked = null; 
		roomBooked = null;
		buildingBooked = null;
		
	}
	
	/**
	 * 
	 * @param date: set the date that room was booked 
	 */
	public void setwhichOverallDateBookedRequested(String date){
		whichOverallDateBookedRequested = date;
	}
	
	/**
	 * 
	 * @return: which date room was booked
	 */
	public String getwhichOverallDateBookedRequested() {
		return whichOverallDateBookedRequested;
	}
	
	/**
	 * 
	 * @param date: tset the date that the room was booked 
	 */
	public void  setwhichOverallDateBooked(String date) {
		whichOverallDateBooked = date;
	}
	
	/**
	 * 
	 * @return: which date room was booked
	 */
	public String  getwhichOverallDateBooked() {
		return whichOverallDateBooked;
	}
	/**
	 * 
	 * @param time: set the time room was booked
	 */
	public void setTimeBooked(String time) {
		timeBooked = time;
	}
	
	/**
	 * 
	 * @param reason: set reason failed for request
	 */
	public void setReasonFailed(String reason) {
		reasonFailed = reason;
	}
	
	/**
	 * 
	 * @return: String reason failed
	 */
	public String getReasonFailed() {
		return reasonFailed;
	}
	
	/**
	 * 
	 * @return: String the time room was booked
	 */
	public String getTimeBooked() {
		return timeBooked;
	}
	
	/**
	 * 
	 * @param room: room that was booked
	 */
	public void setRoomBooked( String room) {
		roomBooked = room;
	}
	/**
	 * 
	 * @return: String: the room that was booked
	 */
	public String getRoomBooked() {
		return roomBooked;
	}
	/**
	 * 
	 * @param building: the building that was booked
	 */
	
	public void setBuildingBooked(String building) {
		buildingBooked = building;
	}
	
	/**
	 * 
	 * @return: String the building booked
	 */
	public String getBuildingBooked() {
		return buildingBooked;
	}
	
	/**
	 * 
	 * @param name: the name of the requestor
	 */
	public void setNameOfRequestor(String name) {
		nameOfRequestor = name;
	}
	
	/**
	 * 
	 * @return: String the name of the requestor
	 */
	public String getNameOfRequestor() {
		return nameOfRequestor;
	}
	/**
	 * 
	 * @return: the date user requested to be booked
	 */
	public String getDateRequested() {
		return dateRequested;
	}
	
	/**
	 * 
	 * @param dateRequested: the date request to be booked
	 */
	public void setDateRequested(String dateRequested) {
		this.dateRequested = dateRequested;
	}
	
	/**
	 * 
	 * @return: the building user wants to book
	 */
	public String getRequestedBuilding() {
		return requestedBuilding;
	}
	
	/**
	 * 
	 * @param requestedBuilding: set the building user wants to book
	 */
	public void setRequestedBuiliding(String requestedBuilding) {
		this.requestedBuilding = requestedBuilding;
	}
	
	/**
	 * 
	 * @return: they type of request they made: cancel or book
	 */
	public String getRequestType() {
		return requestType;
	}
	/**
	 * 
	 * @param requestType: set the type of request made
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	
	/**
	 * 
	 * @return: the type of search user requested
	 */
	public String getSearchType() {
		return searchType;
	}
	
	/**
	 * set the serach type
	 * @param searchType: the search type 
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	/**
	 * 
	 * @return: the number of students they requested
	 */
	public int getNumberOfStudentRequested() {
		return numberOfStudentRequested;
	}
	
	/**
	 * 
	 * @param numberOfStudentRequested: the number of students they requested 
	 */
	public void setNumberOfStudentsRequested(int numberOfStudentRequested) {
		this.numberOfStudentRequested = numberOfStudentRequested;
	}
	/**
	 * 
	 * @return: the time user requested
	 */
	public String getTimeRequested() {
		return timeRequested;
	}
	/**
	 * 
	 * @return: the time user requested
	 */
	public void setTimeRequested(String timeRequested){
		this.timeRequested = timeRequested;
	}
	/**
	 * 
	 * @return: the room requested
	 */
	public String getRequestedRoom() {
		return requestedRoom;
	}
	/**
	 * 
	 * @return: the room user requested to book
	 */
	public void setRequestedRoom(String requestedRoom) {
		this.requestedRoom = requestedRoom;
	}
	/**
	 * 
	 * @return: the request number of request
	 */
	public int getRequestNumber() {
		return requestNumber;
	}
	/**
	 * 
	 * @param requestNumber: set request number for object
	 */
	public void setRequestNumber(int requestNumber) {
		this.requestNumber = requestNumber;
	}
	
	/**
	 * Prints out the name of requester
	 */
	public void printRequest() {
		System.out.print(nameOfRequestor + " ");
		
	}
	
	/**
	 * 
	 * @return: return the day the room was booked: monday, tuesday etc
	 */
	public String getDateBooked() {
		return dateBooked;
	}
	/**
	 * 
	 * @param dateBooked: set the day the room was booked
	 */
	public void setDateBooked(String dateBooked) {
		this.dateBooked = dateBooked;
	}
}
