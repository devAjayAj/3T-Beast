package com.beast.tictactoe.xo;

/**
 * Created by aj on 24/6/17.
 */

public class Player {
    String pushKey = "";

    public Player() {
    }

    public Player(String pushKey) {
        this.pushKey = pushKey;
    }

    public String getUid() {
        return pushKey;
    }

    public void setUid(String pushKey) {
        this.pushKey = pushKey;
    }
}
