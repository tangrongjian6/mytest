package cn.itcast.springboot.service;

import java.util.List;
import java.util.Map;

import cn.itcast.springboot.domain.Notice;

public interface NoticeService {
	//查询所有公共
	List<Notice> findAll();

	Map<String, Object> findByPage(Integer page, Integer rows);
}
