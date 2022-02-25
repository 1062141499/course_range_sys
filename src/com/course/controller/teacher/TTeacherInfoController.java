package com.course.controller.teacher;

import com.course.controller.LoginModel;

import com.course.dao.*;

import com.course.model.*;

import com.course.service.*;
import com.course.service.impl.*;

import com.course.util.*;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/teacher/teacher_info")
public class TTeacherInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    TeacherInfoService teacherInfoService;
    @Autowired
    TeacherInfoMapper teacherInfoMapper;

    /**
    进入教师详情页
    */
    @RequestMapping("detail")
    public Object detail(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        TeacherInfo model = new TeacherInfo();
        model.setId(login.getId());

        TeacherInfo preModel = teacherInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("detail",
            teacherInfoService.getTeacherInfoModel(preModel, login));

        return "teacher/personal";
    }
}

