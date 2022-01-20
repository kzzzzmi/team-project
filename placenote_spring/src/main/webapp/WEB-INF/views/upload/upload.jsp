<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/css/upload.css" />
<title>업로드</title>
<script src="https://kit.fontawesome.com/0bd5e629f4.js"
	crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
	<div class="text-container">
		<div class="text-body">
			<div class="text-body-header">
				<div class="body-header-link-naver">
					<a href="https://www.naver.com/" class="link-naver"> <img
						src="/images/naver-logo.png" width="20px" height="20px" />
					</a> <a href="https://m.place.naver.com/" class="link-index">MY플레이스</a>
				</div>
				<div class="body-header-save">
					<button type="button" class="body-header-save-btn">게시</button>
				</div>
			</div>

			<div class="text-body-toolBox">
				<div class="body-toolBox-iconBox">
					<div class="body-iconBox">
						<div class="iconBox-icon">
							<div class="iconBox-icon-img">
								<i class="far fa-image"></i>
							</div>
							<div class="iconBox-icon-name">사진</div>
						</div>

						<div class="iconBox-icon">
							<div class="iconBox-icon-img">
								<i class="fas fa-map-marker-alt"></i>
							</div>
							<div class="iconBox-icon-name">장소</div>
						</div>
						<div class="iconBox-icon">
							<div class="iconBox-icon-img">
								<i class="fas fa-laugh"></i>
							</div>
							<div class="iconBox-icon-name">스티커</div>
						</div>
						<div class="iconBox-icon">
							<div class="iconBox-icon-img">
								<i class="fas fa-quote-left"></i>
							</div>
							<div class="iconBox-icon-name">인용구</div>
						</div>
					</div>
				</div>

				<div class="body-fontBox">
					<div class="fontBox-items">
						<div class="fontBox-items-left">
							<select name="keyword">
								<option value="ko_food">한식</option>
								<option value="ch_food">중식</option>
								<option value="ja_food">일식</option>
								<option value="it_food">양식</option>
								<option value="ca_food">카페</option>
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="file-boxs">
				<div class="file-box"></div>
			</div>
			<form action="">
				<div class="text-body-main">
					<div class="text-body-mainBox">
						<div class="mainBox-text">
							<input id="text-title" type="text" name="placeName"
								placeholder="맛집이름" />
							<textarea id="text-content" cols="90%" rows="35%"
								name="boardContent" placeholder="맛집을 소개해주세요!"></textarea>
						</div>
					</div>
				</div>
				<input type="file" class="file" name="files" multiple="multiple" accept=".png, .jpeg, .jpg" />
			</form>
		</div>
	</div>
	<script src="/js/upload.js"></script>
</body>
</html>
