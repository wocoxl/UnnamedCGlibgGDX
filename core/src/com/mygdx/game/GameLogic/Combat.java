package com.mygdx.game.GameLogic;

import com.mygdx.game.GameLogic.Character.GameCharacter;
import com.mygdx.game.GameLogic.Character.Mob.Mob;
import com.mygdx.game.GameLogic.Helper.combatHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Combat {

    public GameCharacter getPlayer() {
        return player;
    }

    public enum battleState{
        PLAYERTURN,
        MOBTURN
    }

    public ArrayList<String> currentDeck;
    public ArrayList<String> discardPile;
    public ArrayList<String> hand;
    public GameCharacter player;
    public ArrayList<GameCharacter> mob;
    public int handSize;


    public Combat(GameCharacter player, ArrayList<GameCharacter> mob){
        this.player = player;
        this.mob = mob;
        currentDeck = new ArrayList<String>();
        for(int i = 0; i< player.getDeck().size();i++){
            currentDeck.add(player.getDeck().get(i));
        }
        discardPile = new ArrayList<String>();
        hand = new ArrayList<String>();
        handSize = 5;
    }

    public void draw(){
        for(int i =0; i<handSize;i++){
            hand.add(currentDeck.get(0));
            //System.out.println(currentDeck.get(0));
            currentDeck.remove(0);
        }
    }

    public void StartTurn(){
        //while loop

        //shuffle

        if(currentDeck.size()<5) {
            shuffle();
        }
        //draw
        draw();

        //playCard

    }

    public void shuffle(){
        Random ran = new Random();

        currentDeck.addAll(discardPile);
        discardPile.removeAll(discardPile);
        Collections.shuffle(currentDeck,ran);
    }

    public void playCard(GameCharacter player, ArrayList<GameCharacter> mob, int target, String card){
        hand.remove(card);
        switch(card){
            case "punch":{
                combatHelper.dealDamage(3, mob.get(target));
                discardPile.add(card);
                break;
            }
            case "block":{
                combatHelper.applyBlock(3, player);
                discardPile.add(card);
                break;
            }
            case "Shield":{
                for(int i =0; i<2; i++){
                    discardPile.add("shield slam");
                }
                break;
            }
            case "shield slam":{
                break;
            }
        }


    }

    public void mobAction(Mob mob){
        mob.action(player);
    }

    private void endTurn(){

    }

    public boolean combatFinish(){
        boolean finish = false;
        int mobhp = 0;

        if((player.getCurrentHP()<0)||(mob.size()==0)){
            finish = true;
        }

        return finish;
    }
}
