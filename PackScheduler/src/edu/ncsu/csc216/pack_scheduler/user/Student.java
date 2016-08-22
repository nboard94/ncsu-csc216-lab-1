package edu.ncsu.csc216.pack_scheduler.user;

public class Student {
	private String firstName;
	private String lastName;
	private String id;
	private String email;
	private String hashPW;
	private int maxCredits;
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the hashPW
	 */
	public String getHashPW() {
		return hashPW;
	}

	/**
	 * @param hashPW the hashPW to set
	 */
	public void setHashPW(String hashPW) {
		this.hashPW = hashPW;
	}

	/**
	 * @return the maxCredits
	 */
	public int getMaxCredits() {
		return maxCredits;
	}

	/**
	 * @param maxCredits the maxCredits to set
	 */
	public void setMaxCredits(int maxCredits) {
		this.maxCredits = maxCredits;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public Student(String firstName, String lastName, String id, String email, String hashPW, int maxCredits) {
		setFirstName(this.firstName);
		setLastName(this.lastName);
		setEmail(this.email);
		setHashPW(this.hashPW);
		setMaxCredits(this.maxCredits);
	}
	
	public Student(String firstName, String lastName, String id, String email, String hashPW) {
		Student(this.firstName, this.lastName, this.id, this.email, this.hashPW, 18);
	}
	
	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
