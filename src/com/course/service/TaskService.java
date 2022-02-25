package com.course.service;

import com.course.controller.LoginModel;
import com.course.dao.*;
import com.course.model.*;

import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface TaskService {
	public void courseRange(Integer termId);
}

