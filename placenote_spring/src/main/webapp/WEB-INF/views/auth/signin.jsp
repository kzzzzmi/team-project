<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>네이버 로그인</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/auth/signin.css">
</head>

<body>
	<div class="main-container">
		<div class="main-wrap">
			<header>
				<div class="sel-lang-wrap">
					<select class="lang-select">
						<option>한국어</option>
						<option>English</option>
					</select>
				</div>
				<div class="logo-wrap">
					<a href="../index"><img src="/images/naver.png"></a>
				</div>
			</header>
			<section class="login-input-section-wrap">
				<div class="Keyboard">
					<button>
						PC 키보드 보기<i class="fas fa-chevron-down"></i>
					</button>
				</div>


				<form action="/auth/signin" method="post">
					<div class="login-input-wrap">
						<div class="login-input-icon">
							<i class="far fa-user"></i>
						</div>
						<input type="text" name="username" placeholder="아이디"
							required="required"></input>
					</div>
					<div class="login-input-wrap password-wrap">
						<div class="login-input-icon">
							<i class="fas fa-unlock"></i>
						</div>
						<input type="password" name="password" placeholder="비밀번호"
							required="required"></input>
					</div>
					<div class="login-button-wrap">
						<button type="submit">로그인</button>
					</div>
				</form>
				<div class="login-stay-sign-in">
					<i class="far fa-check-circle"></i> <span>로그인 상태 유지</span>
				</div>
			</section>
			<section class="Easy-sgin-in-wrap">
				<h2>간편 로그인</h2>
				<ul class="sign-button-list">
					<li><button>
							<i class="fab fa-instagram" style="color: rgb(238, 40, 139);"></i><span>Instagram</span>
						</button></li>
					<li><a href="/oauth2/authorization/naver" class="si-google">
							<button>
								<i class="fab fa-google"></i><span>naver</span>
							</button>
					</a></li>

				</ul>
				<div class="forget-box">
					<a href="#">
						<p class="forget-msg">아이디 찾기</p>
					</a> <a href="#" class="fotget-msg-middle">
						<p class="forget-msg">비밀번호 찾기</p>
					</a> <a href="/auth/signup">
						<p class="forget-msg">회원가입</p>
					</a>
				</div>
			</section>
			<footer>
				<div class="copyright-wrap">
					<span> <img src="/images/naverfootimg.png"></span>
				</div>
				<div class="footer-logo">
					<a href="#"> <img src="/images/naverfooter_logo.png" alt="">
					</a> <a href="#"> <span>회원정보 고객센터</span>
					</a>
				</div>
			</footer>
		</div>
	</div>
	<script src="https://kit.fontawesome.com/51db22a717.js"
		crossorigin="anonymous"></script>
</body>

</html>