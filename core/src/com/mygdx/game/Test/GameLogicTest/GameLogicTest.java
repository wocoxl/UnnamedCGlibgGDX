package com.mygdx.game.Test.GameLogicTest;

import com.badlogic.gdx.Game;
import com.mygdx.game.GameLogic.Character.GameCharacter;
import com.mygdx.game.GameLogic.Character.Mob.FighterMob;
import com.mygdx.game.GameLogic.Character.Mob.Mob;
import com.mygdx.game.GameLogic.Combat;
import com.mygdx.game.GameLogic.Character.PlayerCharacter.FireDude;
import com.mygdx.game.GameLogic.GameLogic;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.Scanner;

public class GameLogicTest {

    public static void main(String args[]) {
        GameLogic gl;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose starting character:");
        System.out.println("Type 1 for Fire");
        System.out.println("Type 2 for Weapon");
        System.out.println("Type 3 for Fighter");

        int pc = Integer.parseInt(sc.nextLine());

        try {
            if ((pc > 3) || (pc < 1)) throw new Exception();
        } catch (Exception e) {
            System.out.println("Invalid Input. Terminating");
            System.exit(0);
        }

        System.out.println("Please choose starting equipment from:");
        System.out.println("Shield");
        System.out.println("Sword");
        System.out.println("Spear");

        String equipment = sc.nextLine();

        //initialize game/player character
        gl = new GameLogic(pc, equipment);

        //initialize mob
        ArrayList<GameCharacter> mob = new ArrayList<GameCharacter>();
        GameCharacter fighterMob = new FighterMob();
        mob.add(fighterMob);

        Combat c = new Combat(gl.getPlayer(), mob);

        System.out.println("Combat begins.");
        while (!c.combatFinish()) {
            c.draw();
            while (c.currentPower!=0) {//condition of turn ending
                if(mob.size()==0) break;
                statusUpdate(c, c.getPlayer(), mob);
                String card = sc.nextLine();
                int target = 0;
                c.playCard(c.getPlayer(),mob,target,card);
                c.currentPower-=1;

                //check if mob dies
                if(mob.get(target).getCurrentHP()<=0){
                    mob.remove(mob.get(target));
                }
            }
            c.endTurn();

            for(int i =0;i<mob.size();i++){
                mob.get(i).action(gl.getPlayer());
                //mobs' actions
            }
            //reset power
            c.currentPower=3;

        }

    }

    public static void statusUpdate(Combat c, GameCharacter pc, ArrayList<GameCharacter> mob){

        System.out.println("Player HP:"+ pc.getCurrentHP() + "/" + pc.getMaxHP());
        System.out.println("Current Power =" +c.currentPower + "/" + pc.getPower());
        for(int i =0; i<mob.size();i++){
            GameCharacter a = mob.get(i);
            System.out.println("Mob"+i+ "HP:"+ a.getCurrentHP() + "/" + a.getMaxHP());
        }
        System.out.println("Current Hand:");
        for(int i= 0;i<c.hand.size();i++){
            System.out.println(i+" "+c.hand.get(i));
        }
        System.out.println("Please choose a card to play.");
    }



}