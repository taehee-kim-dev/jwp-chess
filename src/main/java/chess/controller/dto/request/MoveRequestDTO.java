package chess.controller.dto.request;


public class MoveRequestDTO {
    private Long gameId;
    private String startPosition;
    private String destination;
    private String encryptedPassword;

    public MoveRequestDTO() {
    }

    public MoveRequestDTO(Long gameId, String startPosition, String destination) {
        this.gameId = gameId;
        this.startPosition = startPosition;
        this.destination = destination;
    }

    public MoveRequestDTO(String startPosition, String destination) {
        this.startPosition = startPosition;
        this.destination = destination;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Long getGameId() {
        return gameId;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public String getDestination() {
        return destination;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }
}
