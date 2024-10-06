package com.SoccerLeague.soccerZone.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Handles incoming HTTP request, delegates to service layer and returns appropriate response
// Marks the class as a Spring MVC controller where every method returns a domain object instead of a view
@RestController
@RequestMapping(path ="api/vi/player") // Can change URL accordingly
public class PlayerController {
    // Create a field to store player service
    private final PlayerService playerService;

    // For automatic dependency injection so don't have to manually instantiate or provide these dependencies
    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    // Start figuring out the mapping
    // To handle all get requests
    @GetMapping
    public List<Player> getPlayers(
        @RequestParam(required = false) String team,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String position,
        @RequestParam(required = false) String nation){
        
            if (team != NULL && position != null){
                return playerService.getPlayersByTeamAndPosition(team, position);
            } else if (team != null){
                return playerService.getPlayersFromTeam(team);
            } else if (name != null){
                return playerService.getPlayersByName(name);
            } else if (position != null){
                return playerService.getPlayersByPos(position);
            } else if (nation != null){
                return playerService.getPlayersBynation(nation);
            } else{
                return playerService.getPlayers();
            }
    }

    // Handles HTTP POST request to add a new player to our database
    // @RequestBody is the player you want to add to the database
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        // Calling our service class to try and add the player to our repository
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    // Handles HTTP PUT request to update existing player in database
    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player resultPlayer = playerService.updatePlayer(player);
        if (resultPlayer != null){
            return new ResponseEntity<>(resultPlayer, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName){
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }
}
