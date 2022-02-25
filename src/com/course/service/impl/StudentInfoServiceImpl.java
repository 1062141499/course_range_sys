package com.course.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.course.dao.*;
import com.course.model.*;
import com.course.service.*;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import com.course.util.*;
import org.springframework.ui.ModelMap;
import java.util.*;
import com.course.service.*;
import com.course.controller.LoginModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Service
public class StudentInfoServiceImpl implements StudentInfoService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	TermInfoMapper termInfoMapper;
	@Autowired
	ClassInfoMapper classInfoMapper;
	@Autowired
	StudentInfoMapper studentInfoMapper;
	@Autowired
	MajorInfoMapper majorInfoMapper;
	@Autowired
	MajorDirectInfoMapper majorDirectInfoMapper;
	/**
	新增
	*/
	@Override
	public String add(StudentInfo model,LoginModel login){
		if(model.getStuNo()==null||model.getStuNo().equals("")){
			return "学号为必填属性";
		}
		if(model.getStuNo()!=null){
			StudentInfoExample te=new StudentInfoExample();
			StudentInfoExample.Criteria tc=te.createCriteria();
			tc.andStuNoEqualTo(model.getStuNo());
			int count = (int)studentInfoMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 学号 ,请重新填写";
			}
		}
		if(model.getPassword()==null||model.getPassword().equals("")){
			return "密码为必填属性";
		}
		if(model.getSex()==null){
			return "性别为必填属性";
		}
		if(model.getRealName()==null||model.getRealName().equals("")){
			return "姓名为必填属性";
		}
		if(model.getMajorId()==null){
			return "所属学科为必填属性";
		}
		if(model.getDirectId()==null){
			return "方向为必填属性";
		}
		if(model.getClassId()==null){
			return "班级为必填属性";
		}
		if(model.getCelPhone()==null||model.getCelPhone().equals("")){
			return "联系电话为必填属性";
		}
		if(model.getCelPhone()!=null){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(model.getCelPhone());
			if( m.matches()==false){
				return "请输入正确的联系电话";
			}
		}
		if(model.getEnterYear()==null){
			return "入学年份为必填属性";
		}
		if(model.getTermId()==null){
			return "学期id为必填属性";
		}
		if(model.getFamilyAddress()==null||model.getFamilyAddress().equals("")){
			return "家庭住址为必填属性";
		}
		if(model.getParentCel()==null||model.getParentCel().equals("")){
			return "家长联系方式为必填属性";
		}
		model.setCreateTime(sdf1.format(new Date()));//当前时间格式
		studentInfoMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(StudentInfo model,LoginModel login){
		StudentInfo preModel = studentInfoMapper.selectByPrimaryKey(model.getId());
		if(model.getStuNo()==null||model.getStuNo().equals("")){
			return "学号为必填属性";
		}
		if(model.getStuNo()!=null){
			StudentInfoExample te=new StudentInfoExample();
			StudentInfoExample.Criteria tc=te.createCriteria();
			tc.andStuNoEqualTo(model.getStuNo());
			tc.andIdNotEqualTo(model.getId());
			int count = (int)studentInfoMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 学号 ,请重新填写";
			}
		}
		if(model.getPassword()==null||model.getPassword().equals("")){
			return "密码为必填属性";
		}
		if(model.getSex()==null){
			return "性别为必填属性";
		}
		if(model.getRealName()==null||model.getRealName().equals("")){
			return "姓名为必填属性";
		}
		if(model.getMajorId()==null){
			return "所属学科为必填属性";
		}
		if(model.getDirectId()==null){
			return "方向为必填属性";
		}
		if(model.getClassId()==null){
			return "班级为必填属性";
		}
		if(model.getCelPhone()==null||model.getCelPhone().equals("")){
			return "联系电话为必填属性";
		}
		if(model.getCelPhone()!=null){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(model.getCelPhone());
			if( m.matches()==false){
				return "请输入正确的联系电话";
			}
		}
		if(model.getEnterYear()==null){
			return "入学年份为必填属性";
		}
		if(model.getTermId()==null){
			return "学期id为必填属性";
		}
		if(model.getFamilyAddress()==null||model.getFamilyAddress().equals("")){
			return "家庭住址为必填属性";
		}
		if(model.getParentCel()==null||model.getParentCel().equals("")){
			return "家长联系方式为必填属性";
		}
		preModel.setStuNo(model.getStuNo());
		preModel.setPassword(model.getPassword());
		preModel.setSex(model.getSex());
		preModel.setRealName(model.getRealName());
		preModel.setMajorId(model.getMajorId());
		preModel.setDirectId(model.getDirectId());
		preModel.setClassId(model.getClassId());
		preModel.setCelPhone(model.getCelPhone());
		preModel.setEnterYear(model.getEnterYear());
		preModel.setTermId(model.getTermId());
		preModel.setFamilyAddress(model.getFamilyAddress());
		preModel.setParentCel(model.getParentCel());
		studentInfoMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询学生列表数据
	*/
	@Override
	public Map<String,Object> getDataList(StudentInfo queryModel,Integer page,Integer pageSize,LoginModel login) {
		StudentInfoExample se = new StudentInfoExample();
		StudentInfoExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getStuNo()!=null&&queryModel.getStuNo().equals("")==false){
			sc.andStuNoLike("%"+queryModel.getStuNo()+"%");//模糊查询
		}
		if(queryModel.getRealName()!=null&&queryModel.getRealName().equals("")==false){
			sc.andRealNameLike("%"+queryModel.getRealName()+"%");//模糊查询
		}
		if(queryModel.getMajorId()!=null){
			sc.andMajorIdEqualTo(queryModel.getMajorId());//查询所属学科等于指定值
		}
		if(queryModel.getClassId()!=null){
			sc.andClassIdEqualTo(queryModel.getClassId());//查询班级等于指定值
		}
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		int count = (int)studentInfoMapper.countByExample(se);
		int totalPage = 0;
		if(page!=null&&pageSize!=null){//分页
			if ((count > 0) && ((count % pageSize) == 0)) {
				totalPage = count / pageSize;
			} else {
				totalPage = (count / pageSize) + 1;
			}
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<StudentInfo> list = studentInfoMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(StudentInfo model:list){
			list2.add(getStudentInfoModel(model,login));
		}
		rs.put("list",list2);//数据列表
		rs.put("count",count);//数据总数
		rs.put("totalPage",totalPage);//总页数
		return rs;
	}
	/**
	封装学生为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getStudentInfoModel(StudentInfo model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("studentInfo",model);
		map.put("sexStr",DataListUtils.getSexNameById(model.getSex()+""));//解释性别字段
		if(model.getMajorId()!=null){
			MajorInfo majorInfo = majorInfoMapper.selectByPrimaryKey(model.getMajorId());//所属学科为外接字段，需要关联专业来解释该字段
			if(majorInfo!=null){
				map.put("majorIdStr",majorInfo.getMajorName());
			}
		}
		if(model.getDirectId()!=null){
			MajorDirectInfo majorDirectInfo = majorDirectInfoMapper.selectByPrimaryKey(model.getDirectId());//方向为外接字段，需要关联专业方向来解释该字段
			if(majorDirectInfo!=null){
				map.put("directIdStr",majorDirectInfo.getDirectName());
			}
		}
		if(model.getClassId()!=null){
			ClassInfo classInfo = classInfoMapper.selectByPrimaryKey(model.getClassId());//班级为外接字段，需要关联班级来解释该字段
			if(classInfo!=null){
				map.put("classIdStr",classInfo.getClassName());
			}
		}
		if(model.getTermId()!=null){
			TermInfo termInfo = termInfoMapper.selectByPrimaryKey(model.getTermId());//学期id为外接字段，需要关联学期来解释该字段
			if(termInfo!=null){
				map.put("termIdStr",termInfo.getTermName());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		studentInfoMapper.deleteByPrimaryKey(id);
	}
	/**
	**导入学生数据，根据传入的excel，得到传入数据，然后做值的校验并导入系统
	*/
	@Override
	public String importData(InputStream is,String fileName,LoginModel login,StudentInfo pageModel){
		String result="";
		ExcelUtil eu = new ExcelUtil();
		eu.setStartReadPos(1);//定位读取excel的第一行
		List<Map<Integer,Object>> list = eu.readExcelData(is, fileName);//读取excel数据到list中
		List<StudentInfo> addList = new ArrayList<StudentInfo>();
		for(int i=0;i<list.size();i++){
			Map<Integer,Object> m = list.get(i);
			StudentInfo model = new StudentInfo();
			//默认赋值
			model.setCreateTime(sdf1.format(new Date()));//当前时间格式
			Object val1 = m.get(1);//字段:学号
			if(val1==null||val1.toString().trim().equals("")){
				return "第"+(i+1)+"行数据中，学号不能为空";
			}
			if(val1!=null&&val1.toString().trim().equals("")==false){
				model.setStuNo(val1.toString().trim());
			}
			Object val2 = m.get(2);//字段:密码
			if(val2==null||val2.toString().trim().equals("")){
				return "第"+(i+1)+"行数据中，密码不能为空";
			}
			if(val2!=null&&val2.toString().trim().equals("")==false){
				model.setPassword(val2.toString().trim());
			}
			Object val3 = m.get(3);//字段:性别
			if(val3==null||val3.toString().trim().equals("")){
				return "第"+(i+1)+"行数据中，性别不能为空";
			}
			if(val3!=null){
				String tmpStr = val3.toString();
				if(tmpStr.equals("")==false){
					List<Map<String,Object>> dlist = DataListUtils.getSexList();//查询sex数据列表
					for(Map<String,Object> dm:dlist){
						if(tmpStr.equals(dm.get("name").toString())){
							model.setSex(Integer.parseInt(dm.get("id").toString()));
						}
					}
				}
			}
			Object val4 = m.get(4);//字段:姓名
			if(val4==null||val4.toString().trim().equals("")){
				return "第"+(i+1)+"行数据中，姓名不能为空";
			}
			if(val4!=null&&val4.toString().trim().equals("")==false){
				model.setRealName(val4.toString().trim());
			}
			Object val5 = m.get(5);//字段:所属学科
			if(val5==null||val5.toString().trim().equals("")){
				return "第"+(i+1)+"行数据中，所属学科不能为空";
			}
			if(val5!=null){
				String tmpStr = val5.toString();
				if(tmpStr.equals("")==false){
					MajorInfoExample te = new MajorInfoExample();
					MajorInfoExample.Criteria tc = te.createCriteria();
					tc.andMajorNameEqualTo(tmpStr.trim());
					List<MajorInfo> tl = majorInfoMapper.selectByExample(te);//查询专业是否存在该数据
					if(tl.size()==1){
						model.setMajorId(tl.get(0).getId());//
					}
				}
			}
			Object val6 = m.get(6);//字段:方向
			if(val6==null||val6.toString().trim().equals("")){
				return "第"+(i+1)+"行数据中，方向不能为空";
			}
			if(val6!=null){
				String tmpStr = val6.toString();
				if(tmpStr.equals("")==false){
					MajorDirectInfoExample te = new MajorDirectInfoExample();
					MajorDirectInfoExample.Criteria tc = te.createCriteria();
					tc.andDirectNameEqualTo(tmpStr.trim());
					List<MajorDirectInfo> tl = majorDirectInfoMapper.selectByExample(te);//查询专业方向是否存在该数据
					if(tl.size()==1){
						model.setDirectId(tl.get(0).getId());//
					}
				}
			}
			Object val7 = m.get(7);//字段:班级
			if(val7==null||val7.toString().trim().equals("")){
				return "第"+(i+1)+"行数据中，班级不能为空";
			}
			if(val7!=null){
				String tmpStr = val7.toString();
				if(tmpStr.equals("")==false){
					ClassInfoExample te = new ClassInfoExample();
					ClassInfoExample.Criteria tc = te.createCriteria();
					tc.andClassNameEqualTo(tmpStr.trim());
					List<ClassInfo> tl = classInfoMapper.selectByExample(te);//查询班级是否存在该数据
					if(tl.size()==1){
						model.setClassId(tl.get(0).getId());//
					}
				}
			}
			Object val8 = m.get(8);//字段:联系电话
			if(val8==null||val8.toString().trim().equals("")){
				return "第"+(i+1)+"行数据中，联系电话不能为空";
			}
			if(val8!=null&&val8.toString().trim().equals("")==false){
				model.setCelPhone(val8.toString().trim());
			}
			Object val9 = m.get(9);//字段:入学年份
			if(val9==null||val9.toString().trim().equals("")){
				return "第"+(i+1)+"行数据中，入学年份不能为空";
			}
			if(val9!=null&&val9.toString().trim().equals("")==false){
				model.setEnterYear(Integer.parseInt(val9.toString().trim()));
			}
			Object val10 = m.get(10);//字段:学期id
			if(val10==null||val10.toString().trim().equals("")){
				return "第"+(i+1)+"行数据中，学期id不能为空";
			}
			if(val10!=null){
				String tmpStr = val10.toString();
				if(tmpStr.equals("")==false){
					TermInfoExample te = new TermInfoExample();
					TermInfoExample.Criteria tc = te.createCriteria();
					tc.andTermNameEqualTo(tmpStr.trim());
					List<TermInfo> tl = termInfoMapper.selectByExample(te);//查询学期是否存在该数据
					if(tl.size()==1){
						model.setTermId(tl.get(0).getId());//
					}
				}
			}
			Object val11 = m.get(11);//字段:家庭住址
			if(val11==null||val11.toString().trim().equals("")){
				return "第"+(i+1)+"行数据中，家庭住址不能为空";
			}
			if(val11!=null&&val11.toString().trim().equals("")==false){
				model.setFamilyAddress(val11.toString().trim());
			}
			Object val12 = m.get(12);//字段:家长联系方式
			if(val12==null||val12.toString().trim().equals("")){
				return "第"+(i+1)+"行数据中，家长联系方式不能为空";
			}
			if(val12!=null&&val12.toString().trim().equals("")==false){
				model.setParentCel(val12.toString().trim());
			}
			addList.add(model);
		}
		for (int i=0;i<addList.size();i++) {
			for (int j=0;j<addList.size();j++) {
				if(i!=j){
					if(addList.get(i).getStuNo()!=null&&addList.get(j).getStuNo()!=null
					&&addList.get(i).getStuNo().equals(addList.get(j).getStuNo())){
						return "excel中存在两条数据学号列的值为"+addList.get(j).getStuNo()+",请检查修改";
					}
				}
			}
		}
		for (int k=0;k<addList.size();k++) {
			StudentInfo model = addList.get(k);
			if(model.getStuNo()==null||model.getStuNo().equals("")){
				return "excel中第"+(k+1)+"行中学号列不能为空";
			}
			if(model.getStuNo()!=null){
				StudentInfoExample te=new StudentInfoExample();
				StudentInfoExample.Criteria tc=te.createCriteria();
				tc.andStuNoEqualTo(model.getStuNo());
				int count = (int)studentInfoMapper.countByExample(te);
				if(count>0){
					return "excel中第"+(k+1)+"行中系统已存在值为 "+model.getStuNo()+" 的学号请重新填写上传";
				}
			}
			if(model.getPassword()==null||model.getPassword().equals("")){
				return "excel中第"+(k+1)+"行中密码列不能为空";
			}
			if(model.getSex()==null){
				return "excel中第"+(k+1)+"行中性别列不能为空";
			}
			if(model.getRealName()==null||model.getRealName().equals("")){
				return "excel中第"+(k+1)+"行中姓名列不能为空";
			}
			if(model.getMajorId()==null){
				return "excel中第"+(k+1)+"行中所属学科列不能为空";
			}
			if(model.getDirectId()==null){
				return "excel中第"+(k+1)+"行中方向列不能为空";
			}
			if(model.getClassId()==null){
				return "excel中第"+(k+1)+"行中班级列不能为空";
			}
			if(model.getCelPhone()==null||model.getCelPhone().equals("")){
				return "excel中第"+(k+1)+"行中联系电话列不能为空";
			}
			if(model.getCelPhone()!=null){
			Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
				Matcher m = p.matcher(model.getCelPhone());
				if( m.matches()==false){
					return "excel中第"+(k+1)+"行中的联系电话该值不符合手机号匹配,请修改后重新上传";
				}
			}
			if(model.getEnterYear()==null){
				return "excel中第"+(k+1)+"行中入学年份列不能为空";
			}
			if(model.getTermId()==null){
				return "excel中第"+(k+1)+"行中学期id列不能为空";
			}
			if(model.getFamilyAddress()==null||model.getFamilyAddress().equals("")){
				return "excel中第"+(k+1)+"行中家庭住址列不能为空";
			}
			if(model.getParentCel()==null||model.getParentCel().equals("")){
				return "excel中第"+(k+1)+"行中家长联系方式列不能为空";
			}
		}
		for (int k=0;k<addList.size();k++) {
			studentInfoMapper.insertSelective(addList.get(k));
		}
		return "";
	}
}
