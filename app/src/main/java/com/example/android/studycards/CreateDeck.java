package com.example.android.studycards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateDeck extends AppCompatActivity implements View.OnClickListener {

    private final int cardRadius = 20;
    private Button cancelBtn;
    private Button createBtn;
    public static String deckNameStaticString;

    // public static Deck deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_deck);

        Toolbar toolbar = findViewById(R.id.create_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        CardView deckCard = findViewById(R.id.createDeckCard);
        deckCard.setRadius(cardRadius);

        // assigning buttons to variable names
        cancelBtn = findViewById(R.id.cancelBtn);
        createBtn = findViewById(R.id.createDeckBtn);

        // setting OnClickListeners
        cancelBtn.setOnClickListener(this);
        createBtn.setOnClickListener(this);

        deckNameObserver();
    }


    private void deckNameObserver() {
        final EditText deckNameET = findViewById(R.id.deckName);
        deckNameET.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!deckNameET.getText().toString().equals("")) {
                    createBtn.setAlpha(1.0f);
                } else {
                    createBtn.setAlpha(0.5f);
                }
            }
        });
    }


    // EFFECTS: when new activity opens (only possible through clicking createBtn),
    //          set the color of createBtn to 1.0f, that way, when back button pressed
    //          createBtn will still be solid, b/c there's still text in deckName
    @Override
    protected void onPause() {
        super.onPause();
        createBtn.setAlpha(1.0f);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.cancelBtn:
                cancelBtn.setAlpha(0.5f);
                Intent cancelIntent = new Intent(this, MainActivity.class);
                startActivity(cancelIntent);
                break;

            case R.id.createDeckBtn:
                EditText deckNameET = findViewById(R.id.deckName);
                String deckNameString = deckNameET.getText().toString();


                if (!deckNameString.equals("")) {
                    deckNameStaticString = deckNameString;
//                    deck = new Deck(deckNameString, 0);
//                    deck.setName(deckNameString);

                    // deck = new Deck(deckNameStaticString, 0);


                    createBtn.setAlpha(0.5f);
                    Intent createIntent = new Intent(this, CreateCard.class);
                    startActivity(createIntent);
                    break;
                } else {
                    Toast.makeText(this,
                            "A name must be included for the deck", Toast.LENGTH_SHORT).show();
                    break;
                }

            default:
                break;
        }
    }

//    private static void buttonEffect(final View button){
//        button.setOnTouchListener(new View.OnTouchListener() {
//
//            public boolean onTouch(View v, MotionEvent event) {
//
//                switch (event.getAction()) {
//                    // When the user clicks the Button
//                    case MotionEvent.ACTION_DOWN:
//                        v.setAlpha(0.5f);
//                        break;
//
//                    // When the user releases the Button
//                    case MotionEvent.ACTION_UP:
//                        v.setAlpha(1.0f);
//                        break;
//                }
//                return false;
//            }
//        });
//    }

}
