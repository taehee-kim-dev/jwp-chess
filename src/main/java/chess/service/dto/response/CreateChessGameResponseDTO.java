package chess.service.dto.response;

public class CreateChessGameResponseDTO {
    private final Long gameId;
    private final String password;

    public CreateChessGameResponseDTO(Long gameId, String password) {
        this.gameId = gameId;
        this.password = password;
    }

    public Long getGameId() {
        return gameId;
    }

    public String getPassword() {
        return password;
    }
}
