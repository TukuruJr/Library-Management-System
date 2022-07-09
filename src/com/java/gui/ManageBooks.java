package com.java.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.java.connection.Connection;
import com.java.models.Book;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManageBooks implements ActionListener{

	private JFrame frmManageBooks;
	private JTextField isbn;
	private JTextField bookname;
	private JTextField writer;
	private JTextField publisher;
	private JTextField edition;
	private JTextField quantity;
	private JLabel lblDateIn;
	private JTextField price;
	private JTextField date;
	private JLabel lblDateIn_1;
	private JButton btnUpdate,btnAdd;
	private JButton btnDelete,btnPrint;
	private JTable table;
	Connection conn;
	PreparedStatement pst;
	private JTextField total;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageBooks window = new ManageBooks();
					window.frmManageBooks.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ManageBooks() throws ClassNotFoundException, SQLException {
		initialize();
		LoadTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManageBooks = new JFrame();
		frmManageBooks.getContentPane().setBackground(Color.MAGENTA);
		frmManageBooks.setTitle("MANAGE BOOKS");
		frmManageBooks.setBounds(100, 100, 776, 472);
		frmManageBooks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManageBooks.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(25, 12, 739, 220);
		frmManageBooks.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(29, 17, 56, 15);
		panel.add(lblNewLabel);
		
		isbn = new JTextField();
		isbn.setBounds(117, 10, 242, 30);
		panel.add(isbn);
		isbn.setColumns(10);
		
		JLabel lblBookName = new JLabel("BOOK NAME");
		lblBookName.setBounds(12, 59, 97, 15);
		panel.add(lblBookName);
		
		bookname = new JTextField();
		bookname.setColumns(10);
		bookname.setBounds(117, 52, 242, 30);
		panel.add(bookname);
		
		writer = new JTextField();
		writer.setColumns(10);
		writer.setBounds(117, 94, 242, 30);
		panel.add(writer);
		
		JLabel lblWriter = new JLabel("WRITER");
		lblWriter.setBounds(33, 101, 79, 15);
		panel.add(lblWriter);
		
		JLabel lblPublisher = new JLabel("PUBLISHER");
		lblPublisher.setBounds(29, 147, 80, 15);
		panel.add(lblPublisher);
		
		publisher = new JTextField();
		publisher.setColumns(10);
		publisher.setBounds(117, 136, 242, 30);
		panel.add(publisher);
		
		edition = new JTextField();
		edition.setColumns(10);
		edition.setBounds(127, 178, 176, 30);
		panel.add(edition);
		
		JLabel lblEdition = new JLabel("EDITION");
		lblEdition.setBounds(32, 185, 80, 15);
		panel.add(lblEdition);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setBounds(377, 17, 80, 15);
		panel.add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setColumns(10);
		quantity.setBounds(475, 10, 252, 30);
		panel.add(quantity);
		
		lblDateIn = new JLabel("PRICE");
		lblDateIn.setBounds(387, 59, 64, 15);
		panel.add(lblDateIn);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(475, 52, 252, 30);
		panel.add(price);
		
		date = new JTextField();
		date.setEditable(false);
		date.setColumns(10);
		date.setText(LocalDate.now().toString());
		date.setBounds(485, 94, 242, 30);
		panel.add(date);
		
		lblDateIn_1 = new JLabel("DATE IN");
		lblDateIn_1.setBounds(377, 101, 80, 15);
		panel.add(lblDateIn_1);
		
		btnAdd = new JButton("ADD");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(0, 0, 139));
		btnAdd.setBounds(357, 180, 117, 25);
		btnAdd.addActionListener(this);
		panel.add(btnAdd);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(0, 0, 139));
		btnUpdate.setBounds(479, 180, 117, 25);
		btnUpdate.addActionListener(this);
		panel.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(139, 0, 0));
		btnDelete.addActionListener(this);
		btnDelete.setBounds(617, 180, 117, 25);
		panel.add(btnDelete);
		
		JLabel lblDateIn_1_1 = new JLabel("TOTAL");
		lblDateIn_1_1.setBounds(394, 147, 80, 15);
		panel.add(lblDateIn_1_1);
		
		total = new JTextField();
		total.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		total.setForeground(Color.BLUE);
		total.setBackground(Color.ORANGE);
		total.setEditable(false);
		total.setColumns(10);
		total.setBounds(495, 140, 110, 30);
		panel.add(total);
		
		btnPrint = new JButton("Print");
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setBackground(new Color(75, 0, 130));
		btnPrint.setBounds(617, 142, 117, 25);
		btnPrint.addActionListener(this);
		panel.add(btnPrint);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				date.setEditable(true);
				int row = table.getSelectedRow();
				isbn.setText((String)table.getValueAt(row, 0));
				writer.setText((String)table.getValueAt(row, 1));
				bookname.setText((String)table.getValueAt(row, 2));
				publisher.setText((String)table.getValueAt(row, 3));
				edition.setText(table.getValueAt(row, 4)+"");
				price.setText(table.getValueAt(row, 7)+"");
				total.setText(table.getValueAt(row, 8)+"");
				quantity.setText(table.getValueAt(row, 5)+"");
			}
		});
		table.setFont(new Font("Dialog", Font.BOLD, 12));
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(0, 100, 0));
		table.setBounds(25, 256, 729, 182);
		frmManageBooks.getContentPane().add(table);
		
		lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_1.setBounds(35, 244, 70, 12);
		frmManageBooks.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Book Name");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_2.setBounds(100, 244, 81, 12);
		frmManageBooks.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Writer");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_3.setBounds(193, 244, 70, 12);
		frmManageBooks.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Publisher");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_4.setBounds(273, 244, 70, 12);
		frmManageBooks.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Edition");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_5.setBounds(355, 241, 70, 12);
		frmManageBooks.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Quantity");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_6.setBounds(437, 241, 70, 12);
		frmManageBooks.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Date_in");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_7.setBounds(519, 244, 70, 12);
		frmManageBooks.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Price");
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_8.setBounds(601, 244, 70, 12);
		frmManageBooks.getContentPane().add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Reciept's total");
		lblNewLabel_9.setForeground(Color.BLACK);
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_9.setBounds(665, 244, 99, 12);
		frmManageBooks.getContentPane().add(lblNewLabel_9);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		try {
			conn = new Connection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Book book = new Book(isbn.getText(),bookname.getText(),writer.getText(),publisher.getText(),
				Integer.valueOf(edition.getText()),Integer.parseInt(quantity.getText()),
				Float.parseFloat(price.getText()),(Float.parseFloat(price.getText())*Integer.parseInt(quantity.getText())));
		
		// TODO Auto-generated method stub
		if(ev.getSource().equals(btnAdd)) {
			total.setText(Float.parseFloat(price.getText())*Integer.parseInt(quantity.getText())+"");
			try {
				pst = conn.connect.prepareStatement("insert into books values(?,?,?,?,?,?,?,?,?)");
				pst.setString(1, book.getISBN());
				pst.setString(2, book.getBname());
				pst.setString(3, book.getWriter());
				pst.setString(4, book.getPublisher());
				pst.setInt(5, book.getEdition());
				pst.setInt(6, book.getQuantity());
				pst.setString(7, LocalDate.now().toString());
				pst.setFloat(8, book.getPrice());
				pst.setFloat(9, book.getTotal());
				pst.execute();
				LoadTable();
				Clear();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		else if(ev.getSource().equals(btnUpdate)) {
			try {
				pst = conn.connect.prepareStatement("update books set bookname=?,writer=?,publisher=?,edition=?,quantity=?,price=?,total=?,date_in=? where ISBN=?");
				pst.setString(1, book.getBname());
				pst.setString(2, book.getWriter());
				pst.setString(3, book.getPublisher());
				pst.setInt(4, book.getEdition());
				pst.setInt(5, book.getQuantity());
				pst.setFloat(6, book.getPrice());
				pst.setFloat(7, book.getTotal());
				pst.setString(8, LocalDate.now().toString());
				pst.setString(9, book.getISBN());
				pst.execute();
				LoadTable();
				Clear();
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
				pst = conn.connect.prepareStatement("delete from books where ISBN= ?");
				pst.setString(1, book.getISBN());
				int confirm = JOptionPane.showConfirmDialog(frmManageBooks, "Delete Record??");
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
		
		
		
		else if(ev.getSource().equals(btnPrint)) {
			File file = new File("/home/maurice/eclipse-workspace/Library/reciepts/"+LocalTime.now()+".txt");
				try {
					FileWriter fw = new FileWriter(file);
					String text = "";
					text="BOOK: "+book.getBname()+"\t\t"+"ISBN: "+book.getISBN()+"\n\n";
					fw.append(text);
					text="Quantity "+book.getQuantity()+"\t\t"+"Total "+book.getTotal()+"\n\n";
					fw.append(text);
					fw.close();
				JOptionPane.showMessageDialog(frmManageBooks, "Printing Reciept Copy Left in "+file.getAbsolutePath());
				Clear();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void Clear() {
		isbn.setText("");
		writer.setText("");
		bookname.setText("");
		publisher.setText("");
		edition.setText("");
		price.setText("");
		total.setText("");
		quantity.setText("");
	}
	
	
	private void LoadTable() throws SQLException, ClassNotFoundException {
		conn = new Connection();
		pst = conn.connect.prepareStatement("select * from books");
		table.setModel(DbUtils.resultSetToTableModel(pst.executeQuery()));
	}
}
