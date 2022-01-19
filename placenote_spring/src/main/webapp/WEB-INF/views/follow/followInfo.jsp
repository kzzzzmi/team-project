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
    <script src="https://kit.fontawesome.com/c3df4d7d1c.js" crossorigin="anonymous"></script>

</head>

<body>

    <nav>
        <div class="container">
            <div class="back-page-btn">
                <button type="button" style="border: none; background-color: white;">
                    <i class="fas fa-arrow-left"></i>
                </button>
                <span>username</span>
            </div>
        </div>
    </nav>
    <div class="menu-box">
        <div class="menu">
            <div class="menu-btn">
                <button onclick="location.href='/follow/following'">
                    팔로잉 <span>0</span>
                </button>
                <button  onclick="location.href='/follow/follow'">
                    팔로워 <span>0</span>
                </button>
            </div>
        </div>
    </div>
    <div class="follow-box">
        <i class="fas fa-user-alt"></i>
        <p class="notification">아직 팔로워가 없습니다</p>
    </div>

</body>

</html>