package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.bean.MemberDTO;

public class MemberDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "oracle";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MemberDAO() {
		try {
		Class.forName(driver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {		
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
}	
	
//	write(String name, String id, ~~~~12개 받아야...)
	//회원가입
	public int write(MemberDTO memberDTO) {
		int su=0;
		String sql = "insert into member values (?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getZipcode());
			pstmt.setString(11, memberDTO.getAddr1());
			pstmt.setString(12, memberDTO.getAddr2());
			
			su = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return su;
	}
	
	////////////////////////////////////////////////
	
	//로그인체크
	public String loginCheck(String id, String pwd) {
		getConnection();
		String sql = "select id, pwd, name from member";
		
		try {
			pstmt = conn.prepareStatement(sql);//select를 처리해줄 가이드.
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				if(id.equals(rs.getString("id"))){
					if(pwd.equals(rs.getString("pwd")))
						return rs.getString("name");
					else
						return "1";
				}
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return "2";
	}
	
	//////////////////강사님코드
	public String login(String id,String pwd) {
		String name=null;
		String sql = "select * from member where id=? pwd=?";
		getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())name=rs.getString("name");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return name;
	}
	
	
	public boolean isExistId(String id) {
		boolean exist=false; //이미 존재하면 true 아니면 false
		
		getConnection();
		
		String sql = "select * from member where id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
					exist=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return exist;
	}

	
	
	// 회원정보 수정(내정보 가져오기)
	public MemberDTO getUserInfo(String userId) {
		getConnection();
		MemberDTO memberDTO = new MemberDTO();
		String sql = "select * from member where id=?";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
					
			if(rs.next()) {
				
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setZipcode(rs.getString("zipcode"));
				memberDTO.setAddr1(rs.getString("addr1"));
				memberDTO.setAddr2(rs.getString("addr2"));
				memberDTO.setLogtime(rs.getDate("logtime"));
				
				System.out.print("DAO= "+memberDTO.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return memberDTO;
	}
	
	
	// 회원정보 업데이트
	public void updateUserInfo(MemberDTO memberDTO) {
		
		getConnection();
		String sql = "Update member SET name = ?,"
								  	 + "pwd = ?,"
								  	 + "gender = ?,"
								  	 + "email1 = ?,"
								  	 + "email2 = ?,"
								  	 + "tel1 = ?,"
								  	 + "tel2 = ?,"
								  	 + "tel3 = ?,"
								  	 + "zipcode = ?,"
								  	 + "addr1 = ?,"
								  	 + "addr2 = ?"
								  	 + "where id = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getGender());
			pstmt.setString(4, memberDTO.getEmail1());
			pstmt.setString(5, memberDTO.getEmail2());
			pstmt.setString(6, memberDTO.getTel1());
			pstmt.setString(7, memberDTO.getTel2());
			pstmt.setString(8, memberDTO.getTel3());
			pstmt.setString(9, memberDTO.getZipcode());
			pstmt.setString(10, memberDTO.getAddr1());
			pstmt.setString(11, memberDTO.getAddr2());
			pstmt.setString(12, memberDTO.getId());
			
			pstmt.executeUpdate();
			
			System.out.print("잘들어갔나?"+memberDTO.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	
	}
	
	public void close() {
		try {
			if(rs != null) rs.close(); 
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}

//
//클래스			서블릿
//Object			HttpServlet
//new - 생성		new X ->  init() -> service() -> destroy()