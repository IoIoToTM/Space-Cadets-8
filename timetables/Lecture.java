package timetables;

import java.util.Date;

public class Lecture {
	private String location;
	private Date date;
	private String name;

	public Lecture(String location, Date date, String name) {
		this.date = date;
		this.location = location;
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}