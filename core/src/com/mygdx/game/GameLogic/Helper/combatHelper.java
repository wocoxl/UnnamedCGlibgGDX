package com.mygdx.game.GameLogic.Helper;

import com.mygdx.game.GameLogic.Character.GameCharacter;

public class combatHelper {
    public static void dealDamage(int dmg, GameCharacter target){
        if(target.getBaseDefense()!=0){
            int def = target.getBaseDefense()-dmg;
            if(def<0){
                target.setBaseDefense(0);
                target.setCurrentHP(target.getCurrentHP()+def);
            }else{
                target.setBaseDefense(def);
            }
        }else{
            target.setCurrentHP(target.getCurrentHP()-3);
        }
    }

    public static void applyBlock(int def, GameCharacter player){
        player.setCurrentDefense(player.getCurrentDefense());
    }
}
