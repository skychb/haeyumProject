package org.next.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.next.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class PostDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private static PostDao postDao;

	
	public List<Post> findAll() {
		String sql = "SELECT id_post, title, content, date, writer, team_id FROM post";
		RowMapper<Post> rm = new RowMapper<Post>() {
			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {

				return new Post(rs.getInt("id_post"), rs.getString("title"), null,
						rs.getTimestamp("date"), rs.getString("writer"), rs.getInt("id_board"));
			}
		};
		return jdbcTemplate.query(sql, rm);
	}
	
//	public void addPost(Post post) {
//		String sql = "INSERT INTO post (id_post, title, content, date, writer, team_id) VALUES (?, ?, ?, ?, ?, ?)";
//		jdbcTemplate.update(sql, post.getId_post(), post.getTitle(), post.getContent(),
//				post.getDate(), post.getWriter(), post.getTeam_id());
//	}
	
	public void addPost(Post post) {
		String sql = "CALL regularInsert(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, post.getId_post(), post.getTitle(), post.getContent(),
				post.getDate(), post.getWriter(), post.getTeam_id());
	}

	public List<Post> findPostByTeamId(int team_id) {
		String sql = "SELECT id_post, title, content, date, writer, team_id FROM post WHERE team_id = ?";
		RowMapper<Post> rm = new RowMapper<Post>() {
			@Override
			public Post mapRow(ResultSet rs, int index) throws SQLException {

				return new Post(rs.getInt("id_post"), rs.getString("title"), null,
						rs.getTimestamp("date"), rs.getString("writer"), rs.getInt("team_id"));
			}
		};
		return jdbcTemplate.query(sql, rm, team_id);
	}
	
	public Post findPostById(int id_post) {
		String sql = "SELECT id_post, title, content, date, writer, team_id FROM post WHERE id_post = ?";
		RowMapper<Post> rm = new RowMapper<Post>() {
			@Override
			public Post mapRow(ResultSet rs, int index) throws SQLException {

				return new Post(rs.getInt("id_post"), rs.getString("title"), rs.getString("content"),
						rs.getTimestamp("date"), rs.getString("writer"), rs.getInt("team_id"));
			}
		};
		return jdbcTemplate.queryForObject(sql, rm, id_post);

	}

	public void update(Post post) {
		String sql = "UPDATE post set title = ?, content = ? WHERE id_post = ?";
        jdbcTemplate.update(sql, 
        		post.getTitle(),
                post.getContent(),
                post.getId_post());
	}

	public void delete(int id_post) {
		String sql = "DELETE FROM post WHERE id_post = ?";
		jdbcTemplate.update(sql, id_post);
	}
	
	public static PostDao getInstance() {
		if (postDao == null) {
			postDao = new PostDao();
		}
		return postDao;
	}
}
