package com.mygdx.game.GameLogic.Character;

import java.util.ArrayList;

public class GameCharacter {
    protected int MaxHP ;
    protected int currentHP;
    protected int baseDefense;
    protected int currentDefense;
    protected ArrayList<String> deck;
    public GameCharacter(String equipment, boolean player){
        if(player==true) {
            deck = new ArrayList<String>();
            deck.add(equipment);
            for(int i = 0; i<3; i++){
                deck.add("punch");
                deck.add("block");
            }
        }
    }

    public void setMaxHP(int MaxHP) {
        this.MaxHP = MaxHP;
    }

    public int getMaxHP(){
        return MaxHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void addToDeck(String card) {
        deck.add(card);
    }

    public void deleteFromDeck(String card){
        deck.remove(card);
    }

    public ArrayList<String> getDeck (){
        return deck;
    }

    public int getBaseDefense(){
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense){
        this.baseDefense = baseDefense;
    }

    public int getCurrentDefense () {
        return currentDefense;
    }

    public void setCurrentDefense (int currentDefense) {
        this.currentDefense = currentDefense;
    }

}
