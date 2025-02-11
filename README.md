# ♟ java-chess
체스 게임 구현을 위한 저장소

<br>

## 3단계, 추가미션

- [x] DB 스키마 변경
  - [x] 테이블에 white_player_password, black_player_password 컬럼을 varchar(255)로 추가한다.

<br>

- [x] 방 만들기
  - [x] 방을 만드는 플레이어는 white 플레이어다.
  - [x] 방의 제목을 입력한다. (5글자 이상)
  - [x] white 플레이어의 비밀번호를 입력받는다.
  - [x] 서버에 white 플레이어의 비밀번호와 함께 방 생성 요청이 들어간다.
  - [x] 초기 체스 게임 상태, white 플레이어의 hash 암호화 된 비밀번호를 DB에 저장한다.
  - [x] DB 테이블의 black_player_password 컬럼은 null이다.
  - [x] 서버는 hash 암호화 된 white 플레이어의 비밀번호를 쿠키에 담아 방 생성 요청 응답으로 넘겨준다.

<br>

- [x] 메인 화면 방 목록
  - [x] black 플레이어가 아직 입장하지 않은 방들만 보여준다. black 플레이어가 입장한 방은 보여주지 않는다.

<br>

- [x] 방 입장
  - [x] 방에 입장하는 플레이어는 black 플레이어다.
  - [x] black 플레이어는 방에 입장할 때 비밀번호를 입력한다.
  - [x] 서버에 black 플레이어의 비밀번호와 함께 방 입장 요청이 들어간다.
  - [x] black 플레이어의 비밀번호를 hash 함수로 암호화해서, DB 테이블의 black_player_password 컬럼에 저장한다.
  - [x] 서버는 hash 암호화 된 black 플레이어의 비밀번호를 쿠키에 담아 방 입장 요청 응답으로 넘겨준다.

<br>

- [x] 게임 진행  : 기물 이동 요청 시, 쿠키(암호화된 비밀번호) 유효성 검사
  - [x] 이동 요청에 같이 넘어온 쿠키에서 암호화된 비밀번호 값을 꺼내 검사한다.
  - [x] 쿠키의 encryptedPassword 값이 DB에 저장되어 있는 현재 차례 플레이어의 hash 암호화 된 비밀번호와 일치하는지 확인한다.
  - [x] 일치하지 않다면, `"비밀번호가 일치하지 않습니다."` 의 메시지로 예외를 발생시킨다.

<br>

- [x] 방 나가기
  - [x] 체스 게임 방 안의 `"게임 나가기"` 버튼을 누르면, `"게임을 나가면 이 게임은 삭제됩니다. 정말 나가시겠습니까?"` 안내문을 띄운다.
  - [x] 한 명의 플레이어라도 방을 나가면, 게임을 삭제한다.
    

<br>