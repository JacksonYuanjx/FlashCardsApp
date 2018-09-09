package com.example.android.studycards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.studycards.CustomDeckAdapter.Deck;

import static com.example.android.studycards.CreateDeck.deckNameStaticString;


public class CreateCard extends AppCompatActivity implements View.OnClickListener {

    private final int cardRadius = 20;
    private Button doneBtn;
    private Button createCardBtn;

    public static Integer numCardsStaticInteger;
    public static Deck deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_card);

        numCardsStaticInteger = 0;

        Toolbar toolbar = findViewById(R.id.create_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        CardView card = findViewById(R.id.createDeckCard);
        card.setRadius(cardRadius);

        // assigning buttons to variable names
        doneBtn = findViewById(R.id.doneBtn);
        createCardBtn = findViewById(R.id.createCardBtn);

        // setting OnClickListeners
        doneBtn.setOnClickListener(this);
        createCardBtn.setOnClickListener(this);


//        EditText cardFrontEditText = findViewById(R.id.cardFront);
//        cardFrontEditText.setFocusableInTouchMode(true);
//        cardFrontEditText.requestFocus();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.doneBtn:
                doneBtn.setAlpha(0.5f);
                Intent doneIntent = new Intent(this, MainActivity.class);

                EditText cardFrontET = findViewById(R.id.cardFrontET);
                EditText cardBackET = findViewById(R.id.cardBackET);
                String cardFrontString = cardFrontET.getText().toString();
                String cardBackString = cardBackET.getText().toString();

                if (!cardFrontString.equals("") && !cardBackString.equals("")) {
                    numCardsStaticInteger++;
                }

                deck = new Deck(deckNameStaticString, numCardsStaticInteger);
                startActivity(doneIntent);
                break;

            case R.id.createCardBtn:
                createCardBtn.setAlpha(0.5f);
                // deck.numCards++;
                break;
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        doneBtn.setAlpha(1.0f);
        moveTaskToBack(true);
    }

}
