package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.GameService;
import org.example.util.AttributeNames;
import org.example.util.GameMappings;
import org.example.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class GameController {

    // == fields ==
    private final GameService gameService;

    // == constructor ==
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // == request methods ==
    @GetMapping(GameMappings.PLAY)
    public String play(Model model) {
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        log.info("model = {}", model);

        if (gameService.isGameOver()) {
            return ViewNames.GAME_OVER;
        } else {
            return ViewNames.PLAY;
        }
    }

    // parameter "guess" needs to match the name of the input inside the form (play.html)
    @PostMapping(GameMappings.PLAY)
    public String processMessage(@RequestParam int guess) {
        log.info("guess = {}", guess);
        gameService.checkGuess(guess);
        return GameMappings.REDIRECT_PLAY;
    }

    @GetMapping(GameMappings.RESTART)
    public String restart() {
        gameService.reset();
        return GameMappings.REDIRECT_PLAY;
    }
}
