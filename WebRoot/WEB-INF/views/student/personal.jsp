
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
			<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<html>
				<head>
					<c:set var="uri" value="${pageContext.request.contextPath}" />
						<meta charset="utf-8">
							<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
								<title>个人中心</title>
								<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui/css/layui.css">
									<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/global.css">
										<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/icheck/minimal/red.css">
											<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/page/myPagination.css?t=4" />
											</head>
											<body class="layui-layout-body">
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
												<fieldset class="layui-elem-field">
													<legend>个人中心</legend>
													<div class="layui-field-box">
														<table  class="layui-table">
															<thead>
																<tr>
																	<th colspan="2" scope="col">个人中心</th>
																</tr>
															</thead>
															<tbody>
																<tr>
																	<th width="10%">学号</th>
																	<th width="90%"  >${detail.studentInfo.stuNo}</th>
																</tr>
																<tr>
																	<th width="10%">性别</th>
																	<th width="90%"  >${detail.sexStr}</th>
																</tr>
																<tr>
																	<th width="10%">姓名</th>
																	<th width="90%"  >${detail.studentInfo.realName}</th>
																</tr>
																<tr>
																	<th width="10%">所属学科</th>
																	<th width="90%"   id=majorIdStr>${detail.majorIdStr}</th>
																</tr>
																<tr>
																	<th width="10%">方向</th>
																	<th width="90%"   id=directIdStr>${detail.directIdStr}</th>
																</tr>
																<tr>
																	<th width="10%">班级</th>
																	<th width="90%"   id=classIdStr>${detail.classIdStr}</th>
																</tr>
																<tr>
																	<th width="10%">联系电话</th>
																	<th width="90%"  >${detail.studentInfo.celPhone}</th>
																</tr>
																<tr>
																	<th width="10%">入学年份</th>
																	<th width="90%"  >${detail.studentInfo.enterYear}</th>
																</tr>
																<tr>
																	<th width="10%">学期id</th>
																	<th width="90%"   id=termIdStr>${detail.termIdStr}</th>
																</tr>
																<tr>
																	<th width="10%">家庭住址</th>
																	<th width="90%"  >${detail.studentInfo.familyAddress}</th>
																</tr>
																<tr>
																	<th width="10%">家长联系方式</th>
																	<th width="90%"  >${detail.studentInfo.parentCel}</th>
																</tr>
																<tr>
																	<th width="10%">创建时间</th>
																	<th width="90%"  >${detail.studentInfo.createTime}</th>
																</tr>
															</tbody>
														</table>
														<hr>
															<div style="margin-left:20%">
															</div>
														</div>
													</fieldset>
													<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
													<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.js"></script>
													<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/icheck/icheck.js"></script>
													<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layuiutil.js"></script>
													<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=#随机码#"></script>
													
<script type="text/javascript">
$(function(){
})

</script>
												</body>
											</html>


