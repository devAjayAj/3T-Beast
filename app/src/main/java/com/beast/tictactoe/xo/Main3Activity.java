package com.beast.tictactoe.xo;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    TextView dispTurn;
    Button playAgain;
    Toast a;
    int greaterCount = 0;
    int[] smallCount = {0, 0, 0, 0, 0, 0, 0, 0, 0};
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
    boolean gameOver = false;
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

    TextView winner;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        winner = (TextView) findViewById(R.id.winner);
        for (int i = 0; i < 9; i++) {
            LinearLayout temp = (LinearLayout) findViewById(bigImageViewIds[i]);
            temp.setClickable(true);
        }
        dispTurn = (TextView) findViewById(R.id.dispTurn);
        SpannableString spantext = new SpannableString("X's Turn");
        spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 3, 0);
        dispTurn.setText(spantext, TextView.BufferType.SPANNABLE);
        playAgain = (Button) findViewById(R.id.pagain);
        playAgain.setVisibility(View.INVISIBLE);
        playAgain.setClickable(false);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main3Activity.this.finish();
            }
        });
    }

    public void onclickBig(View v){
        if(a!=null)
            a.cancel();
        a = Toast.makeText(this.getApplicationContext(), "You cannot play here", Toast.LENGTH_SHORT);
        a.setGravity(Gravity.TOP, 0, 0);
        a.show();
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
            smallCount[idNum / 9]++;
            SpannableString spantext = new SpannableString("X's Turn");
            spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 3, 0);
            dispTurn.setText(spantext, TextView.BufferType.SPANNABLE);
        } else if (player == 1) {
            temp.setImageResource(R.drawable.x);
            temp.setClickable(false);
            player = 0;
            ninePlaces[idNum] = 1;
            smallCount[idNum / 9]++;
            SpannableString spantext = new SpannableString("O's Turn");
            spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 3, 0);
            dispTurn.setText(spantext, TextView.BufferType.SPANNABLE);
        }
        check(idNum, player);
        /*if (openChoice) {
            openChoiceFun(idNum);
            openChoice = false;
        } else*/
        if (!gameOver)
            block(idNum);
        if (smallCount[idNum / 9] == 9) {
            greaterCount++;
            threePlaces[idNum / 9] = 3;
        }
    }


    public void check(int idNum, int player) {
        int smallStart = (idNum / 9) * 9;
        int bigPos = idNum / 9;
        if (ninePlaces[smallStart] == ninePlaces[smallStart + 1] && ninePlaces[smallStart + 1] == ninePlaces[smallStart + 2] && ninePlaces[smallStart] != 2) {
            displayWin(smallStart, smallStart + 1, smallStart + 2, bigPos, player, idNum);
        } else if (ninePlaces[smallStart + 3] == ninePlaces[smallStart + 4] && ninePlaces[smallStart + 4] == ninePlaces[smallStart + 5] && ninePlaces[smallStart + 3] != 2) {
            displayWin(smallStart + 3, smallStart + 4, smallStart + 5, bigPos, player, idNum);
        } else if (ninePlaces[smallStart + 6] == ninePlaces[smallStart + 7] && ninePlaces[smallStart + 7] == ninePlaces[smallStart + 8] && ninePlaces[smallStart + 8] != 2) {
            displayWin(smallStart + 6, smallStart + 7, smallStart + 8, bigPos, player, idNum);
        } else if (ninePlaces[smallStart] == ninePlaces[smallStart + 3] && ninePlaces[smallStart + 3] == ninePlaces[smallStart + 6] && ninePlaces[smallStart] != 2) {
            displayWin(smallStart, smallStart + 3, smallStart + 6, bigPos, player, idNum);
        } else if (ninePlaces[smallStart + 1] == ninePlaces[smallStart + 4] && ninePlaces[smallStart + 4] == ninePlaces[smallStart + 7] && ninePlaces[smallStart + 1] != 2) {
            displayWin(smallStart + 1, smallStart + 4, smallStart + 7, bigPos, player, idNum);
        } else if (ninePlaces[smallStart + 2] == ninePlaces[smallStart + 5] && ninePlaces[smallStart + 5] == ninePlaces[smallStart + 8] && ninePlaces[smallStart + 2] != 2) {
            displayWin(smallStart + 2, smallStart + 5, smallStart + 8, bigPos, player, idNum);
        } else if (ninePlaces[smallStart] == ninePlaces[smallStart + 4] && ninePlaces[smallStart + 4] == ninePlaces[smallStart + 8] && ninePlaces[smallStart + 4] != 2) {
            displayWin(smallStart, smallStart + 4, smallStart + 8, bigPos, player, idNum);
        } else if (ninePlaces[smallStart + 2] == ninePlaces[smallStart + 4] && ninePlaces[smallStart + 4] == ninePlaces[smallStart + 6] && ninePlaces[smallStart + 6] != 2) {
            displayWin(smallStart + 2, smallStart + 4, smallStart + 6, bigPos, player, idNum);
        }
    }

    public void checkBig() {
        if (threePlaces[0] == threePlaces[1] && threePlaces[1] == threePlaces[2] && threePlaces[0] != 2) {
            displayWinBig(0, 1, 2);
            blockAll();
        } else if (threePlaces[3] == threePlaces[4] && threePlaces[4] == threePlaces[5] && threePlaces[3] != 2) {
            displayWinBig(3, 4, 5);
            blockAll();
        } else if (threePlaces[6] == threePlaces[7] && threePlaces[7] == threePlaces[8] && threePlaces[6] != 2) {
            displayWinBig(6, 7, 8);
            blockAll();
        } else if (threePlaces[0] == threePlaces[3] && threePlaces[3] == threePlaces[6] && threePlaces[0] != 2) {
            displayWinBig(0, 3, 6);
            blockAll();
        } else if (threePlaces[1] == threePlaces[4] && threePlaces[4] == threePlaces[7] && threePlaces[1] != 2) {
            displayWinBig(1, 4, 7);
            blockAll();
        } else if (threePlaces[2] == threePlaces[5] && threePlaces[5] == threePlaces[8] && threePlaces[2] != 2) {
            displayWinBig(2, 5, 8);
            blockAll();
        } else if (threePlaces[0] == threePlaces[4] && threePlaces[4] == threePlaces[8] && threePlaces[0] != 2) {
            displayWinBig(0, 4, 8);
            blockAll();
        } else if (threePlaces[2] == threePlaces[4] && threePlaces[4] == threePlaces[6] && threePlaces[2] != 2) {
            displayWinBig(2, 4, 6);
            blockAll();
        } else if (greaterCount == 9) {
            SpannableString spantext = new SpannableString("DRAW!");
            spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 1, 0);
            winner.setText(spantext, TextView.BufferType.SPANNABLE);
            blockAll();
        }
    }

    public void displayWinBig(int b1, int b2, int b3) {
        LinearLayout big1 = (LinearLayout) findViewById(bigImageViewIds[b1]);
        LinearLayout big2 = (LinearLayout) findViewById(bigImageViewIds[b2]);
        LinearLayout big3 = (LinearLayout) findViewById(bigImageViewIds[b3]);
        if (threePlaces[b1] == 1) {
            big1.setBackgroundResource(R.drawable.xwin);
            big2.setBackgroundResource(R.drawable.xwin);
            big3.setBackgroundResource(R.drawable.xwin);
            SpannableString spantext = new SpannableString("X wins!");
            spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 1, 0);
            winner.setText(spantext, TextView.BufferType.SPANNABLE);
        } else if (threePlaces[b1] == 0) {
            big1.setBackgroundResource(R.drawable.owin);
            big2.setBackgroundResource(R.drawable.owin);
            big3.setBackgroundResource(R.drawable.owin);
            SpannableString spantext = new SpannableString("O wins!");
            spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 1, 0);
            winner.setText(spantext, TextView.BufferType.SPANNABLE);
        }
        for (int i = 0; i < 9; i++) {
            LinearLayout temp = (LinearLayout) findViewById(bigImageViewIds[i]);
            temp.setVisibility(View.VISIBLE);
        }
    }

    public void displayWin(int small1, int small2, int small3, int bigPos, int player, int idNum) {
        ImageView s1 = (ImageView) findViewById(smallImageViewIds[small1]);
        ImageView s2 = (ImageView) findViewById(smallImageViewIds[small2]);
        ImageView s3 = (ImageView) findViewById(smallImageViewIds[small3]);
        LinearLayout big = (LinearLayout) findViewById(bigImageViewIds[bigPos]);
        if (player == 0) {
            s1.setImageResource(R.drawable.xwin);
            s2.setImageResource(R.drawable.xwin);
            s3.setImageResource(R.drawable.xwin);
            big.setBackgroundResource(R.drawable.x);
            big.setAlpha((float) 0.7);
            threePlaces[bigPos] = 1;
            greaterCount++;
        } else if (player == 1) {
            s1.setImageResource(R.drawable.owin);
            s2.setImageResource(R.drawable.owin);
            s3.setImageResource(R.drawable.owin);
            big.setBackgroundResource(R.drawable.o);
            big.setAlpha((float) 0.7);
            threePlaces[bigPos] = 0;
            greaterCount++;
        }
        checkBig();
        /*if (bigPos == nextBigPos(idNum)) {
            openChoice = true;
        }*/
    }

    public void block(int idNum) {
        int bigPos = nextBigPos(idNum);
        for (int i = 0; i < 9; i++) {
            LinearLayout temp = (LinearLayout) findViewById(bigImageViewIds[i]);
            temp.setVisibility(View.VISIBLE);
        }
        for (int i = 0; i < 81; i++) {
            ImageView v = (ImageView) findViewById(smallImageViewIds[i]);
            v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
        }
        if (threePlaces[bigPos] != 2) {
            for (int i = 0; i < 81; i++) {
                if (threePlaces[i / 9] == 2) {
                    ImageView v = (ImageView) findViewById(smallImageViewIds[i]);
                    if (player == 1 && ninePlaces[i] == 2) {
                        v.setImageDrawable(null);
                        v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.xclrlight));
                    } else if (player == 0 && ninePlaces[i] == 2) {
                        v.setImageDrawable(null);
                        v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.oclrlight));
                    }
                }
            }
            for (int i = 0; i < 9; i++) {
                if (threePlaces[i] == 2) {
                    LinearLayout temp = (LinearLayout) findViewById(bigImageViewIds[i]);
                    temp.setVisibility(View.GONE);
                }
            }
        } else if (threePlaces[bigPos] == 2) {
            LinearLayout temp = (LinearLayout) findViewById(bigImageViewIds[bigPos]);
            temp.setVisibility(View.GONE);
            for (int i = bigPos * 9; i < bigPos * 9 + 9; i++) {
                ImageView v = (ImageView) findViewById(smallImageViewIds[i]);
                if (player == 1 && ninePlaces[i] == 2) {
                    v.setImageDrawable(null);
                    v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.xclrlight));
                } else if (player == 0 && ninePlaces[i] == 2) {
                    v.setImageDrawable(null);
                    v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.oclrlight));
                }
            }
        }
        /*if (threePlaces[bigPos] != 2) {
            for (int i = 0; i < 9; i++) {
                if (threePlaces[i] == 2) {
                    LinearLayout temp = (LinearLayout) findViewById(bigImageViewIds[i]);
                    temp.setVisibility(View.INVISIBLE);
                }
            }
            for (int i = 0; i < 81; i++) {
                ImageView v = (ImageView) findViewById(smallImageViewIds[i]);
                if (player == 1 && ninePlaces[i] == 2) {
                    v.setImageDrawable(null);
                    v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.xclrlight));
                } else if (player == 0 && ninePlaces[i] == 2) {
                    v.setImageDrawable(null);
                    v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.oclrlight));
                }
            }
            for (int i = bigPos * 9; i < (bigPos * 9 + 9); i++) {
                ImageView v = (ImageView) findViewById(smallImageViewIds[i]);
                v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            }
        } else {
            for (int i = 0; i < 81; i++) {
                ImageView v = (ImageView) findViewById(smallImageViewIds[i]);
                v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            }
            if (threePlaces[bigPos] == 2) {
                for (int i = 0; i < 9; i++) {
                    LinearLayout temp = (LinearLayout) findViewById(bigImageViewIds[i]);
                    temp.setVisibility(View.VISIBLE);
                }
                for (int i = bigPos * 9; i < (bigPos * 9 + 9); i++) {
                    ImageView v = (ImageView) findViewById(smallImageViewIds[i]);
                    if (player == 1 && ninePlaces[i] == 2) {
                        v.setImageDrawable(null);
                        v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.xclrlight));
                    } else if (player == 0 && ninePlaces[i] == 2) {
                        v.setImageDrawable(null);
                        v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.oclrlight));
                    }
                }
                if (threePlaces[bigPos] == 2) {
                    LinearLayout temp = (LinearLayout) findViewById(bigImageViewIds[bigPos]);
                    temp.setVisibility(View.INVISIBLE);
                }
            } else {
                for (int i = 0; i < 9; i++) {
                    if (threePlaces[i] == 2) {
                        LinearLayout temp = (LinearLayout) findViewById(bigImageViewIds[i]);
                        temp.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }*/
    }

    /*public void openChoiceFun(int idNum) {
        int bigPos = idNum / 9;
        for (int i = 0; i < 9; i++) {
            if (threePlaces[i] == 2) {
                LinearLayout temp = (LinearLayout) findViewById(bigImageViewIds[i]);
                temp.setVisibility(View.INVISIBLE);
            }
        }
        LinearLayout temp = (LinearLayout) findViewById(bigImageViewIds[bigPos]);
        temp.setVisibility(View.VISIBLE);

        for (int i = 0; i < 81; i++) {
            ImageView v = (ImageView) findViewById(smallImageViewIds[i]);
            if (player == 1 && ninePlaces[i] == 2) {
                v.setImageDrawable(null);
                v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.xclrlight));
            } else if (player == 0 && ninePlaces[i] == 2) {
                v.setImageDrawable(null);
                v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.oclrlight));
            }
        }

        for (int i = bigPos * 9; i < (bigPos * 9 + 9); i++) {
            ImageView v = (ImageView) findViewById(smallImageViewIds[i]);
            v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
        }
    }*/

    public void blockAll() {
        gameOver = true;
        for (int i = 0; i < 81; i++) {
            ImageView temp = (ImageView) findViewById(smallImageViewIds[i]);
            temp.setClickable(false);
        }
        for (int i = 0; i < 81; i++) {
            ImageView v = (ImageView) findViewById(smallImageViewIds[i]);
            v.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
        }
        playAgain.setVisibility(View.VISIBLE);
        playAgain.setClickable(true);
        dispTurn.setText(" ");
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
    }

    public int nextBigPos(int idNum) {
        return (idNum % 9);
    }

}
