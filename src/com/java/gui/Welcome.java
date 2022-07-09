package com.java.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JSeparator;
import javax.swing.JProgressBar;

public class Welcome {

	private static JFrame frmWelcomePage;
	private static JProgressBar progressBar ;
    static int num;
	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		new Welcome();
		LoadProgress();
		
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcomePage = new JFrame();
		frmWelcomePage.setResizable(false);
		frmWelcomePage.getContentPane().setBackground(Color.YELLOW);
		frmWelcomePage.setBackground(Color.WHITE);
		frmWelcomePage.setTitle("Welcome Page");
		frmWelcomePage.setBounds(100, 100, 726, 386);
		frmWelcomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomePage.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Francode Library Management System <>");
		lblNewLabel.setFont(new Font("MathJax_Typewriter", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(24, 22, 688, 27);
		frmWelcomePage.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 350, 188, 2);
		frmWelcomePage.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("@francode softwares");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(45, 323, 188, 15);
		frmWelcomePage.getContentPane().add(lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(35, 315, 188, 7);
		frmWelcomePage.getContentPane().add(separator_1);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(Color.CYAN);
		progressBar.setStringPainted(true);
		progressBar.setBounds(24, 284, 688, 27);
		frmWelcomePage.getContentPane().add(progressBar);
		
		JLabel lblNewLabel_2 = new JLabel("Loading Please Wait...");
		lblNewLabel_2.setBounds(249, 263, 255, 15);
		frmWelcomePage.getContentPane().add(lblNewLabel_2);
		frmWelcomePage.setVisible(true);
	}
	
	private static void LoadProgress() throws InterruptedException {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				num+=10;
				progressBar.setValue(num);
			}
			
		}, 0,300);
		new Thread().sleep(4000);
		frmWelcomePage.dispose();
		Login lgn = new Login();
		lgn.frmLoginModule.setVisible(true);
	}
		
}
