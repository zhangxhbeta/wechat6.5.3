package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.view.LayoutInflater;
import com.tencent.mm.ar.l;
import com.tencent.mm.as.k;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.console.Shell;
import com.tencent.mm.e.a.ab;
import com.tencent.mm.e.a.hr;
import com.tencent.mm.e.a.jh;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.f.b;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.performance.wxperformancetool.d;
import com.tencent.mm.plugin.report.service.IKVReportNotify;
import com.tencent.mm.plugin.report.service.i;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ac.c;
import com.tencent.mm.storage.at;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI;
import com.tencent.mm.ui.tools.NewTaskUI;
import com.tencent.mm.v.t;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class WorkerProfile extends e implements ah, a, x, z, IKVReportNotify, com.tencent.mm.v.e, t.a {
    public static final String aQE = (aa.getPackageName());
    public static d aRK;
    private static WorkerProfile aRx;
    private u aRA;
    private boolean aRB;
    @Deprecated
    public boolean aRC;
    public boolean aRD;
    private int aRE = 0;
    private final int aRF = 0;
    private final int aRG = 1;
    private int aRH;
    private final int aRI = 2130706432;
    private StringBuilder aRJ = new StringBuilder();
    private g aRL;
    private b aRM;
    private final n aRN = new n();
    public final m aRO = new m();
    private final Shell aRs = new Shell();
    private final com.tencent.mm.console.a aRw = new com.tencent.mm.console.a();
    private com.tencent.mm.model.aa aRy;
    private c aRz;
    protected Locale locale;

    static /* synthetic */ boolean oM() {
        if (com.tencent.mm.ai.b.HC()) {
            return false;
        }
        com.tencent.mm.sdk.c.b pdVar = new pd();
        pdVar.bqt.bqv = true;
        com.tencent.mm.sdk.c.a.nhr.z(pdVar);
        return be.kS(pdVar.bqu.bqx);
    }

    public WorkerProfile() {
        aRx = this;
    }

    public static WorkerProfile oE() {
        return aRx;
    }

    public static void aj(boolean z) {
        if (aRK != null) {
            d dVar = aRK;
            if (dVar.dom != null) {
                com.tencent.mm.performance.wxperformancetool.c cVar = dVar.dom;
                if (cVar.dok != null && cVar.dok.isAlive()) {
                    com.tencent.mm.performance.wxperformancetool.b bVar = cVar.dok;
                    if (bVar.doh != z) {
                        bVar.doh = z;
                        bVar.mHandler.removeMessages(1);
                        if (!bVar.doh) {
                            bVar.mHandler.removeMessages(1);
                            bVar.mHandler.sendEmptyMessageDelayed(1, (long) com.tencent.mm.performance.wxperformancetool.b.dog);
                        }
                    }
                }
            }
        }
    }

    public final void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.kiss.a.b vH = com.tencent.mm.kiss.a.b.vH();
        Looper looper = com.tencent.mm.kiss.a.a.vG().clm.getLooper();
        LayoutInflater em = q.em(this.app);
        if (!vH.cls) {
            vH.cls = true;
            vH.CE = em;
            vH.clq = looper;
            vH.mMode = 2;
            vH.clr = new com.tencent.mm.kiss.a.b.AnonymousClass1(vH, vH.clq);
            vH.clu = new b(looper);
        }
        v.v("MicroMsg.WorkerProfile", "workerProfile onCreate, step 1");
        aRK = new d(aa.getContext());
        v.i("MicroMsg.WorkerProfile", "start time check onCreate proc:%s pid:%d" + aQE + Process.myPid());
        oG();
        final Context context = aa.getContext();
        com.tencent.mm.i.a.a anonymousClass21 = new com.tencent.mm.i.a.a() {
            final Map<String, Integer> aRX = new HashMap();
            final Map<String, Integer> map = new HashMap();

            public final String bt(String str) {
                if (this.map.containsKey(str)) {
                    return context.getString(((Integer) this.map.get(str)).intValue());
                }
                return null;
            }

            public final String bu(String str) {
                if (this.aRX.containsKey(str)) {
                    return context.getString(((Integer) this.aRX.get(str)).intValue());
                }
                return null;
            }
        };
        anonymousClass21.map.put("qqmail", Integer.valueOf(2131233252));
        anonymousClass21.map.put("fmessage", Integer.valueOf(2131233220));
        anonymousClass21.map.put("qmessage", Integer.valueOf(2131233248));
        anonymousClass21.map.put("qqsync", Integer.valueOf(2131233257));
        anonymousClass21.map.put("floatbottle", Integer.valueOf(2131233208));
        anonymousClass21.map.put("lbsapp", Integer.valueOf(2131233229));
        anonymousClass21.map.put("shakeapp", Integer.valueOf(2131233264));
        anonymousClass21.map.put("medianote", Integer.valueOf(2131233238));
        anonymousClass21.map.put("qqfriend", Integer.valueOf(2131233249));
        anonymousClass21.map.put("newsapp", Integer.valueOf(2131233260));
        anonymousClass21.map.put("facebookapp", Integer.valueOf(2131233214));
        anonymousClass21.map.put("masssendapp", Integer.valueOf(2131233235));
        anonymousClass21.map.put("meishiapp", Integer.valueOf(2131233241));
        anonymousClass21.map.put("feedsapp", Integer.valueOf(2131233217));
        anonymousClass21.map.put("voipapp", Integer.valueOf(2131233271));
        anonymousClass21.map.put("weixin", Integer.valueOf(2131234134));
        anonymousClass21.map.put("filehelper", Integer.valueOf(2131233204));
        anonymousClass21.map.put("cardpackage", Integer.valueOf(2131233211));
        anonymousClass21.map.put("officialaccounts", Integer.valueOf(2131233245));
        anonymousClass21.map.put("voicevoipapp", Integer.valueOf(2131233274));
        anonymousClass21.map.put("helper_entry", Integer.valueOf(2131233226));
        anonymousClass21.map.put("voiceinputapp", Integer.valueOf(2131233268));
        anonymousClass21.map.put("linkedinplugin", Integer.valueOf(2131233232));
        anonymousClass21.map.put("googlecontact", Integer.valueOf(2131233223));
        anonymousClass21.map.put("notifymessage", Integer.valueOf(2131233242));
        anonymousClass21.map.put("gh_43f2581f6fd6", Integer.valueOf(2131233267));
        anonymousClass21.map.put("appbrandcustomerservicemsg", Integer.valueOf(2131233205));
        anonymousClass21.aRX.put("weixin", Integer.valueOf(2131234133));
        com.tencent.mm.i.a.a(anonymousClass21);
        if (!f.sj()) {
            com.tencent.mm.plugin.report.service.g.iuh.a(340, com.tencent.mm.compatible.util.d.dW(19) ? 5 : 6, 1, false);
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(com.tencent.mm.compatible.util.d.dW(19) ? 5001 : 5002);
            objArr[1] = String.format("%s;%s;%s", new Object[]{com.tencent.mm.compatible.util.e.cni, Environment.getExternalStorageDirectory().getAbsolutePath(), h.getExternalStorageDirectory().getAbsolutePath()});
            gVar.h(11098, objArr);
        }
        v.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(this.aRC), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.aPW), Integer.valueOf(com.tencent.mm.protocal.d.lWh), be.ec(aa.getContext()));
        com.tencent.mm.bc.c.brO();
    }

    public final synchronized boolean oF() {
        return this.aRE == 2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int oG() {
        /*
        r14 = this;
        r13 = 8;
        r12 = 2;
        r11 = -1;
        r1 = 1;
        r2 = 0;
        r0 = "MicroMsg.WorkerProfile";
        r3 = "appOnCreate start appCreateStatus %d, getAccStg %b, thread name %s";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = r14.aRE;
        r5 = java.lang.Integer.valueOf(r5);
        r4[r2] = r5;
        r5 = java.lang.Boolean.valueOf(r1);
        r4[r1] = r5;
        r5 = java.lang.Thread.currentThread();
        r5 = r5.getName();
        r4[r12] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r0, r3, r4);
        r4 = java.lang.System.currentTimeMillis();
        monitor-enter(r14);
        r0 = r14.aRE;	 Catch:{ all -> 0x0755 }
        if (r0 != 0) goto L_0x0751;
    L_0x0033:
        r0 = 1;
        r14.aRE = r0;	 Catch:{ all -> 0x0755 }
        monitor-exit(r14);	 Catch:{ all -> 0x0755 }
        r0 = com.tencent.mm.app.WorkerProfile.class;
        r0 = r0.getClassLoader();
        r3 = "wechatnormsg";
        com.tencent.mm.compatible.util.k.b(r3, r0);
        com.tencent.mm.sdk.platformtools.MMBitmapFactory.init();
        r0 = new com.tencent.mm.app.WorkerProfile$1;
        r0.<init>(r14);
        com.tencent.mm.model.ak.a(r14, r0);
        r0 = com.tencent.mm.model.d.a.Aw();
        r3 = aQE;
        com.tencent.mm.model.d.a.aRj = r3;
        r3 = com.tencent.mm.sdk.platformtools.aa.niD;
        if (r3 == 0) goto L_0x0076;
    L_0x005a:
        r3 = com.tencent.mm.model.d.a.cwm;
        r3 = com.tencent.mm.loader.stub.b.deleteFile(r3);
        r6 = "MicroMsg.HandlerTraceManager";
        r7 = new java.lang.StringBuilder;
        r8 = "trace setup delete old file ret: ";
        r7.<init>(r8);
        r3 = r7.append(r3);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.v.i(r6, r3);
    L_0x0076:
        r6 = java.lang.System.currentTimeMillis();
        r0.cwC = r6;
        r3 = new com.tencent.mm.model.d.a$1;
        r3.<init>(r0);
        com.tencent.mm.sdk.platformtools.ac.setLogCallback(r3);
        r3 = "NetsceneQueue forbid in ";
        r6 = new com.tencent.mm.model.d.a$2;
        r6.<init>(r0);
        com.tencent.mm.sdk.platformtools.ag.a(r3, r6);
        r0 = com.tencent.mm.model.ak.vy();
        r0.a(r11, r14);
        com.tencent.mm.v.t.a(r14);
        r0 = com.tencent.mm.model.ak.yU();
        r0.cvC = r14;
        com.tencent.mm.model.ak.yP();
        com.tencent.mm.model.bm.cvu = r14;
        com.tencent.mm.model.ak.a(r14);
        r0 = new com.tencent.mm.app.WorkerProfile$12;
        r0.<init>(r14);
        com.tencent.mm.model.ak.a(r0);
        r0 = com.tencent.mm.model.ak.yU();
        r3 = "getkvidkeystg";
        r6 = new com.tencent.mm.app.WorkerProfile$23;
        r6.<init>(r14);
        r0.a(r3, r6, r1);
        r0 = r14.app;
        com.tencent.mm.sdk.platformtools.f.dE(r0);
        com.tencent.mm.sdk.platformtools.f.dF(r0);
        r3 = r0.getPackageManager();
        r0 = r0.getPackageName();	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r6 = 0;
        r0 = r3.getPackageInfo(r0, r6);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r0 = r0.applicationInfo;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r0.sourceDir;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r0 = "MicroMsg.WorkerProfile";
        r6 = "initChannelUtil sourceFile = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r8 = 0;
        r7[r8] = r3;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.v.i(r0, r6, r7);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r0 = com.tencent.mm.a.e.aQ(r3);	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        r6 = "MicroMsg.WorkerProfile";
        r7 = "checkApkExternal, fileSize = %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        r9 = 0;
        r10 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        r8[r9] = r10;	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        com.tencent.mm.sdk.platformtools.v.i(r6, r7, r8);	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        if (r0 >= r13) goto L_0x0758;
    L_0x00ff:
        r0 = com.tencent.mm.b.a.bb(r3);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        if (r0 == 0) goto L_0x07dd;
    L_0x0105:
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        if (r3 == 0) goto L_0x07dd;
    L_0x0109:
        r3 = "MicroMsg.WorkerProfile";
        r6 = "apk external info not null";
        com.tencent.mm.sdk.platformtools.v.i(r3, r6);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r3.aPW;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        if (r3 == 0) goto L_0x0127;
    L_0x0118:
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r3.aPW;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.f.aPW = r3;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = "MicroMsg.WorkerProfile";
        r6 = "read channelId from apk external";
        com.tencent.mm.sdk.platformtools.v.i(r3, r6);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
    L_0x0127:
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r3.aPY;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        if (r3 == 0) goto L_0x0148;
    L_0x012d:
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r3.aPY;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.f.aPY = r3;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = "MicroMsg.WorkerProfile";
        r6 = "ext.updateMode = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r8 = 0;
        r9 = com.tencent.mm.sdk.platformtools.f.aPY;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r7[r8] = r9;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.v.i(r3, r6, r7);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
    L_0x0148:
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r3.aPZ;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        if (r3 == 0) goto L_0x0159;
    L_0x014e:
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r3.aPZ;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r6 = 0;
        r3 = com.tencent.mm.sdk.platformtools.be.getInt(r3, r6);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.f.nhV = r3;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
    L_0x0159:
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r3.aQa;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        if (r3 == 0) goto L_0x0165;
    L_0x015f:
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r3.aQa;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.f.nhW = r3;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
    L_0x0165:
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r3.aPX;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        if (r3 == 0) goto L_0x0171;
    L_0x016b:
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r3.aPX;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.f.aPX = r3;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
    L_0x0171:
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r3.aQd;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        if (r3 == 0) goto L_0x0192;
    L_0x0177:
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r3.aQd;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.f.nia = r3;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = "MicroMsg.WorkerProfile";
        r6 = "ext.isNokiaol = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r8 = 0;
        r9 = com.tencent.mm.sdk.platformtools.f.nia;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r9 = java.lang.Boolean.valueOf(r9);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r7[r8] = r9;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.v.i(r3, r6, r7);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
    L_0x0192:
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r3.aQc;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        if (r3 == 0) goto L_0x01b3;
    L_0x0198:
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r3.aQc;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.f.aQc = r3;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = "MicroMsg.WorkerProfile";
        r6 = "ext.autoAddAccount = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r8 = 0;
        r9 = com.tencent.mm.sdk.platformtools.f.aQc;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r7[r8] = r9;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.v.i(r3, r6, r7);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
    L_0x01b3:
        r3 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r3 = r3.aQb;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        if (r3 == 0) goto L_0x01d4;
    L_0x01b9:
        r0 = r0.aPT;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r0 = r0.aQb;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.f.nhZ = r0;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r0 = "MicroMsg.WorkerProfile";
        r3 = "ext.shouldShowGprsAlert = %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r7 = 0;
        r8 = com.tencent.mm.sdk.platformtools.f.nhZ;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r8 = java.lang.Boolean.valueOf(r8);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r6[r7] = r8;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.v.i(r0, r3, r6);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
    L_0x01d4:
        com.tencent.mm.app.b.oe();
        r0 = r14.app;
        r0 = com.tencent.mm.booter.c.ao(r0);
        if (r0 == 0) goto L_0x01e7;
    L_0x01df:
        r3 = r0.bXJ;
        if (r3 == r11) goto L_0x01e7;
    L_0x01e3:
        r0 = r0.bXJ;
        com.tencent.mm.sdk.platformtools.f.aPW = r0;
    L_0x01e7:
        r0 = r14.app;
        r0 = r0.getApplicationContext();
        r3 = com.tencent.mm.sdk.platformtools.f.aPW;
        r6 = com.tencent.mm.protocal.d.lWh;
        if (r0 == 0) goto L_0x01f9;
    L_0x01f3:
        if (r3 < 0) goto L_0x01f9;
    L_0x01f5:
        r7 = 637534208; // 0x26000000 float:4.440892E-16 double:3.1498375E-315;
        if (r6 >= r7) goto L_0x080b;
    L_0x01f9:
        r0 = com.tencent.mm.sdk.platformtools.f.nhV;
        if (r0 <= 0) goto L_0x01ff;
    L_0x01fd:
        com.tencent.mm.sdk.platformtools.f.nhX = r1;
    L_0x01ff:
        com.tencent.mm.ay.c.brh();
        r3 = new java.lang.StringBuilder;
        r0 = "android-";
        r3.<init>(r0);
        r0 = com.tencent.mm.sdk.platformtools.f.aPX;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 == 0) goto L_0x083f;
    L_0x0212:
        r0 = android.os.Build.VERSION.SDK_INT;
        r0 = java.lang.Integer.valueOf(r0);
    L_0x0218:
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.tencent.mm.protocal.d.cmW = r0;
        r0 = com.tencent.mm.sdk.b.b.bsJ();
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x0242;
    L_0x022c:
        r0 = new java.lang.StringBuilder;
        r3 = "android-";
        r0.<init>(r3);
        r3 = com.tencent.mm.sdk.b.b.bsJ();
        r0 = r0.append(r3);
        r0 = r0.toString();
        com.tencent.mm.protocal.d.cmW = r0;
    L_0x0242:
        r0 = "MicroMsg.WorkerProfile";
        r3 = "set device type :%s  %s";
        r6 = new java.lang.Object[r12];
        r7 = com.tencent.mm.protocal.d.cmW;
        r6[r2] = r7;
        r7 = com.tencent.mm.sdk.b.b.bsJ();
        r6[r1] = r7;
        com.tencent.mm.sdk.platformtools.v.v(r0, r3, r6);
        r0 = r14.app;
        r0 = r0.getBaseContext();
        r0 = com.tencent.mm.ui.MMActivity.ed(r0);
        r14.locale = r0;
        r0 = r14.aRw;
        r1 = com.tencent.mm.sdk.c.a.nhr;
        r1.e(r0);
        r0 = new com.tencent.mm.app.a;
        r0.<init>();
        r1 = "MicroMsg.AvatarDrawable";
        r3 = new java.lang.StringBuilder;
        r6 = "setLoader";
        r3.<init>(r6);
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.v.d(r1, r3);
        com.tencent.mm.pluginsdk.ui.a.b.hXG = r0;
        r0 = new com.tencent.mm.app.WorkerProfile$20;
        r0.<init>(r14);
        com.tencent.mm.pluginsdk.j.a.lxI = r0;
        r0 = "hp";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "profile";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "setting";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "subapp";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "nearby";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "brandservice";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "favorite";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "scanner";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "shake";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "wallet";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "mall";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "voip";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "radar";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "sns";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "ext";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "accountsync";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "traceroute";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "qqmail";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "readerapp";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "talkroom";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "emoticon";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "sandbox";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "webview";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "bottle";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "masssend";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "emoji";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "qmessage";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "game";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "location";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "clean";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "chatroom";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "safedevice";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "card";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "search";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "exdevice";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "translate";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "location_soso";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "extqlauncher";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "nearlife";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "freewifi";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "pwdgroup";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "gallery";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "label";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "address";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "wxcredit";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "offline";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "recharge";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "wallet_index";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "order";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "product";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "remittance";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "collect";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "extaccessories";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "gai";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "backup";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "record";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "webwx";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "notification";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "gesture";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "voiceprint";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "wear";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "wallet_payu";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "luckymoney";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "fingerprint";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "ipcall";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "voip_cs";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "multitalk";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "soter";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "music";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "wenote";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "dbbackup";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "soter_mp";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "aa";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "sport";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "recovery";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "fps_lighter";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = "mmsight";
        r1 = r14.aRN;
        r3 = r14.aRO;
        com.tencent.mm.ay.c.a(r0, r1, r3);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.plugin.b.a$a;
        r1.<init>();
        r0.e(r1);
        r0 = new com.tencent.mm.booter.notification.b;
        r1 = r14.app;
        r0.<init>(r1);
        r14.aRy = r0;
        r0 = new com.tencent.mm.f.b;
        r0.<init>();
        r14.aRM = r0;
        r0 = r14.aRM;
        r1 = com.tencent.mm.sdk.c.a.nhr;
        r3 = r0.caz;
        r1.e(r3);
        r1 = new com.tencent.mm.e.a.pm;
        r1.<init>();
        r0.cav = r1;
        r1 = r0.cav;
        r1 = r1.bqO;
        r3 = "";
        r1.desc = r3;
        r1 = r0.cav;
        r1 = r1.bqO;
        r3 = "";
        r1.url = r3;
        r1 = r0.cav;
        r1 = r1.bqO;
        r1.aXx = r2;
        r1 = r0.cav;
        r1 = r1.bqO;
        r3 = 30;
        r1.aXw = r3;
        r1 = r0.cav;
        r1 = r1.bqO;
        r1.visible = r2;
        r1 = r0.cav;
        r1 = r1.bqO;
        r3 = "";
        r1.aXz = r3;
        r1 = r0.cav;
        r1 = r1.bqO;
        r1.aXy = r2;
        r0 = r0.cav;
        r0 = r0.bqO;
        r1 = 2130904082; // 0x7f030412 float:1.7415E38 double:1.0528065015E-314;
        r0.aXA = r1;
        r0 = r14.aRB;
        if (r0 == 0) goto L_0x0602;
    L_0x05fc:
        r0 = 0;
        r14.a(r0);
        r14.aRB = r2;
    L_0x0602:
        r0 = com.tencent.mm.kiss.a.b.vH();
        r1 = com.tencent.mm.sdk.c.a.nhr;
        r2 = new com.tencent.mm.kiss.a.b$2;
        r2.<init>(r0);
        r1.e(r2);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.ui.bindqq.a;
        r1.<init>();
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$25;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$26;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$27;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$28;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$29;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$30;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$2;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$3;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$4;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$5;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$6;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$7;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$8;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$9;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$10;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$11;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$13;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$14;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$15;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$16;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$17;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$18;
        r1.<init>(r14);
        r0.e(r1);
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r1 = new com.tencent.mm.app.WorkerProfile$19;
        r1.<init>(r14);
        r0.e(r1);
        r0 = new com.tencent.mm.ui.transmit.b;
        r0.<init>();
        com.tencent.mm.pluginsdk.j.a.lxO = r0;
        r0 = new com.tencent.mm.app.plugin.a;
        r0.<init>();
        com.tencent.mm.pluginsdk.j.a.lxU = r0;
        r0 = new com.tencent.mm.app.plugin.d;
        r0.<init>();
        com.tencent.mm.pluginsdk.j.a.lxV = r0;
        r0 = com.tencent.mm.app.plugin.e.oQ();
        com.tencent.mm.pluginsdk.j.a.lxW = r0;
        r0 = com.tencent.mm.model.ak.uG();
        if (r0 != 0) goto L_0x0724;
    L_0x0721:
        com.tencent.mm.model.ak.yW();
    L_0x0724:
        r0 = new com.tencent.mm.e.a.bo;
        r0.<init>();
        r1 = com.tencent.mm.sdk.c.a.nhr;
        r1.z(r0);
        monitor-enter(r14);
        r0 = 2;
        r14.aRE = r0;	 Catch:{ all -> 0x0843 }
        monitor-exit(r14);	 Catch:{ all -> 0x0843 }
        r0 = "MicroMsg.WorkerProfile";
        r1 = new java.lang.StringBuilder;
        r2 = "start time check WorkerProfile appOnCreate use time ";
        r1.<init>(r2);
        r2 = java.lang.System.currentTimeMillis();
        r2 = r2 - r4;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.d(r0, r1);
        r0 = r14.aRE;
    L_0x0750:
        return r0;
    L_0x0751:
        r0 = r14.aRE;	 Catch:{ all -> 0x0755 }
        monitor-exit(r14);	 Catch:{ all -> 0x0755 }
        goto L_0x0750;
    L_0x0755:
        r0 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x0755 }
        throw r0;
    L_0x0758:
        r6 = r0 + -8;
        r7 = 8;
        r6 = com.tencent.mm.a.e.d(r3, r6, r7);	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        r6 = com.tencent.mm.b.a.a.r(r6);	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        if (r6 != 0) goto L_0x079f;
    L_0x0766:
        r0 = "MicroMsg.WorkerProfile";
        r6 = "checkApkExternal, header null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r6);	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        goto L_0x00ff;
    L_0x0771:
        r0 = move-exception;
        r6 = "MicroMsg.WorkerProfile";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.v.a(r6, r0, r7, r8);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r6 = "MicroMsg.WorkerProfile";
        r7 = "Exception in checkApkExternal, %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r9 = 0;
        r0 = r0.getMessage();	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r8[r9] = r0;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.v.e(r6, r7, r8);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        goto L_0x00ff;
    L_0x0793:
        r0 = move-exception;
        r0 = "MicroMsg.WorkerProfile";
        r3 = "initChannelUtil NameNotFoundException";
        com.tencent.mm.sdk.platformtools.v.e(r0, r3);
        goto L_0x01d4;
    L_0x079f:
        r7 = r6.aPV;	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        r7 = r7 + 8;
        r7 = r7 + -8;
        if (r7 < 0) goto L_0x07d2;
    L_0x07a7:
        r7 = new com.tencent.mm.b.b;	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        r7.<init>();	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        r8 = r6.aPV;	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        r8 = r8 + 8;
        r8 = r8 + -8;
        r0 = r0 - r8;
        r0 = r0 + -8;
        r6 = r6.aPV;	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        r6 = r6 + 8;
        r6 = r6 + -8;
        r0 = com.tencent.mm.a.e.d(r3, r0, r6);	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        r7.az(r0);	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        r0 = new com.tencent.mm.b.a;	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        r0.<init>(r7);	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        r0 = "MicroMsg.WorkerProfile";
        r6 = "checkApkExternal, check ok";
        com.tencent.mm.sdk.platformtools.v.i(r0, r6);	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        goto L_0x00ff;
    L_0x07d2:
        r0 = "MicroMsg.WorkerProfile";
        r6 = "checkApkExternal header wrong";
        com.tencent.mm.sdk.platformtools.v.e(r0, r6);	 Catch:{ Exception -> 0x0771, NameNotFoundException -> 0x0793 }
        goto L_0x00ff;
    L_0x07dd:
        r3 = "MicroMsg.WorkerProfile";
        r6 = "initChannelUtil something null %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r8 = 0;
        if (r0 != 0) goto L_0x0809;
    L_0x07e9:
        r0 = r1;
    L_0x07ea:
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        r7[r8] = r0;	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r6, r7);	 Catch:{ NameNotFoundException -> 0x0793, Exception -> 0x07f5 }
        goto L_0x01d4;
    L_0x07f5:
        r0 = move-exception;
        r3 = "MicroMsg.WorkerProfile";
        r6 = "Exception in initChannel, %s";
        r7 = new java.lang.Object[r1];
        r0 = r0.getMessage();
        r7[r2] = r0;
        com.tencent.mm.sdk.platformtools.v.e(r3, r6, r7);
        goto L_0x01d4;
    L_0x0809:
        r0 = r2;
        goto L_0x07ea;
    L_0x080b:
        r7 = "crash_status_file";
        r8 = 4;
        r0 = r0.getSharedPreferences(r7, r8);	 Catch:{ Throwable -> 0x083c }
        r7 = "channel";
        r8 = -1;
        r7 = r0.getInt(r7, r8);	 Catch:{ Throwable -> 0x083c }
        r8 = "version";
        r9 = 0;
        r8 = r0.getInt(r8, r9);	 Catch:{ Throwable -> 0x083c }
        if (r7 != r3) goto L_0x0827;
    L_0x0825:
        if (r8 == r6) goto L_0x01f9;
    L_0x0827:
        r0 = r0.edit();	 Catch:{ Throwable -> 0x083c }
        r7 = "channel";
        r0.putInt(r7, r3);	 Catch:{ Throwable -> 0x083c }
        r3 = "version";
        r0.putInt(r3, r6);	 Catch:{ Throwable -> 0x083c }
        r0.commit();	 Catch:{ Throwable -> 0x083c }
        goto L_0x01f9;
    L_0x083c:
        r0 = move-exception;
        goto L_0x01f9;
    L_0x083f:
        r0 = com.tencent.mm.sdk.platformtools.f.aPX;
        goto L_0x0218;
    L_0x0843:
        r0 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x0843 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.WorkerProfile.oG():int");
    }

    public final void onTerminate() {
        super.onTerminate();
        com.tencent.mm.sdk.c.a.nhr.f(this.aRM.caz);
        this.aRM = null;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        String property = ba.getProperty("system_property_key_locale");
        if (property != null && property.length() > 0) {
            this.locale = new Locale(property);
        }
        synchronized (this) {
            if (oF()) {
                a(configuration);
                return;
            }
            this.aRB = true;
        }
    }

    private void a(Configuration configuration) {
        com.tencent.mm.sdk.platformtools.u.b(configuration);
        String property = ba.getProperty("system_property_key_locale");
        if (property != null && property.length() > 0) {
            if ("language_default".equalsIgnoreCase(property)) {
                this.locale = Locale.getDefault();
            } else {
                String[] split = property.split("_");
                if (split == null || split.length < 2) {
                    this.locale = new Locale(property);
                } else {
                    v.d("MicroMsg.WorkerProfile", "initLanguage arr.length = %s", Integer.valueOf(split.length));
                    this.locale = new Locale(split[0], split[1]);
                }
            }
        }
        Locale ed = MMActivity.ed(this.app.getBaseContext());
        v.d("MicroMsg.WorkerProfile", "onConfigurationChanged, locale = %s, n = %s, lang = %s", this.locale, ed, property);
        if (ed != null && this.locale != null && !ed.equals(this.locale)) {
            if (ak.uz()) {
                try {
                    com.tencent.mm.network.e eVar = ak.vy().cAa;
                    if (eVar != null) {
                        com.tencent.mm.network.c BU = eVar.BU();
                        if (BU != null) {
                            byte[] bArr = new byte[0];
                            ak.yW();
                            BU.i(bArr, com.tencent.mm.model.c.ww());
                        }
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.WorkerProfile", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.a("MicroMsg.WorkerProfile", e, "what the f$!k", new Object[0]);
                }
            }
            v.w("MicroMsg.WorkerProfile", "language changed, restart process");
            System.exit(-1);
        }
    }

    public final String toString() {
        return aQE;
    }

    public final com.tencent.mm.model.aa oH() {
        if (this.aRy == null) {
            this.aRy = new com.tencent.mm.booter.notification.b(this.app);
        }
        return this.aRy;
    }

    public final c oI() {
        if (this.aRz == null) {
            this.aRz = new c(this) {
                final /* synthetic */ WorkerProfile aRP;

                {
                    this.aRP = r1;
                }

                public final void a(at atVar, PString pString, PString pString2, PInt pInt, boolean z) {
                    com.tencent.mm.booter.notification.a.h.b(atVar, pString, pString2, pInt, z);
                }

                public final String a(int i, String str, String str2, int i2, Context context) {
                    return com.tencent.mm.booter.notification.a.h.a(i, str, str2, i2, context);
                }
            };
        }
        return this.aRz;
    }

    public final u oJ() {
        if (this.aRA == null) {
            this.aRA = new com.tencent.mm.booter.a();
        }
        return this.aRA;
    }

    public final Map<String, ag> oK() {
        Map<String, ag> hashMap = new HashMap();
        hashMap.put(n.class.getName(), new n());
        hashMap.put(com.tencent.mm.ae.n.class.getName(), new com.tencent.mm.ae.n());
        hashMap.put(com.tencent.mm.al.t.class.getName(), new com.tencent.mm.al.t());
        hashMap.put(p.class.getName(), new p());
        hashMap.put(l.class.getName(), new l());
        hashMap.put(k.class.getName(), new k());
        hashMap.put(m.class.getName(), new m());
        hashMap.put(com.tencent.mm.p.c.class.getName(), new com.tencent.mm.p.c());
        hashMap.put(j.class.getName(), new j());
        hashMap.put(am.class.getName(), new am());
        hashMap.put(i.class.getName(), new i());
        hashMap.put(com.tencent.mm.modelbiz.u.class.getName(), new com.tencent.mm.modelbiz.u());
        hashMap.put(com.tencent.mm.modelcdntran.g.class.getName(), new com.tencent.mm.modelcdntran.g());
        hashMap.put(com.tencent.mm.modelfriend.ah.class.getName(), new com.tencent.mm.modelfriend.ah());
        hashMap.put(o.class.getName(), new o());
        hashMap.put(com.tencent.mm.model.a.f.class.getName(), new com.tencent.mm.model.a.f());
        hashMap.put(com.tencent.mm.model.c.c.class.getName(), new com.tencent.mm.model.c.c());
        hashMap.put(com.tencent.mm.o.h.class.getName(), new com.tencent.mm.o.h());
        hashMap.put(com.tencent.mm.modelcontrol.c.class.getName(), new com.tencent.mm.modelcontrol.c());
        com.tencent.mm.ay.c.k("hp", hashMap);
        com.tencent.mm.ay.c.k("profile", hashMap);
        com.tencent.mm.ay.c.k("setting", hashMap);
        com.tencent.mm.ay.c.k("subapp", hashMap);
        com.tencent.mm.ay.c.k("sandbox", hashMap);
        com.tencent.mm.ay.c.k("nearby", hashMap);
        com.tencent.mm.ay.c.k("brandservice", hashMap);
        com.tencent.mm.ay.c.k("wallet_core", hashMap);
        com.tencent.mm.ay.c.k("wallet", hashMap);
        com.tencent.mm.ay.c.k("mall", hashMap);
        com.tencent.mm.ay.c.k("favorite", hashMap);
        com.tencent.mm.ay.c.k("scanner", hashMap);
        com.tencent.mm.ay.c.k("shake", hashMap);
        com.tencent.mm.ay.c.k("voip", hashMap);
        com.tencent.mm.ay.c.k("radar", hashMap);
        com.tencent.mm.ay.c.k("sns", hashMap);
        com.tencent.mm.ay.c.k("ext", hashMap);
        com.tencent.mm.ay.c.k("emoji", hashMap);
        com.tencent.mm.ay.c.k("emoticon", hashMap);
        com.tencent.mm.ay.c.k("accountsync", hashMap);
        com.tencent.mm.ay.c.k("qqmail", hashMap);
        com.tencent.mm.ay.c.k("readerapp", hashMap);
        com.tencent.mm.ay.c.k("talkroom", hashMap);
        com.tencent.mm.ay.c.k("game", hashMap);
        com.tencent.mm.ay.c.k("bottle", hashMap);
        com.tencent.mm.ay.c.k("masssend", hashMap);
        com.tencent.mm.ay.c.k("qmessage", hashMap);
        com.tencent.mm.ay.c.k("chatroom", hashMap);
        com.tencent.mm.ay.c.k("location", hashMap);
        com.tencent.mm.ay.c.k("clean", hashMap);
        com.tencent.mm.ay.c.k("safedevice", hashMap);
        com.tencent.mm.ay.c.k("card", hashMap);
        com.tencent.mm.ay.c.k("search", hashMap);
        com.tencent.mm.ay.c.k("translate", hashMap);
        com.tencent.mm.ay.c.k("extqlauncher", hashMap);
        com.tencent.mm.ay.c.k("nearlife", hashMap);
        com.tencent.mm.ay.c.k("webview", hashMap);
        com.tencent.mm.ay.c.k("exdevice", hashMap);
        com.tencent.mm.ay.c.k("freewifi", hashMap);
        com.tencent.mm.ay.c.k("freewifi", hashMap);
        com.tencent.mm.ay.c.k("pwdgroup", hashMap);
        com.tencent.mm.ay.c.k("gallery", hashMap);
        com.tencent.mm.ay.c.k("gesture", hashMap);
        com.tencent.mm.ay.c.k("wallet_payu", hashMap);
        com.tencent.mm.ay.c.k("label", hashMap);
        com.tencent.mm.ay.c.k("address", hashMap);
        com.tencent.mm.ay.c.k("wxcredit", hashMap);
        com.tencent.mm.ay.c.k("offline", hashMap);
        com.tencent.mm.ay.c.k("recharge", hashMap);
        com.tencent.mm.ay.c.k("order", hashMap);
        com.tencent.mm.ay.c.k("product", hashMap);
        com.tencent.mm.ay.c.k("wallet_index", hashMap);
        com.tencent.mm.ay.c.k("remittance", hashMap);
        com.tencent.mm.ay.c.k("collect", hashMap);
        com.tencent.mm.ay.c.k("backup", hashMap);
        com.tencent.mm.ay.c.k("record", hashMap);
        com.tencent.mm.ay.c.k("webwx", hashMap);
        com.tencent.mm.ay.c.k("notification", hashMap);
        com.tencent.mm.ay.c.k("extaccessories", hashMap);
        com.tencent.mm.ay.c.k("voiceprint", hashMap);
        com.tencent.mm.ay.c.k("wear", hashMap);
        com.tencent.mm.ay.c.k("auto", hashMap);
        com.tencent.mm.ay.c.k("gai", hashMap);
        com.tencent.mm.ay.c.k("nfc", hashMap);
        com.tencent.mm.ay.c.k("luckymoney", hashMap);
        com.tencent.mm.ay.c.k("tmassistant", hashMap);
        com.tencent.mm.ay.c.k("fingerprint", hashMap);
        com.tencent.mm.ay.c.k("nfc_open", hashMap);
        com.tencent.mm.ay.c.k("ipcall", hashMap);
        com.tencent.mm.ay.c.k("voip_cs", hashMap);
        com.tencent.mm.ay.c.k("f2f", hashMap);
        com.tencent.mm.ay.c.k("multitalk", hashMap);
        com.tencent.mm.ay.c.k("soter", hashMap);
        com.tencent.mm.ay.c.k("music", hashMap);
        com.tencent.mm.ay.c.k("wenote", hashMap);
        com.tencent.mm.ay.c.k("dbbackup", hashMap);
        com.tencent.mm.ay.c.k("soter_mp", hashMap);
        com.tencent.mm.ay.c.k("sl_warpgate", hashMap);
        com.tencent.mm.ay.c.k("aa", hashMap);
        com.tencent.mm.ay.c.k("sport", hashMap);
        com.tencent.mm.ay.c.k("fps_lighter", hashMap);
        com.tencent.mm.ay.c.k("appbrand", hashMap);
        com.tencent.mm.ay.c.k("recovery", hashMap);
        com.tencent.mm.ay.c.k("mmsight", hashMap);
        com.tencent.mm.sdk.c.a.nhr.z(new jh());
        v.i("MicroMsg.WorkerProfile", "publish on SubCore inited event.");
        return hashMap;
    }

    public final List<w> oL() {
        List<w> arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.y.d());
        arrayList.add(new com.tencent.mm.y.g());
        arrayList.add(new com.tencent.mm.y.e());
        arrayList.add(new com.tencent.mm.y.f());
        arrayList.add(new com.tencent.mm.y.a());
        arrayList.add(new com.tencent.mm.y.c());
        arrayList.add(new com.tencent.mm.y.i());
        arrayList.add(new com.tencent.mm.y.h());
        arrayList.add(new com.tencent.mm.y.b());
        Collection yD = w.a.yD();
        if (!be.bP(yD)) {
            arrayList.addAll(yD);
        }
        return arrayList;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.WorkerProfile", "onSceneEnd dkwt type:%d [%d,%d,%s]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 3 && i2 == -1) {
            v.i("MicroMsg.WorkerProfile", "getStack([ %s ]), ThreadID: %s", be.bur(), Long.valueOf(Thread.currentThread().getId()));
        }
        com.tencent.mm.sdk.c.b abVar;
        if (i == 4 && i2 == -3002) {
            if (be.kS(str)) {
                v.e("MicroMsg.WorkerProfile", "-3002 but errMsg is null");
                return;
            }
            if (str.startsWith("autoauth_errmsg_")) {
                str = str.substring(16);
            }
            v.i("MicroMsg.WorkerProfile", "-3002 errStr:%s", str);
            abVar = new ab();
            abVar.aXt.type = 4;
            abVar.aXt.aXv = str;
            com.tencent.mm.sdk.c.a.nhr.z(abVar);
        } else if (ak.uz() && i == 4 && ((i2 == -6 || i2 == -310 || i2 == -311) && str != null && str.startsWith("autoauth_errmsg_"))) {
            if (NewTaskUI.bJr() == null) {
                r0 = new Intent();
                r0.setClass(aa.getContext(), NewTaskUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                aa.getContext().startActivity(r0);
            }
        } else if (i == 4 && i2 == -213) {
            abVar = new hr();
            abVar.bhA.status = 0;
            abVar.bhA.bhB = 3;
            com.tencent.mm.sdk.c.a.nhr.z(abVar);
            if (AccountDeletedAlphaAlertUI.bIQ() == null) {
                r0 = new Intent();
                r0.setClass(aa.getContext(), AccountDeletedAlphaAlertUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                r0.putExtra("errmsg", str);
                aa.getContext().startActivity(r0);
            }
        }
    }

    public final void onReportKVDataReady(byte[] bArr, final byte[] bArr2, final int i) {
        ad.o(new Runnable(this) {
            final /* synthetic */ WorkerProfile aRP;

            public final void run() {
                if (!ak.yN()) {
                    v.e("MicroMsg.WorkerProfile", "channel:" + i);
                    ak.vy().a(new com.tencent.mm.plugin.report.b.d(bArr2, i), 0);
                }
            }
        });
    }

    public final void br(String str) {
        com.tencent.mm.sdk.c.b abVar = new ab();
        abVar.aXt.type = 4;
        abVar.aXt.aXv = str;
        com.tencent.mm.sdk.c.a.nhr.z(abVar);
    }

    public final void bs(String str) {
        v.i("MicroMsg.WorkerProfile", "onReMoveNoticeId:%s", str);
        com.tencent.mm.sdk.c.b abVar = new ab();
        abVar.aXt.type = 1;
        abVar.aXt.aXv = str;
        com.tencent.mm.sdk.c.a.nhr.z(abVar);
    }
}
