package rooms;

import java.util.HashMap;

import timetables.Lecture;

public class Room {
	
	private String name;
	private String greetingText;
	private Lecture lectrue;
	private HashMap<String,Room> setOfRooms;
	
	public Room(String name)
	{
		setOfRooms = new HashMap<String,Room>();
		greetingText = null;
		this.name = name;
		lectrue = null;
	}
	
	public String getHelp()
	{
		return setOfRooms.keySet().toString();
	}
	
	public void setGreeting(String greetingText)
	{
		this.greetingText = greetingText;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGreetingText() {
		return greetingText;
	}

	public void setGreetingText(String greetingText) {
		this.greetingText = greetingText;
	}

	public Lecture getLectrue() {
		return lectrue;
	}

	public void setLectrue(Lecture lectrue) {
		this.lectrue = lectrue;
	}

	public HashMap<String, Room> getSetOfRooms() {
		return setOfRooms;
	}

	public void setSetOfRooms(HashMap<String, Room> setOfRooms) {
		this.setOfRooms = setOfRooms;
	}

	public void printGreeting()
	{
		System.out.println(greetingText);
	}
	public void addRoomToHashMap(String howToGetThere, Room room)
	{
		setOfRooms.put(howToGetThere,room);
		//room.addRoomToHashMap("Go back", this);
	}
	public HashMap<String,Room> getHashMap()
	{
		return setOfRooms;
	}
	
}
