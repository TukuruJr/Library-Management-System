package com.java.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.java.connection.Connection;
import com.java.models.issue;

public class ReturnBook  implements ActionListener{

	public JFrame frame;
	private JTextField getisbn;
	private JTextField getname;
	private JTextField getwriter;
	private JTextField getPublisher;
	private JTextField getadm;
	private JTextField getstudent;
	private JTextField getyear;
	private JTextField getmobile;
	private JButton btnReturn,btnSearch ;
	Connection conn; PreparedStatement pst; issue iss ;
 private JTextField showdate;
 private JTextField returndate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook window = new ReturnBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReturnBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setTitle("ISSUE BOOK");
		frame.setBounds(100, 100, 819, 459);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Return a Book");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(316, 12, 162, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 255));
		panel.setBounds(24, 45, 403, 311);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAdmissionNo = new JLabel("ADMISSION NO:");
		lblAdmissionNo.setForeground(Color.BLACK);
		lblAdmissionNo.setBounds(86, 24, 133, 15);
		panel.add(lblAdmissionNo);
		
		getadm = new JTextField();
		getadm.setColumns(10);
		getadm.setBounds(227, 12, 164, 32);
		panel.add(getadm);
		
		JLabel lblStudentName = new JLabel("STUDENT NAME:");
		lblStudentName.setForeground(Color.BLACK);
		lblStudentName.setBounds(12, 108, 120, 15);
		panel.add(lblStudentName);
		
		getstudent = new JTextField();
		getstudent.setEditable(false);
		getstudent.setColumns(10);
		getstudent.setBounds(138, 92, 253, 32);
		panel.add(getstudent);
		
		JLabel lblYear = new JLabel("YEAR");
		lblYear.setForeground(Color.BLACK);
		lblYear.setBounds(47, 177, 73, 15);
		panel.add(lblYear);
		
		getyear = new JTextField();
		getyear.setEditable(false);
		getyear.setColumns(10);
		getyear.setBounds(138, 169, 253, 32);
		panel.add(getyear);
		
		JLabel lblMobile = new JLabel("MOBILE");
		lblMobile.setForeground(Color.BLACK);
		lblMobile.setBounds(47, 243, 73, 15);
		panel.add(lblMobile);
		
		getmobile = new JTextField();
		getmobile.setEditable(false);
		getmobile.setColumns(10);
		getmobile.setBounds(138, 228, 253, 32);
		panel.add(getmobile);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 255));
		panel_1.setBounds(427, 39, 380, 311);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel bbb = new JLabel("ISBN");
		bbb.setForeground(Color.BLACK);
		bbb.setBounds(10, 31, 48, 15);
		panel_1.add(bbb);
		
		getisbn = new JTextField();
		getisbn.setBounds(56, 23, 181, 32);
		panel_1.add(getisbn);
		getisbn.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Book Name");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(10, 115, 79, 15);
		panel_1.add(lblNewLabel_2);
		
		getname = new JTextField();
		getname.setEditable(false);
		getname.setColumns(10);
		getname.setBounds(121, 107, 236, 32);
		panel_1.add(getname);
		
		JLabel nnn = new JLabel("Writer");
		nnn.setForeground(Color.BLACK);
		nnn.setBounds(26, 181, 76, 15);
		panel_1.add(nnn);
		
		getwriter = new JTextField();
		getwriter.setEditable(false);
		getwriter.setColumns(10);
		getwriter.setBounds(121, 173, 236, 32);
		panel_1.add(getwriter);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setForeground(Color.BLACK);
		lblPublisher.setBounds(26, 250, 78, 15);
		panel_1.add(lblPublisher);
		
		getPublisher = new JTextField();
		getPublisher.setEditable(false);
		getPublisher.setColumns(10);
		getPublisher.setBounds(121, 242, 236, 32);
		panel_1.add(getPublisher);
		
		btnSearch = new JButton("Search");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(Color.BLUE);
		btnSearch.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSearch.setBounds(251, 26, 117, 25);
		btnSearch.addActionListener(this);
		panel_1.add(btnSearch);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(184, 25, 403, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Search Student");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(70, 27, 173, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Search Book");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setBounds(589, 25, 173, 15);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		btnReturn = new JButton("RETURN BOOK");
		btnReturn.setForeground(Color.GREEN);
		btnReturn.setBackground(Color.DARK_GRAY);
		btnReturn.setBounds(346, 402, 222, 25);
		btnReturn.setFocusable(false);
		btnReturn.addActionListener(this);
		frame.getContentPane().add(btnReturn);
		
		JLabel lblNewLabel_3 = new JLabel("DATE ISSUED");
		lblNewLabel_3.setBounds(91, 372, 95, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		showdate = new JTextField();
		showdate.setFont(new Font("Dialog", Font.BOLD, 12));
		showdate.setBackground(Color.DARK_GRAY);
		showdate.setForeground(Color.WHITE);
		showdate.setEditable(false);
		showdate.setBounds(204, 368, 189, 24);
		frame.getContentPane().add(showdate);
		showdate.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("DATE RETURNED");
		lblNewLabel_3_1.setForeground(Color.RED);
		lblNewLabel_3_1.setBounds(438, 375, 131, 15);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		returndate = new JTextField();
		returndate.setForeground(Color.WHITE);
		returndate.setFont(new Font("Dialog", Font.BOLD, 12));
		returndate.setEditable(false);
		returndate.setColumns(10);
		returndate.setBackground(Color.DARK_GRAY);
		returndate.setBounds(589, 368, 208, 24);
		frame.getContentPane().add(returndate);
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
		if(ob.getSource().equals(btnReturn)) {
			
			//validate fields
			try {
				Return();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * search if a book is registered
		 */
		else if(ob.getSource().equals(btnSearch)) {
			try {
				pst = conn.connect.prepareStatement("select * from issuebook where ISBN =?");
				pst.setString(1, getisbn.getText());
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					showdate.setText(rs.getString(1));
					getwriter.setText(rs.getString(4));
					getPublisher.setText(rs.getString(5));
					getname.setText(rs.getString(2));
					getisbn.setText(rs.getString(3));
					getstudent.setText(rs.getString(6));
					getadm.setText(rs.getString(7));
					getmobile.setText(rs.getString(8));
					getyear.setText(rs.getString(9));
				}else {
					JOptionPane.showMessageDialog(frame, "Student - Book details mismatch","Warning",JOptionPane.WARNING_MESSAGE);
					return;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private void Return() throws SQLException {
		if(getstudent.getText().isBlank()||getadm.getText().isBlank()||getyear.getText().isBlank()||getmobile.getText().isBlank()||
		   getisbn.getText().isBlank()||getname.getText().isBlank()||getwriter.getText().isBlank()||getPublisher.getText().isBlank()){
			
			JOptionPane.showMessageDialog(frame, "Student - Book details mismatch","Warning",JOptionPane.WARNING_MESSAGE);
			return;
		}else {
			
			//return a book
			
			pst = conn.connect.prepareStatement("insert into returnbook values(?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, iss.getDate());
			pst.setString(2, iss.getB_name());
			pst.setString(3, iss.getBk_isbn());
			pst.setString(4, iss.getB_witer());
			pst.setString(5, iss.getB_publisher());
			pst.setString(6, iss.getSt_name());
			pst.setString(7, iss.getSt_adm());
			pst.setString(8, iss.getSt_mobile());
			pst.setString(9, iss.getSt_year());
			pst.setString(10, LocalDate.now().toString());
			pst.execute();
			
			CheckInfo();
				JOptionPane.showMessageDialog(frame, "Book Returned");
				returndate.setText(LocalDate.now().toString());
		}
	}
	
	private boolean CheckInfo() throws SQLException {
		pst = conn.connect.prepareStatement("delete from issuebook where ISBN=? and adm=?");
		pst.setString(1, iss.getBk_isbn());
		pst.setString(2, iss.getSt_adm());
			return pst.execute();
	}
}
