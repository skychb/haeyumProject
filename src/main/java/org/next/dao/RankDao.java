package org.next.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.next.model.Post;
import org.next.model.Rank;
import org.next.model.Reply;
import org.next.model.TeamRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RankDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public Rank find2016(){
		String sql = "select count(*) as count from competition inner join team_community on competition.year_competition = team_community.year_competition inner join post on team_community.team_id = post.team_id";
		RowMapper<Rank> rm = new RowMapper<Rank>(){
			@Override
			public Rank mapRow(ResultSet rs, int index) throws SQLException{
				return new Rank(rs.getInt("count"));
			}
		};
		return jdbcTemplate.queryForObject(sql, rm);
	}
	
	public List<TeamRank> findAll() {
		String sql = "select team_id, count(team_id) as count from post group by team_id order by count(team_id) desc;";
		RowMapper<TeamRank> rm = new RowMapper<TeamRank>() {
			@Override
			public TeamRank mapRow(ResultSet rs, int index) throws SQLException {

				return new TeamRank(rs.getInt("team_id"), rs.getInt("count"));
			}
		};
		return jdbcTemplate.query(sql, rm);
	}	
}
