
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
			<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<html>
				<head>
					<c:set var="uri" value="${pageContext.request.contextPath}" />
						
<script type="text/javascript">
var uri='${uri}';

</script>
						<meta charset="utf-8">
							<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
								<title>修改-课程表</title>
								<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui/css/layui.css">
									<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/selectsearch/jquery.searchableSelect.css" />
										<style type="text/css">
											.loadingModel {
											position: absolute;
											top: 0;
											left: 0;
											display: none;
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
									</head>
									<div id="loadingDiv"></div>
									<div id="imgModal"></div>
									<div class="layui-container" style="overflow:hidden;min-height:850px">
										<div class="layui-row">
											<div class="layui-col-lg12">
												<fieldset class="layui-elem-field">
													<legend>修改-课程表</legend>
													<div class="layui-field-box">
														<div >
															<div class="layui-form-item layui-form-text" id="courseIdParentContent">
																<label class="layui-form-label">课程ID<p style="color:red">(*必填)</p></label>
																<div class="layui-input-block">
																	<select  id="courseId" style="height:30px;width:400px"  >
																		<c:forEach items="${courseInfoList}" var="item">
																			<c:if test="${item.id==data.courseId}">
																				<option value="${item.id}" selected>${item.name}</option>
																			</c:if>
																			<c:if test="${item.id!=data.courseId}">
																				<option value="${item.id}">${item.name}</option>
																			</c:if>
																		</c:forEach>
																	</select>
																	<p style="color:gray"></p>
																</div>
															</div>
															<div class="layui-form-item layui-form-text" id="roomIdParentContent">
																<label class="layui-form-label">教室<p style="color:red">(*必填)</p></label>
																<div class="layui-input-block">
																	<select  id="roomId" style="height:30px;width:400px"  >
																		<c:forEach items="${roomInfoList}" var="item">
																			<c:if test="${item.id==data.roomId}">
																				<option value="${item.id}" selected>${item.name}</option>
																			</c:if>
																			<c:if test="${item.id!=data.roomId}">
																				<option value="${item.id}">${item.name}</option>
																			</c:if>
																		</c:forEach>
																	</select>
																	<p style="color:gray"></p>
																</div>
															</div>
															<div class="layui-form-item layui-form-text" id="weekNoParentContent">
																<label class="layui-form-label">第几周<p style="color:red">(*必填)</p></label>
																<div class="layui-input-block">
																	<input type="text"  style="display:inline;width:400px" value="${data.weekNo}" placeholder="请输入第几周(请输入数字)" id="weekNo" class="layui-input">
																		<p style="color:gray"></p>
																	</div>
																</div>
																<div class="layui-form-item layui-form-text" id="weekDayParentContent">
																	<label class="layui-form-label">星期几<p style="color:red">(*必填)</p></label>
																	<div class="layui-input-block">
																		<select  id="weekDay" style="display:inline;height:30px;width:400px" >
																			<c:forEach items="${weekDayList}" var="item">
																				<c:if test="${item.id==data.weekDay}">
																					<option value="${item.id}" selected>${item.name}</option>
																				</c:if>
																				<c:if test="${item.id!=data.weekDay}">
																					<option value="${item.id}">${item.name}</option>
																				</c:if>
																			</c:forEach>
																		</select>
																		<p style="color:gray"></p>
																	</div>
																</div>
																<div class="layui-form-item layui-form-text" id="jsParentContent">
																	<label class="layui-form-label">第几节<p style="color:red">(*必填)</p></label>
																	<div class="layui-input-block">
																		<select  id="js" style="display:inline;height:30px;width:400px" >
																			<c:forEach items="${jsList}" var="item">
																				<c:if test="${item.id==data.js}">
																					<option value="${item.id}" selected>${item.name}</option>
																				</c:if>
																				<c:if test="${item.id!=data.js}">
																					<option value="${item.id}">${item.name}</option>
																				</c:if>
																			</c:forEach>
																		</select>
																		<p style="color:gray"></p>
																	</div>
																</div>
																<div class="layui-form-item">
																	<div class="layui-input-block">
																		<button class="layui-btn" onclick="submitData();" >立即提交</button>
																		<button  class="layui-btn layui-btn-primary"  onclick="javascript:history.back(-1);" >返回</button>
																	</div>
																</div>
																<div style="height:200px"></div>
															</div>
														</div>
													</fieldset>
												</div>
											</div>
										</div>
										<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
										<script type="text/javascript" src="${pageContext.request.contextPath}/static/selectsearch/jquery.searchableSelect.js"></script>
										<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.js"></script>
										<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=9056"></script>
										<script type="text/javascript">
											$(function(){
											$('#courseId').next().remove();
											$('#courseId').searchableSelect();
											$('#roomId').next().remove();
											$('#roomId').searchableSelect();
											})
											function submitData(){
											var courseId=$('#courseId').val()
											var courseId= $('#courseId').val();
											var roomId=$('#roomId').val()
											var roomId= $('#roomId').val();
											var weekNo= $('#weekNo').val();
											var weekDay= $('#weekDay').val();
											var js= $('#js').val();
											if(weekNo!=''){
											if(isIntNum(weekNo)==false){
											alert("第几周必须填入整数");
											return;
											}
											}
											$.ajax({
											type: 'post',
											url: '${pageContext.request.contextPath}/admin/course_range_info/update_submit',
											data:{
											"id":'${data.id}',
											"courseId":courseId,
											"roomId":roomId,
											"weekNo":weekNo,
											"weekDay":weekDay,
											"js":js
											},
											success: function(result) {
											if(result.code == 0){
											alert(result.msg);
											}else{
											alert(result.msg);
											self.location=document.referrer;
											}
											}
											});
											}
										</script>
									</body>
								</html>


