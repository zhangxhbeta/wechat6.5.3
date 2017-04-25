package com.tencent.mm.plugin.bbom;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.booter.MMReceivers.ExdeviceProcessReceiver;
import com.tencent.mm.booter.MMReceivers.SandBoxProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsProcessReceiver;
import com.tencent.mm.booter.d;
import com.tencent.mm.booter.d.c;
import com.tencent.mm.booter.x;
import com.tencent.mm.compatible.d.r;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.kernel.plugin.ProcessProfile;
import com.tencent.mm.kernel.plugin.b;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.model.n;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.plugin.f.a.a.h;
import com.tencent.mm.plugin.f.a.a.i;
import com.tencent.mm.plugin.f.a.a.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMAppMgr.Receiver;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteTrace;
import java.util.Map;

public class PluginBigBallOfMud extends b implements ApplicationLifeCycleBucket {
    private static final String TAG = "MicroMsg.PluginBigBallOfMud";
    public Application app;
    private final MMAppMgr appMgr = new MMAppMgr();
    private e mProfileCompat;

    public String toString() {
        return "plugin-big-ball-of-mud";
    }

    public void dependency() {
        dependsOn(a.class);
        dependsOn(com.tencent.mm.plugin.f.a.e.class);
    }

    public void configure(ProcessProfile processProfile) {
        String str;
        e eVar;
        int i;
        com.tencent.mm.plugin.report.b bVar = com.tencent.mm.plugin.report.b.itm;
        v.i("MicroMsg.ReportService", "instance set %s", g.iuh);
        bVar.itn = r3;
        ToolsProcessReceiver.a(new c());
        SandBoxProcessReceiver.a(new d.b());
        ExdeviceProcessReceiver.a(new d.a());
        com.tencent.mm.bg.e.a(new SQLiteTrace(this) {
            final /* synthetic */ PluginBigBallOfMud eoc;

            {
                this.eoc = r1;
            }

            public final void onSQLExecuted(SQLiteDatabase sQLiteDatabase, String str, int i, long j) {
                com.tencent.mm.model.d.b AD = com.tencent.mm.model.d.b.AD();
                String path = sQLiteDatabase.getPath();
                boolean isMainThread = ad.isMainThread();
                if ((j > AD.cwK && isMainThread) || (j > AD.cwM && !isMainThread)) {
                    for (String str2 : com.tencent.mm.model.d.b.cwS) {
                        if (!isMainThread && path.contains(str2)) {
                            return;
                        }
                    }
                    if (i != 2 || !isMainThread || j >= AD.cwL) {
                        if (AD.cwp) {
                            v.i("MicroMsg.SQLTraceManager", "mark stop as file is full !");
                            return;
                        }
                        String toUpperCase = str.trim().toUpperCase();
                        if (toUpperCase.startsWith("INSERT") || toUpperCase.startsWith("UPDATE") || toUpperCase.startsWith("DELETE") || toUpperCase.startsWith("COMMIT") || toUpperCase.startsWith("SELECT")) {
                            if (toUpperCase.startsWith("INSERT")) {
                                toUpperCase = toUpperCase.substring(0, toUpperCase.indexOf("(", 0));
                            } else if (toUpperCase.startsWith("COMMIT")) {
                                toUpperCase = j > AD.cwN ? toUpperCase + "task:" + be.bur() : null;
                            }
                            if (toUpperCase.length() > 512) {
                                toUpperCase = toUpperCase.substring(0, 512) + "...";
                            }
                            if (!toUpperCase.trim().endsWith(";")) {
                                toUpperCase = toUpperCase + ";";
                            }
                        } else {
                            toUpperCase = null;
                        }
                        if (!be.kS(toUpperCase)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            com.tencent.mm.model.d.b.a("tid", String.valueOf(Thread.currentThread().getId()), stringBuilder);
                            com.tencent.mm.model.d.b.a("sql", toUpperCase, stringBuilder);
                            com.tencent.mm.model.d.b.a("lastTime", String.valueOf(j), stringBuilder);
                            com.tencent.mm.model.d.b.a("foreground", com.tencent.mm.sdk.b.b.foreground ? "1" : "0", stringBuilder);
                            com.tencent.mm.model.d.b.a("tname", Thread.currentThread().getName(), stringBuilder);
                            toUpperCase = stringBuilder.toString();
                            v.d("MicroMsg.SQLTraceManager", "SQL Trace mark : " + toUpperCase);
                            ak.vA().x(new com.tencent.mm.model.d.b.AnonymousClass3(AD, toUpperCase));
                        }
                    }
                }
            }

            public final void onDatabaseCorrupted(SQLiteDatabase sQLiteDatabase) {
                com.tencent.mm.model.d.b.AD();
                com.tencent.mm.model.d.b.gn(sQLiteDatabase.getPath());
            }
        });
        f fVar = (f) com.tencent.mm.kernel.g.g(f.class);
        fVar.a(new k());
        fVar.a(new i());
        fVar.a(new j());
        fVar.a(new e());
        fVar.a(new d(processProfile.application()));
        com.tencent.mm.aj.a.a.a("delchatroommember", new com.tencent.mm.aj.a.a() {
            public final com.tencent.mm.aj.a a(Map<String, String> map, at atVar) {
                return new com.tencent.mm.aj.d(map);
            }
        });
        com.tencent.mm.aj.a.a.a("NewXmlChatRoomAccessVerifyApplication", new com.tencent.mm.aj.a.a() {
            public final com.tencent.mm.aj.a a(Map<String, String> map, at atVar) {
                return new com.tencent.mm.aj.c(map, atVar);
            }
        });
        com.tencent.mm.aj.a.a.a("NewXmlChatRoomAccessVerifyApproval", new com.tencent.mm.aj.a.a() {
            public final com.tencent.mm.aj.a a(Map<String, String> map, at atVar) {
                return new com.tencent.mm.aj.b(map, atVar);
            }
        });
        au.a(new com.tencent.mm.plugin.f.a.a.e(this) {
            final /* synthetic */ PluginBigBallOfMud eoc;

            {
                this.eoc = r1;
            }

            public final String B(at atVar) {
                int i = (atVar.field_bizChatId == -1 || !com.tencent.mm.modelbiz.e.hC(atVar.field_talker)) ? 0 : 1;
                if (i == 0) {
                    return atVar.field_talker;
                }
                v.d(PluginBigBallOfMud.TAG, "mapNotifyInfo key:%s", atVar.field_talker + ":" + atVar.field_bizChatId);
                return atVar.field_talker + ":" + atVar.field_bizChatId;
            }
        });
        n.a(new n.a(this) {
            final /* synthetic */ PluginBigBallOfMud eoc;

            {
                this.eoc = r1;
            }

            public final boolean a(String str, String str2, PInt pInt) {
                if (!m.eD(str)) {
                    return false;
                }
                if (com.tencent.mm.modelbiz.e.hC(str)) {
                    if (com.tencent.mm.modelbiz.a.e.hT(str2)) {
                        pInt.value = 5;
                    } else {
                        pInt.value = 4;
                    }
                } else if (com.tencent.mm.modelbiz.e.hA(str)) {
                    pInt.value = 3;
                } else if (com.tencent.mm.modelbiz.e.hB(str)) {
                    pInt.value = 0;
                } else if (com.tencent.mm.modelbiz.e.hx(str)) {
                    pInt.value = 6;
                } else {
                    pInt.value = 7;
                }
                return true;
            }
        });
        v.i(TAG, "zero %s", fVar);
        com.tencent.mm.plugin.f.a.f.a(new j.a(this) {
            final /* synthetic */ PluginBigBallOfMud eoc;

            {
                this.eoc = r1;
            }

            public final j Xc() {
                return new l(true);
            }
        });
        i aVar = new com.tencent.mm.modelmulti.a();
        i.a.a(69, aVar);
        i.a.a(68, aVar);
        i.a.a(22, aVar);
        i.a.a(13, aVar);
        i.a.a(15, aVar);
        i.a.a(23, aVar);
        i.a.a(25, aVar);
        i.a.a(24, aVar);
        i.a.a(33, aVar);
        i.a.a(35, aVar);
        i.a.a(44, aVar);
        i.a.a(999999, aVar);
        i.a.a(53, aVar);
        i.a.a(204, aVar);
        com.tencent.mm.plugin.f.a.a.a(new c());
        com.tencent.mm.plugin.f.a.c.a(new g());
        com.tencent.mm.plugin.f.a.g.a(new m());
        aj.a(new a());
        h.a hVar = new h();
        ((h) com.tencent.mm.kernel.g.f(h.class)).a((com.tencent.mm.plugin.f.a.a.f) hVar);
        ((h) com.tencent.mm.kernel.g.f(h.class)).a(hVar);
        com.tencent.mm.model.e.a(new b());
        this.app = processProfile.application();
        com.tencent.mm.kernel.g.vx();
        if (com.tencent.mm.kernel.d.b(com.tencent.mm.kernel.g.vt().uZ())) {
            com.tencent.mm.permission.b bVar2 = new com.tencent.mm.permission.b();
        }
        com.tencent.mm.modelstat.d.b(this.app);
        v.i(TAG, "app.getResources() is:" + processProfile.application().getResources());
        aa.setResources(com.tencent.mm.be.a.a(processProfile.application().getResources(), processProfile.application()));
        autoScaleFontSize();
        r.rZ().a(new com.tencent.mm.app.plugin.a.b());
        com.tencent.mm.app.b.ac(this.app.getApplicationContext());
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.compatible.loader.f fVar2 = new com.tencent.mm.compatible.loader.f();
        Application application = this.app;
        String processName = processProfile.getProcessName();
        if (processName == null || processName.length() <= 0) {
            HandlerThread Lg = com.tencent.mm.sdk.i.e.Lg("ProfileFactoryImp_handlerThread");
            Lg.start();
            processName = (String) new az<String>(fVar2) {
                final /* synthetic */ f cfK;

                {
                    this.cfK = r4;
                }

                protected final /* synthetic */ Object run() {
                    return AnonymousClass1.sd();
                }

                private static String sd() {
                    while (true) {
                        String p = be.p(aa.getContext(), Process.myPid());
                        if (p != null) {
                            return p;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (Throwable e) {
                            v.a("MicroMsg.ProfileFactoryImpl", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                }
            }.c(new ac(Lg.getLooper()));
            Lg.getLooper().quit();
            str = processName;
        } else {
            str = processName;
        }
        if (str == null) {
            v.e("MicroMsg.ProfileFactoryImpl", "get process name failed, retry later");
            eVar = null;
        } else {
            aa.Kh(str);
            if (str.equals(aa.getPackageName())) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.WorkerProfile");
            } else if (str.equals(aa.getPackageName() + ":push")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.PusherProfile");
            } else if (str.equals(aa.getPackageName() + ":tools")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.ToolsProfile");
            } else if (str.equals(aa.getPackageName() + ":sandbox")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.SandBoxProfile");
            } else if (str.equals(aa.getPackageName() + ":exdevice")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.ExDeviceProfile");
            } else if (str.equals(aa.getPackageName() + ":TMAssistantDownloadSDKService")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.TMAssistantProfile");
            } else if (str.equals(aa.getPackageName() + ":nospace")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.NoSpaceProfile");
            } else if (str.equals(aa.getPackageName() + ":patch")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.PatchProfile");
            } else if (str.equals(aa.getPackageName() + ":recovery")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.RecoveryProfile");
            } else if (str.startsWith(aa.getPackageName() + ":appbrand")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.AppBrandProfile");
            } else {
                com.tencent.mm.sdk.b.b.r("MMApplication onCreate profile == null", "profile is null and initMMcore failed");
                eVar = null;
            }
            v.w("MicroMsg.ProfileFactoryImpl", "application started, profile = %s", str);
        }
        this.mProfileCompat = eVar;
        if (!(this.mProfileCompat == null || com.tencent.mm.kernel.d.b(processProfile))) {
            v.i(TAG, "before profile oncreate.");
            this.mProfileCompat.onCreate();
        }
        v.i(TAG, "after profile oncreate.");
        processProfile.setProfileCompat(this.mProfileCompat);
        SharedPreferences sharedPreferences = processProfile.application().getSharedPreferences("system_config_prefs", 0);
        if (sharedPreferences != null) {
            i = sharedPreferences.getInt("default_uin", 0);
        } else {
            i = 0;
        }
        v.i(TAG, "APPonCreate proc:%s time:%d (loader:%d) ueh:%d data[%s] sdcard[%s]", processProfile.getProcessName(), Long.valueOf(be.ay(MMApplicationLike.sAppStartTime)), Long.valueOf(be.ay(currentTimeMillis)), Integer.valueOf(i), t.cng, com.tencent.mm.compatible.util.e.cni);
        if (com.tencent.mm.kernel.d.b(processProfile)) {
            MMAppMgr mMAppMgr = this.appMgr;
            Context context = this.app;
            if (mMAppMgr.nFe == null) {
                mMAppMgr.nFe = new Receiver(mMAppMgr);
            }
            MMActivity.bzT();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mm.ui.ACTION_ACTIVE");
            intentFilter.addAction("com.tencent.mm.ui.ACTION_DEACTIVE");
            intentFilter.addAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
            intentFilter.addAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            intentFilter.addAction("MINIQB_OPEN_RET");
            context.registerReceiver(mMAppMgr.nFe, intentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
            com.tencent.mm.booter.r xVar = new x(com.tencent.mm.booter.c.ao(this.app));
            xVar.cR("MM");
            q.dqp = be.a(xVar.cS(".com.tencent.mm.debug.test.use_cdn_down_thumb"), false);
            q.dpx = be.a(xVar.cS(".com.tencent.mm.debug.test.display_errcode"), false);
            q.dpy = be.a(xVar.cS(".com.tencent.mm.debug.test.display_msgstate"), false);
            q.dpz = be.a(xVar.cS(".com.tencent.mm.debug.test.network.simulate_fault"), false);
            q.dpA = be.a(xVar.cS(".com.tencent.mm.debug.test.network.force_touch"), false);
            q.dpB = be.a(xVar.cS(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
            q.dpC = be.a(xVar.cS(".com.tencent.mm.debug.test.crashIsExit"), false);
            q.dqb = be.getInt(be.ah(xVar.getString(".com.tencent.mm.debug.datatransfer.times"), "0"), 0);
            q.dqc = be.getInt(be.ah(xVar.getString(".com.tencent.mm.debug.datatransfer.duration"), "0"), 0);
            q.dpE = be.a(xVar.cS(".com.tencent.mm.debug.test.album_drop_table"), false);
            q.dpF = be.a(xVar.cS(".com.tencent.mm.debug.test.album_dle_file"), false);
            q.dpG = be.a(xVar.cS(".com.tencent.mm.debug.test.album_show_info"), false);
            q.dpH = be.a(xVar.cS(".com.tencent.mm.debug.test.location_help"), false);
            q.dpK = be.a(xVar.cS(".com.tencent.mm.debug.test.force_soso"), false);
            q.dpL = be.a(xVar.cS(".com.tencent.mm.debug.test.simulatePostServerError"), false);
            q.dpM = be.a(xVar.cS(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
            q.dpN = be.a(xVar.cS(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
            q.dpQ = be.a(xVar.cS(".com.tencent.mm.debug.test.filterfpnp"), false);
            q.dpR = be.a(xVar.cS(".com.tencent.mm.debug.test.testForPull"), false);
            int a = be.a(xVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
            q.dpO = a;
            if (a != 4 && q.dpO > 0) {
                s.noe = q.dpO;
                v.e("MicroMsg.WorkerDebugger", "cdn thread num " + q.dpO);
            }
            q.dpP = be.a(xVar.cS(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
            q.dpS = be.ah(xVar.getString(".com.tencent.mm.debug.server.host.http"), SQLiteDatabase.KeyEmpty);
            q.dpT = be.ah(xVar.getString(".com.tencent.mm.debug.server.host.socket"), SQLiteDatabase.KeyEmpty);
            if (be.a(xVar.cS(".com.tencent.mm.debug.test.show_full_version"), false)) {
                com.tencent.mm.sdk.platformtools.f.nhX = true;
            }
            try {
                a = Integer.decode(xVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
                com.tencent.mm.protocal.d.uA(a);
                new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
            } catch (Exception e) {
                v.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                String string = xVar.getString(".com.tencent.mm.debug.log.setapilevel");
                if (!be.kS(string)) {
                    com.tencent.mm.protocal.d.cmW = "android-" + string;
                    com.tencent.mm.protocal.d.lWc = "android-" + string;
                    com.tencent.mm.protocal.d.lWe = string;
                    com.tencent.mm.sdk.b.b.JP(string);
                    new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.cmW).append(" ").append(com.tencent.mm.sdk.b.b.bsJ());
                }
            } catch (Exception e2) {
                v.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                currentTimeMillis = Long.decode(xVar.getString(".com.tencent.mm.debug.log.setuin")).longValue();
                new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.lWg).append(" new: ").append(currentTimeMillis);
                com.tencent.mm.protocal.d.lWg = currentTimeMillis;
            } catch (Exception e3) {
                v.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                xVar.mDebugger.bXJ = Integer.decode(xVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            } catch (Exception e4) {
                v.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                boolean a2 = be.a(xVar.cS(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean a3 = be.a(xVar.cS(".com.tencent.mm.debug.report.kvstat"), false);
                boolean a4 = be.a(xVar.cS(".com.tencent.mm.debug.report.clientpref"), false);
                boolean a5 = be.a(xVar.cS(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
                new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
            } catch (Exception e5) {
                v.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            q.dpW = be.a(xVar.cS(".com.tencent.mm.debug.test.update_test"), false);
            q.dpX = be.a(xVar.cS(".com.tencent.mm.debug.test.scan_save_image"), false);
            q.dpZ = be.a(xVar.cS(".com.tencent.mm.debug.test.shake_get_config_list"), false);
            q.dqa = be.a(xVar.cS(".com.tencent.mm.debug.test.shake_show_shaketv"), false);
            q.dqe = be.ah(xVar.getString(".com.tencent.mm.debug.jsapi.permission"), SQLiteDatabase.KeyEmpty);
            v.d("MicroMsg.WorkerDebugger", "Test.jsapiPermission = " + q.dqe);
            q.dqt = be.ah(xVar.getString(".com.tencent.mm.debug.cdn.front"), SQLiteDatabase.KeyEmpty);
            q.dqu = be.ah(xVar.getString(".com.tencent.mm.debug.cdn.zone"), SQLiteDatabase.KeyEmpty);
            q.dqv = be.ah(xVar.getString(".com.tencent.mm.debug.cdn.wifi_elt"), SQLiteDatabase.KeyEmpty);
            q.dqw = be.ah(xVar.getString(".com.tencent.mm.debug.cdn.nowifi_elt"), SQLiteDatabase.KeyEmpty);
            q.dqx = be.ah(xVar.getString(".com.tencent.mm.debug.cdn.ptl"), SQLiteDatabase.KeyEmpty);
            q.dqy = be.a(xVar.cS(".com.tencent.mm.debug.cdn.usestream"), false);
            q.dqz = be.a(xVar.cS(".com.tencent.mm.debug.cdn.onlysendetl"), false);
            q.dqA = be.a(xVar.cS(".com.tencent.mm.debug.cdn.onlysendptl"), false);
            q.dqC = be.a(xVar.cS(".com.tencent.mm.debug.cdn.enable_debug"), false);
            q.dqD = be.a(xVar.cS(".com.tencent.mm.debug.cdn.enable_conn_verify"), false);
            q.dqE = be.a(xVar.cS(".com.tencent.mm.debug.cdn.enable_video_redirect_oc"), false);
            q.dqL = be.a(xVar.cS(".com.tencent.mm.debug.bakmove_hardcode"), false);
            v.d("MicroMsg.WorkerDebugger", "Test.bakmove_hardcode = " + q.dqL);
            q.dqM = be.ah(xVar.getString(".com.tencent.mm.debug.bakmove_ip"), SQLiteDatabase.KeyEmpty);
            q.dqN = be.getInt(be.ah(xVar.getString(".com.tencent.mm.debug.bakmove_port"), "0"), 0);
            q.dqH = be.a(xVar.cS(".com.tencent.mm.debug.pagetrace.enable"), false);
            try {
                q.dqI = Integer.decode(xVar.getString(".com.tencent.mm.debug.pagetrace.count")).intValue();
            } catch (Exception e6) {
                v.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            if (q.dqI == 0) {
                q.dqI = 3000;
            }
            q.dri = be.a(xVar.cS(".com.tencent.mm.debug.disaster_ignore_interval"), false);
            q.drj = be.a(xVar.cS(".com.tencent.mm.debug.disaster_ignore_expire"), false);
            q.drk = be.a(xVar.cS(".com.tencent.mm.debug.disaster_ignore_remove"), false);
            q.dra = be.a(xVar.cS(".com.tencent.mm.debug.netscene_sniffer.enable_snapshot"), false);
            q.drc = be.ah(xVar.getString(".com.tencent.mm.debug.netscene_sniffer.snapshot_protocal"), SQLiteDatabase.KeyEmpty);
            q.drb = be.a(xVar.cS(".com.tencent.mm.debug.netscene_sniffer.enable_inject"), false);
            q.drd = be.ah(xVar.getString(".com.tencent.mm.debug.netscene_sniffer.inject_protocal"), SQLiteDatabase.KeyEmpty);
            ComponentName eb = be.eb(aa.getContext());
            if (eb != null && eb.getPackageName().equals(aa.getPackageName()) && eb.getClassName().equals(aa.btg())) {
                WorkerProfile.oE().aRC = true;
                WorkerProfile.oE().aRD = true;
                v.i(TAG, "start time check currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", eb.getPackageName(), eb.getClassName());
            } else {
                if (eb != null) {
                    v.i(TAG, "start time check onCreate appOnCreate currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", eb.getPackageName(), eb.getClassName());
                } else {
                    v.i(TAG, "start time check onCreate appOnCreate currentActivity == null");
                }
                if (!(eb == null || eb.getPackageName().equals(aa.getPackageName()))) {
                    WorkerProfile.oE().aRC = true;
                }
            }
            com.tencent.mm.kernel.a.b.a(new com.tencent.mm.plugin.d.e(), processProfile);
            com.tencent.mm.model.d.b.AD();
            com.tencent.mm.model.d.b.setup();
            AppLogic.setCallBack(new AppCallBack(aa.getContext()));
            SmcLogic.setCallBack(new com.tencent.mm.plugin.report.service.h());
            com.tencent.mm.plugin.report.service.h.iup = (WorkerProfile) this.mProfileCompat;
            k.b(com.tencent.mm.sdk.a.nhi, WorkerProfile.class.getClassLoader());
            BaseEvent.onCreate();
            SmcLogic.SetDebugFlag(com.tencent.mm.plugin.report.a.c.itp);
            com.tencent.mm.plugin.f.a.e eVar2 = (com.tencent.mm.plugin.f.a.e) com.tencent.mm.kernel.g.g(com.tencent.mm.plugin.f.a.e.class);
            com.tencent.mm.kernel.g.g(com.tencent.mm.plugin.zero.b.class);
            new com.tencent.mm.plugin.d.d().after(eVar2).before(this);
            new com.tencent.mm.plugin.d.f().after((com.tencent.mm.plugin.d.a) new com.tencent.mm.plugin.d.a().after((com.tencent.mm.plugin.d.c) new com.tencent.mm.plugin.d.c().after(eVar2).before(this)).before(this)).before(this);
            new com.tencent.mm.plugin.d.b().after(eVar2).before(this);
        }
        com.tencent.recovery.b.a(new com.tencent.mm.bc.e());
    }

    public void execute(ProcessProfile processProfile) {
        if (this.mProfileCompat != null && com.tencent.mm.kernel.d.b(processProfile)) {
            v.i(TAG, "before WorkerProfile oncreate.");
            this.mProfileCompat.onCreate();
        }
    }

    private void autoScaleFontSize() {
    }

    public void onTerminate() {
        v.i(TAG, "onTerminate(%s)", aa.getProcessName());
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onTerminate();
        }
        MMAppMgr mMAppMgr = this.appMgr;
        Context context = this.app;
        if (mMAppMgr.nFe != null) {
            context.unregisterReceiver(mMAppMgr.nFe);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onConfigurationChanged(configuration);
        }
        Resources resources = aa.getResources();
        if (resources instanceof com.tencent.mm.be.a) {
            ((com.tencent.mm.be.a) resources).brX();
        }
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        v.i(TAG, "onTrimMemory, level = %d, process = %s", Integer.valueOf(i), aa.getProcessName());
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onTrimMemory(i);
        }
    }

    public void onCreate() {
    }

    public void onBaseContextAttached(Context context) {
    }
}
