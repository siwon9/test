<%@ page contentType="text/html; charset=UTF-8" %>
<%
    // 내부변수 접근 가능함

   System.out.println(request);
%>

<%!
    //지역 내부변수는 접근 불가능하다 request, response 같은애들
%>