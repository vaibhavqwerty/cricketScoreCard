package com.example.demo.controller;


import com.example.demo.dto.Game;
import com.example.demo.dto.ScoreCard;
import com.example.demo.dto.Team;
import com.example.demo.service.GameActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@Slf4j
public class GameController {

    @Autowired
    private GameActivityService gameActivityService;

    @RequestMapping(value="/newGame",
            method = RequestMethod.POST,
            produces= MediaType.TEXT_HTML_VALUE)
    public ResponseEntity postRequest(@RequestParam Integer numberOfPlayers,@RequestParam Integer overPerTeam,@RequestParam String membersTeam1, @RequestParam String membersTeam2, @RequestParam Integer battingTeam){
        try{

            gameActivityService.createGame(overPerTeam,numberOfPlayers,membersTeam1,membersTeam2,battingTeam);
            return new ResponseEntity("Successfully created new game ", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/getScore",
            method = RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRequest(){
        try{
            if(Game.currentTeam==1){
                return new ResponseEntity(new ScoreCard("Team 1",Game.getTeam1()), HttpStatus.OK);
            }
            return new ResponseEntity(new ScoreCard("Team 2",Game.getTeam2()), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/addRun",
            method = RequestMethod.POST,
            produces= MediaType.TEXT_HTML_VALUE)
    public ResponseEntity addRun(@RequestParam String runs){
        try{
            gameActivityService.addRuns(runs);
            return new ResponseEntity("Score updated Successfully ", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
