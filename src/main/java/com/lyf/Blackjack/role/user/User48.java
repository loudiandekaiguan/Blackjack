package com.lyf.Blackjack.role.user;

import com.lyf.Blackjack.cards.Card48;
import com.lyf.Blackjack.clone.Clone48;
import com.lyf.Blackjack.role.Role48;
import com.lyf.Blackjack.role.ai.AI48;
import com.lyf.Blackjack.role.ai.EasyAI48;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 15:38
 * @Descript:
 */
public class User48 extends Role48 {
    private static User48 user;
    private User48(AI48 ai) {
        super();
        this.ai = ai;
        this.ai.user = this;
    }

    public List<Card48> peekAI(){
        List<Card48> cards = new ArrayList<>();
        cards.add(ai.getHandCards().get(0));
//        cards.add(ai.getHandCards().get(1));
        return cards;
    }

    public static User48 getInstall(AI48 ai){
        if(user == null){
            synchronized (User48.class){
                if(user == null){
                    user =new User48(ai);
                }
            }
        }
        return user;
    }

    public static User48 getInstall(){
        if(user == null){
            System.out.println("默认使用EasyAI!");
            return getInstall(new EasyAI48());
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
    public Clone48 copy(Clone48 clone){
        clone.userHandCards = Clone48.deepCopy(this.handCards);
        clone.userPoint = this.getPoint();
        clone.userSumA = this.getSumA();
        return clone;
    }
    @Override
    public void rollBack(Clone48 clone){
        this.handCards = Clone48.deepCopy(clone.userHandCards);
        this.setPoint(clone.userPoint);
        this.setSumA(clone.userSumA);
    }

}
