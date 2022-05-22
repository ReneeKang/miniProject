
package com.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(
		urlPatterns= {"*.do"}, 
		initParams= {@WebInitParam(name="propertyConfig", value="command.properties")})
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> map = new HashMap<String, Object>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String propertyConfig = config.getInitParameter("propertyConfig");
		System.out.println("propertyConfig = " + propertyConfig);
		
		//////////////
		// @애너테이션으로 등록하는거 
		String realFolder = config.getServletContext().getRealPath("/WEB-INF"); // c,d니가읽어와라
		String realPath = realFolder +"/"+ propertyConfig;
							//폴더    +	  파일명
		System.out.println("realPath = " + realPath);
		//////////////////////////////////////////////////////////
		
		
			
		FileInputStream fin = null;
		Properties properties = new Properties();
		
		try {
//			fin = new FileInputStream(propertyConfig);/////
			fin = new FileInputStream(realPath); //@WebServlet으로 등록해주고 경고 해줬으니까
			
						
			properties.load(fin);
			System.out.println("properties = "+properties);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		
		Iterator it = properties.keySet().iterator();
		while(it.hasNext()) {
			String key = (String)it.next();
			System.out.println("key = "+key);
			
			String className = properties.getProperty(key);
			System.out.println("className = "+className);
			
			try {
				Class<?> classType = Class.forName(className);
				Object ob = classType.newInstance();
				
				System.out.println("ob = "+ob);
				
				map.put(key, ob); //파일을 읽어서 map에 저장한다는것임!!!!!!!!
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} 
			
			System.out.println();
		}//while
	}//init
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("POST")){
			request.setCharacterEncoding("UTF-8");
		}
		
		//요청이 들어왔을 때 - http://localhost:8080/mvcmember/member/writeForm.do
		String category = request.getServletPath();
		System.out.println("category = "+category); //member/writeForm.do
		
		CommandProcess com = (CommandProcess)map.get(category); //member.service.WriteFormService
		String view = null;  	//map.get에서 읽어서!!! 그 키에맞는 밸류를 읽어오고 
		
		try {
			view = com.requestPro(request, response); //"/member/writeForm.jsp"
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		//forward
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);//상대번지
		dispatcher.forward(request, response);//제어권 넘기기
	}

}

