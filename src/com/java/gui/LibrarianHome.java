package com.java.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;

public class LibrarianHome implements ActionListener{

	public JFrame frmLibrarianHome;
	private JButton btnManage,btnStudent,btnBooks,btnIssue,btnReturn,btnStats;

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
		frmLibrarianHome.setResizable(false);
		frmLibrarianHome.getContentPane().setBackground(Color.ORANGE);
		frmLibrarianHome.setTitle("LIBRARIAN HOME");
		frmLibrarianHome.setBounds(100, 100, 775, 430);
		frmLibrarianHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLibrarianHome.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(12, 12, 212, 384);
		frmLibrarianHome.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		btnStudent = new JButton("MANAGE STUDENTS");
		btnStudent.setForeground(Color.WHITE);
		btnStudent.setBackground(new Color(75, 0, 130));
		btnStudent.setBounds(12, 23, 188, 37);
		btnStudent.addActionListener(this);
		panel.add(btnStudent);
		
		btnBooks = new JButton("MANAGE BOOKS");
		btnBooks.setForeground(Color.WHITE);
		btnBooks.setBackground(new Color(75, 0, 130));
		btnBooks.setBounds(12, 99, 188, 37);
		btnBooks.addActionListener(this);
		panel.add(btnBooks);
		
		btnIssue = new JButton("ISSUE BOOK");
		btnIssue.setForeground(Color.WHITE);
		btnIssue.setBackground(new Color(75, 0, 130));
		btnIssue.setBounds(12, 173, 188, 37);
		btnIssue.addActionListener(this);
		panel.add(btnIssue);
		
		btnReturn = new JButton("RETURN BOOK");
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setBackground(new Color(75, 0, 130));
		btnReturn.setBounds(12, 251, 188, 37);
		btnReturn.addActionListener(this);
		panel.add(btnReturn);
		
		btnStats = new JButton("STATISTICS");
		btnStats.setForeground(Color.WHITE);
		btnStats.setBackground(new Color(75, 0, 130));
		btnStats.setBounds(12, 322, 188, 37);
		btnStats.addActionListener(this);
		panel.add(btnStats);
		
		JButton logout = new JButton("LOGOUT");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//manage logout
				try {
					new Thread().sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frmLibrarianHome.dispose();
				new Login().frmLoginModule.setVisible(true);
			}
		});
		logout.setForeground(Color.WHITE);
		logout.setBackground(Color.RED);
		logout.setBounds(575, 359, 188, 37);
		frmLibrarianHome.getContentPane().add(logout);
	}

	@Override
	public void actionPerformed(ActionEvent v) {
		// TODO Auto-generated method stub
		
		Object obj = v.getSource();
		if(obj.equals(btnBooks)) {
			try {
				new ManageBooks().frmManageBooks.setVisible(true);;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(obj.equals(btnIssue)) {
			new IssueBook().frmIssueBook.setVisible(true);;
		}
		
		else if(obj.equals(btnReturn)) {
			new ReturnBook().frame.setVisible(true);;
		}
		
		else if(obj.equals(btnStats)) {
			try {
				new Stats().frmStatistics.setVisible(true);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		else if(obj.equals(btnStudent)) {
			try {
				new Students().frame.setVisible(true);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
	}
}
