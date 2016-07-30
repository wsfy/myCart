package com.hsp;

import java.util.ArrayList;

// 用ArrayList模拟一个内存数据库
final public class DB {

	private static ArrayList al = null;
	
	private DB() {
		
	}
	
	static {
		
		al = new ArrayList<Book>();
		Book book1 = new Book();
		book1.setId("1");
		book1.setName("java");
		book1.setPrice(23.4f);
		
		Book book2 = new Book();
		book2.setId("2");
		book2.setName("Oracle");
		
		Book book3 = new Book();
		book3.setId("3");
		
		book3.setName("Linux");
		
		Book book4 = new Book();
		book4.setId("4");
		
		book4.setName("servlet");
		
		al.add(book1);
		al.add(book2);
		al.add(book3);
		al.add(book4);
		System.out.println("----------zhixingle???");

		
	}
	
	public static ArrayList getDB(){
		return al;
	}
	
	public static Book getBookById(String id) {
		System.out.println("id=" + id);
		Book book = null;
		boolean b = false;
		for (int i = 0; i < al.size(); i++) {
			book = (Book) al.get(i);
			if (book.getId().equals(id)) {
				b = true;
				break;
				
			 }
			 
		} 
		if (b) {
			return book;
		} else {
			return null;
		}
	
	}
	
}
