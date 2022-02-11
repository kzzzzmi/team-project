<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  <link rel="stylesheet" href="/css/myInfo.css">
  <link rel="stylesheet" href="/css/style.css">
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
</head>

<body>
  <header>
    <div class="header-top">
      <div class="top-box">
        <div class="logo">
          <svg viewBox="0 0 26 26" class="naver-logo" aria-hidden="true" onclick="location.href = '/index'">
            <path fill="#fff" d="M0 26h26V0H0z"></path>
            <path fill="#07b495" d="M15.137 7v6.391L10.688 7H7v11.941h3.863v-6.39l4.449 6.39H19V7z"></path>
          </svg>
        </div>
        <h1 class="top-title">내정보</h1>
      </div>
    </div>
  </header>
  <div id="content" class="container" role="main">
    <section class="section">
      <div class="profile_img" role="region">
        <div class="profile_frame sp_after" id="profileModifyImageBtn">
          <a href="#" style="cursor: pointer;">
            <img src="/image/${principal.userDtl.profile_img}" id="principal-profile-img" width="102" height="102"
              alt="프로필이미지" class="profile-frame-image">
          </a>
        </div>

        <div class="profile_edit_area">
          <a href="/my/${principal.username}" style="cursor: pointer;"><span class="profile_name"
              id="principal-username">${principal.user.username}</i></span></a>
              <div>
          <span class="profile-name-text" id="principal-email" style="cursor: pointer;">${principal.user.email} </span>
          </div>
          <a href="#" class="qrcheck_btn" id="qrBtn" style="cursor: pointer;">
            <span><i class="fas fa-qrcode">QR체크인</i></span>
          </a>
          <a href="#" class="vaccine_btn" id="vaccineBtn" style="cursor: pointer;"><span><i class="fas fa-syringe"></i>
              잔여백신예약</span></a>
          <button type="button" class="logout_btn"><span>로그아웃</span></button>
        </div>
        
        <!-- 로그아웃 모달창 -->
        <div class="modal">
          <div class="logout-window">
            <div class="logout-text">로그아웃 하시겠습니까?</div>
            <div class="logout-btns">
              <button type="button" class="cancel-logout">취소</button>
              <button type="button" class="ok-logout" onclick="location.href = '/logout'">로그아웃</button>
            </div>
          </div>
        </div>
      </div>
    </section>
    <div class="information">
      <section class="user-info">
        <div class="user-detail">
          <strong>내 정보 수정</strong> 
          <img src="/image/${principal.userDtl.profile_img}" id="profile-img" class="profile-frame-image">

          <button type="button" class="profile-img-btn">프로필 사진변경</button>

        </div>
        <form enctype="multipart/form-data">
          <input type="file" id="file" name="file">
          <div class="edit-items">
            <aside>
              <label for="username-ip" class="edit-lb">사용자 이름</label>
            </aside>
            <div class="edit-ip">
              <input type="text" id="username-ip" class="profile-ip" name="username" value="${principal.user.username }"
                onclick="clearInput(this)" placeholder="최소 2글자 이상" minlength="2">
            </div>
          </div>
          <div class="edit-items">
            <aside>
              <label for="email-ip" class="edit-lb">이메일</label>
            </aside>
            <div class="edit-ip">
              <input type="email" id="email-ip" class="profile-ip" name="email" value="${principal.user.email }"
                onclick="clearInput(this)" >
            </div>
          </div>
          <div class="edit-items">
            <aside>
              <label for="phone-ip" class="edit-lb">전화번호</label>
            </aside>
            <div class="edit-ip">
              <input type="tel" id="phone-ip" class="profile-ip" name="phone" value="${principal.user.phone}"
                onclick="clearInput(this)" maxlength = "11" placeholder="전화번호 입력 ( - 생략)" >
              <button type="button" class="receive-sms">인증번호</button>
            </div>
          </div>
          <!-- 인증번호 확인 -->
          <div class="edit-items">
            <aside>
              <label for="check-sms"></label>
            </aside>
            <div class="edit-ip">
              <div class="sms-ip">
                <input type="text" class="user-edit phoneCheck" maxlength="6" value="인증번호 입력" onclick="clearInput(this)"
                  onClick="clearInput(this)" placeholder="인증번호를 입력하세요 (6자리)" readonly/>
              </div>
              <button type="button" class="receive-ok-sms">확인</button>
            </div>
          </div>
          <button type="button" class="submit-btn">수정완료</button>
           </form>
           <div class="edit-items">
            <aside>
              <label for="password-ip" class="password-lb">현재 비밀번호 </label>
            </aside>
            <div class="edit-ip">
              <input type="password" id="prepassword-ip" >
            </div>
          </div>
          <div class="edit-items">
            <aside>
              <label for="new-password-ip" class="newpassword-lb">새 비밀번호</label>
            </aside>
            <div class="edit-ip">
              <input type="password" id="new-password-ip" onclick="clearInput(this)" minlength = "4" placeholder="최소 4글자 이상">
            </div>
          </div>
            <div class="edit-items">
            <aside>
              <label for="re-password-ip" class="repassword-lb">새 비밀번호 확인</label>
            </aside>
            <div class="edit-ip">
              <input type="password" id="re-password-ip">
            </div>
          </div>
          <div>
            <button type="button" class="password-submit-btn">수정완료</button>
          </div>
          
           </section>
    </div>
  </div> 
  <script src="https://kit.fontawesome.com/c3df4d7d1c.js" crossorigin="anonymous"></script>
  <script src="/js/myInfo.js"></script>
</body>

</html>