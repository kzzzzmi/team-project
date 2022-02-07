const body = document.querySelector('body');
const modalContainer = document.querySelector('.modal-container');
const modalContainer2 = document.querySelector('.modal-container2');
const settingBtn = document.querySelector('#setting-btn');
const boardItemImg = document.querySelectorAll('.board-item-img');
const closeBtn = document.querySelector('#close-btn');
const boardList = document.querySelector('.board-list');
const subCategoryItem = document.querySelectorAll('.sub-category-item');
var boardFollowBtn = document.querySelectorAll('.board-follow-btn');
var selectSubCategory = document.querySelector('.select-sub-category');
var boardImg = document.querySelector('.board-img');
var boardImages = [];
var boardImagesStartIndex = [];
var currentBoardNum = [];

var prevImg = document.querySelectorAll('.prevImg');
var	nextImg = document.querySelectorAll('.nextImg');

var page = 0;
var boardTotal = 0;
var boardListItems = ``;
var imagesIndex = 0;
var currentNum = 0;

window.onscroll = () => {
	let checkNum = $(document).height() - $(window).height() - $(window).scrollTop();

	if (checkNum < 1 && checkNum > -1 && boardTotal >= (page + 1) * 5) {
		page++;
		boardLoad(selectSubCategory.textContent);
	}
}

boardLoad(selectSubCategory.textContent);

for (let i = 0; i < subCategoryItem.length; i++) {
	subCategoryItem[i].onclick = () => {
		if (!subCategoryItem[i].classList.contains('select-sub-category')) {
			selectSubCategory.classList.toggle('select-sub-category');
			subCategoryItem[i].classList.add('select-sub-category');
			selectSubCategory = document.querySelector('.select-sub-category');
			initBoard();
			boardLoad(subCategoryItem[i].textContent);
		}
	}
}

function initBoard() {
	page = 0;
	boardTotal = 0;
	boardListItems = ``;
}

function boardLoad(subCategory) {
	$.ajax({
		type: "GET",
		url: `/getBoard/${subCategory}?page=${page}`,
		dataType: "text",
		success: function(data) {
			let boardItems = JSON.parse(data);
			boardTotal += boardItems.length;
			boardListItems += getBoardListItems(boardItems);
			boardList.innerHTML = boardListItems;
			boardImg = document.querySelectorAll('.board-img');
			prevImg = document.querySelectorAll('.prevImg');
			nextImg = document.querySelectorAll('.nextImg');
			moveImg(prevImg, nextImg);
		},
		error: function() {
			alert("비동기 처리 오류");
		}
	})
}

function moveImg(prevImg, nextImg) {
	for(let i = 0; i < prevImg.length; i++) {
		prevImg[i].onclick = () => {
			if(currentBoardNum[i] > boardImagesStartIndex[i]) {
				boardImg[i].src = `/image/${boardImages[--currentBoardNum[i]]}`;
			}
		}
	}
	
	for(let i = 0; i < nextImg.length; i++) {
		nextImg[i].onclick = () => {
			if(currentBoardNum[i] < boardImagesStartIndex[i + 1] - 1) {
				boardImg[i].src = `/image/${boardImages[++currentBoardNum[i]]}`;
			}
		}
	}
}

function getBoardListItems(boardItems) {
	let boardItemsHtml = ``;
	for (let boardItem of boardItems) {
		boardItemsHtml += getBoardItem(boardItem);
	}
	return boardItemsHtml;
}

function getBoardItem(boardItem) {
	boardImagesStartIndex.push(imagesIndex);
	currentBoardNum.push(imagesIndex);
	
	for(let i = 0; i < boardItem.file_name.length; i++) {
		boardImages[imagesIndex++] = boardItem.file_name[i];
	}
	
	let imgHtml = ``;
	
	if(boardItem.file_name.length == 1) {
		imgHtml = `<i class="fas fa-chevron-left prevImg" style="display:none"></i>
						<img src="/image/${boardImages[boardImagesStartIndex[currentNum++]]}" class='board-img' />
						<i class="fas fa-chevron-right nextImg" style="display:none"></i>`;
	} else {
		imgHtml = `<i class="fas fa-chevron-left prevImg"></i>
						<img src="/image/${boardImages[boardImagesStartIndex[currentNum++]]}" class='board-img' />
						<i class="fas fa-chevron-right nextImg"></i>`;
	}

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
						${imgHtml}
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
