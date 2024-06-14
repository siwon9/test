<%@ page contentType="text/html; charset=UTF-8" %>

<jsp:useBean id="item" class="board.entities.BoardData" scope="request"/>
<jsp:setProperty name="item" property="*" />

<%--
<jsp:setProperty name="item" property="subject" />
<jsp:setProperty name="item" property="content" />
<jsp:setProperty name="item" property="poster" param="writer"/>
--%>

<%-- param은 property와 이름이 다를 경우에 명시해주면 된다.--%>

제목 : ${item.subject}<br>
내용 : ${item.content}<br>
작성자 : ${item.poster}<br>



