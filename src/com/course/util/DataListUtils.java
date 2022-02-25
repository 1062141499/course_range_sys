package com.course.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 固定下拉列表解释器
 * @author Administrator
 *
 */
public class DataListUtils {
    public static void main(String[] args) {
    }

    /**
    **获取登录角色列表
    */
    public static List<Map<String, Object>> getLoginTypeList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1", "admin"));
        list.add(getMap("2", "teacher"));
        list.add(getMap("3", "student"));

        return list;
    }

    /**
    **获取sex数据列表
    */
    public static List<Map<String, Object>> getSexList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1", "男"));
        list.add(getMap("2", "女"));

        return list;
    }

    public static String getSexNameById(String id) { //根据sex的key值获取名称

        List<Map<String, Object>> list = getSexList();

        return getNameById(id, list);
    }

    /**
    **获取js数据列表
    */
    public static List<Map<String, Object>> getJsList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1",
                "第一、二节"));
        list.add(getMap("2",
                "第三、四节"));
        list.add(getMap("3",
                "第五、六节"));
        list.add(getMap("4",
                "第七、八节"));
        list.add(getMap("5",
                "第九、十节"));

        return list;
    }

    public static String getJsNameById(String id) { //根据js的key值获取名称

        List<Map<String, Object>> list = getJsList();

        return getNameById(id, list);
    }

    /**
    **获取week_day数据列表
    */
    public static List<Map<String, Object>> getWeekDayList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1", "星期一"));
        list.add(getMap("2", "星期二"));
        list.add(getMap("3", "星期三"));
        list.add(getMap("4", "星期四"));
        list.add(getMap("5", "星期五"));
        list.add(getMap("6", "星期六"));
        list.add(getMap("7", "星期日"));

        return list;
    }

    public static String getWeekDayNameById(String id) { //根据week_day的key值获取名称

        List<Map<String, Object>> list = getWeekDayList();

        return getNameById(id, list);
    }

    /**
    **获取is_setting数据列表
    */
    public static List<Map<String, Object>> getIsSettingList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1", "是"));
        list.add(getMap("2", "否"));

        return list;
    }

    public static String getIsSettingNameById(String id) { //根据is_setting的key值获取名称

        List<Map<String, Object>> list = getIsSettingList();

        return getNameById(id, list);
    }
    
	/**
	**获取is_bx数据列表
	*/
	public static List<Map<String,Object>> getIsBxList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","必修课"));
		list.add(getMap("2","选修课"));
		return list;
	}
	public static String getIsBxNameById(String id){//根据is_bx的key值获取名称
		List<Map<String,Object>> list = getIsBxList();
		return getNameById(id,list);
	}
	/**
	**获取apply_status数据列表
	*/
	public static List<Map<String,Object>> getApplyStatusList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","已申请"));
		list.add(getMap("2","申请通过"));
		list.add(getMap("3","申请不通过"));
		return list;
	}
	public static String getApplyStatusNameById(String id){//根据apply_status的key值获取名称
		List<Map<String,Object>> list = getApplyStatusList();
		return getNameById(id,list);
	}

    public static String getNameById(String id, List<Map<String, Object>> list) {
        if (id == null) {
            return null;
        }

        if (id.endsWith(",")) {
            id = id.substring(0, id.length() - 1);
        }

        String[] idsplit = id.split(",");
        String rs = "";

        for (String tmp : idsplit) {
            for (Map<String, Object> map : list) {
                if (map.get("id").toString().equals(tmp)) {
                    rs += (map.get("name").toString() + ",");
                }
            }
        }

        if (rs.endsWith(",")) {
            rs = rs.substring(0, rs.length() - 1);
        }

        return rs;
    }

    private static Map<String, Object> getMap(String id, String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("name", name);

        return map;
    }
}

