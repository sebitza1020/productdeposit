<%-- 
    Document   : index
    Created on : 17.12.2020, 19:24:27
    Author     : munte
--%>

<%@page import="com.productdeposit.model.Stock"%>
<%@page import="com.productdeposit.dao.StockDAOImpl"%>
<%@page import="com.productdeposit.dao.StockDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.productdeposit.model.Product"%>
<%@page import="com.productdeposit.dao.ConnectionDAO"%>
<%@page import="com.productdeposit.dao.ProductDAOImpl"%>
<%@page import="com.productdeposit.dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<%@ include file="WEB-INF/pages/header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/resources/style.css">
    </head>
    <body>
        <div  class="container-fluid">
            <nav class="navbar navbar-light">
                <p class="navbar-brand">PRODUCT DEPOSIT MANAGEMENT</p>
                <form class="form-inline" method="get">
                    <button><a class="new-btn" href="addproduct.jsp">New</a></button>
                    <input class="search" type="search" name="search" placeholder="Search" aria-label="Search">
                    <button class="search-btn" type="submit">Search</button>
                </form>
            </nav>
        </div>
        <div class="container">
            <div class="inner">
                <div class="row">
                    <div class="dates">
                        <table class="table">
                            <thead class="bg-light">
                                <tr>
                                    <th scope="col">Name</th>
                                    <th scope="col">Unit</th>
                                    <th scope="col">Price/Unit</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    ProductDAO productData = new ProductDAOImpl(ConnectionDAO.getCon());
                                    List<Product> products = productData.getAllProducts(request.getParameter("search"));
                                    request.setAttribute("PRODUCTS_LIST", products);
                                    StockDAO stockData = new StockDAOImpl(ConnectionDAO.getCon());
                                    List<Stock> stocks = stockData.getAllStocks();
                                    request.setAttribute("STOCK_LIST", stocks);
                                %>
                                <c:forEach var="tempProd" items="${PRODUCTS_LIST}" varStatus="status">
                                    <tr>
                                        <td>${tempProd.name}</td>
                                        <td>${tempProd.unit}</td>
                                        <td>${STOCK_LIST[status.index].priceUnit}</td>
                                        <td>${STOCK_LIST[status.index].quantity}</td>
                                        <td><button><a class="btn-btn-primary" href="editproduct.jsp?id=${tempProd.id}">Edit</a></button> 
                                            <button><a class="btn-btn-primary" href="deleteproduct.jsp?id=${tempProd.id}">Delete</a></button></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <%@ include file="WEB-INF/pages/footer.jsp" %>

</html>
