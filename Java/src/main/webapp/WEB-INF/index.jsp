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
	<%@ include file="header.jsp" %>
	<div class="slide-img">
		<img src="<c:url value="/resource/img/slide.png" />" alt="slide">
	</div>
	<div class="content">
		<div class="container">
			<div class="clearfix">
				<h2 class="page-title">New Products</h2>
			</div>
			<div class="product-list">
				<div class="product-item">
					<a href="#"><img src="<c:url value="/resource/img/product.jpg" />" class="img-product"></a>
					<div class="product-item-detail">
						<h3 class="product-name">Product Example</h3>	
						<h5 class="product-price">$30.00</h5>
						<div class="product-buy-detail">
							<a href="#" class="add-item-cart"><i class="fa fa-shopping-cart"></i></a>
							<a href="#" class="item-detail">Details<i class="fa fa-chevron-right"></i></a>
						</div>
					</div>
				</div>
				<div class="product-item">
					<a href="#"><img src="<c:url value="/resource/img/product.jpg" />" class="img-product"></a>
					<div class="product-item-detail">
						<h3 class="product-name">Product Example</h3>	
						<h5 class="product-price">$30.00</h5>
						<div class="product-buy-detail">
							<a href="#" class="add-item-cart"><i class="fa fa-shopping-cart"></i></a>
							<a href="#" class="item-detail">Details<i class="fa fa-chevron-right"></i></a>
						</div>
					</div>
				</div>
				<div class="product-item">
					<a href="#"><img src="<c:url value="/resource/img/product.jpg" />" class="img-product"></a>
					<div class="product-item-detail">
						<h3 class="product-name">Product Example</h3>	
						<h5 class="product-price">$30.00</h5>
						<div class="product-buy-detail">
							<a href="#" class="add-item-cart"><i class="fa fa-shopping-cart"></i></a>
							<a href="#" class="item-detail">Details<i class="fa fa-chevron-right"></i></a>
						</div>
					</div>
				</div>
				<div class="product-item">
					<a href="#"><img src="<c:url value="/resource/img/product.jpg" />" class="img-product"></a>
					<div class="product-item-detail">
						<h3 class="product-name">Product Example</h3>	
						<h5 class="product-price">$30.00</h5>
						<div class="product-buy-detail">
							<a href="#" class="add-item-cart"><i class="fa fa-shopping-cart"></i></a>
							<a href="#" class="item-detail">Details<i class="fa fa-chevron-right"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="clearfix">
				<h2 class="page-title">Top Products</h2>
			</div>
			<div class="product-list">
				<div class="product-item">
					<a href="#"><img src="<c:url value="/resource/img/product.jpg" />" class="img-product"></a>
					<div class="product-item-detail">
						<h3 class="product-name">Product Example</h3>	
						<h5 class="product-price">$30.00</h5>
						<div class="product-buy-detail">
							<a href="#" class="add-item-cart"><i class="fa fa-shopping-cart"></i></a>
							<a href="#" class="item-detail">Details<i class="fa fa-chevron-right"></i></a>
						</div>
					</div>
				</div>
				<div class="product-item">
					<a href="#"><img src="<c:url value="/resource/img/product.jpg" />" class="img-product"></a>
					<div class="product-item-detail">
						<h3 class="product-name">Product Example</h3>	
						<h5 class="product-price">$30.00</h5>
						<div class="product-buy-detail">
							<a href="#" class="add-item-cart"><i class="fa fa-shopping-cart"></i></a>
							<a href="#" class="item-detail">Details<i class="fa fa-chevron-right"></i></a>
						</div>
					</div>
				</div>
				<div class="product-item">
					<a href="#"><img src="<c:url value="/resource/img/product.jpg" />" class="img-product"></a>
					<div class="product-item-detail">
						<h3 class="product-name">Product Example</h3>	
						<h5 class="product-price">$30.00</h5>
						<div class="product-buy-detail">
							<a href="#" class="add-item-cart"><i class="fa fa-shopping-cart"></i></a>
							<a href="#" class="item-detail">Details<i class="fa fa-chevron-right"></i></a>
						</div>
					</div>
				</div>
				<div class="product-item">
					<a href="#"><img src="<c:url value="/resource/img/product.jpg" />" class="img-product"></a>
					<div class="product-item-detail">
						<h3 class="product-name">Product Example</h3>	
						<h5 class="product-price">$30.00</h5>
						<div class="product-buy-detail">
							<a href="#" class="add-item-cart"><i class="fa fa-shopping-cart"></i></a>
							<a href="#" class="item-detail">Details<i class="fa fa-chevron-right"></i></a>
						</div>
					</div>
				</div>
			</div>
			<div class="product-list">
				<div class="product-item">
					<a href="#"><img src="<c:url value="/resource/img/product.jpg" />" class="img-product"></a>
					<div class="product-item-detail">
						<h3 class="product-name">Product Example</h3>	
						<h5 class="product-price">$30.00</h5>
						<div class="product-buy-detail">
							<a href="#" class="add-item-cart"><i class="fa fa-shopping-cart"></i></a>
							<a href="#" class="item-detail">Details<i class="fa fa-chevron-right"></i></a>
						</div>
					</div>
				</div>
				<div class="product-item">
					<a href="#"><img src="<c:url value="/resource/img/product.jpg" />" class="img-product"></a>
					<div class="product-item-detail">
						<h3 class="product-name">Product Example</h3>	
						<h5 class="product-price">$30.00</h5>
						<div class="product-buy-detail">
							<a href="#" class="add-item-cart"><i class="fa fa-shopping-cart"></i></a>
							<a href="#" class="item-detail">Details<i class="fa fa-chevron-right"></i></a>
						</div>
					</div>
				</div>
				<div class="product-item">
					<a href="#"><img src="<c:url value="/resource/img/product.jpg" />" class="img-product"></a>
					<div class="product-item-detail">
						<h3 class="product-name">Product Example</h3>	
						<h5 class="product-price">$30.00</h5>
						<div class="product-buy-detail">
							<a href="#" class="add-item-cart"><i class="fa fa-shopping-cart"></i></a>
							<a href="#" class="item-detail">Details<i class="fa fa-chevron-right"></i></a>
						</div>
					</div>
				</div>
				<div class="product-item">
					<a href="#"><img src="<c:url value="/resource/img/product.jpg" />" class="img-product"></a>
					<div class="product-item-detail">
						<h3 class="product-name">Product Example</h3>	
						<h5 class="product-price">$30.00</h5>
						<div class="product-buy-detail">
							<a href="#" class="add-item-cart"><i class="fa fa-shopping-cart"></i></a>
							<a href="#" class="item-detail">Details<i class="fa fa-chevron-right"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>	
	<%@ include file="footer.jsp" %>
</body>
</html>