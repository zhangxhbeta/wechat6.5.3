package com.tencent.mm.modelmulti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class m {
    Boolean cSe = null;

    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ a cSf;
        final /* synthetic */ boolean cSg = false;
        final /* synthetic */ m cSh;

        AnonymousClass1(m mVar, a aVar, boolean z) {
            this.cSh = mVar;
            this.cSf = aVar;
        }

        public final void onReceive(Context context, Intent intent) {
            v.i("MicroMsg.ScreenState", "ScreenReceiver action [%s] ", new Object[]{intent == null ? "" : intent.getAction()});
            if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
                this.cSh.cSe = Boolean.valueOf(false);
            } else {
                this.cSh.cSe = Boolean.valueOf(true);
            }
            if (this.cSf != null) {
                this.cSf.bc(this.cSh.cSe.booleanValue());
            }
            if (this.cSg) {
                context.unregisterReceiver(this);
            }
        }
    }

    public interface a {
        void bc(boolean z);
    }

    public m(Context context, a aVar) {
        this.cSe = aS(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(new AnonymousClass1(this, aVar, false), intentFilter);
    }

    private Boolean aS(Context context) {
        try {
            v.i("MicroMsg.ScreenState", "reflectScreenOn: byReflect:%s isScreenOn:%s", new Object[]{(Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]), this.cSe});
            return (Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]);
        } catch (Throwable e) {
            g.iuh.a(99, 154, 1, false);
            v.e("MicroMsg.ScreenState", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[]{this.cSe, be.e(e)});
            return null;
        }
    }
}
