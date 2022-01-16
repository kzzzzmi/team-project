const username = document.querySelector('#username');
const idCheck_false = document.querySelector('.idCheck_false');

var isValidUsername = false;

function usernameCheck(username) {
  $.ajax({
    type: 'GET',
    url: '/auth/check',
    data: username,
    dataType: 'text',
  });
}

username.onblur = () => {
  let isValidUsername = usernameCheck(username.value);

  if (isValid == false) {
    idCheck_false.style.display = 'block';
  } else {
    idCheck_false.style.display = 'none';
  }
};
