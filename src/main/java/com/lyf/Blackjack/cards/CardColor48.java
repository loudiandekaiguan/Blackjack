package com.lyf.Blackjack.cards;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 13:30
 * @Descript:
 */
public enum CardColor48 {
    Heart("\u2663"),Diamond("\u2666"),Club("\u2665"),Black("\u2660");
    CardColor48(String Color) {
        this.Color=Color;
    }
    private String Color;
    public String getColor() {
        return Color;
    }
}
