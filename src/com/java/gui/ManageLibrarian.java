package com.java.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.java.connection.Connection;
import com.java.models.Admin;
import com.java.models.Librarian;

import net.proteanit.sql.DbUtils;
import java.awt.Window.Type;

public class ManageLibrarian  implements ActionListener{

	private JFrame frmManageLibrarian;
	private JTextField getid;
	private JTextField getuser;
	private JTextField getfname;
	private JTextField getmobile;
	private JTextField getemail;
	private JTextField getpass;
	private JTextField getlocation;
	private JTextField getqualification;
	private JTextField getdate;
	private JTable table;
	private JButton btnSave, btnUpdate,btnDelete;
	private PreparedStatement pst;
	Connection conn;
	private JLabel lblIdno;
	private JLabel lblUsername_1;
	private JLabel lblFullname_1;
	private JLabel lblMobile_1;
	private JLabel lblEmail_1;
	private JLabel lblPassword_1;
	private JLabel lblLocation_1;
	private JLabel lblQuantity;
	private JLabel lblDateEmployed;
	private JLabel error;


	public ManageLibrarian() throws ClassNotFoundException, SQLException {
		initialize();
		Load();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		frmManageLibrarian = new JFrame();
		frmManageLibrarian.setType(Type.UTILITY);
		frmManageLibrarian.setResizable(false);
		frmManageLibrarian.getContentPane().setBackground(new Color(0, 0, 139));
		frmManageLibrarian.setTitle("Manage Librarian");
		frmManageLibrarian.setBounds(100, 100, 862, 492);
		frmManageLibrarian.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmManageLibrarian.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 69, 0));
		panel.setBounds(12, 12, 838, 246);
		frmManageLibrarian.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID NO:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(250, 128, 114));
		lblNewLabel.setBounds(60, 19, 61, 15);
		panel.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBackground(new Color(250, 128, 114));
		lblUsername.setBounds(35, 53, 86, 15);
		panel.add(lblUsername);
		
		JLabel lblFullname = new JLabel("FULLNAME");
		lblFullname.setForeground(Color.BLACK);
		lblFullname.setBackground(new Color(250, 128, 114));
		lblFullname.setBounds(35, 92, 86, 15);
		panel.add(lblFullname);
		
		getid = new JTextField();
		getid.setBounds(123, 12, 190, 29);
		panel.add(getid);
		getid.setColumns(10);
		
		getuser = new JTextField();
		getuser.setColumns(10);
		getuser.setBounds(123, 49, 190, 29);
		panel.add(getuser);
		
		getfname = new JTextField();
		getfname.setColumns(10);
		getfname.setBounds(123, 85, 190, 29);
		panel.add(getfname);
		
		JLabel lblMobile = new JLabel("MOBILE");
		lblMobile.setForeground(Color.BLACK);
		lblMobile.setBackground(new Color(250, 128, 114));
		lblMobile.setBounds(35, 134, 86, 15);
		panel.add(lblMobile);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setBackground(new Color(250, 128, 114));
		lblEmail.setBounds(44, 170, 68, 15);
		panel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBackground(new Color(250, 128, 114));
		lblPassword.setBounds(35, 210, 86, 15);
		panel.add(lblPassword);
		
		getmobile = new JTextField();
		getmobile.setColumns(10);
		getmobile.setBounds(123, 126, 190, 29);
		panel.add(getmobile);
		
		getemail = new JTextField();
		getemail.setColumns(10);
		getemail.setBounds(123, 168, 190, 29);
		panel.add(getemail);
		
		getpass = new JTextField();
		getpass.setColumns(10);
		getpass.setBounds(123, 208, 190, 29);
		panel.add(getpass);
		
		JLabel lblLocation = new JLabel("LOCATION");
		lblLocation.setForeground(Color.BLACK);
		lblLocation.setBackground(new Color(250, 128, 114));
		lblLocation.setBounds(435, 26, 91, 15);
		panel.add(lblLocation);
		
		JLabel lblQualification = new JLabel("QUALIFICATION");
		lblQualification.setForeground(Color.BLACK);
		lblQualification.setBackground(new Color(250, 128, 114));
		lblQualification.setBounds(416, 69, 120, 15);
		panel.add(lblQualification);
		
		JLabel lblDate = new JLabel("DATE  OF EMPLOYMENT");
		lblDate.setForeground(Color.BLACK);
		lblDate.setBackground(new Color(250, 128, 114));
		lblDate.setBounds(364, 126, 183, 15);
		panel.add(lblDate);
		
		getlocation = new JTextField();
		getlocation.setColumns(10);
		getlocation.setBounds(544, 19, 190, 29);
		panel.add(getlocation);
		
		getqualification = new JTextField();
		getqualification.setColumns(10);
		getqualification.setBounds(554, 62, 190, 29);
		panel.add(getqualification);
		
		getdate = new JTextField();
		getdate.setEditable(false);
		getdate.setColumns(10);
		getdate.setBounds(554, 119, 190, 29);
		getdate.setText(LocalDate.now().toString());
		panel.add(getdate);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "OPERATIONS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 140, 0)));
		panel_1.setBackground(new Color(85, 107, 47));
		panel_1.setBounds(343, 170, 462, 64);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnSave = new JButton("SAVE");
		btnSave.setForeground(new Color(255, 255, 0));
		btnSave.setBackground(new Color(0, 128, 128));
		btnSave.setBounds(22, 27, 96, 25);
		btnSave.addActionListener(this);
		panel_1.add(btnSave);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(255, 255, 0));
		btnUpdate.setBackground(new Color(0, 128, 128));
		btnUpdate.setBounds(189, 27, 96, 25);
		btnUpdate.addActionListener(this);
		panel_1.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setBounds(331, 27, 96, 25);
		btnDelete.addActionListener(this);
		panel_1.add(btnDelete);
		
		error = new JLabel("");
		error.setForeground(new Color(127, 255, 0));
		error.setFont(new Font("Dialog", Font.BOLD, 9));
		error.setBounds(123, 197, 202, 15);
		panel.add(error);
		
		table = new JTable();
		table.setFont(new Font("Dialog", Font.BOLD, 12));
		//populate fields on table mouseclick
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				getid.setText(table.getValueAt(row, 0)+"");
				getuser.setText((String)table.getValueAt(row, 1));
				getfname.setText((String)table.getValueAt(row, 2));
				getmobile.setText((String)table.getValueAt(row, 3));
				getemail.setText((String)table.getValueAt(row, 4));
				getpass.setText((String)table.getValueAt(row, 5));
				getlocation.setText((String)table.getValueAt(row, 6));
				getqualification.setText((String)table.getValueAt(row, 7));
				getdate.setText((String)table.getValueAt(row, 8));
				getdate.setEditable(true);
				
			}
		});
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(47, 79, 79));
		table.setBounds(22, 285, 828, 173);
		frmManageLibrarian.getContentPane().add(table);
		
		lblIdno = new JLabel("IDNO:");
		lblIdno.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblIdno.setForeground(Color.CYAN);
		lblIdno.setBounds(22, 270, 70, 15);
		frmManageLibrarian.getContentPane().add(lblIdno);
		
		lblUsername_1 = new JLabel("UserName");
		lblUsername_1.setForeground(Color.CYAN);
		lblUsername_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblUsername_1.setBounds(104, 270, 94, 15);
		frmManageLibrarian.getContentPane().add(lblUsername_1);
		
		lblFullname_1 = new JLabel("FullName");
		lblFullname_1.setForeground(Color.CYAN);
		lblFullname_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblFullname_1.setBounds(203, 270, 77, 15);
		frmManageLibrarian.getContentPane().add(lblFullname_1);
		
		lblMobile_1 = new JLabel("Mobile");
		lblMobile_1.setForeground(Color.CYAN);
		lblMobile_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblMobile_1.setBounds(292, 270, 70, 15);
		frmManageLibrarian.getContentPane().add(lblMobile_1);
		
		lblEmail_1 = new JLabel("Email");
		lblEmail_1.setForeground(Color.CYAN);
		lblEmail_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblEmail_1.setBounds(385, 270, 70, 15);
		frmManageLibrarian.getContentPane().add(lblEmail_1);
		
		lblPassword_1 = new JLabel("Password");
		lblPassword_1.setForeground(Color.CYAN);
		lblPassword_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblPassword_1.setBounds(467, 270, 70, 15);
		frmManageLibrarian.getContentPane().add(lblPassword_1);
		
		lblLocation_1 = new JLabel("Location");
		lblLocation_1.setForeground(Color.CYAN);
		lblLocation_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblLocation_1.setBounds(555, 270, 70, 15);
		frmManageLibrarian.getContentPane().add(lblLocation_1);
		
		lblQuantity = new JLabel("Qualification");
		lblQuantity.setForeground(Color.CYAN);
		lblQuantity.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblQuantity.setBounds(646, 270, 98, 15);
		frmManageLibrarian.getContentPane().add(lblQuantity);
		
		lblDateEmployed = new JLabel("Date Employed");
		lblDateEmployed.setForeground(Color.CYAN);
		lblDateEmployed.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblDateEmployed.setBounds(742, 270, 108, 15);
		frmManageLibrarian.getContentPane().add(lblDateEmployed);
		frmManageLibrarian.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ob) {

		//instantiate Admin model class
		Librarian lib = new Librarian(Integer.parseInt(getid.getText()),getuser.getText(),getfname.getText(),getmobile.getText(),getemail.getText()
				,getpass.getText(),getlocation.getText(),getqualification.getText(),LocalDate.now().toString());
		
        try {
			conn = new Connection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object btn = ob.getSource();
		if(btn.equals(btnSave)) {
			// handle registration
			Validate();
			try {
			
				pst = conn.connect.prepareStatement("insert into librarians values(?,?,?,?,?,?,?,?,?)");
				pst.setInt(1, lib.getIdno());
				pst.setString(2,lib.getUsername());
				pst.setString(3, lib.getFullname());
				pst.setString(4,lib.getMobile());
				pst.setString(5, lib.getEmail());
				pst.setString(6,lib.getPassword());
				pst.setString(7, lib.getLocation());
				pst.setString(8, lib.getQualification());
				pst.setString(9, lib.getDate());
				
				int success = pst.executeUpdate();
				if(success>0) {
					JOptionPane.showMessageDialog(frmManageLibrarian, "Librarian Created!!");
					Load();
					Clear();
				}
			
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
		/**
		 * handle update functionality
		 */
		else if(btn.equals(btnUpdate)) {
			Validate();
			try {
				pst = conn.connect.prepareStatement("update librarians set username=?,fullname=?,mobile=?,email=?,password=?,location=?,qualification=?,date_employed=? where idno=?");
				pst.setString(1, lib.getUsername());
				pst.setString(2, lib.getFullname());
				pst.setString(3, lib.getMobile());
				pst.setString(4, lib.getEmail());
				pst.setString(5, lib.getPassword());
				pst.setString(6, lib.getLocation());
				pst.setString(7, lib.getQualification());
				pst.setString(8, getdate.getText());
				pst.setInt(9, lib.getIdno());
				
				int success = pst.executeUpdate();
				if(success>0) {
					JOptionPane.showMessageDialog(frmManageLibrarian, "Librarian  Record Updated!!");
					Load();
					Clear();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * handle delete functionality
		 */
		else if(btn.equals(btnDelete)) {
			try {
				pst = conn.connect.prepareStatement("DELETE FROM librarians WHERE idno = ?");
				pst.setInt(1, lib.getIdno());
				int ok =  JOptionPane.showConfirmDialog(frmManageLibrarian, "Delete this User?");
				if(ok ==JOptionPane.OK_OPTION) {
					pst.execute();
					Load();
					Clear();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void Load() throws ClassNotFoundException, SQLException {
		conn = new Connection();
		pst = conn.connect.prepareStatement("SELECT * FROM librarians");
		table.setModel(DbUtils.resultSetToTableModel(pst.executeQuery()));
	}
	
	private void Clear() {
		getid.setText("");
		getuser.setText("");
		getfname.setText("");
		getemail.setText("");
		getmobile.setText("");
		getdate.setText("");
		getqualification.setText("");
		getlocation.setText("");
		getpass.setText("");
	}
	
	private void Validate() {
		if(getid.getText().isBlank()||getuser.getText().isBlank()||getfname.getText().isBlank()||getemail.getText().isBlank()
				||getmobile.getText().isBlank()||getdate.getText().isBlank()||getqualification.getText().isBlank()||getlocation.getText().isBlank()
				||getpass.getText().isBlank()) {
			JOptionPane.showMessageDialog(frmManageLibrarian, "Fill in all fields","error",JOptionPane.WARNING_MESSAGE);
			if(!getpass.getText().contains("@")) {
				error.setText("Invalid Email!!");
			}
			return;
		}
	}
}

