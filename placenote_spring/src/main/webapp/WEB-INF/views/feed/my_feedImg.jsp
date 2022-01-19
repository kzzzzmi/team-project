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
    <title>Instagram</title>
    <link rel="stylesheet" href="/css/feedImg.css">
    <script src="https://kit.fontawesome.com/c3df4d7d1c.js" crossorigin="anonymous"></script>
    <script>

    </script>
</head>

<body>
    <nav>
        <div class="text-container">
            <div class="text-body">
                <div class="text-body-header">
                    <div class="body-header-link-naver">
                        <a href="#" class="link-naver" onclick="location.href = '/index'">
                            <img src="/images/naver-logo.png" width="20px" height="20px">
                        </a>
                        <a href="#" class="link-index">MY플레이스</a>
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
                            <h1 class="profile-username">${principal.getUsername()}</h1>
                              <input type="button" class="profile-edit-btn" value="프로필편집" ></input>
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
                                    <button>0</button>
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
                            <button class="main-category-btns" onclick="location.href = '/feed/my_feed'">
                                <i class="fas fa-bars"></i> 전체
                            </button>
                        </div>
                        <div class="main-category-btnbox">
                            <button class="main-category-btns">
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
                <section>
                    <div class="board-list-group">
                        <div class="board-list-item">
                            <div class="board-list-item-box">
                                <div class="board-title">
                                    <div class="board-img-btn-box">
                                        <button class="board-img-btn" type="button">
                                            <div class="board-img">
                                                <img src="/images/content-img.png">
                                            </div>
                                            <div class="board-text-box">
                                                <div class="board-text">제주시 애월읍</div>
                                                <div class="board-place-name">새빌</div>
                                            </div>
                                            <div class="like-btn">
                                                <div><i class="far fa-heart"></i></div>
                                            </div>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="board-list-item">
                            <div class="board-list-item-box">
                                <div class="board-title">
                                    <div class="board-img-btn-box">
                                        <button class="board-img-btn" type="button">
                                            <div class="board-img">
                                                <img src="/images/content-img.png">
                                            </div>
                                            <div class="board-text-box">
                                                <div class="board-text">제주시 애월읍</div>
                                                <div class="board-place-name">새빌</div>
                                            </div>
                                            <div class="like-btn">
                                                <div><i class="far fa-heart"></i></div>
                                            </div>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="board-list-item">
                            <div class="board-list-item-box">
                                <div class="board-title">
                                    <div class="board-img-btn-box">
                                        <button class="board-img-btn" type="button">
                                            <div class="board-img">
                                                <img src="/images/content-img.png">
                                            </div>
                                            <div class="board-text-box">
                                                <div class="board-text">제주시 애월읍</div>
                                                <div class="board-place-name">새빌</div>
                                            </div>
                                            <div class="like-btn">
                                                <div><i class="far fa-heart"></i></div>
                                            </div>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                </section>
                <section>
                    <div class="board-list-group">
                        <div class="board-list-item">
                            <div class="board-list-item-box">
                                <div class="board-title">
                                    <div class="board-img-btn-box">
                                        <button class="board-img-btn" type="button">
                                            <div class="board-img">
                                                <img src="/images/content-img.png">
                                            </div>
                                            <div class="board-text-box">
                                                <div class="board-text">제주시 애월읍</div>
                                                <div class="board-place-name">새빌</div>
                                            </div>
                                            <div class="like-btn">
                                                <div><i class="far fa-heart"></i></div>
                                            </div>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="board-list-item">
                            <div class="board-list-item-box">
                                <div class="board-title">
                                    <div class="board-img-btn-box">
                                        <button class="board-img-btn" type="button">
                                            <div class="board-img">
                                                <img src="/images/content-img.png">
                                            </div>
                                            <div class="board-text-box">
                                                <div class="board-text">제주시 애월읍</div>
                                                <div class="board-place-name">새빌</div>
                                            </div>
                                            <div class="like-btn">
                                                <div><i class="far fa-heart"></i></div>
                                            </div>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="board-list-item">
                            <div class="board-list-item-box">
                                <div class="board-title">
                                    <div class="board-img-btn-box">
                                        <button class="board-img-btn" type="button">
                                            <div class="board-img">
                                                <img src="/images/content-img.png">
                                            </div>
                                            <div class="board-text-box">
                                                <div class="board-text">제주시 애월읍</div>
                                                <div class="board-place-name">새빌</div>
                                            </div>
                                            <div class="like-btn">
                                                <div><i class="far fa-heart"></i></div>
                                            </div>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                </section>
                <section>
                    <div class="board-list-group">
                        <div class="board-list-item">
                            <div class="board-list-item-box">
                                <div class="board-title">
                                    <div class="board-img-btn-box">
                                        <button class="board-img-btn" type="button">
                                            <div class="board-img">
                                                <img src="/images/content-img.png">
                                            </div>
                                            <div class="board-text-box">
                                                <div class="board-text">제주시 애월읍</div>
                                                <div class="board-place-name">새빌</div>
                                            </div>
                                            <div class="like-btn">
                                                <div><i class="far fa-heart"></i></div>
                                            </div>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="board-list-item">
                            <div class="board-list-item-box">
                                <div class="board-title">
                                    <div class="board-img-btn-box">
                                        <button class="board-img-btn" type="button">
                                            <div class="board-img">
                                                <img src="/images/content-img.png">
                                            </div>
                                            <div class="board-text-box">
                                                <div class="board-text">제주시 애월읍</div>
                                                <div class="board-place-name">새빌</div>
                                            </div>
                                            <div class="like-btn">
                                                <div><i class="far fa-heart"></i></div>
                                            </div>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="board-list-item">
                            <div class="board-list-item-box">
                                <div class="board-title">
                                    <div class="board-img-btn-box">
                                        <button class="board-img-btn" type="button">
                                            <div class="board-img">
                                                <img src="/images/content-img.png">
                                            </div>
                                            <div class="board-text-box">
                                                <div class="board-text">제주시 애월읍</div>
                                                <div class="board-place-name">새빌</div>
                                            </div>
                                            <div class="like-btn">
                                                <div><i class="far fa-heart"></i></div>
                                            </div>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                </section>
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


</body>

</html>