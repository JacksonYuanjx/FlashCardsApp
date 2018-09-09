package com.example.android.studycards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.android.studycards.CustomDeckAdapter.Deck;
import com.example.android.studycards.CustomDeckAdapter.DecksAdapter;
import com.example.android.studycards.exceptions.ExcessiveBackBtnPressedOnStartException;

import java.util.ArrayList;

import static com.example.android.studycards.CreateCard.deck;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button createDeckBtn;

    // Decks data source
    public static ArrayList<Deck> decks = new ArrayList<>();
    private static Integer deckNum = 0;

    ListView decksListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assigning buttons to variable names
        createDeckBtn = findViewById(R.id.createDeckMainBtn);

        // setting OnClickListeners
        createDeckBtn.setOnClickListener(this);

        populateDecksList();

    }

    private void populateDecksList() {

        if (deck != null) {
            deck.setDeckNum(deckNum);
            if (!decks.contains(deck)) {
                decks.add(deck);
                Log.i("MainActivity", "populateDecksList called");
            }
            deckNum++;
        }

        DecksAdapter adapter = new DecksAdapter(this, decks);
        decksListView = findViewById(R.id.decksListView);
        decksListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try {
            deckNum--;
            if (deckNum <= -1) {
                throw new ExcessiveBackBtnPressedOnStartException();
            }
        } catch (ExcessiveBackBtnPressedOnStartException e) {
            deckNum = 0;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.createDeckMainBtn:
                Intent createDeckIntent = new Intent(this, CreateDeck.class);
                startActivity(createDeckIntent);
                break;
            default:
                break;
        }
    }

}
