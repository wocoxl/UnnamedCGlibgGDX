package com.mygdx.game.Test;

import com.mygdx.game.GameLogic.Character.GameCharacter;
import com.mygdx.game.GameLogic.Combat;
import com.mygdx.game.GameLogic.Character.PlayerCharacter.FireDude;
import com.mygdx.game.GameLogic.GameLogic;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class CombatTest {

    public GameLogic game;
    public GameCharacter[] mob;
    public Combat newCombat;
    public GameCharacter player2;
    @Before
    public void setUp() throws Exception {
        game = new GameLogic(1, "Shield");
        mob = null;
        player2 = new FireDude("Shield");
        newCombat = new Combat(game.getPlayer() ,mob);
    }

    @Test
    public void testShuffle(){
        Assert.assertEquals(player2.getDeck(), newCombat.currentDeck);
        newCombat.shuffle();

        Assert.assertNotEquals(player2.getDeck(), newCombat.currentDeck);

    }

    @Test
    public void testDraw(){

        newCombat.draw();

        Assert.assertEquals(newCombat.hand.size(),newCombat.handSize);
        Assert.assertEquals(newCombat.currentDeck.size(),game.getPlayer().getDeck().size()-newCombat.handSize);

    }
}