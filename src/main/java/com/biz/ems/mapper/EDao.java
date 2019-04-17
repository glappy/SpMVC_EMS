package com.biz.ems.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.ems.model.EVO;

public interface EDao {
	@Select("select * from ems")
	public List<EVO> selectAll();
	@Select("select * from ems where id=#{id]")
	public EVO findById(long id);
	@Select("select * from ems where from_email=#{from_email}")
	public List<EVO> selectByFromMail();
	@InsertProvider(type=ESQL.class,method="ems_insert_sql")
	public int insert(EVO evo);
	@UpdateProvider(type=ESQL.class,method="ems_update_sql")
	public int update(EVO evo);
	@Delete("delete from ems where id=#{id}")
	public int delete(long id);
}
