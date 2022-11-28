package com.lyf.Blackjack.server;

import com.lyf.Blackjack.clone.Clone;
import com.lyf.Blackjack.role.Role;
import com.lyf.Blackjack.role.ai.AI;
import com.lyf.Blackjack.role.ai.DifficultyAI;
import com.lyf.Blackjack.role.ai.EasyAI;
import com.lyf.Blackjack.role.user.User;

import java.util.Scanner;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/28 13:40
 * @Descript:
 */
public abstract class Template {
    Clone clone = new Clone();
    protected void before(AI ai){
        Role install = User.getInstall(ai);
//        AI ai = install.getAi();
        install.newDeck();
        install.drawCard();
        install.drawCard();
        ai.drawCard();
        ai.drawCard();
        System.out.print("user:");
        install.show();
        System.out.print("     ");
        System.out.print(ai.getClass().getSimpleName() + ":");
        System.out.println("? ?");
    }
    public void startGame(AI ai){
        this.before(ai);
        this.play();
        this.after();
    }
    protected abstract void play();

    protected void after(){
        User user = User.getInstall();
        AI ai = user.getAi();
        user.end();
        ai.end();
        System.out.print("user的点数为：" + user.getPoint());
        System.out.println("    " + ai.getClass().getSimpleName() + "的点数为：" + ai.getPoint());
        if((user.getPoint() > 21 && ai.getPoint() > 21) || user.getPoint() == ai.getPoint()){
            user.draw();
        }else if(user.getPoint() > 21){
            user.userFail();
        }else if(ai.getPoint() > 21){
            user.aiFail();
        }else if(ai.getPoint() > user.getPoint()){
            user.userFail();
        }else{
            user.aiFail();
        }
    }
    protected void myClone(){
        User user = User.getInstall();
        AI ai = user.getAi();
        clone = user.copy(clone);
        clone = ai.copy(clone);
    }
    protected void rollBack(){
        User user = User.getInstall();
        AI ai = user.getAi();
        user.rollBack(clone);
        ai.rollBack(clone);
    }

}
