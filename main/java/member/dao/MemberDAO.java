package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;

public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory;

	public MemberDAO() {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
}	
	
	//회원가입
	public int write(MemberDTO memberDTO) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su= sqlSession.insert("memberSQL.write",memberDTO);
		sqlSession.commit();
		sqlSession.close();
		
		
		return su;
	}
	
	
	public boolean isExistId(String id) {
		boolean exist=false; //이미 존재하면 true 아니면 false
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.isExistId",id);
		sqlSession.close();
		
		if(memberDTO!=null)
			exist=true;
			
		return exist;
	}

	
	
	// 회원정보 수정(내정보 가져오기)
	public MemberDTO getUserInfo(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.getUserInfo",id);
		System.out.println("userDTO = " + memberDTO);
		sqlSession.close();
				
		System.out.print("memberDTO= "+memberDTO.toString());
	
		return memberDTO;
	}
	
	
	// 회원정보 업데이트
	public void updateUserInfo(MemberDTO memberDTO) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("memberSQL.updateUserInfo",memberDTO); 
		sqlSession.commit();
		sqlSession.close();
	}

	//로그인
	public MemberDTO loginCheckPlusEmail(Map map) {
			System.out.println(map.get("id"));
			System.out.println(map.get("pwd"));
		
			SqlSession sqlSession = sqlSessionFactory.openSession();
			MemberDTO memberDTO = sqlSession.selectOne("memberSQL.loginCheckPlusEmail",map);
			System.out.println("login id + email = " + memberDTO);
			sqlSession.close();
		
		return memberDTO;
	}
	
}
