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
        <title>新增-学期</title>
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
            <legend>新增-学期</legend>
            <div class="layui-field-box">
            <div >
            
            
            <div class="layui-form-item layui-form-text" id="termNameParentContent">
            <label class="layui-form-label">学期名</label>
            <div class="layui-input-block">
            <input type="text"  style="width:500px;display:inline"  placeholder="请输入学期名" id="termName" class="layui-input">	<span style="color:red">*必填</span>
            
            </div>
            </div>
            
            <div class="layui-form-item layui-form-text" id="termIntroParentContent">
            <label class="layui-form-label">学期说明</label>
            <div class="layui-input-block">
            <input type="text"  style="width:500px;display:inline"  placeholder="请输入学期说明" id="termIntro" class="layui-input">
            </div>
            </div>
            
            <div class="layui-form-item layui-form-text" id="endTimeParentContent">
            <label class="layui-form-label">学期排课截止时间</label>
            <div class="layui-input-block">
            <input type="text" class="layui-input Wdate"  readonly="readonly"  style="width:500px;display:inline"   onFocus="WdatePicker({startDate: '%y-%M-%d' })"  placeholder="请输入学期排课截止时间" id="endTime">	<span style="color:red">*必填</span>
                
                </div>
                </div>
                
                <div class="layui-form-item layui-form-text" id="weekNumParentContent">
                <label class="layui-form-label">周数</label>
                <div class="layui-input-block">
                <input type="text"  style="width:500px;display:inline"  placeholder="请输入周数（请输入数字）" id="weekNum" class="layui-input">	<span style="color:red">*必填</span>
                
                </div>
                </div>
                
                <div class="layui-form-item layui-form-text" id="enterYearParentContent">
                <label class="layui-form-label">入学年份</label>
                <div class="layui-input-block">
                <input type="text"  style="width:500px;display:inline"  placeholder="请输入入学年份（请输入数字）" id="enterYear" class="layui-input">	<span style="color:red">*必填</span>
                
                </div>
                </div>
                
                <div class="layui-form-item layui-form-text" id="isSettingParentContent">
                <label class="layui-form-label">是否可修改空闲时间</label>
                <div class="layui-input-block">
                <select  id="isSetting" style="height:30px;width:500px;display:inline" >
                <c:forEach items="${isSettingList}" var="item">
                    <option value="${item.id}">${item.name}</option>
                        </c:forEach>
                        </select>
                        <span style="color:red">*必填</span>
                        
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
                            
                            <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/My97DatePicker/4.8/WdatePicker.js"></script>
                                
                                
                                
                                <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.js"></script>
                                    <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=7145"></script>
                                        
                                        
                                        
                                        <script type="text/javascript">
                                        
                                        
                                        
                                        $(function(){
                                            
                                            
                                            
                                        })
                                        
                                        
                                        
                                        function submitData(){
                                            var termName= $('#termName').val();
                                            var termIntro= $('#termIntro').val();
                                            var endTime= $('#endTime').val();
                                            var weekNum= $('#weekNum').val();
                                            var enterYear= $('#enterYear').val();
                                            var isSetting= $('#isSetting').val();
                                            
                                            if(weekNum!=''){
                                                if(isIntNum(weekNum)==false){
                                                    alert("周数必须填入整数");
                                                    return;
                                                }
                                            }
                                            if(enterYear!=''){
                                                if(isIntNum(enterYear)==false){
                                                    alert("入学年份必须填入整数");
                                                    return;
                                                }
                                            }
                                            $.ajax({
                                                type: 'post',
                                                url: '${pageContext.request.contextPath}/admin/term_info/add_submit',
                                                    data:{
                                                        "termName":termName,
                                                        "termIntro":termIntro,
                                                        "endTime":endTime,
                                                        "weekNum":weekNum,
                                                        "enterYear":enterYear,
                                                        "isSetting":isSetting
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
