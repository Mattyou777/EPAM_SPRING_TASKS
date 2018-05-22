<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: matty
  Date: 14.05.2018
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%
    Cookie cookies [] = request.getCookies ();
    Cookie myCookie = null;
    if (cookies != null)
    {
      for (int i = 0; i < cookies.length; i++)
      {
        if (cookies[i].getName().equals("count"))
        {
          myCookie = cookies[i];
          break;
        }
      }
    }
    if (myCookie == null) {
      Cookie cookie = new Cookie ("count", "1");
      cookie.setMaxAge(30);
      response.addCookie(cookie);
    }
  %>
<!DOCTYPE html>
<html>
  <head>
    <title>jQuery, Ajax and Servlet/JSP integration</title>
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js">
    </script>
  </head>
  <body>

  <div id="msg"></div>

  <form method="get" action="${pageContext.request.contextPath}/index">
        Name:
        <input type="text"  name="name" />
    <input type="submit"  value="get"/>
  </form>
  <br>
  <br>

  <form method="post" action="${pageContext.request.contextPath}/index">
        Name:
        <input type="text"  name="name" />
    <input type="submit"  value="post"/>
  </form>
  <br>
  <br>

  <form id="delete-method">
        Name:
        <input type="text"  name="delete_name" />
    <input type="submit"  value="delete"/>
  </form>

  <form id="put_method">
        Name:
    <input type="text"  name="put_name" />
    <input type="submit"  value="put"/>
  </form>

  <strong>Ajax Response</strong>:
  <c:forEach items="${data}" var="data">
      <div>${data}</div>
  </c:forEach>
  <br/>
  <br/>
  <strong>Cookie Count</strong>
  <%
    if (myCookie != null)
    {
  %>
  <%=myCookie.getValue()%>
  <%
  } else {
  %>
  1
  <%
    }
  %>

<script>
  $("#put_method").submit(function(event){
    event.preventDefault();
    var $form = $(this);
    var url = 'http://localhost:8080/index';
    var userName = $form.find('input[name="put_name"]').val();
    $.ajax({
      type : 'PUT',
      url : url,
      contentType: 'application/json',
      data : JSON.stringify(userName),
      success : function(data, status, xhr){
        window.location.replace("http://localhost:8080/index");
      },
      error: function(xhr, status, error){
        $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
      }
    });
  });
  $("#delete-method").submit(function(event){
    event.preventDefault();
    var $form = $(this);
    var url = 'http://localhost:8080/index';
    var userName = $form.find('input[name="delete_name"]').val();
    $.ajax({
      type : 'DELETE',
      url : url,
      contentType: 'application/json',
      data : JSON.stringify(userName),
      success : function(data, status, xhr){
        window.location.replace("http://localhost:8080/index");
      },
      error: function(xhr, status, error){
        $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
      }
    });
  });
</script>
  </body>
</html>
