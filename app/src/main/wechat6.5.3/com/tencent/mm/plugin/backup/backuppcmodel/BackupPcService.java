package com.tencent.mm.plugin.backup.backuppcmodel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.backup.backupmodel.BackupUSBService;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BackupPcService extends Service {
    private boolean eaR = false;
    private boolean ecK = false;

    public void onCreate() {
        v.i("MicroMsg.BackupPcService", "onCreate.");
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        v.i("MicroMsg.BackupPcService", "onStartCommand.");
        if (intent == null) {
            v.w("MicroMsg.BackupPcService", "summerbak onStartCommand intent is null");
        } else {
            final String stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            if (be.kS(stringExtra)) {
                v.e("MicroMsg.BackupPcService", "summerbak onStartCommand url is null");
                stopSelf();
            } else if (stringExtra.contains("mm.gj.qq.com")) {
                v.i("MicroMsg.BackupPcService", "summerbak onStartCommand url from gj stop and start BackupUSBService");
                startService(new Intent(this, BackupUSBService.class).putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL)).putExtra("isFromWifi", true));
                stopSelf();
            } else {
                this.eaR = intent.getBooleanExtra("isFromWifi", false);
                this.ecK = intent.getBooleanExtra("isMove", false);
                v.i("MicroMsg.BackupPcService", "summerbak Broadcast url:%s, isFromWifi:%b, isMove:%b", stringExtra, Boolean.valueOf(this.eaR), Boolean.valueOf(this.ecK));
                if (this.ecK || ak.uN()) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ BackupPcService ecL;

                        public final void run() {
                            a UL = b.UL();
                            v.w("MicroMsg.BackupPcProcessMgr", "~~~~~~~~~~~~  start by url:%s", stringExtra);
                            ak.vy().a(595, UL.ebB);
                            ak.vy().a(new i(r1), 0);
                        }
                    });
                } else {
                    v.e("MicroMsg.BackupPcService", "summerbak onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    startActivity(className);
                }
            }
        }
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        v.i("MicroMsg.BackupPcService", "onDestroy thread:" + Thread.currentThread().getName());
    }
}
