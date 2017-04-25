package com.tencent.mm.plugin.backup.backupmodel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.bakpcmodel.a;
import com.tencent.mm.plugin.backup.bakpcmodel.c;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BackupUSBService extends Service implements e {
    private boolean eaR = false;
    private int eaS = -1;

    public IBinder onBind(Intent intent) {
        v.i("MicroMsg.BackupUSBService", "onBind()");
        return null;
    }

    public void onCreate() {
        v.i("MicroMsg.BackupUSBService", "onCreate()");
        super.onCreate();
        ak.vy().a(595, (e) this);
        b.a(1, (e) this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 1;
        v.i("MicroMsg.BackupUSBService", "onStartCommand() scene：%d", Integer.valueOf(this.eaS));
        if (intent == null) {
            v.w("MicroMsg.BackupUSBService", "onStartCommand intent is null");
        } else {
            String stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            if (be.kS(stringExtra)) {
                v.e("MicroMsg.BackupUSBService", "onStartCommand url is null");
                stopSelf();
            } else {
                this.eaR = intent.getBooleanExtra("isFromWifi", false);
                v.i("MicroMsg.BackupUSBService", "Broadcast url:%s, isFromWifi:%b", stringExtra, Boolean.valueOf(this.eaR));
                com.tencent.mm.plugin.backup.g.b.UO().zR();
                a UO = com.tencent.mm.plugin.backup.g.b.UO();
                if (this.eaR) {
                    i3 = 2;
                }
                UO.efJ = i3;
                if (ak.uN()) {
                    ak.vy().a(new i(stringExtra), 0);
                } else {
                    v.e("MicroMsg.BackupUSBService", "onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    startActivity(className);
                }
            }
        }
        return 2;
    }

    public void onDestroy() {
        ak.vy().b(595, (e) this);
        b.b(1, this);
        super.onDestroy();
        v.i("MicroMsg.BackupUSBService", "onDestroy thread:" + Thread.currentThread().getName());
    }

    private boolean TC() {
        return this.eaS == 0 || this.eaS == 1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.BackupUSBService";
        String str3 = "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = kVar == null ? SQLiteDatabase.KeyEmpty : kVar.getClass().getSimpleName();
        objArr[4] = Integer.valueOf(this.eaS);
        v.i(str2, str3, objArr);
        if (kVar instanceof b) {
            v.d("MicroMsg.BackupUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(this.eaS));
            if (kVar.getType() == 1 && i == 0 && i2 == 0) {
                boolean z;
                Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                str3 = "newPCBackup";
                if (TC()) {
                    z = false;
                } else {
                    z = true;
                }
                className.putExtra(str3, z);
                startActivity(className);
            }
            stopSelf();
        } else if (!(kVar instanceof i)) {
        } else {
            if (i == 0 && i2 == 0) {
                vb WC = ((i) kVar).WC();
                this.eaS = WC.maG;
                v.d("MicroMsg.BackupUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", Integer.valueOf(WC.efm), Integer.valueOf(WC.maG), Boolean.valueOf(this.eaR));
                if (!this.eaR && WC.efm == 1) {
                    v.e("MicroMsg.BackupUSBService", "broast from usb but type is wifi, url may be fake!!!!");
                    stopSelf();
                    return;
                } else if (TC()) {
                    com.tencent.mm.plugin.backup.g.b.UK().aX(WC.meF, WC.meG);
                    b.a(com.tencent.mm.plugin.backup.g.b.UK());
                    b.a(com.tencent.mm.plugin.backup.g.b.UJ());
                    b.setMode(1);
                    com.tencent.mm.plugin.backup.g.b.UJ().b(WC.efm, WC.meE);
                    return;
                } else {
                    v.d("MicroMsg.BackupUSBService", "summerbak onSceneEnd need todo for new scene:% ", Integer.valueOf(this.eaS));
                    return;
                }
            }
            com.tencent.mm.plugin.backup.g.b.UO().efK = 2;
            com.tencent.mm.plugin.backup.g.b.UO().zR();
            if (i == 4 && i2 == -2011) {
                v.i("MicroMsg.BackupUSBService", "getConnect info: INVALID URL");
            } else {
                v.i("MicroMsg.BackupUSBService", "getConnect info other error");
            }
            com.tencent.mm.plugin.backup.g.b.UK();
            c.Ux();
            stopSelf();
        }
    }
}
