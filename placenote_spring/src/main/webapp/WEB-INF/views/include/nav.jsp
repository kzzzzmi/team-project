<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<sec:authorize access="isAuthenticated">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>naver 플레이스</title>
<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="/css/nav.css" />
<link rel="stylesheet" href="/css/index.css" />
</head>

<body>
	<header>
		<div class="header-top">
			<div class="top-box">
				<div class="logo">
					<svg viewBox="0 0 26 26" class="naver-logo" aria-hidden="true">
		              <path fill="#fff" d="M0 26h26V0H0z"></path>
		              <path fill="#07b495"
							d="M15.137 7v6.391L10.688 7H7v11.941h3.863v-6.39l4.449 6.39H19V7z"></path>
		            </svg>
				</div>
				<div class="top-title">MY플레이스</div>
			</div>
		</div>
		<c:choose>
			<c:when test="${empty principal.user}">
				<div class="header-middle">
					<div class="header-profile">
						<button type="button" class="profile-login">
							<div class="profile-info">
								<div>
									<img src="/images/mona-loading-default.gif">
								</div>
								<div onclick="location.href ='/auth/signin'">로그인하기</div>
							</div>
						</button>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="profile-info-title-box">
					<div class="profile-info-title">
						<div class="profile-img-box">
							<img src="/image/${principal.userDtl.profile_img}">
						</div>
						<div class="profile-info-top">
							<h1 style="cursor: pointer"
								onclick="location.href = '/my/${principal.getUsername()}'">
								${principal.getUsername()}</h1>
						</div>

					</div>
				</div>
				<div class="profile-info-middle">
					<div class="profile-info-middle-item cursor-pointer">
						리뷰
						<div>
							<button>5</button>
						</div>
					</div>
					<div class="profile-info-middle-item cursor-pointer">
						사진
						<div>
							<button>5</button>
						</div>
					</div>
						<div class="profile-info-middle-item cursor-pointer" onclick="location.href = '/my/${principal.getUsername()}/following'">
							팔로잉
							<div>
								<button>230</button>
							</div>
						</div>
					<div class="profile-info-middle-item cursor-pointer" onclick="location.href = '/my/${principal.getUsername()}/follower'">
						팔로워
						<div>
							<button>100</button>
						</div>
					</div>
				</div>
				<div class="upload-board-btn">
					<a href="/upload"> <i class="far fa-edit"></i> 게시물 작성
					</a>
				</div>
			</c:otherwise>
		</c:choose>
		<div class="category-box">
			<ul class="category-menu">
				<li><a href="#"> <span class="category">피드</span>
				</a></li>
				<li><a href="#"> <span class="category">방문</span>
				</a></li>
				<li><a href="#"> <span class="category">리뷰</span>
				</a></li>
				<li><a href="#"> <span class="category">예약·주문</span>
				</a></li>
				<li><a href="#"> <span class="category">저장</span>
				</a></li>
			</ul>
		</div>
	</header>
</body>

</html>