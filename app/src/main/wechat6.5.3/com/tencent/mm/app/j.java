package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.tencent.mm.ae.n;
import com.tencent.mm.al.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.d.b;
import com.tencent.mm.pluginsdk.j.ak;
import com.tencent.mm.pluginsdk.j.q.c;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.conversation.d;
import com.tencent.mm.ui.i;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.lang.reflect.Field;

public final class j {
    public static j aRo;
    public boolean aRp;
    public ac aRq = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ j aRr;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == -1999) {
                if (!this.aRr.aRp) {
                    LauncherUI bzB = LauncherUI.bzB();
                    if (bzB != null && bzB.nBh) {
                        Resources resources;
                        Field declaredField;
                        bzB.NX("tab_main");
                        if (bzB.nBh) {
                            bzB.nBo = true;
                            bzB.nBO.setBackgroundDrawable(null);
                            VoiceSearchLayout voiceSearchLayout = bzB.nBO;
                            voiceSearchLayout.lIP.setBackgroundDrawable(null);
                            voiceSearchLayout.lIT.setBackgroundDrawable(null);
                            voiceSearchLayout.lIU = null;
                        }
                        try {
                            resources = aa.getContext().getResources();
                            if (resources != null) {
                                declaredField = resources.getClass().getDeclaredField("mDrawableCache");
                                declaredField.setAccessible(true);
                                ((LongSparseArray) declaredField.get(resources)).clear();
                            }
                        } catch (Throwable e) {
                            v.a("MicroMsg.ActivityResourceRecycler", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                        try {
                            resources = aa.getContext().getResources();
                            if (resources != null) {
                                declaredField = resources.getClass().getDeclaredField("mColorStateListCache");
                                declaredField.setAccessible(true);
                                Object obj = declaredField.get(resources);
                                if (obj instanceof SparseArray) {
                                    ((SparseArray) obj).clear();
                                } else {
                                    ((LongSparseArray) obj).clear();
                                }
                            }
                        } catch (Throwable e2) {
                            v.a("MicroMsg.ActivityResourceRecycler", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                        try {
                            if (VERSION.SDK_INT >= 16) {
                                Resources resources2 = aa.getContext().getResources();
                                if (resources2 != null) {
                                    Field declaredField2 = resources2.getClass().getDeclaredField("mColorDrawableCache");
                                    declaredField2.setAccessible(true);
                                    ((LongSparseArray) declaredField2.get(resources2)).clear();
                                    declaredField2 = resources2.getClass().getDeclaredField("sPreloadedColorDrawables");
                                    declaredField2.setAccessible(true);
                                    ((LongSparseArray) declaredField2.get(resources2)).clear();
                                }
                            }
                        } catch (Throwable e22) {
                            v.a("MicroMsg.ActivityResourceRecycler", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                        c cVar = ak.lye;
                        if (cVar != null) {
                            cVar.aRT();
                        }
                        for (Fragment fragment : bzB.nCr.values()) {
                            if (!(fragment instanceof d)) {
                                ((i) fragment).byB();
                            }
                        }
                    }
                    System.gc();
                }
            } else if (message.what == -2999 && !this.aRr.aRp) {
                LauncherUI bzB2 = LauncherUI.bzB();
                if (bzB2 != null && bzB2.nCr.containsKey(Integer.valueOf(0))) {
                    ((i) bzB2.nCr.get(Integer.valueOf(0))).byB();
                }
                if (!g.vr()) {
                    com.tencent.mm.model.ak.yW();
                    if (com.tencent.mm.model.c.ww() != 0) {
                        ag fY = com.tencent.mm.model.ak.yP().fY("plugin.emoji");
                        if (fY != null) {
                            fY.ed(0);
                        }
                        if (((n) com.tencent.mm.model.ak.yP().fY(n.class.getName())) != null) {
                            n.GN();
                        }
                        a AD = b.AD();
                        a Aw = a.Aw();
                        com.tencent.mm.model.d.c AF = com.tencent.mm.model.d.c.AF();
                        com.tencent.mm.model.ak.vA().x(new Runnable(AD) {
                            final /* synthetic */ b cwT;

                            {
                                this.cwT = r1;
                            }

                            public final void run() {
                                File file = new File(b.cwJ + "MMSQL.trace");
                                if (file.exists()) {
                                    com.tencent.mm.model.ak.yW();
                                    if (com.tencent.mm.model.c.ww() == 0) {
                                        v.w("MicroMsg.SQLTraceManager", "acc not ready ");
                                        return;
                                    }
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long aI = b.aI(aa.getContext());
                                    boolean z = false;
                                    if (aI > currentTimeMillis) {
                                        z = true;
                                    } else if (currentTimeMillis - aI > 86400000) {
                                        z = true;
                                    } else if (currentTimeMillis - aI > this.cwT.cwQ && this.cwT.cwp) {
                                        z = true;
                                    }
                                    v.i("MicroMsg.SQLTraceManager", "check need upload ,file size is %d,time out  %b", Long.valueOf(file.length()), Boolean.valueOf(z));
                                    if (z && r2 > this.cwT.cwP) {
                                        b bVar = this.cwT;
                                        Context context = aa.getContext();
                                        String packageName = aa.getContext().getPackageName();
                                        try {
                                            PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context.getPackageManager(), new Object[]{packageName, new Stub(bVar) {
                                                final /* synthetic */ b cwT;

                                                {
                                                    this.cwT = r1;
                                                }

                                                public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                                                    this.cwT.cwn[0] = packageStats.cacheSize;
                                                    this.cwT.cwn[1] = packageStats.dataSize;
                                                    this.cwT.cwn[2] = packageStats.codeSize;
                                                    v.i("MicroMsg.SQLTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                                                }
                                            }});
                                        } catch (Exception e) {
                                            bVar.cwn[0] = -1;
                                            bVar.cwn[1] = -1;
                                            bVar.cwn[2] = -1;
                                        }
                                        if (this.cwT.cwn[1] != 0 || this.cwT.cwo > 1) {
                                            v.i("MicroMsg.SQLTraceManager", "start file upload ,file length is %d ", Long.valueOf(file.length()));
                                            if (file.length() > this.cwT.cwO) {
                                                v.e("MicroMsg.SQLTraceManager", "log file invaild format");
                                            } else {
                                                String gp = b.gl(b.cwJ + "MMSQL.trace");
                                                v.i("MicroMsg.SQLTraceManager", "read content success");
                                                this.cwT.go(gp);
                                            }
                                            v.i("MicroMsg.SQLTraceManager", "set last Upload Time %d ", Long.valueOf(System.currentTimeMillis()));
                                            this.cwT.a(file, true);
                                            this.cwT.cwp = false;
                                            this.cwT.cwo = 0;
                                            b.c(aa.getContext(), System.currentTimeMillis());
                                            return;
                                        }
                                        v.i("MicroMsg.SQLTraceManager", "wait for get packageStats");
                                        this.cwT.cwo = 1 + this.cwT.cwo;
                                        return;
                                    }
                                    return;
                                }
                                v.w("MicroMsg.SQLTraceManager", "SqlTrace file is not  exists");
                            }
                        });
                        com.tencent.mm.model.ak.vA().x(new Runnable(Aw) {
                            final /* synthetic */ a cwF;

                            {
                                this.cwF = r1;
                            }

                            public final void run() {
                                File file = new File(a.cwm);
                                if (file.exists()) {
                                    com.tencent.mm.model.ak.yW();
                                    if (com.tencent.mm.model.c.ww() == 0) {
                                        v.w("MicroMsg.HandlerTraceManager", "summer acc not ready ");
                                        return;
                                    }
                                    long j = this.cwF.cnm.getLong("handler_report_lastUploadTime", 0);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    Object obj = (currentTimeMillis - j > this.cwF.cwv || j > currentTimeMillis) ? 1 : null;
                                    if (this.cwF.cwp && obj != null) {
                                        v.i("MicroMsg.HandlerTraceManager", "summer check need upload ,file size is %d,time out %b", Long.valueOf(file.length()), Boolean.valueOf(true));
                                        a aVar = this.cwF;
                                        Context context = aa.getContext();
                                        String packageName = aa.getContext().getPackageName();
                                        try {
                                            PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context.getPackageManager(), new Object[]{packageName, new Stub(aVar) {
                                                final /* synthetic */ a cwF;

                                                {
                                                    this.cwF = r1;
                                                }

                                                public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                                                    this.cwF.cwn[0] = packageStats.cacheSize;
                                                    this.cwF.cwn[1] = packageStats.dataSize;
                                                    this.cwF.cwn[2] = packageStats.codeSize;
                                                    v.i("MicroMsg.HandlerTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                                                }
                                            }});
                                        } catch (Exception e) {
                                            aVar.cwn[0] = -1;
                                            aVar.cwn[1] = -1;
                                            aVar.cwn[2] = -1;
                                        }
                                        if (this.cwF.cwn[1] != 0 || this.cwF.cwo > 1) {
                                            if (file.length() > this.cwF.cwu) {
                                                v.e("MicroMsg.HandlerTraceManager", "summer log file invaild format");
                                            } else {
                                                String gm = a.gl(a.cwm);
                                                a aVar2 = this.cwF;
                                                Intent intent = new Intent();
                                                intent.setClassName(aa.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
                                                intent.setAction("uncatch_exception");
                                                intent.putExtra("exceptionPid", Process.myPid());
                                                String str = "userName";
                                                String A = ai.cse.A("login_weixin_username", SQLiteDatabase.KeyEmpty);
                                                if (be.kS(A)) {
                                                    A = ai.cse.A("login_user_name", "never_login_crash");
                                                }
                                                intent.putExtra(str, A);
                                                intent.putExtra("tag", "handler");
                                                intent.putExtra("exceptionMsg", Base64.encodeToString((aVar2.Ax() + gm).getBytes(), 2));
                                                aa.getContext().startService(intent);
                                            }
                                            this.cwF.a(file, true);
                                            this.cwF.cwp = false;
                                            this.cwF.cwo = 0;
                                            this.cwF.cnm.edit().putLong("handler_report_lastUploadTime", System.currentTimeMillis()).commit();
                                            return;
                                        }
                                        this.cwF.cwo = 1 + this.cwF.cwo;
                                        return;
                                    }
                                    return;
                                }
                                v.w("MicroMsg.HandlerTraceManager", "summer handler trace file is not exists");
                            }

                            public final String toString() {
                                return super.toString() + "|checkAndUpload";
                            }
                        });
                        AF.a(AD);
                        AF.a(Aw);
                        com.tencent.mm.model.ak.vA().x(new Runnable(AF) {
                            final /* synthetic */ c cxa;

                            {
                                this.cxa = r1;
                            }

                            public final void run() {
                                if (this.cxa.cwY) {
                                    v.i("MicroMsg.TraceConfigUpdater", "summer update isUpdating and ret");
                                    return;
                                }
                                long j = this.cxa.cnm.getLong("trace_config_last_update_time", 0);
                                long currentTimeMillis = System.currentTimeMillis();
                                if (currentTimeMillis - j > 86400000 || j > currentTimeMillis) {
                                    this.cxa.release();
                                    this.cxa.cwY = true;
                                    com.tencent.mm.model.ak.vy().a(159, this.cxa);
                                    com.tencent.mm.model.ak.vy().a(160, this.cxa);
                                    com.tencent.mm.model.ak.vy().a(new k(21), 0);
                                    return;
                                }
                                v.i("MicroMsg.TraceConfigUpdater", "summer last update time: " + j + " current time: " + currentTimeMillis + " in same day");
                            }
                        });
                    }
                }
                System.gc();
            }
        }
    };

    public static j ot() {
        if (aRo == null) {
            aRo = new j();
        }
        return aRo;
    }
}
