package player;

import java.util.Date;
import java.util.HashMap;

import rooms.Room;
import timetables.Lecture;
import timetables.Location;
import timetables.Timetable;

public class Player {

	private Room room;
	private Date time;
	private Timetable timetable;

	public Player(Room room) {
		this.room = room;
	}

	public Player(Date time, Timetable timeable) {

		this.time = time;
		this.timetable = timeable;

		Room bedroom = new Room("Bedroom");

		this.room = bedroom;

		Room kitchen = new Room("Kitchen");
		Room entrance = new Room("Entrance");
		Room busStop = new Room("Bus Stop");
		Room campusEx = new Room("Interchange");

		Room lanchester = new Room("Lanchester");
		Room lanchester3009 = new Room("07/3009");
		Room lanchester3027 = new Room("07/3027");

		Room EEE = new Room("32");
		Room EEE1015 = new Room("32/1015");

		Room SUSU = new Room("SUSU");
		Room SUSUCinema = new Room("42");

		Room mathematics = new Room("54");
		Room mathematics5025 = new Room("54/5025");
		Room mathematics4011 = new Room("54/4011");

		Room nightingale = new Room("67");
		Room nightingale1027 = new Room("67/1027");

		Room ECS = new Room("59");
		Room ECSTeachingLab = new Room("59/ECS Teaching lab");
		Room ECSComputerRoom = new Room("59/ComputerRoom");

		// TODO AVENUE

		bedroom.setGreeting("You hear an alarm clock, you wake up and turn it off. You close your eyes.");
		kitchen.setGreeting("You went to the kitchen, what do you want to do?");
		entrance.setGreeting("You went down the stairs and now you're outside the entrance, where now?");
		busStop.setGreeting("You went to the bus stop");
		campusEx.setGreeting("You arive at the bus interchange, now where to go?");

		lanchester.setGreeting("You went to the Lanchester building, now what?");
		lanchester3009.setGreeting("You arrive at the 07/3009 lecture room");
		lanchester3027.setGreeting("You went to the 3027 lecture room");

		EEE.setGreeting("You arrive at the EEE building");
		EEE1015.setGreeting("You're at the EEE building, room 1015");

		SUSU.setGreeting("You arrive at SUSU");
		SUSUCinema.setGreeting("You go to the cinema");

		nightingale.setGreeting("You arrived at the Nightingale building");
		nightingale1027.setGreeting("You went to the 1027 lecture room");

		mathematics.setGreeting("You arrive at the mathematics building");
		mathematics4011.setGreeting("You went to the 4011 lecture room in the mathematics building");
		mathematics5025.setGreeting("You went to the 5025 lecture room in the mathematics building");

		ECS.setGreeting("You arrive at the ECS building");
		ECSTeachingLab.setGreeting("You went to the ECS teaching lab");
		ECSComputerRoom.setGreeting("You went to the computer room");

		kitchen.addRoomToHashMap("Go to bedroom", bedroom);
		kitchen.addRoomToHashMap("Go out", entrance);

		bedroom.addRoomToHashMap("Go to kitchen", kitchen);
		bedroom.addRoomToHashMap("Go out", entrance);

		entrance.addRoomToHashMap("Go to room", bedroom);
		entrance.addRoomToHashMap("Go to bus stop", busStop);

		busStop.addRoomToHashMap("Go back", entrance);
		busStop.addRoomToHashMap("Get on bus", campusEx);

		campusEx.addRoomToHashMap("Go to Lanchester", lanchester);
		campusEx.addRoomToHashMap("Go to EEE", EEE);
		campusEx.addRoomToHashMap("Go to SUSU", SUSU);
		campusEx.addRoomToHashMap("Go to mathematics", mathematics);
		campusEx.addRoomToHashMap("Go to Nightingale", nightingale);
		campusEx.addRoomToHashMap("Go to ECS", ECS);

		lanchester.addRoomToHashMap("Go to 3009", lanchester3009);
		lanchester3009.addRoomToHashMap("Go to entrance", lanchester);
		lanchester.addRoomToHashMap("Go to 3027", lanchester3027);
		lanchester3027.addRoomToHashMap("Go to entrance", lanchester);

		EEE.addRoomToHashMap("Go to 1015", EEE1015);
		EEE1015.addRoomToHashMap("Go to entrance", EEE);

		SUSU.addRoomToHashMap("Go to cinema", SUSUCinema);
		SUSUCinema.addRoomToHashMap("Go to entrance", SUSU);

		mathematics.addRoomToHashMap("Go to 4011", mathematics4011);
		mathematics4011.addRoomToHashMap("Go to entrance", mathematics);
		mathematics.addRoomToHashMap("Go to 5025", mathematics5025);
		mathematics5025.addRoomToHashMap("go to entrance", mathematics);

		nightingale.addRoomToHashMap("Go to 1027", nightingale1027);
		nightingale1027.addRoomToHashMap("Go to entrance", nightingale);

		ECS.addRoomToHashMap("Go to computer room", ECSComputerRoom);
		ECSComputerRoom.addRoomToHashMap("Go to entrance", ECS);
		ECS.addRoomToHashMap("Go to teaching lab", ECSTeachingLab);
		ECSTeachingLab.addRoomToHashMap("Go to entrance", ECS);

		bedroom.printGreeting();
	}

	public Room getRoom() {
		return room;
	}

	public void goToRoom(String whereTo) {
		HashMap<String, Room> temp = room.getHashMap();

		if (temp.containsKey(whereTo)) {
			this.room = temp.get(whereTo);
			room.printGreeting();

			// Location teste =
			// timetable.getLectureFromDate(time).getLocation();

			// checkIfTimeIsRightForLecture();
			// System.out.println(room.getName() + teste);
			/*
			 * if(checkIfTimeIsRightForLecture()) {
			 * 
			 * }
			 */
		} else
			System.out.println("Don't have the meaning of these words in my lexicon, try again starting with 'Go to'");
	}

	public boolean checkIfTimeIsRightForLecture() {

		String temp = room.getName();
		Lecture temp1;

		temp1 = timetable.getLectureFromDate(time);
		if (temp1 == null)
			return false;
		else {

			//System.out.println(temp + " " + temp1);

			if (room.getName().equals(timetable.getLectureFromDate(time).getLocation())) {
				System.out.println("You have " +timetable.getLectureFromDate(time).getName() + ". You got just on time");
				return true;
			}
			return false;
		}
	}

}
