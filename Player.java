package com.company;

public class Player {
    //member variables
    int ID;
    Card[] playersHand;

    //Constructor
    Player(int newID, Card[] playersHand){
        this.ID = newID;
        this.playersHand = playersHand;
    }

    //Getter for accessing the Player's ID
    public int getID(){
        return this.ID;
    }

    //Getter for accessing the Player's hand
    public Card[] getPlayersHand(){
        return this.playersHand;
    }
}
