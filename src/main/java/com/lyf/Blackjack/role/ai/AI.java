package com.lyf.Blackjack.role.ai;

import com.lyf.Blackjack.cards.Card;
import com.lyf.Blackjack.cards.Deck;
import com.lyf.Blackjack.clone.Clone;
import com.lyf.Blackjack.role.Role;
import com.lyf.Blackjack.role.user.User;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 16:45
 * @Descript:
 */
public abstract class AI extends Role {

    public User user;
    protected AI() {
        super();
        System.out.println("您选择了" + this.getClass().getSimpleName());
    }
    @Override
    public void aiFail(){
        System.out.println(this.getClass().getSimpleName() + ":收到,我失败了");
    }

    @Override
    public void userFail() {
        System.out.println(this.getClass().getSimpleName() + ":收到,我胜利了");
    }
    @Override
    public void draw() {
        System.out.println(this.getClass().getSimpleName() + ":收到,平局");
    }
    @Override
    public void show() {
        System.out.print("? ?");
        for (int i = 2; i < handCards.size(); i++){
            System.out.print(handCards.get(i));
        }
    }

    @Override
    public void end(){
        if(super.getSumA() == 0){
            return;
        }
        for (int i = 1; i <= super.getSumA(); i++) {
            if(super.getPoint() > 21){
                super.setPoint(super.getPoint() - 10);
            }
        }
    }
    @Override
    public Clone copy(Clone clone){
        clone.AIHandCards = Clone.deepCopy(this.handCards);
        clone.AIPoint = this.getPoint();
        clone.AISumA = this.getSumA();
        return clone;
    }
    @Override
    public void rollBack(Clone clone){
        this.handCards = Clone.deepCopy(clone.AIHandCards);
        this.setPoint(clone.AIPoint);
        this.setSumA(clone.AISumA);
    }

}
