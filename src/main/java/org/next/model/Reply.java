package org.next.model;

import java.sql.Timestamp;
import java.util.Date;

public class Reply {
	private int id_reply;
	private String rep_writer;
	private String rep_comment;
	private Timestamp date;
	private int id_post;

	public Reply() {

	}

	public Reply(String rep_writer, String rep_comment) {
		this(0, rep_writer, rep_comment, null, 0);
	}
	
	public Reply(int id_reply, String rep_writer, String rep_comment) {
		this(id_reply, rep_writer, rep_comment, null, 0);
	}

	public Reply(int id_reply, String rep_writer, String rep_comment, Timestamp date, int id_post) {
		this.id_reply = id_reply;
		this.rep_writer = rep_writer;
		this.rep_comment = rep_comment;
		this.date = date;
		this.id_post = id_post;
	}

	public int getId_reply() {
		return id_reply;
	}

	public void setId_reply(int id_reply) {
		this.id_reply = id_reply;
	}

	public String getRep_writer() {
		return rep_writer;
	}

	public void setRep_writer(String rep_writer) {
		this.rep_writer = rep_writer;
	}

	public String getRep_comment() {
		return rep_comment;
	}

	public void setRep_comment(String rep_comment) {
		this.rep_comment = rep_comment;
	}

	public Timestamp getDate() {
		return date;
	}

	public long getTimeFromCreateDate() {
		return this.date.getTime();
	}

	@Override
	public String toString() {
		return "Reply [id_reply=" + id_reply + ", rep_writer=" + rep_writer + ", rep_comment=" + rep_comment + ", date="
				+ date + ", id_post=" + id_post + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id_post;
		result = prime * result + id_reply;
		result = prime * result + ((rep_comment == null) ? 0 : rep_comment.hashCode());
		result = prime * result + ((rep_writer == null) ? 0 : rep_writer.hashCode());
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
		Reply other = (Reply) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id_post != other.id_post)
			return false;
		if (id_reply != other.id_reply)
			return false;
		if (rep_comment == null) {
			if (other.rep_comment != null)
				return false;
		} else if (!rep_comment.equals(other.rep_comment))
			return false;
		if (rep_writer == null) {
			if (other.rep_writer != null)
				return false;
		} else if (!rep_writer.equals(other.rep_writer))
			return false;
		return true;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getId_post() {
		return id_post;
	}

	public void setId_post(int id_post) {
		this.id_post = id_post;
	}

}
