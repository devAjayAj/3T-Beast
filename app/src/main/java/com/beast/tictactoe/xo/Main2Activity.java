package com.beast.tictactoe.xo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main2Activity extends AppCompatActivity {
    CardView s;
    int player = 1;
    int[] nine = new int[81];
    int[] three = new int[9];
    int imageViewIds[] = {
            R.id.nineb1, R.id.nineb2, R.id.nineb3, R.id.nineb4, R.id.nineb5, R.id.nineb6, R.id.nineb7, R.id.nineb8, R.id.nineb9
            , R.id.nineb10, R.id.nineb11, R.id.nineb12, R.id.nineb13, R.id.nineb14, R.id.nineb15, R.id.nineb16, R.id.nineb17, R.id.nineb18
            , R.id.nineb19, R.id.nineb20, R.id.nineb21, R.id.nineb22, R.id.nineb23, R.id.nineb24, R.id.nineb25, R.id.nineb26, R.id.nineb27
            , R.id.nineb28, R.id.nineb29, R.id.nineb30, R.id.nineb31, R.id.nineb32, R.id.nineb33, R.id.nineb34, R.id.nineb35, R.id.nineb36
            , R.id.nineb37, R.id.nineb38, R.id.nineb39, R.id.nineb40, R.id.nineb41, R.id.nineb42, R.id.nineb43, R.id.nineb44, R.id.nineb45
            , R.id.nineb46, R.id.nineb47, R.id.nineb48, R.id.nineb49, R.id.nineb50, R.id.nineb51, R.id.nineb52, R.id.nineb53, R.id.nineb54
            , R.id.nineb55, R.id.nineb56, R.id.nineb57, R.id.nineb58, R.id.nineb59, R.id.nineb60, R.id.nineb61, R.id.nineb62, R.id.nineb63
            , R.id.nineb64, R.id.nineb65, R.id.nineb66, R.id.nineb67, R.id.nineb68, R.id.nineb69, R.id.nineb70, R.id.nineb71, R.id.nineb72
            , R.id.nineb73, R.id.nineb74, R.id.nineb75, R.id.nineb76, R.id.nineb77, R.id.nineb78, R.id.nineb79, R.id.nineb80, R.id.nineb81
    };
    int[] bigImageViewIds = {
            R.id.nineBig0, R.id.nineBig1, R.id.nineBig2, R.id.nineBig3, R.id.nineBig4, R.id.nineBig5, R.id.nineBig6, R.id.nineBig7, R.id.nineBig8
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        s = (CardView) findViewById(R.id.nineParent);
        s.post(new Runnable() {
            @Override
            public void run() {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(s.getMeasuredWidth(), s.getMeasuredWidth());
                params.setMargins(dpToPx(8), dpToPx(8), dpToPx(8), dpToPx(8));
                s.setLayoutParams(params);
            }
        });

    }

    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public void id(View v) {
        String idName = v.getResources().getResourceEntryName(v.getId());
        String idNum = idName.replaceAll("[^0-9]", "");
        int place = Integer.parseInt(idNum);
        place--;
        if(player == 1){
            player = 0;
            place = 35;
            ImageView temp = (ImageView) findViewById(imageViewIds[place]);
            temp.setImageResource(R.drawable.x);
        }
        sendId(idNum);
    }

    public void sendId(String idNumber) {

    }
}
