package com.lyf.Blackjack.server;

import com.lyf.Blackjack.role.Role;
import com.lyf.Blackjack.role.ai.AI;
import com.lyf.Blackjack.role.ai.EasyAI;
import com.lyf.Blackjack.role.user.User;

import java.util.Scanner;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 17:11
 * @Descript:
 */
public class Start extends Template{


    @Override
    protected void play() {
        User user = User.getInstall();
        AI ai = user.getAi();
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
                    System.out.print( ai.getClass().getSimpleName() + "底牌为：" + user.peekAI().get(0));
                    System.out.println(user.peekAI().get(1));
                    break;
                case 4:
                    super.rollBack();
                    user.show();
                    System.out.print("    " + ai.getClass().getSimpleName() + ":");
                    ai.show();
                    System.out.println();
            }
        }


    }
}
