package registrationSystem.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import registrationSystem.dal.entity.User;
import registrationSystem.dal.daoImp.UserDaoImp;

import java.awt.CardLayout;
import java.awt.Event;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField userPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJFrame frame = new LoginJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginJFrame() {
		setTitle("��½������Ǽ�ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		CardLayout cardLayout = new CardLayout();

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);

		JPanel userPanel = new JPanel();
		contentPane.add(userPanel, "name_5600414879778");
		userPanel.setLayout(null);

		userName = new JTextField();
		userName.setBounds(148, 55, 122, 21);
		userPanel.add(userName);
		userName.setColumns(10);

		userPassword = new JPasswordField();
		userPassword.setBounds(148, 96, 122, 21);
		userPanel.add(userPassword);

		JButton userButton1 = new JButton("��½");
		userButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				userLoginActionPerformed(event);
			}
		});
		userButton1.setBounds(72, 159, 93, 23);
		userPanel.add(userButton1);

		JButton userButton2 = new JButton("ע��");
		userButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				userRegisterActionPerformed(event);
			}
		});
		userButton2.setBounds(220, 159, 93, 23);
		userPanel.add(userButton2);

		JLabel lbll = new JLabel("�û�����");
		lbll.setBounds(72, 58, 54, 15);
		userPanel.add(lbll);

		JLabel label = new JLabel("���룺");
		label.setBounds(72, 99, 54, 15);
		userPanel.add(label);

	}

	private void userLoginActionPerformed(ActionEvent event) {
		String uname = userName.getText();
		String upassword = new String(userPassword.getPassword());
		UserDaoImp userDaoImp = new UserDaoImp();
		if (userDaoImp.certifyUser(uname, upassword)) {
			JOptionPane.showMessageDialog(this, "��¼�ɹ�");
			/*
			 * JFrame studentJFrame = new JFrame();
			 * JFrame.setBounds(600, 400, 800, 600); JFrame.setVisible(true);
			 */
			this.setVisible(false);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "��¼ʧ�ܣ��˺Ż��������", "��¼������Ǽ�ϵͳ", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void userRegisterActionPerformed(ActionEvent event) {
		String uname = userName.getText();
		String upassword = new String(userPassword.getPassword());
		User user = new User(uname, upassword);
		UserDaoImp userDaoImp = new UserDaoImp();
		if (userDaoImp.addUser(user)) {
			JOptionPane.showMessageDialog(this, "ע��ɹ�");
		} else {
			JOptionPane.showMessageDialog(this, "ע��ʧ��!", "ע�������Ǽ�ϵͳ", JOptionPane.ERROR_MESSAGE);
		}
	}

}
