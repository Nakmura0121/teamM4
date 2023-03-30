package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Book;

public class BookDAO {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);	    
	}
	//登録機能
	public static int registerBook(Book book) {
		String sql = "INSERT INTO teamlibrary2 VALUES(default, ?, ?, ?, ?, ?, ?)";
		int result = 0;
				
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, book.getBook_name());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			pstmt.setInt(4, book.getIsbn());
			pstmt.setString(5, book.getVersion());
			pstmt.setString(6, book.getDay());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "冊登録しました。");
		}
		return result;
	}
	//一覧機能
	public static List<Book> selectAllteamlibrary(){


		List<Book>result = new ArrayList<>();

		String sql = "SELECT * FROM teamlibrary2";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet book = pstmt.executeQuery()){
				while(book.next()) {
					int id = book.getInt("id");
					String Book_name = book.getString("book_name");
					String Author = book.getString("author");
					String Publisher = book.getString("publisher");
					int Isbn = book.getInt("isbn");
					String Version = book.getString("version");
					String Day = book.getString("day");
					Book Book = new Book(id, Book_name, Author, Publisher, Isbn, Version, Day);
					result.add(Book);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	//削除機能
	public static int deletelibrary(int id) {
		String sql = "DELETE FROM teamlibrary2 WHERE book_id = ?";
		int result = 0;
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
		
			pstmt.setInt(1,id);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "冊削除しました。");
		}
		return result;
	}
	
	//検索機能
	public static List<Book> searchLibraly(String book_name){

		String sql = "SELECT * FROM teamlibrary2 WHERE book_name LIKE ?";

		List<Book> result = new ArrayList<>();


		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){

			pstmt.setString(1, "%" + book_name + "%");

			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int Id = rs.getInt("id");
					String Book_name = rs.getString("book_name");
					String Author = rs.getString("author");
					String Publisher = rs.getString("publisher");
					int isbn = rs.getInt("isbn");
					String Version = rs.getString("version");
					String Day = rs.getString("day");

					Book teamlibrary= new Book(Id, Book_name, Author, Publisher, isbn, Version, Day);

					result.add(teamlibrary);
				}
			}	

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
		}
}
