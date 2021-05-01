package com.mygdx.game.GameLogic.Helper;

import com.mygdx.game.GameLogic.Character.GameCharacter;

public class combatHelper {
    public static void dealDamage(int dmg, GameCharacter target){
        if(target.getCurrentDefense()!=0){
            int def = target.getCurrentDefense()-dmg;
            if(def<0){
                target.setCurrentDefense(0);
                target.setCurrentHP(target.getCurrentHP()+def);
            }else{
                target.setCurrentDefense(def);
            }
        }else{
            target.setCurrentHP(target.getCurrentHP()-dmg);
        }
    }

    public static void applyBlock(int def, GameCharacter player){
        player.setCurrentDefense(player.getCurrentDefense()+def);
    }
}
