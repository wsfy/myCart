package com.hsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuyBookCl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 接收用户购买书的名字
		
		
		String id = request.getParameter("id");
		Book bookinfo = DB.getBookById(id);
		HttpSession session = request.getSession();
		
		
		// 从session中取出mybooks
		HashMap<String, Book> hm = (HashMap<String, Book>) session.getAttribute("mybooks");
		// 如果是第一次购物 al = null
		if (hm == null) {
			
			hm = new LinkedHashMap<String, Book>();
			// 集合三大类 list set map
			// 构建一个Book对象
			Book book = new Book();
			book.setId(id);
			book.setName(bookinfo.getName());
			book.setNum(1);
			hm.put(id, book);
			// 把al放入到session
			session.setAttribute("mybooks", hm);
		} else {
			
			// 判断hm是否有该书
			if (hm.containsKey(id)) {
				// 表示书购买过一次
				// 取出
				Book book = hm.get(id);
				int bookNum = book.getNum();
				book.setNum(bookNum + 1);
			} else {
				Book book = new Book();
				book.setId(id);
				book.setName(bookinfo.getName());
				book.setNum(1);
				hm.put(id, book);
			}
			// 更新
			session.setAttribute("mybooks", hm);
		}
		
		
		
		
		session.setAttribute("mybooks", hm);
		
		// 跳转到显示购物车的页面
		request.getRequestDispatcher("/ShowMyCart").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
