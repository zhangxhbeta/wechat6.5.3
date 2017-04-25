package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;

public class MMAutoMessageHeardReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String g = r.g(intent, "key_username");
        if (g != null) {
            v.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "username %s heard", g);
            ak.oH().cancelNotification(g);
            ak.yW();
            c.wK().Mj(g);
        }
    }
}
