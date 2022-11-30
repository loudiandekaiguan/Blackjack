package com.lyf.Blackjack.cards;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 13:33
 * @Descript:
 */
public class DeckImpl48 implements Deck48 {
    private final List<Card48> cards = new ArrayList<>(); //一副牌
    public DeckImpl48() {
        for (CardRank48 rank : EnumSet.range(CardRank48.Ace, CardRank48.King)) {
            for (CardColor48 color : EnumSet.range(CardColor48.Heart, CardColor48.Black)) {
                Card48 card = new Card48();
                card.setFlower(color.getColor());
                card.setNum(rank.getNum());
                card.setPoint(rank.getPoint());
                cards.add(card);
            }
        }
    }


    @Override
    public Card48 drawOneCard() {
        Random random = new Random();
        if(cards.size() != 0){
            int i = random.nextInt(cards.size());
            return cards.remove(i);
        }
        return null;
    }
}
