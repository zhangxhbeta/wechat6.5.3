package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class UpdaterService extends Service {
    private static UpdaterService ngZ = null;
    static final long nhb = 1800000;
    private boolean cSL = false;
    Map<Integer, a> nha = new HashMap();
    private ah nhc = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ UpdaterService nhe;

        {
            this.nhe = r1;
        }

        public final boolean oU() {
            return !this.nhe.bsF();
        }
    }, true);
    private a nhd = null;

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    static final class a extends BroadcastReceiver {
        a() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (UpdaterService.bsE() != null) {
                UpdaterService bsE = UpdaterService.bsE();
                boolean isWifi = ak.isWifi(context);
                if (bsE.nha.size() > 0) {
                    for (a ir : bsE.nha.values()) {
                        ir.ir(isWifi);
                    }
                }
            }
        }
    }

    public static void cn() {
        v.i("MicroMsg.UpdaterService", "UpdaterService stopInstance()");
        if (ngZ != null) {
            ngZ.bsF();
        }
    }

    public static UpdaterService bsE() {
        return ngZ;
    }

    public void onCreate() {
        super.onCreate();
        v.i("MicroMsg.UpdaterService", "onCreate");
        c.e(hashCode(), this);
        ngZ = this;
        this.nha.put(Integer.valueOf(0), a.ngY);
        this.nha.put(Integer.valueOf(1), d.bso());
        this.nha.put(Integer.valueOf(2), d.bso());
        MMActivity.ed(this);
        this.nhc.ea(nhb);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.nhd = new a();
        registerReceiver(this.nhd, intentFilter);
    }

    public void onStart(Intent intent, int i) {
        v.i("MicroMsg.UpdaterService", "onStart intent = %s", intent);
        j(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        v.i("MicroMsg.UpdaterService", "onStartCommand intent = %s", intent);
        if (intent != null) {
            if (intent.getBooleanExtra("intent_extra_run_in_foreground", false)) {
                v.i("MicroMsg.UpdaterService", "runServiceInForground");
                startForeground(0, new Builder(this).setTicker("updater service running forground").setWhen(System.currentTimeMillis()).setContentTitle("Updater Service").setContentText("updater service running forground").setContentIntent(PendingIntent.getService(this, 0, new Intent(), 0)).getNotification());
                this.cSL = true;
            } else if (VERSION.SDK_INT < 18 && !this.cSL) {
                startForeground(-1314, new Notification());
                this.cSL = true;
            }
        }
        j(intent);
        return 2;
    }

    public void onDestroy() {
        v.i("MicroMsg.UpdaterService", "onDestroy");
        this.nhc.QI();
        if (this.nhd != null) {
            unregisterReceiver(this.nhd);
        }
        if (this.cSL) {
            stopForeground(true);
        }
        for (a onDestroy : this.nha.values()) {
            onDestroy.onDestroy();
        }
        this.nha.clear();
        ngZ = null;
        c.f(hashCode(), this);
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private void j(Intent intent) {
        if (intent != null) {
            v.i("MicroMsg.UpdaterService", "handleCommand, downloadType = %d", Integer.valueOf(intent.getIntExtra("intent_extra_download_type", 0)));
            a aVar = (a) this.nha.get(Integer.valueOf(r0));
            if (aVar != null) {
                v.i("MicroMsg.UpdaterService", "handleCommand ret = %b", Boolean.valueOf(aVar.R(intent)));
                if (!aVar.R(intent)) {
                    bsF();
                }
            }
        }
    }

    private boolean bsF() {
        if (this.nha.size() > 0) {
            for (a isBusy : this.nha.values()) {
                if (isBusy.isBusy()) {
                    v.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, dont stop, some download mgr still busy");
                    return false;
                }
            }
        }
        v.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, UpdaterService killed self");
        ad.g(new Runnable(this) {
            final /* synthetic */ UpdaterService nhe;

            {
                this.nhe = r1;
            }

            public final void run() {
                if (this.nhe.nha.size() > 0) {
                    for (a isBusy : this.nhe.nha.values()) {
                        if (isBusy.isBusy()) {
                            v.i("MicroMsg.UpdaterService", "checkAndTryStopSelf2, dont stop, some download mgr still busy");
                            return;
                        }
                    }
                }
                if (com.tencent.mm.pluginsdk.model.v.a.bnb()) {
                    v.i("TBSDownloadMgr", "is still busy");
                } else {
                    this.nhe.stopSelf();
                }
            }
        }, 10000);
        return true;
    }
}
