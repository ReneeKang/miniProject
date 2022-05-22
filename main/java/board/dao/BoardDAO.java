package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import board.bean.BoardDTO;

public class BoardDAO {
	//JDBC
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "oracle";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	List<BoardDTO> list = new ArrayList<BoardDTO>();//부모=자식
	
	public BoardDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			conn= DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 내 글쓰기 메서드
	public int writeOnBoard(BoardDTO boardDTO) {
		int su=0;
		String sql = "insert into board (seq,id,name,email,subject,content,ref,logtime) "
				+ "values (seq_board.nextval, ?, ?, ?, ?, ?, seq_board.currval, sysdate)";
		
		getConnection();

		try {
			// ? index (컬럼이 아닌 ?갯수 인덱스....)
			pstmt = conn.prepareStatement(sql);
			System.out.println("from form : ");
			System.out.println( boardDTO);
			pstmt.setString(1, boardDTO.getId());
			pstmt.setString(2, boardDTO.getName());
			pstmt.setString(3, boardDTO.getEmail());
			pstmt.setString(4, boardDTO.getSubject());
			pstmt.setString(5, boardDTO.getContent());
			System.out.println("after setString");
			
			su = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return su;
	}
	
	
	
	public List<BoardDTO> selectArticle() {
		getConnection();
		String sql = "select * from board order by logtime desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("start select");
			
			while(rs.next()) {
				
				BoardDTO boardDTO = new BoardDTO();
				
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setEmail(rs.getString("email"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setRef(rs.getInt("ref"));
				boardDTO.setLev(rs.getInt("lev"));
				boardDTO.setStep(rs.getInt("step"));
				boardDTO.setPseq(rs.getInt("pseq"));
				boardDTO.setReply(rs.getInt("reply"));
				boardDTO.setHit(rs.getInt("hit"));
//				boardDTO.setLogtime(rs.getString("logtime"));
				boardDTO.setLogtime(rs.getDate("logtime"));
//				Date dateStr = rs.getDate("logtime");
			
//				System.out.println("Date변환 = " +dateStr);
				list.add(boardDTO);
				System.out.println("set list : " + boardDTO);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
		
	
	///////////////
	
//	public List<BoardDTO> selectBoard() {
		public List<BoardDTO> selectBoard(int startNum, int endNum) {
		getConnection();
//		String sql = "select * from board order by logtime desc";
		String sql = "select * from ( select rownum rn, tt.*"
				+"from (select * from board order by seq desc )tt ) where rn>=? and rn<=?";

		
		try {
			pstmt = conn.prepareStatement(sql);
			//페이징처리 추가
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			
			
			
			rs = pstmt.executeQuery();
			
			System.out.println("start select");
			
			while(rs.next()) {
				
				BoardDTO boardDTO = new BoardDTO();
				
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getDate("logtime"));
				list.add(boardDTO);
				System.out.println("set list : " + boardDTO);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			list=null; //////////////////////가져오다 망하면 널로 처리해버림
		} finally {
			close();
		}
		
		return list;
	}
	
	////////////////////////
	
	public void close() {
		try {
			if(rs != null) rs.close(); 
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//페이징처리
	public int getTotalA() {
		getConnection();
		String sql = "select count(*) from board";
		int totalA=0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next(); //이거 해줘야함 !!!!!!! 포지션 맞춰야 꺼내오든 말든 함.
			//totalA=Integer.parseInt(rs.getString("count(*)") );
			totalA = rs.getInt(1); //함정2 ㅋㅋ 첫번쨰칼럼이니까 이렇게 가져와도 됌
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return totalA;
		
		
		
	}
	
	
	///////////// 강사님 글쓰기 메서드
	
	public int writeOnBoard(Map<String, String> map) {
		int su=0;
		String sql = "insert into board (seq,id,name,email,subject,content,ref,logtime) "
				+ "values (seq_board.nextval, ?, ?, ?, ?, ?, seq_board.currval, sysdate)";
		
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("from form : ");
			System.out.println( map);
			pstmt.setString(1, map.get("id"));
			pstmt.setString(2, map.get("name"));
			pstmt.setString(3, map.get("email"));
			pstmt.setString(4, map.get("subject"));
			pstmt.setString(5, map.get("content"));
			System.out.println("after setString");
			
			su = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return su;
	}
	
	
	
	//제목클릭 내용보여주기
	public String getContent(int seq) {
//	public boardDTO getContent(int seq) {
		
		getConnection();
//		String sql = "select content from board where seq="+seq;
		String sql = "select content from board where seq=?";
//		String sql = "select * from board where seq=?";
		String content="";
		// content만 가져올게 아니고 다른부가정보 다 가져올거라 DTO에 담아오자ㅎ
		BoardDTO boardDTO = null;
		String sqlHit = "Update board SET hit = hit+1 where seq=?";
		
		try {
			//조회수 업데이트
			pstmt = conn.prepareStatement(sqlHit); //가이드만들어주고~~ ㅋ
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
			
			
			pstmt = conn.prepareStatement(sql); //가이드만들어주고~~ ㅋ
			//?채우기
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
				content = rs.getString("content");
				
			}
			
			
			//dto로받아올때 통째로 
//			pstmt = conn.prepareStatement(sql); //가이드만들어주고~~ ㅋ
//			pstmt.setInt(1, seq);
//			rs = pstmt.executeQuery();
//			
//			
//			while(rs.next()) {
//				
//				boardDTO = new BoardDTO();
//				
//				boardDTO.setSeq(rs.getInt("seq"));
//				boardDTO.setId(rs.getString("id"));
//				boardDTO.setName(rs.getString("name"));
//				boardDTO.setEmail(rs.getString("email"));
//				boardDTO.setSubject(rs.getString("subject"));
//				boardDTO.setContent(rs.getString("content"));
//				boardDTO.setRef(rs.getInt("ref"));
//				boardDTO.setLev(rs.getInt("lev"));
//				boardDTO.setStep(rs.getInt("step"));
//				boardDTO.setPseq(rs.getInt("pseq"));
//				boardDTO.setReply(rs.getInt("reply"));
//				boardDTO.setHit(rs.getInt("hit"));
//				boardDTO.setLogtime(rs.getDate("logtime"));
//				
//			}
			//여기까지
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return content;
//		return boardDTO;
	}
	
	
	
	
	
	
	//강사님 제목클릭 내용 보여주기 메서드 
	
	public BoardDTO getBoard(int seq) {
			getConnection();
			BoardDTO boardDTO = null;
			String sql = "select * from board where seq=?";
			String sqlHit = "Update board SET hit = hit+1 where seq=?";
			
			try {
				//조회수업데이트
				pstmt = conn.prepareStatement(sqlHit); //가이드만들어주고~~ ㅋ
				pstmt.setInt(1, seq);
				pstmt.executeUpdate();
				
				pstmt = conn.prepareStatement(sql); //가이드만들어주고~~ ㅋ
				pstmt.setInt(1, seq);
				rs = pstmt.executeQuery();
				
				
				
				while(rs.next()) {
					
					boardDTO = new BoardDTO();
					
					boardDTO.setSeq(rs.getInt("seq"));
					boardDTO.setId(rs.getString("id"));
					boardDTO.setName(rs.getString("name"));
					boardDTO.setEmail(rs.getString("email"));
					boardDTO.setSubject(rs.getString("subject"));
					boardDTO.setContent(rs.getString("content"));
					boardDTO.setRef(rs.getInt("ref"));
					boardDTO.setLev(rs.getInt("lev"));
					boardDTO.setStep(rs.getInt("step"));
					boardDTO.setPseq(rs.getInt("pseq"));
					boardDTO.setReply(rs.getInt("reply"));
					boardDTO.setHit(rs.getInt("hit"));
					boardDTO.setLogtime(rs.getDate("logtime"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			
			return boardDTO;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
