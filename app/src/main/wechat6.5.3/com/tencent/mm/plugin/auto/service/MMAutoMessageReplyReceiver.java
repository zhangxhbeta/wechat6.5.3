package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ae;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;

public class MMAutoMessageReplyReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String g = r.g(intent, "key_username");
        if (g != null) {
            Bundle resultsFromIntent = ae.getResultsFromIntent(intent);
            CharSequence charSequence = resultsFromIntent != null ? resultsFromIntent.getCharSequence("key_voice_reply_text") : null;
            if (charSequence == null) {
                v.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply null", g);
                return;
            }
            v.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply %s", g, charSequence.toString());
            a.bmt().x(g, charSequence.toString(), m.fp(g));
        }
    }
}
