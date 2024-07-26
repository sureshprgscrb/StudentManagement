package training.java.spring.webmvc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import training.java.spring.webmvc.bean.StudentBean;

public class rowMapperImpl implements RowMapper<StudentBean>
{

	@Override
	public StudentBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			StudentBean std = new StudentBean();
			std.setId(rs.getLong(1));
			std.setName(rs.getString(2));
			std.setDob(rs.getDate(3));
			std.setGender(rs.getString(4));
			std.setType(rs.getString(5));
			std.setCity(rs.getString(6));
			
			return std;
	}

}
