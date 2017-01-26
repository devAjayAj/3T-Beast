package com.beast.tictactoe.xo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int ctrlvar;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int dataentry[][] = new int[3][3];
    int x = 0,y = 0,c;
    TextView xs,ys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctrlvar = 0;
        for(int i = 0; i <=2; i++)
            for(int j = 0; j <= 2; j++){
                dataentry[i][j] = 0;
            }
        xs = (TextView)findViewById(R.id.xscore);
        ys = (TextView)findViewById(R.id.yscore);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        b6 = (Button)findViewById(R.id.b6);
        b7 = (Button)findViewById(R.id.b7);
        b8 = (Button)findViewById(R.id.b8);
        b9 = (Button)findViewById(R.id.b9);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
    }

    public void clear(){
        ctrlvar = 0;
        c = 0;
        String v = " "+x;
        xs.setText(v);
        v = " "+y;
        for(int i = 0; i <=2; i++)
            for(int j = 0; j <= 2; j++){
                dataentry[i][j] = 0;
            }
        ys.setText(v);
        b1.setText(" ");
        b1.setClickable(true);
        b2.setText(" ");
        b2.setClickable(true);
        b3.setText(" ");
        b3.setClickable(true);
        b4.setText(" ");
        b4.setClickable(true);
        b5.setText(" ");
        b5.setClickable(true);
        b6.setText(" ");
        b6.setClickable(true);
        b7.setText(" ");
        b7.setClickable(true);
        b8.setText(" ");
        b8.setClickable(true);
        b9.setText(" ");
        b9.setClickable(true);
    }

    public void check(){
        c = (dataentry[0][0] + dataentry[0][1] + dataentry[0][2]);
        int gameover = 0;
        if(c == 3){
            Toast.makeText(MainActivity.this,"X wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            x++;
            clear();
        }
        else if(c == 30){
            Toast.makeText(MainActivity.this,"O wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            y++;
            clear();
        }
        c = (dataentry[1][0] + dataentry[1][1] + dataentry[1][2]);
        if(c == 3){
            Toast.makeText(MainActivity.this,"X wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            x++;
            clear();
        }
        else if(c == 30){
            Toast.makeText(MainActivity.this,"O wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            y++;
            clear();
        }
        c = (dataentry[2][0] + dataentry[2][1] + dataentry[2][2]);
        if(c == 3){
            Toast.makeText(MainActivity.this,"X wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            x++;
            clear();
        }
        else if(c == 30){
            Toast.makeText(MainActivity.this,"O wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            y++;
            clear();
        }
        c = (dataentry[0][0] + dataentry[1][0] + dataentry[2][0]);
        if(c == 3){
            Toast.makeText(MainActivity.this,"X wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            x++;
            clear();
        }
        else if(c == 30){
            Toast.makeText(MainActivity.this,"O wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            y++;
            clear();
        }
        c = (dataentry[0][1] + dataentry[1][1] + dataentry[2][1]);
        if(c == 3){
            Toast.makeText(MainActivity.this,"X wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            x++;
            clear();
        }
        else if(c == 30){
            Toast.makeText(MainActivity.this,"O wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            y++;
            clear();
        }
        c = (dataentry[0][2] + dataentry[1][2] + dataentry[2][2]);
        if(c == 3){
            Toast.makeText(MainActivity.this,"X wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            x++;
            clear();
        }
        else if(c == 30){
            Toast.makeText(MainActivity.this,"O wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            y++;
            clear();
        }
        c = (dataentry[0][0] + dataentry[1][1] + dataentry[2][2]);
        if(c == 3){
            Toast.makeText(MainActivity.this,"X wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            x++;
            clear();
        }
        else if(c == 30){
            Toast.makeText(MainActivity.this,"O wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            y++;
            clear();
        }
        c = (dataentry[0][2] + dataentry[1][1] + dataentry[2][0]);
        if(c == 3){
            Toast.makeText(MainActivity.this,"X wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            x++;
            clear();
        }
        else if(c == 30){
            Toast.makeText(MainActivity.this,"O wins",Toast.LENGTH_SHORT).show();
            gameover = 1;
            y++;
            clear();
        }
        if(ctrlvar == 9 && gameover == 0){
            Toast.makeText(MainActivity.this,"Draw! Play Again",Toast.LENGTH_SHORT).show();
            clear();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.b1:
            if(ctrlvar % 2 == 0) {
                b1.setText("X");
                b1.setTextSize(40);
                b1.setClickable(false);
                ctrlvar++;
                dataentry[0][0] = 1;
            }
            else{
                b1.setText("O");
                b1.setTextSize(40);
                b1.setClickable(false);
                ctrlvar++;
                dataentry[0][0] = 10;
            }
            break;
            case R.id.b2:
            if(ctrlvar % 2 == 0) {
                b2.setText("X");
                b2.setTextSize(40);
                b2.setClickable(false);
                ctrlvar++;
                dataentry[0][1] = 1;
            }
            else{
                b2.setText("O");
                b2.setTextSize(40);
                b2.setClickable(false);
                ctrlvar++;
                dataentry[0][1] = 10;
            }
            break;
            case R.id.b3:
            if(ctrlvar % 2 == 0) {
                b3.setText("X");
                b3.setTextSize(40);
                b3.setClickable(false);
                ctrlvar++;
                dataentry[0][2] = 1;
            }
            else{
                b3.setText("O");
                b3.setTextSize(40);
                b3.setClickable(false);
                ctrlvar++;
                dataentry[0][2] = 10;
            }
            break;
            case R.id.b4:
            if(ctrlvar % 2 == 0) {
                b4.setText("X");
                b4.setTextSize(40);
                b4.setClickable(false);
                ctrlvar++;
                dataentry[1][0] = 1;
            }
            else{
                b4.setText("O");
                b4.setTextSize(40);
                b4.setClickable(false);
                ctrlvar++;
                dataentry[1][0] = 10;
            }
            break;
            case R.id.b5:
            if(ctrlvar % 2 == 0) {
                b5.setText("X");
                b5.setTextSize(40);
                b5.setClickable(false);
                ctrlvar++;
                dataentry[1][1] = 1;
            }
            else{
                b5.setText("O");
                b5.setTextSize(40);
                b5.setClickable(false);
                ctrlvar++;
                dataentry[1][1] = 10;
            }
            break;
            case R.id.b6:
            if(ctrlvar % 2 == 0) {
                b6.setText("X");
                b6.setTextSize(40);
                b6.setClickable(false);
                ctrlvar++;
                dataentry[1][2] = 1;
            }
            else{
                b6.setText("O");
                b6.setTextSize(40);
                b6.setClickable(false);
                ctrlvar++;
                dataentry[1][2] = 10;
            }
            break;
            case R.id.b7:
            if(ctrlvar % 2 == 0) {
                b7.setText("X");
                b7.setTextSize(40);
                b7.setClickable(false);
                ctrlvar++;
                dataentry[2][0] = 1;
            }
            else{
                b7.setText("O");
                b7.setTextSize(40);
                b7.setClickable(false);
                ctrlvar++;
                dataentry[2][0] = 10;
            }
            break;
            case R.id.b8:
            if(ctrlvar % 2 == 0) {
                b8.setText("X");
                b8.setTextSize(40);
                b8.setClickable(false);
                ctrlvar++;
                dataentry[2][1] = 1;
            }
            else{
                b8.setText("O");
                b8.setTextSize(40);
                b8.setClickable(false);
                ctrlvar++;
                dataentry[2][1] = 10;
            }
            break;
            case R.id.b9:
            if(ctrlvar % 2 == 0) {
                b9.setText("X");
                b9.setTextSize(40);
                b9.setClickable(false);
                ctrlvar++;
                dataentry[2][2] = 1;
            }
            else{
                b9.setText("O");
                b9.setTextSize(40);
                b9.setClickable(false);
                ctrlvar++;
                dataentry[2][2] = 10;
            }
            break;
        }
        check();
    }
}
