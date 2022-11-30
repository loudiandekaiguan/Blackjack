package com.lyf.Blackjack.role;

import com.lyf.Blackjack.cards.Card48;
import com.lyf.Blackjack.cards.Deck48;
import com.lyf.Blackjack.cards.factory.DeckFactoryProxy48;
import com.lyf.Blackjack.clone.Clone48;
import com.lyf.Blackjack.role.ai.AI48;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 14:20
 * @Descript:
 */
public abstract class Role48 {
    protected static Deck48 deck;
    private int point;
    private int sumA;
    protected List<Card48> handCards = new ArrayList<>();
    protected AI48 ai;

    protected Role48(){

    }

    public void drawCard(){
        Card48 card = deck.drawOneCard();
        point += card.getPoint();
        if(card.getPoint() == 11){
            sumA++;
        }
        this.handCards.add(card);
    }

    public abstract void aiFail();
    public abstract void userFail();
    public abstract void draw(); //平局

    public void newDeck(){
        deck = new DeckFactoryProxy48().getDeck();
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getSumA() {
        return sumA;
    }

    public void setSumA(int sumA) {
        this.sumA = sumA;
    }

    public List<Card48> getHandCards(){
        return handCards;
    }

    public AI48 getAi(){
        return ai;
    }
    public void show() {
        for (Card48 handCard : handCards) {
            System.out.print(handCard);
        }
    }

    public abstract void end();
    public abstract Clone48 copy(Clone48 clone);

    public abstract void rollBack(Clone48 clone);

}
