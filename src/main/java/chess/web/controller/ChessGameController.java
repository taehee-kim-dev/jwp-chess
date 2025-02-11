package chess.web.controller;


import chess.web.controller.dto.request.CreateGameRequestDto;
import chess.web.controller.dto.request.JoinGameRequestDto;
import chess.web.controller.dto.response.ChessGameResponseDto;
import chess.web.controller.dto.response.CreateGameResponseDto;
import chess.web.controller.dto.response.GameStatusResponseDto;
import chess.web.service.ChessGameService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ChessGameController {

    protected static final String ENCRYPTED_PASSWORD = "encryptedPassword";
    private final ChessGameService chessGameService;

    public ChessGameController(ChessGameService chessGameService) {
        this.chessGameService = chessGameService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<ChessGameResponseDto> notFulledChessGames = chessGameService.getNotFulledChessGames();
        model.addAttribute("notFulledChessGames", notFulledChessGames);
        return "index";
    }

    @PostMapping("/games")
    public String createGame(@ModelAttribute CreateGameRequestDto createGameRequestDto, HttpServletResponse response) {
        CreateGameResponseDto createGameResponseDto = chessGameService.createNewChessGame(createGameRequestDto);
        Cookie cookie = new Cookie(ENCRYPTED_PASSWORD, createGameResponseDto.getEncryptedWhitePlayerPassword());
        response.addCookie(cookie);
        return "redirect:/games/" + createGameResponseDto.getGameId();
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinGame(@RequestBody JoinGameRequestDto joinGameRequestDto, HttpServletResponse response) {
        String encryptedBlackPlayerPassword = chessGameService.joinGame(joinGameRequestDto);
        Cookie cookie = new Cookie(ENCRYPTED_PASSWORD, encryptedBlackPlayerPassword);
        response.addCookie(cookie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/games/{gameId}")
    public String chessBoard(@PathVariable Long gameId, Model model, HttpServletResponse response) {
        GameStatusResponseDto gameStatusDto = chessGameService.getGameStatus(gameId);
        addCookiesAboutGameToResponse(gameStatusDto, response);
        model.addAttribute("gameStatusDto", gameStatusDto);
        return "chess-game";
    }

    private void addCookiesAboutGameToResponse(GameStatusResponseDto gameStatusResponseDto, HttpServletResponse response) {
        List<Cookie> cookies = getCookiesAboutGame(gameStatusResponseDto);

        for (Cookie cookie : cookies) {
            response.addCookie(cookie);
        }
    }

    private List<Cookie> getCookiesAboutGame(GameStatusResponseDto gameStatusResponseDto) {
        return new ArrayList<>(Arrays.asList(
            new Cookie("gameId", String.valueOf(gameStatusResponseDto.getGameId())),
            new Cookie("title", gameStatusResponseDto.getTitle()),
            new Cookie("beforeTurnTeamColorName", gameStatusResponseDto.getBeforeTurnTeamColorName()),
            new Cookie("currentTurnTeamColorName", gameStatusResponseDto.getCurrentTurnTeamColorName()),
            new Cookie("boardStatus", gameStatusResponseDto.getBoardStatus()),
            new Cookie("whitePlayerScore", String.valueOf(gameStatusResponseDto.getWhitePlayerScore())),
            new Cookie("blackPlayerScore", String.valueOf(gameStatusResponseDto.getBlackPlayerScore())),
            new Cookie("isKingDead", String.valueOf(gameStatusResponseDto.isKingDead()))
        ));
    }


}
