package org.next.model;

import javax.validation.constraints.NotNull;

public class Secretariat {
	@NotNull
	private String sec_id;

	@NotNull
	private String sec_pw;
	
	private String sec_name;
	private String sec_charge;
	private int year_competition;
	
	

	public Secretariat() {
	}

	public Secretariat(String sec_id, String sec_pw, String sec_name, String sec_charge, int year_competition) {
		this.sec_id = sec_id;
		this.sec_pw = sec_pw;
		this.sec_name = sec_name;
		this.sec_charge = sec_charge;
		this.year_competition = year_competition;
	}

	public Secretariat(String userId, String userPassword) {
		this(userId, userPassword, null, null, 0);
	}

	public String getSec_id() {
		return sec_id;
	}

	public void setSec_id(String sec_id) {
		this.sec_id = sec_id;
	}

	public String getSec_pw() {
		return sec_pw;
	}

	public void setSec_pw(String sec_pw) {
		this.sec_pw = sec_pw;
	}

	public String getSec_name() {
		return sec_name;
	}

	public void setSec_name(String sec_name) {
		this.sec_name = sec_name;
	}

	public String getSec_charge() {
		return sec_charge;
	}

	public void setSec_charge(String sec_charge) {
		this.sec_charge = sec_charge;
	}

	public int getYear_competition() {
		return year_competition;
	}

	public void setYear_competition(int year_competition) {
		this.year_competition = year_competition;
	}
}
