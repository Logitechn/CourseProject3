package GUILayer;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class MainMenuSimpleWithLogIn {
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel mainContainer;
	private JPanel mainMenuPanel;
	private JPanel personPanel;
	private JPanel buttonPanel;
	private LoginUI loginUI;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuSimpleWithLogIn window = new MainMenuSimpleWithLogIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainMenuSimpleWithLogIn() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Veterinary System");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				close();
			}
		});
		frame.setSize(1200, 740);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		loginUI = new LoginUI();
		frame.getContentPane().add(loginUI, "loginUI");

		loginUI.getLoginBtnLogin().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginUI.login();
				if (LoginUI.getLoggedInId() != 0) {
					loginInit();
				}
			}
		});

	}

	public void loginInit() {
		mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, "mainPanel");
		mainPanel.setLayout(new BorderLayout());
		mainMenuPanel = new JPanel();
		mainPanel.add(mainMenuPanel, BorderLayout.NORTH);
		mainMenuPanel.setLayout(new BorderLayout());

		buttonPanel = new JPanel();
		mainMenuPanel.add(buttonPanel, BorderLayout.WEST);

		mainContainer = new JPanel();
		mainContainer.setLayout(new CardLayout());
		mainPanel.add(mainContainer, BorderLayout.CENTER);

			JButton personButton = new JButton("Person");
			buttonPanel.add(personButton);

			personButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						frame.setCursor(Cursor
								.getPredefinedCursor(Cursor.WAIT_CURSOR));
						disposeAll();
						personPanel = new PersonGUI();
						mainContainer.add(personPanel, "personPanel");
						CardLayout cl = (CardLayout) (mainContainer.getLayout());
						cl.show(mainContainer, "personPanel");
						mainContainer.updateUI();
					} finally {
						frame.setCursor(Cursor.getDefaultCursor());
					}
				}
			});

		JLabel lbllogInd = new JLabel("Log In Name: "
				+ LoginUI.getLoggedInName());
		JButton logoutButton = new JButton("Log Out");

		JPanel logPanel = new JPanel();
		logPanel.setLayout(new FlowLayout());
		logPanel.add(lbllogInd);
		logPanel.add(logoutButton);
		mainMenuPanel.add(logPanel, BorderLayout.EAST);

		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(mainPanel);
				LoginUI.logout();
				CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
				cl.show(frame.getContentPane(), "loginUI");
			}
		});

		CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
		cl.show(frame.getContentPane(), "mainPanel");
	}

	private void disposeAll() {
		try {
			for (Component comp : mainContainer.getComponents()) {
				System.out.println("MainMenuSimple - Removing component "
						+ comp.getClass().getName());
				mainContainer.remove(comp);
			}
		} catch (NullPointerException e) {

		}

	}

	public void close() {
		System.exit(1);
	}
}
