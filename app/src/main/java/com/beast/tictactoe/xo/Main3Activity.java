package com.beast.tictactoe.xo;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main3Activity extends AppCompatActivity {

    int[] ninePlaces = {
            2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2,
    };
    int[] threePlaces = {
            2, 2, 2, 2, 2, 2, 2, 2, 2
    };
    int player = 1;
    int smallImageViewIds[] = {
            R.id.nineb0, R.id.nineb1, R.id.nineb2, R.id.nineb3, R.id.nineb4, R.id.nineb5, R.id.nineb6, R.id.nineb7, R.id.nineb8, R.id.nineb9
            , R.id.nineb10, R.id.nineb11, R.id.nineb12, R.id.nineb13, R.id.nineb14, R.id.nineb15, R.id.nineb16, R.id.nineb17, R.id.nineb18
            , R.id.nineb19, R.id.nineb20, R.id.nineb21, R.id.nineb22, R.id.nineb23, R.id.nineb24, R.id.nineb25, R.id.nineb26, R.id.nineb27
            , R.id.nineb28, R.id.nineb29, R.id.nineb30, R.id.nineb31, R.id.nineb32, R.id.nineb33, R.id.nineb34, R.id.nineb35, R.id.nineb36
            , R.id.nineb37, R.id.nineb38, R.id.nineb39, R.id.nineb40, R.id.nineb41, R.id.nineb42, R.id.nineb43, R.id.nineb44, R.id.nineb45
            , R.id.nineb46, R.id.nineb47, R.id.nineb48, R.id.nineb49, R.id.nineb50, R.id.nineb51, R.id.nineb52, R.id.nineb53, R.id.nineb54
            , R.id.nineb55, R.id.nineb56, R.id.nineb57, R.id.nineb58, R.id.nineb59, R.id.nineb60, R.id.nineb61, R.id.nineb62, R.id.nineb63
            , R.id.nineb64, R.id.nineb65, R.id.nineb66, R.id.nineb67, R.id.nineb68, R.id.nineb69, R.id.nineb70, R.id.nineb71, R.id.nineb72
            , R.id.nineb73, R.id.nineb74, R.id.nineb75, R.id.nineb76, R.id.nineb77, R.id.nineb78, R.id.nineb79, R.id.nineb80
    };

    int[] bigImageViewIds = {
            R.id.nineBig0, R.id.nineBig1, R.id.nineBig2, R.id.nineBig3, R.id.nineBig4, R.id.nineBig5, R.id.nineBig6, R.id.nineBig7, R.id.nineBig8
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        for (int i = 0; i < 9; i++) {
                LinearLayout temp = (LinearLayout) findViewById(bigImageViewIds[i]);
                temp.setVisibility(View.VISIBLE);
        }
    }

    public void onclick(View v) {
        String idName = v.getResources().getResourceEntryName(v.getId());
        String a = idName.replaceAll("[^0-9]", "");
        int idNum = Integer.parseInt(a);
        ImageView temp = (ImageView) findViewById(smallImageViewIds[idNum]);
        if (player == 0) {
            temp.setImageResource(R.drawable.o);
            temp.setClickable(false);
            player = 1;
            ninePlaces[idNum] = 0;
        } else if (player == 1) {
            temp.setImageResource(R.drawable.x);
            temp.setClickable(false);
            player = 0;
            ninePlaces[idNum] = 1;
        }
    }

    public void onclickBig(View v) {
        String idName = v.getResources().getResourceEntryName(v.getId());
        String a = idName.replaceAll("[^0-9]", "");
        int bigIdNum = Integer.parseInt(a);
        int smallBlocker = bigIdNum * 9;
        for (int i = 1; i < 2; i++) {
            LinearLayout temp = (LinearLayout) findViewById(bigImageViewIds[i]);
            temp.setVisibility(View.INVISIBLE);
        }
        /*//Block all
        for (int i = 0; i < smallBlocker; i++) {
            ImageView temp = (ImageView) findViewById(smallImageViewIds[i]);
            temp.setClickable(false);
        }
        for (int i = smallBlocker + 9; i < 81; i++) {
            ImageView temp = (ImageView) findViewById(smallImageViewIds[i]);
            temp.setClickable(false);
        }
        //unblock selected bigCell
        for (int i = smallBlocker; i < smallBlocker + 9; i++) {
            if (ninePlaces[i] == 2) {
                ImageView temp = (ImageView) findViewById(smallImageViewIds[i]);
                temp.setClickable(true);
                if(player == 1) {
                    temp.setImageDrawable(null);
                    temp.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.xclr));
                }
                else if(player == 0){
                    temp.setImageDrawable(null);
                    temp.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.oclr));
                }
            }


        }*/
    }

    public void openChoice() {

    }
}
