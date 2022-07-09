package com.java.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;

public class LibrarianHome implements ActionListener{

	private JFrame frmLibrarianHome;
	private JButton btnManage,btnStudent,btnBooks,btnIssue,btnReturn,btnStats,btnLogout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianHome window = new LibrarianHome();
					window.frmLibrarianHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LibrarianHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLibrarianHome = new JFrame();
		frmLibrarianHome.getContentPane().setBackground(Color.ORANGE);
		frmLibrarianHome.setTitle("LIBRARIAN HOME");
		frmLibrarianHome.setBounds(100, 100, 775, 484);
		frmLibrarianHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLibrarianHome.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(12, 12, 212, 438);
		frmLibrarianHome.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnManage = new JButton("Manage Account");
		btnManage.setForeground(new Color(255, 255, 255));
		btnManage.setBackground(new Color(75, 0, 130));
		btnManage.setBounds(12, 27, 188, 37);
		panel.add(btnManage);
		
		btnStudent = new JButton("MANAGE STUDENTS");
		btnStudent.setForeground(Color.WHITE);
		btnStudent.setBackground(new Color(75, 0, 130));
		btnStudent.setBounds(12, 90, 188, 37);
		panel.add(btnStudent);
		
		btnBooks = new JButton("MANAGE BOOKS");
		btnBooks.setForeground(Color.WHITE);
		btnBooks.setBackground(new Color(75, 0, 130));
		btnBooks.setBounds(12, 148, 188, 37);
		panel.add(btnBooks);
		
		btnIssue = new JButton("ISSUE BOOK");
		btnIssue.setForeground(Color.WHITE);
		btnIssue.setBackground(new Color(75, 0, 130));
		btnIssue.setBounds(12, 211, 188, 37);
		panel.add(btnIssue);
		
		btnReturn = new JButton("RETURN BOOK");
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setBackground(new Color(75, 0, 130));
		btnReturn.setBounds(12, 274, 188, 37);
		panel.add(btnReturn);
		
		btnStats = new JButton("STATISTICS");
		btnStats.setForeground(Color.WHITE);
		btnStats.setBackground(new Color(75, 0, 130));
		btnStats.setBounds(12, 334, 188, 37);
		panel.add(btnStats);
		
		btnLogout = new JButton("LOGOUT");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBackground(new Color(75, 0, 130));
		btnLogout.setBounds(12, 389, 188, 37);
		panel.add(btnLogout);
	}

	@Override
	public void actionPerformed(ActionEvent v) {
		// TODO Auto-generated method stub
		
		Object obj = v.getSource();
		if(obj.equals(btnBooks)) {
			
		}
	}
}
