/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.course;

/** 
 * Checks to see if two objects conflict with each other, in the case of activities two activities conflict if they
 * occur at the same time/day
 * @author James Ticatic
 *
 */
public interface Conflict {
	/**
	 * Checks if two activities conflict based on time/day
	 * @param possibleConflictingActivity the activity that is being checked for confliction
	 * @throws ConflictException if the two Activities conflict
	 */
	void checkConflict(Activity possibleConflictingActivity) throws ConflictException;
}
