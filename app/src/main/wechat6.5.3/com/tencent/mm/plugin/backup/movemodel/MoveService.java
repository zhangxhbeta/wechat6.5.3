package com.tencent.mm.plugin.backup.movemodel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.plugin.backup.moveui.BakMoveErrUI;
import com.tencent.mm.plugin.backup.moveui.BakMoveNewUI;
import com.tencent.mm.protocal.c.li;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class MoveService extends Service implements e {
    private boolean ecK = true;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        v.i("summerbak.MicroMsg.MoveService", "onCreate()");
        super.onCreate();
        ak.vy().a(595, (e) this);
        b.a(1, (e) this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        v.i("summerbak.MicroMsg.MoveService", "onStartCommand()");
        if (intent == null) {
            v.w("summerbak.MicroMsg.MoveService", "onStartCommand intent is null");
        } else {
            String stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            if (be.kS(stringExtra)) {
                v.e("summerbak.MicroMsg.MoveService", "onStartCommand url is null");
                stopSelf();
            } else {
                v.i("summerbak.MicroMsg.MoveService", "Broadcast url:%s, isMove:%b", stringExtra, Boolean.valueOf(this.ecK));
                ak.vy().a(new i(stringExtra), 0);
                b.b(1, this);
            }
        }
        return 2;
    }

    public void onDestroy() {
        ak.vy().b(595, (e) this);
        b.b(1, this);
        super.onDestroy();
        v.i("summerbak.MicroMsg.MoveService", "onDestroy" + Thread.currentThread().getName());
    }

    public final void a(int i, int i2, String str, k kVar) {
        Intent className;
        if (kVar instanceof b) {
            if (kVar.getType() == 1 && i == 0 && i2 == 0) {
                className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                startActivity(className);
            }
            stopSelf();
        } else if (!(kVar instanceof i)) {
        } else {
            if (i == 0 && i2 == 0) {
                vb WC = ((i) kVar).WC();
                b.a(com.tencent.mm.plugin.backup.g.b.UT());
                b.a(com.tencent.mm.plugin.backup.g.b.UP());
                b.setMode(2);
                String str2 = null;
                int i3 = 0;
                if (q.dqL) {
                    str2 = q.dqM;
                    i3 = q.dqN;
                } else if (WC.meD > 0) {
                    li liVar = (li) WC.meE.getFirst();
                    str2 = liVar.mnP;
                    i3 = ((Integer) liVar.mnQ.getFirst()).intValue();
                } else {
                    v.e("summerbak.MicroMsg.MoveService", "addr count is empty");
                }
                if (!com.tencent.mm.model.k.xF().equals(WC.meG)) {
                    v.e("summerbak.MicroMsg.MoveService", "username not equal:self:%s, resp.acc:%s", com.tencent.mm.model.k.xF(), WC.meG);
                    str2 = null;
                }
                if (be.kS(str2)) {
                    className = new Intent(aa.getContext(), BakMoveErrUI.class);
                    className.putExtra("getConnectInfoErr", true);
                    className.addFlags(335544320);
                    aa.getContext().startActivity(className);
                } else {
                    com.tencent.mm.plugin.backup.g.b.UP().connect(str2, i3);
                    Intent intent = new Intent(aa.getContext(), BakMoveNewUI.class);
                    intent.putExtra("should_auth", true);
                    intent.putExtra("WifiName", WC.meH);
                    intent.putExtra("DataSize", WC.eeK);
                    intent.putExtra("ip", str2);
                    v.i("summerbak.MicroMsg.MoveService", "WifiName %s, DataSize:%d, ip:%s, port:%d", WC.meH, Long.valueOf(WC.eeK), str2, Integer.valueOf(i3));
                    intent.addFlags(335544320);
                    aa.getContext().startActivity(intent);
                }
                stopSelf();
                return;
            }
            className = new Intent(aa.getContext(), BakMoveErrUI.class);
            className.putExtra("getConnectInfoErr", true);
            className.addFlags(335544320);
            aa.getContext().startActivity(className);
            stopSelf();
        }
    }
}
