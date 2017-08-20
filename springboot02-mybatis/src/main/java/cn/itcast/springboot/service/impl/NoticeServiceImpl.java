package cn.itcast.springboot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.springboot.domain.Notice;
import cn.itcast.springboot.mapper.NoticeMapper;
import cn.itcast.springboot.service.NoticeService;
@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper noticeMapper;
	@Override
	public List<Notice> findAll() {
		
		return noticeMapper.findAll();
	}
	@Override
	public Map<String, Object> findByPage(Integer page, Integer rows) {
		// {"total": 30, "rows" : [{},{}]}
		/** 查询总记录数 */
		Long total = noticeMapper.count();
		//分页查询
		List<Notice> notices= noticeMapper.findByPage((page-1)*rows,rows);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total", total);
		data.put("rows", notices);
		return data;
	}

}
