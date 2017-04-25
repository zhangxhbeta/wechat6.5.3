package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.LocationManager;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.os.Process;
import android.provider.Settings.Secure;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.ae.n;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.as.k;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.cache.CacheService;
import com.tencent.mm.booter.p;
import com.tencent.mm.booter.z;
import com.tencent.mm.e.a.bw;
import com.tencent.mm.e.a.e;
import com.tencent.mm.e.a.ev;
import com.tencent.mm.e.a.hr;
import com.tencent.mm.e.a.le;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.om;
import com.tencent.mm.e.a.pl;
import com.tencent.mm.e.a.u;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelsimple.f;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j.al;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.d.d;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;

public final class MMAppMgr {
    private static long dNW;
    static StringBuffer nFc;
    long cZt;
    String nFd;
    public Receiver nFe;
    boolean nFf = false;
    boolean nFg = false;
    final ah nFh = new ah(new a(this) {
        final /* synthetic */ MMAppMgr nFj;

        {
            this.nFj = r1;
        }

        public final boolean oU() {
            String bf = be.bf(aa.getContext());
            if (bf == null || !bf.toLowerCase().startsWith(aa.getPackageName())) {
                v.i("MicroMsg.MMAppMgr", "onTimerExpired, kill tools process");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                aa.getContext().sendBroadcast(intent);
            } else {
                v.i("MicroMsg.MMAppMgr", "onTimerExpired, top activity belongs to mm, skip kill tools");
            }
            return false;
        }
    }, true);
    private final ah nFi = new ah(Looper.getMainLooper(), new a(this) {
        final /* synthetic */ MMAppMgr nFj;

        {
            this.nFj = r1;
        }

        public final boolean oU() {
            if (this.nFj.nFg == this.nFj.nFf) {
                v.d("MicroMsg.MMAppMgr", "status not changed, cur=" + this.nFj.nFg);
                return true;
            } else if (ak.yN()) {
                return false;
            } else {
                this.nFj.nFg = this.nFj.nFf;
                BaseEvent.onForeground(this.nFj.nFg);
                b kVar;
                if (this.nFj.nFg) {
                    v.w("MicroMsg.MMAppMgr", "[ACTIVATED MODE]");
                    WorkerProfile.aj(false);
                    ak.vy().aR(true);
                    if (!(!ak.uz() || ak.yZ() || ak.uG())) {
                        z zVar = z.bYz;
                        if (!zVar.hasInit) {
                            Map buX;
                            zVar.hasInit = true;
                            c Ls = com.tencent.mm.model.c.c.Au().Ls("100066");
                            if (Ls.isValid()) {
                                buX = Ls.buX();
                                zVar.bYG = t.getInt((String) buX.get("maxCacheCount"), 20);
                                zVar.bYH = t.getInt((String) buX.get("maxCacheHours"), 24);
                            }
                            Ls = com.tencent.mm.model.c.c.Au().Ls("100058");
                            if (Ls.isValid()) {
                                buX = Ls.buX();
                                zVar.bYI = t.getInt((String) buX.get("cacheLogCount"), 30);
                                zVar.bYJ = t.getInt((String) buX.get("maxCacheTime"), 10800);
                            }
                            v.i("MicroMsg.StayTimeReport", "initAbtestChattingArg appMaxCnt:%d, appMaxHour:%d, chattingMaxCnt:%d, chattingMaxSeconds:%d", Integer.valueOf(zVar.bYG), Integer.valueOf(zVar.bYH), Integer.valueOf(zVar.bYI), Integer.valueOf(zVar.bYJ));
                        }
                        f.be(true);
                        o.Ho().fP(3);
                        ak.vy().a(new i(), 0);
                        ak.vA().x(new Runnable(this) {
                            final /* synthetic */ AnonymousClass8 nFm;

                            {
                                this.nFm = r1;
                            }

                            public final void run() {
                                m.LB().run();
                                k.KY().run();
                                n.GF().run();
                                am.bnE().run();
                                if (ab.a.csd != null) {
                                    ab.a.csd.yH();
                                }
                                com.tencent.mm.sdk.c.a.nhr.z(new om());
                                ak.yW();
                                com.tencent.mm.model.c.wG().b(null);
                            }
                        });
                        bl.zQ().b(19, Integer.valueOf(1));
                        com.tencent.mm.aq.d JU = com.tencent.mm.aq.d.JU();
                        v.d("MicroMsg.SpeexUploadCore", "now pause speex uploader");
                        JU.cJw.en(true);
                        n.GJ().aR(true);
                        if (al.lyl != null) {
                            al.lyl.aZp();
                        }
                        kVar = new com.tencent.mm.e.a.k();
                        kVar.aWD.aWE = true;
                        com.tencent.mm.sdk.c.a.nhr.z(kVar);
                        com.tencent.mm.modelstat.n.gp(4);
                        com.tencent.mm.modelstat.n.gp(3);
                        com.tencent.mm.modelstat.n.bh(true);
                    }
                    ak.vy().aQ(false);
                    aa.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", false).commit();
                    if (this.nFj.nFh.btC()) {
                        return true;
                    }
                    this.nFj.nFh.QI();
                    return true;
                }
                v.w("MicroMsg.MMAppMgr", "[DEACTIVATED MODE]");
                WorkerProfile.aj(true);
                this.nFj.cZt = be.Nj();
                this.nFj.nFd = "desktop";
                kVar = new com.tencent.mm.e.a.k();
                kVar.aWD.aWE = false;
                com.tencent.mm.sdk.c.a.nhr.z(kVar);
                ak.vy().aR(false);
                if (ak.uz() && !ak.yZ()) {
                    boolean z;
                    com.tencent.mm.az.a.Io(com.tencent.mm.az.a.bri());
                    Looper.myQueue().addIdleHandler(new IdleHandler(com.tencent.mm.aq.d.JU()) {
                        final /* synthetic */ d daC;

                        {
                            this.daC = r1;
                        }

                        public final boolean queueIdle() {
                            if (ak.vy().foreground) {
                                v.w("MicroMsg.SpeexUploadCore", "skiped resume speex uploader, not foreground");
                            } else {
                                v.d("MicroMsg.SpeexUploadCore", "now resume speex uploader");
                                this.daC.cJw.en(false);
                            }
                            return false;
                        }
                    });
                    kVar = new le();
                    kVar.bmz.state = 0;
                    com.tencent.mm.sdk.c.a.nhr.z(kVar);
                    com.tencent.mm.sdk.c.a.nhr.z(new pl());
                    kVar = new com.tencent.mm.e.a.d();
                    kVar.aWo.aWp = false;
                    com.tencent.mm.sdk.c.a.nhr.z(kVar);
                    kVar = new lw();
                    kVar.bnb.aWr = false;
                    com.tencent.mm.sdk.c.a.nhr.z(kVar);
                    n.GJ().aR(false);
                    v.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod]");
                    ak.yW();
                    Object obj = com.tencent.mm.model.c.vf().get(327808, null);
                    if (obj == null) {
                        z = true;
                    } else if (be.kS(obj.toString())) {
                        z = true;
                    } else {
                        z = System.currentTimeMillis() - be.KM(obj.toString()) >= 604800000;
                    }
                    v.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod] needToStat:%s", String.valueOf(z));
                    if (z) {
                        try {
                            g.iuh.Y(11375, be.ma(Secure.getString(aa.getContext().getContentResolver(), "default_input_method")));
                            ak.yW();
                            com.tencent.mm.model.c.vf().set(327808, Long.valueOf(System.currentTimeMillis()));
                        } catch (Exception e) {
                            v.e("MicroMsg.MMAppMgr", "[oneliang][inputMethodStat]exception:" + e.getMessage());
                        }
                    }
                    kVar = new bw();
                    kVar.aZr.state = 0;
                    com.tencent.mm.sdk.c.a.nhr.z(kVar);
                    f.be(false);
                    com.tencent.mm.modelstat.n.bh(false);
                }
                if (!this.nFj.nFh.btC()) {
                    this.nFj.nFh.QI();
                }
                v.i("MicroMsg.MMAppMgr", "before kill tools, tools is running : %b", Boolean.valueOf(be.aZ(aa.getContext(), aa.getPackageName() + ":tools")));
                if (!be.aZ(aa.getContext(), aa.getPackageName() + ":tools")) {
                    return true;
                }
                this.nFj.nFh.ea(60000);
                return true;
            }
        }
    }, false);

    static class AnonymousClass11 implements OnDismissListener {
        final /* synthetic */ OnClickListener lhY;

        AnonymousClass11(OnClickListener onClickListener) {
            this.lhY = onClickListener;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            com.tencent.mm.sdk.platformtools.ab.Kj("show_wap_adviser");
            if (this.lhY != null) {
                this.lhY.onClick(dialogInterface, 0);
            }
        }
    }

    static class AnonymousClass13 implements OnClickListener {
        final /* synthetic */ Context val$context;

        AnonymousClass13(Context context) {
            this.val$context = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                this.val$context.startActivity(new Intent("android.settings.APN_SETTINGS"));
            } catch (Exception e) {
            }
        }
    }

    static class AnonymousClass9 implements OnClickListener {
        final /* synthetic */ int cSP;

        AnonymousClass9(int i) {
            this.cSP = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ak.yW();
            com.tencent.mm.model.c.vf().set(65, Integer.valueOf(this.cSP + 1));
        }
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class Receiver extends BroadcastReceiver {
        private MMAppMgr appMgr;

        public Receiver(MMAppMgr mMAppMgr) {
            this.appMgr = mMAppMgr;
        }

        private static boolean W(Intent intent) {
            if (intent.getBooleanExtra("process_is_mm", false) && intent.getIntExtra("process_id", 0) != Process.myPid()) {
                return false;
            }
            return true;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && !ak.yN() && !ak.uF()) {
                String action = intent.getAction();
                if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(action)) {
                    if (W(intent)) {
                        MMAppMgr.a(this.appMgr, intent, true);
                        this.appMgr.c(intent, true);
                        return;
                    }
                    v.w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()));
                } else if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(action)) {
                    if (W(intent)) {
                        p.qq();
                        MMAppMgr.a(this.appMgr, intent, false);
                        this.appMgr.c(intent, false);
                        if (MMAppMgr.nFc != null && MMAppMgr.nFc.length() > 800) {
                            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                                final /* synthetic */ Receiver nFn;

                                {
                                    this.nFn = r1;
                                }

                                public final void run() {
                                    MMAppMgr.bAk();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    v.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()));
                } else if ("com.tencent.mm.ui.ACTION_ABTEST".equals(action)) {
                    action = intent.getStringExtra("content");
                    if (be.kS(action)) {
                        v.i("MicroMsg.MMAppMgr", "dealWithClickTestCaseStream case id is null, broadcast should set this intent flag");
                    } else {
                        if (MMAppMgr.nFc == null) {
                            MMAppMgr.nFc = new StringBuffer(800);
                        }
                        MMAppMgr.nFc.append(action);
                        v.i("MicroMsg.MMAppMgr", "cpan content: %s", action);
                    }
                    if (MMAppMgr.nFc != null && MMAppMgr.nFc.length() > 800) {
                        new ac(Looper.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ Receiver nFn;

                            {
                                this.nFn = r1;
                            }

                            public final void run() {
                                MMAppMgr.bAk();
                            }
                        });
                    }
                } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE")) {
                    int intExtra;
                    if (intent.getBooleanExtra("intent_extra_is_silence_stat", false)) {
                        intExtra = intent.getIntExtra("intent_extra_opcode", 0);
                        v.d("MicroMsg.MMAppMgr", "silence_update_stat = " + intExtra);
                        if (ak.uz()) {
                            if (intExtra == 2) {
                                int intExtra2 = intent.getIntExtra("intent_extra_install_dialog_times", 0);
                                g.iuh.h(11147, Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                            } else {
                                g.iuh.h(11147, Integer.valueOf(intExtra));
                            }
                            if (intExtra == 4 && s.Ne() == 4) {
                                com.tencent.mm.pluginsdk.model.app.a bne = com.tencent.mm.pluginsdk.model.app.a.bne();
                                if (bne != null) {
                                    bne.bnh();
                                }
                            }
                        }
                    } else {
                        v.d("MicroMsg.MMAppMgr", "incremental_update = " + intent.getIntExtra("intent_extra_opcode", 0));
                        if (ak.uz()) {
                            g.iuh.h(10328, Integer.valueOf(intExtra));
                        }
                    }
                    long longExtra = intent.getLongExtra("intent_extra_flow_stat_upstream", 0);
                    long longExtra2 = intent.getLongExtra("intent_extra_flow_stat_downstream", 0);
                    boolean booleanExtra = intent.getBooleanExtra("intent_extra_flow_stat_is_wifi", false);
                    if (!ak.uz()) {
                        return;
                    }
                    if (longExtra != 0 || longExtra2 != 0) {
                        v.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", Long.valueOf(longExtra), Long.valueOf(longExtra2), Boolean.valueOf(booleanExtra));
                        if (booleanExtra) {
                            com.tencent.mm.modelstat.m.s((int) longExtra2, (int) longExtra, 0);
                        } else {
                            com.tencent.mm.modelstat.m.t((int) longExtra2, (int) longExtra, 0);
                        }
                    }
                } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP")) {
                    MMAppMgr.a(context, true);
                } else if (intent.getAction().equals("MINIQB_OPEN_RET")) {
                    com.tencent.mm.pluginsdk.ui.tools.a.Q(intent);
                } else {
                    v.e("MicroMsg.MMAppMgr", "unknown broadcast action");
                }
            }
        }
    }

    static /* synthetic */ void a(MMAppMgr mMAppMgr, Intent intent, boolean z) {
        String stringExtra = intent.getStringExtra("classname");
        if (be.kS(stringExtra)) {
            v.i("MicroMsg.MMAppMgr", "dealWithClickStream className is null, broadcast should set this intent flag");
            return;
        }
        stringExtra = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        com.tencent.mm.sdk.b.b.JO(stringExtra);
        if (nFc == null) {
            nFc = new StringBuffer(800);
            dNW = be.Nh();
            nFc.append("start:");
            nFc.append(be.Nh());
            nFc.append("|");
        }
        if (z) {
            if ("desktop".equals(mMAppMgr.nFd)) {
                nFc.append("desktop:");
                nFc.append(be.az(mMAppMgr.cZt) + 800);
                nFc.append("|");
            }
            mMAppMgr.cZt = be.Nj();
            mMAppMgr.nFd = stringExtra;
        } else {
            nFc.append(mMAppMgr.nFd + ":");
            nFc.append(be.az(mMAppMgr.cZt));
            nFc.append("|");
        }
        b eVar = new e();
        eVar.aWq.aWr = z;
        eVar.aWq.className = stringExtra;
        com.tencent.mm.sdk.c.a.nhr.z(eVar);
        v.i("MicroMsg.MMAppMgr", "dkact classname %s, isAcitvity %b", stringExtra, Boolean.valueOf(z));
    }

    public final void c(Intent intent, boolean z) {
        b leVar;
        String str;
        if (z) {
            com.tencent.mm.u.m.Bi();
            leVar = new le();
            leVar.bmz.state = 1;
            com.tencent.mm.sdk.c.a.nhr.z(leVar);
            leVar = new com.tencent.mm.e.a.d();
            leVar.aWo.aWp = true;
            com.tencent.mm.sdk.c.a.nhr.z(leVar);
            leVar = new lw();
            leVar.bnb.aWr = true;
            com.tencent.mm.sdk.c.a.nhr.z(leVar);
            leVar = new bw();
            leVar.aZr.state = 1;
            com.tencent.mm.sdk.c.a.nhr.z(leVar);
        }
        leVar = new ev();
        leVar.bdB.aWE = z;
        com.tencent.mm.sdk.c.a.nhr.z(leVar);
        this.nFf = z;
        String stringExtra = intent.getStringExtra("classname");
        if (be.kS(stringExtra)) {
            str = SQLiteDatabase.KeyEmpty;
        } else {
            str = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        }
        z zVar;
        if (z) {
            zVar = z.bYz;
            if (zVar.bYF == -1) {
                if (zVar.bYA.getInt(3, 0) == 0) {
                    zVar.bYA.setLong(1, t.Nh());
                }
                zVar.bYF = t.Nh();
                String str2 = "MicroMsg.StayTimeReport";
                String str3 = "onAppResume chatUser:%s, class:%s";
                Object[] objArr = new Object[2];
                objArr[0] = zVar.bYB == null ? "null" : zVar.bYB.bYK;
                objArr[1] = str;
                v.i(str2, str3, objArr);
                if (zVar.bYB != null) {
                    zVar.bYC = t.Nj();
                    if (str != null && str.contains("WebViewUI")) {
                        zVar.bYD = t.Nj();
                    }
                }
            }
        } else {
            zVar = z.bYz;
            if (zVar.bYF != -1) {
                stringExtra = ((String) zVar.bYA.get(2, SQLiteDatabase.KeyEmpty)) + zVar.bYF + "|" + t.Nh() + "#";
                zVar.bYA.set(2, stringExtra);
                int i = zVar.bYA.getInt(3, 0) + 1;
                zVar.bYA.setInt(3, i);
                v.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", Integer.valueOf(i), Long.valueOf(zVar.bYF), Long.valueOf(r4));
                zVar.bYF = -1;
                if (t.ax(zVar.bYA.getLong(1, 0)) > 3600 * ((long) zVar.bYH) || i > zVar.bYG) {
                    g.iuh.Y(13110, stringExtra);
                    v.i("MicroMsg.StayTimeReport", "report appStayTime:%s", stringExtra);
                    zVar.bYA.set(2, SQLiteDatabase.KeyEmpty);
                    zVar.bYA.setInt(3, 0);
                }
                if (zVar.bYB != null) {
                    a aVar = zVar.bYB;
                    aVar.time += t.az(zVar.bYC) / 1000;
                    if (str != null && str.contains("WebViewUI")) {
                        aVar = zVar.bYB;
                        aVar.bYO = (int) (((long) aVar.bYO) + (t.az(zVar.bYD) / 1000));
                    }
                    v.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", Long.valueOf(zVar.bYB.time));
                }
            }
        }
        this.nFi.ea(800);
    }

    public static void bAk() {
        StringBuffer stringBuffer = new StringBuffer(800);
        if (nFc == null) {
            nFc = stringBuffer;
            dNW = be.Nh();
            return;
        }
        String stringBuffer2 = nFc.toString();
        stringBuffer.append(Oa(stringBuffer2));
        nFc = stringBuffer;
        v.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", stringBuffer2);
        g.iuh.Y(10508, "1," + dNW + "," + stringBuffer2);
        dNW = be.Nh();
    }

    private static String Oa(String str) {
        int i = 0;
        int length = str.length() - 1;
        while (length >= 0) {
            if (str.charAt(length) == '|') {
                i++;
            }
            if (i == 3) {
                break;
            }
            length--;
        }
        return str.substring(length + 1);
    }

    public static void cancelNotification(String str) {
        ak.oH().cancelNotification(str);
    }

    public static void oz() {
        ak.oH().oz();
    }

    public static void bAl() {
        iX(true);
    }

    public static void iX(boolean z) {
        v.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), be.bur(), Boolean.valueOf(z));
        com.tencent.mm.plugin.report.b.c.j(2, 0, SQLiteDatabase.KeyEmpty);
        if (z) {
            Context context = aa.getContext();
            if (context != null) {
                context.stopService(new Intent(context, CoreService.class));
                context.stopService(new Intent(context, NotifyService.class));
                context.stopService(new Intent(context, CacheService.class));
                context.stopService(new Intent().setClassName(context, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"));
            }
        }
        com.tencent.mm.sdk.c.a.nhr.z(new u());
        b hrVar = new hr();
        hrVar.bhA.status = 0;
        hrVar.bhA.bhB = 2;
        com.tencent.mm.sdk.c.a.nhr.z(hrVar);
        bAk();
        if (z) {
            ak.dQ(be.bur().toString());
            ak.release();
        }
        v.appenderClose();
        BaseEvent.onSingalCrash(0);
        int myPid = Process.myPid();
        com.tencent.recovery.b.yH(13);
        Process.killProcess(myPid);
    }

    public static void ai(Context context) {
        a(context, true);
    }

    public static void a(Context context, boolean z) {
        com.tencent.mm.kernel.g.vx().ckJ.ah(z);
        BaseEvent.onSingalCrash(0);
        MMNativeJpeg.Destroy();
        p.oC();
        if (!(ak.vy() == null || ak.vy().cAa == null)) {
            ak.vy().cAa.aV(z);
        }
        Intent intent = new Intent().setClass(context, LauncherUI.class);
        intent.addFlags(67108864);
        intent.putExtra("absolutely_exit_pid", Process.myPid());
        intent.putExtra("kill_service", z);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }

    public static boolean oO() {
        if (com.tencent.mm.protocal.d.lWk) {
            return false;
        }
        if (!com.tencent.mm.ay.c.In("whatsnew")) {
            v.i("MicroMsg.MMAppMgr", "plugin cannot load");
            return false;
        } else if (com.tencent.mm.plugin.ipcall.d.atT()) {
            return true;
        } else {
            return false;
        }
    }

    public static void X(Activity activity) {
        com.tencent.mm.ay.c.b(activity, "whatsnew", ".ui.WhatsNewUI", new Intent(), 57005);
    }

    public static void ek(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(aa.bti(), 0);
        if (!sharedPreferences.getBoolean("Main_ShortCut", false)) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", context.getString(2131230721));
            intent.putExtra("duplicate", false);
            Parcelable intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(context.getPackageName(), aa.bth() + ".ui.LauncherUI"));
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, 2130838373));
            context.sendBroadcast(intent);
            Editor edit = sharedPreferences.edit();
            edit.putBoolean("Main_ShortCut", true);
            edit.commit();
        }
    }

    public static void d(final Activity activity) {
        final SharedPreferences sharedPreferences = activity.getSharedPreferences(aa.bti(), 0);
        boolean z = sharedPreferences.getBoolean("gprs_alert", true);
        com.tencent.mm.sdk.platformtools.f.nhY &= z;
        if (z) {
            View inflate = View.inflate(activity, 2130903776, null);
            final CheckBox checkBox = (CheckBox) inflate.findViewById(2131757426);
            Dialog a = com.tencent.mm.ui.base.g.a((Context) activity, false, null, inflate, activity.getString(2131231977), activity.getString(2131233718), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (checkBox.isChecked()) {
                        Editor edit = sharedPreferences.edit();
                        edit.putBoolean("gprs_alert", false);
                        edit.commit();
                    }
                    com.tencent.mm.sdk.platformtools.f.nhY = false;
                    dialogInterface.dismiss();
                    MMAppMgr.ek(activity);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    MMAppMgr.a(activity, true);
                }
            });
            if (a != null) {
                a.setOnCancelListener(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        activity.onKeyDown(4, new KeyEvent(0, 4));
                    }
                });
            }
        }
    }

    public static boolean a(Context context, int i, OnClickListener onClickListener, OnClickListener onClickListener2) {
        boolean z;
        View inflate = View.inflate(context, 2130904126, null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(2131758448);
        checkBox.setText(context.getString(2131234025));
        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(16385, Boolean.valueOf(!z));
            }
        });
        inflate.findViewById(2131758447).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(2131758446);
        switch (i) {
            case 1:
                textView.setText(2131234024);
                z = true;
                break;
            case 3:
                textView.setText(2131234032);
                z = false;
                break;
            default:
                textView.setText(2131234032);
                z = true;
                break;
        }
        if (!z) {
            return false;
        }
        h.a aVar = new h.a(context);
        aVar.wm(2131231164);
        aVar.jk(false);
        aVar.cC(inflate);
        aVar.wp(2131234029).a(onClickListener);
        aVar.wq(2131234025).b(onClickListener2);
        aVar.RX().show();
        return true;
    }

    public static h aj(final Context context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (com.tencent.mm.sdk.platformtools.ak.isWifi(context) && locationManager.isProviderEnabled("gps")) {
                return null;
            }
            ak.yW();
            Boolean bool = (Boolean) com.tencent.mm.model.c.vf().get(4105, Boolean.valueOf(false));
            if (bool != null && bool.booleanValue()) {
                return null;
            }
            View inflate = View.inflate(context, 2130903856, null);
            ((CheckBox) inflate.findViewById(2131757694)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(4105, Boolean.valueOf(true));
                        return;
                    }
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(4105, Boolean.valueOf(false));
                }
            });
            OnClickListener anonymousClass7 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    } catch (Throwable e) {
                        v.a("MicroMsg.MMAppMgr", e, "showLbsTipsAlert", new Object[0]);
                    }
                }
            };
            h.a aVar = new h.a(context);
            aVar.wm(2131234006);
            aVar.cC(inflate);
            aVar.wp(2131231153).a(anonymousClass7);
            aVar.wq(2131231078);
            h RX = aVar.RX();
            RX.show();
            return RX;
        } catch (Throwable e) {
            v.a("MicroMsg.MMAppMgr", e, "showLbsTipsAlert error", new Object[0]);
            return null;
        }
    }
}
