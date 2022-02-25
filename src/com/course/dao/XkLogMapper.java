package com.course.dao;
import com.course.model.XkLog;
import com.course.model.XkLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface XkLogMapper {
	long countByExample(XkLogExample example);
	int deleteByExample(XkLogExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(XkLog record);
	int insertSelective(XkLog record);
	List<XkLog> selectByExample(XkLogExample example);
	XkLog selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") XkLog record, @Param("example") XkLogExample example);
	int updateByExample(@Param("record") XkLog record, @Param("example") XkLogExample example);
	int updateByPrimaryKeySelective(XkLog record);
	int updateByPrimaryKey(XkLog record);
}
