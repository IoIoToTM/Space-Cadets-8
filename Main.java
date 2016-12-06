import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import player.Player;
import timetables.Lecture;
import timetables.Timetable;
import timetables.Timetable.Days;

public class Main {
	
	public static void main(String[] args) {
		
		Timetable today = getRandomTimeTable();
		
		System.out.println("The time is 08:00:00 and today is " + today.getToday());
		
		
		
		
		String newDay = "08:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(newDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Player test = new Player(date,today);
		
		ArrayList<Lecture> timetable = today.getTimeTable();
		
		
		Scanner reader = new Scanner(System.in);
		String input = null;
	
		while(true)
		{
			input = reader.nextLine();
			if(input.equals(""))
				continue;
			if(input.equals("help"))
			{
				System.out.println(test.getRoom().getHelp());
				continue;
			}
			if(input.equals("timetable"))
			{
				Iterator<Lecture> temp = today.getTimeTable().iterator();
				while(temp.hasNext()){
					Lecture tempL = temp.next();
					System.out.println(tempL.getName() + " at " + tempL.getLocation() + " at " +sdf.format(tempL.getDate().getTime()));
				}
				continue;
			}
			
			date.setTime(date.getTime()+300000);
			System.out.println(sdf.format(date));
			
			if(input.equals("wait"))
			{
				System.out.println("You wait 5 minutes");
				continue;
			}
			
			test.goToRoom(input);
			if(test.checkIfTimeIsRightForLecture());
				
			
		}
		
	}
	
	
	private static Timetable getRandomTimeTable(){
		Random rand = new Random();
		int day = rand.nextInt(5)+1;
		
		Timetable todaysTimetable = null;
		
		switch (day)
		{
		case 1: todaysTimetable = new Timetable(Days.MONDAY); break;
		case 2: todaysTimetable = new Timetable(Days.TUESDAY); break;
		case 3: todaysTimetable = new Timetable(Days.WEDNESDAY); break;
		case 4: todaysTimetable = new Timetable(Days.THURSDAY); break;
		case 5: todaysTimetable = new Timetable(Days.FRIDAY); break;
		}
		return todaysTimetable;
	}

}
