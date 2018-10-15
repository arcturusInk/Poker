package com.company;

public class Poker {
    //ranking of hand
    private static final int STRAIGHT_FLUSH  = 8000000;
    private static final int THREE_OF_A_KIND = 7000000;
    private static final int STRAIGHT        = 6000000;
    private static final int FLUSH           = 5000000;
    private static final int PAIRS           = 4000000;
    private static final int CONSTANT        = 15;

    //Selection Sort of player's hand
    //@param playersHand - an array of cards that constitutes a player's hand for a game
    private static void sortRank(Card[] playersHand){
        int i, j, minIndex;
        for (i = 0 ; i < playersHand.length ; ++i){
            minIndex = i;
            for (j = i+1; j < playersHand.length; ++j){
                if (playersHand[j].getRank() < playersHand[minIndex].getRank()){
                    minIndex = j;
                }
            }
            Card temp = playersHand[i];
            playersHand[i] = playersHand[minIndex];
            playersHand[minIndex]= temp;
        }
    }

    //Determines the value of each card based on the rank
    //@param playersHand - an array of cards that constitutes a player's hand for a game
    //@return - the total calculated value of the player's hand
    private static int valueOfHighCard(Card[] playersHand){
        sortRank(playersHand);
        return playersHand[0].getRank() + CONSTANT*playersHand[1].getRank() + CONSTANT*CONSTANT*playersHand[2].getRank();
    }

    //Determines whether the player's hand is a Straight
    //@param playersHand - an array of cards that constitutes a player's hand for a game
    //@return - returns true if hand is Straight, returns false otherwise
    private static boolean isStraight(Card[] playersHand){
        int l = 0;
        if(playersHand.length != 3){
            return false;
        }
        sortRank(playersHand);
        if(playersHand[l+2].getRank()-playersHand[l].getRank() == 2 && playersHand[l+1].getRank()-playersHand[l].getRank() == 1){
            return true;
        }
        return false;
    }

    //Determines whether the player's hand is a Flush
    //@param playersHand - an array of cards that constitutes a player's hand for a game
    //@return - returns true if hand is Flush, returns false otherwise
    private static boolean isFlush(Card[] playersHand){
        if(playersHand.length != 3){
            return false;
        }
        if(playersHand[0].getSuit() == playersHand[1].getSuit() && playersHand[1].getSuit() == playersHand[2].getSuit()){
            return true;
        }
        return false;
    }

    //Determines whether the player's hand is a Three of a Kind
    //@param playersHand - an array of cards that constitutes a player's hand for a game
    //@return - returns true if hand is Three of a Kind, returns false otherwise
    private static boolean isThreeOfAKind(Card[] playersHand){
        if(playersHand.length != 3){
            return false;
        }
        sortRank(playersHand);
        if(playersHand[0].getRank() == playersHand[1].getRank() && playersHand[1].getRank() == playersHand[2].getRank()){
            return true;
        }
        return false;
    }

    //Determines whether the player's hand has a Pair
    //@param playersHand - an array of cards that constitutes a player's hand for a game
    //@return - returns true if hand has a Pair, returns false otherwise
    private static boolean isPair(Card[] playersHand){
        if(playersHand.length != 3){
            return false;
        }
        sortRank(playersHand);
        if(playersHand[0].getRank() == playersHand[1].getRank() && playersHand[1].getRank() != playersHand[2].getRank()){
            return true;
        }else if(playersHand[0].getRank() == playersHand[2].getRank() && playersHand[2].getRank() != playersHand[1].getRank()){
            return true;
        }else if(playersHand[2].getRank() == playersHand[1].getRank() && playersHand[1].getRank() != playersHand[0].getRank()){
            return true;
        }
        return false;
    }

    //Decision tree: decides what type of hand a player has
    //@param playersHand - an array of cards that constitutes a player's hand for a game
    //@return - the ranking of a hand as a int
    public static int valueOfHand(Card[] playersHand){
        if (isFlush(playersHand) && isStraight(playersHand)){
            return STRAIGHT_FLUSH + valueOfHighCard(playersHand);
        } else if (isThreeOfAKind(playersHand)){
            return THREE_OF_A_KIND + valueOfHighCard(playersHand);
        } else if (isStraight(playersHand)){
            return STRAIGHT + valueOfHighCard(playersHand);
        } else if (isFlush(playersHand)){
            return FLUSH + valueOfHighCard(playersHand);
        } else if (isPair(playersHand)){
            return PAIRS + valueOfHighCard(playersHand);
        }else{
            return valueOfHighCard(playersHand);
        }
    }
}

