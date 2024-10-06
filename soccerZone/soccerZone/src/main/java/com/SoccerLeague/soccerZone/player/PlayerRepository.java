package com.SoccerLeague.soccerZone.player;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// Extends the JpaRepository which provides CRUD operations for the player entity
// <Player.. -> Specifies the entity type
// <... String -> Type of primary key is string
@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    // Write 2 custom methods

    // Finds a player by their name and deletes it
    void deleteByName(String playerName); 

    // Find any player by their name in the repository
    // Use of "Optional" is to handle cases where players may not be found in the repository
    Optional<Player> findByName(String name);
}
