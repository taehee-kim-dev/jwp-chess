package chess.domain.board.move;

import chess.controller.dto.request.MoveRequestDTO;
import chess.domain.piece.type.Direction;
import chess.domain.player.type.TeamColor;
import chess.domain.position.Position;

public class MoveRequest {
    private final Long gameId;
    private final TeamColor currentTurnTeamColor;
    private final Position startPosition;
    private final Position destination;
    private String encryptedPassword;

    public MoveRequest(TeamColor currentTurnTeamColor, MoveRequestDTO moveRequestDTO) {
        this.gameId = moveRequestDTO.getGameId();
        this.currentTurnTeamColor = currentTurnTeamColor;
        startPosition = Position.of(moveRequestDTO.getStartPosition());
        destination = Position.of(moveRequestDTO.getDestination());
        encryptedPassword = moveRequestDTO.getEncryptedPassword();
    }

    public Long getGameId() {
        return gameId;
    }

    public TeamColor getCurrentTurnTeamColor() {
        return currentTurnTeamColor;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getDestination() {
        return destination;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public Direction getDirection() {
        return startPosition.calculateDirection(destination);
    }

    public Position getNextPositionOfStartPosition() {
        return startPosition.moveTo(getDirection());
    }

    public boolean isDestination(Position position) {
        return position.equals(destination);
    }

    public boolean isRankForwardedBy(int rankDiff) {
        return startPosition.isRankForwardedBy(destination, rankDiff);
    }

    public boolean isStartPositionFirstPawnPosition() {
        return startPosition.isFirstPawnPosition(currentTurnTeamColor);
    }

    public Long getDestinationId() {
        return destination.getId();
    }
}
