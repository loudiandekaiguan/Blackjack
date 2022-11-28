package com.lyf.Blackjack.role.ai;

import com.lyf.Blackjack.cards.Deck;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 15:39
 * @Descript:
 */
public class DifficultyAI extends AI{

    public DifficultyAI() {
        super();
    }

    @Override
    public void drawCard() {
        if(super.getPoint() < 15){
            super.drawCard();
        }
    }
}
