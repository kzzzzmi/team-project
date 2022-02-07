/**
 * 팔로우 팔로잉 
 */
const followBtn = document.querySelectorAll('.follow-btn');
const profileEditBtn = document.querySelector('.profile-edit-btn');
const getUserID = document.querySelector('.getuserid');

function follow() {
	var userId = getUserID.value;
	$.ajax({
		type: 'post',
		url: `/follow/${userId}`,
		dataType: 'text',
		success: function(data) {
			if (data == '1') {
				profileEditBtn.textContent = '팔로우취소';
			} else {
				alert('로그인 후 가능합니다');
				location.href = '/auth/signin';	
			}
		},
		error: function() {
			alert('로그인 후 가능합니다');
			location.href = '/auth/signin';
		}
	});

}
function followCancel() {
	var userId = getUserID.value;
	$.ajax({
		type: 'delete',
		url: `/follow/${userId}`,
		dataType: 'text',
		success: function(data) {
			if (data == '1') {
				profileEditBtn.textContent = '팔로우';
			} else {
				alert('로그인 후 가능합니다.');
				location.href = '/auth/signin';
			}
		},
		error: function() {
			alert('로그인 후 가능합니다.');
			location.href = '/auth/signin';
		}

	});
}
profileEditBtn.onclick = () => {
	if (profileEditBtn.textContent == "팔로우") {
		follow();
	} else {
		followCancel();
	}
}