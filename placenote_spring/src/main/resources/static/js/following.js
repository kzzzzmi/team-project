/**
 * 팔로우 팔로잉 
 */
const followBtn = document.querySelectorAll('.follow-btn');
const profileEditBtn = document.querySelector('.profile-edit-btn');
for (let i = 0; i < followBtn.length; i++) {
	followBtn[i].onclick = () => {
		if (followBtn[i].value == "팔로우") {
			followBtn[i].value = "팔로우취소"
		} else {
			followBtn[i].value = "팔로우"
		}

	}
}

profileEditBtn.onclick = () => {
	if (profileEditBtn.value == "팔로우") {
		profileEditBtn.value = "팔로우취소"
	} else {
		profileEditBtn.value = "팔로우"
	}

}





