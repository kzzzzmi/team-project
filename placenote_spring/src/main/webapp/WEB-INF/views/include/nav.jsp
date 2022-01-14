<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="/css/nav.css" />
<script
      src="https://kit.fontawesome.com/0bd5e629f4.js"
      crossorigin="anonymous"
></script>
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
		<div class="header-middle">
			<div class="header-profile">
				<button type="button" class="profile-login" onclick="location.href='/auth/signin'">
					<div>
						<img src="/images/profile_img.png" />
					</div>
					<div>로그인 하기</div>
				</button>
				<div class="upload-board-btn">
					<button>
						<i class="far fa-edit"></i> 게시물 작성
					</button>
				</div>
			</div>
		</div>
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