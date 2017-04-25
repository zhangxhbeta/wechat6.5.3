package com.tencent.mm.modelfriend;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.e.a.hg;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.plugin.ipcall.d;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Random;

public final class AddrBookObserver extends ContentObserver {
    private static boolean cGA = false;
    private static Intent cGB;
    private static ac handler = new ac(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            Context context = (Context) message.obj;
            if (AddrBookObserver.cGB == null) {
                AddrBookObserver.cGB = new Intent();
                AddrBookObserver.cGB.setClass(context, AddrBookService.class);
            }
            AddrBookObserver.cGB.putExtra(AddrBookService.cGC, new Random(System.currentTimeMillis()).nextFloat());
            try {
                v.i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", Float.valueOf(new Random(System.currentTimeMillis()).nextFloat()));
                context.startService(AddrBookObserver.cGB);
            } catch (Throwable e) {
                v.a("MicroMsg.AddrBookObserver", e, "startService failed", new Object[0]);
            }
        }
    };
    private final Context context;

    public static class AddrBookService extends Service {
        public static boolean cGA = false;
        public static String cGC = "key_sync_session";
        public static boolean czH = false;
        private b cGD = new b(this) {
            final /* synthetic */ AddrBookService cGE;

            {
                this.cGE = r1;
            }

            public final void ba(boolean z) {
                if (z) {
                    System.currentTimeMillis();
                    ak.vy().a(new ac(m.Ff(), m.Fe()), 0);
                    this.cGE.stopSelf();
                    AddrBookService.cGA = false;
                    return;
                }
                v.v("MicroMsg.AddrBookObserver", "onSyncEnd not sync succ, do not upload");
                this.cGE.stopSelf();
                AddrBookService.cGA = false;
            }
        };

        public int onStartCommand(Intent intent, int i, int i2) {
            super.onStartCommand(intent, i, i2);
            String str = "MicroMsg.AddrBookObserver";
            String str2 = "service start intent:%b";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(intent == null);
            v.i(str, str2, objArr);
            if (intent == null) {
                v.e("MicroMsg.AddrBookObserver", "intent == null, stop service");
                stopSelf();
            } else {
                float floatExtra = intent.getFloatExtra(cGC, -1.0f);
                if (floatExtra == -1.0f) {
                    v.e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
                    stopSelf();
                } else {
                    SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences(aa.bti(), 0);
                    if (sharedPreferences.getFloat(cGC, 0.0f) == floatExtra) {
                        v.d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", Float.valueOf(sharedPreferences.getFloat(cGC, 0.0f)));
                        stopSelf();
                    } else {
                        sharedPreferences.edit().putFloat(cGC, floatExtra).commit();
                        v.d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", Float.valueOf(floatExtra));
                        if (czH) {
                            v.i("MicroMsg.AddrBookObserver", "service canceled");
                            czH = false;
                            stopSelf();
                        } else if (ak.yN()) {
                            v.e("MicroMsg.AddrBookObserver", "[onStartCommand] getCode is null, stop service");
                            stopSelf();
                        } else {
                            ak.yY();
                            try {
                                if (ak.uz()) {
                                    if (d.atT()) {
                                        a.nhr.z(new hg());
                                    }
                                    if (!m.Fb() || m.EX()) {
                                        v.e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
                                        stopSelf();
                                    } else {
                                        v.i("MicroMsg.AddrBookObserver", "start sync");
                                        if (com.tencent.mm.modelsimple.d.bb(this)) {
                                            v.e("MicroMsg.AddrBookObserver", "requestSync false, stop service");
                                            stopSelf();
                                        } else {
                                            cGA = true;
                                            a.a(this.cGD);
                                        }
                                    }
                                } else {
                                    v.i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
                                    stopSelf();
                                }
                            } catch (Throwable e) {
                                v.a("MicroMsg.AddrBookObserver", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                v.e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", e.getMessage());
                                stopSelf();
                            }
                        }
                    }
                }
            }
            return 2;
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }

    public AddrBookObserver(Context context) {
        super(ac.fetchFreeHandler());
        this.context = context;
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        v.i("MicroMsg.AddrBookObserver", "address book changed, start sync after 20 second");
        if (cGA) {
            v.e("MicroMsg.AddrBookObserver", "isSyncing:" + cGA + ", is time to sync:true , return");
            return;
        }
        handler.removeMessages(0);
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = this.context;
        obtainMessage.what = 0;
        handler.sendMessageDelayed(obtainMessage, 20000);
    }
}
