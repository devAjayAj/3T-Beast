package com.beast.tictactoe.xo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView b1, b2, b3, b4, b5, b6, b7, b8, b9, back;
    LinearLayout llayout;
    CardView cv;
    int dataentry[][] = new int[3][3], x = 0, y = 0, c, gameover, ctrlvar;
    TextView xs, ys, dispTurn, winner;
    Button playAgain, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctrlvar = 0;
        for (int i = 0; i <= 2; i++)
            for (int j = 0; j <= 2; j++) {
                dataentry[i][j] = 0;
            }
        xs = (TextView) findViewById(R.id.xscore);
        ys = (TextView) findViewById(R.id.yscore);
        dispTurn = (TextView) findViewById(R.id.dispTurn);
        winner = (TextView) findViewById(R.id.winner);
        dispTurn.setText("X's Turn");
        playAgain = (Button) findViewById(R.id.pagain);
        reset = (Button) findViewById(R.id.reset);
        playAgain.setVisibility(View.INVISIBLE);
        playAgain.setClickable(false);
        llayout = (LinearLayout) findViewById(R.id.llayout);
        b1 = (ImageView) findViewById(R.id.b1);
        b2 = (ImageView) findViewById(R.id.b2);
        b3 = (ImageView) findViewById(R.id.b3);
        b4 = (ImageView) findViewById(R.id.b4);
        b5 = (ImageView) findViewById(R.id.b5);
        b6 = (ImageView) findViewById(R.id.b6);
        b7 = (ImageView) findViewById(R.id.b7);
        b8 = (ImageView) findViewById(R.id.b8);
        b9 = (ImageView) findViewById(R.id.b9);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(this);
        cv = (CardView) findViewById(R.id.card);
        cv.post(new Runnable() {
            @Override
            public void run() {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(cv.getMeasuredWidth(), cv.getMeasuredWidth());
                params.setMargins(dpToPx(8), dpToPx(8), dpToPx(8), dpToPx(8));
                cv.setLayoutParams(params);
            }
        });
    }

    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public void clickable(Boolean val) {
        b1.setClickable(val);
        b2.setClickable(val);
        b3.setClickable(val);
        b4.setClickable(val);
        b5.setClickable(val);
        b6.setClickable(val);
        b7.setClickable(val);
        b8.setClickable(val);
        b9.setClickable(val);
    }

    public void clear() {
        String v = x + " ";
        xs.setText(v);
        v = y + " ";
        ys.setText(v);
        clickable(false);
        playAgain.setVisibility(View.VISIBLE);
        playAgain.setClickable(true);
        dispTurn.setText(" ");
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xs.setText("0");
                ys.setText("0");
                x = 0;
                y = 0;
                newGame();
            }
        });
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                newGame();
            }
        });

    }

    public void newGame() {
        SpannableString spantext = new SpannableString("X's Turn");
        dispTurn.setText(spantext, TextView.BufferType.SPANNABLE);
        winner.setText(" ");
        playAgain.setClickable(false);
        playAgain.setVisibility(View.INVISIBLE);
        ctrlvar = 0;
        c = 0;
        for (int i = 0; i <= 2; i++)
            for (int j = 0; j <= 2; j++) {
                dataentry[i][j] = 0;
            }
        b1.setBackgroundResource(R.drawable.empty);
        b2.setBackgroundResource(R.drawable.empty);
        b3.setBackgroundResource(R.drawable.empty);
        b4.setBackgroundResource(R.drawable.empty);
        b5.setBackgroundResource(R.drawable.empty);
        b6.setBackgroundResource(R.drawable.empty);
        b7.setBackgroundResource(R.drawable.empty);
        b8.setBackgroundResource(R.drawable.empty);
        b9.setBackgroundResource(R.drawable.empty);
        clickable(true);
    }

    public void declare(ImageView bb1, ImageView bb2, ImageView bb3, int check) {
        if (check == 1) {
            SpannableString spantext = new SpannableString("X wins!");
            spantext.setSpan(new ForegroundColorSpan(Color.rgb(89, 176, 247)), 0, 1, 0);
            spantext.setSpan(new ForegroundColorSpan(Color.rgb(89, 176, 247)), 6, 7, 0);
            spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 1, 0);
            winner.setText(spantext, TextView.BufferType.SPANNABLE);
            bb1.setBackgroundResource(R.drawable.xwin);
            bb2.setBackgroundResource(R.drawable.xwin);
            bb3.setBackgroundResource(R.drawable.xwin);
            gameover = 1;
            x++;
            clear();
        } else if (check == 0) {
            SpannableString spantext = new SpannableString("O wins!");
            spantext.setSpan(new ForegroundColorSpan(Color.rgb(248, 114, 106)), 0, 1, 0);
            spantext.setSpan(new ForegroundColorSpan(Color.rgb(248, 114, 106)), 6, 7, 0);
            spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 1, 0);
            winner.setText(spantext, TextView.BufferType.SPANNABLE);
            bb1.setBackgroundResource(R.drawable.owin);
            bb2.setBackgroundResource(R.drawable.owin);
            bb3.setBackgroundResource(R.drawable.owin);
            gameover = 1;
            y++;
            clear();
        }
    }

    public void check() {
        c = (dataentry[0][0] + dataentry[0][1] + dataentry[0][2]);
        gameover = 0;
        if (c == 3) {
//            M.Sl(findViewById(android.R.id.content),"X Wins!");
            declare(b1, b2, b3, 1);
        } else if (c == 30) {
//            Toast.makeText(MainActivity.this, "O wins", Toast.LENGTH_SHORT).show();
            declare(b1, b2, b3, 0);
        }
        c = (dataentry[1][0] + dataentry[1][1] + dataentry[1][2]);
        if (c == 3) {
            declare(b4, b5, b6, 1);
        } else if (c == 30) {
            declare(b4, b5, b6, 0);
        }
        c = (dataentry[2][0] + dataentry[2][1] + dataentry[2][2]);
        if (c == 3) {
            declare(b7, b8, b9, 1);
        } else if (c == 30) {
            declare(b7, b8, b9, 0);
        }
        c = (dataentry[0][0] + dataentry[1][0] + dataentry[2][0]);
        if (c == 3) {
            declare(b1, b4, b7, 1);
        } else if (c == 30) {
            declare(b1, b4, b7, 0);
        }
        c = (dataentry[0][1] + dataentry[1][1] + dataentry[2][1]);
        if (c == 3) {
            declare(b2, b5, b8, 1);
        } else if (c == 30) {
            declare(b2, b5, b8, 0);
        }
        c = (dataentry[0][2] + dataentry[1][2] + dataentry[2][2]);
        if (c == 3) {
            declare(b3, b6, b9, 1);
        } else if (c == 30) {
            declare(b3, b6, b9, 0);
        }
        c = (dataentry[0][0] + dataentry[1][1] + dataentry[2][2]);
        if (c == 3) {
            declare(b1, b5, b9, 1);
        } else if (c == 30) {
            declare(b1, b5, b9, 0);
        }
        c = (dataentry[0][2] + dataentry[1][1] + dataentry[2][0]);
        if (c == 3) {
            declare(b3, b5, b7, 1);
        } else if (c == 30) {
            declare(b3, b5, b7, 0);
        }
        if (ctrlvar == 9 && gameover == 0) {
            SpannableString spantext = new SpannableString("DRAW!");
            winner.setText(spantext, TextView.BufferType.SPANNABLE);
            clear();
        }
    }

    public void displayTurn(ImageView bb1, int a, int b, int check) {
        if (check == 1) {
            bb1.setBackgroundResource(R.drawable.x);
            bb1.setClickable(false);
            ctrlvar++;
            dataentry[a][b] = 1;
            SpannableString spantext = new SpannableString("O's Turn");
            dispTurn.setText(spantext, TextView.BufferType.SPANNABLE);
        } else if (check == 0) {
            bb1.setBackgroundResource(R.drawable.o);
            bb1.setClickable(false);
            ctrlvar++;
            dataentry[a][b] = 10;
            SpannableString spantext = new SpannableString("X's Turn");
            dispTurn.setText(spantext, TextView.BufferType.SPANNABLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                if (ctrlvar % 2 == 0) {
                    displayTurn(b1, 0, 0, 1);
                } else {
                    displayTurn(b1, 0, 0, 0);
                }
                break;
            case R.id.b2:
                if (ctrlvar % 2 == 0) {
                    displayTurn(b2, 0, 1, 1);
                } else {
                    displayTurn(b2, 0, 1, 0);
                }
                break;
            case R.id.b3:
                if (ctrlvar % 2 == 0) {
                    displayTurn(b3, 0, 2, 1);
                } else {
                    displayTurn(b3, 0, 2, 0);
                }
                break;
            case R.id.b4:
                if (ctrlvar % 2 == 0) {
                    displayTurn(b4, 1, 0, 1);
                } else {
                    displayTurn(b4, 1, 0, 0);
                }
                break;
            case R.id.b5:
                if (ctrlvar % 2 == 0) {
                    displayTurn(b5, 1, 1, 1);
                } else {
                    displayTurn(b5, 1, 1, 0);
                }
                break;
            case R.id.b6:
                if (ctrlvar % 2 == 0) {
                    displayTurn(b6, 1, 2, 1);
                } else {
                    displayTurn(b6, 1, 2, 0);
                }
                break;
            case R.id.b7:
                if (ctrlvar % 2 == 0) {
                    displayTurn(b7, 2, 0, 1);
                } else {
                    displayTurn(b7, 2, 0, 0);
                }
                break;
            case R.id.b8:
                if (ctrlvar % 2 == 0) {
                    displayTurn(b8, 2, 1, 1);
                } else {
                    displayTurn(b8, 2, 1, 0);
                }
                break;
            case R.id.b9:
                if (ctrlvar % 2 == 0) {
                    displayTurn(b9, 2, 2, 1);
                } else {
                    displayTurn(b9, 2, 2, 0);
                }
                break;
            case R.id.back:
                MainActivity.this.finish();
        }
        check();
    }
}
