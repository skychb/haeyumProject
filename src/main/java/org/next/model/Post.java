package org.next.model;

import java.util.Date;

public class Post {
	private int id_post;

	private String title;
	private String content;
	private Date date;
	private String writer;
	private int team_id;
	

	public Post() {
	}

	public Post(String title, String content, String writer) {
		this(0, title, content, new Date(), writer, 0);
	}

	public int getId_post() {
		return id_post;
	}

	public void setId_post(int id_post) {
		this.id_post = id_post;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	
	public long getTimeFromCreateDate() {
		return this.date.getTime();
	}
	
	public void update(Post newPost) {
		this.title = newPost.title;
		this.content = newPost.content;
	}
	
	public Post(int id_post, String title, String content, Date date, String writer, int team_id) {
		this.id_post = id_post;
		this.title = title;
		this.content = content;
		this.date = date;
		this.writer = writer;
		this.team_id = team_id;
	}
}
