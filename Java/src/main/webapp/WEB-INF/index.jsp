	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Trang chủ</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
	<link href="<c:url value="/resource/css/index.css" />" rel="stylesheet">
	<style>
		.has-error {
			color: red;
		}
	</style>
</head>
<body>
    <div id="indexScreen">
        <div class="header">
            <div class="header-top">
                <div class="container container-flex">
                    <ul class="header-contact">
                        <li>
                            <a href="#">
                                <i class="fas fa-home"></i>Địa chỉ
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fas fa-phone"></i>Số điện thoại
                            </a>
                        </li>
                    </ul>
                    <ul class="header-menu">
                        <c:if test="${sessionScope.userName != null}">
                            <li>
                                <a href="#">
                                    <i class="fas fa-user"></i>${sessionScope.userName}
                                </a>
                            </li>
                            <li><a href="/BookWebMVC/logout">Đăng xuất</a></li>
                        </c:if>
                        <c:if test="${sessionScope.userName == null}">
                            <li><a href="/BookWebMVC/signup">Đăng kí</a></li>
                            <li><a href="/BookWebMVC/login">Đăng nhập</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
            <div class="header-mid">
                <div class="container container-flex">
                    <div class="hero-img">
                        <a href="/BookWebMVC/index">
						<img src="<c:url value="/resource/img/book-logo.png" />" alt="book logo">
					</a>
                    </div>
                    <div class="header-mid-right">
                        <div class="header-mid-margin">
                            <form action="/" id="form-search">
                                <input type="text" placeholder="Nhập từ khóa..." id="input-search">
                                <button class="fa fa-search" type="submit" id="btn-search"></button>
                            </form>
                        </div>
                        <div class="header-mid-margin">
                            <div class="cart">
                                <div class="cart-item">
                                    <i class="fa fa-shopping-cart"></i> Giỏ hàng (Trống)
                                    <i class="fa fa-chevron-down"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="header-bottom">
                <div class="container">
                    <ul class="header-nav">
                        <li class="home-page"><a href="/BookWebMVC/index" class="current-nav">Trang chủ</a></li>
                        <li>
                            <a class="current-nav" href="/BookWebMVC/category">Danh mục sách</a>
                            <ul class="header-sub-nav">
                                <c:forEach var="category" items="${lstCategory}">
                                    <li class="sub-list">
                                        <a href="/BookWebMVC/category?idCategory=${category.id}">${category.name} </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </li>
                        <li><a href="#" class="current-nav">Giới thiệu</a></li>
                        <li><a href="#" class="current-nav">Liên hệ</a></li>

                    </ul>
                </div>
            </div>
        </div>
        <div class="slide-img">
            <img src="<c:url value="/resource/img/slide.png" />" alt="slide">
        </div>
        <div class="content">
            <div class="container">
                <div class="clearfix">
                    <h2 class="page-title">New Products</h2>
                </div>
                <div class="product-list">
                    <c:forEach var="productByTime" items="${lstProductsByTime}">
                        <div class="product-item">
                            <a href="/BookWebMVC/product?id=${productByTime.id}"><img src="<c:url value="${productByTime.image}" />" class="img-product"></a>
                            <div class="product-item-detail">
                                <div class="product-title">
                                    <h3 class="product-name">${productByTime.name}</h3></div>
                                <h5 class="product-price">${productByTime.priceUnitProduct}${productByTime.donVi}</h5>
                                <div class="product-buy-detail">
                                    <a href="/BookWebMVC/product?id=${productByTime.id}" class="add-item-cart"><i class="fa fa-shopping-cart"></i></a>
                                    <a href="/BookWebMVC/product?id=${productByTime.id}" class="item-detail">Details<i class="fa fa-chevron-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="container">
                <div class="clearfix">
                    <h2 class="page-title">Top Products</h2>
                </div>
                <div class="product-list">
                    <c:forEach var="productByPrice" items="${lstProductByPrice}" begin="0" end="3">
                        <div class="product-item">
                            <a href="/BookWebMVC/product?id=${productByPrice.id}"><img src="<c:url value="${productByPrice.image}" />" class="img-product"></a>
                            <div class="product-item-detail">
                                <div class="product-title">
                                    <h3 class="product-name">${productByPrice.name}</h3></div>
                                <h5 class="product-price">${productByPrice.priceUnitProduct}${productByPrice.donVi}</h5>
                                <div class="product-buy-detail">
                                    <a href="/BookWebMVC/product?id=${productByPrice.id}" class="add-item-cart"><i class="fa fa-shopping-cart"></i></a>
                                    <a href="/BookWebMVC/product?id=${productByPrice.id}" class="item-detail">Details<i class="fa fa-chevron-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="product-list">
                    <c:forEach var="productByPrice" items="${lstProductByPrice}" begin="4" end="7">
                        <div class="product-item">
                            <a href="/BookWebMVC/product?id=${productByPrice.id}"><img src="<c:url value="${productByPrice.image}" />" class="img-product"></a>
                            <div class="product-item-detail">
                                <div class="product-title">
                                    <h3 class="product-name">${productByPrice.name}</h3></div>
                                <h5 class="product-price">${productByPrice.priceUnitProduct}${productByPrice.donVi}</h5>
                                <div class="product-buy-detail">
                                    <a href="/BookWebMVC/product?id=${productByPrice.id}" class="add-item-cart"><i class="fa fa-shopping-cart"></i></a>
                                    <a href="/BookWebMVC/product?id=${productByPrice.id}" class="item-detail">Details<i class="fa fa-chevron-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>