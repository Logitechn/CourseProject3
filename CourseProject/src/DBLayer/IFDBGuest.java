package DBLayer;

import java.util.ArrayList;

import ModelLayer.Guest;

public interface IFDBGuest {
	public Guest getGuest(int guestId, boolean retriveAssociation);

	public int insertGuest(Guest guest);

	public ArrayList<Guest> getAllGuest(boolean retrieveAssociation);
}
