<%-- 
    Document   : deleteproduct
    Created on : 06.01.2021, 14:52:13
    Author     : munte
--%>

<%@page import="com.productdeposit.model.Product"%>
<%@page import="com.productdeposit.dao.ConnectionDAO"%>
<%@page import="com.productdeposit.dao.ProductDAOImpl"%>
<%@page import="com.productdeposit.dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Integer id = Integer.parseInt(request.getParameter("id"));
    ProductDAO prd = new ProductDAOImpl(ConnectionDAO.getCon());
    Product pr = prd.selectProduct(id);
    request.setAttribute("delete_product", pr);
%>

<%@ include file="WEB-INF/pages/header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete product</title>
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/resources/style.css">
    </head>
    <body>
        <div  class="container-fluid">
            <nav class="navbar navbar-light">
                <p class="navbar-brand">PRODUCT DEPOSIT MANAGEMENT</p>
                <div class="add-form">
                    <h3>
                        Are you sure you want to delete this product?</h3>
                    <form action="DeleteProductServlet" method="post">
                        <div class="form-group">
                            <label>Id</label>
                            <input type="text" class="form-control" name="id" 
                                   value="${delete_product.id}" required readonly>
                        </div>
                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" class="form-control" name="name" 
                                   value="${delete_product.nume}" required readonly>
                        </div>
                        <div class="form-group">
                            <label>Measuring Unit</label>
                            <input type="text" class="form-control" name="unit" 
                                   value="${delete_product.unit}" required readonly>
                        </div>
                        <div class="form-group">
                            <label>Price per Unit</label>
                            <input type="text" class="form-control" name="price_unit" 
                                   value="${delete_product.priceUnit}" required readonly>
                        </div>
                        <div class="form-group" >
                            <label>Quantity</label>
                            <input type="text" class="form-control" name="quantity"
                                   value="${delete_product.quantity}" required readonly>
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
