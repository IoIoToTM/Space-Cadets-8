package timetables;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;





public class Timetable {
	public static enum Days {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
	}

	private LocalTime test;
	private Days today;
	private ArrayList<Lecture> timeTable;



	public Days getToday() {
		return today;
	}

	public void setToday(Days today) {
		this.today = today;
	}

	public Timetable(Days days) {
		
		timeTable = new ArrayList<Lecture>();

		today = days;

		switch (days) {
		case MONDAY:

			try {
				String firstLecture = "12:00:00";
				String secondLecture = "13:00:00";
				String thirdLecture = "14:00:00";
				String fourthLecture = "15:00:00";
				String fifthLecture = "16:00:00";
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				Date date = null;
				date = sdf.parse(firstLecture);
				timeTable.add(new Lecture(("07/3009"), date, "Professional Development"));

				date = sdf.parse(secondLecture);
				timeTable.add(new Lecture(("07/3009"), date, "Professional Development"));
				date = sdf.parse(thirdLecture);
				timeTable.add(new Lecture(("32/1015"), date, "Programming I"));
				date = sdf.parse(fourthLecture);
				timeTable.add(new Lecture(("42"), date, "Computer Systems I"));
				date = sdf.parse(fifthLecture);
				timeTable.add(new Lecture(("54/5025"), date, "Foundations of CompSci Tutorial"));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case TUESDAY:

			try {
				String firstLecture = "9:00:00";
				String secondLecture = "10:00:00";
				String thirdLecture = "13:00:00";
				String fourthLecture = "14:00:00";
				String fifthLecture = "16:00:00";
				String sixthLecture = "17:00:00";
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				Date date = null;
				date = sdf.parse(firstLecture);
				timeTable.add(new Lecture(("54/4011"), date, "Foundations of CompSci"));
				date = sdf.parse(secondLecture);
				timeTable.add(new Lecture(("54/4011"), date, "Foundations of CompSci"));
				date = sdf.parse(thirdLecture);
				timeTable.add(new Lecture(("07/3027"), date, "Programming I Space Cadets"));
				date = sdf.parse(fourthLecture);
				timeTable.add(new Lecture(("07/3027"), date, "Programming I Space Cadets"));
				date = sdf.parse(fifthLecture);
				timeTable.add(new Lecture(("54/5025"), date, "Computer Systems I"));
				date = sdf.parse(sixthLecture);
				timeTable.add(new Lecture(("67/1027"), date, "Programming I"));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case WEDNESDAY:
			try {
				String firstLecture = "9:00:00";
				String secondLecture = "12:00:00";

				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				Date date = null;
				date = sdf.parse(firstLecture);
				timeTable.add(
						new Lecture(("59/ECS Teaching lab"), date, "Programming I Ground Controllers"));
				date = sdf.parse(secondLecture);
				timeTable.add(new Lecture(("Tutorial Place"), date, "TT ECS Weekly Tutorial"));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case THURSDAY:
			try {
				String firstLecture = "9:00:00";
				String secondLecture = "10:00:00";
				String thirdLecture = "11:00:00";
				String fourthLecture = "14:00:00";
				String fifthLecture = "15:00:00";
				String sixthLecture = "16:00:00";
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				Date date = null;
				date = sdf.parse(firstLecture);
				timeTable.add(new Lecture(("Avenue 65/1133"), date, "Professional Development"));
				date = sdf.parse(secondLecture);
				timeTable.add(new Lecture(("07/3009"), date, "Foundations of CompSci"));
				date = sdf.parse(thirdLecture);
				timeTable.add(new Lecture(("07/3009"), date, "Foundations of CompSci"));
				date = sdf.parse(fourthLecture);
				timeTable.add(new Lecture(("59/ECS"), date, "Computer Systems Labs"));
				date = sdf.parse(fifthLecture);
				timeTable.add(new Lecture(("59/ECS"), date, "Computer Systems Labs"));
				date = sdf.parse(sixthLecture);
				timeTable.add(new Lecture(("59/ECS"), date, "Computer Systems Labs"));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case FRIDAY:
			try {
				String firstLecture = "13:00:00";
				String secondLecture = "14:00:00";
				String thirdLecture = "15:00:00";
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				Date date = null;
				date = sdf.parse(firstLecture);
				timeTable.add(new Lecture(("07/3009"), date, "Computer Systems I"));
				date = sdf.parse(secondLecture);
				timeTable.add(new Lecture(("59/ECS"), date, "Programming I Lab"));
				date = sdf.parse(thirdLecture);
				timeTable.add(new Lecture(("59/ECS"), date, "Programming I Lab"));


			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		}

	}

	public ArrayList<Lecture> getTimeTable() {
		return timeTable;
	}
	
	public Lecture getLectureFromDate(Date date)
	{
		Iterator<Lecture> tempIT = timeTable.iterator();
		
		while(tempIT.hasNext())
		{
			
			
			Lecture temp = tempIT.next();
			//System.out.println(temp.getName() + temp.getDate());
			//System.out.println(temp.getDate());
			if(temp.getDate().equals(date))
			{
				return temp;
			}
		}
		return null;
	}

}
