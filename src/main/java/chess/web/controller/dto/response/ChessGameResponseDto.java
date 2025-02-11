package chess.web.controller.dto.response;


import chess.domain.game.ChessGame;

public class ChessGameResponseDto {

    private final Long gameId;
    private final String title;

    public ChessGameResponseDto(ChessGame chessGame) {
        gameId = chessGame.getId();
        title = chessGame.getTitle();
    }

    public Long getGameId() {
        return gameId;
    }

    public String getTitle() {
        return title;
    }
}
