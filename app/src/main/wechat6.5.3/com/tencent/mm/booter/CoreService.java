package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mars.Mars;
import com.tencent.mars.comm.Alarm;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.comm.PlatformComm.IResetProcess;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mm.booter.MMReceivers.AlarmReceiver;
import com.tencent.mm.e.a.ll;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.ae;
import com.tencent.mm.network.l;
import com.tencent.mm.network.o;
import com.tencent.mm.network.s;
import com.tencent.mm.network.x;
import com.tencent.mm.network.z;
import com.tencent.mm.network.z.a;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.sdk.platformtools.y.b;
import com.tencent.mmdb.database.SQLiteDatabase;

public class CoreService extends Service implements IResetProcess, l, a {
    private int bXA = -1;
    private long bXB = 0;
    private long bXC = 0;
    private long bXD = 0;
    private WakerLock bXE = null;
    private f bXF = new f();
    private ah bXG = new ah(new ah.a(this) {
        final /* synthetic */ CoreService bXH;

        {
            this.bXH = r1;
        }

        public final boolean oU() {
            boolean z;
            f a = this.bXH.bXF;
            if (be.az(a.doO) < a.doM) {
                v.i("MicroMsg.FrequncyLimiter", "frequency limited, last=" + a.doO + ", cur=" + be.Nj() + ", retries=" + a.doP);
                if (a.doP <= 0) {
                    z = false;
                } else {
                    a.doP--;
                    a.doO = be.Nj();
                    z = true;
                }
            } else {
                a.doP = a.doN;
                a.doO = be.Nj();
                z = true;
            }
            if (z) {
                v.i("MicroMsg.CoreService", "setNetworkAvailable  deal with Sync Check isSessionKeyNull:%b, isMMProcessExist:%b", Boolean.valueOf(be.bl(this.bXH.bXw.dlt.uT())), Boolean.valueOf(z.Mx().Mh()));
                if (be.bl(this.bXH.bXw.dlt.uT()) || r3 || !f.a(1, 0, null, this.bXH.bXw.dlt.uT(), be.Ni())) {
                    CoreService.pV();
                } else {
                    v.i("MicroMsg.CoreService", "setNetworkAvailable deal with notify sync in push");
                    return true;
                }
            }
            v.e("MicroMsg.CoreService", "setNetworkAvailable checker frequency limited");
            v.i("MicroMsg.CoreService", "setNetworkAvailable finish lockCount:%d delayCount:%d delayDur:%d", Long.valueOf(this.bXH.bXB), Long.valueOf(this.bXH.bXD), Long.valueOf(be.Ni() - this.bXH.bXC));
            this.bXH.bXB = 0;
            this.bXH.bXD = 0;
            this.bXH.bXC = 0;
            new ah(new ah.a(this) {
                final /* synthetic */ AnonymousClass4 bXI;

                {
                    this.bXI = r1;
                }

                public final boolean oU() {
                    this.bXI.bXH.bXE.unLock();
                    return false;
                }
            }, false).ea(500);
            return true;
        }
    }, false);
    private s bXw;
    private e bXx = new e();
    private boolean bXy = true;
    private final b bXz = new b(this) {
        final /* synthetic */ CoreService bXH;

        {
            this.bXH = r1;
        }

        public final void prepare() {
            AlarmReceiver.ap(this.bXH.getApplicationContext());
        }

        public final void cancel() {
            AlarmReceiver.aq(this.bXH.getApplicationContext());
        }
    };

    public static class InnerService extends Service {
        public void onCreate() {
            super.onCreate();
            try {
                startForeground(-1213, new Notification());
            } catch (NullPointerException e) {
                v.e("MicroMsg.CoreService", "set service for push exception:%s.", e);
            }
            stopSelf();
        }

        public void onDestroy() {
            stopForeground(true);
            super.onDestroy();
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public void onCreate() {
        String str;
        NetworkInfo networkInfo = null;
        v.d("MicroMsg.CoreService", "onCreate~~~threadID:" + Thread.currentThread());
        super.onCreate();
        if (VERSION.SDK_INT < 24) {
            if (VERSION.SDK_INT < 18) {
                startForeground(-1213, new Notification());
            } else if (getSharedPreferences("system_config_prefs", 4).getBoolean("set_service", false)) {
                startForeground(-1213, new Notification());
                startService(new Intent(this, InnerService.class));
                v.i("MicroMsg.CoreService", "set service for push.");
            }
        }
        ac acVar = new ac(Looper.getMainLooper());
        Mars.init(aa.getContext(), acVar);
        StnLogic.setCallBack(new ae());
        IPxxLogic.setCallBack(new o());
        com.tencent.mm.jni.a.a.ut();
        com.tencent.mm.sdk.c.a.nhr.e(new c<ll>(this) {
            final /* synthetic */ CoreService bXH;

            {
                this.bXH = r1;
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                String str = ((ll) bVar).bmP.bmQ;
                if (be.kS(str)) {
                    return false;
                }
                com.tencent.mm.plugin.report.b.itm.a(12900, str, true, false);
                return true;
            }
        });
        z.Mr();
        y.a(this.bXz);
        if (PlatformComm.resetprocessimp == null) {
            PlatformComm.resetprocessimp = this;
        }
        z.a(acVar);
        z.setContext(getApplicationContext());
        z.a(new com.tencent.mm.network.aa());
        z.a(new ab());
        z.a((a) this);
        z.a(new com.tencent.mm.network.v());
        this.bXw = z.Mx();
        if (this.bXw == null) {
            v.i("MicroMsg.CoreService", "autoAuth is null and new one");
            this.bXw = new s(z.Mv());
            z.b(this.bXw);
        } else {
            v.w("MicroMsg.CoreService", "autoAuth is not null and reset");
            this.bXw.reset();
        }
        Mars.onCreate(true);
        if (z.My() == null) {
            v.i("MicroMsg.CoreService", "NetTaskAdapter is null and new one");
            z.a(new com.tencent.mm.network.y());
        } else {
            v.w("MicroMsg.CoreService", "NetTaskAdapter is not null and reset");
            z.My().reset();
        }
        if (z.Mz() == null) {
            v.i("MicroMsg.CoreService", "NetNotifyAdapter is null and new one");
            z.a(new x());
            z.Mz().dmm = this;
            if (z.MC()) {
                z.bn(false);
                z.Mv().post(new Runnable(this) {
                    final /* synthetic */ CoreService bXH;

                    {
                        this.bXH = r1;
                    }

                    public final void run() {
                        v.i("MicroMsg.CoreService", "NetNotifyAdapter NeedNotifyGCM after init");
                        z.Mz().onPush(2147480001, new byte[0]);
                    }

                    public final String toString() {
                        return "NotifyGCM";
                    }
                });
            }
        }
        com.tencent.mm.plugin.zero.a.a aVar = ((com.tencent.mm.plugin.zero.b) g.g(com.tencent.mm.plugin.zero.b.class)).lxo;
        this.bXw.c(aVar == null ? networkInfo : aVar.WR(), aVar == null ? networkInfo : aVar.WS(), aVar == null ? networkInfo : aVar.WT(), aVar == null ? networkInfo : aVar.WU());
        String WV = aVar == null ? networkInfo : aVar.WV();
        if (WV == null || !WV.contains(":")) {
            str = WV;
            Object obj = networkInfo;
        } else {
            String[] split = WV.split(":");
            str = split[0];
            WV = split[1];
        }
        this.bXw.setNewDnsDebugHost(str, WV);
        AlarmReceiver.as(getApplicationContext());
        AlarmReceiver.ar(getApplicationContext());
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable e) {
            v.a("MicroMsg.CoreService", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.CoreService", "getActiveNetworkInfo failed.");
        }
        if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
            z.Mt().dmF = false;
            z.Mu().gE(0);
        } else {
            z.Mt().dmF = true;
            z.Mu().gE(6);
        }
        if (((com.tencent.mm.plugin.zero.b) g.g(com.tencent.mm.plugin.zero.b.class)).lxn != null) {
            ((com.tencent.mm.plugin.zero.b) g.g(com.tencent.mm.plugin.zero.b.class)).lxn.a(this);
        }
        v.i("MicroMsg.CoreService", "CoreService OnCreate ");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int myPid = Process.myPid();
        v.i("MicroMsg.CoreService", "onStartCommand lastpid:%d  pid:%d flags:%d startId:%d", Integer.valueOf(this.bXA), Integer.valueOf(myPid), Integer.valueOf(i), Integer.valueOf(i2));
        if (myPid != this.bXA) {
            this.bXA = myPid;
            com.tencent.mm.plugin.report.b.itm.a(99, 141, 1, false);
            if (intent != null && "auto".equals(intent.getStringExtra("START_TYPE"))) {
                com.tencent.mm.plugin.report.b.itm.a(99, 140, 1, false);
            }
        }
        return 1;
    }

    public void onDestroy() {
        v.d("MicroMsg.CoreService", "onDestroy~~~ threadID:" + Thread.currentThread());
        if (((com.tencent.mm.plugin.zero.b) g.g(com.tencent.mm.plugin.zero.b.class)).lxn != null) {
            ((com.tencent.mm.plugin.zero.b) g.g(com.tencent.mm.plugin.zero.b.class)).lxn.b(this);
        }
        com.tencent.mm.jni.a.a.uu();
        super.onDestroy();
        pW();
    }

    public boolean onUnbind(Intent intent) {
        v.d("MicroMsg.CoreService", "onUnbind~~~ threadID:" + Thread.currentThread());
        z.Mt().dmE = null;
        z.MB().dmf = null;
        return super.onUnbind(intent);
    }

    public IBinder onBind(Intent intent) {
        v.d("MicroMsg.CoreService", "onBind~~~ threadID:" + Thread.currentThread());
        return this.bXw;
    }

    public void onRebind(Intent intent) {
        v.d("MicroMsg.CoreService", "onRebind~~~ threadID:" + Thread.currentThread());
        super.onRebind(intent);
    }

    public final boolean d(int i, byte[] bArr) {
        if (getSharedPreferences("system_config_prefs", 4).getBoolean("settings_fully_exit", true)) {
            v.i("MicroMsg.CoreService", "fully exited, no need to notify worker");
            return false;
        }
        int i2;
        if (i == -255) {
            i2 = 138;
        } else {
            i2 = i;
        }
        boolean z = z.Mq().getBoolean("is_in_notify_mode", false);
        boolean bl = be.bl(this.bXw.dlt.uT());
        boolean Mh = z.Mx().Mh();
        if (!(!z || bl || Mh)) {
            if (f.a(2, i2, bArr, this.bXw.dlt.uT(), be.Ni())) {
                v.i("MicroMsg.CoreService", "deal with notify sync in push");
                return true;
            }
        }
        v.i("MicroMsg.CoreService", "deal with notify sync to mm by broast, isSessionKeyNull:%b, isMMProcessExist:%b, isInNotifyMode:%b", Boolean.valueOf(bl), Boolean.valueOf(Mh), Boolean.valueOf(z));
        Intent intent = new Intent(this, NotifyReceiver.class);
        intent.putExtra("notify_option_type", 2);
        intent.putExtra("notify_uin", this.bXw.dlt.ww());
        intent.putExtra("notify_respType", i2);
        intent.putExtra("notify_respBuf", bArr);
        intent.putExtra("notfiy_recv_time", be.Ni());
        intent.putExtra("notify_skey", this.bXw.dlt.uT());
        v.i("MicroMsg.CoreService", "notify broadcast:" + intent.getAction() + ", type=" + i2);
        try {
            v.i("MicroMsg.CoreService", "notify broadcast: dknot recvTime:%d uin:%d type:%d buf:%d", Long.valueOf(intent.getLongExtra("notfiy_recv_time", 0)), Integer.valueOf(intent.getIntExtra("notify_uin", 0)), Integer.valueOf(intent.getIntExtra("notify_respType", 0)), Integer.valueOf(be.k(intent.getByteArrayExtra("notify_respBuf"), new byte[0]).length));
            sendBroadcast(intent);
        } catch (Throwable th) {
            v.e("MicroMsg.CoreService", "dknot sendBroadcast  failed:%s", be.e(th));
        }
        return true;
    }

    public final void ao(boolean z) {
        if (z) {
            v.w("MicroMsg.CoreService", "[NETWORK CONNECTED]");
            z.Mt().dmF = true;
            boolean pX = this.bXx.pX();
            if (!this.bXy || pX) {
                if (pX) {
                    z.Mx().LZ();
                }
                this.bXy = true;
                z.Mu().gE(6);
                if (this.bXE == null) {
                    this.bXE = new WakerLock(getApplicationContext());
                }
                if (!this.bXE.isLocking()) {
                    this.bXE.lock(6000, "CoreService.setNetworkAvailable");
                    this.bXB++;
                }
                if (0 == this.bXD) {
                    this.bXC = be.Ni();
                }
                this.bXD++;
                v.i("MicroMsg.CoreService", "setNetworkAvailable start lockCount:%d delayCount:%d delayDur:%d", Long.valueOf(this.bXB), Long.valueOf(this.bXD), Long.valueOf(be.Ni() - this.bXC));
                this.bXG.ea(3000);
                return;
            }
            v.i("MicroMsg.CoreService", "network not change or can't get network info, lastStatus connect:%b", Boolean.valueOf(this.bXy));
            return;
        }
        v.w("MicroMsg.CoreService", "[NETWORK LOST]");
        z.Mt().dmF = false;
        z.Mu().gE(0);
        if (this.bXy) {
            z.Mx().LZ();
            e eVar = this.bXx;
            eVar.bXS = null;
            eVar.bXT = null;
        }
        this.bXy = false;
    }

    public static void pV() {
        Intent intent = new Intent(z.getContext(), NotifyReceiver.class);
        intent.putExtra("notify_option_type", 1);
        intent.putExtra("notify_uin", z.Mx().dlt.ww());
        try {
            z.getContext().sendBroadcast(intent);
        } catch (Exception e) {
            v.f("MicroMsg.CoreService", "checker frequency limited hasDestroyed %s", e.toString());
        }
    }

    private void pW() {
        v.w("MicroMsg.CoreService", "[COMPLETE EXIT]");
        z.My().d(3, 10000, SQLiteDatabase.KeyEmpty);
        Mars.onDestroy();
        try {
            AlarmReceiver.as(getApplicationContext());
            AlarmReceiver.aq(getApplicationContext());
            Alarm.resetAlarm(getApplicationContext());
        } catch (Throwable e) {
            v.a("MicroMsg.CoreService", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        v.appenderClose();
        int myPid = Process.myPid();
        com.tencent.recovery.b.yH(13);
        Process.killProcess(myPid);
    }

    public void restartProcess() {
        v.w("MicroMsg.CoreService", "restartProcess");
        pW();
    }
}
