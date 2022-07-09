package com.java.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.java.connection.Connection;
import com.java.models.Library;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.Window.Type;

public class Libraries implements ActionListener{

	private JFrame frmManageLibraries;
	private JTextField tfname;
	private JTextField tflocation;
	private JTextField tfadmin;
	private JTextField tfseats;
	private JButton btnReg,btnUpdate,btnDelete;
	private JTable table;
	Connection conn;
	PreparedStatement pst;
	private JLabel lblLibid;
	private JTextField getid;

	
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Libraries() throws SQLException, ClassNotFoundException {
		initialize();
		LoadTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManageLibraries = new JFrame();
		frmManageLibraries.setType(Type.UTILITY);
		frmManageLibraries.setResizable(false);
		frmManageLibraries.getContentPane().setBackground(new Color(128, 128, 0));
		frmManageLibraries.setTitle("Manage Libraries");
		frmManageLibraries.setBounds(100, 100, 779, 441);
		frmManageLibraries.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmManageLibraries.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "ADD A LIBRARY", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(12, 12, 755, 197);
		frmManageLibraries.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(42, 49, 77, 15);
		panel.add(lblNewLabel);
		
		JLabel lblAdmin = new JLabel("ADMIN:");
		lblAdmin.setForeground(Color.BLACK);
		lblAdmin.setBounds(49, 103, 70, 15);
		panel.add(lblAdmin);
		
		JLabel lblSeats = new JLabel("SEATS");
		lblSeats.setForeground(Color.BLACK);
		lblSeats.setBounds(436, 85, 70, 15);
		panel.add(lblSeats);
		
		tfname = new JTextField();
		tfname.setForeground(new Color(0, 0, 0));
		tfname.setBounds(118, 40, 239, 33);
		panel.add(tfname);
		tfname.setColumns(10);
		
		tflocation = new JTextField();
		tflocation.setForeground(new Color(0, 0, 0));
		tflocation.setColumns(10);
		tflocation.setBounds(504, 24, 239, 33);
		panel.add(tflocation);
		
		tfadmin = new JTextField();
		tfadmin.setForeground(new Color(0, 0, 0));
		tfadmin.setColumns(10);
		tfadmin.setBounds(118, 85, 239, 33);
		panel.add(tfadmin);
		
		tfseats = new JTextField();
		tfseats.setForeground(new Color(0, 0, 0));
		tfseats.setColumns(10);
		tfseats.setBounds(514, 76, 239, 33);
		panel.add(tfseats);
		
		JLabel lblLocation_1 = new JLabel("LOCATION:");
		lblLocation_1.setForeground(Color.BLACK);
		lblLocation_1.setBounds(401, 40, 85, 15);
		panel.add(lblLocation_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 255, 47));
		panel_1.setBounds(42, 132, 701, 53);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnReg = new JButton("Register New");
		btnReg.setForeground(new Color(255, 255, 255));
		btnReg.setBackground(new Color(25, 25, 112));
		btnReg.setBounds(43, 16, 150, 25);
		btnReg.addActionListener(this);
		panel_1.add(btnReg);
		
		btnUpdate = new JButton("Update Existing");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(25, 25, 112));
		btnUpdate.setBounds(283, 16, 150, 25);
		btnUpdate.addActionListener(this);
		panel_1.add(btnUpdate);
		
		btnDelete = new JButton("Delete Record");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setBounds(501, 16, 150, 25);
		btnDelete.addActionListener(this);
		panel_1.add(btnDelete);
		
		lblLibid = new JLabel("LIBID:");
		lblLibid.setForeground(Color.BLACK);
		lblLibid.setBounds(47, 24, 53, 15);
		panel.add(lblLibid);
		
		getid = new JTextField();
		getid.setForeground(Color.BLACK);
		getid.setColumns(10);
		getid.setBounds(118, 10, 172, 25);
		panel.add(getid);
		
		table = new JTable();
		table.setFont(new Font("Dialog", Font.BOLD, 12));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				getid.setText(table.getValueAt(row, 0)+"");
				tfname.setText((String)table.getValueAt(row, 1));
				tflocation.setText((String)table.getValueAt(row, 2));
				tfadmin.setText((String)table.getValueAt(row, 3));
				tfseats.setText(table.getValueAt(row, 4)+"");
			}
		});
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(148, 0, 211));
		table.setBounds(12, 242, 755, 165);
		frmManageLibraries.getContentPane().add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Library Id");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setBounds(32, 221, 97, 15);
		frmManageLibraries.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("LibraryName");
		lblNewLabel_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1.setBounds(184, 221, 97, 15);
		frmManageLibraries.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Library Location");
		lblNewLabel_1_2.setForeground(Color.CYAN);
		lblNewLabel_1_2.setBounds(310, 221, 123, 15);
		frmManageLibraries.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Library Admin");
		lblNewLabel_1_3.setForeground(Color.CYAN);
		lblNewLabel_1_3.setBounds(471, 221, 123, 15);
		frmManageLibraries.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Library Seats");
		lblNewLabel_1_4.setForeground(Color.CYAN);
		lblNewLabel_1_4.setBounds(615, 221, 97, 15);
		frmManageLibraries.getContentPane().add(lblNewLabel_1_4);
		frmManageLibraries.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		//instance of the model class
		Library lib = new Library(Integer.parseInt(getid.getText()),tfname.getText(),tflocation.getText(),tfadmin.getText(),Integer.parseInt(tfseats.getText()));
		
		try {
			 conn = new Connection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Object btn = ev.getSource();
		
		/**
		 * Add a Library
		 */
		if(btn.equals(btnReg)) {
			Validate();
			try {
				pst = conn.connect.prepareStatement("insert into newlib values(?,?,?,?,?)");
				pst.setInt(1, lib.getid());
				pst.setString(2, lib.getLibname());
				pst.setString(3, lib.getLocation());
				pst.setString(4, lib.getAdmin());
				pst.setInt(5, lib.getSeats());
				pst.execute();
				JOptionPane.showMessageDialog(frmManageLibraries, "Library Registered!!");
				Clear();
				LoadTable();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * Update a Library
		 */
		else if(btn.equals(btnUpdate)) {
			try {
				pst = conn.connect.prepareStatement("update newlib set name=?, location=?,admin=?, seats=? where libid = ?");
				pst.setString(1, lib.getLibname());
				pst.setString(2, lib.getLocation());
				pst.setString(3, lib.getAdmin());
				pst.setInt(4, lib.getSeats());
				pst.setInt(5, lib.getid());
				pst.execute();
				JOptionPane.showMessageDialog(frmManageLibraries, "Library Updated!");
				Clear();
				LoadTable();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * delete a Library
		 */
		else if(btn.equals(btnDelete)) {
			try {
				pst = conn.connect.prepareStatement("delete from newlib where libid = ?");
				pst.setInt(1, lib.getid());
				int confirm = JOptionPane.showConfirmDialog(frmManageLibraries, "Delete Record??");
				if(confirm == JOptionPane.OK_OPTION) {
					pst.execute();
					Clear();
					LoadTable();
				}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
	
	
	private void Clear() {
		getid.setText("");
		tfname.setText("");
		tflocation.setText("");
		tfadmin.setText("");
		tfseats.setText("");
		
	}
	
	
	private void LoadTable() throws SQLException, ClassNotFoundException {
		conn = new Connection();
		pst = conn.connect.prepareStatement("select * from newlib");
		table.setModel(DbUtils.resultSetToTableModel(pst.executeQuery()));
	}
	
	private void Validate() {
		if(getid.getText().isBlank()||tfname.getText().isBlank()||tflocation.getText().isBlank()||
				tfadmin.getText().isBlank()||tfseats.getText().isBlank()) {
			
			JOptionPane.showMessageDialog(frmManageLibraries, "fill in all fields","Warning",JOptionPane.WARNING_MESSAGE);
		return;
		}
	}
}
