
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
								<title>修改-学生</title>
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
													<legend>修改-学生</legend>
													<div class="layui-field-box">
														<div >
															<div class="layui-form-item layui-form-text" id="stuNoParentContent">
																<label class="layui-form-label">学号<p style="color:red">(*必填)</p></label>
																<div class="layui-input-block">
																	<input type="text"  style="display:inline;width:400px" value="${data.stuNo}" placeholder="请输入学号" id="stuNo" class="layui-input">
																		<p style="color:gray"></p>
																	</div>
																</div>
																<div class="layui-form-item layui-form-text" id="passwordParentContent">
																	<label class="layui-form-label">密码<p style="color:red">(*必填)</p></label>
																	<div class="layui-input-block">
																		<input type="text"  style="display:inline;width:400px" value="${data.password}" placeholder="请输入密码" id="password" class="layui-input">
																			<p style="color:gray"></p>
																		</div>
																	</div>
																	<div class="layui-form-item layui-form-text" id="sexParentContent">
																		<label class="layui-form-label">性别<p style="color:red">(*必填)</p></label>
																		<div class="layui-input-block">
																			<select  id="sex" style="display:inline;height:30px;width:400px" >
																				<c:forEach items="${sexList}" var="item">
																					<c:if test="${item.id==data.sex}">
																						<option value="${item.id}" selected>${item.name}</option>
																					</c:if>
																					<c:if test="${item.id!=data.sex}">
																						<option value="${item.id}">${item.name}</option>
																					</c:if>
																				</c:forEach>
																			</select>
																			<p style="color:gray"></p>
																		</div>
																	</div>
																	<div class="layui-form-item layui-form-text" id="realNameParentContent">
																		<label class="layui-form-label">姓名<p style="color:red">(*必填)</p></label>
																		<div class="layui-input-block">
																			<input type="text"  style="display:inline;width:400px" value="${data.realName}" placeholder="请输入姓名" id="realName" class="layui-input">
																				<p style="color:gray"></p>
																			</div>
																		</div>
																		<div class="layui-form-item layui-form-text" id="majorIdParentContent">
																			<label class="layui-form-label">所属学科<p style="color:red">(*必填)</p></label>
																			<div class="layui-input-block">
																				<select  id="majorId" style="height:30px;width:400px"  >
																					<c:forEach items="${majorInfoList}" var="item">
																						<c:if test="${item.id==data.majorId}">
																							<option value="${item.id}" selected>${item.name}</option>
																						</c:if>
																						<c:if test="${item.id!=data.majorId}">
																							<option value="${item.id}">${item.name}</option>
																						</c:if>
																					</c:forEach>
																				</select>
																				<p style="color:gray"></p>
																			</div>
																		</div>
																		<div class="layui-form-item layui-form-text" id="directIdParentContent">
																			<label class="layui-form-label">方向<p style="color:red">(*必填)</p></label>
																			<div class="layui-input-block">
																				<select  id="directId" style="height:30px;width:400px"  >
																					<c:forEach items="${majorDirectInfoList}" var="item">
																						<c:if test="${item.id==data.directId}">
																							<option value="${item.id}" selected>${item.name}</option>
																						</c:if>
																						<c:if test="${item.id!=data.directId}">
																							<option value="${item.id}">${item.name}</option>
																						</c:if>
																					</c:forEach>
																				</select>
																				<p style="color:gray"></p>
																			</div>
																		</div>
																		<div class="layui-form-item layui-form-text" id="classIdParentContent">
																			<label class="layui-form-label">班级<p style="color:red">(*必填)</p></label>
																			<div class="layui-input-block">
																				<select  id="classId" style="height:30px;width:400px"  >
																					<c:forEach items="${classInfoList}" var="item">
																						<c:if test="${item.id==data.classId}">
																							<option value="${item.id}" selected>${item.name}</option>
																						</c:if>
																						<c:if test="${item.id!=data.classId}">
																							<option value="${item.id}">${item.name}</option>
																						</c:if>
																					</c:forEach>
																				</select>
																				<p style="color:gray"></p>
																			</div>
																		</div>
																		<div class="layui-form-item layui-form-text" id="celPhoneParentContent">
																			<label class="layui-form-label">联系电话<p style="color:red">(*必填)</p></label>
																			<div class="layui-input-block">
																				<input type="text"  style="display:inline;width:400px" value="${data.celPhone}" placeholder="请输入联系电话" id="celPhone" class="layui-input">
																					<p style="color:gray"></p>
																				</div>
																			</div>
																			<div class="layui-form-item layui-form-text" id="enterYearParentContent">
																				<label class="layui-form-label">入学年份<p style="color:red">(*必填)</p></label>
																				<div class="layui-input-block">
																					<input type="text"  style="display:inline;width:400px" value="${data.enterYear}" placeholder="请输入入学年份(请输入数字)" id="enterYear" class="layui-input">
																						<p style="color:gray"></p>
																					</div>
																				</div>
																				<div class="layui-form-item layui-form-text" id="termIdParentContent">
																					<label class="layui-form-label">学期id<p style="color:red">(*必填)</p></label>
																					<div class="layui-input-block">
																						<select  id="termId" style="height:30px;width:400px"  >
																							<c:forEach items="${termInfoList}" var="item">
																								<c:if test="${item.id==data.termId}">
																									<option value="${item.id}" selected>${item.name}</option>
																								</c:if>
																								<c:if test="${item.id!=data.termId}">
																									<option value="${item.id}">${item.name}</option>
																								</c:if>
																							</c:forEach>
																						</select>
																						<p style="color:gray"></p>
																					</div>
																				</div>
																				<div class="layui-form-item layui-form-text" id="familyAddressParentContent">
																					<label class="layui-form-label">家庭住址<p style="color:red">(*必填)</p></label>
																					<div class="layui-input-block">
																						<input type="text"  style="display:inline;width:400px" value="${data.familyAddress}" placeholder="请输入家庭住址" id="familyAddress" class="layui-input">
																							<p style="color:gray"></p>
																						</div>
																					</div>
																					<div class="layui-form-item layui-form-text" id="parentCelParentContent">
																						<label class="layui-form-label">家长联系方式<p style="color:red">(*必填)</p></label>
																						<div class="layui-input-block">
																							<input type="text"  style="display:inline;width:400px" value="${data.parentCel}" placeholder="请输入家长联系方式" id="parentCel" class="layui-input">
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
																<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=0754"></script>
																<script type="text/javascript">
																	$(function(){
																	$('#majorId').next().remove();
																	$('#majorId').searchableSelect();
																	$("#majorId").change(function(){
																	changeMajorIdVal();
																	});
																	changeMajorIdVal();
																	$("#majorId").change(function(){
																	changeMajorIdVal();
																	});
																	changeMajorIdVal();
																	$('#directId').next().remove();
																	$('#directId').searchableSelect();
																	$('#classId').next().remove();
																	$('#classId').searchableSelect();
																	$('#termId').next().remove();
																	$('#termId').searchableSelect();
																	})
																	function changeMajorIdVal(){
																	var id = $("#majorId").val();
																	$.ajax({
																	async:false,
																	type: 'post',
																	url: '${pageContext.request.contextPath}/teacher/student_info/getMajorDirectInfoListByMajorId',
																	data:{
																	"majorId":id
																	},
																	success: function(result) {
																	var html='<option value="" >全部</option>';
																	for(var i=0;i<result.length;i++){
																		html+='<option value='+result[i].id+' >'+result[i].name+'</option>';
																		}
																		$("#directId").html(html);
																		$("#directId").next().remove();
																		$("#directId").searchableSelect();
																		if('${data.directId}'!=''&&'${data.directId}'!='null'&&'${data.directId}'!=null){
																		$("#directId").val('${data.directId}');
																		}
																		}
																		});
																		}
																		function changeMajorIdVal(){
																		var id = $("#majorId").val();
																		$.ajax({
																		async:false,
																		type: 'post',
																		url: '${pageContext.request.contextPath}/teacher/student_info/getClassInfoListByMajorId',
																		data:{
																		"majorId":id
																		},
																		success: function(result) {
																		var html='<option value="" >全部</option>';
																		for(var i=0;i<result.length;i++){
																			html+='<option value='+result[i].id+' >'+result[i].name+'</option>';
																			}
																			$("#classId").html(html);
																			$("#classId").next().remove();
																			$("#classId").searchableSelect();
																			if('${data.classId}'!=''&&'${data.classId}'!='null'&&'${data.classId}'!=null){
																			$("#classId").val('${data.classId}');
																			}
																			}
																			});
																			}
																			function submitData(){
																			var stuNo= $('#stuNo').val();
																			var password= $('#password').val();
																			var sex= $('#sex').val();
																			var realName= $('#realName').val();
																			var majorId=$('#majorId').val()
																			var majorId= $('#majorId').val();
																			var directId=$('#directId').val()
																			var directId= $('#directId').val();
																			var classId=$('#classId').val()
																			var classId= $('#classId').val();
																			var celPhone= $('#celPhone').val();
																			var enterYear= $('#enterYear').val();
																			var termId=$('#termId').val()
																			var termId= $('#termId').val();
																			var familyAddress= $('#familyAddress').val();
																			var parentCel= $('#parentCel').val();
																			if(enterYear!=''){
																			if(isIntNum(enterYear)==false){
																			alert("入学年份必须填入整数");
																			return;
																			}
																			}
																			$.ajax({
																			type: 'post',
																			url: '${pageContext.request.contextPath}/teacher/student_info/update_submit',
																			data:{
																			"id":'${data.id}',
																			"stuNo":stuNo,
																			"password":password,
																			"sex":sex,
																			"realName":realName,
																			"majorId":majorId,
																			"directId":directId,
																			"classId":classId,
																			"celPhone":celPhone,
																			"enterYear":enterYear,
																			"termId":termId,
																			"familyAddress":familyAddress,
																			"parentCel":parentCel
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


