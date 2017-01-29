package com.beast.tictactoe.xo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Beast extends AppCompatActivity {

    private CardView cv, yb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beast);

        cv = (CardView) findViewById(R.id.xh);
        yb = (CardView) findViewById(R.id.yb);

        cv.post(new Runnable() {
            @Override
            public void run() {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(cv.getMeasuredWidth(), cv.getMeasuredWidth());
                params.setMargins(dpToPx(8), dpToPx(8), dpToPx(8), dpToPx(8));
                cv.setLayoutParams(params);
                RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(
                        (int) (yb.getMeasuredWidth() / 1.7), (int) (yb.getMeasuredWidth() / 1.7));
                param.setMargins(dpToPx(8), dpToPx(8), dpToPx(8), dpToPx(8));
                param.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                yb.setLayoutParams(param);
            }
        });
    }

    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
