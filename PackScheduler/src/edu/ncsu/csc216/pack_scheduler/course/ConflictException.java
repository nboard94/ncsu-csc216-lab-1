package edu.ncsu.csc216.pack_scheduler.course;

/**
 * Exception thrown when two activities conflict, they conflict if at any point of the duration of either activity 
 * overlaps
 * @author James Ticatic
 */
public class ConflictException extends Exception {

	/** ID used for serialization. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor for an exception that allows a message to be passed to it
	 * @param message the message the exception throws
	 */
	public ConflictException(String message) {
		super(message);
	}
	
	/**
	 * Default constructor for exception with message "Schedule conflict."
	 */
	public ConflictException() {
		super("Schedule conflict.");
	}
}
