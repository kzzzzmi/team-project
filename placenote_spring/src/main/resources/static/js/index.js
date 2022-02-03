const body = document.querySelector('body');
const modalContainer = document.querySelector('.modal-container');
const modalContainer2 = document.querySelector('.modal-container2');
const settingBtn = document.querySelector('#setting-btn');
const boardItemImg = document.querySelectorAll('.board-item-img');
const closeBtn = document.querySelector('#close-btn');
const boardList = document.querySelector('.board-list');
const subCategoryItem = document.querySelectorAll('.sub-category-item');
let boardFollowBtn = document.querySelectorAll('.board-follow-btn');
let selectSubCategory = document.querySelector('.select-sub-category');

var page = 0;
var boardTotal = 0;
var boardListItems = ``;

window.onscroll = () => {
	let checkNum = $(document).height() - $(window).height() - $(window).scrollTop();

	if (checkNum < 1 && checkNum > -1 && boardTotal >= (page + 1) * 5) {
		page++;
		boardLoadAll();
	}
}

boardLoadAll();

for(let i = 0; i < subCategoryItem.length; i++) {
	subCategoryItem[i].onclick = () => {
		if(!subCategoryItem[i].classList.contains('select-sub-category')) {
			selectSubCategory.classList.remove('select-sub-category');
			subCategoryItem[i].classList.add('select-sub-category');
			selectSubCategory = document.querySelector('.select-sub-category');
			
			boardLoad(selectSubCategory.textContent);
		} else if(subCategoryItem[i].textContent == )
	}
}

function boardLoadAll() {
	$.ajax({
		type: "GET",
		url: `/getBoardAll?page=${page}`,
		dataType: "text",
		success: function(data) {
			let boardItems = JSON.parse(data);
			boardTotal += boardItems.length;
			boardListItems += getBoardListItems(boardItems);
			boardList.innerHTML = boardListItems;
		},
		error: function() {
			alert("비동기 처리 오류");
		}
	})
}

function boardLoad(subCategory) {
	$.ajax({
		type: "GET",
		url: `/getBoard/${subCategory}?page=${page}`,
		dataType: "text",
		success: function(data) {
			boardListItems = "";
			let boardItems = JSON.parse(data);
			boardTotal += boardItems.length;
			boardListItems += getBoardListItems(boardItems);
			boardList.innerHTML = boardListItems;
		},
		error: function() {
			alert("비동기 처리 오류");
		}
	})
}

function getBoardListItems(boardItems) {
	let boardItemsHtml = ``;

	for (let boardItem of boardItems) {
		boardItemsHtml += getBoardItem(boardItem);
	}
	return boardItemsHtml;
}

function getBoardItem(boardItem) {
	let boardItemHtml = `
				<li class="board-list-item">
					<div class="board-profile">
						<button class="board-profile-btn" onclick="location.href='/my/${boardItem.writer}'">
							<div class="board-profile-img">
								<img src="/image/${boardItem.profile_img}" />
							</div>
							<div>
								<div class="board-profile-username">${boardItem.writer}</div>
								<div class="board-update-date">${boardItem.update}</div>
							</div>
						</button>
						<div class="board-heart-follow-btn">
							<button class="board-heart-btn">
								<i class="far fa-heart"></i>좋아요
							</button>
							<button class="board-follow-btn">
								<i class="fas fa-check"></i>팔로우
							</button>
						</div>
					</div>
					<div class="board-item-img">
						<img src="/image/${boardItem.file_name}" />
					</div> <pre class="board-item-text">${boardItem.board_content}</pre>
					<div class="board-item-comment">
						<input type="text" />
						<button>등록</button>
					</div>
				</li>
				`;
	return boardItemHtml;
}

function follow() {

}

function followCancel() {

}

/*profileEditBtn.onclick = () => {
	if (profileEditBtn.textContent == "팔로우") {
		follow();
	} else {
		followCancel();
	}
}*/

for (let i = 0; i < boardItemImg.length; i++) {
	boardItemImg[i].onclick = () => {
		modalContainer2.classList.toggle('show');

		if (modalContainer2.classList.contains('show')) {
			body.style.overflow = 'hidden';
		}
	};
}

closeBtn.onclick = () => {
	modalContainer2.classList.toggle('show');

	if (!modalContainer2.classList.contains('show')) {
		body.style.overflow = 'auto';
	}
};

/*for(let categoryItem of subCategoryItem) {
	categoryItem
}*/
