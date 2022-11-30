package com.lyf.Blackjack.role.ai;

import com.lyf.Blackjack.clone.Clone48;
import com.lyf.Blackjack.role.Role48;
import com.lyf.Blackjack.role.user.User48;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 16:45
 * @Descript:
 */
public abstract class AI48 extends Role48 {
    public User48 user;
    protected AI48() {
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
        System.out.print("? ");
        for (int i = 1; i < handCards.size(); i++){
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
    public Clone48 copy(Clone48 clone){
        clone.AIHandCards = Clone48.deepCopy(this.handCards);
        clone.AIPoint = this.getPoint();
        clone.AISumA = this.getSumA();
        return clone;
    }
    @Override
    public void rollBack(Clone48 clone){
        this.handCards = Clone48.deepCopy(clone.AIHandCards);
        this.setPoint(clone.AIPoint);
        this.setSumA(clone.AISumA);
    }

}
