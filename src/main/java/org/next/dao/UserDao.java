package org.next.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.next.model.Participant;
import org.next.model.Secretariat;
import org.next.model.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static UserDao userDao;

	public Participant findUserById(String userId) throws UserNotFoundException {
		try {
			String sql = "SELECT par_id, par_pw, par_name, par_school, par_teamNum FROM participant WHERE par_id = ?";
			RowMapper<Participant> rm = new RowMapper<Participant>() {
				public Participant mapRow(ResultSet rs, int index) throws SQLException {

					return new Participant(rs.getString("par_id"), rs.getString("par_pw"), rs.getString("par_name"), rs.getString("par_school"),
							rs.getInt("par_teamNum"));
				}
			};
			return jdbcTemplate.queryForObject(sql, rm, userId);
		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException();
		}
	}
	
	public Secretariat findSecretariatById(String userId) throws UserNotFoundException {
		try {
			String sql = "SELECT sec_id, sec_pw, sec_name, sec_charge, year_competition FROM secretariat WHERE sec_id = ?";
			RowMapper<Secretariat> rm = new RowMapper<Secretariat>() {
				public Secretariat mapRow(ResultSet rs, int index) throws SQLException {

					return new Secretariat(rs.getString("sec_id"), rs.getString("sec_pw"), rs.getString("sec_name"), rs.getString("sec_charge"),
							rs.getInt("year_competition"));
				}
			};
			return jdbcTemplate.queryForObject(sql, rm, userId);
		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException();
		}
	}
	
	public List<Participant> findAll(){
		String sql = "SELECT par_id, par_pw, par_name, par_school, par_teamNum FROM participant";
		RowMapper<Participant> rm = new RowMapper<Participant>() {
			public Participant mapRow(ResultSet rs, int index) throws SQLException {

				return new Participant(rs.getString("par_id"), rs.getString("par_pw"), rs.getString("par_name"), rs.getString("par_school"),
						rs.getInt("par_teamNum"));
			}
		};
		return jdbcTemplate.query(sql, rm);
	}
	
	public static UserDao getInstance() {
		if (userDao == null) {
			userDao = new UserDao();
		}
		return userDao;
	}

}
