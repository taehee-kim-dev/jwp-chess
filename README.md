# ♟ java-chess
체스 게임 구현을 위한 저장소

<br>

## 3단계, 추가미션

- [x] DB 스키마 변경
    - [x] player 테이블에 password 컬럼을 varchar(255)로 추가한다.

- [x] 방 만들기
    - [x] 방을 만드는 플레이어는 white 플레이어다.
    - [x] 방의 제목을 입력한다. (5글자 이상)
    - [x] white 플레이어의 비밀번호를 입력받는다.
    - [x] 서버에 white 플레이어의 비밀번호와 함께 방 생성 요청이 들어간다.
    - [x] 체스 게임, white/black 플레이어, 초기 기물 위치 정보를 생성해서 DB에 저장한다.
    - [x] DB의 player 테이블에서 white/black 플레이어의 password 컬럼은 비어있다.
    - [x] 방 생성시 입력받은 white 플레이어의 비밀번호를 hash 함수로 암호화해서, white 플레이어의 password 컬럼에 저장한다.
    - [x] 방을 생성한 white 플레이어는 방 안에 들어가 있다. 메인 화면에 있는 사람이 방 삭제를 하면 안되므로, 메인 화면 방 목록의 삭제 버튼은 제거한다.
    - [x] 서버는 hash 암호화 된 white 플레이어의 비밀번호를 쿠키에 담아 방 생성 요청 응답으로 넘겨준다.

- [ ] 메인 화면 방 목록
    - [ ] black 플레이어가 아직 입장하지 않은 방들만 보여준다. black 플레이어가 입장한 방은 보여주지 않는다.

- [ ] 방 입장
    - [ ] 방에 입장하는 플레이어는 black 플레이어다.
    - [ ] black 플레이어는 방에 입장할 때 비밀번호를 입력한다.
    - [ ] 서버에 black 플레이어의 비밀번호와 함께 방 입장 요청이 들어간다.
    - [ ] black 플레이어의 비밀번호를 hash 함수로 암호화해서, black 플레이어의 password 컬럼에 저장한다.
    - [ ] 서버는 hash 암호화 된 black 플레이어의 비밀번호를 쿠키에 담아 방 입장 요청 응답으로 넘겨준다.

- [ ] 게임 진행
    - [ ] 이동 요청 유효성 검사
        - [ ] 이동 요청에 같이 들어온 쿠키에서 값을 꺼내 검사한다.
            - [ ] password key가 있는지 확인한다.
                - [ ] 없다면 "쿠키에 password key가 없습니다." 의 메시지로 예외를 던진다.
            - [ ] password 값이 DB에 저장되어 있는 현재 차례 플레이어의 hash 암호화 된 비밀번호와 일치하는지 확인한다.
                - [ ] 일치하지 않다면, "쿠키로 전달된 암호화 된 password값이 일치하지 않습니다." 의 메시지로 예외를 던진다.

- [ ] 방 나가기
    - [ ] 체스 게임 방 안의 "게임 나가기" 버튼을 누르면, "게임을 나가면 다시 들어올 수 없습니다. 정말 나가시겠습니까?" 안내문을 띄운다.

- [ ] 사용하지 않는 부분 삭제
    - [ ] Controller, Service에서 방 목록 삭제버튼 입력 관련 부분 삭제

<br>