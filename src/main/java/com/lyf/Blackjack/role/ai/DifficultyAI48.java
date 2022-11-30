package com.lyf.Blackjack.role.ai;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 15:39
 * @Descript:
 */
public class DifficultyAI48 extends AI48 {

    public DifficultyAI48() {
        super();
    }

    @Override
    public void drawCard() {
        if(super.getPoint() < 15){
            super.drawCard();
        }
    }
}
