package com.mygdx.game.GameLogic.Character.PlayerCharacter;

import com.mygdx.game.GameLogic.Character.GameCharacter;

public class FireDude extends GameCharacter {
    public FireDude(String equipment) {
        super(equipment,true);
        setMaxHP(50);
        setCurrentHP(50);
        setBaseDefense(0);
        System.out.println("Character fire dude created.");
    }
}
