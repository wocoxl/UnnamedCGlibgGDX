package com.mygdx.game.GameLogic;


import com.mygdx.game.GameLogic.Character.GameCharacter;
import com.mygdx.game.GameLogic.Character.PlayerCharacter.FighterDude;
import com.mygdx.game.GameLogic.Character.PlayerCharacter.FireDude;
import com.mygdx.game.GameLogic.Character.PlayerCharacter.WeaponDude;

import java.util.ArrayList;


public class GameLogic {
    private GameCharacter player;
    public GameLogic(int playerCharacter, String equipment){
        isACard(equipment);
        switch(playerCharacter){
            case 1: {
                player = new FireDude(equipment);
                break;
            }

            case 2: {
                player = new FighterDude(equipment);
                break;
            }

            case 3: {
                player = new WeaponDude(equipment);
                break;
            }

            default:{
                System.out.println("Error");
                break;
            }

        }


    }

    public static void enterCombat(GameCharacter player, ArrayList<GameCharacter> mob){
        Combat newCombat = new Combat(player, mob);
        while(player.getCurrentHP()>0){
            //fight code
        }
    }

    public boolean isACard(String equipment){
        //to do
        return true;
    }

    public GameCharacter getPlayer() {
        return player;
    }
}
