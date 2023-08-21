package com.example.demo.controller;

import com.example.demo.dto.Game;
import com.example.demo.dto.Team;
import com.example.demo.service.TeamActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
@Slf4j
public class TeamController {

    @Autowired
    private TeamActivityService teamActivityService;
    @RequestMapping(value="/team/addPlayers",
            method = RequestMethod.POST,
            produces= MediaType.TEXT_HTML_VALUE)
    public ResponseEntity addPlayers(@RequestParam List<String> PlayerList){
        try{

            for(int i=0;i<PlayerList.size();i++){
                Game.setTeam1(teamActivityService.addPlayer(PlayerList.get(i),Game.getTeam1()));
            }
            return new ResponseEntity("Successfully added players ", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
