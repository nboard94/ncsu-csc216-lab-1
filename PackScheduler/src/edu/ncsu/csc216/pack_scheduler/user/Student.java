package edu.ncsu.csc216.pack_scheduler.user;

public class Student {

	static public final int MAX_CREDITS = 18;
	private String firstName;
	private String lastName;
	private String id;
	private String email;
	private String hashPW;
	private int maxCredits;
	public Student(String firstName, String lastName, String id, String email, String hashPW, int maxCredits) {
		setFirstName(firstName);
		setLastName(lastName);
		setId(id);
		setEmail(email);
		setPassword(hashPW);
		setMaxCredits(maxCredits);
	}

	public Student(String firstName, String lastName, String id, String email, String hashPW) {
		this(firstName, lastName, id, email, hashPW, MAX_CREDITS);
	}

	/**sets the firstName variable
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.isEmpty()) {
			throw new IllegalArgumentException("First Name is null or empty");
		}
		this.firstName = firstName;

	}

	public String getFirstName() {
		return firstName;
	}

	/**sets the LastName variable
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		if (lastName == null || lastName.isEmpty()) {
			throw new IllegalArgumentException("Last Name is null or empty");
			
		}
		this.lastName = lastName;

	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	/**@sets the id variable
	 * @param id the id to set
	 */
	private void setId(String id) {
		if (id == null || id.isEmpty()) {
			throw new IllegalArgumentException("ID is null or empty");
		}
		this.id = id;
	
	}

	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	/**sets the email variable
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		if (email == null || email.isEmpty()) {
			throw new IllegalArgumentException("Email is null or empty");
		}
		if (!email.contains("@") || !email.contains(".")) {
			throw new IllegalArgumentException("Emails need to contain @ and . characters");
		}
		if (email.lastIndexOf('.') < email.indexOf('@')) {
			throw new IllegalArgumentException("Invalid email address");
		}
		this.email = email;
	
	}

	public String getEmail() {
		return email;

	}

	/**
	 * @param hashPW the hashPW to set
	 */
	public void setPassword(String hashPW) {
		if (hashPW == null || hashPW.isEmpty()) {
			throw new IllegalArgumentException("Password is null or empty");
		}
		this.hashPW = hashPW;
	
	}

	/**
	 * @return the hashPW
	 */
	public String getPassword() {
		return hashPW;
	}
 
	/**
	 * @param maxCredits the maxCredits to set
	 */
	public void setMaxCredits(int maxCredits) {
		if (maxCredits < 3 || maxCredits > 18) {
			throw new IllegalArgumentException("Invalid credit hours");
		}
		this.maxCredits = maxCredits;
	
	}

	/**
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
	 * Returns string as firstname,lastname,id,hashedPassword,maxCredits
	 * @return concatenated string of fields
	 */
	@Override
	public String toString() {
		return firstName + "," + lastName + "," + id + "," + hashPW + "," + maxCredits;
	}
	public static void main(String[] args){
	    Student student =  new Student("James", "Ticatic", "2000", "@.", "2020202", 5);
	    System.out.println(student.toString());
	}
}
