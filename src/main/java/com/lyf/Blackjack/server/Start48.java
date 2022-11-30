package com.lyf.Blackjack.server;

import com.lyf.Blackjack.role.ai.AI48;
import com.lyf.Blackjack.role.user.User48;

import java.util.Scanner;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 17:11
 * @Descript:
 */
public class Start48 extends Template48 {
    @Override
    protected void play() {
        User48 user = User48.getInstall();
        AI48 ai = user.getAi();
        Scanner scanner = new Scanner(System.in);
        int i;
        boolean flag = true;
        while(flag){
            System.out.println("输入1摸牌，输入2结束，输入3偷看底牌，输入4反悔一次");
            i = scanner.nextInt();
            switch (i){
                case 1:
                    super.myClone();
                    user.drawCard();
                    ai.drawCard();
                    System.out.print("user:");
                    user.show();
                    System.out.print("    " + ai.getClass().getSimpleName() + ":");
                    ai.show();
                    System.out.println();
                    break;
                case 2:
                    flag = false;
                    break;
                case 3:
                    System.out.println( ai.getClass().getSimpleName() + "底牌为：" + user.peekAI().get(0));
                    break;
                case 4:
                    super.rollBack();
                    System.out.print("user:");
                    user.show();
                    System.out.print("    " + ai.getClass().getSimpleName() + ":");
                    ai.show();
                    System.out.println();
            }
        }
    }
}
