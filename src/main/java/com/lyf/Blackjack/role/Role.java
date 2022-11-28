package com.lyf.Blackjack.role;

import com.lyf.Blackjack.cards.Card;
import com.lyf.Blackjack.cards.Deck;
import com.lyf.Blackjack.cards.factory.DeckFactoryProxy;
import com.lyf.Blackjack.clone.Clone;
import com.lyf.Blackjack.role.ai.AI;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 14:20
 * @Descript:
 */
public abstract class Role {
    protected static Deck deck;
    private int point;
    private int sumA;
    protected List<Card> handCards = new ArrayList<>();
    protected AI ai;

    protected Role(){

    }

    public void drawCard(){
        Card card = deck.drawOneCard();
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
        deck = new DeckFactoryProxy().getDeck();
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

    public List<Card> getHandCards(){
        return handCards;
    }

    public void setHandCards(List<Card> handCards) {
        this.handCards = handCards;
    }
    public AI getAi(){
        return ai;
    }


    public void show() {
        for (Card handCard : handCards) {
            System.out.print(handCard);
        }
    }

    public abstract void end();
    public abstract Clone copy(Clone clone);

    public abstract void rollBack(Clone clone);

}
