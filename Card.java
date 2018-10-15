package com.company;

public class Card {
    //public static final char[] Suit = { '.', 'd', 'c', 'h', 's'};
    private static final String Rank = "..23456789TJQKA";

    //member variables
    public int rank;
    public char suit;

    //Constructor
    public Card(char newRank, char newSuit){
        this.rank = Rank.indexOf(newRank);
        this.suit = newSuit;
    }

    //Getter for accessing the Card's suit
    public char getSuit(){
        return this.suit;
    }

    //Getter for accessing the Card's rank
    public int getRank(){
        return this.rank;
    }
}
