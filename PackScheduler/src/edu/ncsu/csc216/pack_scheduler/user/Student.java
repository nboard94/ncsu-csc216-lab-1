package edu.ncsu.csc216.pack_scheduler.user;


/**Class for the Student object, has getters, setters, and methods to overwrite equals, hashCode,
 * and toString default java classes
 * @author James Ticatic
 * @author Nicholas Board
 */
public class Student implements Comparable<Student>  {

	/**
	 * CONSTANT FOR MAXIMUM NUMBER OF CREDITS
	 */
	static public final int MAX_CREDITS = 18;
	private String firstName;
	private String lastName;
	private String id;
	private String email;
	private String hashPW;
	private int maxCredits;
	
	/** 
	 * constructor for Student class
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param id the id 
	 * @param email the email 
	 * @param hashPW the hashed password 
	 * @param maxCredits the maximum amount of credits
	 */
	public Student(String firstName, String lastName, String id, String email, String hashPW, int maxCredits) {
		setFirstName(firstName);
		setLastName(lastName);
		setId(id);
		setEmail(email);
		setPassword(hashPW);
		setMaxCredits(maxCredits);
	}

	/** 
	 * constructor for Student class that defaults max credits to 18
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param id the id 
	 * @param email the email
	 * @param hashPW the hashed pw
	 */
	public Student(String firstName, String lastName, String id, String email, String hashPW) {
		this(firstName, lastName, id, email, hashPW, MAX_CREDITS);
	}

	/**sets the firstName variable
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.isEmpty()) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;

	}

	/** Getter for first name
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**sets the LastName variable
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		if (lastName == null || lastName.isEmpty()) {
			throw new IllegalArgumentException("Invalid last name");
			
		}
		this.lastName = lastName;

	}
	/** Getter for last name
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**sets the id variable
	 * @param id the id to set
	 */
	public void setId(String id) {
		if (id == null || id.isEmpty()) {
			throw new IllegalArgumentException("Invalid id");
		}
		this.id = id;
	
	}
	
	/**getter for Id
	 * @return the Id
	 */
	public String getId() {
		return id;
	}

	/**sets the email variable
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		if (email == null || email.isEmpty()) {
			throw new IllegalArgumentException("Invalid email");
		}
		if (!(email.contains("@"))) {
			throw new IllegalArgumentException("Invalid email");
		}
		if (!(email.contains("."))) {
			throw new IllegalArgumentException("Invalid email");
		}
		
		if (email.lastIndexOf('.') < email.indexOf('@')) {
			throw new IllegalArgumentException("Invalid email");
		}
		this.email = email;
	
	}

	/** Getter for email
	 * @return the email
	 */
	public String getEmail() {
		return email;

	}

	/** setter for password
	 * @param hashPW the hashPW to set
	 */
	public void setPassword(String hashPW) {
		if (hashPW == null || hashPW.isEmpty()) {
			throw new IllegalArgumentException("Invalid password");
		}
		this.hashPW = hashPW;
	
	}

	/** Getter for password
	 * @return the hashPW
	 */
	public String getPassword() {
		return hashPW;
	}
 
	/** Sets number of max credits
	 * @param maxCredits the maxCredits to set
	 */
	public void setMaxCredits(int maxCredits) {
		if (maxCredits < 3 || maxCredits > MAX_CREDITS) {
			throw new IllegalArgumentException("Invalid max credits");
		}
		this.maxCredits = maxCredits;
	
	}

	/** Getter for max credits field
	 * @return the maxCredits
	 */
	public int getMaxCredits() {
		return maxCredits;
		
	}

	/**
	 * Generates hashcode for student using all fields
	 * @return result the hashcode for course
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((hashPW == null) ? 0 : hashPW.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + maxCredits;
		return result;
	}

	/**
	 * Generates equality based on fields
	 * @param obj a student object
	 * @return boolean if both objects are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (hashPW == null) {
			if (other.hashPW != null)
				return false;
		} else if (!hashPW.equals(other.hashPW))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (maxCredits != other.maxCredits)
			return false;
		return true;
	}

	/**
	 * Returns string as firstname, lastname, id, hashedPassword, maxCredits
	 * @return concatenated string of fields
	 */
	@Override
	public String toString() {
		return firstName + "," + lastName + "," + id + "," + email + "," + hashPW + "," + maxCredits;
	}

	@Override
	public int compareTo(Student s) {
		
		for (int i = 0; i < this.getLastName().length(); i++) {
			if (((Character)this.getLastName().charAt(i)).compareTo(((Character)s.getLastName().charAt(i))) != 0) {
				return (int) Math.signum(this.getLastName().compareTo(s.getLastName()));
			}
		}
		
		for (int i = 0; i < this.getFirstName().length(); i++) {
			if (((Character)this.getFirstName().charAt(i)).compareTo(((Character)s.getFirstName().charAt(i))) != 0) {
				return (int) Math.signum(this.getFirstName().compareTo(s.getFirstName()));
			}
		}

		for (int i = 0; i < this.getId().length(); i++) {
			if (((Character)this.getId().charAt(i)).compareTo(((Character)s.getId().charAt(i))) != 0) {
				return (int) Math.signum(this.getId().compareTo(s.getId()));
			}
		}
		
		return 0;
	}
}
