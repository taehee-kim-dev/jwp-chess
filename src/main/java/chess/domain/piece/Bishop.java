package chess.domain.piece;

import static chess.domain.piece.type.PieceType.BISHOP;

import chess.domain.color.type.TeamColor;
import chess.domain.piece.type.Direction;

public class Bishop extends Piece {

    private static final double SCORE = 3;

    public Bishop(TeamColor teamColor) {
        super(BISHOP, teamColor, SCORE, Direction.bishopDirections());
    }
}
