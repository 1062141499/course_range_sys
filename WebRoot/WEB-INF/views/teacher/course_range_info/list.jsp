<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>课程表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui/css/layui.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/global.css">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/icheck/minimal/red.css">
                <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/page/myPagination.css?t=4" />
                    
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
                    <legend>课程表</legend>
                    <div class="layui-field-box">
                    <div class="layui-form" action="">
                    <div class="layui-form-item" style="text-align:center;">
                    
                    <div class="layui-inline" style="margin-left:100px;">
                    <label>课程名</label>
                    </div>
                    <div class="layui-inline">
                    <div class="layui-input-inline" >
                    <input type="text"  style="width:250px;display:inline"  placeholder="请输入课程名进行查询" id="courseName" class="layui-input">
                    </div>
                    </div>
                    
                    <button type="button" onclick="ajaxList(1);" style="margin-left:50px" class="layui-btn layui-btn-radius" ><i class="layui-icon layui-icon-search"></i>查询</button>
                    
                    </div>
                    </div>
                    
                    <hr>
                    <div class="layui-form-item">
                    
                    <span id="batchUpdateDiv">
                    
                    </span>
                    <span class="l" id="globalBtns">
                    	<a href="javascript:void(0);" onclick="export_data2()" class="layui-btn layui-btn-warm layui-btn-radius">导出课程</a>
                    
                    </span>
                    </div>
                    <hr>
                    <table class="layui-table">
                    
                    <thead>
                    <tr  style="text-align:center">
                    <th>教师id</th>
                    <th>课程名</th>
                    <th>学科名</th>
                    <th>学科方向</th>
                    <th>教室</th>
                    <th>第几周</th>
                    <th>星期几</th>
                    <th>第几节</th>
                    <th>学期</th>
                    <th style="width:200px;">操作</th>
                    
                    </tr>
                    </thead>
                    <tbody id="course_range_info_body">
                    
                    </tbody>
                    </table>
                    
                    <div id="course_range_info_bar" class="pagination" style="margin-top:20px;">
                    </div>
                    </div>
                    </fieldset>
                    
                    <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
                        <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/page/myPagination.js"></script>
                            
                            <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.js"></script>
                                <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layuiutil.js"></script>
                                    
                                    
                                    
                                    <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=3262"></script>
                                        
                                        
                                        
                                        <script type="text/javascript">
                                        
                                        $(function(){
                                            
                                            ajaxList(1);
                                            
                                            
                                        });
                                        
                                        function export_data2(){
                                        	var params = "";
                                        	var courseName = $("#courseName").val();
                                        	params+="courseName="+courseName+"&";
                                        	var url = "${pageContext.request.contextPath}/teacher/course_range_info/export_data2?1=1&"+params+"";
                                        	window.location.href=url;
                                        }
                                        
                                        function ajaxList(page) {
                                            var courseName = $("#courseName").val();
                                            
                                            
                                            showLoading('${pageContext.request.contextPath}/static/common/loading.gif');
                                                $.ajax({
                                                    type : 'get',
                                                    url : "${pageContext.request.contextPath}/teacher/course_range_info/queryList",
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
                                                                var teacherIdVal=setNullToEmpty(rows[i].teacherIdStr);
                                                                html+='<td>'+ teacherIdVal+'</td>';
                                                                var courseNameVal=setNullToEmpty(rows[i].courseRangeInfo.courseName);
                                                                html+='<td>'+ courseNameVal+'</td>';
                                                                var majorIdVal=setNullToEmpty(rows[i].majorIdStr);
                                                                html+='<td>'+ majorIdVal+'</td>';
                                                                var directIdVal=setNullToEmpty(rows[i].directIdStr);
                                                                html+='<td>'+ directIdVal+'</td>';
                                                                var roomIdVal=setNullToEmpty(rows[i].roomIdStr);
                                                                html+='<td>'+ roomIdVal+'</td>';
                                                                var weekNoVal=setNullToEmpty(rows[i].courseRangeInfo.weekNo);
                                                                html+='<td>第'+weekNoVal+'周</td>';
                                                                var weekDayVal=setNullToEmpty(rows[i].weekDayStr);
                                                                html+='<td>'+weekDayVal+'</td>';
                                                                var jsVal=setNullToEmpty(rows[i].jsStr);
                                                                html+='<td>'+jsVal+'</td>';
                                                                var termIdVal=setNullToEmpty(rows[i].termIdStr);
                                                                html+='<td>'+ termIdVal+'</td>';
                                                                html+='<td>';
                                                                html+='<a href="javascript:void(0)" data-url="${pageContext.request.contextPath}/teacher/stu_range_info?rangeId='+rows[i].courseRangeInfo.id+'" page-name="课程学生安排" onclick="gotoPage(this)"  class="layui-btn layui-btn-radius btnStyle">查看学生名单</a>';
                                                                    html+='</td>';
                                                                    html+='</tr>';
                                                                }
                                                                if (rows.length == 0) {
                                                                    html += '<tr><td></td><td></td><td></td><td></td><td></td><td>无数据</td><td></td><td></td><td></td><td></td></tr>';
                                                                }
                                                                $("#course_range_info_body").html(html);
                                                                
                                                                
                                                                new myPagination({
                                                                    id: 'course_range_info_bar',
                                                                    curPage:page, //初始页码
                                                                    pageTotal: result.totalPage, //总页数
                                                                    pageAmount: 10,  //每页多少条
                                                                    dataTotal: total, //总共多少条数据
                                                                    pageSize: 5, //可选,分页个数
                                                                    showPageTotalFlag:true, //是否显示数据统计
                                                                    showSkipInputFlag:false, //是否支持跳转
                                                                    getPage: function (page) {
                                                                        ajaxList(page);
                                                                    }
                                                                })
                                                                
                                                            }
                                                        });
                                                    }
                                                    
                                                    
                                                    
                                                    function gotoPage(e){
                                                        
                                                        var url = $(e).attr("data-url");
                                                        window.location.href=url;
                                                    }
                                                    
                                                    </script>
                                                    
                                                    </body>
                                                    </html>
