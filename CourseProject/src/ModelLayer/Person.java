package ModelLayer;

import java.util.Random;

public class Person {

	private int ID;
	private int authLevel;
	private String password;
	private String logId;
	private String fName;
	private String lName;
	private String address;
	private String email;
	private String phone;

	public Person() {

	}

	public Person(int id) {
		ID = id;
	}

	public void generateLogId() {
		setLogId(Integer.toString(getID()));
	}

	public void generatePassword() {
		setPassword(Integer.toString(new Random().nextInt(10000)));
	}

	public String toString() {
		return "/nID: " + getID() + "/nName: " + getfName() + " " + getlName()
				+ "/nAddress: " + getAddress() + "/nEmail: " + getEmail() + "/nPhone: " + getPhone();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getAuthLevel() {
		return authLevel;
	}

	public void setAuthLevel(int authLevel) {
		this.authLevel = authLevel;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}
}