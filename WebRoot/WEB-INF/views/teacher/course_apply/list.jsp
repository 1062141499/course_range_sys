
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
			<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<html>
				<head>
					<c:set var="uri" value="${pageContext.request.contextPath}" />
						<meta charset="utf-8">
							<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
								<title>调停课申请</title>
								<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui/css/layui.css">
									<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/global.css">
										<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/icheck/minimal/red.css">
											<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/page/myPagination.css" />
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
													<legend>调停课申请</legend>
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
																	<div style="display:inline;width:300px">
																		<div class="layui-inline"  style="margin-left:30px;margin-top:20px;">
																			<label>申请状态</label>
																		</div>
																		<div class="layui-inline" style="margin-top:20px;">
																			<div>
																				<select  id="applyStatus" style="display:inline;height:30px;width:200px" >  <option value="">全部</option>
																					<c:forEach items="${applyStatusList}" var="item">
																						<option value="${item.id}">${item.name}</option>
																					</c:forEach>
																				</select>
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
																		<a href="${pageContext.request.contextPath}/teacher/course_apply/apply" class="layui-btn layui-btn-radius">申请调停课</a>
																	</span>
																</div>
																<hr>
																	<table class="layui-table">
																		<thead>
																			<tr  style="text-align:center">
																				<th>课程名</th>
																				<th>调停原因</th>
																				<th>申请状态</th>
																				<th>管理员备注</th>
																				<th>申请教师</th>
																				<th>申请时间</th>
																				<th style="width:200px;">操作</th>
																			</tr>
																		</thead>
																		<tbody id="course_apply_body">
																		</tbody>
																	</table>
																	<div id="course_apply_bar" class="pagination" style="margin-top:20px;"></div>
																</div>
															</fieldset>
															<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
															<script type="text/javascript" src="${pageContext.request.contextPath}/static/page/myPagination.js"></script>
															<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.js"></script>
															<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layuiutil.js"></script>
															<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=2324"></script>
															
<script type="text/javascript">
$(function(){
	ajaxList(1);
});
function ajaxList(page) {
	var courseName = $("#courseName").val();
	var applyStatus = $("#applyStatus").val();
	showLoading('${pageContext.request.contextPath}/static/common/loading.gif');
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/teacher/course_apply/queryList",
		data : {
			"page":page,
			"courseName":courseName,
			"applyStatus":applyStatus
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
				var courseNameVal=setNullToEmpty(rows[i].courseApply.courseName);
				html+='<td>'+ courseNameVal+'</td>';
				var reasonVal=setNullToEmpty(rows[i].courseApply.reason);
				html+='<td>'+ reasonVal+'</td>';
				var applyStatusVal=setNullToEmpty(rows[i].applyStatusStr);
				html+='<td>'+applyStatusVal+'</td>';
				var checkRemarkVal=setNullToEmpty(rows[i].courseApply.checkRemark);
				html+='<td>'+ checkRemarkVal+'</td>';
				var teacherIdVal=setNullToEmpty(rows[i].teacherIdStr);
				html+='<td>'+ teacherIdVal+'</td>';
				var createTimeVal=setNullToEmpty(rows[i].courseApply.createTime);
				html+='<td>'+ createTimeVal+'</td>';
				html+='<td>';
				if(rows[i].courseApply.applyStatus=='1'){
					html+='<a href="${pageContext.request.contextPath}/teacher/course_apply/update?id='+rows[i].courseApply.id+'" class="layui-btn layui-btn-normal layui-btn-radius btnStyle">修改</a>';
				}
				if(rows[i].courseApply.applyStatus=='1'){
					html+='<a href="javascript:void(0)" onclick="del(this)" data-id="'+rows[i].courseApply.id+'" class="layui-btn layui-btn-danger layui-btn-radius btnStyle">删除</a>';
				}
				html+='</td>';
				html+='</tr>';
			}
			if (rows.length == 0) {
				html += '<tr><td></td><td></td><td></td><td>无数据</td><td></td><td></td><td></td></tr>';
			}
			$("#course_apply_body").html(html);
			new myPagination({
				id: 'course_apply_bar',
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
function del(e){
	if(window.confirm('你确定要删除该调停课申请吗')){
		var id = $(e).attr("data-id");
		$.ajax({
			type : 'get',
			url : "${pageContext.request.contextPath}/teacher/course_apply/del",
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
		return true;
		}else{
		return false;
	}
}
function gotoPage(e){
	var url = $(e).attr("data-url");
	window.location.href=url;
}

</script>
														</body>
													</html>


