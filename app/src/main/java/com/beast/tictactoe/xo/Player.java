package com.beast.tictactoe.xo;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by aj on 24/6/17.
 */

@IgnoreExtraProperties
public class Player {
    public String pushKey = "";

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
