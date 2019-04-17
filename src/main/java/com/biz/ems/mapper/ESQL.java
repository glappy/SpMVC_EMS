package com.biz.ems.mapper;

import org.apache.ibatis.jdbc.SQL;

public class ESQL {
	public String ems_insert_sql() {
		SQL sql=new SQL()
				.INSERT_INTO("ems")
				.INTO_COLUMNS("id").INTO_VALUES("SEQ_EMS.NEXTVAL")
				.INTO_COLUMNS("from_email").INTO_VALUES("#{from_email}")
				.INTO_COLUMNS("to_email").INTO_VALUES("#{to_email}")
				.INTO_COLUMNS("s_subject").INTO_VALUES("#{s_subject}")
				.INTO_COLUMNS("s_content").INTO_VALUES("#{s_content}")
				.INTO_COLUMNS("s_file1").INTO_VALUES("#{s_file1}")
				.INTO_COLUMNS("s_file2").INTO_VALUES("#{s_file2}");
		return sql.toString();	
	}
	public String ems_update_sql() {
		SQL sql=new SQL()
				.UPDATE("ems")
				.SET("from_email=#{from_email}")
				.SET("to_email=#{to_email}")
				.SET("s_subject=#{s_subject}")
				.SET("s_content=#{s_content}")
				.SET("s_file1=#{s_file1}")
				.SET("s_file2=#{s_file2}")
				.WHERE("id=#{id}");
		return sql.toString();
	}
}