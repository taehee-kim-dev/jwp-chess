package chess.dao.player;

import chess.domain.player.type.TeamColor;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository {
    void save(TeamColor[] teamColors, Long gameId) throws SQLException;

    void savePlayerPassword(Long playerId, String encryptedPassword);

    String findPasswordByGameIdIdAndTeamColor(Long gameId, TeamColor teamColor);

    Long findIdByGameIdAndTeamColor(Long gameId, TeamColor teamColor) throws SQLException;

    void removeAllByChessGame(Long gameId) throws SQLException;

    void removeAll() throws SQLException;
}
