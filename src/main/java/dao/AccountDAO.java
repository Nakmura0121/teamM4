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

import dto.Account;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class AccountDAO {
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
	
	public static int registerAccount(Account account) {
		String sql = "INSERT INTO teamaccount VALUES(default, ?, ?, ?, ?, current_timestamp)";
		int result = 0;
		
		// ランダムなソルトの取得(今回は32桁で実装)
		String salt = GenerateSalt.getSalt(32);
		
		// 取得したソルトを使って平文PWをハッシュ
		String hashedPw = GenerateHashedPw.getSafetyPassword(account.getPassword(), salt);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, account.getName());
			pstmt.setString(2, account.getMail());
			pstmt.setString(3, salt);
			pstmt.setString(4, hashedPw);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	// メールアドレスを元にソルトを取得
	public static String getSalt(String mail) {
		String sql = "SELECT salt FROM teamaccount WHERE mail = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("salt");
					return salt;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// ログイン処理
	public static Account login(String mail, String hashedPw) {
		String sql = "SELECT * FROM teamaccount WHERE mail = ? AND hashedpw = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			pstmt.setString(2, hashedPw);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					int id = rs.getInt("account_id");
					String name = rs.getString("account_name");
					String salt = rs.getString("salt");
					String createdAt = rs.getString("created_at");
					
					return new Account(id, name, mail, salt, null, null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	  public static List<Account> searchAccount(String name){
			
			String sql = "SELECT account_name,mail FROM teamaccount WHERE  account_name LIKE ?";
			
			List<Account> result = new ArrayList<>();
					
			
			try (
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				
				pstmt.setString(1, "%" + name + "%");
				
				try (ResultSet rs = pstmt.executeQuery()){
					while(rs.next()) {
						String name1=rs.getString("account_name");
						String mail=rs.getString("mail");
					
						Account libraly= new Account(-1, name1, mail, null, null, null);
						
						result.add(libraly);
					}
				}	
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return result;

	    }
	
	   public static Account selectAccount(String mail){
			
			// 実行するSQL
			String sql = "SELECT * FROM teamaccount WHERE mail = ?";
					
			try (
					Connection con = getConnection();	// DB接続
					PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
					){
				
				pstmt.setString(1, mail);
				
				try (ResultSet rs = pstmt.executeQuery()){
					
					if(rs.next()) {
						// id は引数で受け取っているのでgetしない
						String name = rs.getString("account_name");
						String mail2 = rs.getString("mail");

					Account result = new Account(-1, name,mail2, null, null, null);
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
		
}


