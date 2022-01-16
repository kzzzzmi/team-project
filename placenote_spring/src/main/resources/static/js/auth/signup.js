const signupInputs = document.querySelectorAll('.su-inputs');
const username = document.querySelector('#username');
const idCheck_false = document.querySelector('.idCheck_false');
const password = document.querySelector('#password');
const repassword = document.querySelector('#repassword');
const joinSubmit = document.querySelector('.join_submit');

var isValidUsername = 'true';
var signupFlag = 'false';

function usernameCheck(username) {
	$.ajax({
		type: "GET",
		url: "/auth/username-check",
		data: {
			"username": username
		},
		async: false,
		dataType: "text",
		success: function(data) {
			isValidUsername = data;
		},
		error: function() {
			alert('비동기 처리 오류');
		}
	});
}

username.onblur = () => {
	let usernameInp = username.value;

	usernameCheck(usernameInp);

	if (isValidUsername == 'false') {
		idCheck_false.style.display = 'block';
	} else {
		idCheck_false.style.display = 'none';
	}

};

function signup() { // 회원가입 ajax와 다음 페이지 설정
	let signupObj = {
		username: signupInputs[0].value,
		password: signupInputs[1].value,
		name: signupInputs[2].value,
		gender: signupInputs[3].value,
		email: signupInputs[4].value,
		phone: signupInputs[5].value
	};

	$.ajax({
		type: "POST",
		url: "/auth/signup",
		data: signupObj,
		dataType: "text",
		async: false,
		success: function(data) {
			signupFlag = data;
		},
		error: function() {
			alert('비동기 처리 오류');
		}
	})
	
	if(signupFlag == 'false') {
		alert('회원가입 실패');
	} else {
		location.replace('/auth/signin');
	}
}

joinSubmit.onclick = () => {
	if (isValidUsername != 'true') {
		alert('이미 존재하는 아이디입니다.');
		return;
	}
	if (password.value != repassword.value) {
		alert('비밀번호를 확인해주세요.');
		return;
	}

	signup();
}
