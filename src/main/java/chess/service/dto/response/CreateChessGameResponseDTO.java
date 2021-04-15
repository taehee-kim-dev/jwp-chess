package chess.service.dto.response;

public class CreateChessGameResponseDTO {
    private final Long gameId;
    private final String encryptedPassword;

    public CreateChessGameResponseDTO(Long gameId, String encryptedPassword) {
        this.gameId = gameId;
        this.encryptedPassword = encryptedPassword;
    }

    public Long getGameId() {
        return gameId;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }
}
