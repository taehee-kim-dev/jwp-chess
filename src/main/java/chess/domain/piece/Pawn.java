package chess.domain.piece;

import static chess.domain.piece.type.PieceType.PAWN;

import chess.domain.color.type.TeamColor;
import chess.domain.piece.type.Direction;

public class Pawn extends Piece {

    private static final double DEFAULT_SCORE = 1;
    private static final double HALF_SCORE = DEFAULT_SCORE / 2;

    public Pawn(TeamColor teamColor) {
        super(PAWN, teamColor, DEFAULT_SCORE, Direction.pawnDirections(teamColor));
    }

    public static double defaultScore() {
        return DEFAULT_SCORE;
    }

    public static double halfScore() {
        return HALF_SCORE;
    }
}
