package com.aidenoo.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aidenoo.data.dao.PersonnelDAO;
import com.aidenoo.data.model.Personnel;


class PersonnelMapper implements RowMapper<Personnel> {

	@Override
	public Personnel mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Personnel(
				rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
				rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),
				rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17), rs.getString(18),
				rs.getString(19), rs.getInt(20));
	}
	
}

@Repository
public class PersonnelJDBC implements PersonnelDAO {
	private static final String CREATE_QUERY = "INSERT INTO personnel (id, nom, prenom, num_rue, rue, compl_rue, codepost, ville, pays, "
				+ "localisation, portable, email, nationalite, num_ss, age, garde, diplomes, competences, "
				+ "observations, specialisation) "
				+ "VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?)";
	
	private static final String DELETE_QUERY = "DELETE FROM personnel WHERE id=?";
	private static final String UPDATE_QUERY = "UPDATE personnel SET id=?, nom=?, prenom=?, num_rue=?, rue=?, compl_rue=?, codepost=?, ville=?, pays=?, "
				+ "localisation=?, portable=?, email=?, nationalite=?, num_ss=?, age=?, garde=?, diplomes=?, competences=?, "
				+ "observations=?, specialisation=?";
	
	private static final String _QUERY_ONCE_ = "SELECT * FROM personnel WHERE id=";
	private static final String _SELECT_ALL_ = "SELECT * FROM personnel";
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public PersonnelJDBC() { super(); }

	@Override
	public boolean create(Personnel p) {
		int res = jdbcTemplate.update(CREATE_QUERY, new Object[] {
				p.getId(), p.getNom(), p.getPrenom(), p.getNum_rue(), p.getRue(), p.getCompl_rue(),
				p.getCodepost(), p.getVille(), p.getPays(), p.getLocalisation(), p.getPortable(), p.getEmail(),
				p.getNationalite(), p.getNum_ss(), p.getAge(), p.getGarde(), p.getDiplomes(), p.getCompetences(),
				p.getObservations(), p.getSpecialisation()
		});
		
		return res > 0; 
	}

	@Override
	public Personnel search(String id) {
		final String SQL_QUERY = _QUERY_ONCE_ + "'"+id+"'";
		List<Personnel> personnels = jdbcTemplate.query(SQL_QUERY, new PersonnelMapper());
		
		return personnels.get(0);
	}

	@Override
	public boolean update(Personnel p) {
		int res = jdbcTemplate.update(UPDATE_QUERY, p.getId());
		
		return res > 0;
	}

	@Override
	public boolean delete(Personnel p) {
		int res = jdbcTemplate.update(DELETE_QUERY, p.getId());
		
		return res > 0;
	}

	@Override
	public List<Personnel> read() {
		return jdbcTemplate.query(_SELECT_ALL_, new PersonnelMapper());
	}

}
