package registrationSystem.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import registrationSystem.dal.entity.NadTaker;
import registrationSystem.dal.daoImp.NadTakerDaoImp;
/**
 * @author Kunbin He,Haoze Zhu
 * @version ����ʱ�䣺2021��4��20��
 */
public class QueryJFrame extends JFrame {
	private JPanel contentPane;
	private JTextField idJTextField;
	private JTable jTable;

	public QueryJFrame() {
		setTitle("�������֤�Ų�ѯ��������");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("���֤��:");
		lblId.setFont(new Font("����", Font.PLAIN, 16));
		lblId.setBounds(91, 48, 54, 15);
		contentPane.add(lblId);

		idJTextField = new JTextField();
		idJTextField.setBounds(155, 46, 166, 21);
		contentPane.add(idJTextField);
		idJTextField.setColumns(10);

		JButton buttonSearch = new JButton("��ѯ");
		buttonSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchActionPerformed(e);
			}
		});
		buttonSearch.setBounds(169, 96, 93, 23);
		contentPane.add(buttonSearch);
	}

	public QueryJFrame(JTable jTable) throws HeadlessException {
		super();
		this.jTable = jTable;
		setTitle("�������֤�Ų�ѯ��������");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("���֤��:");
		lblId.setFont(new Font("����", Font.PLAIN, 16));
		lblId.setBounds(81, 48, 84, 15);
		contentPane.add(lblId);

		idJTextField = new JTextField();
		idJTextField.setBounds(155, 46, 166, 21);
		contentPane.add(idJTextField);
		idJTextField.setColumns(10);

		JButton buttonSearch = new JButton("��ѯ");
		buttonSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchActionPerformed(e);
			}
		});
		buttonSearch.setBounds(169, 96, 93, 23);
		contentPane.add(buttonSearch);
	}

	private void searchActionPerformed(ActionEvent event) {
		try {
			jTable.clearSelection();
			String queryNumber = this.idJTextField.getText();
			String ans = new NadTakerDaoImp().getAnswer(queryNumber);
			JOptionPane.showMessageDialog(this, "��ѯ���Ϊ��" + ans, "��ѯ��������", JOptionPane.DEFAULT_OPTION);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "��ѯʧ�ܣ�", "��ѯ��������", JOptionPane.ERROR_MESSAGE);
		}

	}
}
