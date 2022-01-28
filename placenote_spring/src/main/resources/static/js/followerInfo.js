/**
 * 
 */
 const username = document.querySelector('.getUsername').value;
const getfollowerInfo = document.querySelector('.getfollower-info');
const followerTotalCount = document.querySelector('.follower-total-count');
var followBtn = document.querySelectorAll('.follow-btn');
var userId = document.querySelectorAll('.from-userid');

var followerItem = ``;
var followerCount = 0;

getFollowerLoad();
 
function getFollowerLoad() {
	$.ajax({
		type: 'get',
		url: "/follower/list",
		data: {
			"username": username
		},
		dataType: 'text',
		success: function(data) {
			let followListObj = JSON.parse(data);
			followerItem += getFollow(followListObj.followList);
			getfollowerInfo.innerHTML = followerItem;
			followerTotalCount.textContent = followerCount;
			let loginCheck = followListObj.loginCheck;
			userId = document.querySelectorAll('.from-userid');
			followBtn = document.querySelectorAll('.follow-btn');
			followBtnClick(loginCheck);
		},
		error: function() {
			alert('비동기 처리 오류');

		}

	});
}
 
 function getFollow(followList) {
	
	let followHtml = ``;
	followerCount = followList.length;
	
	for(let i = 0; i < followList.length; i++) {
		followButton = followList[i].follow == 'i' ? "" : `<input class="follow-btn" type="button" value="${followList[i].follow}">`;
		followHtml += `
			
			<li class="following-btn-box">
				<button type="button" class="following-img-btn"
					onclick="location.href='/my/${followList[i].username}'">
					<img src="/image/${followList[i].profile_img}">
				</button>
				<div class="following-name-btn-box">
					 <button type="button" class="following-name-btn" onclick="location.href='/my/${followList[i].username}'">
					${followList[i].username}
					</button>
				</div>
				  <div class="follow-btn-box">
                      ${followButton} 
                </div>
                <input type="hidden" class="from-userid" value="${followList[i].from_userid}">
            </li>`;
			
		}	
	
	
	return followHtml;
}
function follow(userId, i) {
	$.ajax({
		type: 'post',
		url: `/follow/${userId}`,
		dataType: 'text',
		success: function(data) {
			if (data == '1') {
				followBtn[i].value = '팔로우취소';

			}
		},
		error: function() {
			alert('로그인 후 가능합니다');

		}
	});

}
function followCancel(userId, i) {
	$.ajax({
		type: 'delete',
		url: `/follow/${userId}`,
		dataType: 'text',
		success: function(data) {
			if (data == '1') {
				followBtn[i].value = '팔로우';
			}
		},
		error: function() {
			alert('로그인 후 가능합니다.');
		}

	});
}
function followBtnClick(loginCheck) {
	for (let i = 0; i < followBtn.length; i++) {
		followBtn[i].onclick = () => {
			if (loginCheck == false) {
				location.href = '/auth/signin';
			} else {
				if (followBtn[i].value == "팔로우") {
					follow(userId[i].value, i);
				} else {
					followCancel(userId[i].value, i);
				}
			}
		}
	}
}
