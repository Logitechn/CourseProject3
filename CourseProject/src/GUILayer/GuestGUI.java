//package GUILayer;
//
//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//
//import javax.swing.BorderFactory;
//import javax.swing.GroupLayout;
//import javax.swing.JButton;
//
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.table.DefaultTableModel;
//
//import ControlLayer.PersonCtr;
//import ModelLayer.Guest;
//
//public class GuestGUI extends JPanel {
//	private static final long serialVersionUID = 1L;
//	private PersonCtr personCtr;
//	private DefaultTableModel guestTableModel;
//	private JScrollPane guestTableScrollPane;
//	private JPanel showAllGuestPanel;
//	private JTable showAllGuestTable;
//	private JPanel guestInfoPanel;
//	private JPanel choicePanel;
//
//	private JTextField textField_guestId;
//	private JTextField txt_Search;
//	private JTextField textField_fname;
//	private JTextField textField_address;
//	private JTextField textField_email;
//	private JTextField textField_phone;
//	private JTextField textField_lname;
//
//	private JButton btnSave;
//	private JButton btnCreate;
//	private JButton btnCancel;
//	private JButton btnDelete;
//
//	public GuestGUI() {
//		personCtr = new PersonCtr();
//		initialize();
//	}
//
//	public void initialize() {
//		this.setLayout(new BorderLayout());
//
//		showAllGuestPanel = new JPanel();
//		this.add(showAllGuestPanel, BorderLayout.CENTER);
//		showAllGuestPanel.setBorder(BorderFactory
//				.createTitledBorder("Guests Info"));
//		showAllGuestPanel.setLayout(new BorderLayout());
//
//		txt_Search = new JTextField();
//		txt_Search.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent arg0) {
//				showAllGuests();
//			}
//		});
//		txt_Search.setColumns(10);
//
//		JPanel searchPanel = new JPanel();
//		showAllGuestPanel.add(searchPanel, BorderLayout.NORTH);
//		GroupLayout gl_searchPanel = new GroupLayout(searchPanel);
//		gl_searchPanel.setHorizontalGroup(gl_searchPanel.createParallelGroup(
//				Alignment.LEADING).addComponent(txt_Search));
//		gl_searchPanel.setVerticalGroup(gl_searchPanel.createParallelGroup(
//				Alignment.LEADING).addGroup(
//				gl_searchPanel
//						.createSequentialGroup()
//						.addGap(5)
//						.addComponent(txt_Search, GroupLayout.PREFERRED_SIZE,
//								GroupLayout.DEFAULT_SIZE,
//								GroupLayout.PREFERRED_SIZE)));
//		searchPanel.setLayout(gl_searchPanel);
//
//		// show customer info view
//		JPanel showGuestPanel = new JPanel();
//		this.add(showGuestPanel, BorderLayout.EAST);
//		showGuestPanel.setLayout(new BorderLayout());
//		showGuestPanel.setBorder(BorderFactory.createTitledBorder("Guest"));
//
//		// Person - Guests labels
//		guestInfoPanel = new JPanel();
//		JLabel lblguestId = new JLabel("Guest Id: ");
//		JLabel lblfname = new JLabel("First Name: ");
//		JLabel lbladdress = new JLabel("Address: ");
//		JLabel lblPhone = new JLabel("Phone: ");
//		JLabel lbllname = new JLabel("Last Name: ");
//		JLabel lblemail = new JLabel("Email: ");
//
//		// Person - Guests fields
//		textField_guestId = new JTextField();
//		textField_guestId.setEditable(false); // guestId not editable
//
//		textField_fname = new JTextField();
//		textField_address = new JTextField();
//		textField_email = new JTextField();
//		textField_phone = new JTextField();
//		textField_lname = new JTextField();
//
//		GroupLayout gl = new GroupLayout(guestInfoPanel);
//		guestInfoPanel.setLayout(gl);
//		guestInfoPanel.setBorder(BorderFactory.createTitledBorder("Info"));
//		gl.setAutoCreateGaps(true);
//		gl.setAutoCreateContainerGaps(true);
//
//		gl.setHorizontalGroup(gl
//				.createSequentialGroup()
//				.addGroup(
//						gl.createParallelGroup(GroupLayout.Alignment.LEADING)
//								.addComponent(lblguestId)
//								.addComponent(lblfname)
//								.addComponent(lbladdress)
//								.addComponent(lbllname)
//								.addComponent(lblPhone)
//								.addComponent(lbladdress)
//								.addComponent(lblPhone)
//								.addComponent(lblemail))
//				.addGroup(
//						gl.createParallelGroup(GroupLayout.Alignment.LEADING)
//								.addComponent(textField_guestId)
//								.addComponent(textField_fname)
//								.addComponent(textField_lname)
//								.addComponent(textField_address)
//								.addComponent(textField_phone)
//								.addComponent(textField_email)));
//		gl.setVerticalGroup(gl
//				.createSequentialGroup()
//				.addGroup(
//						gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
//								.addComponent(lblguestId)
//								.addComponent(textField_guestId))
//				.addGroup(
//						gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
//								.addComponent(lblfname)
//								.addComponent(textField_fname))
//				.addGroup(
//						gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
//								.addComponent(lbllname)
//								.addComponent(textField_lname))
//				.addGroup(
//						gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
//								.addComponent(lbladdress)
//								.addComponent(textField_address))
//				.addGroup(
//						gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
//								.addComponent(lblPhone)
//								.addComponent(textField_phone))
//				.addGroup(
//						gl.createParallelGroup(GroupLayout.Alignment.LEADING)
//								.addComponent(lblemail)
//								.addComponent(textField_email)));
//
//		showGuestPanel.add(guestInfoPanel, BorderLayout.NORTH);
//
//		choicePanel = new JPanel();
//		choicePanel.setLayout(new FlowLayout());
//		
//		btnCreate = new JButton("Create");
//		btnDelete = new JButton("Delete");
//		btnSave = new JButton("Save");
//		btnCancel = new JButton("Clear");
//
//		choicePanel.add(btnCreate);
//		choicePanel.add(btnSave);
//		choicePanel.add(btnDelete);
//		choicePanel.add(btnCancel);
//		showGuestPanel.add(choicePanel, BorderLayout.CENTER);
//
//		addGuestsTable();
//		showAllGuests();
//
//		btnCreate.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (!textField_guestId.getText().isEmpty()) {
//					JOptionPane.showMessageDialog(null,
//							"Please clear guest fields before create one",
//							"Error", JOptionPane.ERROR_MESSAGE);
//				} else {
//					try {
//						personCtr.createGuest(
//								textField_fname.getText(),
//								textField_lname.getText(),
//								textField_address.getText(),
//								textField_phone.getText(),
//								textField_email.getText(), 
//								"Guest");
//						JOptionPane.showMessageDialog(null,
//								"The guest is created", "Create Guest",
//								JOptionPane.INFORMATION_MESSAGE);
//					} catch (Exception ex) {
//						// TODO number exception
//						JOptionPane.showMessageDialog(null,
//								"Please input correct values", "Error",
//								JOptionPane.ERROR_MESSAGE);
//					}
//					cleanTextField();
//					showAllGuests();
//				}
//			}
//		});
//
//		btnDelete.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (textField_guestId.getText().isEmpty()) {
//					JOptionPane.showMessageDialog(null,
//							"Please select a guest", "Error",
//							JOptionPane.ERROR_MESSAGE);
//				} else {
//					int reply = JOptionPane.showConfirmDialog(null,
//							"Do you want to delete this guest ?",
//							"Delete Guest", JOptionPane.YES_NO_OPTION,
//							JOptionPane.WARNING_MESSAGE);
//					if (reply == JOptionPane.YES_OPTION) {
//						try {
//							personCtr.deletePerson(Integer
//									.parseInt(textField_guestId.getText()));
//							JOptionPane.showMessageDialog(null,
//									"The guest is deleted", "Delete Guest",
//									JOptionPane.INFORMATION_MESSAGE);
//							cleanTextField();
//
//							showAllGuests();
//						} catch (Exception e1) {
//						}
//					}
//				}
//			}
//		});
//
//		btnSave.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (textField_guestId.getText().isEmpty()) {
//					JOptionPane.showMessageDialog(null,
//							"Please select a guest", "Error",
//							JOptionPane.ERROR_MESSAGE);
//				} else {
//					try {
//						personCtr.updatePerson(
//								Integer.parseInt(textField_guestId.getText()),
//								textField_fname.getText(),
//								textField_lname.getText(),
//								textField_address.getText(),
//								textField_phone.getText(),
//								textField_email.getText(), 
//								5);
//						JOptionPane.showMessageDialog(null,
//								"The guest info is saved", "Update Guest",
//								JOptionPane.INFORMATION_MESSAGE);
//					} catch (Exception a) {
//						JOptionPane.showMessageDialog(null,
//								"Please input correct values", "Error",
//								JOptionPane.ERROR_MESSAGE);
//					}
//
//					cleanTextField();
//					showAllGuests();
//				}
//			}
//		});
//
//		btnCancel.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				cleanTextField();
//			}
//		});
//
//	}
//
//	//Person - Guests grid
//	public void addGuestsTable() {
//		guestTableModel = new DefaultTableModel() {
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				return false;
//			}
//		};
//		guestTableModel.addColumn("ID");
//		guestTableModel.addColumn("First Name");
//		guestTableModel.addColumn("Last Name");
//		guestTableModel.addColumn("Phone");
//		guestTableModel.addColumn("Email");
//
//		guestTableScrollPane = new JScrollPane();
//
//		showAllGuestPanel.add(guestTableScrollPane, BorderLayout.CENTER);
//
//		showAllGuestTable = new JTable(guestTableModel);
//		showAllGuestTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
//		showAllGuestTable.setAutoCreateRowSorter(true);
//
//		showAllGuestTable.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//
//				int row = showAllGuestTable.rowAtPoint(e.getPoint());
//				showGuest(Integer.valueOf((Integer) showAllGuestTable
//						.getValueAt(row, 0)));
//			}
//		});
//		guestTableScrollPane.setViewportView(showAllGuestTable);
//	}
//
////	public void showAllGuests() {
////		guestTableModel.setRowCount(0);
////		String searchFilter = txt_Search.getText();
////
////		ArrayList<Guest> guests = personCtr.getAllGuest();
////
////		for (Guest guest : guests) {
////			if (((Integer) guest.getID()).toString().toLowerCase()
////					.contains(searchFilter.toLowerCase())
////					|| guest.getfName().toLowerCase()
////							.contains(searchFilter.toLowerCase())
////					|| guest.getlName().toLowerCase()
////							.contains(searchFilter.toLowerCase()))
////				try {
////					guestTableModel.addRow(new Object[] { 
////							guest.getID(),
////							guest.getfName(), 
////							guest.getlName(),
////							guest.getPhone(),
////							guest.getEmail()});
////				} catch (Exception e) {
////					JOptionPane.showMessageDialog(null, e, "Error",
////							JOptionPane.ERROR_MESSAGE);
////				}
////		}
////	}
//
//	public boolean showGuest(int guestId) {
//		boolean success = true;
//		Guest guest = null;
//		try {
//			if (guestId != 0) {
//				guest = (Guest) personCtr.getPerson(guestId);
//			}
//		} catch (Exception e) {
//			success = false;
//			JOptionPane.showMessageDialog(null, e, "Error",
//					JOptionPane.ERROR_MESSAGE);
//			return success;
//		}
//
//		if (success) {
//			textField_guestId.setText(Integer.toString(guest.getID()));
//			textField_fname.setText(guest.getfName());
//			textField_lname.setText(guest.getlName());
//			textField_address.setText(guest.getAddress());
//			textField_email.setText(guest.getEmail());
//			textField_phone.setText(guest.getPhone());
//		}
//		return success;
//	}
//
//	public void refreshTable() {
//
//	}
//
//	public int getTextFieldId(JTextField textField) {
//		int id = 0;
//		try {
//			id = Integer.parseInt(textField.getText());
//		} catch (NumberFormatException e) {
//			JOptionPane.showMessageDialog(null, "Please input number", "Error",
//					JOptionPane.ERROR_MESSAGE);
//		} finally {
//			textField.setText("");
//		}
//		return id;
//	}
//
//	public void cleanTextField() {
//		txt_Search.setText("");
//		textField_guestId.setText("");
//		textField_fname.setText("");
//		textField_lname.setText("");
//		textField_address.setText("");
//		textField_email.setText("");
//		textField_phone.setText("");
//	}
//}
