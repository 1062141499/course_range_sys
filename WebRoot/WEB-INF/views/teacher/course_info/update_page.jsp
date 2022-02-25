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
        <title>修改-课程</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui/css/layui.css">
            
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
            <div class="layui-container" style="overflow:hidden;height:2000px">
            <div class="layui-row">
            <div class="layui-col-lg12">
            <fieldset class="layui-elem-field">
            <legend>修改-课程</legend>
            <div class="layui-field-box">
            <div >
            
            
            <div class="layui-form-item layui-form-text" id="courseNameParentContent">
            <label class="layui-form-label">课程名</label>
            <div class="layui-input-block">
            <input type="text"  style="width:500px;display:inline" value="${data.courseName}" placeholder="请输入课程名" id="courseName" class="layui-input">	<span style="color:red">*必填</span>
                
                </div>
                </div>
                
                <div class="layui-form-item layui-form-text" id="majorIdParentContent">
                <label class="layui-form-label">学科名</label>
                <div class="layui-input-block">
                <select  id="majorId" style="height:30px;width:500px;display:inline" >
                <c:forEach items="${majorInfoList}" var="item">
                    <c:if test="${item.id==data.majorId}">
                        <option value="${item.id}" selected>${item.name}</option>
                            </c:if>
                            <c:if test="${item.id!=data.majorId}">
                                <option value="${item.id}">${item.name}</option>
                                    </c:if>
                                    </c:forEach>
                                    </select>
                                    <span style="color:red">*必填</span>
                                    
                                    </div>
                                    </div>
                                    
                                    <div class="layui-form-item layui-form-text" id="directIdParentContent">
                                    <label class="layui-form-label">学科方向</label>
                                    <div class="layui-input-block">
                                    <select  id="directId" style="height:30px;width:500px;display:inline" >
                                    <c:forEach items="${majorDirectInfoList}" var="item">
                                        <c:if test="${item.id==data.directId}">
                                            <option value="${item.id}" selected>${item.name}</option>
                                                </c:if>
                                                <c:if test="${item.id!=data.directId}">
                                                    <option value="${item.id}">${item.name}</option>
                                                        </c:if>
                                                        </c:forEach>
                                                        </select>
                                                        <span style="color:red">*必填</span>
                                                        
                                                        </div>
                                                        </div>
                                                        
                                                        <div class="layui-form-item layui-form-text" id="termIdParentContent">
                                                        <label class="layui-form-label">学期</label>
                                                        <div class="layui-input-block">
                                                        <select  id="termId" style="height:30px;width:500px;display:inline" >
                                                        <c:forEach items="${termInfoList}" var="item">
                                                            <c:if test="${item.id==data.termId}">
                                                                <option value="${item.id}" selected>${item.name}</option>
                                                                    </c:if>
                                                                    <c:if test="${item.id!=data.termId}">
                                                                        <option value="${item.id}">${item.name}</option>
                                                                            </c:if>
                                                                            </c:forEach>
                                                                            </select>
                                                                            <span style="color:red">*必填</span>
                                                                            
                                                                            </div>
                                                                            </div>
                                                                            
                                                                            <div class="layui-form-item layui-form-text" id="roomIdsParentContent">
                                                                            <label class="layui-form-label">可上课教室</label>
                                                                            <div class="layui-input-block">
                                                                            <c:forEach items="${roomInfoList}" var="item">
                                                                                <label><input type="checkbox" name="roomIds" value="${item.id}">${item.name}</label>
                                                                                    </c:forEach>
                                                                                    <span style="color:red">*必填</span>
                                                                                    
                                                                                    </div>
                                                                                    </div>
                                                                                    
                                                                                    <div class="layui-form-item layui-form-text" id="courseTimesParentContent">
                                                                                    <label class="layui-form-label">上课次数</label>
                                                                                    <div class="layui-input-block">
                                                                                    <input type="text"  style="width:500px;display:inline" value="${data.courseTimes}" placeholder="请输入上课次数（请输入数字）" id="courseTimes" class="layui-input">	<span style="color:red">*必填</span>
                                                                                        
                                                                                        </div>
                                                                                        </div>
                                                                                        
                                                                                        	<div class="layui-form-item layui-form-text" id="isBxParentContent">
																			<label class="layui-form-label">课程类型<p style="color:red">(*必填)</p></label>
																			<div class="layui-input-block">
																				<select  id="isBx" style="display:inline;height:30px;width:400px" >
																					<c:forEach items="${isBxList}" var="item">
																						<c:if test="${item.id==data.isBx}">
																							<option value="${item.id}" selected>${item.name}</option>
																						</c:if>
																						<c:if test="${item.id!=data.isBx}">
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
                                                                                        </div>
                                                                                        </div>
                                                                                        </fieldset>
                                                                                        </div>
                                                                                        </div>
                                                                                        </div>
                                                                                        <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
                                                                                            
                                                                                            
                                                                                            
                                                                                            
                                                                                            
                                                                                            <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.js"></script>
                                                                                                <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=9739"></script>
                                                                                                    
                                                                                                    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/selectSearch/jquery.searchableSelect.css?d=129339" />
                                                                                                        <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/selectSearch/jquery.searchableSelect.js?d=1293393"></script>
                                                                                                            
                                                                                                            
                                                                                                            <script type="text/javascript">
                                                                                                            
                                                                                                            
                                                                                                            
                                                                                                            $(function(){
                                                                                                                
                                                                                                                $('#majorId').next().remove();
                                                                                                                $('#majorId').searchableSelect();
                                                                                                                $("#majorId").change(function(){
                                                                                                                    changeMajorIdVal();
                                                                                                                });
                                                                                                                changeMajorIdVal();
                                                                                                                $('#directId').next().remove();
                                                                                                                $('#directId').searchableSelect();
                                                                                                                $('#termId').next().remove();
                                                                                                                $('#termId').searchableSelect();
                                                                                                                var roomIds ='${data.roomIds}'
                                                                                                                    var roomIdsTmp = $("input[name='roomIds']");
                                                                                                                    for(var i=0;i<roomIdsTmp.length;i++){
                                                                                                                        var tmp =$(roomIdsTmp[i]).val();
                                                                                                                        if(roomIds.indexOf(tmp+',')!=-1||roomIds.indexOf(','+tmp)!=-1||roomIds==tmp){
                                                                                                                            $(roomIdsTmp[i]).prop("checked",true);
                                                                                                                        }
                                                                                                                    }
                                                                                                                    
                                                                                                                    
                                                                                                                })
                                                                                                                
                                                                                                                
                                                                                                                
                                                                                                                function changeMajorIdVal(){
                                                                                                                    var id = $("#majorId").val();
                                                                                                                    $.ajax({
                                                                                                                        async:false,
                                                                                                                        type: 'post',
                                                                                                                        url: '${pageContext.request.contextPath}/teacher/course_info/getMajorDirectInfoListByMajorId',
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
                                                                                                                        function submitData(){
                                                                                                                            var courseName= $('#courseName').val();
                                                                                                                            var majorId= $('#majorId').val();
                                                                                                                            var directId= $('#directId').val();
                                                                                                                            var termId= $('#termId').val();
                                                                                                                            var roomIds=getCheckBoxVal('roomIds');
                                                                                                                            var courseTimes= $('#courseTimes').val();
                                                                                                                            var isBx= $('#isBx').val();
                                                                                                                            if(courseTimes!=''){
                                                                                                                                if(isIntNum(courseTimes)==false){
                                                                                                                                    alert("上课次数必须填入整数");
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            $.ajax({
                                                                                                                                type: 'post',
                                                                                                                                url: '${pageContext.request.contextPath}/teacher/course_info/update_submit',
                                                                                                                                    data:{
                                                                                                                                        "id":'${data.id}',
                                                                                                                                            "courseName":courseName,
                                                                                                                                            "majorId":majorId,
                                                                                                                                            "directId":directId,
                                                                                                                                            "termId":termId,
                                                                                                                                            "roomIds":roomIds,
                                                                                                                                            "courseTimes":courseTimes,
                                                                                                                                            "isBx":isBx
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
