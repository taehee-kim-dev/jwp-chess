package chess.controller.dto.request;

public class JoinChessRoomRequestDTO {
    private Long gameId;
    private String blackPlayerPassword;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getBlackPlayerPassword() {
        return blackPlayerPassword;
    }

    public void setBlackPlayerPassword(String blackPlayerPassword) {
        this.blackPlayerPassword = blackPlayerPassword;
    }
}
