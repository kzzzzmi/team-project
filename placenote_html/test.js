const followBtn = document.querySelectorAll('.follow-btn');

for(let i = 0; i < followBtn.length; i++) {
  followBtn[i].onclick = () => {
    if(followBtn[i].value == '팔로우') {  
      followBtn[i].value = '팔로우 취소'; 
    } else {
      followBtn[i].value = '팔로우';
    }
  }
}