<%@ page contentType="text/html; charset=UTF-8" %>
<%
    // 내부변수 접근 가능함, 내장객체 접근가능함(지역변수도)
    // _jspService() 지역 내부

    int num1 = 100;
    int num2 = 200;
    int result = num1 + num2;
    out.write("result=" + result);

    out.write("<br>이름:" + name);
    print();
%>
<br>
<%-- JSP 주석 (번역X)... --%>
<%--
<%=num1%> + <%=num2%> = <%=result%>
--%>
<%!
    //지역 내부변수는 접근 불가능하다 request, response 같은애들
    // 클래스명 바로 아래쪽에 정리된다 - 멤버 변수

    String name = "이이름";
    void print() {
        System.out.println(name);
    }
%>


