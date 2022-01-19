const signinFlag = document.querySelector('#signin-flag');

if(signinFlag.value == '0'){
	alert('존재하지 않는 아이디입니다.')
}else if(signinFlag.value == '1'){
	alert('비밀번호가 틀렸습니다.')
}