package com.lyf.Blackjack;

import com.lyf.Blackjack.role.ai.DifficultyAI48;
import com.lyf.Blackjack.role.ai.EasyAI48;
import com.lyf.Blackjack.server.Start48;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/28 14:12
 * @Descript:
 */
public class Main {
    public static void main(String[] args) {
        Start48 start = new Start48();
        start.startGame(new EasyAI48());
    }
}
