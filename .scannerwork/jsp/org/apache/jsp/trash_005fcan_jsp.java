/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat9
 * Generated at: 2021-05-20 04:58:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class trash_005fcan_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n\r\n\r\n <!-- 데이터베이스-->\r\n\r\n<!--지움\r\n");
      cse.maven_webmail.model.Pop3Agent pop3 = null;
      pop3 = (cse.maven_webmail.model.Pop3Agent) _jspx_page_context.getAttribute("pop3", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (pop3 == null){
        try {
          pop3 = (cse.maven_webmail.model.Pop3Agent) java.beans.Beans.instantiate(this.getClass().getClassLoader(), "cse.maven_webmail.model.Pop3Agent");
        } catch (java.lang.ClassNotFoundException exc) {
          throw new InstantiationException(exc.getMessage());
        } catch (java.lang.Exception exc) {
          throw new javax.servlet.ServletException("Cannot create bean of class " + "cse.maven_webmail.model.Pop3Agent", exc);
        }
        _jspx_page_context.setAttribute("pop3", pop3, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');

    pop3.setHost((String) session.getAttribute("host"));
    pop3.setUserid((String) session.getAttribute("userid"));
    pop3.setPassword((String) session.getAttribute("password"));

      out.write(" \r\n--!>\r\n\r\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitiona1//EN\" \r\n    \"http://www.w3.org/TR/html4/loose.dtd\">\r\n\r\n<html>\r\n    <head>\r\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n        <title>휴지통</title>\r\n        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/main_style.css\" />\r\n    </head>\r\n\r\n    <body>\r\n        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n\r\n        <div id=\"sidebar\">\r\n            <a href=\"main_menu.jsp\"> 이전 메뉴로 </a>\r\n        </div>\r\n\r\n         <div id=\"msgBody\">\r\n             화아면\r\n             </div>\r\n     \r\n            ");

            final String JdbcDriver = "com.mysql.cj.jdbc.Driver";
            final String JdbcUrl = "jdbc:mysql://localhost:3306/goto_bin";
            final String User = "jdbctester";
            final String Password = "12345*";
            
            try {
            // 1. JDBC 드라이버 적재
            Class.forName(JdbcDriver);
            // 2. Connection 객체생성
            Connection conn = DriverManager.getConnection
                               (JdbcUrl, User, Password);
            // 3. Statement 객체생성
            Statement stmt = conn.createStatement();
            // 4. SQL 질의 쿼리실행
            String sql = "SELECT * FROM bin";
            ResultSet rs = stmt.executeQuery(sql); 
            
      out.write("\r\n            <table border =\" \"1\" >\r\n                <thead>\r\n                    <tr>\r\n                        <th>보낸 사람</th>\r\n                        <th>보낸날짜</th>\r\n                        <th>제목</th>\r\n\r\n                    </tr>\r\n                </thead>\r\n                <tbody>\r\n                    \r\n                 ");

                 while (rs.next()){ //휴지통 테이블에서 보여줄것
                 out.println("<tr>");
                 out.println("<td>" + rs.getString("send_person")+ "</td>");
                 out.println("<td>" + rs.getString("send_date")+ "</td>");
                 out.println("<td>" + rs.getString("m_title")+ "</td>");
                 }
                 
                     rs.close();
                     stmt.close();
                     conn.close();
                 
      out.write("\r\n                </tbody>\r\n            </table>\r\n                ");
 
                    } catch (Exception ex){
                    out.println("오류발생. (발생오류:"
                                                    + ex.getMessage()+ ")");
                    }
                            
                
      out.write("\r\n\r\n        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n\r\n    </body>\r\n</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}