package org.next.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.next.model.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class ReplyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static ReplyDao replyDao;

	public void insert(Reply reply) throws SQLException{
		String sql = "INSERT INTO REPLY (rep_writer, rep_comment, id_post) values (?, ?, ?)";
		jdbcTemplate.update(sql, reply.getRep_writer(), reply.getRep_comment(), reply.getId_post());
	}

	public List<Reply> findAllByPostId(int id_post){
		String sql = "SELECT id_reply, rep_writer, rep_comment, date, id_post FROM REPLY WHERE id_post = ? ";

		RowMapper<Reply> rm = new RowMapper<Reply>() {
			@Override
			public Reply mapRow(ResultSet rs, int index) throws SQLException {
				return new Reply(rs.getInt("id_reply"), rs.getString("rep_writer"), rs.getString("rep_comment"),
						rs.getTimestamp("date"), id_post);
			}
		};
		return jdbcTemplate.query(sql, rm, id_post);
	}
	
	public Reply findAllById(int id_reply){
		String sql = "SELECT id_reply, rep_writer, rep_comment, date, id_post FROM REPLY WHERE id_post = ? ";

		RowMapper<Reply> rm = new RowMapper<Reply>() {
			@Override
			public Reply mapRow(ResultSet rs, int index) throws SQLException {
				return new Reply(rs.getInt("id_reply"), rs.getString("rep_writer"), rs.getString("rep_comment"));
			}
		};
		return jdbcTemplate.queryForObject(sql, rm, id_reply);
	}
	
	public void delete(int id_reply) {
		String sql = "DELETE FROM reply WHERE id_reply = ?";
		jdbcTemplate.update(sql, id_reply);
	}
}
