package com.floionze.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CopyOfcrudsqlab {
	private String url = "jdbc:mysql://localhost:3306/";
	private String dbname = "bookdb";
	private String drivername = "com.mysql.jdbc.Driver";
	private String username = "root";
	private String password = "0000";

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(drivername);
			con = DriverManager.getConnection(url + dbname, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void closeConnection(Connection con) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public List<book> getlistb(int authorid) {
		List<book> list = new ArrayList<book>();
		try {
			Connection mycon = this.getConnection();
			Statement st = mycon.createStatement();
			st.execute("select * from book where authorid = '"
					+ String.valueOf(authorid) + "'");
			while (true) {
				ResultSet set = st.getResultSet();
				if (set != null) {
					while (set.next()) {
						book book = new book();
						book.setAuthorid(authorid);
						book.setIsbn(set.getString("isbn"));
						book.setPrice(Double.valueOf(set.getString("price")));
						book.setPublishdate(set.getString("publishdate"));
						book.setPublisher(set.getString("publisher"));
						book.setTitle(set.getString("title"));
						list.add(book);
						continue;
					}
					st.getMoreResults();
				}
				break;
			}
			this.closeConnection(mycon);
		} catch (Exception e) {
		}
		return list;
	}

	public author geta(int authorid) {
		author author = new author();
		try {
			Connection mycon = this.getConnection();
			Statement st = mycon.createStatement();
			ResultSet set = st
					.executeQuery("select * from author where authorid = "
							+ String.valueOf(authorid) + ";");
			while (set.next()) {
				author.setAge(Integer.valueOf(set.getString("age")));
				author.setAuthorid(authorid);
				author.setCountry(set.getString("country"));
				author.setName(set.getString("name"));
			}
			this.closeConnection(mycon);
		} catch (Exception e) {
		}
		return author;
	}

	public author geta(String name) {
		author author = new author();
		try {
			Connection mycon = this.getConnection();
			Statement st = mycon.createStatement();
			ResultSet set = st
					.executeQuery("select * from author where name = '" + name
							+ "';");
			while (set.next()) {
				author.setAge(Integer.valueOf(set.getString("age")));
				author.setAuthorid(Integer.valueOf(set.getString("authorid")));
				author.setCountry(set.getString("country"));
				author.setName(name);
			}
			this.closeConnection(mycon);
		} catch (Exception e) {
		}
		return author;
	}

	public book getb(String isbn) {
		book book = new book();
		try {
			Connection mycon = this.getConnection();
			Statement st = mycon.createStatement();
			ResultSet set = st.executeQuery("select * from book where isbn = '"
					+ isbn + "';");
			while (set.next()) {
				book.setAuthorid(Integer.valueOf(set.getString("authorid")));
				book.setIsbn(isbn);
				book.setPrice(Double.valueOf(set.getString("price")));
				book.setPublishdate(set.getString("publishdate"));
				book.setPublisher(set.getString("publisher"));
				book.setTitle(set.getString("title"));
			}
			this.closeConnection(mycon);
		} catch (Exception e) {
		}
		return book;
	}

	public void deleteb(String isbn) {
		try {
			Connection mycon = this.getConnection();
			Statement st = mycon.createStatement();
			st.executeUpdate("delete from book where isbn='" + isbn + "'");
			this.closeConnection(mycon);
		} catch (Exception e) {
		}
	}

	public void savea(author a) {
		try {
			Connection mycon = this.getConnection();
			Statement st = mycon.createStatement();
			st.executeUpdate("insert into author values (null,'" + a.getName()
					+ "','" + a.getAge() + "','" + a.getCountry() + "')");
			this.closeConnection(mycon);
		} catch (Exception e) {
		}
	}

	public void saveb(book b) {
		try {
			Connection mycon = this.getConnection();
			Statement st = mycon.createStatement();
			st.executeUpdate("insert into book values ('" + b.getIsbn() + "','"
					+ b.getTitle() + "','" + b.getAuthorid() + "','"
					+ b.getPublisher() + "','" + b.getPublishdate() + "','"
					+ b.getPrice() + "')");
			this.closeConnection(mycon);
		} catch (Exception e) {
		}
	}

	public void updateb(book b) {
		try {
			Connection mycon = this.getConnection();
			Statement st = mycon.createStatement();
			st.executeUpdate("update book set isbn='" + b.getIsbn()
					+ "',title='" + b.getTitle() + "',authorid='"
					+ String.valueOf(b.getAuthorid()) + "',publisher='"
					+ b.getPublisher() + "',publishdate='" + b.getPublishdate()
					+ "',price='" + b.getPrice() + "' where isbn='"
					+ b.getIsbn() + "'");
			this.closeConnection(mycon);
		} catch (Exception e) {
		}
	}

	public void initdb() {
		try {
			Class.forName(drivername);
			Connection con = DriverManager.getConnection(url, username,
					password);
			Statement st = con.createStatement();
			st.executeUpdate("drop database if exists " + dbname);
			st.executeUpdate("create database " + dbname);
			st.executeUpdate("use " + dbname);
			st.executeUpdate("create table if not exists author("
					+ "authorid int(3) not null primary key auto_increment,"
					+ "name char(20)," + "age int(3)," + "country char(20))");
			st.executeUpdate("create table if not exists book("
					+ "isbn char(20) primary key," + "title char(20),"
					+ "authorid int(3),"
					+ "foreign key(authorid) references author(authorid),"
					+ "publisher char(20)," + "publishdate char(20),"
					+ "price double(6,2))");
			PreparedStatement psa = con
					.prepareStatement("INSERT INTO author VALUES(null,?,?,?)");
			for (int i = 0; i < 5; i++) {
				psa.setString(1, "zeppit" + String.valueOf(i));
				psa.setInt(2, i + 20);
				psa.setString(3, i < 3 ? "China" : "Chinatown");
				psa.executeUpdate();
			}
			PreparedStatement psb = con
					.prepareStatement("INSERT INTO book VALUES(?,?,?,?,?,?)");
			for (int i = 0; i < 20; i++) {
				psb.setString(1, "000-000000-" + i / 10 + i % 10);
				psb.setString(2, i + " in 1");
				psb.setLong(3, i % 5 + 1);
				psb.setString(4, "hit " + (i % 4 + 1));
				psb.setString(5, "0000-00-00");
				psb.setDouble(6, (double) i + 50);
				psb.executeUpdate();
			}
			this.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		CopyOfcrudsqlab csab = new CopyOfcrudsqlab();
		csab.initdb();
		// System.out.println(csab.getlistb(1).size());
	}
}
