<%-- 
    Document   : addproduct
    Created on : 05.01.2021, 21:51:31
    Author     : munte
--%>

<%@page import="com.productdeposit.dao.ConnectionDAO"%>
<%@page import="com.productdeposit.dao.ProductDAOImpl"%>
<%@page import="com.productdeposit.dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%
    ProductDAO productData = new ProductDAOImpl(ConnectionDAO.getCon());
%>

<%@ include file="WEB-INF/pages/header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add product</title>
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/resources/style.css">
    </head>
    <body>
        <div  class="container-fluid">
            <nav class="navbar navbar-light">
                <p class="navbar-brand">PRODUCT DEPOSIT MANAGEMENT</p>
                <div class="add-form">
                    <h3>
                        Add New Product:</h3>
                    <form action="AddProductServlet" method="post">
                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" class="form-control" name="name" required>
                        </div>
                        <div class="form-group">
                            <label>Measuring Unit</label>
                            <input type="text" class="form-control" name="unit" required>
                        </div>
                        <div class="form-group">
                            <label>Price per Unit</label>
                            <input type="text" class="form-control" name="price_unit" required>
                        </div>
                        <div class="form-group" >
                            <label>Quantity</label>
                            <input type="text" class="form-control" name="quantity" required>
                        </div>
                        <button><a class="cancel-btn" href="index.jsp">Cancel</a></button>
                        <button type="submit" class="btn btn-primary">OK</button>
                    </form>
                </div>
            </nav>
        </div>
    </body>
    <%@ include file="WEB-INF/pages/footer.jsp" %>
</html>
