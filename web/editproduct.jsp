<%-- 
    Document   : editproduct
    Created on : 06.01.2021, 14:22:56
    Author     : munte
--%>

<%@page import="com.productdeposit.model.Stock"%>
<%@page import="com.productdeposit.dao.StockDAOImpl"%>
<%@page import="com.productdeposit.dao.StockDAO"%>
<%@page import="com.productdeposit.model.Product"%>
<%@page import="com.productdeposit.dao.ProductDAO"%>
<%@page import="com.productdeposit.dao.ConnectionDAO"%>
<%@page import="com.productdeposit.dao.ProductDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    ProductDAO prd = new ProductDAOImpl(ConnectionDAO.getCon());
    Product pr = prd.selectProduct(id);
    request.setAttribute("edit_product", pr);
    StockDAO std = new StockDAOImpl(ConnectionDAO.getCon());
    Stock st = std.selectStock(id);
    request.setAttribute("edit_stock", st);
%>

<%@ include file="WEB-INF/pages/header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit product</title>
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/resources/style.css">
    </head>
    <body>
        <div  class="container-fluid">
            <nav class="navbar navbar-light">
                <p class="navbar-brand">PRODUCT DEPOSIT MANAGEMENT</p>
                <div class="add-form">
                    <h3>
                        Edit Product:</h3>
                    <form action="EditProductServlet" method="post">
                        <div class="form-group">
                            <label>Id</label>
                            <input type="text" class="form-control" name="id" 
                                   value="${edit_product.id}" required>
                        </div>
                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" class="form-control" name="name" 
                                   value="${edit_product.name}" required>
                        </div>
                        <div class="form-group">
                            <label>Measuring Unit</label>
                            <input type="text" class="form-control" name="unit" 
                                   value="${edit_product.unit}" required>
                        </div>
                        <div class="form-group">
                            <label>Price per Unit</label>
                            <input type="text" class="form-control" name="price_unit" 
                                   value="${edit_stock.priceUnit}" required>
                        </div>
                        <div class="form-group" >
                            <label>Quantity</label>
                            <input type="text" class="form-control" name="quantity"
                                   value="${edit_stock.quantity}" required>
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
