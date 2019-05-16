<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/5
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="500">
    <tr>
        <th>编号</th>
        <th>姓名</th>
    </tr>
    <c:forEach items="${page.list}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
        </tr>
    </c:forEach>
</table>
<a href="/fy?pageNo=1">首页</a>
<a href="/fy?pageNo=${page.pre}">上一页</a>
<a href="/fy?pageNo=${page.next}">下一页</a>
<a href="/fy?pageNo=${page.pages}">末页</a>
当前第${page.pageNo}页/共${page.pages}页（共${page.count}条）
<select id="sel">
    <option value="-1">请选择</option>
    <c:forEach begin="1" end="${page.pages}" step="1" var="i">
        <option value="${i}">第${i}页</option>
    </c:forEach>
</select>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function(){

   $("#sel option[value=${page.pageNo}]").attr("selected",true);

   $("#sel").change(function(){
       //获得当前选中的sel的值
       var pageNo = $(this).val();
       if(pageNo!=-1){
           //发起请求
           location="/fy?pageNo="+pageNo;
       }
   });
});
</script>
</body>
</html>
