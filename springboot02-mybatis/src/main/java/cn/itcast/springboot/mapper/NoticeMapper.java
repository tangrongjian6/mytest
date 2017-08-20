package cn.itcast.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.itcast.springboot.domain.Notice;

@Mapper
public interface NoticeMapper {
	
	//查询所有公共
	@Select("SELECT * from notice")
	List<Notice> findAll();
	/** 查询总记录数 */
	Long count();
	/** 分页查询 */
	List<Notice> findByPage(@Param("page") int page,@Param("rows") Integer rows);
}
