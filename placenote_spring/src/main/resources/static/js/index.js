const body = document.querySelector('body');
const modalContainer = document.querySelector('.modal-container');
const modalContainer2 = document.querySelector('.modal-container2');
const settingBtn = document.querySelector('#setting-btn');
const boardItemImg = document.querySelectorAll('.board-item-img');
const closeBtn = document.querySelector('#close-btn');
const boardList = document.querySelector('.board-list');

var page = 0;
var boardTotal = 0;
var boardListItems = ``;

/*window.onscroll = () => {
	let checkNum = $(document).height() - $(window).height() - $(window).scrollTop();
	
	if(checkNum < 1 && checkNum > -1 && boardTotal > (page + 1) * 5) {
		alert('ok');
		page++;
		boardLoad();
	}
}*/

boardLoad();

function boardLoad() {
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
						<button class="board-profile-btn">
							<div class="board-profile-img">
								<img src="/images/${boardItem.profile_img}" />
							</div>
							<div>
								<div class="board-profile-username">${boardItem.writer}</div>
								<div class="board-update-date">${boardItem.upadate_date}</div>
							</div>
						</button>
						<div class="board-follow-btn">
							<button>
								<i class="far fa-heart"></i>좋아요
							</button>
							<button>
								<i class="fas fa-check"></i>팔로우
							</button>
						</div>
					</div>
					<div class="board-item-img">
						<img src="/image/${boardItem.file_name}" alt="" />
					</div> <pre class="board-item-text">${boardItem.board_content}</pre>
					<div class="board-item-comment">
						<input type="text" />
						<button>등록</button>
					</div>
				</li>
				`;
	return boardItemHtml;
}

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
