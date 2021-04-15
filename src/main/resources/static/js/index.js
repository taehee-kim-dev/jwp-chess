
const HOME = 'http://localhost:8080';

const enter_room_buttons =  document.getElementsByClassName("enter-room-button");

for (let i = 0; i < enter_room_buttons.length; i++) {
  enter_room_buttons[i].addEventListener('click', (event) => {
    window.location.href = HOME + '/rooms?id=' + event.target.parentElement.id;
  });
}

const remove_room_buttons =  document.getElementsByClassName("delete-room-button");
for (let i = 0; i < remove_room_buttons.length; i++) {
  remove_room_buttons[i].addEventListener('click', (event) => {
    const is_delete = confirm('정말 삭제하시겠습니까?');
    if (is_delete === true) {
      window.location.href = HOME + '/delete?id=' + event.target.parentElement.id;
    }
  });
}

function create_room_check() {
  const room_title_min_size = 5;

  const new_room_title = document.getElementById('new_room_title');
  if(new_room_title.value.length < room_title_min_size) {
    alert('방 제목은 ' + room_title_min_size + '글자 이상이어야 합니다.');
    new_room_title.focus();
    return false;
  }

  const white_player_password = document.getElementById('white-player-password');
  if(white_player_password.value.length < room_title_min_size) {
    alert('비밀번호는 ' + room_title_min_size + '자 이상이어야 합니다.');
    white_player_password.focus();
    return false;
  }

  return true;
}