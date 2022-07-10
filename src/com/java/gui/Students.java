package com.java.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import com.java.connection.Connection;
import com.java.models.Student;

import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class Students implements ActionListener {

	public JFrame frame;
	private JTextField getadm;
	private JTextField getname;
	private JTextField getmobile;
	private JTextField getemil;
	private JTextField getethnicity;
	private JTextField getlocation;
	private JTable table;
	private JTextField search;
	private JTextField getcourse;
	private JButton btnAdd,btnUpdate,btnDelete; JComboBox gender;
    private JComboBox year;
    private JLabel lblNewLabel_2;
	Connection conn ;
	PreparedStatement pt;


	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Students() throws SQLException, ClassNotFoundException {
		initialize();
		LoadTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(112, 128, 144));
		frame.setResizable(false);
		frame.setBounds(100, 100, 940, 706);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "REGISTER NEW STUDENT/UPDATE AND DELETE RECORDS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(75, 0, 130)));
		panel.setBackground(new Color(255, 127, 80));
		panel.setBounds(12, 12, 906, 317);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMISSION");
		lblNewLabel.setBounds(12, 28, 78, 15);
		panel.add(lblNewLabel);
		
		getadm = new JTextField();
		getadm.setBounds(96, 20, 254, 32);
		panel.add(getadm);
		getadm.setColumns(10);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(12, 81, 53, 15);
		panel.add(lblName);
		
		getname = new JTextField();
		getname.setColumns(10);
		getname.setBounds(96, 73, 254, 32);
		panel.add(getname);
		
		JLabel lblCourse = new JLabel("COURSE");
		lblCourse.setBounds(12, 135, 71, 15);
		panel.add(lblCourse);
		
		JLabel lblYear = new JLabel("YEAR");
		lblYear.setBounds(12, 191, 53, 15);
		panel.add(lblYear);
		
		getmobile = new JTextField();
		getmobile.setColumns(10);
		getmobile.setBounds(96, 232, 254, 32);
		panel.add(getmobile);
		
		JLabel lblMobile = new JLabel("MOBILE");
		lblMobile.setBounds(12, 240, 65, 15);
		panel.add(lblMobile);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(530, 81, 53, 15);
		panel.add(lblEmail);
		
		JLabel lblEthnicity = new JLabel("ETHNICITY");
		lblEthnicity.setBounds(493, 135, 90, 15);
		panel.add(lblEthnicity);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setBounds(501, 191, 71, 15);
		panel.add(lblGender);
		
		JLabel lblLocation = new JLabel("LOCATION");
		lblLocation.setBounds(493, 240, 90, 15);
		panel.add(lblLocation);
		
		getemil = new JTextField();
		getemil.setColumns(10);
		getemil.setBounds(590, 64, 254, 32);
		panel.add(getemil);
		
		getethnicity = new JTextField();
		getethnicity.setColumns(10);
		getethnicity.setBounds(590, 121, 254, 32);
		panel.add(getethnicity);
		
		getlocation = new JTextField();
		getlocation.setColumns(10);
		getlocation.setBounds(590, 232, 254, 32);
		panel.add(getlocation);
		
		btnAdd = new JButton("ADD NEW");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(128, 0, 0));
		btnAdd.setBounds(313, 267, 161, 38);
		btnAdd.addActionListener(this);
		panel.add(btnAdd);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(0, 100, 0));
		btnUpdate.setBounds(106, 267, 161, 38);
		btnUpdate.addActionListener(this);
		panel.add(btnUpdate);
		
		 btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(0, 0, 0));
		btnDelete.setBounds(539, 267, 161, 38);
		btnDelete.addActionListener(this);
		panel.add(btnDelete);
		
		getcourse = new JTextField();
		getcourse.setColumns(10);
		getcourse.setBounds(96, 127, 254, 32);
		panel.add(getcourse);
		
		gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"", "MALE", "FEMALE"}));
		gender.setBounds(590, 185, 253, 27);
		panel.add(gender);
		
		year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		year.setBounds(101, 186, 249, 24);
		panel.add(year);
		
		lblNewLabel_2 = new JLabel("MANAGE STUDENT INFO");
		lblNewLabel_2.setForeground(new Color(0, 51, 255));
		lblNewLabel_2.setFont(new Font("TeXGyreChorus", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_2.setBounds(391, 23, 398, 24);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 153, 0));
		panel_1.setBounds(22, 366, 906, 303);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Dialog", Font.ITALIC, 12));
		table.setForeground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				getadm.setText((String)table.getValueAt(row, 0));
				getname.setText((String)table.getValueAt(row, 1));
				getcourse.setText((String)table.getValueAt(row, 2));
				year.setSelectedItem(table.getValueAt(row, 3));
				getmobile.setText((String)table.getValueAt(row, 4));
				getemil.setText(table.getValueAt(row, 5)+"");
				getethnicity.setText((String)table.getValueAt(row, 6));
				gender.setSelectedItem(table.getValueAt(row, 7));
				getlocation.setText((String)table.getValueAt(row, 8));
			}
		});
		table.setBackground(new Color(0, 0, 51));
		table.setBounds(0, 24, 894, 267);
		panel_1.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("STUDENT ADM: ");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(206, 339, 135, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		search = new JTextField();
		search.setColumns(10);
		search.setBounds(343, 337, 254, 25);
		search.addActionListener(this);
		frame.getContentPane().add(search);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		
	
		try {
			conn = new Connection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Student st = new Student(getadm.getText(),getname.getText(),getcourse.getText(),getmobile.getText(),getemil.getText()
				,getethnicity.getText(),(String)gender.getSelectedItem(),getlocation.getText(),(String)year.getSelectedItem());
		
		
		if(ev.getSource().equals(btnAdd)) {
			if(getadm.getText().isBlank()||getname.getText().isBlank()||getcourse.getText().isBlank()||getmobile.getText().isBlank()||getemil.getText().isBlank()
					||getethnicity.getText().isBlank()||gender.getSelectedIndex()==0||getlocation.getText().isBlank()||year.getSelectedIndex()==0) {
				JOptionPane.showMessageDialog(frame, "fill all spaces","Error",JOptionPane.ERROR_MESSAGE);
			}else {
				try {
					PreparedStatement pst = conn.connect.prepareStatement("insert into students values(?,?,?,?,?,?,?,?,?)");
					pst.setString(1, st.getAdm());
					pst.setString(2, st.getFullname());
					pst.setString(3, st.getCourse());
					pst.setString(4, st.getYear());
					pst.setString(5, st.getMobile());
					pst.setString(6, st.getEmail());
					pst.setString(7, st.getEthnicity());
					pst.setString(8, st.getGender());
					pst.setString(9, st.getLocation());
					pst.execute();
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
		}
		
		else if(ev.getSource().equals(btnUpdate)) {
			try {
				PreparedStatement pst = conn.connect.prepareStatement("update students set fullname=?,course=?,year=?,mobile=?,email=?,ethnicity=?,gender=?,location=? where adm=?");
				pst.setString(9, st.getAdm());
				pst.setString(1, st.getFullname());
				pst.setString(2, st.getCourse());
				pst.setString(3, st.getYear());
				pst.setString(4, st.getMobile());
				pst.setString(5, st.getEmail());
				pst.setString(6, st.getEthnicity());
				pst.setString(7, st.getGender());
				pst.setString(8, st.getLocation());
				pst.execute();
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
		else if(ev.getSource().equals(btnDelete)) {
			try {
				pt = conn.connect.prepareStatement("delete from students where adm=?");
				pt.setString(1, getadm.getText());
				int confirm = JOptionPane.showConfirmDialog(frame, "Delete Record??");
				if(confirm == JOptionPane.OK_OPTION) {
					pt.execute();
					LoadTable();
					Clear();}
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		}
		else if(ev.getSource().equals(search)) {
			try {
				pt = conn.connect.prepareStatement("select * from students where adm=?");
				pt.setString(1, search.getText());
				table.setModel(DbUtils.resultSetToTableModel(pt.executeQuery()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private void Clear() {
		// TODO Auto-generated method stub
		getadm.setText("");
		getname.setText("");
		getemil.setText("");
		getethnicity.setText("");
		getlocation.setText("");
		year.setSelectedIndex(0);
		gender.setSelectedIndex(0);
		getmobile.setText("");
		getcourse.setText("");
		
	}

	private void LoadTable() throws SQLException, ClassNotFoundException {
		conn = new Connection();
		pt = conn.connect.prepareStatement("select * from students");
		table.setModel(DbUtils.resultSetToTableModel(pt.executeQuery()));
	}
}
