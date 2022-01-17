const signupInputs = document.querySelectorAll('.su-inputs');
const username = document.querySelector('#username');
const idCheck_false = document.querySelector('.idCheck_false');
const password = document.querySelector('#password');
const repassword = document.querySelector('#repassword');
const joinSubmit = document.querySelector('.join_submit');
const authNumberBtn = document.querySelector('.auth-number-btn');
const authCheckBtn = document.querySelector('.auth-check-btn');
const phoneCheck = document.querySelector('.phoneCheck');

var isValidUsername = 'true';
var signupFlag = 'false';
var phoneCheckFlag = false;

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

	if (signupFlag == 'false') {
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
	
	if(!phoneCheckFlag) {
		alert('휴대폰 인증을 다시 시도해주세요.');
		return;
	}

	signup();
}

function switchBtn() {
	if (authNumberBtn.style.display = "block") {
		authNumberBtn.style.display = "none";
		authCheckBtn.style.display = "block";
		$('.phoneCheck').attr('readonly', false);
	} else {
		authNumberBtn.style.display = "block";
		authCheckBtn.style.display = "none";
		$('.phoneCheck').attr('readonly', true);
	}

}

function phoneValidCheck(phoneNumber) {
	if(phoneNumber.length != 11) {
		return false;
	}
	
	for(let i = 0; i < phoneNumber.length; i++) {
		if(!(phoneNumber[i] >= '0' && phoneNumber[i] <= '9')) {
			return false;
		}
	}
	return true;
}

authNumberBtn.onclick = () => {
	let phoneNumber = signupInputs[5].value;
	if(!phoneValidCheck(phoneNumber)) {
		alert('휴대폰 번호를 정확히 입력해주세요.');
		return;
	} else {
		alert('인증 번호를 발송했습니다.')
	}

	$.ajax({
		type: "GET",
		url: "/auth/sendSMS",
		data: {
			"phoneNumber": phoneNumber
		},
		dataType: "text",
		success: function(data) {
			switchBtn();
			let phoneCheckNum = data;
			
			authCheckBtn.onclick = () => {
				if(phoneCheckNum == phoneCheck.value) {
					alert('휴대폰 인증 성공!');
					phoneCheckFlag = true;
				} else {
					alert('휴대폰 인증 실패!');
					phoneCheckFlag = false;
				}
			}
		},
		error: function() {
			alert('비동기 처리 오류');
		}
	})
}
