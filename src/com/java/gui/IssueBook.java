package com.java.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.java.connection.Connection;
import com.java.models.issue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class IssueBook implements ActionListener{

	public JFrame frmIssueBook;
	private JTextField getisbn;
	private JTextField getname;
	private JTextField getwriter;
	private JTextField getPublisher;
	private JTextField getadm;
	private JTextField getstudent;
	private JTextField getyear;
	private JTextField getmobile;
	private JButton btnIssue;
	Connection conn; PreparedStatement pst; issue iss ;
 private JTextField showdate;

	
	/**
	 * Create the application.
	 */
	public IssueBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIssueBook = new JFrame();
		frmIssueBook.getContentPane().setBackground(UIManager.getColor("OptionPane.warningDialog.titlePane.shadow"));
		frmIssueBook.setTitle("ISSUE BOOK");
		frmIssueBook.setResizable(false);
		frmIssueBook.setBounds(100, 100, 819, 459);
		frmIssueBook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmIssueBook.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ISSUE BOOK TO ENROLLED STUDENTS");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(227, 0, 341, 15);
		frmIssueBook.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(24, 45, 403, 311);
		frmIssueBook.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAdmissionNo = new JLabel("ADMISSION NO:");
		lblAdmissionNo.setBounds(86, 24, 133, 15);
		panel.add(lblAdmissionNo);
		
		getadm = new JTextField();
		getadm.setColumns(10);
		getadm.setBounds(227, 12, 164, 32);
		getadm.addActionListener(this);
		panel.add(getadm);
		
		JLabel lblStudentName = new JLabel("STUDENT NAME:");
		lblStudentName.setBounds(12, 108, 120, 15);
		panel.add(lblStudentName);
		
		getstudent = new JTextField();
		getstudent.setEditable(false);
		getstudent.setColumns(10);
		getstudent.setBounds(138, 92, 253, 32);
		panel.add(getstudent);
		
		JLabel lblYear = new JLabel("YEAR");
		lblYear.setBounds(47, 177, 73, 15);
		panel.add(lblYear);
		
		getyear = new JTextField();
		getyear.setEditable(false);
		getyear.setColumns(10);
		getyear.setBounds(138, 169, 253, 32);
		panel.add(getyear);
		
		JLabel lblMobile = new JLabel("MOBILE");
		lblMobile.setBounds(47, 243, 73, 15);
		panel.add(lblMobile);
		
		getmobile = new JTextField();
		getmobile.setEditable(false);
		getmobile.setColumns(10);
		getmobile.setBounds(138, 228, 253, 32);
		panel.add(getmobile);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBounds(438, 39, 369, 311);
		frmIssueBook.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel bbb = new JLabel("ISBN");
		bbb.setBounds(118, 33, 48, 15);
		panel_1.add(bbb);
		
		getisbn = new JTextField();
		getisbn.setBounds(176, 23, 181, 32);
		panel_1.add(getisbn);
		getisbn.addActionListener(this);
		getisbn.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Book Name");
		lblNewLabel_2.setBounds(10, 115, 79, 15);
		panel_1.add(lblNewLabel_2);
		
		getname = new JTextField();
		getname.setEditable(false);
		getname.setColumns(10);
		getname.setBounds(121, 107, 236, 32);
		panel_1.add(getname);
		
		JLabel nnn = new JLabel("Writer");
		nnn.setBounds(26, 181, 76, 15);
		panel_1.add(nnn);
		
		getwriter = new JTextField();
		getwriter.setEditable(false);
		getwriter.setColumns(10);
		getwriter.setBounds(121, 173, 236, 32);
		panel_1.add(getwriter);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(37, 250, 93, 15);
		panel_1.add(lblPublisher);
		
		getPublisher = new JTextField();
		getPublisher.setEditable(false);
		getPublisher.setColumns(10);
		getPublisher.setBounds(121, 242, 236, 32);
		panel_1.add(getPublisher);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(184, 25, 403, 2);
		frmIssueBook.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Search Student");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(70, 27, 173, 15);
		frmIssueBook.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Search Book");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setBounds(589, 25, 173, 15);
		frmIssueBook.getContentPane().add(lblNewLabel_1_1);
		
		btnIssue = new JButton("ISSUE BOOK");
		btnIssue.setForeground(Color.GREEN);
		btnIssue.setBackground(Color.DARK_GRAY);
		btnIssue.setBounds(346, 402, 222, 25);
		btnIssue.setFocusable(false);
		btnIssue.addActionListener(this);
		frmIssueBook.getContentPane().add(btnIssue);
		
		JLabel lblNewLabel_3 = new JLabel("DATE ISSUED");
		lblNewLabel_3.setBounds(222, 375, 131, 15);
		frmIssueBook.getContentPane().add(lblNewLabel_3);
		
		showdate = new JTextField();
		showdate.setFont(new Font("Dialog", Font.BOLD, 12));
		showdate.setBackground(Color.DARK_GRAY);
		showdate.setForeground(Color.WHITE);
		showdate.setEditable(false);
		showdate.setBounds(382, 368, 268, 24);
		frmIssueBook.getContentPane().add(showdate);
		showdate.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent ob) {
		// TODO Auto-generated method stub
		
		iss = new issue(LocalDate.now().toString(),getadm.getText(),getstudent.getText(),getyear.getText(),getmobile.getText(),
				              getisbn.getText(),getname.getText(),getwriter.getText(),getPublisher.getText());
		
		try {
			conn = new Connection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * Issue a book
		 */
		if(ob.getSource().equals(btnIssue)) {
			
			//validate fields
			try {
				Issue();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * search if a book is registered
		 */
		else if(ob.getSource().equals(getisbn)) {
			try {
				pst = conn.connect.prepareStatement("select * from books where ISBN =?");
				pst.setString(1, getisbn.getText());
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					getwriter.setText(rs.getString(3));
					getPublisher.setText(rs.getString(4));
					getname.setText(rs.getString(2));
				}else {
					JOptionPane.showMessageDialog(frmIssueBook, "Book not Availabe","Warning",JOptionPane.WARNING_MESSAGE);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		/**
		 * search for registered student
		 */
		else if(ob.getSource().equals(getadm)) {
			try {
				pst = conn.connect.prepareStatement("select * from students where adm =?");
				pst.setString(1, getadm.getText());
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					getstudent.setText(rs.getString(2));
					getyear.setText(rs.getString(4));
					getmobile.setText(rs.getString(5));
				}else {
					JOptionPane.showMessageDialog(frmIssueBook, "Student Not Enrolled!!","Warning",JOptionPane.WARNING_MESSAGE);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void Issue() throws SQLException {
		if(getstudent.getText().isBlank()||getadm.getText().isBlank()||getyear.getText().isBlank()||getmobile.getText().isBlank()||
		   getisbn.getText().isBlank()||getname.getText().isBlank()||getwriter.getText().isBlank()||getPublisher.getText().isBlank()){
			
			JOptionPane.showMessageDialog(frmIssueBook, "Student - Book details mismatch","Warning",JOptionPane.WARNING_MESSAGE);
			return;
		}else {
			//check if book is issued
			if(CheckInfo()) {
			//issue a book
			pst = conn.connect.prepareStatement("insert into issuebook values(?,?,?,?,?,?,?,?,?)");
			pst.setString(1, iss.getDate());
			pst.setString(2, iss.getB_name());
			pst.setString(3, iss.getBk_isbn());
			pst.setString(4, iss.getB_witer());
			pst.setString(5, iss.getB_publisher());
			pst.setString(6, iss.getSt_name());
			pst.setString(7, iss.getSt_adm());
			pst.setString(8, iss.getSt_mobile());
			pst.setString(9, iss.getSt_year());
			pst.execute();
			JOptionPane.showInternalMessageDialog(null, "Book Issued!");
			showdate.setText(LocalDate.now().toString());
		}
		}
	}
	
	private boolean CheckInfo() throws SQLException {
		pst = conn.connect.prepareStatement("select * from issuebook where ISBN=? and adm=?");
		pst.setString(1, iss.getBk_isbn());
		pst.setString(2, iss.getSt_adm());
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			JOptionPane.showMessageDialog(frmIssueBook, "Book already issued","Warning",JOptionPane.WARNING_MESSAGE);
			showdate.setText(rs.getString(1));
			return false;
		}else {
			return true;
		}
	}
}
