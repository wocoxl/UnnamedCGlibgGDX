package com.mygdx.game.GameLogic.Character.PlayerCharacter;

import com.mygdx.game.GameLogic.Character.GameCharacter;

public class WeaponDude extends GameCharacter {
    public WeaponDude(String equipment) {
        super(equipment,true);
        setMaxHP(55);
        setCurrentHP(55);
        setBaseDefense(0);
        System.out.println("Character weapon dude created.");
    }
}