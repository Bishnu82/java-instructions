package business;

import java.util.Date;

public class Actor {
	private int id;
	private String fName;
	private String lName;
	private String gender;
	private Date birthDate;
	public Actor() {
		super();
	}
	public Actor(int id, String fName, String lName, String gender, Date birthDate) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.birthDate = birthDate;
	}
	
	public Actor(String fName, String lName, String gender, Date birthDate) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.birthDate = birthDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "Actor [id=" + id + ", fName=" + fName + ", lName=" + lName + ", gender=" + gender + "]";
	}
	
}
