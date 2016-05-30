package org.next.model;

import java.sql.Timestamp;


public class Notice {
	@Override
	public String toString() {
		return "Notice [noticePost_id=" + noticePost_id + ", title=" + title + ", content=" + content + ", date=" + date
				+ ", team_id=" + team_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + noticePost_id;
		result = prime * result + team_id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notice other = (Notice) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (noticePost_id != other.noticePost_id)
			return false;
		if (team_id != other.team_id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	private int noticePost_id;
	private String title;
	private String content;
	private Timestamp date;
	private int team_id;
	
	public Notice(int noticePost_id, String title, String content, Timestamp date, int team_id){
		this.noticePost_id = noticePost_id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.team_id = team_id;
	}
	
	public Notice(){
		
	}
	
	public Notice(String title, String content){
		this(0, title, content, null, 0);
	}
	
	public int getNoticePost_id() {
		return noticePost_id;
	}

	public void setNoticePost_id(int noticePost_id) {
		this.noticePost_id = noticePost_id;
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

	public Timestamp getDate() {
		return date;
	}
	
	public long getTimeFromCreateDate() {
		return this.date.getTime();
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
}
