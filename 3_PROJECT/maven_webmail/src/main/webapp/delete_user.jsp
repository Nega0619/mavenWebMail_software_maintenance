<%-- 
    Document   : delete_user.jsp
    Author     : jongmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cse.maven_webmail.control.CommandType" %>
<%@page import="cse.maven_webmail.model.UserAdminAgent" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<%@page errorPage="ErrorPage.jsp"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>

<script type="text/javascript">

    function getConfirmResult() {
        var result = confirm("사용자를 정말로 삭제하시겠습니까?");
        return result;
    }

</script>


<html lang="en" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>사용자 제거 화면</title>
        <link type="text/css" rel="stylesheet" href="css/main_style.css" />
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <%
            String userid = (String) session.getAttribute("userid");
            if (userid.equals("admin")) {
        %>
        <div id="sidebar">
            <jsp:include page="sidebar_admin_previous_menu.jsp" />
        </div>

        <div id="main">
            <h2> 삭제할 사용자를 선택해 주세요. </h2> <br>
            <form name="DeleteUser" action="UserAdmin.do?menu=<%=CommandType.DELETE_USER_COMMAND%>"
                  method="POST">
                <c:catch var="errorReason">
                    <mytags:dellistusers user="jdbctester" password="43319521"
                                         schema="webmail" table="userinfo" />
                </c:catch>
                ${empty errorReason ? "<noerror/>" : errorReason}<br>
                <input type="submit" value="제거" name="delete_command" onClick ="return getConfirmResult()"/>
                <input type="reset" value="선택 전부 취소" />
            </form>
        </div>
        <%
            }
        %>
        <jsp:include page="footer.jsp" />
    </body>
</html>
