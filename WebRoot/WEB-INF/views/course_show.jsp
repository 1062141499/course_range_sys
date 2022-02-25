<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>班级课表</title>
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
                    <legend>班级课表</legend>
                    <div class="layui-field-box">
                    <div class="layui-form" action="">
                    <div class="layui-form-item" style="text-align:center;">
                    
                     <div class="layui-inline" style="margin-left:100px;">
                            <label>学期</label>
                            </div>
                            <div class="layui-inline">
                            <div class="layui-input-inline" >
                            <select  id="termId" style="height:30px;width:250px;display:inline" >
                            <c:forEach items="${tl}" var="item">
                                <option value="${item.id}">${item.termName}</option>
                                    </c:forEach>
                                    </select>
                                    
                                    </div>
                                    </div>
                                    
                                    
                                        <div class="layui-inline" style="margin-left:100px;">
                            <label>第几周</label>
                            </div>
                            <div class="layui-inline">
                            <div class="layui-input-inline" >
                            <select  id="weekNo" style="height:30px;width:250px;display:inline" >
                            <c:forEach items="${weekNoList}" var="item">
                                <option value="${item.id}">${item.name}</option>
                                    </c:forEach>
                                    </select>
                                    
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
                        
                        </span>
                        </div>
                        <hr>
                        <h2 id="weekNoTxt" style="text-align:center"></h2>
                        <table class="layui-table">
                        
                        <thead>
                        <tr  style="text-align:center">
                         <th>/</th>
                        <c:forEach var="item" items="${weekList}">
                        <th>${item.name}</th>
                        </c:forEach>
                        
                        </tr>
                        </thead>
                        <tbody id="major_info_body">
                        
                        </tbody>
                        </table>
                        
                        <div  style="margin-top:20px;">
                        </div>
                        </div>
                        </fieldset>
                        
                        <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
                            <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/page/myPagination.js"></script>
                                
                                <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.js"></script>
                                    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layuiutil.js"></script>
                                        
                                        
                                        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/selectSearch/jquery.searchableSelect.css?d=12939" />
                                                                <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/selectSearch/jquery.searchableSelect.js?d=124393"></script>
                                        <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=1838"></script>
                                            
                                            
                                            
                                            <script type="text/javascript">
                                            
                                            $(function(){
                                            	 $('#termId').next().remove();
                                                 $('#termId').searchableSelect();
                                                ajaxList(1);
                                                
                                                
                                            });
                                            
                                            function ajaxList(page) {
                                                var termId = $("#termId").val();
                                                var weekNo = $("#weekNo").val();
                                                
                                                
                                                showLoading('${pageContext.request.contextPath}/static/common/loading.gif');
                                                    $.ajax({
                                                        type : 'get',
                                                        url : "${pageContext.request.contextPath}/commonapi/course_show/courseQuery",
                                                            data : {
                                                                "termId":termId,
                                                                "weekNo":weekNo
                                                                
                                                            },
                                                            success : function(result) {
                                                            	
                                                            	$("#weekNoTxt").html('第'+weekNo+'周');
                                                            	
                                                                hideLoading();
                                                                var rows = result;//得到数据列
                                                                var html = '';
                                                                for (var i = 0; i < rows.length; i++) {
                                                                    html += '<tr>' ;
                                                                    var js=setNullToEmpty(rows[i].js);
                                                                    html+='<td>'+ js+'</td>';
                                                                    
                                                                
                                                                    
                                                                    var course1=setNullToEmpty(rows[i].course1);
                                                                    html+='<td>'+ course1+'</td>';
                                                                    
                                                                    var course2=setNullToEmpty(rows[i].course2);
                                                                    html+='<td>'+ course2+'</td>';
                                                                    
                                                                    var course3=setNullToEmpty(rows[i].course3);
                                                                    html+='<td>'+ course3+'</td>';
                                                                    
                                                                    var course4=setNullToEmpty(rows[i].course4);
                                                                    html+='<td>'+ course4+'</td>';
                                                                    
                                                                    var course5=setNullToEmpty(rows[i].course5);
                                                                    html+='<td>'+ course5+'</td>';
                                                                    
                                                                    var course6=setNullToEmpty(rows[i].course6);
                                                                    html+='<td>'+ course6+'</td>';
                                                                    
                                                                    var course7=setNullToEmpty(rows[i].course7);
                                                                    html+='<td>'+ course7+'</td>';
                                                                    
                                                                        html+='</tr>';
                                                                    }
                                                                    if (rows.length == 0) {
                                                                        html += '<tr><td></td><td></td><td></td><td></td><td>无数据</td><td></td><td></td><td></td></tr>';
                                                                    }
                                                                    $("#major_info_body").html(html);
                                                                    
                                                                    
                                                                    
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
