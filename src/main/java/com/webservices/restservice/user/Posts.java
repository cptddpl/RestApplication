package com.webservices.restservice.user;

public class Posts { 
	
	private String content;
	private int postid;
	private int Id;
	public int getId() {
		return Id;
	}
	public Posts(String content, int postid, int id) {
		super();
		this.content = content;
		this.postid = postid;
		this.Id = id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	public String getContent() {
		return content;
	}
	public int getPostid() {
		return postid;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public Posts() {}

}
