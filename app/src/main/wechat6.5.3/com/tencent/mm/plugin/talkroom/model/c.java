package com.tencent.mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.talkroom.a;
import com.tencent.mm.pluginsdk.j.y;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class c implements y {
    public boolean gVJ = false;
    public String gVg = "";
    public boolean kkc = false;
    private Notification kkd;
    private String kke;
    ac mHandler = new ac(Looper.getMainLooper());

    private static boolean baa() {
        if (!be.kS(b.aZW().kkT)) {
            return true;
        }
        v.w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
        v.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        bac();
        return false;
    }

    public final void awP() {
        this.gVJ = false;
    }

    public final void A(String str, int i, int i2) {
        this.gVJ = false;
    }

    public final void awQ() {
    }

    public final void mq(int i) {
    }

    public final void vT(String str) {
        this.gVg = str;
    }

    public final void bZ(String str, String str2) {
        if (!this.kkc) {
            bab();
        }
    }

    public final void g(int i, int i2, String str) {
    }

    public final void awR() {
        v.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        bac();
    }

    public final void awS() {
    }

    public final void awT() {
    }

    public final void awU() {
    }

    public final void Cz(String str) {
        if (baa()) {
            v.v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: " + str);
            this.kke = str;
            this.kkd = new Builder(aa.getContext()).setTicker(str).setWhen(0).getNotification();
            this.kkd.icon = 2130839298;
            this.kkd.flags = 32;
            bab();
        }
    }

    private void bab() {
        if (!baa()) {
            return;
        }
        if (this.kkd == null) {
            v.e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
            return;
        }
        CharSequence string;
        CharSequence au = h.au(aa.getContext(), b.aZW().kkT);
        if (b.aZW().klh) {
            string = aa.getContext().getString(2131235626);
        } else {
            string = aa.getContext().getString(2131235623, new Object[]{Integer.valueOf(b.aZW().awq().size())});
        }
        Intent oA = a.drq.oA();
        oA.putExtra("enter_chat_usrname", b.aZW().kkT);
        this.kkd = new Builder(aa.getContext()).setTicker(this.kke).setWhen(0).setContentTitle(au).setContentText(string).setContentIntent(PendingIntent.getActivity(aa.getContext(), 100, oA, 268435456)).getNotification();
        this.kkd.icon = 2130839298;
        this.kkd.flags = 32;
        ak.oH().a(100, this.kkd, false);
    }

    public static void bac() {
        v.v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
        ak.oH().cancel(100);
    }
}
