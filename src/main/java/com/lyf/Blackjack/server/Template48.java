package com.lyf.Blackjack.server;

import com.lyf.Blackjack.clone.Clone48;
import com.lyf.Blackjack.role.Role48;
import com.lyf.Blackjack.role.ai.AI48;
import com.lyf.Blackjack.role.ai.DifficultyAI48;
import com.lyf.Blackjack.role.ai.EasyAI48;
import com.lyf.Blackjack.role.user.User48;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/28 13:40
 * @Descript:
 */
public abstract class Template48 {
    Clone48 clone = new Clone48();
    protected void before(AI48 ai){
        Role48 install = User48.getInstall(ai);
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
        ai.show();
        System.out.println();
    }
    public void startGame(AI48 ai){
        this.before(ai);
        this.play();
        this.after();
    }

    protected abstract void play();

    protected void after(){
        User48 user = User48.getInstall();
        AI48 ai = user.getAi();
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
        User48 user = User48.getInstall();
        AI48 ai = user.getAi();
        clone = user.copy(clone);
        clone = ai.copy(clone);
    }
    protected void rollBack(){
        User48 user = User48.getInstall();
        AI48 ai = user.getAi();
        user.rollBack(clone);
        ai.rollBack(clone);
    }

}
