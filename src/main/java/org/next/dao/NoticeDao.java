package org.next.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.next.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static NoticeDao noticeDao;

	
	public List<Notice> findAll() {
		String sql = "SELECT noticePost_id, title, date, team_id FROM notice";
		RowMapper<Notice> rm = new RowMapper<Notice>() {
			@Override
			public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {

				return new Notice(rs.getInt("noticePost_id"), rs.getString("title"), null,
						rs.getTimestamp("date"), rs.getInt("team_id"));
			}
		};
		return jdbcTemplate.query(sql, rm);
	}
	
	public void addNotice(Notice notice) {
		String sql = "INSERT INTO notice (noticePost_id, title, content, date) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, notice.getNoticePost_id(), notice.getTitle(), notice.getContent(),
				notice.getDate());
	}

	public Notice findNoticeById(int noticePost_id) {

		String sql = "SELECT noticePost_id, title, content, date, team_id FROM notice WHERE noticePost_id = ?";
		RowMapper<Notice> rm = new RowMapper<Notice>() {
			@Override
			public Notice mapRow(ResultSet rs, int index) throws SQLException {
				return new Notice(rs.getInt("noticePost_id"), rs.getString("title"), rs.getString("content"),
						rs.getTimestamp("date"), rs.getInt("team_id"));
			}
		};
		return jdbcTemplate.queryForObject(sql, rm, noticePost_id);

	}

	public static NoticeDao getInstance() {
		if (noticeDao == null) {
			noticeDao = new NoticeDao();
		}
		return noticeDao;
	}

}
