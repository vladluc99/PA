package com.vlad.controller;

import com.vlad.model.Player;
import com.vlad.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;

    @GetMapping("/player")
    private List<Player> getAllPlayers() {
        List<Player> playerList = new ArrayList<>();
        playerRepository.findAll().forEach(playerList::add); //adaugam fiecare jucator din baza de date in lista
        return playerList;
    }

    @PostMapping("/player")
    private Player savePlayer(@RequestBody Player player) {
        playerRepository.save(player);
        return player;
    }

    @PutMapping("/player/{playerid}")
    private Player update(@PathVariable("playerid") int playerid, @RequestParam String name) {
        Player player = playerRepository.findById(playerid).get();
        player.setPlayerName(name);
        playerRepository.save(player);
        return player;
    }

    @DeleteMapping("/player/{playerid}")
    private void deletePlayer(@PathVariable("playerid") int playerid) {
        playerRepository.deleteById(playerid);
    }
}
