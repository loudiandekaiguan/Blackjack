package com.lyf.Blackjack.clone;

import com.lyf.Blackjack.cards.Card48;
import com.lyf.Blackjack.cards.Deck48;

import java.io.*;
import java.util.List;

/**
 * @Author: 刘宇帆
 * @Time: 2022/11/28 15:18
 * @Descript:
 */
public class Clone48 {
    public Deck48 deck;
    public int userPoint;
    public int userSumA;
    public List<Card48> userHandCards;
    public int AIPoint;
    public int AISumA;
    public List<Card48> AIHandCards;

    public static <T> List<T> deepCopy(List<T> src) {
        try{
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            @SuppressWarnings("unchecked")
            List<T> dest = (List<T>) in.readObject();
            return dest;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
