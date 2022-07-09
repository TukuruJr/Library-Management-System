package com.java.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class AdminHome extends Login implements ActionListener {

	public JFrame frmAdminHomepage;
    private JButton btnAdmin,btnLibrarian,btnstats,btnlogout,btnlibrary;
	

	/**
	 * Create the application.
	 */
	public AdminHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminHomepage = new JFrame();
		frmAdminHomepage.setResizable(false);
		frmAdminHomepage.getContentPane().setBackground(new Color(255, 140, 0));
		frmAdminHomepage.setTitle("Admin HomePage");
		frmAdminHomepage.setBounds(100, 100, 840, 459);
		frmAdminHomepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminHomepage.getContentPane().setLayout(null);
		
		JLabel name = new JLabel(getuser.getText());
		name.setForeground(new Color(0, 0, 0));
		name.setBounds(29, 12, 109, 15);
		frmAdminHomepage.getContentPane().add(name);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setForeground(new Color(0, 0, 0));
		lblAdmin.setBounds(579, 12, 84, 15);
		frmAdminHomepage.getContentPane().add(lblAdmin);
		
		JPanel panel = new JPanel();
		panel.setBounds(183, 33, 645, 392);
		frmAdminHomepage.getContentPane().add(panel);
		
		btnAdmin = new JButton("Manage Admin");
		btnAdmin.setForeground(new Color(255, 255, 255));
		btnAdmin.setBackground(new Color(47, 79, 79));
		btnAdmin.setBounds(12, 66, 159, 33);
		btnAdmin.setFocusable(false);
		btnAdmin.addActionListener(this);
		frmAdminHomepage.getContentPane().add(btnAdmin);
		
		btnLibrarian = new JButton("Manage Librarian");
		btnLibrarian.setForeground(Color.WHITE);
		btnLibrarian.setBackground(new Color(47, 79, 79));
		btnLibrarian.setBounds(12, 149, 159, 33);
		btnLibrarian.setFocusable(false);
		btnLibrarian.addActionListener(this);
		frmAdminHomepage.getContentPane().add(btnLibrarian);
		
		btnlibrary = new JButton("Manage Libraries");
		btnlibrary.setForeground(Color.WHITE);
		btnlibrary.setBackground(new Color(47, 79, 79));
		btnlibrary.setBounds(12, 233, 159, 33);
		btnlibrary.setFocusable(false);
		btnlibrary.addActionListener(this);
		frmAdminHomepage.getContentPane().add(btnlibrary);
		
		btnstats = new JButton("Statistics");
		btnstats.setForeground(Color.WHITE);
		btnstats.setBackground(new Color(47, 79, 79));
		btnstats.setBounds(12, 306, 159, 33);
		btnstats.setFocusable(false);
		btnstats.addActionListener(this);
		frmAdminHomepage.getContentPane().add(btnstats);
		
		btnlogout = new JButton("Logout");
		btnlogout.setForeground(Color.WHITE);
		btnlogout.setBackground(new Color(47, 79, 79));
		btnlogout.setBounds(12, 375, 159, 33);
		btnlogout.setFocusable(false);
		btnlogout.addActionListener(this);
		frmAdminHomepage.getContentPane().add(btnlogout);
	}

	@Override
	public void actionPerformed(ActionEvent ob) {
		// TODO Auto-generated method stub
		Object btn = ob.getSource();
		
		if(btn.equals(btnAdmin)) {
			//Manage admin
			try {
		       new ManageAdmin().frmManageAdmin.setVisible(true);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * MANAGE A LIBRARIAN
		 */
		
		else if(btn.equals(btnLibrarian)) {
			//manage Librarian
			try {
				new ManageLibrarian();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(btn.equals(btnlibrary)) {
			//manage Library
			try {
				new Libraries();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(btn.equals(btnstats)) {
			//view statistics
		}
		
		else if(btn.equals(btnlogout)) {
			//manage logout
			try {
				new Thread().sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frmAdminHomepage.dispose();
			new Login().frmLoginModule.setVisible(true);
			
		}
	}
}
