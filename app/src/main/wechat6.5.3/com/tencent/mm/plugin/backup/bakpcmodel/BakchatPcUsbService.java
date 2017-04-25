package com.tencent.mm.plugin.backup.bakpcmodel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BakchatPcUsbService extends Service implements e {
    private boolean eaR = false;
    private boolean ecK = false;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        v.i("MicroMsg.BakchatPcUsbService", "onCreate()");
        super.onCreate();
        ak.vy().a(595, (e) this);
        b.a(1, (e) this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 1;
        v.i("MicroMsg.BakchatPcUsbService", "onStartCommand()");
        if (intent == null) {
            v.w("MicroMsg.BakchatPcUsbService", "onStartCommand intent is null");
        } else {
            String stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            if (be.kS(stringExtra)) {
                v.e("MicroMsg.BakchatPcUsbService", "onStartCommand url is null");
                stopSelf();
            } else {
                this.eaR = intent.getBooleanExtra("isFromWifi", false);
                this.ecK = intent.getBooleanExtra("isMove", false);
                v.i("MicroMsg.BakchatPcUsbService", "Broadcast url:%s, isFromWifi:%b, isMove:%b", stringExtra, Boolean.valueOf(this.eaR), Boolean.valueOf(this.ecK));
                if (this.ecK) {
                    ak.vy().a(new i(stringExtra), 0);
                    b.b(1, this);
                } else {
                    com.tencent.mm.plugin.backup.g.b.UO().zR();
                    a UO = com.tencent.mm.plugin.backup.g.b.UO();
                    if (this.eaR) {
                        i3 = 2;
                    }
                    UO.efJ = i3;
                    if (this.ecK || ak.uN()) {
                        ak.vy().a(new i(stringExtra), 0);
                    } else {
                        v.e("MicroMsg.BakchatPcUsbService", "onStartCommand not in Login state");
                        Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                        className.addFlags(335544320);
                        className.putExtra("nofification_type", "back_to_pcmgr_notification");
                        startActivity(className);
                    }
                }
            }
        }
        return 2;
    }

    public void onDestroy() {
        ak.vy().b(595, (e) this);
        b.b(1, this);
        super.onDestroy();
        v.i("MicroMsg.BakchatPcUsbService", "onDestroy" + Thread.currentThread().getName());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r11, int r12, java.lang.String r13, com.tencent.mm.v.k r14) {
        /*
        r10 = this;
        r0 = r14 instanceof com.tencent.mm.plugin.backup.b.b;
        if (r0 == 0) goto L_0x0030;
    L_0x0004:
        r0 = r14.getType();
        r1 = 1;
        if (r0 != r1) goto L_0x002c;
    L_0x000b:
        if (r11 != 0) goto L_0x002c;
    L_0x000d:
        if (r12 != 0) goto L_0x002c;
    L_0x000f:
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "com.tencent.mm.ui.LauncherUI";
        r0 = r0.setClassName(r10, r1);
        r1 = 335544320; // 0x14000000 float:6.4623485E-27 double:1.65780921E-315;
        r0.addFlags(r1);
        r1 = "nofification_type";
        r2 = "back_to_pcmgr_notification";
        r0.putExtra(r1, r2);
        r10.startActivity(r0);
    L_0x002c:
        r10.stopSelf();
    L_0x002f:
        return;
    L_0x0030:
        r0 = r14 instanceof com.tencent.mm.plugin.backup.h.i;
        if (r0 == 0) goto L_0x002f;
    L_0x0034:
        if (r11 != 0) goto L_0x0188;
    L_0x0036:
        if (r12 != 0) goto L_0x0188;
    L_0x0038:
        r14 = (com.tencent.mm.plugin.backup.h.i) r14;
        r2 = r14.WC();
        r0 = r10.ecK;
        if (r0 == 0) goto L_0x0133;
    L_0x0042:
        r0 = com.tencent.mm.plugin.backup.g.b.UT();
        com.tencent.mm.plugin.backup.b.b.a(r0);
        r0 = com.tencent.mm.plugin.backup.g.b.UP();
        com.tencent.mm.plugin.backup.b.b.a(r0);
        r0 = 2;
        com.tencent.mm.plugin.backup.b.b.setMode(r0);
        r1 = 0;
        r0 = 0;
        r3 = com.tencent.mm.platformtools.q.dqL;
        if (r3 == 0) goto L_0x00ed;
    L_0x005a:
        r1 = com.tencent.mm.platformtools.q.dqM;
        r0 = com.tencent.mm.platformtools.q.dqN;
    L_0x005e:
        r3 = com.tencent.mm.model.k.xF();
        r4 = r2.meG;
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x0083;
    L_0x006a:
        r1 = "MicroMsg.BakchatPcUsbService";
        r3 = "username not equal:self:%s, resp.acc:%s";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.model.k.xF();
        r4[r5] = r6;
        r5 = 1;
        r6 = r2.meG;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.v.e(r1, r3, r4);
        r1 = 0;
    L_0x0083:
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r3 != 0) goto L_0x0114;
    L_0x0089:
        r3 = com.tencent.mm.plugin.backup.g.b.UP();
        r3.connect(r1, r0);
        r3 = new android.content.Intent;
        r4 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r5 = com.tencent.mm.plugin.backup.moveui.BakMoveNewUI.class;
        r3.<init>(r4, r5);
        r4 = "should_auth";
        r5 = 1;
        r3.putExtra(r4, r5);
        r4 = "WifiName";
        r5 = r2.meH;
        r3.putExtra(r4, r5);
        r4 = "DataSize";
        r6 = r2.eeK;
        r3.putExtra(r4, r6);
        r4 = "ip";
        r3.putExtra(r4, r1);
        r4 = "MicroMsg.BakchatPcUsbService";
        r5 = "WifiName %s, DataSize:%d, ip:%s, port:%d";
        r6 = 4;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = r2.meH;
        r6[r7] = r8;
        r7 = 1;
        r8 = r2.eeK;
        r2 = java.lang.Long.valueOf(r8);
        r6[r7] = r2;
        r2 = 2;
        r6[r2] = r1;
        r1 = 3;
        r0 = java.lang.Integer.valueOf(r0);
        r6[r1] = r0;
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
        r0 = 335544320; // 0x14000000 float:6.4623485E-27 double:1.65780921E-315;
        r3.addFlags(r0);
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r0.startActivity(r3);
    L_0x00e8:
        r10.stopSelf();
        goto L_0x002f;
    L_0x00ed:
        r3 = r2.meD;
        if (r3 <= 0) goto L_0x0109;
    L_0x00f1:
        r0 = r2.meE;
        r0 = r0.getFirst();
        r0 = (com.tencent.mm.protocal.c.li) r0;
        r1 = r0.mnP;
        r0 = r0.mnQ;
        r0 = r0.getFirst();
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        goto L_0x005e;
    L_0x0109:
        r3 = "MicroMsg.BakchatPcUsbService";
        r4 = "addr count is empty";
        com.tencent.mm.sdk.platformtools.v.e(r3, r4);
        goto L_0x005e;
    L_0x0114:
        r0 = new android.content.Intent;
        r1 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r2 = com.tencent.mm.plugin.backup.moveui.BakMoveErrUI.class;
        r0.<init>(r1, r2);
        r1 = "getConnectInfoErr";
        r2 = 1;
        r0.putExtra(r1, r2);
        r1 = 335544320; // 0x14000000 float:6.4623485E-27 double:1.65780921E-315;
        r0.addFlags(r1);
        r1 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1.startActivity(r0);
        goto L_0x00e8;
    L_0x0133:
        r0 = r10.eaR;
        if (r0 == 0) goto L_0x0147;
    L_0x0137:
        r0 = "MicroMsg.BakchatPcUsbService";
        r1 = "from wifi, reconnect";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        r0 = com.tencent.mm.plugin.backup.g.b.UJ();
        r0.Tz();
    L_0x0147:
        r0 = r10.eaR;
        if (r0 != 0) goto L_0x015e;
    L_0x014b:
        r0 = r2.efm;
        r1 = 1;
        if (r0 != r1) goto L_0x015e;
    L_0x0150:
        r0 = "MicroMsg.BakchatPcUsbService";
        r1 = "broast from usb but type is wifi, url may be fake!!!!";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        r10.stopSelf();
        goto L_0x002f;
    L_0x015e:
        r0 = com.tencent.mm.plugin.backup.g.b.UK();
        r1 = r2.meF;
        r3 = r2.meG;
        r0.aX(r1, r3);
        r0 = com.tencent.mm.plugin.backup.g.b.UK();
        com.tencent.mm.plugin.backup.b.b.a(r0);
        r0 = com.tencent.mm.plugin.backup.g.b.UJ();
        com.tencent.mm.plugin.backup.b.b.a(r0);
        r0 = 1;
        com.tencent.mm.plugin.backup.b.b.setMode(r0);
        r0 = com.tencent.mm.plugin.backup.g.b.UJ();
        r1 = r2.efm;
        r2 = r2.meE;
        r0.b(r1, r2);
        goto L_0x002f;
    L_0x0188:
        r0 = r10.ecK;
        if (r0 == 0) goto L_0x01af;
    L_0x018c:
        r0 = new android.content.Intent;
        r1 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r2 = com.tencent.mm.plugin.backup.moveui.BakMoveErrUI.class;
        r0.<init>(r1, r2);
        r1 = "getConnectInfoErr";
        r2 = 1;
        r0.putExtra(r1, r2);
        r1 = 335544320; // 0x14000000 float:6.4623485E-27 double:1.65780921E-315;
        r0.addFlags(r1);
        r1 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1.startActivity(r0);
        r10.stopSelf();
        goto L_0x002f;
    L_0x01af:
        r0 = com.tencent.mm.plugin.backup.g.b.UO();
        r1 = 2;
        r0.efK = r1;
        r0 = com.tencent.mm.plugin.backup.g.b.UO();
        r0.zR();
        r0 = 4;
        if (r11 != r0) goto L_0x01dc;
    L_0x01c0:
        r0 = -2011; // 0xfffffffffffff825 float:NaN double:NaN;
        if (r12 != r0) goto L_0x01dc;
    L_0x01c4:
        r0 = "MicroMsg.BakchatPcUsbService";
        r1 = "getConnect info: INVALID URL";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        r0 = r10.eaR;
        if (r0 == 0) goto L_0x01d1;
    L_0x01d1:
        com.tencent.mm.plugin.backup.g.b.UK();
        com.tencent.mm.plugin.backup.bakpcmodel.c.Ux();
        r10.stopSelf();
        goto L_0x002f;
    L_0x01dc:
        r0 = "MicroMsg.BakchatPcUsbService";
        r1 = "getConnect info other error";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        goto L_0x01d1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakpcmodel.BakchatPcUsbService.a(int, int, java.lang.String, com.tencent.mm.v.k):void");
    }
}
