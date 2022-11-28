package com.lyf.Blackjack.cards;

import java.io.Serializable;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 13:32
 * @Descript:
 */
public class Card implements Serializable {
    private String flower;
    private String num;
    private int point;

    public Card(){}
    public Card(String flower,String num, int point) {
        this.flower=flower;
        this.num=num;
        this.point = point;
    }
    public String getFlower() {
        return flower;
    }
    public void setFlower(String flower) {
        this.flower=flower;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num=num;
    }
    public int getPoint(){return point;}
    public void setPoint(int point){this.point = point;}
    public String toString() {
        return flower + num;
    }
}
