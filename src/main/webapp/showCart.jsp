<%@ page import="edu.yuryan.firstservletdemo.logic.Cart" %><%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 9.12.2023
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show cart</title>
</head>
<body>
    <% Cart cart = (Cart) session.getAttribute("cart"); %>

    <p> Products in the Cart: <%= cart.getProduct() %> </p>
    <p> Quantity of products: <%= cart.getQuantity() %> </p>
</body>
</html>
