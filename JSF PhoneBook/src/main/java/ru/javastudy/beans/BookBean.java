package ru.javastudy.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "bookBean")
@SessionScoped
public class BookBean implements Serializable {

	private static final long serialVersionUID = 6081417964063918994L;

	public List<DialogBean> getBooks() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {

		Connection connect = null;


		try {
			String username = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/book";
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			connect = DriverManager.getConnection (url, username, password);

		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		}

		List<DialogBean> books = new ArrayList<DialogBean>();
		PreparedStatement pstmt = connect
				.prepareStatement("select * from book");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			DialogBean book = new DialogBean();
			book.setId(rs.getInt("id"));
			book.setFirstName(rs.getString("first_name"));
			book.setSecondName(rs.getString("second_name"));
			book.setPhone(rs.getString("phone"));

			books.add(book);

		}

		// close resources
		rs.close();
		pstmt.close();
		connect.close();

		return books;

	}



	public static void insertSql(String FirstName,String SecondName,String Phone) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {

		Connection connect = null;


		try {
			String username = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/book";
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			connect = DriverManager.getConnection (url, username, password);

		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		}

		String query="INSERT INTO book(first_name,second_name,phone) VALUES ('"+FirstName+"','"+SecondName+"','"+Phone+"');";
		PreparedStatement pstmt = connect
				.prepareStatement(query);
		pstmt.executeUpdate(query);


		pstmt.close();
		connect.close();


	}
	public static void deleteSql(int id) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {

		Connection connect = null;


		try {
			String username = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/book";
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			connect = DriverManager.getConnection (url, username, password);

		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		}

		String query="DELETE FROM book where id="+id+";";
		PreparedStatement pstmt = connect
				.prepareStatement(query);
		pstmt.executeUpdate(query);


		pstmt.close();
		connect.close();


	}




	public static void updateSql(int id,String FirstName,String SecondName,String Phone) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {

		Connection connect = null;


		try {
			String username = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/book";
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			connect = DriverManager.getConnection (url, username, password);

		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		};


		String query="UPDATE book set  first_name='"+FirstName+"',second_name='"+SecondName+"',phone='"+Phone+"'  where id="+id+";";
		PreparedStatement pstmt = connect
				.prepareStatement(query);
		pstmt.executeUpdate(query);

		pstmt.close();
		connect.close();

	}



	public static List<DialogBean> getBooks1(int Id) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {

		Connection connect = null;


		try {
			String username = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/book";
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			connect = DriverManager.getConnection (url, username, password);

		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		}

		List<DialogBean> books1 = new ArrayList<DialogBean>();
		PreparedStatement pstmt = connect
				.prepareStatement("select * from book where id="+Id+";");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			DialogBean book1 = new DialogBean();
			book1.setId(rs.getInt("id"));
			book1.setFirstName(rs.getString("first_name"));
			book1.setSecondName(rs.getString("second_name"));
			book1.setPhone(rs.getString("phone"));

			books1.add(book1);

		}

		// close resources
		rs.close();
		pstmt.close();
		connect.close();

		return books1;

	}





}
