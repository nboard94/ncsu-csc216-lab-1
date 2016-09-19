package edu.ncsu.csc216.pack_scheduler.course;

/**
 * Creates Course objects an has getter and setter methods for fields
 * @author James Ticatic
 * 
 */
public class Course extends Activity implements Comparable <Course> {
	/** Course's name. */
	private String name;
	/** Course's section. */
	private String section;
	/** Course's credit hours */
	private int credits;
	/** Course's instructor */
	private String instructorId;
	
	/**
	 * Creates a Course with the given name, title, section, credits, instructorId, and meetingDays for 
 	 * courses that are arranged.
	 * @param name name of course
	 * @param title title of course
	 * @param section section number
	 * @param credits number of credits
	 * @param instructorId unity id of instructor
	 * @param meetingDays the days the class is in session
	 * @param startTime time class starts
	 * @param endTime time class ends
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays,
			int startTime, int endTime) {
		super(title, meetingDays, startTime, endTime);
		setName(name);
	    setSection(section);
	    setCredits(credits);
	    setInstructorId(instructorId);
	}

	/**
	 * Creates a Course with the given name, title, section, credits, instructorId, and meetingDays for 
	 * courses that are arranged.
	 * @param name name of Course
	 * @param title title of Course
	 * @param section section of Course
	 * @param credits credit hours for Course
	 * @param instructorId instructor's unity id
	 * @param meetingDays meeting days for Course as series of chars
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays) {
		this(name, title, section, credits, instructorId, meetingDays, 0, 0);
	}
	
	/**
	 * Returns the course's name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the Course's name.  If the name is null, has a length less than 4 or 
	 * greater than 6, an IllegalArgumentException is thrown.
	 * @param name the name to set
	 * @throws IllegalArgumentException if name is null or length is less than 4 or 
	 * greater than 6
	 */
	private void setName(String name) {
	    if (name == null || name.isEmpty()) {
	        throw new IllegalArgumentException();
	    }
	    if (name.length() < 4 || name.length() > 6) {
	        throw new IllegalArgumentException();
	    }
	    this.name = name;
	}
	
	/**
	 * Gets the course's section
	 * @return the section
	 */
	public String getSection() {
		return section;
	}
	
	/**
	 * Sets the course's section
	 * @param section the section to set
	 */
	public void setSection(String section) {
		if (section == null) {
	        throw new IllegalArgumentException();
	    }
		if (section.length() != 3) {
			throw new IllegalArgumentException();
		}
		Character a = section.charAt(0);
		Character b = section.charAt(1);
		Character c = section.charAt(2);
		if (!Character.isDigit(a) || !Character.isDigit(b) || !Character.isDigit(c)){
			throw new IllegalArgumentException();
		}
		this.section = section;
	}
	
	/**
	 * Gets the course's credits
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}
	
	/**
	 * Sets the course's credits
	 * @param credits the credits to set
	 */
	public void setCredits(int credits) {
		if (credits < 1 || credits > 5) {
			throw new IllegalArgumentException();
		}
		this.credits = credits;
	}
	
	/**
	 * Gets the instructors Id
	 * @return the instructorId
	 */
	public String getInstructorId() {
		return instructorId;
	}
	
	/**
	 * Sets the instructors id
	 * @param instructorId the instructorId to set
	 */
	public void setInstructorId(String instructorId) {
		  if (instructorId == null || instructorId.isEmpty()) {
		        throw new IllegalArgumentException();
		    }
		this.instructorId = instructorId;
	}
	
	/**
	 * Returns a comma separated value String of all Course fields.
	 * @return String representation of Course
	 */
	@Override
	public String toString() {
	    if (getMeetingDays().equals("A")) {
	        return name + "," + getTitle() + "," + section + "," + credits + "," + instructorId + "," + getMeetingDays();
	    }
	    return name + "," + getTitle() + "," + section + "," + credits + "," + instructorId + "," + getMeetingDays() + "," + getStartTime() + "," + getEndTime(); 
	}

	/** 
	 * Hashes course information
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + credits;
		result = prime * result + ((instructorId == null) ? 0 : instructorId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		return result;
	}

	/**
	 * Checks if two activities are equal across all fields
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (credits != other.credits)
			return false;
		if (instructorId == null) {
			if (other.instructorId != null)
				return false;
		} else if (!instructorId.equals(other.instructorId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		return true;
	}

	/**
	 * Returns array in form name, section, title, meeting string
	 */
	@Override
	public String[] getShortDisplayArray() {
		String[] displayArray = new String[4];
		displayArray[0] = name;
		displayArray[1] = section;
		displayArray[2] = getTitle();
		displayArray[3] = getMeetingString();
		return displayArray;
	}

	/**
	 * Returns array in form name, section, title, credits, instructor id, meeting string, ""
	 */
	@Override
	public String[] getLongDisplayArray() {
		String[] displayArray = new String[7];
		displayArray[0] = name;
		displayArray[1] = section;
		displayArray[2] = getTitle();
		displayArray[3] = "" + credits;
		displayArray[4] = instructorId;
		displayArray[5] = getMeetingString();
		displayArray[6] = "";
		return displayArray;
	}

	/**
	 * Checks that the days are valid for a course object
	 */
	@Override
	public void setMeetingDays(String meetingDays) {
		if (meetingDays == null || meetingDays.isEmpty()) {
			throw new IllegalArgumentException();
		}
		char[] days = meetingDays.toCharArray();
		for (int i = 0; i < meetingDays.length(); i++) {
			if (days[i] != 'M' && days[i] != 'T' && days[i] != 'W' && days[i] != 'H' && 
				days[i] != 'F' && days[i] != 'A') {
				throw new IllegalArgumentException();
			}
		}
		CharSequence a = "A";
		if (meetingDays.contains(a) && meetingDays.length() != 1) {
			throw new IllegalArgumentException();
		}
		super.setMeetingDays(meetingDays);
	}

	/**
	 * Checks if two course objects are duplicates of each other.
	 */
	@Override
	public boolean isDuplicate(Activity activity) {
		if (!(activity instanceof Course)) {
			return false;
		}
		Course course = (Course) activity;
		if (course.getName().equals(name)) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Course course) {
		for (int i = 0; i < this.getName().length(); i++) {
			if (((Character)this.getName().charAt(i)).compareTo(((Character)course.getName().charAt(i))) != 0) {
				return (int) Math.signum(this.getName().compareTo(course.getName()));
			}
		}
		
		for (int i = 0; i < this.getSection().length(); i++) {
			if (((Character)this.getSection().charAt(i)).compareTo(((Character)course.getSection().charAt(i))) != 0) {
				return (int) Math.signum(this.getSection().compareTo(course.getSection()));
			}
		}
		
		return 0;
	}

}
