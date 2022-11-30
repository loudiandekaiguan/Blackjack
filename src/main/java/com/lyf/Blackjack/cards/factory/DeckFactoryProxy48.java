package com.lyf.Blackjack.cards.factory;

import com.lyf.Blackjack.cards.Deck48;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 14:12
 * @Descript:
 */
public class DeckFactoryProxy48 implements DeckFactory48 {
    DeckFactory48 deckFactory = new DeckFactoryImpl48();
    @Override
    public Deck48 getDeck() {
        System.out.println("------正在洗牌中,请稍等------");
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Deck48 deck = deckFactory.getDeck();
        System.out.println("------已完成洗牌,开始游戏------");
        return deck;
    }
}
