const body = document.querySelector('body');
const modalContainer = document.querySelector('.modal-container');
var boardItemImg = document.querySelectorAll('.board-item-img');
const closeBtn = document.querySelector('#close-btn');
const boardList = document.querySelector('.board-list');
const subCategoryItem = document.querySelectorAll('.sub-category-item');
const boardModalImgPreview = document.querySelector('.board-modal-img-preview');
const boardModalUsername = document.querySelector('.board-modal-username');
const boardModalProfileImg = document.querySelector('.board-modal-profile-img');
var boardListItem = document.querySelectorAll('.board-list-item');
var boardHeartBtn = document.querySelectorAll('.board-heart-btn');
var boardFollowBtn = document.querySelectorAll('.board-follow-btn');
var selectSubCategory = document.querySelector('.select-sub-category');
var boardImg = document.querySelector('.board-img');

var boardId = [];
var boardUserId = [];

var boardImages = [];
var boardImagesStartIndex = [];
var currentBoardNum = [];
var moreBoardNum = [];

var prevImg = document.querySelectorAll('.prevImg');
var nextImg = document.querySelectorAll('.nextImg');

const myUsername = document.querySelector('.profile-info-top h1') != null ? document.querySelector('.profile-info-top h1').textContent : null;
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
			initImg();
			initFollow();
			initHeart();
		},
		error: function() {
			alert("비동기 처리 오류");
		}
	})
}

function moveImg(prevImg, nextImg) {
	for (let i = 0; i < prevImg.length; i++) {
		prevImg[i].onclick = () => {
			let boardNumber = moreBoardNum[i];
			if (currentBoardNum[boardNumber] > boardImagesStartIndex[boardNumber]) {
				boardImg[boardNumber].src = `/image/${boardImages[--currentBoardNum[boardNumber]]}`;
			}
		}
	}

	for (let i = 0; i < nextImg.length; i++) {
		nextImg[i].onclick = () => {
			let boardNumber = moreBoardNum[i];
			if (currentBoardNum[boardNumber] < boardImagesStartIndex[boardNumber + 1] - 1) {
				boardImg[boardNumber].src = `/image/${boardImages[++currentBoardNum[boardNumber]]}`;
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
	boardUserId.push(boardItem.user_id);
	boardId.push(boardItem.board_id);

	let imgHtml = ``;

	if (boardItem.file_name.length > 1) {
		moreBoardNum.push(boardImagesStartIndex.length - 1);
	}

	for (let i = 0; i < boardItem.file_name.length; i++) {
		boardImages[imagesIndex++] = boardItem.file_name[i];
	}

	if (boardItem.file_name.length == 1) {
		imgHtml = `<img src="/image/${boardImages[boardImagesStartIndex[currentNum++]]}" class='board-img' />`;
	} else {
		imgHtml = `<i class="fas fa-chevron-left prevImg"></i>
						<img src="/image/${boardImages[boardImagesStartIndex[currentNum++]]}" class='board-img' />
						<i class="fas fa-chevron-right nextImg"></i>`;
	}

	let followCheck = `<button class="board-follow-btn" style="display: none"><i class="fas fa-check"></i></button>`;
	if (boardItem.writer != myUsername) {
		followCheck = boardItem.follow == '팔로잉' ? `<button class="board-follow-btn"><i class="fas fa-check"></i><span>팔로잉</span></button>` : `<button class="board-follow-btn"><i class="fas fa-user-plus"></i><span>팔로우</span></button>`;
	}

	let heartCheck = boardItem.heart == '좋아요' ? `<i class="far fa-heart"></i><span>좋아요</span>` : `<i class="fas fa-heart"></i><span>취소</span>`;

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
								${heartCheck}
							</button>
							${followCheck}						
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

function initHeart() {
	boardHeartBtn = document.querySelectorAll('.board-heart-btn');
	
	for(let i = 0; i < boardHeartBtn.length; i++) {
		boardHeartBtn[i].onclick = () => {
			if(boardHeartBtn[i].querySelector('span').textContent == '좋아요') {
				heart(boardId[i], i);
			} else {
				heartCancel(boardId[i], i);
			}
		}
	}
}

function heart(boardId, i) {
	$.ajax({
		type: "POST",
		url: `/heart/${boardId}`,
		dataType: "text",
		success: function(data) {
			if(data == '1') {
				boardHeartBtn[i].innerHTML = `<i class="fas fa-heart"></i><span>취소</span>`;
			} else {
				alert('로그인 후 가능합니다.');
				location.href = '/auth/signin';
			}
		},
		error: function() {
			alert('비동기 처리 오류');
			location.href = '/auth/signin';
		}
	})
}

function heartCancel(boardId, i) {
	$.ajax({
		type: "DELETE",
		url: `/heart/${boardId}`,
		dataType: "text",
		success: function(data) {
			if(data == '1') {
				boardHeartBtn[i].innerHTML = `<i class="far fa-heart"></i><span>좋아요</span>`;
			} else {
				alert('로그인 후 가능합니다.');
				location.href = '/auth/signin';
			}
		},
		error: function() {
			alert('비동기 처리 오류');
		}
	})
}

function initFollow() {
	boardFollowBtn = document.querySelectorAll('.board-follow-btn');

	for (let i = 0; i < boardFollowBtn.length; i++) {
		boardFollowBtn[i].onclick = () => {
			if (boardFollowBtn[i].querySelector('span').textContent == '팔로우') {
				follow(boardUserId[i]);
			} else {
				followCancel(boardUserId[i]);
			}
		}
	}
}

function follow(userId) {
	$.ajax({
		type: "POST",
		url: `/follow/${userId}`,
		dataType: "text",
		success: function(data) {
			if (data == '1') {
				for(let i = 0; i < boardUserId.length; i++) {
					if(boardUserId[i] == userId) {
						boardFollowBtn[i].innerHTML = `<i class="fas fa-check"></i><span>팔로잉</span>`;
					}
				}				
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

function followCancel(userId) {
	$.ajax({
		type: "DELETE",
		url: `/follow/${userId}`,
		dataType: "text",
		success: function(data) {
			if (data == '1') {
				for(let i = 0; i < boardUserId.length; i++) {
					if(boardUserId[i] == userId) {
						boardFollowBtn[i].innerHTML = `<i class="fas fa-user-plus"></i><span>팔로우</span>`;
					}
				}		
			}
		},
		error: function() {
			alert('로그인 후 가능합니다');
		}
	});
}

function initImg() {
	boardListItem = document.querySelectorAll('.board-list-item');
	boardImg = document.querySelectorAll('.board-img');
	boardItemImg = document.querySelectorAll('.board-item-img');
	prevImg = document.querySelectorAll('.prevImg');
	nextImg = document.querySelectorAll('.nextImg');
	moveImg(prevImg, nextImg);
	modalWindow();
}

function modalWindow() {
	for (let i = 0; i < boardImg.length; i++) {
		boardImg[i].onclick = () => {
			modalContainer.classList.toggle('show');

			boardModalImgPreview.src = boardImg[i].src;
			boardModalUsername.textContent = boardListItem[i].querySelector('.board-profile-username').textContent;
			boardModalProfileImg.src = boardListItem[i].querySelector('.board-profile-img img').src;

			if (modalContainer.classList.contains('show')) {
				body.style.overflow = 'hidden';
			}
		};
	}

	closeBtn.onclick = () => {
		modalContainer.classList.toggle('show');

		if (!modalContainer.classList.contains('show')) {
			body.style.overflow = 'auto';
		}
	};
}
