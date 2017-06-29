package com.beast.tictactoe.xo;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aj on 24/6/17.
 */
@IgnoreExtraProperties
public class Board {
    public String big, minicount, o, opos, x, xpos;
    public int cplayer, megacount, cpos;
    public Boolean first;
    public Board(){

    }
    public Board(String big, int cplayer, int cpos, Boolean first, int megacount, String minicount, String o, String opos, String x, String xpos){
        this.big = big;
        this.cplayer = cplayer;
        this.cpos = cpos;
        this.first = first;
        this.megacount = megacount;
        this.minicount = minicount;
        this.o = o;
        this.opos = opos;
        this.x = x;
        this.xpos = xpos;
    }

}
