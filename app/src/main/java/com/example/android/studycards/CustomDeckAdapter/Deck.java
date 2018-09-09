package com.example.android.studycards.CustomDeckAdapter;

import android.graphics.Bitmap;

import com.example.android.studycards.R;

import java.util.Objects;

public class Deck {

    public String name;
    public Integer numCards;
    public Integer deckNum;

    public Deck(String name, Integer numCards) {
        this.name = name;
        this.numCards = numCards;
        deckNum = 0;
    }

    //retrieve deck's name
    public String getName(){
        return name;
    }

    //retrieve deck's numCards
    public Integer getNumCards(){
        return numCards;
    }

    public void setDeckNum (Integer deckNum) {
        this.deckNum = deckNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return Objects.equals(deckNum, deck.deckNum);
    }

    @Override
    public int hashCode() {

        return Objects.hash(deckNum);
    }
}
