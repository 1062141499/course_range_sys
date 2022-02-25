<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>面向新高考的走班教学管理平台</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui/css/layui.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui/css/admin.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
 <div class="layui-logo" style="width:300px;"><a  href="#" style="color:white">面向新高考的走班教学管理平台</a></div>
 

 
    <ul class="layui-nav layui-layout-right">
	
	 
	
      <li class="layui-nav-item">
        <a href="javascript:;">
         ${roleName}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="javascript:void(0)" onclick="alterPassword()">修改密码</a></dd>
        </dl>
      </li>
	  	
      <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/commonapi/sys_logout">退出</a></li>
    </ul>
  </div> 
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll" style="display:block">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
      
     <li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">教师管理 </a>
            <dl class="layui-nav-child">
                 <dd>  <a onclick="goPage(this)"  data-name="教师管理"    data-url="${pageContext.request.contextPath}/admin/teacher_info">教师管理  </a>  </dd>
                   <dd>  <a onclick="goPage(this)"  data-name="教师课程表"    data-url="${pageContext.request.contextPath}/admin/teacher_info/queryTeacherCourse">教师课程</a>  </dd>
            </dl>
			</li><li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">学科方向管理 </a>
            <dl class="layui-nav-child">
                 <dd>  <a onclick="goPage(this)"  data-name="学科方向管理"    data-url="${pageContext.request.contextPath}/admin/major_info">学科方向管理 </a>  </dd>
            </dl>
			</li><li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">学科管理 </a>
            <dl class="layui-nav-child">
                 <dd>  <a onclick="goPage(this)"  data-name="学科管理 "    data-url="${pageContext.request.contextPath}/admin/major_direct_info">学科管理  </a>  </dd>
            </dl>
			</li><li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">班级管理 </a>
            <dl class="layui-nav-child">
                 <dd>  <a onclick="goPage(this)"  data-name="班级管理"    data-url="${pageContext.request.contextPath}/admin/class_info">班级管理  </a>  </dd>
            </dl>
			</li><li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">学期管理 </a>
            <dl class="layui-nav-child">
                 <dd>  <a onclick="goPage(this)"  data-name="学期管理"    data-url="${pageContext.request.contextPath}/admin/term_info">学期管理  </a>  </dd>
            </dl>
			</li><li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">教室管理 </a>
            <dl class="layui-nav-child">
                 <dd>  <a onclick="goPage(this)"  data-name="教室管理"    data-url="${pageContext.request.contextPath}/admin/room_info">教室管理  </a>  </dd>
            </dl>
			</li>
			
			<li class="layui-nav-item layui-nav-itemed">
														<a href="javascript:;">课程表管理 </a>
														<dl class="layui-nav-child">
															<dd>  <a onclick="goPage(this)"  data-name="课程表管理"    data-url="${pageContext.request.contextPath}/admin/course_range_info">课程表管理  </a>  </dd>
														</dl>
														</li>
												<li class="layui-nav-item layui-nav-itemed">
														<a href="javascript:;">调停课管理 </a>
														<dl class="layui-nav-child">
															<dd>  <a onclick="goPage(this)"  data-name="调停课管理"    data-url="${pageContext.request.contextPath}/admin/course_apply">调停课管理  </a>  </dd>
														</dl>
													</li>
													
															<li class="layui-nav-item layui-nav-itemed">
														<a href="javascript:;">课表统计 </a>
														<dl class="layui-nav-child">
															<dd>  <a onclick="goPage(this)"  data-name="教室课表"    data-url="${pageContext.request.contextPath}/commonapi/gather/room_gather">教室课表 </a>  </dd>
															<dd>  <a onclick="goPage(this)"  data-name="班级课表"    data-url="${pageContext.request.contextPath}/commonapi/gather/class_gather">班级课表 </a>  </dd>
														</dl>
													</li>
     
      </ul>
    </div>
  </div>
  
  <div class="layui-body" id="LAY_app_body">
 
  
  <div class="layui-tabsbody-item layui-show">
					<iframe src="${pageContext.request.contextPath}/admin/teacher_info" frameborder="0" class="layui-iframe" style="padding: 15px;"></iframe>
				</div>
 </div>

 
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.all.js"></script>
<script type="text/javascript">
layui.use('element', function() {
});
	
	$(function(){
		
	});
	
	/**
 * 操作管理--打开界面
 * @param String title 界面标题
 * @param String url 访问路径
 * @param int width 打开宽度
 * @param int height 打开高度
 */
function execute_open(title, url, width, height) {
    layer.open({
        type: 2,
        title: ''+ title +'',
        shadeClose: true,
        shade: 0.8,
        area: [''+ width +'px', ''+ height +'px'],
        content: ''+ url +'',
    });
}



/**选项卡切换**/
var nav_id = $('.layui-this').data('nav');
$('#layui_nav_left_' + nav_id).show();

$('.layui-layout-left').find('.layui-nav-item').click(function () {
	var nav_id = $(this).data('nav');
	$('#layui_nav_left_' + nav_id).show().siblings().hide();
});

$('.layui-nav-child').find('dd').find('a').click(function () {
	var url = $(this).data('url');
	$('.layui-iframe').attr('src', url);
});
	
	

function goPage(name,url){
	$('.layui-iframe').attr('src', url);
}

function alterPassword(){
	 goPage("修改密码","${pageContext.request.contextPath}/commonapi/alterPassword");
	
}




</script>


</body>
</html>