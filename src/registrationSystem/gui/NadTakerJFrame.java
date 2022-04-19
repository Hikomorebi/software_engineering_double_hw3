package registrationSystem.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import registrationSystem.dal.entity.NadTaker;
import registrationSystem.dal.daoImp.NadTakerDaoImp;

public class NadTakerJFrame extends JFrame {
	private JPanel contentPane;
	private List<String> cols;
	private List<NadTaker> rows;
	private NadTakerDaoImp nadTakerDaoImp;
	private SimpleTableModel<NadTaker> simpleTableModel;
	private JTable jTable;

	public NadTakerJFrame() {
		setTitle("������Ǽ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		cols = new ArrayList<>();
		cols.add("ID");
		cols.add("����");
		cols.add("����");
		cols.add("��ַ");
		cols.add("���֤��");
		cols.add("��ϵ��ʽ");
		cols.add("���ʱ��");
		cols.add("�����");
		nadTakerDaoImp = new NadTakerDaoImp();
		rows = nadTakerDaoImp.getAllTaker();
		simpleTableModel = new SimpleTableModel<NadTaker>(cols, rows);

		JLabel jLabel = new JLabel();
		jLabel.setText("������Ǽ�ϵͳ");
		jLabel.setFont(new Font("Lucida Grande", 0, 36));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(jLabel, BorderLayout.PAGE_START);
		JScrollPane jScrollPane = new JScrollPane();
		jTable = new JTable();
		jTable.setModel(simpleTableModel);
		jScrollPane.setViewportView(jTable);
		getContentPane().add(jScrollPane, BorderLayout.CENTER);

		JLabel jLabel2 = new JLabel();
		jLabel2.setText("״̬��");
		getContentPane().add(jLabel2, BorderLayout.PAGE_END);

		JMenuBar jMenuBar = new JMenuBar();
		JMenu edit = new JMenu();
		edit.setText("ѡ��");
		edit.setToolTipText("");
		JMenuItem register = new JMenuItem();
		register.setText("�Ǽ�");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				registerActionPerformed(evt);
			}
		});
		
		JMenuItem query = new JMenuItem();
		query.setText("��ѯ");
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				queryActionPerformed(evt);
			}
		});
		edit.add(register);
		edit.add(query);

        jMenuBar.add(edit);
        
              
        setJMenuBar(jMenuBar);
        pack();

	}
	 private void registerActionPerformed(ActionEvent evt) {
	     new RegisterJFrame().setVisible(true);
	 }
	 
	 private void queryActionPerformed(ActionEvent evt) {
		 rows=nadTakerDaoImp.getAllTaker();
	     simpleTableModel.setRows(rows);
		 new QueryJFrame(jTable).setVisible(true);
	 }
}
