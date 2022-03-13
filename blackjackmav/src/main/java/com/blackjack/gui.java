package com.blackjack;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class gui extends Application{
    private blackjack ins;
    private Label playScore,dealScore;
    private Button hitBut,standBut;
    private blackjack makeGame(){
        return new blackjack(new Deck(false, 2), this);
    }
    public Button getHitBut(){
        return hitBut;
    }
    public void updateScore(int dealer,int user){
        playScore.setText("Player Score: "+user);
        dealScore.setText("Dealer Score: "+dealer);
    }
    @Override
    public void start(Stage primaryStage){
        Scene scene;
        Button playBut,exitBut; //button to hit, button to stand, button to play again
        ins=makeGame();
        VBox vbox;

        exitBut=new Button("Exit");
        hitBut=new Button("Hit");
        standBut=new Button("Stand");
        playBut=new Button("Play Again");
        
        playScore=new Label("Player Score: "+ins.getPlayerScore());
        dealScore=new Label("Dealer Score: "+ins.getDealerScore());
        
        exitBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event){
                ins.kill();
                Platform.exit();
            }
        });
        playBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                ins.kill();
                ins=makeGame();
                updateScore(ins.getDealerScore(), ins.getPlayerScore());
                ins.start();
            }
        });
        hitBut.setOnAction(new EventHandler<ActionEvent>() { //FIXME: synch issues result in updated values not displaying
            @Override public void handle(ActionEvent event){
                ins.setUserPlay('h');
                try{wait();}catch(InterruptedException e){}
            }
        });
        standBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event){
                ins.setUserPlay('s');
                dealScore.setText("Dealer Score: "+ins.getDealerScore());
            }
        });

        vbox=new VBox(dealScore,playScore,hitBut,standBut,playBut,exitBut);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER_LEFT);
        scene=new Scene(vbox,300,300);

        primaryStage.setTitle("Blackjack");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("App Started");
        ins.start();
    }
    
}
