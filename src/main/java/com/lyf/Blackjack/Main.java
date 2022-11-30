package com.lyf.Blackjack;

import com.lyf.Blackjack.role.ai.DifficultyAI48;
import com.lyf.Blackjack.role.ai.EasyAI48;
import com.lyf.Blackjack.server.Start48;

import java.util.Scanner;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/28 14:12
 * @Descript:
 */
public class Main {
    public static void main(String[] args) {
        Start48 start = new Start48();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择你的难度。（1简单，2困难）");
        String s = scanner.nextLine();
        if("2".equals(s)){
            start.startGame(new DifficultyAI48());
        } else if ("1".equals(s)) {
            start.startGame(new EasyAI48());
        }else {
            System.out.println("输入错误，默认简单AI");
            start.startGame(new EasyAI48());
        }

    }
}
