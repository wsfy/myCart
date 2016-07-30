package com.hsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class ShowBook extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 先死后活
		
		out.println("<h1>欢迎购买</h1>");
		
		// 取出DB
		ArrayList<Book> mydb = DB.getDB();

		//访问一下session
		request.getSession();
		
		for (Book book : mydb) {
			String url = response.encodeURL("/myCart/BuyBookCl?id=" + book.getId());
			
			// 我希望href这样一种格式 href="/myCart/BuyBookCl?id=1&JSESSID=112333abaak"
			out.println(book.getName() + "<a href='" + url + "'>点击购买</a><br/>");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
