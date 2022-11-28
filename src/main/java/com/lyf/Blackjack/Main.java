package com.lyf.Blackjack;

import com.lyf.Blackjack.clone.Clone;
import com.lyf.Blackjack.role.ai.DifficultyAI;
import com.lyf.Blackjack.role.ai.EasyAI;
import com.lyf.Blackjack.role.user.User;
import com.lyf.Blackjack.server.Start;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/28 14:12
 * @Descript:
 */
public class Main {
    public static void main(String[] args) {
        Start start = new Start();
        start.startGame(new DifficultyAI());
    }
}
