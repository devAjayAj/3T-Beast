package com.beast.tictactoe.xo;

/**
 * Created by aj on 24/6/17.
 */

public class Board {
    String big, minicount, o, opos, x, xpos;
    int cplayer, megacount, cpos;
    Boolean first;
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
    public String getBig(){
        return big;
    }
    public int getCplayer(){
        return cplayer;
    }
    public int getCpos(){
        return cpos;
    }
    public Boolean getFirst(){
        return first;
    }
    public int getMegacount(){
        return megacount;
    }
    public String getMinicount(){
        return minicount;
    }
    public String getO(){
        return o;
    }
    public String getOpos(){
        return opos;
    }
    public String getX(){
        return x;
    }
    public String getXpos(){
        return xpos;
    }
}
