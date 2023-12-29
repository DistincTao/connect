package kr.co.distinctao.daoExam.dao;

import static kr.co.distinctao.daoExam.dao.RoleDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.co.distinctao.daoExam.dto.RoleDto;


@Repository
public class RoleDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<RoleDto> rowMapper = BeanPropertyRowMapper.newInstance(RoleDto.class);
	
	public RoleDao(DataSource dataSource) {
			this.jdbc = new NamedParameterJdbcTemplate(dataSource);
			this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("role");
	}
	
	public List<RoleDto> selectAll(){
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}
	
	public int insert(RoleDto dto) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(dto);
		return insertAction.execute(params);
	}
	
	public int update (RoleDto dto) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(dto);
		return jdbc.update(UPDATE, params);
	}
	
	public RoleDto selectById (Integer id) {
		try {
			Map <String, ? > params = Collections.singletonMap("roleId", id);
			return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int deleteById(Integer id) {
		Map <String, ?> params = Collections.singletonMap("roleId", id);
		return jdbc.update(DELETE_BY_ROLE_ID, params);
	}
}
