package org.next.model;

import javax.validation.constraints.NotNull;

import org.apache.regexp.recompile;


public class Participant {
	@NotNull
	private String par_id;

	@NotNull
	private String par_pw;
	
	private String par_school;
	private String par_name;
	private int par_teamNum;
	
	

	public Participant() {
	}

	public Participant(String par_id, String par_pw, String par_name, String par_school, int par_teamNum) {
		this.par_id = par_id;
		this.par_pw = par_pw;
		this.par_name = par_name;
		this.par_school = par_school;
		this.par_teamNum = par_teamNum;
	}

	public Participant(String userId, String userPassword) {
		this(userId, userPassword, null, null, 0);
	}

	public String getPar_id() {
		return par_id;
	}

	public void setPar_id(String par_id) {
		this.par_id = par_id;
	}

	public String getPar_pw() {
		return par_pw;
	}

	public void setPar_pw(String par_pw) {
		this.par_pw = par_pw;
	}

	public String getPar_school() {
		return par_school;
	}

	public void setPar_school(String par_school) {
		this.par_school = par_school;
	}

	public String getPar_name() {
		return par_name;
	}

	public void setPar_name(String par_name) {
		this.par_name = par_name;
	}

	public int getPar_teamNum() {
		return par_teamNum;
	}

	public void setPar_teamNum(int par_teamNum) {
		this.par_teamNum = par_teamNum;
	}

	public boolean isSameUser(Participant participant) {
		return isSameUser(participant.getPar_id());
	}
	
	public boolean isSameUser(String newUserId) {
		return par_id.equals(newUserId);
	}

}
