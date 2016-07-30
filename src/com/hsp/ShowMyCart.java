package com.hsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowMyCart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 从session中取出看购买的数
		HashMap<String, Book> myBooks = (HashMap<String, Book>) request.getSession().getAttribute("mybooks");
		
		out.println("你的购物车有以下书籍：<br/>");
		
		// 遍历HashMap
		Iterator iterator = myBooks.keySet().iterator();
		
		while (iterator.hasNext()) {
			
			String key = (String) iterator.next();
			
			Book book = myBooks.get(key);
			out.println(book.getName() + " " + book.getNum() + "<br/>");
			
		}
		out.println("购物车的总价格是 900");
		
		// 这里我们也需要URL地址重写
		String url = response.encodeURL("/myCart/ShowBook");
		
		out.println("<a href='" + url + "'>返回购物大厅</a>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
