package edu.eci.cvds.servlet.model;


import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;


@ManagedBean(name = "guessBean")

@SessionScoped
public class BackingBean {

    private int randomNumber;

    private int attemptNumber;

    private int attempts;

    private int prize;

    private String gameState;

    public BackingBean(){
        start();
    }

    public void setAttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    private void start(){
        Random ran = new Random();
        this.randomNumber = ran.nextInt(10);
        this.attempts = 0;
        this.attemptNumber = 0;
        this.prize = 100000;
        this.gameState = "HA PERDIDO";
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }



    public void setRandomNumber() {
        this.randomNumber = randomNumber;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public void guess (ActionEvent actionEvent){
        this.attempts+= 1;
        if(this.attemptNumber == this.randomNumber && this.attempts <= 10){
            this.gameState = "GANÓ,  PREMIO TOTAL : " + getPrize();
        }
        else{
            if(this.prize != 0){
                this.prize -= 10000;
            }

        }



    }

    public void restart(ActionEvent actionEvent){
        start();
    }


}
