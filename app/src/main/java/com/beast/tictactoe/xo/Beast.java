package com.beast.tictactoe.xo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.beast.tictactoe.xo.databinding.ActivityBeastBinding;

public class Beast extends AppCompatActivity implements View.OnClickListener {

    ImageView tnb1, tnb2, tnb3, tnb4, tnb5, tnb6, tnb7, tnb8, tnb9;
    int ctrlVar = 0;
    ActivityBeastBinding beast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ctrlVar = 0;
        super.onCreate(savedInstanceState);
        beast = DataBindingUtil.setContentView(this, R.layout.activity_beast);
        beast.back.setOnClickListener(this);
        beast.pbar.setVisibility(View.INVISIBLE);

        beast.threeParent.post(new Runnable() {
            @Override
            public void run() {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(beast.threeParent.getMeasuredWidth(), beast.threeParent.getMeasuredWidth());
                params.setMargins(dpToPx(8), dpToPx(8), dpToPx(8), dpToPx(8));
                beast.threeParent.setLayoutParams(params);
                RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(
                        (int) (beast.nineParent.getMeasuredWidth() / 1.7), (int) (beast.nineParent.getMeasuredWidth() / 1.7));
                param.setMargins(dpToPx(8), dpToPx(8), dpToPx(8), dpToPx(8));
                param.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                beast.nineParent.setLayoutParams(param);
            }
        });

        beast.threeParent.setVisibility(View.INVISIBLE);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                Beast.this.finish();
                break;
        }
    }

    public void set(ImageView nb1, ImageView nb2, ImageView nb3, ImageView nb4, ImageView nb5, ImageView nb6, ImageView nb7, ImageView nb8, ImageView nb9) {
        tnb1 = nb1;
        tnb2 = nb2;
        tnb3 = nb3;
        tnb4 = nb4;
        tnb5 = nb5;
        tnb6 = nb6;
        tnb7 = nb7;
        tnb8 = nb8;
        tnb9 = nb9;
    }

    public void three(View view) {
        switch (view.getId()) {
            case R.id.threeb1:
                if(ctrlVar % 2 == 0) {
                    beast.threeb1.setBackgroundResource(R.drawable.x);
                    tnb1.setImageResource(R.drawable.x);
                    ctrlVar++;
                    break;
                }
                else{
                    beast.threeb1.setBackgroundResource(R.drawable.o);
                    tnb1.setImageResource(R.drawable.o);
                    ctrlVar++;
                    break;
                }
            case R.id.threeb2:
                if(ctrlVar % 2 == 0) {
                    beast.threeb2.setBackgroundResource(R.drawable.x);
                    tnb2.setImageResource(R.drawable.x);
                    ctrlVar++;
                    beast.nineb.setVisibility(View.VISIBLE);
                    beast.nineb.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.oclr));
                    break;
                }
                else{
                    beast.threeb2.setBackgroundResource(R.drawable.o);
                    tnb2.setImageResource(R.drawable.o);
                    ctrlVar++;
                    beast.nineb.setVisibility(View.VISIBLE);
                    beast.nineb.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.bg));
                    break;
                }
        }
    }

    public void nine(View view) {
        switch (view.getId()) {
            case R.id.nineb1:
                beast.threeParent.setVisibility(View.VISIBLE);
                set(beast.nineb11, beast.nineb12, beast.nineb13, beast.nineb14, beast.nineb15, beast.nineb16, beast.nineb17, beast.nineb18, beast.nineb19);
                break;
        }
    }

    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
