package com.beast.tictactoe.xo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    Button nMode, bMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        nMode = (Button) findViewById(R.id.normalMode);
        nMode.setOnClickListener(this);
        bMode = (Button) findViewById(R.id.beast_mode);
        bMode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.normalMode:
                startActivity(new Intent(Menu.this,MainActivity.class));
                break;
            case R.id.beast_mode:
                startActivity(new Intent(Menu.this, Beast.class));
                break;
        }
    }

}
