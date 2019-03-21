<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
	<link href="<c:url value="/resource/css/login.css" />" rel="stylesheet">
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
					<li>
						<a href="#">
							<i class="fas fa-user"></i>Tài khoản
						</a>
					</li>
					<li><a href="#">Đăng kí</a></li>
					<li><a href="#">Đăng nhập</a></li>
				</ul>
			</div>	
		</div>
		<div class="header-mid">
			<div class="container container-flex">
				<div class="hero-img">
					<a href="#">
						<img src="<c:url value="/resource/img/logo-cake.png" /> alt="cake">
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
						<li><a href="#" class="current-nav">Trang chủ</a></li>
						<li>
							<a class="current-nav" href="#">Sản phẩm</a>
							<ul class="header-sub-nav">
								<li><a href="#">Sản phẩm 1</a></li>
								<li><a href="#">Sản phẩm 2</a></li>
								<li><a href="#">Sản phẩm 3</a></li>
							</ul>
						</li>
						<li><a href="#" class="current-nav">Giới thiệu</a></li>
						<li><a href="#" class="current-nav">Liên hệ</a></li>

					</ul>
				</div>	
		</div>
	</div>

	<div class="content">
		<div class="container">
			<div class="clearfix">
				<h2 class="page-title">Đăng Nhập</h2>
				<ul class="page-control">
					<li class="page-control-item"><a href="#">Home</a></li>
					<li>Đăng nhập</li>
				</ul>
			</div>
			<form:form action="/BookWebMVC/formLogin" method="POST" modelAttribute="user">
				<table class="content-login">
					<tr>
						<td>
							<h1 class="page-title">Đăng nhập</h1>
						</td>
					</tr>
					<tr>
						<spring:bind path="email">
								<div class="form-group ${status.error ? 'has-error' : ''}">
								<td class="name-input">Email*</td>
								<td>
									<form:input path="email" type="email" cssClass="input-login" required="required"/>
									<form:errors path="email" cssClass="has-error"/>
								</td>
							</div>	
						</spring:bind>
						<!-- <td class="name-input">Email address*</td>
						<td>
							<input type="Email" class="input-login" name="emailUser" required/>
						</td> -->
					</tr>
					<tr>
						<spring:bind path="password">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<td class="name-input">Password*</td>
								<td>
									<form:password path="password" cssClass="input-login" required="required"/>
									<form:errors path="password" cssClass="has-error"/>
								</td>
							</div>	
						</spring:bind>
						<!-- <td class="name-input">Password*</td>
						<td>
							<input type="Password" class="input-login" name="passwordUser" required/>
						</td> -->
					</tr>
					<tr>
						<td>
							<input type="submit" value="Login" id="btn-login">
						</td>
					</tr>
				</table>
			</form:form>
			
		</div>
	</div>	

	<div class="footer">
		<div class="footer-top">
			<div class="container container-flex-bot">
				<div class="instagram">
					<h1 class="info-title">Instagram Feed</h1>
				</div>
				<div class="information">
					<h1 class="info-title">Information</h1>
					<ul class="information-sub">
						<li>
							<a href=""><i class="fa fa-chevron-right"></i>
								Web Design
							</a>
						</li>
						<li>
							<a href=""><i class="fa fa-chevron-right"></i>
								Web Development
							</a>
						</li>
						<li>
							<a href=""><i class="fa fa-chevron-right"></i>
								Marketing
							</a>
						</li>
						<li>
							<a href=""><i class="fa fa-chevron-right"></i>
								Tips
							</a>
						</li>
						<li>
							<a href=""><i class="fa fa-chevron-right"></i>
								Resources
							</a>
						</li>
						<li>
							<a href=""><i class="fa fa-chevron-right"></i>
								Illustrations
							</a>
						</li>
					</ul>
				</div>
				<div class="contact">
					<div class="contact-sub">
						<h1 class="info-title">Contact Us</h1>
						<i class="fas fa-map-marker-alt"></i>
						<p class="font-size-p">30 South Park Avenue San Francisco, CA 94108 Phone: +78 123 456 78</p>
						<p class="font-size-p">Nemo enim ipsam voluptatem quia voluptas sit asnatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione.</p>
					</div>
				</div>
				<div class="subscribe">
					<h1 class="info-title">Newsletter Subscribe</h1>
					<form action="/">
						<input type="text" id="input-subscribe">
						<button class="btn-subscribe" type="submit">Subscribe <i class="fa fa-chevron-right"></i></button>
					</form>
				</div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container footer-bottom-flex">
				<p class="pull-left">Privacy policy. (©) 2014</p>
				<p class="pull-right">
					<a href="#">
						<img src="<c:url value="/resource/img/rectangle.jpg" /> alt="linhtinh">
					</a>
					<a href="#">
						<img src="<c:url value="/resource/img/rectangle.jpg" /> alt="linhtinh">
					</a>
					<a href="#">
						<img src="<c:url value="/resource/img/rectangle.jpg" /> alt="linhtinh">
					</a>
					<a href="#">
						<img src="<c:url value="/resource/img/rectangle.jpg" /> alt="linhtinh">
					</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>