//package DBLayer;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import ModelLayer.Guest;
//
//public class DBGuest implements IFDBGuest {
//	private Connection con;
//
//	public DBGuest() {
//		con = DBConnection.getInstance().getDBcon();
//	}
//
////	@Override
////	public Guest getGuest(int guestId, boolean retriveAssociation) {
////		String wClause = "  guestId = '" + guestId + "'";
////		return singleWhere(wClause, retriveAssociation);
////	}
//
//	@Override
//	public int insertGuest(Guest guest) {
//		int rc = -1;
//		String query = "INSERT INTO guest(guestId) VALUES('" + guest.getID() + "')";
//		System.out.println("insert : " + query);
//		try {
//			Statement stmt = con.createStatement();
//			stmt.setQueryTimeout(5);
//			rc = stmt.executeUpdate(query);
//			stmt.close();
//			con.commit();
//		} catch (SQLException ex) {
//			System.out.println("Guest is not inserted");
//		}
//		return rc;
//	}
//
////	@Override
////	public ArrayList<Guest> getAllGuest(boolean retrieveAssociation) {
////		return miscWhere("", retrieveAssociation);
////	}
////
////	private Guest singleWhere(String wClause, boolean retrieveAssociation) {
////		ResultSet results;
////		Guest guest = new Guest();
////		String query = buildQuery(wClause);
////		try {
////			Statement stmt = con.createStatement();
////			stmt.setQueryTimeout(5);
////			results = stmt.executeQuery(query);
////
////			if (results.next()) {
////				guest = buildGuest(results);
////				stmt.close();
////				if (retrieveAssociation) {
////					
////				}
////			} else {
////				guest = null;
////			}
////		} catch (Exception e) {
////			System.out.println("Query exception: " + e);
////		}
////		return guest;
////	}
//
////	private ArrayList<Guest> miscWhere(String wClause,
////			boolean retrieveAssociation) {
////		ResultSet results;
////		ArrayList<Guest> list = new ArrayList<Guest>();
////		String query = buildQuery(wClause);
////		try {
////			Statement stmt = con.createStatement();
////			stmt.setQueryTimeout(5);
////			results = stmt.executeQuery(query);
////
////			while (results.next()) {
////				Guest guest = new Guest();
////				guest = buildGuest(results);
////				list.add(guest);
////			}
////			stmt.close();
////			if (retrieveAssociation) {
////				for (Guest guest : list) {
////				}
////			}
////
////		} catch (Exception e) {
////			System.out.println("Query exception - select: " + e);
////			e.printStackTrace();
////		}
////		return list;
////	}
//
////	private Guest buildGuest(ResultSet results) {
////		Guest guest = new Guest();
////		try {
////			guest.setID(results.getInt("guestId"));
////		} catch (Exception e) {
////			System.out.println("error in building the guest object");
////		}
////		return guest;
////	}
////
////	private String buildQuery(String wClause) {
////		String query = "SELECT guestId, passportNr FROM guest";
////
////		if (wClause.length() > 0)
////			query = query + " WHERE " + wClause;
////
////		return query;
////	}
//
//}
