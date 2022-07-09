package com.java.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.java.connection.Connection;
import com.java.models.Admin;
import com.java.models.Librarian;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JProgressBar;

public class Login implements ActionListener {

	public JFrame frmLoginModule;
	private JPasswordField getpass;
   public JTextField getuser;
	private JButton btnlogin ;
	private JComboBox combo ;
	int num;


	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginModule = new JFrame();
		frmLoginModule.setResizable(false);
		frmLoginModule.getContentPane().setBackground(Color.CYAN);
		frmLoginModule.setTitle("Login Module");
		frmLoginModule.setBounds(100, 100, 794, 361);
		frmLoginModule.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLoginModule.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 384, 303);
		frmLoginModule.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Select a Role and Login");
		lblNewLabel.setBounds(414, 12, 227, 15);
		frmLoginModule.getContentPane().add(lblNewLabel);
		
		combo = new JComboBox();
		combo.setFont(new Font("FreeSans", Font.BOLD, 15));
		combo.setModel(new DefaultComboBoxModel(new String[] {"", "ADMINISTRATOR", "LIBRARIAN"}));
		combo.setBackground(Color.RED);
		combo.setForeground(Color.ORANGE);
		combo.setBounds(408, 39, 309, 32);
		frmLoginModule.getContentPane().add(combo);
		
		JLabel lblNewLabel_1 = new JLabel("Username: ");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(451, 143, 98, 15);
		frmLoginModule.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setBounds(451, 203, 87, 15);
		frmLoginModule.getContentPane().add(lblNewLabel_1_1);
		
		getpass = new JPasswordField();
		getpass.setEchoChar('*');
		getpass.setForeground(Color.BLACK);
		getpass.setFont(new Font("Dialog", Font.BOLD, 13));
		getpass.setBackground(Color.GRAY);
		getpass.setBounds(556, 188, 212, 40);
		frmLoginModule.getContentPane().add(getpass);
		
		getuser = new JTextField();
		getuser.setFont(new Font("Dialog", Font.BOLD, 13));
		getuser.setForeground(Color.BLACK);
		getuser.setBackground(Color.GRAY);
		getuser.setBounds(556, 128, 212, 40);
		frmLoginModule.getContentPane().add(getuser);
		getuser.setColumns(10);
		
		btnlogin = new JButton("LOGIN");
		btnlogin.setBackground(Color.GREEN);
		btnlogin.setForeground(Color.WHITE);
		btnlogin.setBounds(665, 283, 117, 32);
		btnlogin.setFocusable(false);
		btnlogin.addActionListener(this);
		frmLoginModule.getContentPane().add(btnlogin);
		
		JLabel lblNewLabel_2 = new JLabel("View Password?");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				getpass.setEchoChar((char) 0);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				getpass.setEchoChar(('*'));
			}
		});
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(650, 256, 132, 15);
		frmLoginModule.getContentPane().add(lblNewLabel_2);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(btnlogin)) {
			try {
				try {
					Verify();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//verify all fields
	private void Verify() throws SQLException, InterruptedException{
		Connection conn = null;
		try {
			conn = new Connection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(frmLoginModule, e.getMessage());
		}
		PreparedStatement pst;
		if(combo.getSelectedIndex()==0||getuser.getText().isBlank()||getpass.getText().isBlank()) {
			JOptionPane.showMessageDialog(frmLoginModule, "Please Fill in all fields","Error",JOptionPane.ERROR_MESSAGE);
			
		}
		
		//login
		else {
			
			//login as administrator
			 if(combo.getSelectedIndex()==1) {
				 
				//instantiate our model class
				Admin admin = new Admin();
				admin.setUsername(getuser.getText());
				admin.setPassword(getpass.getText());
					
			    pst = conn.connect.prepareStatement("select * from admins where username = ? and password = ?");
				pst.setString(1,admin.getUsername() );
				pst.setString(2, admin.getPassword());
				
				if(pst.executeQuery().next()) {
					JOptionPane.showMessageDialog(frmLoginModule, "Login Success!!");
					new Thread().sleep(3000);
					frmLoginModule.dispose();
					new AdminHome().frmAdminHomepage.setVisible(true);
					
				}else {JOptionPane.showMessageDialog(frmLoginModule, "Login Failed","Error",JOptionPane.ERROR_MESSAGE);}
				
				
			}
			
			 
			//login as librarian
			else if(combo.getSelectedIndex()==2) {
				Librarian librarian = new Librarian();
				librarian.setUsername(getuser.getText());
				librarian.setPassword(getpass.getText());
				pst = conn.connect.prepareStatement("select * from librarians where username = ? and password = ?");
				pst.setString(1,librarian.getUsername() );
				pst.setString(2, librarian.getPassword());
				
				if(pst.executeQuery().next()) {
					JOptionPane.showMessageDialog(frmLoginModule, "Login Success!!");
					frmLoginModule.dispose();
					
				}else {JOptionPane.showMessageDialog(frmLoginModule, "Login Failed","Error",JOptionPane.ERROR_MESSAGE);}
				
			}
		}
		
	}
}
