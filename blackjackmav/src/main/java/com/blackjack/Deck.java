package com.blackjack;
public class Deck {
    //helpers
    private String[] remove(String[] start,int ind){
        boolean skip=false;
        String[] temp=new String[start.length-1];
        for (int i=0;i<temp.length;i++){
            if (i==ind){skip=true;}
            if (!skip){
                temp[i]=start[i];
            }else{
                temp[i]=start[i+1];
            }
        }
        return temp;
    }
    //param
    public int numDecks;
    public static char[] suit={'S','C','H','D'};
    public static String[] value={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    public static String[] deck;
    //constructer
    public Deck(){
        numDecks=1;
        deck=new String[13*4+1];
        for (int i=0;i<deck.length-1;i++){
            deck[i]=suit[i%4]+value[i%13];
        }
        deck[deck.length-1]="Joker";
        this.shuffle();
    }

    public Deck(boolean Joker){
        numDecks=1;
        if (Joker){
            deck=new String[13*4+1];
            for (int i=0;i<deck.length-1;i++){
                deck[i]=suit[i%4]+value[i%13];
            }
            deck[deck.length-1]="Joker";
        }else{
            deck=new String[13*4];
            for (int i=0;i<deck.length;i++){
                deck[i]=suit[i%4]+value[i%13];
            }
        }
        this.shuffle();
    }

    public Deck(int num){
        numDecks=num;
        deck=new String[numDecks*(13*4+1)];
        for (int i=0;i<deck.length;i++){
            if (i%53==52){
                deck[i]="Joker";
            }else{
                deck[i]=suit[i%4]+value[i%13];
            }
        }
        this.shuffle();
    }

    public Deck(boolean Joker,int num){
        numDecks=num;
        if (Joker){
            deck=new String[numDecks*(13*4+1)];
            for (int i=0;i<deck.length;i++){
                if (i%53==52){
                    deck[i]="Joker";
                }else{
                    deck[i]=suit[i%4]+value[i%13];
                }
            }
        }else{
            deck=new String[13*4*numDecks];
            for (int i=0;i<deck.length;i++){
                deck[i]=suit[i%4]+value[i%13];
            }
        }
        this.shuffle();
    }

    public Deck(int num,boolean Joker){
        numDecks=num;
        if (Joker){
            deck=new String[numDecks*(13*4+1)];
            for (int i=0;i<deck.length;i++){
                if (i%53==52){
                    deck[i]="Joker";
                }else{
                    deck[i]=suit[i%4]+value[i%13];
                }
            }
        }else{
            deck=new String[13*4*numDecks];
            for (int i=0;i<deck.length;i++){
                deck[i]=suit[i%4]+value[i%13];
            }
        }
        this.shuffle();
    }
    //getter
    public String[] getDeck(){
        return deck;
    }

    public int getNumDecks(){
        return numDecks;
    }

    public String[] getVal(){
        return value;
    }

    public char[] getSuits(){
        return suit;
    }
    //mutator
    public void shuffle(){
        int rand;
        String[] tempDeck=new String[deck.length];
        for (int i=0;i<tempDeck.length;i++){
            rand=(int)(Math.random()*deck.length);
            tempDeck[i]=deck[rand];
            deck=remove(deck,rand);
        }
        deck=tempDeck;
    }

    public String draw(){
        String card=deck[0];
        deck=remove(deck,0);
        return card;
    }
}
