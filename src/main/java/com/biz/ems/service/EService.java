package com.biz.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.ems.mapper.EDao;
import com.biz.ems.model.EVO;

@Service
public class EService {
	@Autowired
	EDao edao;
	
	public int insert(EVO evo) {
		return edao.insert(evo);
	}
	public List<EVO> selectAll(){
		return edao.selectAll();
	}
	public EVO findById(long id) {
		return edao.findById(id);
	}
	public int delete(long id) {
		return edao.delete(id);
	}
	public int update(EVO evo) {
		return edao.update(evo);
	}
}
