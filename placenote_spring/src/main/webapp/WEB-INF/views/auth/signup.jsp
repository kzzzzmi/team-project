<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>회원가입</title>
<link rel="stylesheet" href="/css/auth/signup.css" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<header>
		<h1>
			<a href="http://www.naver.com/"> <span>NAVER</span>
			</a>
		</h1>
	</header>

	<main>
		<div id="container">
			<div id="content">
				<div id="join_content">
					<div class="row_group">
						<div class="join_row">
							<h3 class="join_title">
								<label for="id">아이디</label>
							</h3>
							<input type="text" id="username" class="long_text su-inputs"
								maxlength="12" required /> <span class="idCheck_false">이미
								존재하는 아이디입니다.</span>
						</div>
						<div class="join_row">
							<h3 class="join_title">
								<label for="password">비밀번호</label>
							</h3>
							<input type="password" class="long_text su-inputs" maxlength="20"
								id="password" required />
						</div>
						<div class="join_row">
							<h3 class="join_title">
								<label for="repassword">비밀번호 확인</label>
							</h3>
							<input type="password" class="long_text" id="repassword"
								maxlength="20" required /> <span class="text_required">필수
								정보입니다.</span>
						</div>
					</div>
					<div class="row_group">
						<div class="join_row">
							<h3 class="join_title">
								<label for="name">이름</label>
							</h3>
							<input type="text" class="long_text su-inputs" id="name" required />

						</div>
						<div class="join_row">
							<h3 class="join_title">
								<label for="gender">성별</label>
							</h3>
							<select class="long_text su-inputs" id="gender">
								<option value="남성">남성</option>
								<option value="여성">여성</option>
							</select>
						</div>
						<div class="join_row">
							<h3 class="join_title">
								<label for="email">본인확인 이메일</label>
							</h3>
							<input type="email" class="long_text su-inputs" id="email"
								required />
						</div>
						<div class="join_row">
							<h3 class="join_title">
								<label for="phone">휴대전화</label>
							</h3>
							<div class="phone_flex">
								<input type="tel" class="long_text su-inputs" maxlength="11"
									placeholder="전화번호 입력 ( - 생략)" required />
								<button type="button" class="short_text auth-number-btn">인증번호
									받기</button>
							</div>
							<div class="phone_flex">
								<input type="text" class="long_text phoneCheck" placeholder="인증번호를 입력하세요 (6자리)" maxlength="6"
									readonly />
								<button type="button" class="short_text auth-check-btn">인증번호
									확인</button>
							</div>

							<div class="join_row">
								<button type="button" class="join_submit">가입하기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<footer>
		<ul>
			<li><a href="http://policy.naver.com/rules/service.html">이용약관</a>
			</li>
			<li><strong><a
					href="http://policy.naver.com/policy/privacy.html">개인정보처리방침</a></strong></li>
			<li><a href="http://policy.naver.com/rules/disclaimer.html">책임의
					한계와 법적고지</a></li>
			<li><a
				href="https://help.naver.com/support/alias/membership/p.membership/p.membership_26.naver"
				target="_blank">회원정보 고객센터 </a></li>
		</ul>
		<address>
			<em><a href="https://www.navercorp.com/" target="_blank"
				class="logo"><span class="blind">naver</span></a></em> <em clas..s="copy">Copyright</em>
			<em class="u_cri">©</em> <a href="https://www.navercorp.com/"
				target="_blank" class="u_cra">NAVER Corp.</a> <span class="all_r">All
				Rights Reserved.</span>
		</address>
	</footer>
	<script src="/js/auth/signup.js"></script>
</body>
</html>

