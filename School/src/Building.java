import java.time.*;

import java.util.Calendar;

//****************************************************
//Class: Building
//Date:	4/2018
//Author:  Gilda Rodriguez & Riddhi Choudhary
//Purpose: Building that holds array of rooms. Can cancel/
//book available rooms in the building
//****************************************************
public class Building{
	private Room[] room;
	private int size;
	private String buildingName;
	Calendar c = Calendar.getInstance();

	/**
	 * Constructor with buildingName and no roomCapacity. 
	 * Room Capacity is automatically set to 20 rooms for the building
	 * @param buildingName: Name of the building
	 */
	public Building(String buildingName) {
		room = new Room [20];
		this.buildingName = buildingName;
		size=0;
	}

	/**
	 * Constructor with buildingName and roomCapacity of the building
	 * @param buildingName: Name of the building
	 * @param capacity: how many rooms the building can hold
	 */
	public Building(String buildingName, int capacity) {
		room = new Room [capacity];
		this.buildingName = buildingName;
		size=0;
	}

	/**
	 *addRoom Method adds a certain room into the building
	 * @param roomName: Name of the Room to be added into the building
	 * @param capacity: Capacity of the room to be added to the room
	 * @param isArtRoom: true if the room has art supplies
	 * @param isMusicRoom: true if the room has music supplies
	 * @param isComputerRoom: true if the room has computers
	 * @param isLibrary: true if the room is a library
	 * @param isGym: true if the room is a gym
	 * @param isScienceLab: true if the room is a science room
	 * @return boolean: true if the addRoom to building was successful and false if not
	 */
	public boolean addRoom(String roomName, int capacity, boolean isArtRoom, 
			boolean isMusicRoom, boolean isComputerRoom, boolean isLibrary, 
			boolean isGym, boolean isScienceLab){
		if (!isFull()) {
			Room roomAdd = new Room(roomName, capacity, isArtRoom, isMusicRoom, isComputerRoom, isLibrary, isGym, isScienceLab);
			room[size] = roomAdd;
			size++;
			return true;
		}
		return false;
	}

	/**
	 * printBuilding prints out all the Names of the rooms in the building 
	 * and also all of the times that room is booked
	 */
	public void printBuilding() {
		System.out.println(buildingName);
		for(int i = 0; i<size; i++) {
			room[i].printRoom();
			room[i].allTimesBooked();
		}
	}


	/**
	 * bookRoomInBuilding books a certain room in the building
	 * given the name of the room and date and time you want it to be booked
	 * @param roomName: name of the room to be booked in the building
	 * @param date: date you want the room to be booked in the building
	 * @param time: time you want the room to be booked
	 * @return isBooked: true if room could be booked in the building/false
	 * if it could not be
	 */
	public boolean bookRoomInBuilding(String roomName, String date, String time, Request request) {	
		boolean isBooked=false;
		for(int i = 0; i<size; i++) {
			if ((room[i].getRoomName()).equalsIgnoreCase(roomName) && 
					(request.getNumberOfStudentRequested() <= room[i].roomCapacity)) {
				isBooked = room[i].bookRoom(date, time, request);
				request.setRoomBooked(room[i].getRoomName());
			}
		}	
		return isBooked;
	}
	/**
	 * Method resets data for Monday in 2D array
	 */
	public void buildingRoomResetMonday() {
		for(int i = 0; i<size; i++) {
			room[i].roomResetMonday();
		}	
	}

	/**
	 * Method resets data for Tuesday in 2D array
	 */
	public void buildingRoomResetTuesday() {
		for(int i = 0; i<size; i++) {
			room[i].roomResetTuesday();
		}	
	}
	
	/**
	 * Method resets data for Wednesday in 2D array
	 */
	public void buildingRoomResetWednesday() {
		for(int i = 0; i<size; i++) {
			room[i].roomResetWednesday();
		}
	}
	
	/**
	 * Method resets data for Thursday in 2D array
	 */
	public void buildingRoomResetThursday() {
		for(int i = 0; i<size; i++) {
			room[i].roomResetThursday();
		}
	}
	
	/**
	 * Method resets data for Friday in 2D array
	 */
	public void buildingRoomResetFriday() {
		for(int i = 0; i<size; i++) {
			room[i].roomResetFriday();
		}
	}
	
	/**
	 * Books first available room in the building traversing 
	 * through the array as long as it is fits the size requested
	 * @param date: date user requested to be booked
	 * @param time: time user requested to be booked
	 * @param request: the request object that holds all info collected from user
	 * @return boolean: true if booking successful
	 */
	public boolean bookFirstAvalibleRoom(String date, String time, Request request) {
		boolean isBooked=false;
		for(int i = 0; i<size && !isBooked; i++) {
			if ((room[i].isEmpty(date, time))&& 
					(request.getNumberOfStudentRequested() <= room[i].roomCapacity)&& 
					(!room[i].getIsLibraryRoom()) &&
					(!room[i].getIsGym()) &&
					(!room[i].getIsArtRoom()) &&
					(!room[i].getIsMusicRoom()) &&
					(!room[i].getIsComputerRoom())
					) {
				isBooked = room[i].bookRoom(date, time, request);
				request.setRoomBooked(room[i].getRoomName());
			}	

		}	

		if(isBooked == false) {
			for(int i = 0; i<size && !isBooked; i++) {
				if ((room[i].isEmpty(date, time))&& (room[i].roomCapacity >= request.getNumberOfStudentRequested())){
					isBooked = room[i].bookRoom(date, time, request);
					request.setRoomBooked(room[i].getRoomName());
				}
			}

		}
		return isBooked;
	}

	/**
	 * cancelRoomInBuilding cancels a booked room in the building given the 
	 * roomName, date, and time
	 * @param roomName: name of the Room to be cancelled
	 * @param date: the date the room is to be cancelled
	 * @param time: the time the room is to be cancelled
	 * @return boolean: true if cancel Room was successful and false if 
	 * it was not successful
	 */
	public boolean cancelRoomInBuilding(String roomName, String date, String time) {
		boolean cancelRoom=false;
		for(int i = 0; i<size; i++) {
			if ((room[i].getRoomName()).equalsIgnoreCase(roomName)) {
				cancelRoom = room[i].cancelRoom(date, time);
			}
		}	
		return cancelRoom;
	}
	/**
	 * isFull returns true if the building is full of rooms
	 * @return: boolean true if building if full of rooms, false if building is 
	 * not full of rooms
	 */
	private boolean isFull() {
		return size == room.length;
	}


	//****************************************************
	// Class:   Room
	// Date:	4/2018
	// Author:  Gilda Rodriguez & Riddhi Choudhary
	// Purpose: Room has different characteristics and 
	//          a 2D calender to book rooms. Also has methods to 
	//          book room, cancel rooms, reset room data, and check
	//          if rooms are filled or empty
	//****************************************************
	private class Room{
		String roomName;        // name of room 
		boolean isArtRoom;      // art room
		boolean isMusicRoom;    // music room
		boolean isComputerRoom; // computer room
		boolean isLibrary;      // library 
		boolean isGym;          // gym
		boolean isScienceLab;	// science lab
		int roomCapacity; 
		int[] whenAvalible;
		
		Request[][] allTime = new Request[][]{
			{ null, null,null, null, null },
			{ null, null, null, null, null },
			{ null, null, null, null, null },
			{ null, null, null, null, null },
			{ null, null, null, null, null },
			{ null, null, null, null, null }
		};

		/**
		 * 
		 * @param roomName
		 * @param capacity
		 * @param isArtRoom
		 * @param isMusicRoom
		 * @param isComputerRoom
		 * @param isLibrary
		 * @param isGym
		 * @param isScienceLab
		 */
		private Room(String roomName, int capacity, boolean isArtRoom, 
				boolean isMusicRoom, boolean isComputerRoom, boolean isLibrary, 
				boolean isGym, boolean isScienceLab){
			this.roomName = roomName; 
			roomCapacity = capacity; 
			this.isArtRoom = isArtRoom;
			this.isMusicRoom = isMusicRoom;
			this.isComputerRoom = isComputerRoom;
			this.isLibrary = isLibrary;
			this.isGym = isGym;
			this.isScienceLab = isScienceLab;
		}
		/**
		 * Returns true if room is music room
		 * @return true if room is music room
		 */

		public boolean getIsMusicRoom() {
			return isMusicRoom;
		}

		/**
		 * print the roomName
		 */
		private void printRoom() {
			System.out.println(roomName );
		}
		/**
		 *return the roomName
		 */
		private String getRoomName() {
			return roomName;
		}

		/**
		 * Returns true if room is art room
		 * @return true if room is art room
		 */

		public boolean getIsArtRoom() {
			return isArtRoom;
		}
		/**
		 * 
		 * @return true if computer room
		 */
		public boolean getIsComputerRoom() {
			return isComputerRoom;
		}

		/**
		 * 
		 * @return true if library room is chosen
		 */
		public boolean getIsLibraryRoom() {
			return isLibrary;
		}

		/**
		 * 
		 * @return true if gym room is chosen
		 */
		public boolean getIsGym() {
			return isGym;
		}

		/**
		 * 
		 * @return true if science room is chosen
		 */
		public boolean getIsScienceLab() {
			return isScienceLab;
		}


		/**
		 * Prints out the 2D array shows if rooms are booked 
		 * or empty for that room
		 */
		private void allTimesBooked(){
			boolean[][] newArr=new boolean[allTime.length][allTime[0].length];
			for(int i=0;i<allTime.length;i++)
			{
				for(int j=0;j<allTime[0].length;j++)
				{
					
					if (allTime[i][j] != null) {
						allTime[i][j].printRequest();

					}

					else {
						System.out.print(allTime[i][j] + " ");	
					}


				} 
				System.out.println();
			}  
			//return newArr;     
		}

		/**
		 * isBooked returns true if the room is already 
		 * booked at the certain date and time/ false if it is not
		 * already booked
		 * @param date: the date when to check if room is Booked
		 * @param time: the time when to check if room is booked
		 * @return true if room is booked. false if not. 
		 */
		private boolean isBooked(String date, String time) {
			
			// Monday
			if(date.equalsIgnoreCase("Monday") && time.equals("3-4pm") && allTime[0][0]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Monday") && time.equals("4-5pm") && allTime[1][0]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Monday") && time.equals("5-6pm") && allTime[2][0]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Monday") && time.equals("6-7pm") && allTime[3][0]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Monday") && time.equals("7-8pm") && allTime[4][0]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Monday") && time.equals("8-9pm") && allTime[5][0]!=null) {
				return true;
			}
			//Tuesday
			else if(date.equalsIgnoreCase("Tuesday") && time.equals("3-4pm") && allTime[0][1]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Tuesday") && time.equals("4-5pm") && allTime[1][1]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Tuesday") && time.equals("5-6pm") && allTime[2][1]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Tuesday") && time.equals("6-7pm")&& allTime[3][1]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Tuesday") && time.equals("7-8pm")&& allTime[4][1]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Tuesday") && time.equals("8-9pm") && allTime[5][1]!=null) {
				return true;
			}

			// Wednesday
			else if(date.equalsIgnoreCase("Wednesday") && time.equals("3-4pm") && allTime[0][2]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Wednesday") &&  time.equals("4-5pm") && allTime[1][2]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Wednesday") && time.equals("5-6pm") && allTime[2][2]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Wednesday") && time.equals("6-7pm")&& allTime[3][2]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Wednesday") && time.equals("7-8pm") && allTime[4][2]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Wednesday") && time.equals("8-9pm") && allTime[5][2]!=null) {
				return true;
			}

			// Thursday
			else if(date.equalsIgnoreCase("Thursday") && time.equals("3-4pm") && allTime[0][3]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Thursday") && time.equals("4-5pm") &&  allTime[1][3]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Thursday") &&time.equals("5-6pm") && allTime[2][3]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Thursday") && time.equals("6-7pm") && allTime[3][3]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Thursday") && time.equals("7-8pm") && allTime[4][3]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Thursday") && time.equals("8-9pm") && allTime[5][3]!=null) {
				return true;
			}

			// Friday
			else if(date.equalsIgnoreCase("Friday") && time.equals("3-4pm") && allTime[0][4]!=null ) {
				return true;
			}
			else if(date.equalsIgnoreCase("Friday") && time.equals("4-5pm") && allTime[1][4]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Friday") && time.equals("5-6pm")  && allTime[2][4]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Friday") && time.equals("6-7pm") && allTime[3][4]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Friday") && time.equals("7-8pm") && allTime[4][4]!=null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Friday") && time.equals("8-9pm") && allTime[5][4] !=null) {
				return true;
			}
			return false;	
		}

		/**
		 * cancelRoom cancels the room booked given the date and 
		 * time
		 * @param date : the date when the room is to cancelled
		 * @param time : the time when the room is to be cancelled
		 * @return boolean: true if cancelRoom request was successful/false if not
		 */

		private boolean cancelRoom(String date, String time) {
			

			if(isBooked(date, time)) {
				// Monday
				if(date.equalsIgnoreCase("Monday") && time.equals("3-4pm")) {
					allTime[0][0]=null;
				}
				else if(date.equalsIgnoreCase("Monday") && time.equals("4-5pm")) {
					allTime[1][0]=null;
				}
				else if(date.equalsIgnoreCase("Monday") && time.equals("5-6pm")) {
					allTime[2][0]=null;
				}
				else if(date.equalsIgnoreCase("Monday") && time.equals("6-7pm")) {
					allTime[3][0]=null;
				}
				else if(date.equalsIgnoreCase("Monday") && time.equals("7-8pm")) {
					allTime[4][0]=null;
				}
				
				else if(date.equalsIgnoreCase("Monday") && time.equals("8-9pm")) {
					allTime[5][0]=null;
				}

				//Tuesday
				else if(date.equalsIgnoreCase("Tuesday") && time.equals("3-4pm")) {
					allTime[0][1]=null;
				}
				else if(date.equalsIgnoreCase("Tuesday") && time.equals("4-5pm")) {
					allTime[1][1]=null;
				}
				else if(date.equalsIgnoreCase("Tuesday") &&time.equals("5-6pm")) {
					allTime[2][1]=null;
				}
				else if(date.equalsIgnoreCase("Tuesday") && time.equals("6-7pm")) {
					allTime[3][1]=null;
				}
				else if(date.equalsIgnoreCase("Tuesday") && time.equals("7-8pm")) {
					allTime[4][1]=null;
				}
				else if(date.equalsIgnoreCase("Tuesday") && time.equals("8-9pm")) {
					allTime[5][1]=null;
				}

				// Wednesday
				else if(date.equalsIgnoreCase("Wednesday") && time.equals("3-4pm")) {
					allTime[0][2]=null;
				}
				else if(date.equalsIgnoreCase("Wednesday") && time.equals("4-5pm")) {
					allTime[1][2]=null;
				}
				else if(date.equalsIgnoreCase("Wednesday") && time.equals("5-6pm")) {
					allTime[2][2]=null;
				}
				else if(date.equalsIgnoreCase("Wednesday") && time.equals("6-7pm")) {
					allTime[3][2]=null;
				}
				else if(date.equalsIgnoreCase("Wednesday") && time.equals("7-8pm")) {
					allTime[4][2]=null;
				}
				else if(date.equalsIgnoreCase("Wednesday") && time.equals("8-9pm")) {
					allTime[5][2]=null;
				}

				// Thursday
				else if(date.equalsIgnoreCase("Thursday") &&  time.equals("3-4pm")) {
					allTime[0][3]=null;
				}
				else if(date.equalsIgnoreCase("Thursday") && time.equals("4-5pm")) {
					allTime[1][3]=null;
				}
				else if(date.equalsIgnoreCase("Thursday") && time.equals("5-6pm")) {
					allTime[2][3]=null;
				}
				else if(date.equalsIgnoreCase("Thursday") && time.equals("6-7pm")) {
					allTime[3][3]=null;
				}
				else if(date.equalsIgnoreCase("Thursday") && time.equals("7-8pm")) {
					allTime[4][3]=null;
				}
				else if(date.equalsIgnoreCase("Thursday") && time.equals("8-9pm")) {
					allTime[5][3]=null;
				}

				// Friday
				else if(date.equalsIgnoreCase("Friday") && time.equals("3-4pm")) {
					allTime[0][4]=null;
				}
				else if(date.equalsIgnoreCase("Friday") && time.equals("4-5pm")) {
					allTime[1][4]=null;
				}
				else if(date.equalsIgnoreCase("Friday") && time.equals("5-6pm")) {
					allTime[2][4]=null;
				}
				else if(date.equalsIgnoreCase("Friday") && time.equals("6-7pm")) {
					allTime[3][4]=null;
				}
				else if(date.equalsIgnoreCase("Friday") &&time.equals("7-8pm")) {
					allTime[4][4]=null;
				}
				else if(date.equalsIgnoreCase("Friday") && time.equals("8-9pm")) {
					allTime[5][4]=null;
				}
				return true; 

			}

			return false; 
		}

		/**
		 * Books room by changing false to true.
		 * @param date
		 * @param time
		 * @return returns true if room was successfully booked. false if not. 
		 */
		private boolean bookRoom (String date, String time, Request request) {
			

			if(isEmpty(date, time)) {
				// Monday
				if(date.equalsIgnoreCase("Monday") &&  time.equals("3-4pm")) {
					allTime[0][0]=request;
					request.setTimeBooked("3-4pm");
					request.setDateBooked("Monday");
				}
				else if(date.equalsIgnoreCase("Monday") &&  time.equals("4-5pm")) {
					allTime[1][0]=request;
					request.setTimeBooked("4-5pm");
					request.setDateBooked("Monday");
				}
				else if(date.equalsIgnoreCase("Monday") &&  time.equals("5-6pm")) {
					allTime[2][0]=request;
					request.setTimeBooked("5-6pm");
					request.setDateBooked("Monday");
				}
				else if(date.equalsIgnoreCase("Monday") &&  time.equals("6-7pm")) {
					allTime[3][0]=request;
					request.setTimeBooked("6-7pm");
					request.setDateBooked("Monday");
				}
				else if(date.equalsIgnoreCase("Monday") &&  time.equals("7-8pm")) {
					allTime[4][0]=request;
					request.setTimeBooked("7-8pm");
					request.setDateBooked("Monday");
				}
				else if(date.equalsIgnoreCase("Monday") &&  time.equals("8-9pm")) {
					allTime[5][0]=request;
				}

				//Tuesday
				else if(date.equalsIgnoreCase("Tuesday") &&  time.equals("3-4pm")) {
					allTime[0][1]=request;
					request.setTimeBooked("3-4pm");
					request.setDateBooked("Tuesday");
				}
				else if(date.equalsIgnoreCase("Tuesday") && time.equals("4-5pm")) {
					allTime[1][1]=request;
					request.setTimeBooked("4-5pm");
					request.setDateBooked("Tuesday");
				}
				else if(date.equalsIgnoreCase("Tuesday") && time.equals("5-6pm")) {
					allTime[2][1]=request;
					request.setTimeBooked("5-6pm");
					request.setDateBooked("Tuesday");
				}
				else if(date.equalsIgnoreCase("Tuesday") && time.equals("6-7pm")) {
					allTime[3][1]=request;
					request.setTimeBooked("6-7pm");
					request.setDateBooked("Tuesday");
				}
				else if(date.equalsIgnoreCase("Tuesday") && time.equals("7-8pm")) {
					allTime[4][1]=request;
					request.setTimeBooked("7-8pm");
					request.setDateBooked("Tuesday");
				}
				else if(date.equalsIgnoreCase("Tuesday") && time.equals("8-9pm")) {
					allTime[5][1]=request;
					request.setTimeBooked("8-9pm");
					request.setDateBooked("Tuesday");
				}

				// Wednesday
				else if(date.equalsIgnoreCase("Wednesday") && time.equals("3-4pm")) {
					allTime[0][2]=request;
					request.setTimeBooked("3-4pm");
					request.setDateBooked("Wednesday");
				}
				else if(date.equalsIgnoreCase("Wednesday") && time.equals("4-5pm")) {
					allTime[1][2]=request;
					request.setTimeBooked("4-5pm");
					request.setDateBooked("Wednesday");
				}
				else if(date.equalsIgnoreCase("Wednesday") && time.equals("5-6pm")) {
					allTime[2][2]=request;
					request.setTimeBooked("5-6pm");
					request.setDateBooked("Wednesday");
				}
				else if(date.equalsIgnoreCase("Wednesday") && time.equals("6-7pm")) {
					allTime[3][2]=request;
					request.setTimeBooked("6-7pm");
					request.setDateBooked("Wednesday");
				}
				else if(date.equalsIgnoreCase("Wednesday") && time.equals("7-8pm")) {
					allTime[4][2]=request;
					request.setTimeBooked("7-8pm");
					request.setDateBooked("Wednesday");
				}
				else if(date.equalsIgnoreCase("Wednesday") && time.equals("8-9pm")) {
					allTime[5][2]=request;
				}

				// Thursday
				else if(date.equalsIgnoreCase("Thursday") && time.equals("3-4pm")) {
					allTime[0][3]=request;
					request.setTimeBooked("3-4pm");
					request.setDateBooked("Thursday");
				}
				else if(date.equalsIgnoreCase("Thursday") && time.equals("4-5pm")) {
					allTime[1][3]=request;
					request.setTimeBooked("4-5pm");
					request.setDateBooked("Thursday");
				}
				else if(date.equalsIgnoreCase("Thursday") && time.equals("5-6pm")) {
					allTime[2][3]=request;
					request.setTimeBooked("5-6pm");
					request.setDateBooked("Thursday");
				}
				else if(date.equalsIgnoreCase("Thursday") && time.equals("6-7pm")) {
					allTime[3][3]=request;
					request.setTimeBooked("6-7pm");
					request.setDateBooked("Thursday");
				}
				else if(date.equalsIgnoreCase("Thursday") && time.equals("7-8pm")) {
					allTime[4][3]=request;
					request.setTimeBooked("7-8pm");
					request.setDateBooked("Thursday");
				}
				else if(date.equalsIgnoreCase("Thursday") && time.equals("8-9pm")) {
					allTime[5][3]=request;
				}

				// Friday
				else if(date.equalsIgnoreCase("Friday") &&  time.equals("3-4pm")) {
					allTime[0][4]=request;
					request.setTimeBooked("3-4pm");
					request.setDateBooked("Friday");
				}
				else if(date.equalsIgnoreCase("Friday") && time.equals("4-5pm")) {
					allTime[1][4]=request;
					request.setTimeBooked("4-5pm");
					request.setDateBooked("Friday");
				}
				else if(date.equalsIgnoreCase("Friday") && time.equals("5-6pm")) {
					allTime[2][4]=request;
					request.setTimeBooked("5-6pm");
					request.setDateBooked("Friday");
				}
				else if(date.equalsIgnoreCase("Friday") && time.equals("6-7pm")) {
					allTime[3][4]=request;
					request.setTimeBooked("6-7pm");
					request.setDateBooked("Friday");
				}
				else if(date.equalsIgnoreCase("Friday") && time.equals("7-8pm")) {
					allTime[4][4]=request;
					request.setTimeBooked("7-8pm");
					request.setDateBooked("Friday");
				}
				else if(date.equalsIgnoreCase("Friday") && time.equals("8-9pm")) {
					allTime[5][4]=request;
				}
				return true; //room was booked at the time

			}
			request.setReasonFailed("Room was not empty at the time");

			return false; //if the room was not empty at the time
		}

		/**
		 * isEmpty checks if room is empty at that date and time
		 * @param date: date to check if room is empty at that day
		 * @param time: time to check if room is empty at that time
		 * @return true if empty and false if not.
		 */
		private boolean isEmpty(String date, String time) {
		
			// Monday
			if(date.equalsIgnoreCase("Monday") && time.equals("3-4pm") &&allTime[0][0]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Monday") && time.equals("4-5pm") && allTime[1][0]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Monday") && time.equals("5-6pm")&& allTime[2][0]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Monday") && time.equals("6-7pm") && allTime[3][0]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Monday") && time.equals("7-8pm") && allTime[4][0]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Monday") && time.equals("8-9pm") && allTime[5][0]==null) {
				return true;
			}
			//Tuesday
			else if(date.equalsIgnoreCase("Tuesday") && time.equals("3-4pm") && allTime[0][1]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Tuesday") && time.equals("4-5pm") && allTime[1][1]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Tuesday") && time.equals("5-6pm") && allTime[2][1]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Tuesday") && time.equals("6-7pm") && allTime[3][1]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Tuesday") && time.equals("7-8pm") && allTime[4][1]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Tuesday") && time.equals("8-9pm") && allTime[5][1]==null) {
				return true;
			}

			// Wednesday
			else if(date.equalsIgnoreCase("Wednesday") && time.equals("3-4pm") && allTime[0][2]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Wednesday") && time.equals("4-5pm") && allTime[1][2]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Wednesday") && time.equals("5-6pm") && allTime[2][2]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Wednesday") && time.equals("6-7pm") && allTime[3][2]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Wednesday") && time.equals("7-8pm") && allTime[4][2]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Wednesday") && time.equals("8-9pm") && allTime[5][2]==null) {
				return true;
			}


			// Thursday
			else if(date.equalsIgnoreCase("Thursday") && time.equals("3-4pm") && allTime[0][3]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Thursday") && time.equals("4-5pm") && allTime[1][3]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Thursday") && time.equals("5-6pm") && allTime[2][3]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Thursday") && time.equals("6-7pm") && allTime[3][3]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Thursday") && time.equals("7-8pm") && allTime[4][3]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Thursday") && time.equals("8-9pm") && allTime[5][3]==null) {
				return true;
			}

			// Friday
			else if(date.equalsIgnoreCase("Friday") && time.equals("3-4pm") && allTime[0][4]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Friday") && time.equals("4-5pm") && allTime[1][4]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Friday") && time.equals("5-6pm") && allTime[2][4]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Friday") && time.equals("6-7pm") && allTime[3][4]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Friday") && time.equals("7-8pm") && allTime[4][4]==null) {
				return true;
			}
			else if(date.equalsIgnoreCase("Friday") && time.equals("8-9pm") && allTime[5][4]==null) {
				return true;
			}
			return false;

		}
		
		/**
		 * resets rooms on Monday. Makes rooms null.
		 */
		public void roomResetMonday() {
			for(int i=0;i<allTime.length;i++) {
				allTime[i][0]=null;
			}
		}
		/**
		 * Makes rooms on Tuesday null. Resets rooms.
		 */
		public void roomResetTuesday() {
			for(int i=0;i<allTime.length;i++)
			{
				allTime[i][1]=null;
			}
		}
		/**
		 * Makes rooms on Wednesday null. Resets rooms.
		 */
		public void roomResetWednesday() {
			for(int i=0;i<allTime.length;i++)
			{
				allTime[i][2]=null;
			}
		}
		/**
		 * Makes rooms on Thursday null. Resets rooms.
		 */
		public void roomResetThursday() {
			for(int i=0;i<allTime.length;i++)
			{
				allTime[i][3]=null;
			}
		}
		/**
		 * Makes rooms on Friday null. Resets rooms.
		 */
		public void roomResetFriday() {
			for(int i=0;i<allTime.length;i++)
			{
				allTime[i][4]=null;
			}
		}


	}
}
