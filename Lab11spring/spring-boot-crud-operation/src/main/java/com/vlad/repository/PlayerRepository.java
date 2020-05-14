package com.vlad.repository;

import com.vlad.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository <Player, Integer> {
}
