const iconBoxIcon = document.querySelectorAll(".iconBox-icon");
const file = document.querySelectorAll(".file");
const fileBox = document.querySelector('.file-box');
const uploadBtn = document.querySelector('.body-header-save-btn');
const textContent = document.querySelector('#text-content');
const form = document.querySelector('form');

var removeBtn = document.querySelectorAll('.remove-btn');

for(let i = 0; i < file.length; i++) {
    file[i].onchange = () => {
        let uploadBoxs = document.querySelectorAll('.upload-box');
        if (uploadBoxs.length < 3) {
            let uploadBox = document.createElement('div');
            uploadBox.setAttribute('class', 'upload-box')
            let boxItem = document.createElement('div');
    
            let fileNameTag = document.createElement('span');
            let textContent = file[i].files[0].name;
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
                    file[i].files[0] = null;
                    file[i].value = "";
                }
            }
        } else {
            alert('사진은 3개까지 등록할 수 있습니다.');
        }
    }
}


iconBoxIcon[0].onclick = () => {
    for(let i = 0; i < file.length; i++) {
        if(file[i].files[0] == null) {
            file[i].click();
            return;
        }
    }
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
    if(isEmpty(file[0].files[0]) && isEmpty(file[1].files[0]) && isEmpty(file[2].files[0]) ) {
        alert('이미지를 하나 이상 추가해주세요');
    } else if(isEmpty(textContent.value)) {
        alert('내용을 입력해주세요.');
    } else {
        uploadSubmit();
    }
}

function isEmpty(str) {
    if(typeof(str) == undefined || str == null || str == '') {
        return true;
    } else {
        return false;
    }
}