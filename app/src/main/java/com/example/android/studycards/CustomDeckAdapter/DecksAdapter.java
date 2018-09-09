package com.example.android.studycards.CustomDeckAdapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.studycards.R;

import java.util.ArrayList;


public class DecksAdapter extends ArrayAdapter<Deck> {

    private ArrayList<Deck> decks;
    private Context mContext;

    public DecksAdapter(Context context, ArrayList<Deck> decks) {
        super(context, 0, decks);
        this.mContext = context;
        this.decks = decks;
    }

    @Override
    public Deck getItem(int pos) {
        return decks.get(pos);
    }


    // USING VIEWHOLDER DESIGN PATTERN
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        DecksViewHolder decksViewHolder;
        View view = convertView;

        // Retrieving data item for this position
        Deck deck = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            LayoutInflater layoutInflater = ((Activity) mContext).getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.main_decks_item_layout, parent, false);

            decksViewHolder = new DecksViewHolder(convertView);
            decksViewHolder.deckNameTV = convertView.findViewById(R.id.tvName);
            decksViewHolder.numCardsTV = convertView.findViewById(R.id.tvNumCards);
            decksViewHolder.deckIcon = convertView.findViewById(R.id.ivUserIcon);
            convertView.setTag(decksViewHolder);

        } else {
            decksViewHolder = (DecksViewHolder) convertView.getTag();
        }

        // assign values if the object is != null
        if (deck != null) {
            decksViewHolder.deckNameTV.setText(deck.name);
            decksViewHolder.numCardsTV.setText(String.valueOf(deck.numCards));
        }

        return convertView;
    }

    static class DecksViewHolder {
        private TextView deckNameTV;
        private TextView numCardsTV;
        private ImageView deckIcon;
        public TextView textViewItem;

        public DecksViewHolder(View base) {
            textViewItem = base.findViewById(R.id.listTV);
        }
    }


    // WITHOUT VIEWHOLDER DESIGN PATTERN
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        DecksViewHolder decksViewHolder;
//
//        // Retrieving data item for this position
//        Deck deck = getItem(position);
//
//        // Check if an existing view is being reused, otherwise inflate the view
//        if (convertView == null) {
//            convertView = LayoutInflater.from
//                    (getContext()).inflate(R.layout.main_decks_item_layout, parent, false);
//
//        }
//
//        TextView nameTV = convertView.findViewById(R.id.tvName);
//        TextView numCardsTV = convertView.findViewById(R.id.tvNumCards);
//
//        if (deck != null) {
//            nameTV.setText(deck.name);
//        }
//        numCardsTV.setText(String.valueOf(deck.numCards));
//        return convertView;
//    }
}
