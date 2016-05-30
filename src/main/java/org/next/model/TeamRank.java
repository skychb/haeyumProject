package org.next.model;

public class TeamRank {
	private int team_id;
	private int count;

	public TeamRank() {
	}

	public TeamRank(int team_id, int count){
		this.team_id = team_id;
		this.count = count;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
