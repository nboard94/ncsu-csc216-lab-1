package edu.ncsu.csc216.pack_scheduler.course;

/**
 * Superclass for course and event
 * @author James Ticatic
 *  
 */
abstract public class Activity implements Conflict {

	/** Course's title. */
	private String title;
	/** Course's meeting days */
	private String meetingDays;
	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.wolf_scheduler.course.Conflict#checkConflict(edu.ncsu.csc216.wolf_scheduler.course.Activity)
	 */
	@Override
	public void checkConflict(Activity possibleConflictingActivity) throws ConflictException {
		if (!possibleConflictingActivity.getMeetingDays().equals("A") || !this.getMeetingDays().equals("A")) {
			for(int i = 0; i < possibleConflictingActivity.getMeetingDays().length(); i++) {
				for (int j = 0; j < this.getMeetingDays().length(); j++) {
					if (this.getMeetingDays().charAt(j) == possibleConflictingActivity.getMeetingDays().charAt(i)) {
						if (possibleConflictingActivity.getStartTime() <= this.getStartTime() && 
							possibleConflictingActivity.getEndTime() >= this.getStartTime()) {
							throw new ConflictException();
						}  
						if (this.getStartTime() <= possibleConflictingActivity.getStartTime() && 
							this.getEndTime() >= possibleConflictingActivity.getStartTime()) {
							throw new ConflictException();
						}  
					}
				}
			}
		}
	}

	/** Course's starting time */
	private int startTime;
	/** Course's ending time */
	private int endTime;

	/**
	 * Superclass creates short string array of activity details
	 * @return String array of activity details
	 */
	public abstract String[] getShortDisplayArray();
	
	/**
	 * Superclass creates long string array of activity details
	 * @return String array of activity details
	 */
	public abstract String[] getLongDisplayArray(); 
	
	/**
	 * Superclass constructor for activity objects
	 * @param title title of activity
	 * @param meetingDays days the activity meets
	 * @param startTime time the activity starts
	 * @param endTime time the activity ends
	 */
	public Activity(String title, String meetingDays, int startTime, int endTime) {
		super();
		setTitle(title);
		setMeetingDays(meetingDays);
		setActivityTime(startTime, endTime);		
	}

	/**
	 * Gets the activity's title 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the activity's title
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		if (title == null || title.isEmpty()) {
	        throw new IllegalArgumentException();
	    }
		this.title = title;
	}

	/**
	 * Gets the meeting days
	 * @return the meetingDays
	 */
	public String getMeetingDays() {
		return meetingDays;
	}

	/**
	 * Sets the meeting days
	 * @param meetingDays the meetingDays to set
	 */
	public void setMeetingDays(String meetingDays) {
		this.meetingDays = meetingDays;
	}

	/**
	 * Gets the start time
	 * @return the startTime
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * Gets the end time
	 * @return the endTime
	 */
	public int getEndTime() {
		return endTime;
	}

	/**
	 * Gets the string of when activity meets
	 * @return answer the string containing meeting time information
	 */
	public String getMeetingString() {
		 String answer = "";
		 String days = getMeetingDays();
		 if (days.equals("A")) {
			 return "Arranged";
		 }
		 answer += days;
		 
		 int startHour = startTime / 100;
		 int startMins = startTime % 100;
		 if (startHour > 12) {
			 startHour -= 12;
		 }
		 String stMins = String.format("%02d", startMins);
	
		 if (startTime < 1200) {
			 answer += " " + startHour + ":" + stMins + "AM";
		 }
		 if (startTime >= 1200) {
			 answer += " " + startHour + ":" + stMins + "PM";
		 }
		 
		 int endHour = endTime / 100;
		 int endMins = endTime % 100;
		 if (endHour > 12) {
			 endHour -= 12;
		 }
		 String enMins = String.format("%02d", endMins);
		 if (endTime < 1200) {
			 answer += "-" + endHour + ":" + enMins + "AM";
		 }
		 if (endTime >= 1200) {
			 answer += "-" + endHour + ":" + enMins + "PM";
		 }
		 
		 return answer;
	}

	/**
	 * Sets the activities start and end times and ensures they are valid or nonexistent if the class is arranged 
	 * @param startTime the time the class starts
	 * @param endTime the time the class ends
	 */
	public void setActivityTime(int startTime, int endTime) {
		if ((startTime % 100) >= 60 || (endTime % 100) >= 60) {
			throw new IllegalArgumentException();
		}
		if (meetingDays.equals("A") && startTime != 0 && endTime != 0) {
			throw new IllegalArgumentException();
		}
		if (startTime < 0 || startTime > 2359 || endTime < 0 || endTime > 2359) {
			throw new IllegalArgumentException();
		}
		if (endTime < startTime) {
			throw new IllegalArgumentException();
		}
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/** 
	 * Hashes activity information
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endTime;
		result = prime * result + ((meetingDays == null) ? 0 : meetingDays.hashCode());
		result = prime * result + startTime;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/**
	 * Checks if two activities are equal across all fields
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (endTime != other.endTime)
			return false;
		if (meetingDays == null) {
			if (other.meetingDays != null)
				return false;
		} else if (!meetingDays.equals(other.meetingDays))
			return false;
		if (startTime != other.startTime)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	/**
	 * Checks to see if an event is a duplicate of another one in the schedule
	 * @param activity the activity to compare to
	 * @return true if both activities are the same
	 */
	public abstract boolean isDuplicate(Activity activity);
}