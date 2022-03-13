package com.blackjack;

import javafx.application.Application;

public class game{
    static blackjack ins;
    public static void main(String[] args){
        gui GUI=new gui();
        Application.launch(GUI.getClass(), args);
    }
}
