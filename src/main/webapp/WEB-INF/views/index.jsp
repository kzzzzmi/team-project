<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <script
      src="https://kit.fontawesome.com/0bd5e629f4.js"
      crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="/css/style.css" />
    <link rel="stylesheet" href="/css/nav.css" />
    <link rel="stylesheet" href="/css/index.css" />
  </head>

  <body>
    <jsp:include page="include/nav.jsp"></jsp:include>

    <div class="container">
      <div class="board-box">
        <div class="main-category">
          <div class="main-category-left">
            <div class="main-category-btnbox">
              <button class="main-category-btns main-category-first-btn">
                전체
              </button>
            </div>
            <div class="main-category-btnbox">
              <button class="main-category-btns">팔로잉</button>
            </div>
            <div class="main-category-btnbox">
              <button class="main-category-btns">인기순</button>
            </div>
            <div class="main-category-btnbox">
              <button class="main-category-btns">+ 관심지역</button>
            </div>
          </div>
          <div class="main-category-right">
            <div></div>
            <button><i class="far fa-compass"></i>현위치</button>
          </div>
        </div>

        <div class="sub-category">
          <div>
            <button>한식</button>
          </div>
          <div>
            <button>중식</button>
          </div>
          <div>
            <button>일식</button>
          </div>
          <div>
            <button>양식</button>
          </div>
          <div>
            <button>카페</button>
          </div>
        </div>

        <ul class="board-list">
          <li class="board-list-item">
            <div class="board-profile">
              <button class="board-profile-btn">
                <div class="board-profile-img">
                  <img src="images/profile_img.png" />
                </div>
                <div>
                  <div class="board-profile-username">고죠</div>
                  <div class="board-update-date">1.13 목</div>
                </div>
              </button>
              <div class="board-follow-btn">
                <button><i class="far fa-heart"></i>좋아요</button>
                <button><i class="fas fa-check"></i>팔로잉</button>
              </div>
            </div>
            <div class="board-item-img">
              <img src="/images/1604911318873_0.jpg" alt="" />
            </div>
            <pre class="board-item-text">안녕하세요</pre>
            <div class="board-item-comment">
              <input type="text" /><button>등록</button>
            </div>
          </li>
          <li class="board-list-item">
            <div class="board-profile">
              <button class="board-profile-btn">
                <div class="board-profile-img">
                  <img src="images/profile_img.png" />
                </div>
                <div>
                  <div class="board-profile-username">고죠</div>
                  <div class="board-update-date">1.13 목</div>
                </div>
              </button>
              <div class="board-follow-btn">
                <button><i class="far fa-heart"></i>좋아요</button>
                <button><i class="fas fa-check"></i>팔로잉</button>
              </div>
            </div>
            <div class="board-item-img">
              <img src="/images/해외_인기_한국_음식_01.png" alt="" />
            </div>
            <pre class="board-item-text">안녕하세요</pre>
            <div class="board-item-comment">
              <input type="text" /><button>게시</button>
            </div>
          </li>
          <li class="board-list-item">
            <div class="board-profile">
              <button class="board-profile-btn">
                <div class="board-profile-img">
                  <img src="images/profile_img.png" />
                </div>
                <div>
                  <div class="board-profile-username">고죠</div>
                  <div class="board-update-date">1.13 목</div>
                </div>
              </button>
              <div class="board-follow-btn">
                <button><i class="far fa-heart"></i>좋아요</button>
                <button><i class="fas fa-check"></i>팔로잉</button>
              </div>
            </div>
            <div class="board-item-img">
              <img
                src="/images/riga-latvia-september-22-2020-600w-1955335966.png"
                alt=""
              />
            </div>
            <pre class="board-item-text">안녕하세요</pre>
            <div class="board-item-comment">
              <div><input type="text" /></div>
              <button>게시</button>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </body>
</html>
