package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
	//일 처리 후 jsp파일(뷰페이지) return 												//throws Trowable 설정시 예외+ exception한것까지 다 잡음
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;
		
}
