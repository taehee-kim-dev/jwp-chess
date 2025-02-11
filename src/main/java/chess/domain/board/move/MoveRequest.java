package chess.domain.board.move;

import chess.domain.color.type.TeamColor;
import chess.domain.piece.type.Direction;
import chess.domain.position.Position;

public class MoveRequest {

    private final TeamColor currentTurnTeamColor;
    private final Position startPosition;
    private final Position destination;

    public MoveRequest(TeamColor currentTurnTeamColor, String startPositionInput, String destinationInput) {
        this.currentTurnTeamColor = currentTurnTeamColor;
        this.startPosition = Position.of(startPositionInput);
        this.destination = Position.of(destinationInput);
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
}
