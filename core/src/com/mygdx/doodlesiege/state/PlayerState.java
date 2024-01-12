package com.mygdx.doodlesiege.state;

import com.mygdx.doodlesiege.Player;

public interface PlayerState {
    void mainCycle(Player player);
    void handleMovementInput(Player player);
    void die(Player player);
}
