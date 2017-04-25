package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.modelstat.c;

public class ClickFlowReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        c.JW().n(intent);
    }
}
