
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
			<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<html>
				<head>
					<c:set var="uri" value="${pageContext.request.contextPath}" />
						<meta charset="utf-8">
							<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
								<title>课程</title>
								<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui/css/layui.css">
									<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/global.css">
										<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/icheck/minimal/red.css">
											<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/page/myPagination.css" />
											</head>
											<body class="layui-layout-body" style="overflow:scroll;">
												<style type="text/css">
													.btnStyle{
													margin-left:8px;
													margin-top:8px
													}
													.loadingModel {
													position: absolute;
													top: 0;
													left: 0;
													background-color: rgba(9, 9, 9, 0.63);
													width: 100%;
													height: 100%;
													z-index: 1000;
													}
													.loading-content {
													width: 50%;
													text-align: center;
													background: #ffffff;
													border-radius: 6px;
													line-height: 30px;
													z-index: 10001;
													}
												</style>
												<div id="loadingDiv"></div>
												<div id="imgModal"></div>
												<fieldset class="layui-elem-field">
													<legend>课程</legend>
													<div class="layui-field-box">
														<div>
															<div class="layui-form-item" style="text-align:center;">
																<div style="display:inline;width:300px">
																	<div class="layui-inline"  style="margin-left:30px;margin-top:20px;">
																		<label>课程名</label>
																	</div>
																	<div class="layui-inline" style="margin-top:20px;">
																		<div>
																			<input type="text"  style="display:inline;width:200px" value="" placeholder="请输入课程名" id="courseName" class="layui-input">
																			</div>
																		</div>
																	</div>
																	<button type="button" onclick="ajaxList(1);" style="margin-left:50px;margin-top:30px" class="layui-btn layui-btn-radius" ><i class="layui-icon layui-icon-search"></i>查询</button>
																</div>
															</div>
															<hr>
																<div class="layui-form-item">
																	<span id="batchUpdateDiv">
																	</span>
																	<span class="l" id="globalBtns">
																	</span>
																</div>
																<hr>
																	<table class="layui-table">
																		<thead>
																			<tr  style="text-align:center">
																				<th>课程名</th>
																				<th>专业</th>
																				<th>专业方向</th>
																				<th>学期</th>
																				<th>可上课教室</th>
																				<th>上课次数</th>
																				<th>课程类型</th>
																				<th>负责教师</th>
																				<th style="width:200px;">操作</th>
																			</tr>
																		</thead>
																		<tbody id="course_info_body">
																		</tbody>
																	</table>
																	<div id="course_info_bar" class="pagination" style="margin-top:20px;"></div>
																</div>
															</fieldset>
															<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
															<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/page/myPagination.js"></script>
															<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.js"></script>
															<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layuiutil.js"></script>
															<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=2875"></script>
															
<script type="text/javascript">
$(function(){
	ajaxList(1);
});
function ajaxList(page) {
	var courseName = $("#courseName").val();
	showLoading('${pageContext.request.contextPath}/static/common/loading.gif');
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/student/course_info/queryList",
		data : {
			"page":page,
			"courseName":courseName
		},
		success : function(result) {
			hideLoading();
			var rows = result.list;//得到数据列
			var total = result.count;//得到数据总数
			lastPage=result.totalPage;
			totalCount=total;
			var html = '';
			for (var i = 0; i < rows.length; i++) {
				html += '<tr>' ;
				var courseNameVal=setNullToEmpty(rows[i].courseInfo.courseName);
				html+='<td>'+ courseNameVal+'</td>';
				var majorIdVal=setNullToEmpty(rows[i].majorIdStr);
				html+='<td>'+ majorIdVal+'</td>';
				var directIdVal=setNullToEmpty(rows[i].directIdStr);
				html+='<td>'+ directIdVal+'</td>';
				var termIdVal=setNullToEmpty(rows[i].termIdStr);
				html+='<td>'+ termIdVal+'</td>';
				var roomIdsVal=setNullToEmpty(rows[i].roomIdsStr);
				html+='<td>'+ roomIdsVal+'</td>';
				var courseTimesVal=setNullToEmpty(rows[i].courseInfo.courseTimes);
				html+='<td>'+ courseTimesVal+'</td>';
				var isBxVal=setNullToEmpty(rows[i].isBxStr);
				html+='<td>'+isBxVal+'</td>';
				var teacherIdVal=setNullToEmpty(rows[i].teacherIdStr);
				html+='<td>'+ teacherIdVal+'</td>';
				html+='<td>';
				html+='<a href="javascript:void(0)" onclick="xk(this)" data-id="'+rows[i].courseInfo.id+'" act-type="1" class="layui-btn layui-btn-warm layui-btn-radius btnStyle">选课</a>';
				html+='</td>';
				html+='</tr>';
			}
			if (rows.length == 0) {
				html += '<tr><td></td><td></td><td></td><td></td><td>无数据</td><td></td><td></td><td></td><td></td></tr>';
			}
			$("#course_info_body").html(html);
			new myPagination({
				id: 'course_info_bar',
				curPage:page, //初始页码
				pageTotal:result.totalPage, //总页数
				pageAmount: 10,  //每页多少条
				dataTotal: total, //总共多少条数据
				pageSize: 10, //可选,分页个数
				showPageTotalFlag:true, //是否显示数据统计
				showSkipInputFlag:false, //是否支持跳转
				getPage: function (page) {
					ajaxList(page);
				}
			})
		}
	});
}
function xk(e){
	var r=confirm("确认选课该课程？");
	if(r==true){
		var id = $(e).attr("data-id");
		$.ajax({
			type : 'get',
			url : "${pageContext.request.contextPath}/student/course_info/xk",
			data : {
				"id":id
			},
			success : function(result) {
				alert(result.msg);
				if(result.code==1){
					ajaxList(1);
				}
			}
		});
	}
}
function gotoPage(e){
	var url = $(e).attr("data-url");
	window.location.href=url;
}

</script>
														</body>
													</html>


