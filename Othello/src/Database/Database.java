package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database{
	public String idConfirm(String id) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String result = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/othello_loginsystem?useSSL=false&&useUnicode=true&&characterEncoding=UTF-8&&serverTimezone=UTC", "root", "1234");
			stmt = con.prepareStatement("SELECT * FROM Othello_ID where id = ?");
			stmt.setString(1,id);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getString("id");
			}
			
		}catch( ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch( SQLException e){
            System.out.println("에러 " + e);
        }finally {
        	if(rs != null) {
        		try {
        			rs.close();
        		}catch(SQLException e) {
        			e.printStackTrace();
        		}
        	}if(stmt != null) {
        		try {
        			stmt.close();
        		}catch(SQLException e) {
        			e.printStackTrace();
        		}
        	}if(con != null) {
        		try {
        			con.close();
        		}catch(SQLException e) {
        			e.printStackTrace();
        		}
        	}
		return result;
        }
    }
	public String nickNameConfirm(String nickname) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String result = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/othello_loginsystem?useSSL=false&&useUnicode=true&&characterEncoding=UTF-8&&serverTimezone=UTC", "root", "1234");
			stmt = con.prepareStatement("SELECT * FROM Othello_ID where nickname = ?");
			stmt.setString(1,nickname);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getString("nickname");
			}
			
		}catch( ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch( SQLException e){
            System.out.println("에러 " + e);
        }finally {
        	if(rs != null) {
        		try {
        			rs.close();
        		}catch(SQLException e) {
        			e.printStackTrace();
        		}
        	}if(stmt != null) {
        		try {
        			stmt.close();
        		}catch(SQLException e) {
        			e.printStackTrace();
        		}
        	}if(con != null) {
        		try {
        			con.close();
        		}catch(SQLException e) {
        			e.printStackTrace();
        		}
        	}
		return result;
        }
    }
	public static void insert(String id, String password,  String nickname, String name, String phoneNum, String email){
    	
    	PreparedStatement pstmt = null;
        Connection conn = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost/othello_loginsystem?useSSL=false&&useUnicode=true&&characterEncoding=UTF-8&&serverTimezone=UTC";
            conn = DriverManager.getConnection(url, "root", "1234");

            String sql = "INSERT INTO Othello_ID VALUES (?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            pstmt.setString(3, nickname);
            pstmt.setString(4, name);
            pstmt.setString(5, phoneNum);
            pstmt.setString(6, email);
            
            int count = pstmt.executeUpdate();
            if( count == 0 ){
                System.out.println("데이터 입력 실패");
            }
            else{
                System.out.println("데이터 입력 성공");
            }
        }
        catch( ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch( SQLException e){
            System.out.println("에러 " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
                if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
    }
	
	public boolean Login(String id, String password) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String result = null;
		
		boolean Judge = false;
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/othello_loginsystem?useSSL=false&&useUnicode=true&&characterEncoding=UTF-8&&serverTimezone=UTC", "root", "1234");
			stmt = con.prepareStatement("SELECT * FROM Othello_ID where id = ?");
			stmt.setString(1,id);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getString("password");
			}
			if(password.equals(result)) {
				Judge = true;
			}
		}catch( ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch( SQLException e){
            System.out.println("에러 " + e);
        }finally {
        	if(rs != null) {
        		try {
        			rs.close();
        		}catch(SQLException e) {
        			e.printStackTrace();
        		}
        	}if(stmt != null) {
        		try {
        			stmt.close();
        		}catch(SQLException e) {
        			e.printStackTrace();
        		}
        	}if(con != null) {
        		try {
        			con.close();
        		}catch(SQLException e) {
        			e.printStackTrace();
        		}
        	}
		return Judge;
        }
    }
}