package com.lyf.Blackjack.cards;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/26 13:28
 * @Descript:
 */
public enum CardRank48 {
    Ace("A", 11),Two("2", 2),Three("3", 3),Four("4", 4),Five("5",5),
    Six("6", 6), Seven("7", 7),Eight("8", 8),Nine("9", 9),Ten("10", 10),
    Jack("J", 10),Queen("Q", 10),King("K", 10);
    CardRank48(String Num, int point) {
        this.Num=Num;
        this.point = point;
    }
    private String Num;
    private int point;
    public String getNum(){
        return Num;
    }

    public int getPoint(){
        return point;
    }
}
