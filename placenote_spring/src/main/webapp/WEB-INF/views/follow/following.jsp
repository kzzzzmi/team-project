<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>네이버 My플레이스</title>
    <link rel="stylesheet" href="/css/following.css">

    <script src="https://kit.fontawesome.com/c3df4d7d1c.js" crossorigin="anonymous">
    </script>

</head>

<body>

    <nav>
        <div class="container">
            <div class="back-page-btn">
                <button type="button" style="border: none; background-color: white;" onclick="history.go(-1)">
                    <i class="fas fa-arrow-left"></i>
                </button>
                <span onclick="location.href = '/feed/feed'">username</span>
            </div>
        </div>
    </nav>
    <div class="menu-box">
        <div class="menu">
            <div class="menu-btn">
                <button onclick="location.href='/follow/following'">
                    팔로잉 <span>0</span>
                </button>
                <button onclick="location.href='/follow/follow'">
                    팔로워 <span>0</span>
                </button>
            </div>
        </div>
    </div>
    <div class="following-info-box">
        <ul>
            <li class="following-btn-box">
                <button type="button" class="following-img-btn" onclick="location.href='/feed/feed'">
                    <img src="/images/profile_img.png">
                </button>
                <div class="following-name-btn-box">
                    <button type="button" class="following-name-btn" onclick="location.href='/feed/feed'">
                        케빈
                    </button>
                </div>
                <div class="follow-btn-box">
                        <input class="follow-btn" type="button" value="팔로우"> 
                    </input>
                </div>
            </li>

        </ul>
    </div>

    <script src="/js/following.js"></script>


</body>

</html>