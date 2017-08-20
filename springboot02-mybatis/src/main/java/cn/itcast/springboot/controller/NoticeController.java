package cn.itcast.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.springboot.domain.Notice;
import cn.itcast.springboot.service.NoticeService;

@RestController
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	//查询总信息
	@GetMapping("/findAll")
	public List<Notice> findAll(){
		return noticeService.findAll();	
	}
	
	//分页查询信息
	@PostMapping("/findByPage")
	public Map<String, Object> findByPage(@RequestParam(value="page",defaultValue="1") Integer page,@RequestParam(value="rows",defaultValue="15") Integer rows){
		
		// {"total": 30, "rows" : [{},{}]}
		Map<String, Object> map = noticeService.findByPage(page, rows);
		System.out.println("打印了+++"+map);
		return noticeService.findByPage(page,rows);
	}
	
	
	
}
