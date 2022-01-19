<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri = "http://www.springframework.org/security/tags"  prefix="sec"%>
	<sec:authorize access="isAuthenticated">
	<sec:authentication property="principal" var ="principal"/>
	</sec:authorize>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>네이버 MY 플레이스</title>
    <link rel="stylesheet" href="/css/feed.css">
    <link rel="stylesheet" href="/feed.js">
    <script src="https://kit.fontawesome.com/c3df4d7d1c.js" crossorigin="anonymous"></script>
</head>

<body>
    <nav>
        <div class="text-container">
            <div class="text-body">
                <div class="text-body-header">
                    <div class="body-header-link-naver">
                        <a href="https://www.naver.com/" class="link-naver">
                            <img src="/images/naver-logo.png" width="20px" height="20px">
                        </a>
                        <a href="https://m.place.naver.com/" class="link-index">MY플레이스</a>
                    </div>
                    <div class="body-header-save">
                        <button class="body-header-save-btn"><i class="fas fa-pen"></i>리뷰 참여</button>
                    </div>
                </div>
    </nav>
    <section>

        <main>
            <div class="header">
                <header class="profile-header">
                    <div class="profile-img">
                        <img src="/images/profile_img.png">
                    </div>
                    <div class="profile-info">
                        <div class="profile-info-top">
                            <h1 class="profile-username">${principal.getUsername() }</h1>
                            <input type="button" class="profile-edit-btn" value="팔로우" ></input>
                        </div>
                        <div class="profile-info-middle">
                            <div class="profile-info-middle-item">리뷰
                                <div>
                                    <button>5</button>
                                </div>
                            </div>
                            <div class="profile-info-middle-item cursor-pointer">사진
                                <div>
                                    <button>5</button>
                                </div>
                            </div>
                            <div class="profile-info-middle-item cursor-pointer" onclick="location.href = '/follow/following'">팔로잉
                                <div>
                                    <button >0</button>
                                </div>
                            </div>
                            <div class="profile-info-middle-item cursor-pointer" onclick="location.href = '/follow/follow'">팔로워
                                <div>
                                    <button>0</button>
                                </div>
                            </div>
                        </div>

                    </div>
                </header>
            </div>
        </main>

    </section>
    <section>
        <div class="container">
            <div class="board-box">
                <div class="main-category">
                    <div class="main-category-left">
                        <div class="main-category-btnbox">
                            <button class="main-category-btns">
                                <i class="fas fa-bars"></i> 전체
                            </button>
                        </div>
                        <div class="main-category-btnbox">
                            <button class="main-category-btns" onclick="location.href='/feed/feedImg'">
                                <i class="fas fa-images"></i> 사진
                            </button>
                        </div>
                    </div>
                    <div class="main-category-right">
                        <button>최신순 <i class="fas fa-chevron-down"></i> </button>
                    </div>
                </div>

                <div class="sub-category">
                    <div>
                        <button>전체</button>
                    </div>
                    <div>
                        <button>한식</button>
                    </div>
                    <div>
                        <button>중식</button>
                    </div>
                    <div>
                        <button>양식</button>
                    </div>
                    <div>
                        <button>일식</button>
                    </div>
                </div>

                <ul class="board-list">
                    <li class="board-list-item">
                        <div class="board-list-item-box">
                            <div class="board-title">
                                <button class="board-profile-btn">
                                    <div class="board-text">
                                        <div class="board-profile-username">용이초밥 광안리점</div>
                                        <div class="board-place">부산시 광안동</div>
                                    </div>
                                    <div>
                                        <pre
                                            class="board-item-text">완전 친절하고 서비스도 주시고 청결하고 맛도 좋고 백점짜리 초밥집이네요!! 다<br>시오고 싶은 매장입니다 ㅎ</pre>
                                    </div>
                                </button>
                                <div class="board-img-content">
                                    <button>
                                        <img src="/images/content-img.png" style="outline: none;">
                                    </button>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="board-list-item">
                        <div class="board-list-item-box">
                            <div class="board-title">
                                <button class="board-profile-btn">
                                    <div class="board-text">
                                        <div class="board-profile-username">용이초밥 광안리점</div>
                                        <div class="board-place">부산시 광안동</div>
                                    </div>
                                    <div>
                                        <pre
                                            class="board-item-text">완전 친절하고 서비스도 주시고 청결하고 맛도 좋고 백점짜리 초밥집이네요!! 다<br>시오고 싶은 매장입니다 ㅎ</pre>
                                    </div>
                                </button>
                                <div class="board-img-content">
                                    <button>
                                        <img src="/images/content-img.png" style="outline: none;">
                                    </button>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="board-list-item">
                        <div class="board-list-item-box">
                            <div class="board-title">
                                <button class="board-profile-btn">
                                    <div class="board-text">
                                        <div class="board-profile-username">용이초밥 광안리점</div>
                                        <div class="board-place">부산시 광안동</div>
                                    </div>
                                    <div>
                                        <pre
                                            class="board-item-text">완전 친절하고 서비스도 주시고 청결하고 맛도 좋고 백점짜리 초밥집이네요!! 다<br>시오고 싶은 매장입니다 ㅎ</pre>
                                    </div>
                                </button>
                                <div class="board-img-content">
                                    <button>
                                        <img src="/images/content-img.png" style="outline: none;">
                                    </button>
                                </div>
                            </div>
                        </div>
                    </li>
                    <footer>
                        <div class="footer-logo">
                            <a href="#">
                                <img src="images/naverfooter_logo.png" alt="">
                            </a>
                            <a href="#">
                                <span>회원정보 고객센터</span>
                            </a>
                            <a href="">
                                <span>공지사항</span>
                            </a>
                        </div>
                    </footer>
    </section>
 
   
    <script src="/js/following.js"></script>
</body>

</html>