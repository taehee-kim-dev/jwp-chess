package chess.controller.dto.request;

public class RoomCreateRequestDTO {
    private final String roomTitle;
    private final String whitePlayerPassword;

    public RoomCreateRequestDTO(String roomTitle, String whitePlayerPassword) {
        this.roomTitle = roomTitle;
        this.whitePlayerPassword = whitePlayerPassword;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public String getWhitePlayerPassword() {
        return whitePlayerPassword;
    }
}
