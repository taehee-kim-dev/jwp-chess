package chess.service.dto.request;

public class PlayerPasswordSaveRequestDTO {
    private final String password;
    private final boolean isWhitePlayer;

    public PlayerPasswordSaveRequestDTO(String password, boolean isWhitePlayer) {
        this.password = password;
        this.isWhitePlayer = isWhitePlayer;
    }

    public String getPassword() {
        return password;
    }

    public boolean isWhitePlayer() {
        return isWhitePlayer;
    }
}
