package com.hsp;

public class Book implements java.io.Serializable {

	private String id;
	private String name;
	private int num;
	private float price;
	private String writer;
	private String publishouse;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublishouse() {
		return publishouse;
	}
	public void setPublishouse(String publishouse) {
		this.publishouse = publishouse;
	}
	
}
