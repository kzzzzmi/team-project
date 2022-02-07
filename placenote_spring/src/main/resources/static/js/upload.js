const iconBoxIcon = document.querySelectorAll(".iconBox-icon");
const file = document.querySelector(".file");
const uploadBtn = document.querySelector('.body-header-save-btn');
const textContent = document.querySelector('#text-content');
const form = document.querySelector('form');
const textTitle = document.querySelector('#text-title');
const fileBoxes = document.querySelector('.file-boxes');
let address = document.querySelector('#address');

var file_box = [];

iconBoxIcon[1].onclick = () => {
	new daum.Postcode({
		oncomplete: function(data) {
			address.value = data.address;
		}
	}).open({ popupTitle: '주소 검색' });
}

file.onchange = (event) => {
	file_box = [];
	$(".file-boxes").empty();

	let files = event.target.files;
	let fileArr = Array.prototype.slice.call(files);

	let index = 0;
	fileArr.forEach(function(file) {
		file_box.push(file);

		let reader = new FileReader();
		reader.onload = () => {
			let html = "<div>content</div>";
			$(".file-boxes").append(html);
			index++;
		}
		reader.readAsDataURL(file);
	})
}

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
		success: function() {
			alert('추가 성공');
			location.href = "/index";
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
	} else if(isEmpty(address.value)) {
		alert('장소를 선택해주세요.')
	} else if(isEmpty(file.value)) {
		alert('파일을 선택해주세요');
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

