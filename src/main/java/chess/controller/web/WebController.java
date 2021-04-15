package chess.controller.web;


import chess.controller.dto.request.MoveRequestDTO;
import chess.controller.dto.request.RoomCreateRequestDTO;
import chess.controller.dto.response.BoardResponseDTO;
import chess.controller.dto.response.ChessGameResponseDTO;
import chess.controller.dto.response.MoveResponseDTO;
import chess.controller.dto.response.ResponseDTO;
import chess.service.ChessWebService;
import chess.service.dto.response.CreateChessGameResponseDTO;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Profile("web")
@Controller
public class WebController {
    private static final String ROOT = "/";
    private static final String CREATE_CHESS_ROOM = "rooms";
    private static final String CHESS_BOARD = "rooms";
    private static final String MOVE = "move";
    private static final String DELETE = "delete";
    private static final String CHESS_BOARD_VIEW = "chess-board";
    private static final String HOME_VIEW = "index";
    private static final String RESPONSE_DTO = "responseDTO";

    private final ChessWebService chessWebService;

    public WebController(ChessWebService chessWebService) {
        this.chessWebService = chessWebService;
    }

    @GetMapping(ROOT)
    public String home(Model model) throws SQLException {
        List<ChessGameResponseDTO> allRoomsIdAndTitle = chessWebService.getAllRoomsIdAndTitle();
        model.addAttribute("allChessGameRooms", allRoomsIdAndTitle);
        return HOME_VIEW;
    }

    @PostMapping(ROOT + CREATE_CHESS_ROOM)
    public String createChessRoomRequest(@ModelAttribute RoomCreateRequestDTO roomCreateRequestDTO, HttpServletResponse response) throws SQLException {
        System.out.println(roomCreateRequestDTO);
        CreateChessGameResponseDTO createChessGameResponseDTO = chessWebService.createNewChessGame(roomCreateRequestDTO);
        Cookie cookie = new Cookie("password", createChessGameResponseDTO.getPassword());
        response.addCookie(cookie);
        return "redirect:" + ROOT + CHESS_BOARD + "?id=" + createChessGameResponseDTO.getGameId();
    }

    @GetMapping(ROOT + CHESS_BOARD)
    public String getChessBoardRequest(@RequestParam("id") Long gameId, Model model) throws SQLException {
        ResponseDTO responseDTO = chessWebService.getGameStatus(gameId);
        model.addAttribute(RESPONSE_DTO, responseDTO);
        putBoardRanksToModel(model, responseDTO.getBoardResponseDTO());
        return CHESS_BOARD_VIEW;
    }

    private void putBoardRanksToModel(Model model, BoardResponseDTO boardResponseDTO) {
        model.addAttribute("rank8", boardResponseDTO.getRank8());
        model.addAttribute("rank7", boardResponseDTO.getRank7());
        model.addAttribute("rank6", boardResponseDTO.getRank6());
        model.addAttribute("rank5", boardResponseDTO.getRank5());
        model.addAttribute("rank4", boardResponseDTO.getRank4());
        model.addAttribute("rank3", boardResponseDTO.getRank3());
        model.addAttribute("rank2", boardResponseDTO.getRank2());
        model.addAttribute("rank1", boardResponseDTO.getRank1());
    }

    @PostMapping(ROOT + MOVE)
    @ResponseBody
    public MoveResponseDTO moveRequest(@RequestBody MoveRequestDTO moveRequestDTO) throws SQLException {
        return chessWebService.requestMove(moveRequestDTO);
    }

    @GetMapping(ROOT + DELETE)
    public String deleteRequest(@RequestParam("id") Long gameId) throws SQLException {
        chessWebService.deleteGame(gameId);
        return "redirect:" + ROOT;
    }
}
