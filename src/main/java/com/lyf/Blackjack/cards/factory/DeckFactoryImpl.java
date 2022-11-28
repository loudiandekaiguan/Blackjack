package com.lyf.Blackjack.cards.factory;

import com.lyf.Blackjack.cards.Deck;
import com.lyf.Blackjack.cards.DeckImpl;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 14:03
 * @Descript:
 */
public class DeckFactoryImpl implements DeckFactory{
    public Deck getDeck(){
        return new DeckImpl();
    }
}
