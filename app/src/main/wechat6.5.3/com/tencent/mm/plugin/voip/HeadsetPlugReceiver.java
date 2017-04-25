package com.tencent.mm.plugin.voip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.v;

public class HeadsetPlugReceiver extends BroadcastReceiver {
    private a kqE = null;

    public interface a {
        void dG(boolean z);
    }

    public void onReceive(Context context, Intent intent) {
        v.d("MicroMsg.HeadsetPlugReceiver", "headset onReceive %s  %d", new Object[]{intent.getAction(), Integer.valueOf(intent.getIntExtra("state", 0))});
        if (intent.getAction() != null && intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            if (intent.getIntExtra("state", 0) == 0) {
                if (this.kqE != null) {
                    this.kqE.dG(false);
                }
            } else if (intent.getIntExtra("state", 0) == 1 && this.kqE != null) {
                this.kqE.dG(true);
            }
        }
    }

    public final void a(Context context, a aVar) {
        this.kqE = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        context.registerReceiver(this, intentFilter);
    }

    public final void cD(Context context) {
        try {
            context.unregisterReceiver(this);
        } catch (Exception e) {
            v.e("MicroMsg.HeadsetPlugReceiver", "unregisterReceiver(HeadsetPlugReceiver.this) error:%s", new Object[]{e.getMessage()});
        }
        this.kqE = null;
    }
}
