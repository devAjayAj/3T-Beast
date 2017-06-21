package com.beast.tictactoe.xo;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthCredential;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.R.attr.data;

public class onepeasygame extends AppCompatActivity implements View.OnClickListener {
    ImageView b1, b2, b3, b4, b5, b6, b7, b8, b9, back;
    int b1c = 0, b2c = 0, b3c = 0, b4c = 0, b5c = 0, b6c = 0, b7c = 0, b8c = 0, b9c = 0;
    LinearLayout llayout;
    int dataentry[][] = new int[3][3], x = 0, y = 0, c, gameover, ctrlvar;
    TextView xs, ys, dispTurn, winner;
    Button playAgain, reset;
    Boolean backActivity = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal);
        ctrlvar = 0;
        for (int i = 0; i <= 2; i++)
            for (int j = 0; j <= 2; j++) {
                dataentry[i][j] = 0;
            }


//        FirebaseAuth mAuth = FirebaseAuth.getInstance();
//        FirebaseUser user = mAuth.getCurrentUser();
//        CircleImageView profilePic = (CircleImageView) findViewById(R.id.profile_image);
//        user.reload();
//        Uri uri = user.getPhotoUrl();
//        Picasso.with(onepeasygame.this).load(uri).memoryPolicy(MemoryPolicy.NO_CACHE).into(profilePic);

        xs = (TextView) findViewById(R.id.xscore);
        ys = (TextView) findViewById(R.id.yscore);
        dispTurn = (TextView) findViewById(R.id.dispTurn);
        winner = (TextView) findViewById(R.id.winner);
        SpannableString spantext = new SpannableString("Your Turn");
//        spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 3, 0);
        dispTurn.setText(spantext, TextView.BufferType.SPANNABLE);
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
        /*cv = (CardView) findViewById(R.id.card);
        cv.post(new Runnable() {
            @Override
            public void run() {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(cv.getMeasuredWidth(), cv.getMeasuredWidth());
                params.setMargins(dpToPx(8), dpToPx(8), dpToPx(8), dpToPx(8));
                cv.setLayoutParams(params);
            }
        });*/
    }

    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public void clickable(Boolean val) {
        if (b1c == 0)
            b1.setClickable(val);
        if (b2c == 0)
            b2.setClickable(val);
        if (b3c == 0)
            b3.setClickable(val);
        if (b4c == 0)
            b4.setClickable(val);
        if (b5c == 0)
            b5.setClickable(val);
        if (b6c == 0)
            b6.setClickable(val);
        if (b7c == 0)
            b7.setClickable(val);
        if (b8c == 0)
            b8.setClickable(val);
        if (b9c == 0)
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
                if (x != 0 || y != 0) {
                    xs.setText("0");
                    ys.setText("0");
                    x = 0;
                    y = 0;
                    newGame();
                }
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
        SpannableString spantext = new SpannableString("Your Turn");
//        spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 3, 0);
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
        b1c = 0;
        b2c = 0;
        b3c = 0;
        b4c = 0;
        b5c = 0;
        b6c = 0;
        b7c = 0;
        b8c = 0;
        b9c = 0;
        clickable(true);
    }

    public void declare(ImageView bb1, ImageView bb2, ImageView bb3, int check) {
        if (check == 1) {
            SpannableString spantext = new SpannableString("You win!");
//            spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 1, 0);
            winner.setText(spantext, TextView.BufferType.SPANNABLE);
            bb1.setBackgroundResource(R.drawable.xwin);
            bb2.setBackgroundResource(R.drawable.xwin);
            bb3.setBackgroundResource(R.drawable.xwin);
            gameover = 1;
            x++;
            clear();
        } else if (check == 0) {
            SpannableString spantext = new SpannableString("Computer wins!");
            /*spantext.setSpan(new ForegroundColorSpan(Color.rgb(248, 114, 106)), 0, 1, 0);
            spantext.setSpan(new ForegroundColorSpan(Color.rgb(248, 114, 106)), 6, 7, 0);*/
//            spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 1, 0);
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
//            Toast.makeText(normal.this, "O wins", Toast.LENGTH_SHORT).show();
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
            SpannableString spantext = new SpannableString("Computer's Turn");
//            spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 3, 0);
            dispTurn.setText(spantext, TextView.BufferType.SPANNABLE);
        } else if (check == 0) {
            bb1.setBackgroundResource(R.drawable.o);
            bb1.setClickable(false);
            ctrlvar++;
            dataentry[a][b] = 10;
            SpannableString spantext = new SpannableString("Your Turn");
//            spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 3, 0);
            dispTurn.setText(spantext, TextView.BufferType.SPANNABLE);
        }
    }

    public void compTurn() {
        Random rand = new Random();
        int a = 0, b = 0, place;
        do {
            place = rand.nextInt(3);
            a = rand.nextInt(3);
        } while (dataentry[a][place] != 0);
        if (a == 0 && place == 0) {
            displayTurn(b1, 0, 0, 0);
            b1c = 1;
        } else if (a == 0 && place == 1) {
            displayTurn(b2, 0, 1, 0);
            b2c = 1;
        } else if (a == 0 && place == 2) {
            displayTurn(b3, 0, 2, 0);
            b3c = 1;
       } else if (a == 1 && place == 0) {
            displayTurn(b4, 1, 0, 0);
            b4c = 1;
        } else if (a == 1 && place == 1) {
            displayTurn(b5, 1, 1, 0);
            b5c = 1;
        } else if (a == 1 && place == 2) {
            displayTurn(b6, 1, 2, 0);
            b6c = 1;
        } else if (a == 2 && place == 0) {
            displayTurn(b7, 2, 0, 0);
            b7c = 1;
        } else if (a == 2 && place == 1) {
            displayTurn(b8, 2, 1, 0);
            b8c = 1;
        } else if (a == 2 && place == 2) {
            displayTurn(b9, 2, 2, 0);
            b9c = 1;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                displayTurn(b1, 0, 0, 1);
                b1c = 1;
                break;
            case R.id.b2:
                displayTurn(b2, 0, 1, 1);
                b2c = 1;
                break;
            case R.id.b3:
                displayTurn(b3, 0, 2, 1);
                b3c = 1;
                break;
            case R.id.b4:
                displayTurn(b4, 1, 0, 1);
                b4c = 1;
                break;
            case R.id.b5:
                displayTurn(b5, 1, 1, 1);
                b5c = 1;
                break;
            case R.id.b6:
                displayTurn(b6, 1, 2, 1);
                b6c = 1;
                break;
            case R.id.b7:
                displayTurn(b7, 2, 0, 1);
                b7c = 1;
                break;
            case R.id.b8:
                displayTurn(b8, 2, 1, 1);
                b8c = 1;
                break;
            case R.id.b9:
                displayTurn(b9, 2, 2, 1);
                b9c = 1;
                break;
            case R.id.back:
                onepeasygame.this.finish();
                backActivity = true;
        }
        clickable(false);
        if (!backActivity)
            check();
        if (gameover != 1 && ctrlvar != 9 && !backActivity) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    compTurn();
                    clickable(true);
                    check();
                }
            }, 500);
        }
    }
}
