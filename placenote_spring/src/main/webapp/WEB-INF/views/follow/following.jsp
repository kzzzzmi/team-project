<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<sec:authorize access="isAuthenticated">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>naver 플레이스</title>
<link rel="stylesheet" href="/css/following.css">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://kit.fontawesome.com/c3df4d7d1c.js"
	crossorigin="anonymous">
	
</script>

</head>

<body>

	<nav>
		<div class="container">
			<div class="back-page-btn">
				<button type="button" style="border: none; background-color: white;"
					onclick="location.href='/my/${username}'">
					<i class="fas fa-arrow-left"></i>
				</button>
				<span>${username}</span>
			</div>
		</div>
	</nav>
	<div class="menu-box">
		<div class="menu">
			<div class="menu-btn">
				<button onclick="location.href='/my/${username}/following'" style="background-color: #333333 ; color: white;">
					팔로잉 <span class="following-total-count">0</span>
				</button>
				<button onclick="location.href='/my/${username}/follower'">
					팔로워 <span class="follower-total-count">0</span>
				</button>
			</div>
		</div>
	</div>
	<div class="following-info-box">
		<ul class="getfollowing-info">

		</ul>
	</div>
	<input type="hidden" value="${username}" class="getUsername">

	<script src="/js/followingInfo.js"></script>

</body>

</html>