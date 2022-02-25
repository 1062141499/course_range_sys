package com.course.dao;
import com.course.model.CourseApply;
import com.course.model.CourseApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface CourseApplyMapper {
	long countByExample(CourseApplyExample example);
	int deleteByExample(CourseApplyExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(CourseApply record);
	int insertSelective(CourseApply record);
	List<CourseApply> selectByExample(CourseApplyExample example);
	CourseApply selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") CourseApply record, @Param("example") CourseApplyExample example);
	int updateByExample(@Param("record") CourseApply record, @Param("example") CourseApplyExample example);
	int updateByPrimaryKeySelective(CourseApply record);
	int updateByPrimaryKey(CourseApply record);
}
