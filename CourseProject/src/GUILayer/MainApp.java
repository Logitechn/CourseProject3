package GUILayer;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainApp {

	private JFrame frame;
	private JPanel panelButtonLogout;
	private JPanel panelButton1;
	private JPanel panelButton2;
	private JPanel panelButton3;
	private JPanel panelButton4;
	private JPanel panelButton5;
	private JPanel panelButton6;
	private JPanel panelButton7;
	private JPanel panelButton8;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (Exception e) {
//		}
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainApp window = new MainApp();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		Toolkit tk = Toolkit.getDefaultToolkit();
		frame.setBounds(0, 0, ((int) tk.getScreenSize().getWidth()), ((int) tk
				.getScreenSize().getHeight()));
		frame.setSize(((int) tk.getScreenSize().getWidth()), ((int) tk
				.getScreenSize().getHeight()));
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.DARK_GRAY);

		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(Color.LIGHT_GRAY);

		JPanel userInfoPanel = new JPanel();
		userInfoPanel.setBackground(Color.GRAY);

		JPanel userImagePanel = new JPanel();

		JLabel lblWelcomeBackuser = new JLabel("Welcome back, {user}");
		lblWelcomeBackuser.setForeground(Color.WHITE);
		lblWelcomeBackuser.setFont(new Font("Calibri", Font.PLAIN, 18));

		panelButtonLogout = new JPanel();
		panelButtonLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelButtonLogout.setBackground(Color.DARK_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelButtonLogout.setBackground(Color.LIGHT_GRAY);
			}
		});
		panelButtonLogout.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_userInfoPanel = new GroupLayout(userInfoPanel);
		gl_userInfoPanel
				.setHorizontalGroup(gl_userInfoPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_userInfoPanel
										.createSequentialGroup()
										.addGap(6)
										.addComponent(userImagePanel,
												GroupLayout.PREFERRED_SIZE, 96,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_userInfoPanel
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_userInfoPanel
																		.createSequentialGroup()
																		.addComponent(
																				lblWelcomeBackuser,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGap(245))
														.addGroup(
																gl_userInfoPanel
																		.createSequentialGroup()
																		.addComponent(
																				panelButtonLogout,
																				GroupLayout.PREFERRED_SIZE,
																				96,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap()))));
		gl_userInfoPanel
				.setVerticalGroup(gl_userInfoPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_userInfoPanel
										.createSequentialGroup()
										.addGroup(
												gl_userInfoPanel
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addGroup(
																gl_userInfoPanel
																		.createSequentialGroup()
																		.addGap(6)
																		.addComponent(
																				userImagePanel,
																				GroupLayout.PREFERRED_SIZE,
																				96,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_userInfoPanel
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				lblWelcomeBackuser)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				panelButtonLogout,
																				GroupLayout.PREFERRED_SIZE,
																				28,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		JLabel lblLogOut = new JLabel("Log Out");
		lblLogOut.setFont(new Font("Calibri", Font.BOLD, 14));
		lblLogOut.setForeground(Color.WHITE);
		GroupLayout gl_panelButtonLogout = new GroupLayout(panelButtonLogout);
		gl_panelButtonLogout.setHorizontalGroup(gl_panelButtonLogout
				.createParallelGroup(Alignment.LEADING).addGroup(
						gl_panelButtonLogout
								.createSequentialGroup()
								.addGap(24)
								.addComponent(lblLogOut,
										GroupLayout.DEFAULT_SIZE, 50,
										Short.MAX_VALUE).addGap(48)));
		gl_panelButtonLogout.setVerticalGroup(gl_panelButtonLogout
				.createParallelGroup(Alignment.LEADING).addGroup(
						Alignment.TRAILING,
						gl_panelButtonLogout.createSequentialGroup().addGap(6)
								.addComponent(lblLogOut)
								.addGap(0, 0, Short.MAX_VALUE)));
		panelButtonLogout.setLayout(gl_panelButtonLogout);

		JLabel lblUserimage = new JLabel("UserImage");
		GroupLayout gl_userImagePanel = new GroupLayout(userImagePanel);
		gl_userImagePanel.setHorizontalGroup(gl_userImagePanel
				.createParallelGroup(Alignment.LEADING).addGroup(
						gl_userImagePanel.createSequentialGroup().addGap(22)
								.addComponent(lblUserimage)
								.addContainerGap(22, Short.MAX_VALUE)));
		gl_userImagePanel.setVerticalGroup(gl_userImagePanel
				.createParallelGroup(Alignment.LEADING).addGroup(
						gl_userImagePanel.createSequentialGroup().addGap(41)
								.addComponent(lblUserimage)
								.addContainerGap(41, Short.MAX_VALUE)));
		userImagePanel.setLayout(gl_userImagePanel);
		userInfoPanel.setLayout(gl_userInfoPanel);
		GroupLayout gl_infoPanel = new GroupLayout(infoPanel);
		gl_infoPanel.setHorizontalGroup(gl_infoPanel.createParallelGroup(
				Alignment.TRAILING).addGroup(
				gl_infoPanel
						.createSequentialGroup()
						.addGap(6)
						.addComponent(logoPanel, GroupLayout.PREFERRED_SIZE,
								512, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 236,
								Short.MAX_VALUE)
						.addComponent(userInfoPanel,
								GroupLayout.PREFERRED_SIZE, 512,
								GroupLayout.PREFERRED_SIZE).addGap(6)));
		gl_infoPanel
				.setVerticalGroup(gl_infoPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_infoPanel
										.createSequentialGroup()
										.addGap(6)
										.addGroup(
												gl_infoPanel
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																logoPanel,
																GroupLayout.DEFAULT_SIZE,
																96,
																Short.MAX_VALUE)
														.addComponent(
																userInfoPanel,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGap(6)));
		infoPanel.setLayout(gl_infoPanel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.GRAY);

		panelButton1 = new JPanel();
		panelButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelButton1.setBackground(Color.DARK_GRAY);
			}

			public void mouseExited(MouseEvent e) {
				panelButton1.setBackground(Color.LIGHT_GRAY);
			}
		});
		panelButton1.setBackground(Color.LIGHT_GRAY);

		panelButton2 = new JPanel();
		panelButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelButton2.setBackground(Color.DARK_GRAY);
			}

			public void mouseExited(MouseEvent e) {
				panelButton2.setBackground(Color.LIGHT_GRAY);
			}
		});
		panelButton2.setBackground(Color.LIGHT_GRAY);

		panelButton3 = new JPanel();
		panelButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelButton3.setBackground(Color.DARK_GRAY);
			}

			public void mouseExited(MouseEvent e) {
				panelButton3.setBackground(Color.LIGHT_GRAY);
			}
		});
		panelButton3.setBackground(Color.LIGHT_GRAY);

		panelButton4 = new JPanel();
		panelButton4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelButton4.setBackground(Color.DARK_GRAY);
			}

			public void mouseExited(MouseEvent e) {
				panelButton4.setBackground(Color.LIGHT_GRAY);
			}
		});
		panelButton4.setBackground(Color.LIGHT_GRAY);

		panelButton5 = new JPanel();
		panelButton5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelButton5.setBackground(Color.DARK_GRAY);
			}

			public void mouseExited(MouseEvent e) {
				panelButton5.setBackground(Color.LIGHT_GRAY);
			}
		});
		panelButton5.setBackground(Color.LIGHT_GRAY);

		panelButton6 = new JPanel();
		panelButton6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelButton6.setBackground(Color.DARK_GRAY);
			}

			public void mouseExited(MouseEvent e) {
				panelButton6.setBackground(Color.LIGHT_GRAY);
			}
		});
		panelButton6.setBackground(Color.LIGHT_GRAY);

		panelButton7 = new JPanel();
		panelButton7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelButton7.setBackground(Color.DARK_GRAY);
			}

			public void mouseExited(MouseEvent e) {
				panelButton7.setBackground(Color.LIGHT_GRAY);
			}
		});
		panelButton7.setBackground(Color.LIGHT_GRAY);

		panelButton8 = new JPanel();
		panelButton8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelButton8.setBackground(Color.DARK_GRAY);
			}

			public void mouseExited(MouseEvent e) {
				panelButton8.setBackground(Color.LIGHT_GRAY);
			}
		});
		panelButton8.setBackground(Color.LIGHT_GRAY);

		GroupLayout gl_buttonPanel = new GroupLayout(buttonPanel);
		gl_buttonPanel.setHorizontalGroup(gl_buttonPanel.createParallelGroup(
				Alignment.TRAILING).addGroup(
				gl_buttonPanel
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_buttonPanel
										.createParallelGroup(Alignment.LEADING,
												false)
										.addComponent(panelButton1,
												GroupLayout.PREFERRED_SIZE, 76,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(panelButton2,
												GroupLayout.PREFERRED_SIZE, 76,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(panelButton3,
												GroupLayout.PREFERRED_SIZE, 76,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(panelButton4,
												GroupLayout.PREFERRED_SIZE, 76,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(panelButton5,
												GroupLayout.PREFERRED_SIZE, 76,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(panelButton6,
												GroupLayout.PREFERRED_SIZE, 76,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(panelButton7,
												GroupLayout.PREFERRED_SIZE, 76,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(panelButton8,
												GroupLayout.PREFERRED_SIZE, 76,
												GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_buttonPanel.setVerticalGroup(gl_buttonPanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_buttonPanel
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(panelButton1, GroupLayout.PREFERRED_SIZE,
								76, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelButton2, GroupLayout.PREFERRED_SIZE,
								76, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelButton3, GroupLayout.PREFERRED_SIZE,
								76, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelButton4, GroupLayout.PREFERRED_SIZE,
								76, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelButton5, GroupLayout.PREFERRED_SIZE,
								76, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelButton6, GroupLayout.PREFERRED_SIZE,
								76, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelButton7, GroupLayout.PREFERRED_SIZE,
								76, GroupLayout.PREFERRED_SIZE)
						.addGap(7)
						.addComponent(panelButton8, GroupLayout.PREFERRED_SIZE,
								76, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		buttonPanel.setLayout(gl_buttonPanel);

		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new LineBorder(Color.GRAY, 1, true));
		contentPanel.setBackground(Color.GRAY);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						groupLayout
								.createSequentialGroup()
								.addGap(6)
								.addComponent(buttonPanel,
										GroupLayout.PREFERRED_SIZE, 96,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(contentPanel,
										GroupLayout.DEFAULT_SIZE, 1188,
										Short.MAX_VALUE).addGap(6))
				.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 1280,
						Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addComponent(infoPanel, GroupLayout.PREFERRED_SIZE,
								115, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(contentPanel,
												GroupLayout.DEFAULT_SIZE, 663,
												Short.MAX_VALUE)
										.addComponent(buttonPanel,
												GroupLayout.DEFAULT_SIZE, 663,
												Short.MAX_VALUE)).addGap(6)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
