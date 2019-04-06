<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Product</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
	<link href="<c:url value="/resource/css/product.css" />" rel="stylesheet">
	<script src="<c:url value="/resource/js/product.js" />"></script>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="content">
		<div class="container">
			<div class="clearfix">
				<h2 class="page-title">Product</h2>
				<ul class="page-control">
					<li class="page-control-item"><a href="#">Home</a></li>
					<li>Product</li>
				</ul>
			</div>
			<div class="product-title">
				<div class="content-left">
					<div class="product-img-price">
						<div class="img-product-hero">
							<img src="<c:url value="/resource/img/product.jpg" />" alt="img-product">
						</div>
						<div class="title-product">
							<h3 class="product-name-hero">Product Example</h3>	
							<h5 class="product-price">$30.00</h5>
							<p class="product-info">Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo ms id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe</p>
							<p>Số lượng:</p>
							<div class="option-buy">
								<button class="button-config" id="reduce" onclick="setChange('reduce')"><i class="fas fa-minus"></i></button>
								<input type="number" value="1" id="quantity">
								<button class="button-config" id="increase" onclick="setChange('increase')"><i class="fas fa-plus"></i></button>
							</div>
							<div class="add-to-cart">
								<a href="#" class="add-item-cart-related"><i class="fa fa-shopping-cart"></i></a>
								<a href="#" class="buy-now">Mua ngay</a>
							</div>
						</div>
					</div>
					<div class="description-reviews">
						<div class="tab">
							<button class="tablinks" onclick="openAction(event, 'description')" id="defaultOpen">Description</button>
							<button class="tablinks" onclick="openAction(event, 'reviews')">Reviews</button>
						</div>

						<div id="description" class="tabcontent">
							<p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet.

							Consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequaturuis autem vel eum iure reprehenderit qui in ea voluptate velit es quam nihil molestiae consequr, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?
							</p>
						</div>

						<div id="reviews" class="tabcontent">
							<p>No Reviews</p> 
						</div>
					</div>
					<div class="clearfix">
						<h2 class="page-title">Related Products</h2>
					</div>
					<div class="product-list">
						<div class="product-item-related">
							<a href="#"><img src="<c:url value="/resource/img/product.jpg" />" alt="img-product" class="img-product-related"></a>
							<div class="product-item-detail-related">
								<h3 class="product-name-related">Product Example</h3>	
								<h5 class="product-price-related">$30.00</h5>
								<div class="product-buy-detail-related">
									<a href="#" class="add-item-cart-related"><i class="fa fa-shopping-cart"></i></a>
									<a href="#" class="item-detail-related">Details<i class="fa fa-chevron-right"></i></a>
								</div>
							</div>
						</div>
						<div class="product-item-related">
							<a href="#"><img src="<c:url value="/resource/img/product.jpg" />" alt="img-product" class="img-product-related"></a>
							<div class="product-item-detail-related">
								<h3 class="product-name-related">Product Example</h3>	
								<h5 class="product-price-related">$30.00</h5>
								<div class="product-buy-detail-related">
									<a href="#" class="add-item-cart-related"><i class="fa fa-shopping-cart"></i></a>
									<a href="#" class="item-detail-related">Details<i class="fa fa-chevron-right"></i></a>
								</div>
							</div>
						</div>
						<div class="product-item-related">
							<a href="#"><img src="<c:url value="/resource/img/product.jpg" />" alt="img-product" class="img-product-related"></a>
							<div class="product-item-detail-related">
								<h3 class="product-name-related">Product Example</h3>	
								<h5 class="product-price-related">$30.00</h5>
								<div class="product-buy-detail-related">
									<a href="#" class="add-item-cart-related"><i class="fa fa-shopping-cart"></i></a>
									<a href="#" class="item-detail-related">Details<i class="fa fa-chevron-right"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="content-right">
					<div class="list-product">
						<h3 class="list-product-title">Best Sellers</h3>
						<div class="list-product-body">
							<div class="product-item-mini">
								<a class="img-product-item" href="#">
									<img src="<c:url value="/resource/img/product-mini.png" />" alt="img-product" class="img-product-mini">
								</a>
								<div class="media-body">
									Sample Woman Top
									<span class="beta-sales-price">$34.55</span>
								</div>
							</div>
							<div class="product-item-mini">
								<a class="img-product-item" href="#">
									<img src="<c:url value="/resource/img/product-mini.png" />" alt="img-product" class="img-product-mini">
								</a>
								<div class="media-body">
									Sample Woman Top
									<span class="beta-sales-price">$34.55</span>
								</div>
							</div>
							<div class="product-item-mini">
								<a class="img-product-item" href="#">
									<img src="<c:url value="/resource/img/product-mini.png" />" alt="img-product" class="img-product-mini">
								</a>
								<div class="media-body">
									Sample Woman Top
									<span class="beta-sales-price">$34.55</span>
								</div>
							</div>
							<div class="product-item-last">
								<a class="img-product-item" href="#">
									<img src="<c:url value="/resource/img/product-mini.png" />" alt="img-product" class="img-product-mini">
								</a>
								<div class="media-body">
									Sample Woman Top
									<span class="beta-sales-price">$34.55</span>
								</div>
							</div>
						</div>
					</div>
					<div class="list-product">
						<h3 class="list-product-title">New Products</h3>
						<div class="list-product-body">
							<div class="product-item-mini">
								<a class="img-product-item" href="#">
									<img src="<c:url value="/resource/img/product-mini.png" />" alt="img-product" class="img-product-mini">
								</a>
								<div class="media-body">
									Sample Woman Top
									<span class="beta-sales-price">$34.55</span>
								</div>
							</div>
							<div class="product-item-mini">
								<a class="img-product-item" href="#">
									
									<img src="<c:url value="/resource/img/product-mini.png" />" alt="img-product" class="img-product-mini">
								</a>
								<div class="media-body">
									Sample Woman Top
									<span class="beta-sales-price">$34.55</span>
								</div>
							</div>
							<div class="product-item-mini">
								<a class="img-product-item" href="#">
									<img src="<c:url value="/resource/img/product-mini.png" />" alt="img-product" class="img-product-mini">
								</a>
								<div class="media-body">
									Sample Woman Top
									<span class="beta-sales-price">$34.55</span>
								</div>
							</div>
							<div class="product-item-last">
								<a class="img-product-item" href="#">
									<img src="<c:url value="/resource/img/product-mini.png" />" alt="img-product" class="img-product-mini">
								</a>
								<div class="media-body">
									Sample Woman Top
									<span class="beta-sales-price">$34.55</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>	
	<%@ include file="footer.jsp" %>
	<script>
		document.getElementById("defaultOpen").click();
	</script>
</body>
</html>