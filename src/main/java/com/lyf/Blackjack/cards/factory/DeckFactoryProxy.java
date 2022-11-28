package com.lyf.Blackjack.cards.factory;

import com.lyf.Blackjack.cards.Deck;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 14:12
 * @Descript:
 */
public class DeckFactoryProxy implements DeckFactory{
    DeckFactory deckFactory = new DeckFactoryImpl();
    @Override
    public Deck getDeck() {
        System.out.println("------正在洗牌中,请稍等------");
        Deck deck = deckFactory.getDeck();
        System.out.println("------已完成洗牌,开始游戏------");
        return deck;
    }
}
