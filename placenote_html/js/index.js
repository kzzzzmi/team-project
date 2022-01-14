const body = document.querySelector('body');
const modalContainer = document.querySelector('.modal-container');
const modalContainer2 = document.querySelector('.modal-container2');
const settingBtn = document.querySelector('#setting-btn');
const boardItemImg = document.querySelectorAll('.board-item-img');
const closeBtn = document.querySelector('#close-btn');

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
