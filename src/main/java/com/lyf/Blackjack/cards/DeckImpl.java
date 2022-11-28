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
public class DeckImpl implements Deck{
    private final List<Card> cards = new ArrayList<>(); //一副牌
    public DeckImpl() {
        for (CardRank rank : EnumSet.range(CardRank.Ace, CardRank.King)) {
            for (CardColor color : EnumSet.range(CardColor.Heart, CardColor.Black)) {
                Card card = new Card();
                card.setFlower(color.getColor());
                card.setNum(rank.getNum());
                card.setPoint(rank.getPoint());
                cards.add(card);
            }
        }
    }


    @Override
    public Card drawOneCard() {
        Random random = new Random();
        if(cards.size() != 0){
            int i = random.nextInt(cards.size());
            return cards.remove(i);
        }
        return null;
    }
}
