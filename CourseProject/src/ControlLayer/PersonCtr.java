package ControlLayer;

import java.util.ArrayList;
import java.util.Arrays;

import DBLayer.DBConnection;
//import DBLayer.DBGuest;
import DBLayer.DBPerson;
import DBLayer.GetMaxId;
import DBLayer.IFDBGuest;
import DBLayer.IFDBPerson;
import ModelLayer.Person;
import ModelLayer.Guest;

public class PersonCtr {

	public PersonCtr() {

	}

	public Person loginGUI(String logname, char[] password)
			throws PersonException {
		IFDBPerson dbPerson = new DBPerson();
		Person person = dbPerson.loginGUI(logname, false);
		if (Arrays.equals(person.getPassword().toCharArray(), password))
			return person;
		else
			throw new PersonException("Log in name or password not found");
	}

	public int insertPerson(String fname, String lname, String address, String phone, 
			String email, String logId, String password, int authLevel, String ptype) {
		int personId = 0;
		Person person = new Person();
		person.setfName(fname);
		person.setlName(lname);
		person.setAddress(address);
		person.setPhone(phone);
		person.setEmail(email);
		person.setLogId(logId);
		person.setPassword(password);
		//person.setAuthLevel(authLevel);
		person.generateLogId();
		person.generatePassword();
		try {
			DBConnection.startTransaction();
			DBPerson dbPerson = new DBPerson();
			personId = dbPerson.insertPerson(person);
			DBConnection.commitTransaction();
		} catch (Exception e) {
			DBConnection.rollbackTransaction();
		}
		return personId;
	}

//	public Guest getGuestPersonWithoutAssociation(int guestId)
//			throws PersonException {
//		Person person = new Person();
//		IFDBPerson dbPerson = new DBPerson();
//		person = dbPerson.getPerson(guestId, true);
//		Guest guest = new Guest();
//		IFDBGuest dbGuest = new DBGuest();
//		guest = dbGuest.getGuest(person.getID(), false);
//
//		if (guest == null) {
//			throw new PersonException("Guest is not found");
//		}
//
//		guest.setAddress(person.getAddress());
//		guest.setfName(person.getfName());
//		guest.setlName(person.getlName());
//		guest.setPhone(person.getPhone());
//		guest.setEmail(person.getEmail());
//		guest.setID(person.getID());
//		guest.setLogId(person.getLogId());
//		guest.setPassword(person.getPassword());
//		//guest.setAuthLevel(person.getAuthLevel());
//
//		return guest;
//	}

//	public Guest getGuest(int personId) throws PersonException {
//		Person person = new Person();
//		IFDBPerson dbPerson = new DBPerson();
//		person = dbPerson.getPerson(personId, true);
//		if (person == null) {
//			throw new PersonException("Person not found");
//		}
//		if (person != null) {
//			Guest guest = new Guest();
//			IFDBGuest dbGuest = new DBGuest();
//			guest = dbGuest.getGuest(person.getID(), true);
//			guest.setAddress(person.getAddress());
//			guest.setfName(person.getfName());
//			guest.setlName(person.getlName());
//			guest.setPhone(person.getPhone());
//			guest.setEmail(person.getEmail());
//			guest.setID(person.getID());
//			guest.setLogId(person.getLogId());
//			guest.setPassword(person.getPassword());
//			//guest.setAuthLevel(person.getAuthLevel());
//			return guest;
//		}
//		else {
//			return null;
//		}
//	}

	public Object getPerson(int personId) throws PersonException {
		Person person = new Person();
		IFDBPerson dbPerson = new DBPerson();
		person = dbPerson.getPerson(personId, true);
		if (person != null) {
			Person guest = new Person();
			IFDBPerson dbGuest = new DBPerson();
			guest = dbGuest.getPerson(person.getID(), true);
			guest.setAddress(person.getAddress());
			guest.setfName(person.getfName());
			guest.setlName(person.getlName());
			guest.setPhone(person.getPhone());
			guest.setEmail(person.getEmail());
			guest.setID(person.getID());
			guest.setLogId(person.getLogId());
			guest.setPassword(person.getPassword());
			//guest.setAuthLevel(person.getAuthLevel());
			return guest;
		}
		else {
			throw new PersonException("Person not found");
		}
	}

	public void updatePerson(int guestId, String fname, String lname,
			String address, String phone, String email, int authLevel) {
		Person person = new Person();
		person.setID(guestId);
		person.setfName(fname);
		person.setlName(lname);
		person.setAddress(address);
		person.setPhone(phone);
		person.setEmail(email);
		//person.setAuthLevel(authLevel);
		try {
			DBConnection.startTransaction();
			DBPerson dbPerson = new DBPerson();
			dbPerson.updatePerson(person);
			DBConnection.commitTransaction();
		} catch (Exception e) {
			DBConnection.rollbackTransaction();
		}
	}

	public void deletePerson(int personId) {
		try {
			DBConnection.startTransaction();
			IFDBPerson dbPerson = new DBPerson();
			dbPerson.deletePerson(personId);
			DBConnection.commitTransaction();
		} catch (Exception e) {
			DBConnection.rollbackTransaction();
		}
	}

//	public int createGuest(String fname, String lname, String address,
//			String phone, String email, String ptype) {
//		Guest guest = new Guest();
//		guest.generatePassword();
//		int nextId = GetMaxId.getMaxId("Select max(personId) from person") + 1;
//		guest.setLogId(Integer.toString(nextId));
//
//		int guestId = insertPerson(fname, lname, address, phone,
//				email, guest.getLogId(), guest.getPassword(), 5, ptype);
//		// create guest
//		guest.setID(guestId);
//
//		try {
//			DBConnection.startTransaction();
//			DBGuest dbGuest = new DBGuest();
//			dbGuest.insertGuest(guest);
//			DBConnection.commitTransaction();
//		} catch (Exception e) {
//			DBConnection.rollbackTransaction();
//		}
//		return guestId;
//	}

//	public ArrayList<Guest> getAllGuest() {
//		IFDBGuest dbGuest = new DBGuest();
//		ArrayList<Guest> guests = new ArrayList<Guest>();
//		guests = dbGuest.getAllGuest(true);
//		for (Guest guest : guests) {
//			Person person;
//			try {
//				person = (Person) getPerson(guest.getID());
//				guest.setAddress(person.getAddress());
//				guest.setfName(person.getfName());
//				guest.setlName(person.getlName());
//				guest.setPhone(person.getPhone());
//				guest.setEmail(person.getEmail());
//				guest.setID(person.getID());
//				guest.setLogId(person.getLogId());
//				guest.setPassword(person.getPassword());
//				//guest.setAuthLevel(person.getAuthLevel());
//			} catch (PersonException e) {
//			}
//		}
//		return guests;
//	}
	
	public ArrayList<Person> getAllPerson() {
		IFDBPerson dbPerson = new DBPerson();
		ArrayList<Person> persons = new ArrayList<Person>();
		//persons = dbPerson.getAllPerson(true);
		for (Person person : persons) {
			//Person person;
			try {
				person = (Person) getPerson(person.getID());
				person.getAddress();
				person.getfName();
				person.getlName();
				person.getPhone();
				person.getEmail();
				//person.getID();
				person.getLogId();
				person.getPassword();
			} catch (PersonException e) {
			}
		}
		return persons;
	}
}
