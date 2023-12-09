<%@ page import="java.util.Date, edu.yuryan.firstservletdemo.logic.TestClass" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello new Servlet</a>
</br>
<a href="second-servlet">Hello Second Servlet</a>
    <p>
        <%
            TestClass testClass = new TestClass();
            java.util.Date now = new Date();
            String currentDate = "Current Date is: " + now;

            out.println("<p>" + testClass.getText() + "</p>");
            for (int i = 0; i < 5; i++) {
                out.println("</br>" + "This can be populated from Java block: " + i);
            }
        %>
    </br>
        <%= currentDate %>
    </p>

</body>
</html>