package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Book;
import dto.Rental;

public class RentalDAO {
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
	
	 public static Book selectBook(int id){
			
			// 実行するSQL
			String sql = "SELECT book_id,book_name FROM teamlibrary2 WHERE book_id = ?";
					
			try (
					Connection con = getConnection();	// DB接続
					PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
					){
				
				pstmt.setInt(1, id);
				
				try (ResultSet rs = pstmt.executeQuery()){
					
					if(rs.next()) {
						// id は引数で受け取っているのでgetしない
						int id2 = rs.getInt("book_id");
						String book_name = rs.getString("book_name");
						
					Book result = new Book(-1,book_name ,null, null, -1, null, null);
					
                       System.out.println(book_name);
					 
						return result;
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}

			// 途中でExceptionが発生した場合や取得結果が0件の場合はnullを返す。
			return null;
		}	
		
	 
	 public static int RentalBook(Rental rental) {
			String sql = "INSERT INTO history2 VALUES(default, ?, ?, ?, ?, ?, ?)";
			int result = 0;
					
			try (
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				pstmt.setInt(1, rental.getAccount_id());
				pstmt.setString(2, rental.getMail() );
				pstmt.setInt(3, rental.getBook_id());
				pstmt.setString(4, rental.getLeadingday());
				pstmt.setString(5, rental.getRepayment());

				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} finally {
				System.out.println(result + "冊貸出しました。");
			}
			return result;
		}
}
