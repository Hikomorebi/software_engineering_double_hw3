package registrationSystem.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import registrationSystem.dal.entity.NadTaker;
import registrationSystem.dal.daoImp.NadTakerDaoImp;

public class RegisterJFrame extends JFrame {
	private JPanel contentPane;
	private JTextField sname;
	private JTextField sage;
	private JTextField saddress;
	private JTextField snumber;
	private JTextField sphone;
	private JTextField stime;
	private JTextField state;


	public RegisterJFrame() {
		setTitle("ע��");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 426, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		sname = new JTextField();
		sname.setBounds(195, 50, 140, 20);
		contentPane.add(sname);
		sname.setColumns(10);

		sage = new JTextField();
		sage.setBounds(195, 100, 140, 20);
		contentPane.add(sage);
		sage.setColumns(10);

		saddress = new JTextField();
		saddress.setBounds(195, 150, 140, 20);
		contentPane.add(saddress);
		saddress.setColumns(10);

		snumber = new JTextField();
		snumber.setBounds(195, 200, 140, 20);
		contentPane.add(snumber);
		snumber.setColumns(10);

		sphone = new JTextField();
		sphone.setBounds(195, 250, 140, 20);
		contentPane.add(sphone);
		sphone.setColumns(10);
		


		JLabel labelName = new JLabel("������");
		labelName.setBounds(90, 50, 66, 15);
		contentPane.add(labelName);

		JLabel labelAge = new JLabel("���䣺");
		labelAge.setBounds(90, 100, 66, 15);
		contentPane.add(labelAge);

		JLabel labelAddress = new JLabel("��ַ��");
		labelAddress.setBounds(90, 150, 66, 15);
		contentPane.add(labelAddress);

		JLabel labelSnumber = new JLabel("���֤�ţ�");
		labelSnumber.setBounds(90, 200, 66, 15);
		contentPane.add(labelSnumber);

		JLabel labelPhone = new JLabel("��ϵ�绰��");
		labelPhone.setBounds(90, 250, 66, 15);
		contentPane.add(labelPhone);

		
		JButton buttonAdd = new JButton("ע��");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerTakerActionPerformed(e);
			}
		});
		buttonAdd.setBounds(91, 327, 93, 23);
		contentPane.add(buttonAdd);

		JButton buttonCancel = new JButton("ȡ��");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelActionPerformed(e);
			}
		});
		buttonCancel.setBounds(230, 327, 93, 23);
		contentPane.add(buttonCancel);
	}

	private void registerTakerActionPerformed(ActionEvent event) {
		NadTaker nadTaker = new NadTaker();
		NadTakerDaoImp nadTakerDaoImp = new NadTakerDaoImp();
		try {
			nadTaker.setSname(sname.getText());
			nadTaker.setSage(Integer.parseInt(sage.getText()));
			nadTaker.setSaddress(saddress.getText());
			nadTaker.setSnumber(snumber.getText());
			nadTaker.setSphone(sphone.getText());
			nadTaker.setStime("");
			nadTaker.setState("��δ���");
			nadTakerDaoImp.registerTaker(nadTaker);
			JOptionPane.showMessageDialog(this, "ע��ɹ���", "��Ӽ����Ա��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "ע��ʧ�ܣ�", "��Ӽ����Ա��Ϣ", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cancelActionPerformed(ActionEvent event) {
		this.setVisible(false);
		this.dispose();
	}
}
