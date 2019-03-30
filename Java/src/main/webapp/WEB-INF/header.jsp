<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Đăng nhập</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
	<link href="<c:url value="/resource/css/index.css" />" rel="stylesheet">
	<style>
		.has-error {
			color: red;
		}
	</style>
</head>
<body>
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
						<li>
							<a href="#">
								<i class="fas fa-user"></i>Tài khoản
							</a>
						</li>
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
								<i class="fa fa-shopping-cart"></i>
								 Giỏ hàng (Trống) 
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
						<li><a href="/BookWebMVC/index" class="current-nav">Trang chủ</a></li>
						<li>
							<a class="current-nav" href="#">Danh mục sách</a>
							<ul class="header-sub-nav">
							<c:forEach var="category" items="${lstCategory}">
								<li class="sub-list">
	  								<a href="#">${category.name} </a>
	  								<%-- <ul class="sub-product">
	  									<c:forEach var="product" items="${category.listProduct}">
	  										<li><a href="#">${product.name}</a></li>
	  									</c:forEach>
	  								</ul> --%>
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
</body>
</html>