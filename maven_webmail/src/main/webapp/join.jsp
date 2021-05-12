<%-- 
    Document   : sign_up
    Created on : 2021. 5. 8., 오후 9:11:19
    Author     : kwangmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cse.maven_webmail.control.CommandType"%>

<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>회원가입</title>
        <link type="text/css" rel="stylesheet" href="css/main_style.css" />
    </head>
    <body>
        <%@include file="header.jspf"%>
        <form  action="join_handler.do?menu=<%= CommandType.JOIN%>" method="POST"> 
            <p>
                <label for="id">ID: </label> 
                <input id="id" type="text" name="id" maxlength="20">
                <font color="red">  * 5글자 이상</font>
            </p>
            <p>
                <label for="password">비밀번호: </label> 
                <input id="password" type="text" name="password" maxlength="20">
                <font color="red">  * 6글자 이상</font>
            </p> 
            <p>
                <label for="password_check">비밀번호 확인: </label> 
                <input id="password_check" type="text" name="password_check" maxlength="20">
            </p>
            <p>
                <label for="username">이름: </label> 
                <input id="username" type="text" name="username">
            </p>
            <p>
                <label for="birth">생일: </label>
                <input id="birth" type="text" name="birth" maxlength="8">
                <font color="red">  * 예) 900203</font>
            </p>
            <p>
                <label for="phone">전화번호: </label>
                <input id="phone" type="text" name="phone" maxlength="16">
            </p>
            <p>
                <input type="submit" value="저장" name="register"/>&nbsp;&nbsp;&nbsp;
                <input type="button" value="나가기" onClick="location.href='<%= getServletContext().getInitParameter("HomeDirectory") %>'"/>
            </p>
        </form>

        <%@include file="footer_kwang.jspf"%>
    </body>
</html>