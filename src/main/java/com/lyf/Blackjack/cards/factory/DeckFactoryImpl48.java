package com.lyf.Blackjack.cards.factory;

import com.lyf.Blackjack.cards.Deck48;
import com.lyf.Blackjack.cards.DeckImpl48;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 14:03
 * @Descript:
 */
public class DeckFactoryImpl48 implements DeckFactory48 {
    public Deck48 getDeck(){
        return new DeckImpl48();
    }
}
