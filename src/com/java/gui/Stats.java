package com.java.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.java.connection.Connection;

import net.proteanit.sql.DbUtils;

public class Stats  implements ActionListener{

	public JFrame frmStatistics;
	private JTable issued;
	private JTable returned;
	private JTextField getreturn;
	private JTextField getadm;
	private JTextField getissue;
	Connection conn; PreparedStatement pst,ps;

	
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Stats() throws ClassNotFoundException, SQLException {
		initialize();
		LoadTables();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStatistics = new JFrame();
		frmStatistics.setResizable(false);
		frmStatistics.getContentPane().setBackground(Color.CYAN);
		frmStatistics.setTitle("STATISTICS");
		frmStatistics.setBounds(100, 100, 991, 586);
		frmStatistics.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmStatistics.getContentPane().setLayout(null);
		
		issued = new JTable();
		issued.setFont(new Font("Dialog", Font.BOLD, 10));
		issued.setForeground(new Color(255, 255, 0));
		issued.setBackground(new Color(75, 0, 130));
		issued.setBounds(12, 54, 955, 206);
		frmStatistics.getContentPane().add(issued);
		
		returned = new JTable();
		returned.setFont(new Font("Dialog", Font.BOLD, 10));
		returned.setForeground(Color.GREEN);
		returned.setBackground(new Color(139, 0, 0));
		returned.setBounds(22, 346, 945, 206);
		frmStatistics.getContentPane().add(returned);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(345, 14, 70, 15);
		frmStatistics.getContentPane().add(lblNewLabel);
		
		JLabel lblSearch = new JLabel("STUDENT ADM");
		lblSearch.setForeground(Color.BLACK);
		lblSearch.setBounds(206, 272, 125, 15);
		frmStatistics.getContentPane().add(lblSearch);
		
		getreturn = new JTextField();
		getreturn.setBounds(471, 294, 234, 31);
		frmStatistics.getContentPane().add(getreturn);
		getreturn.addActionListener(this);
		getreturn.setColumns(10);
		
		JLabel lblBookIsbn = new JLabel("BOOK ISBN:");
		lblBookIsbn.setForeground(Color.BLACK);
		lblBookIsbn.setBounds(522, 272, 105, 15);
		frmStatistics.getContentPane().add(lblBookIsbn);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 69, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(395, 255, 6, 93);
		frmStatistics.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(364, 255, 2, 73);
		frmStatistics.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(427, 255, 2, 73);
		frmStatistics.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(413, 255, 2, 73);
		frmStatistics.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(381, 255, 2, 73);
		frmStatistics.getContentPane().add(separator_4);
		
		getadm = new JTextField();
		getadm.setColumns(10);
		getadm.setBounds(122, 299, 234, 28);
		getadm.addActionListener(this);
		frmStatistics.getContentPane().add(getadm);
		
		JLabel lblReturned = new JLabel("RETURNED");
		lblReturned.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblReturned.setForeground(new Color(0, 100, 0));
		lblReturned.setBounds(22, 272, 77, 15);
		frmStatistics.getContentPane().add(lblReturned);
		
		JLabel lblNewLabel_1 = new JLabel("ISSUED");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(22, 6, 70, 15);
		frmStatistics.getContentPane().add(lblNewLabel_1);
		
		getissue = new JTextField();
		getissue.setColumns(10);
		getissue.setBounds(413, 6, 234, 31);
		getissue.addActionListener(this);
		frmStatistics.getContentPane().add(getissue);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Publisher");
		lblNewLabel_2_1_3.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3.setBounds(423, 38, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_3_1 = new JLabel("Student");
		lblNewLabel_2_1_3_1.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_1.setBounds(549, 38, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_1);
		
		JLabel lblNewLabel_2_1_3_2 = new JLabel("Admission");
		lblNewLabel_2_1_3_2.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_2.setBounds(661, 38, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_2);
		
		JLabel lblNewLabel_2_1_3_3 = new JLabel("Mobile");
		lblNewLabel_2_1_3_3.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_3.setBounds(777, 38, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_3);
		
		JLabel lblNewLabel_2_1_3_4 = new JLabel("year");
		lblNewLabel_2_1_3_4.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_4.setBounds(877, 38, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_4);
		
		JLabel lblNewLabel_2_1_3_5 = new JLabel("Writer");
		lblNewLabel_2_1_3_5.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_5.setBounds(337, 40, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_5);
		
		JLabel lblNewLabel_2_1_3_6 = new JLabel("ISBN");
		lblNewLabel_2_1_3_6.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_6.setBounds(232, 40, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_6);
		
		JLabel lblNewLabel_2_1_3_7 = new JLabel("Book Name");
		lblNewLabel_2_1_3_7.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_7.setBounds(125, 40, 75, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_7);
		
		JLabel lblNewLabel_2_1_3_8 = new JLabel("Date Issued");
		lblNewLabel_2_1_3_8.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_8.setBounds(35, 38, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_8);
		
		JLabel lblNewLabel_2_1_3_8_1 = new JLabel("Date Issued");
		lblNewLabel_2_1_3_8_1.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_8_1.setBounds(41, 333, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_8_1);
		
		JLabel lblNewLabel_2_1_3_7_1 = new JLabel("Book Name");
		lblNewLabel_2_1_3_7_1.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_7_1.setBounds(132, 333, 75, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_7_1);
		
		JLabel lblNewLabel_2_1_3_6_1 = new JLabel("ISBN");
		lblNewLabel_2_1_3_6_1.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_6_1.setBounds(232, 333, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_6_1);
		
		JLabel lblNewLabel_2_1_3_5_1 = new JLabel("Writer");
		lblNewLabel_2_1_3_5_1.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_5_1.setBounds(337, 333, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_5_1);
		
		JLabel lblNewLabel_2_1_3_9 = new JLabel("Publisher");
		lblNewLabel_2_1_3_9.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_9.setBounds(412, 333, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_9);
		
		JLabel lblNewLabel_2_1_3_1_1 = new JLabel("Student");
		lblNewLabel_2_1_3_1_1.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_1_1.setBounds(509, 333, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_1_1);
		
		JLabel lblNewLabel_2_1_3_2_1 = new JLabel("Admission");
		lblNewLabel_2_1_3_2_1.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_2_1.setBounds(601, 333, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_2_1);
		
		JLabel lblNewLabel_2_1_3_3_1 = new JLabel("Mobile");
		lblNewLabel_2_1_3_3_1.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_3_1.setBounds(708, 333, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_3_1);
		
		JLabel lblNewLabel_2_1_3_4_1 = new JLabel("year");
		lblNewLabel_2_1_3_4_1.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_4_1.setBounds(804, 333, 64, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_4_1);
		
		JLabel lblNewLabel_2_1_3_8_2 = new JLabel("Date Returned");
		lblNewLabel_2_1_3_8_2.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2_1_3_8_2.setBounds(880, 331, 99, 15);
		frmStatistics.getContentPane().add(lblNewLabel_2_1_3_8_2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			conn = new Connection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/**
		 * search a book in issued record
		 */
		if(e.getSource().equals(getissue)) {
			if(getissue.getText().isBlank()) {
				JOptionPane.showMessageDialog(frmStatistics, "Empty Field!!");
			}else {
				try {
					pst = conn.connect.prepareStatement("select * from issuebook where ISBN=?");
					pst.setString(1, getissue.getText());
					issued.setModel(DbUtils.resultSetToTableModel(pst.executeQuery()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		
		/**
		 * search a student in return records
		 */
		else if(e.getSource().equals(getadm)) {
			if(getadm.getText().isBlank()) {
				JOptionPane.showMessageDialog(frmStatistics, "Empty Field!!");
			}else {
				try {
					pst = conn.connect.prepareStatement("select * from returnbook where adm=?");
					pst.setString(1, getadm.getText());
					returned.setModel(DbUtils.resultSetToTableModel(pst.executeQuery()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		/**
		 * search a book in returns
		 */
		
		else if(e.getSource().equals(getreturn)) {
			if(getreturn.getText().isBlank()) {
				JOptionPane.showMessageDialog(frmStatistics, "Empty Field!!");
			}else {
				try {
					pst = conn.connect.prepareStatement("select * from returnbook where ISBN=?");
					pst.setString(1, getreturn.getText());
					returned.setModel(DbUtils.resultSetToTableModel(pst.executeQuery()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	private void LoadTables() throws ClassNotFoundException, SQLException {
		conn = new Connection();
		pst = conn.connect.prepareStatement("select * from issuebook");
		issued.setModel(DbUtils.resultSetToTableModel(pst.executeQuery()));
		ps = conn.connect.prepareStatement("select * from returnbook");
		returned.setModel(DbUtils.resultSetToTableModel(ps.executeQuery()));
	}
}
