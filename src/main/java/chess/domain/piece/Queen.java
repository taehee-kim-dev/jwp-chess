package chess.domain.piece;

import static chess.domain.piece.type.PieceType.QUEEN;

import chess.domain.color.type.TeamColor;
import chess.domain.piece.type.Direction;

public class Queen extends Piece {

    private static final double SCORE = 9;

    public Queen(TeamColor teamColor) {
        super(QUEEN, teamColor, SCORE, Direction.queenDirections());
    }
}
