package com.blackjack;
import java.util.Scanner;

public class player {
    //helper
    private int updateScore(String[] start){
        String[] values=Deck.value;
        int ind=0;
        int score=0;
        for (int i=0;i<start.length;i++){
            for (int x=0;x<values.length;x++){
                ind=x;
                if (values[x].equals(start[i].substring(1))){
                    break;
                }
            }
            if (ind<8){
                score+=Integer.parseInt(start[i].substring(1));
            }else if(ind!=values.length-1){
                score+=10;
            }
        }
        for (int i=0;i<start.length;i++){
            if (start[i].substring(1).equals("A")){
                if (score<=10){
                score+=11;
                }else{
                    score++;
                }
            }
        }
        return score;
    }
    private int updateCount(String[] start){
        String[] values=Deck.value;
        int ind=0;
        int curCount=0;
        for (int i=0;i<start.length;i++){
            for (int x=0;x<values.length;x++){
                ind=x;
                if (values[x].equals(start[i].substring(1))){break;}
            }
            if (ind<5){
                curCount++;
            }else if(ind>=8){
                curCount--;
            }
        }
        return curCount;
    }
    //param
    private String[] hand,enemyHand;
    private int score;
    private int count;
    //constructor
    public player(String[] myHand, String[] playHand){
        hand=myHand;
        enemyHand=playHand;
        score=updateScore(hand);
        count=updateCount(hand);
        count+=updateCount(enemyHand);
    }
    public player(String[] myHand){
        hand=myHand;
        score=updateScore(hand);
        count=updateCount(hand);
    }
    //getter
    public String[] myHand(){
        return hand;
    }
    public int getScore(){
        return score;
    }
    //mutator
    public char play(){
        if (score<=10){
            return 'h';
        }else if(score>=19){
            return 's';
        }else if(score+count<=18){
            return 'h';
        }else{
            return 's';
        }
    }
    public char play(Scanner input){
        char userPlay;
        userPlay=input.next().charAt(0);
        return userPlay;
    }
    public void updateHand(String[] newHand){
        hand=newHand;
        score=updateScore(hand);
        count=updateCount(hand);
    }
}
