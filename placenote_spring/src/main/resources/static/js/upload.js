const iconBoxIcon = document.querySelectorAll(".iconBox-icon");
const file = document.querySelector(".file");
const fileBox = document.querySelector('.file-box');
const uploadBtn = document.querySelector('.body-header-save-btn');
const textContent = document.querySelector('#text-content');
const form = document.querySelector('form');
const textTitle = document.querySelector('#text-title');

iconBoxIcon[0].onclick = () => {
	file.click();
}

function uploadSubmit() {
	let formData = new FormData(form);

	$.ajax({
		type: "POST",
		url: "/upload",
		data: formData,
		dataType: "text",
		encType: "multipart/form-data",
		processData: false,
		contentType: false,
		success: function(data) {
			
		},
		error: function() {
			alert('비동기 처리 오류');
		}
	})
}

uploadBtn.onclick = () => {
	if (isEmpty(textTitle.value)) {
		alert('가게 이름을 입력해주세요.');
	} else if (isEmpty(textContent.value)) {
		alert('내용을 입력해주세요.');
	}
	else {
		uploadSubmit();
	}
};

function isEmpty(str) {
	if (typeof (str) == undefined || str == null || str == '') {
		return true;
	} else {
		return false;
	}
}