package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Transcript;

@Repository
public class TranscriptDAO {

	private JdbcTemplate jdbcTemplate;

	// DataSource를 JdbcTemplate에 Dependency Injection
	@Autowired
	public void setDataSource(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(name) from infomation";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
		// (sql query, return type)
	}

	// query and return a single object
	public Transcript getTranscript(int id) {
		// '?' = placeholder
		String sqlStatement = "select * from infomation where id =?";

								// (sql문, DB로 접근할 인자의 배열, 가져온 정보를 객체로 맵핑시키는 매쏘드)
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { id }, 
				new RowMapper<Transcript>() {

					@Override
					public Transcript mapRow(ResultSet rs, int rowNum) throws SQLException {

						Transcript transcript = new Transcript();
						transcript.setNumber((rs.getInt("number"))); // id에 해당되는 값을 int로 가져온다.
						transcript.setSubject(rs.getString("subject"));
						transcript.setYear((rs.getInt("year"))); 
						transcript.setSemester((rs.getInt("semester"))); 
						transcript.setCode(rs.getString("code"));
						transcript.setScore((rs.getInt("score"))); 
						transcript.setType(rs.getString("type"));
						transcript.setGrade(rs.getString("grade"));

						return transcript;
					}
				});
	}
	
	// query and return multiple object
	public List<Transcript> getTranscripts() {
		//String sqlStatement = "select * from infomation";
		String sqlStatement = "select distinct year from infomation";
								// (sql문, 가져온 정보를 객체로 맵핑시키는 매쏘드)
		return jdbcTemplate.query(sqlStatement, 
				new RowMapper<Transcript>() {

					@Override
					public Transcript mapRow(ResultSet rs, int rowNum) throws SQLException {

						Transcript transcript = new Transcript();
						transcript.setNumber((rs.getInt("number"))); // id에 해당되는 값을 int로 가져온다.
						transcript.setSubject(rs.getString("subject"));
						transcript.setYear((rs.getInt("year"))); 
						transcript.setSemester((rs.getInt("semester"))); 
						transcript.setCode(rs.getString("code"));
						transcript.setScore((rs.getInt("score"))); 
						transcript.setType(rs.getString("type"));
						transcript.setGrade(rs.getString("grade"));

						return transcript;
					}
				});
	}
	
	public List<Transcript> getAnalysis() {
		// '?' = placeholder
		String sqlStatement = "select year, semester, sum(score) from infomation group by year, semester order by year, semester";

 								// (sql문, DB로 접근할 인자의 배열, 가져온 정보를 객체로 맵핑시키는 매쏘드)
		return jdbcTemplate.query(sqlStatement,  new RowMapper<Transcript>() {

					@Override
					public Transcript mapRow(ResultSet rs, int rowNum) throws SQLException {

						Transcript transcript = new Transcript();
						transcript.setYear((rs.getInt("year"))); 
						transcript.setSemester((rs.getInt("semester"))); 
						transcript.setSum(rs.getInt("sum(score)"));

						return transcript;
					}
				});
	}

	public List<Transcript> getChoiceSemesterTranscripts(int year, int id) {
		//String sqlStatement = "select * from infomation";
		String sqlStatement = "select year, semester, code, subject, type, score from infomation where year = ? and semester = ?";
								// (sql문, 가져온 정보를 객체로 맵핑시키는 매쏘드)
		return jdbcTemplate.query(sqlStatement, new Object[] { year, id }, 
				new RowMapper<Transcript>() {
					@Override
					public Transcript mapRow(ResultSet rs, int rowNum) throws SQLException {

						Transcript transcript = new Transcript();
						transcript.setSubject(rs.getString("subject"));
						transcript.setYear((rs.getInt("year"))); 
						transcript.setSemester((rs.getInt("semester"))); 
						transcript.setCode(rs.getString("code"));
						transcript.setScore((rs.getInt("score"))); 
						transcript.setType(rs.getString("type"));

						return transcript;
					}
				});
	}
	
	
	public boolean insert(Transcript transcript)	{
		
		String subject = transcript.getSubject();
		int year = transcript.getYear();
		int semester = transcript.getSemester();
		String code = transcript.getCode();
		int score = transcript.getScore();
		String type = transcript.getType();
		
		String sqlStatement = "insert into infomation(subject, year, semester, code, score, type) values (?, ?, ?, ?, ?, ?)";
		
		
		return jdbcTemplate.update(sqlStatement, new Object[] {subject, year, semester, code, score, type}) == 1;
	}
	
}
