package com.mygdx.game.GameLogic.Character.Mob;

import com.mygdx.game.GameLogic.Character.GameCharacter;
import com.mygdx.game.GameLogic.Helper.combatHelper;

public class FighterMob extends Mob implements isMob {
    public FighterMob() {
        super();
        MaxHP = 18;
        currentHP = 18;
    }

    @Override
    public void action(GameCharacter player) {
        combatHelper.dealDamage(5, player);
    }
}
