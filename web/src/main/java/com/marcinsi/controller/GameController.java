package com.marcinsi.controller;


import com.marcinsi.service.GameService;
import com.marcinsi.util.AttributeNames;
import com.marcinsi.util.GameMappings;
import com.marcinsi.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GameController {

    // == fields ==

    private final GameService gameService;

    // == constructor ==

    // constructor injection

    @Autowired
    public GameController(GameService gameService) {

        this.gameService = gameService;
    }

    // == request methods ==

    @GetMapping(GameMappings.PLAY)
    public String play(Model model){

        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());

        log.info("model = {}", model);

        if(gameService.isGameOver()){

            return ViewNames.GAME_OVER;
        }

        return ViewNames.PLAY;
    }

    @PostMapping(GameMappings.PLAY)
    public String processMessage(@RequestParam(defaultValue = "-1") int guess){

        log.info("guess = {}", guess);

        // Different layers -> we invoke checkGuess method on gameService

        gameService.checkGuess(guess);

        return GameMappings.REDIRECT_PLAY;
    }

    @GetMapping(GameMappings.RESTART)
    public String restart(){

        gameService.reset();

        // redirecting

        return GameMappings.REDIRECT_PLAY;
    }
}
