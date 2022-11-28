package com.lyf.Blackjack.role.user;

import com.lyf.Blackjack.cards.Card;
import com.lyf.Blackjack.clone.Clone;
import com.lyf.Blackjack.role.Role;
import com.lyf.Blackjack.role.ai.AI;
import com.lyf.Blackjack.role.ai.EasyAI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 15:38
 * @Descript:
 */
public class User extends Role {
    private static User user;
    private User(AI ai) {
        super();
        this.ai = ai;
        this.ai.user = this;
    }

    public List<Card> peekAI(){
        List<Card> cards = new ArrayList<>();
        cards.add(ai.getHandCards().get(0));
        cards.add(ai.getHandCards().get(1));
        return cards;
    }

    public static User getInstall(AI ai){
        if(user == null){
            synchronized (User.class){
                if(user == null){
                    user =new User(ai);
                }
            }
        }
        return user;
    }

    public static User getInstall(){
        if(user == null){
            System.out.println("默认使用EasyAI!");
            return getInstall(new EasyAI());
        }
        return user;
    }

    @Override
    public void aiFail(){
        System.out.println("用户胜利，AI失败了！");
        this.ai.aiFail();
    }

    @Override
    public void userFail() {
        System.out.println("用户失败了，AI胜利！");
        this.ai.userFail();
    }

    @Override
    public void draw() {
        System.out.println("平局");
        this.ai.draw();
    }

    @Override
    public void end() {
        int sumA = user.getSumA();
        if (sumA != 0){
            System.out.println("您抽到了" + sumA + "张A,请选择将A视为1点的个数");
            int i = new Scanner(System.in).nextInt();
            if(i <= sumA && i > 0){
                user.setPoint(user.getPoint() - (i * 10));
            }
        }
    }

    @Override
    public Clone copy(Clone clone){
        clone.userHandCards = Clone.deepCopy(this.handCards);
        clone.userPoint = this.getPoint();
        clone.userSumA = this.getSumA();
        return clone;
    }
    @Override
    public void rollBack(Clone clone){
        this.handCards = Clone.deepCopy(clone.userHandCards);
        this.setPoint(clone.userPoint);
        this.setSumA(clone.userSumA);
    }

}
