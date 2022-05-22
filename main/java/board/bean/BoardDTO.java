package board.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class BoardDTO {
	
	private int seq;	//글번호
	@NonNull
	private String id;	
	@NonNull
	private String name;	
	@NonNull
	private String email;
	private String subject;	//제목
	private String content;	//내용
	
	private int ref; //그룹번호(글번호랑 똑같은값들어가도록)
	private int lev;	//단계
	private int step;	//글 순서
	private int pseq;	//원글번호
	private int reply;	//답변수

	private int hit;	//조회수
//	private String logtime;
	private Date logtime;
}
