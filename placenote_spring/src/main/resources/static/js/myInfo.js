/**
 * 프로필 수정
 */

//모달창
const modal = document.querySelector('.modal');
const logoutBtn = document.querySelector('.logout_btn');
const cancelLogout = document.querySelector('.cancel-logout');

const principalUsername = document.querySelector('#principal-username');
const UsernameCheckInput = document.querySelector('usernameCheck');
const principalEmail = document.querySelector('#principal-email');

const profileImg = document.querySelector('#profile-img');
const imgFile = document.querySelector('#file');
const profileImgChangeBtn = document.querySelector('.profile-img-btn');

const form = document.querySelector('form');
const submitBtn = document.querySelector('.submit-btn');

const profilelabel = document.querySelectorAll('.edit-lb');
const profileInput = document.querySelectorAll('.profile-ip');
const Input = document.querySelectorAll('input');


const receiveSms = document.querySelector('.receive-sms');
const receiveOKSms = document.querySelector('.receive-ok-sms');
const phoneCheck = document.querySelector('.phoneCheck');

const prePasswordInput = document.querySelector('#prepassword-ip');
const newPasswordInput = document.querySelector('#new-password-ip');
const rePasswordInput = document.querySelector('#re-password-ip');
const passwordSubmitBtn = document.querySelector('.password-submit-btn');

var usernameCheckResult = 'true';

var imgFileChangeFlag = false;

var profileImgFile = '';

var phoneCheckFlag = false;

imgFile.style.display = 'none';


//모달창 
modal.style.display = "none";

logoutBtn.onclick = () => {
	modal.style.display = "flex";
}
cancelLogout.onclick = () => {
	modal.style.display = "none";
}

//인풋 온클릭시 값 초기화
var clearInput = function(obj) {
	obj.parentNode.querySelector('input').value = ""
}

profileImgChangeBtn.onclick = () => {
	imgFile.click();
}


imgFile.onchange = () => {
	let reader = new FileReader();

	reader.onload = (e) => {
		imgFileChangeFlag = true;
		profileImgFile = e.target.result;
		profileImg.src = profileImgFile;
	}

	reader.readAsDataURL(imgFile.files[0]);
}

function usernameCheck(username) {

	$.ajax({
		type: "get",
		url: "/auth/username-check",
		data: {
			"username": username
		},
		dataType: "text",
		async: false,
		success: function(data) {
			usernameCheckResult = data;
		},
		error: function() {
			alert('비동기 처리 오류.');
		}
	});
}


function inputIsEmpty(str, lb) {
	let result = false;

	if (typeof (str) == undefined || str == null || str == '') {
		alert(lb + '은(는) 빈값일 수 없습니다.');
		result = true;
	}

	return result;
}

function multipartSubmit() {

	let formData = new FormData(form);

	$.ajax({
		type: "patch",
		url: "/myInfo/edit",
		data: formData,
		dataType: "text",
		enctype: "multipart/form-data",
		processData: false,
		contentType: false,
		success: function(data) {
			if (data == 'true') {
				const principalProfileImg = document.querySelector('#principal-profile-img');
				principalProfileImg.src = profileImgFile;
			}
		},
		error: function() {
			alert('비동기 처리 오류.');
		}
	});
}

function editSubmit() {

	$.ajax({
		type: "patch",
		url: "/myInfo/edit",
		data: {
			"username": profileInput[0].value,
			"email": profileInput[1].value,
			"phone": profileInput[2].value
		},
		dataType: "text",
		success: function(data) {
			if (data == 'true') {
				alert('회원정보 수정 성공.');
				principalUsername.textContent = profileInput[0].value;
				principalEmail.textContent = profileInput[1].value;

			}
		},
		error: function() {
			alert('비동기 처리 오류.');

		}
	});

}



submitBtn.onclick = () => {

	let username = profileInput[0].value;
	let pUsername = principalUsername.textContent;


	if (inputIsEmpty(profileInput[0].value, profilelabel[0].textContent)) {
		return;
	}
	if (inputIsEmpty(profileInput[1].value, profilelabel[1].textContent)) {
		return;
	}

	if (username != pUsername) {
		usernameCheckResult = 'false';
		usernameCheck(username);
	}
	if (usernameCheckResult == 'true') {
		//서브밋 실행
		if (imgFileChangeFlag == true) {
			//파일업로드 필요 o
			multipartSubmit();
		} else {
			//파일업로드 필요 x
			editSubmit();
		}
	} else {
		alert(username + "은(는)이미 사용중인 사용자 이름입니다.");
	}

	function passwordSubmit() {

		$.ajax({
			type: "put",
			url: "/password/change",
			data: {
				"prepassword": prePasswordInput.value,
				"newpassword": newPasswordInput.value
			},
			dataType: "text",
			success: function(data) {
				let passwordRespObj = JSON.parse(data);
				alert(passwordRespObj.message);

				if (passwordRespObj.code == 200) {
					alert('다시 로그인 해주세요.');
					location.replace('/logout');
				}
			},
			error: function() {
				alert('비동기 처리 오류');
			}
		});
	}
	passwordSubmitBtn.onclick = () => {

		if (newPasswordInput.value != rePasswordInput.value) {
			alert('새 비밀번호가 일치하지 않습니다.');
			return;

		}
		if(prePasswordInput.vale && newPasswordInput.value && rePasswordInput.value == false){
			alert('변경된 정보가 없습니다.');
		}
		passwordSubmit();
	}


	function phoneValidCheck(phoneNumber) {
		if (phoneNumber.length != 11) {
			return false;
		}

		for (let i = 0; i < phoneNumber.length; i++) {
			if (!(phoneNumber[i] >= '0' && phoneNumber[i] <= '9')) {
				return false;
			}
		}
		return true;
	}


	receiveSms.onclick = () => {
		let phoneNumber = profileInput[2].value;
		if (!phoneValidCheck(phoneNumber)) {
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

				receiveOKSms.onclick = () => {
					if (phoneCheckNum == phoneCheck.value) {
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
		});
	}
}