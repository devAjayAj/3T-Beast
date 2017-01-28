package com.beast.tictactoe.xo.Extras;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class M {
    public static void ts(Context context, String message) {//, LayoutInflater li, View vg) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void tl(Context context, String message) {//, LayoutInflater li, View vg) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void L(String Tag, String message) {
        Log.e(Tag, message);
    }

    public static void Ss(View v, String message) {
        Snackbar snackbar = Snackbar
                .make(v, message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    public static void Sl(View v, String message) {
        Snackbar snackbar = Snackbar
                .make(v, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

}