const iconBoxIcon = document.querySelectorAll(".iconBox-icon");
const file = document.querySelector("#file");
const fileBox = document.querySelector('.file-box');

var removeBtn = document.querySelectorAll('.remove-btn');

file.onchange = () => {
    let uploadBoxs = document.querySelectorAll('.upload-box');
    if (uploadBoxs.length < 3) {
        let uploadBox = document.createElement('div');
        uploadBox.setAttribute('class', 'upload-box')
        let boxItem = document.createElement('div');

        let fileNameTag = document.createElement('span');
        let textContent = file.value;
        fileNameTag.append(textContent);

        let icon = document.createElement('i');
        icon.setAttribute('class', 'fas fa-times remove-btn');

        boxItem.append(fileNameTag);
        boxItem.append(icon);
        uploadBox.append(boxItem);
        fileBox.appendChild(uploadBox);

        removeBtn = document.querySelectorAll('.remove-btn');

        for (let i = 0; i < removeBtn.length; i++) {
            removeBtn[i].onclick = () => {
                let uploadBox = document.querySelectorAll('.upload-box');
                uploadBox[i].remove();
            }
        }
        file.value = "";
    } else {
        file.value = "";
        alert('사진은 3개까지 등록할 수 있습니다.');
    }
}



iconBoxIcon[0].onclick = () => {
    file.click();
}

iconBoxIcon[3].onclick = () => {

}