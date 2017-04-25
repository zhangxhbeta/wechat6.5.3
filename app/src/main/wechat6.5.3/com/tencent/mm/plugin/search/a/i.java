package com.tencent.mm.plugin.search.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.a.e;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.aq;
import com.tencent.mm.e.a.ar;
import com.tencent.mm.e.a.d;
import com.tencent.mm.e.a.ps;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.modelsearch.n;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.plugin.search.ui.b.f;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

public final class i implements ag {
    private c gEI = new c<ar>(this) {
        final /* synthetic */ i iGy;

        {
            this.iGy = r2;
            this.nhz = ar.class.getName().hashCode();
        }

        private boolean a(ar arVar) {
            Throwable e;
            File file;
            if ((arVar instanceof ar) && arVar.aYn.aYo == 27 && arVar.aYn.aYp == 1) {
                File file2 = new File(arVar.aYn.filePath);
                if (file2.exists()) {
                    int intValue;
                    v.i("MicroMsg.FTS.SubCoreSearch", "checkResUpdateListener callback to update %s", new Object[]{file2.getAbsoluteFile()});
                    File file3 = new File(h.Ii(), "temp");
                    File file4 = new File(file3, "fts_template.zip");
                    file3.mkdirs();
                    e.p(file2.getAbsolutePath(), file4.getAbsolutePath());
                    if (be.dB(file4.getAbsolutePath(), file3.getAbsolutePath()) >= 0) {
                        Properties properties = new Properties();
                        InputStream fileInputStream;
                        try {
                            fileInputStream = new FileInputStream(new File(file3, "config.conf"));
                            try {
                                properties.load(fileInputStream);
                                e.c(fileInputStream);
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    v.a("MicroMsg.FTS.SubCoreSearch", e, e.getMessage(), new Object[0]);
                                    e.c(fileInputStream);
                                    intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                    e.e(file3);
                                    if (h.cVT < intValue) {
                                        v.i("MicroMsg.FTS.SubCoreSearch", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(h.cVT), Integer.valueOf(intValue)});
                                        file4 = new File(h.Ii());
                                        e.e(file4);
                                        file4.mkdirs();
                                        file = new File(file4, ".nomedia");
                                        if (!file.exists()) {
                                            try {
                                                file.createNewFile();
                                            } catch (Throwable e3) {
                                                v.a("MicroMsg.FTS.SubCoreSearch", e3, "create nomedia file error", new Object[0]);
                                            }
                                        }
                                        file = new File(file4, "fts_template.zip");
                                        e.p(file2.getAbsolutePath(), file.getAbsolutePath());
                                        intValue = be.dB(file.getAbsolutePath(), file.getParent());
                                        if (intValue < 0) {
                                            v.e("MicroMsg.FTS.SubCoreSearch", "unzip fail, ret = " + intValue + ", zipFilePath = " + file.getAbsolutePath() + ", unzipPath = " + file.getParent());
                                        } else {
                                            i.bRK();
                                            h.cVT = h.Et();
                                            v.i("MicroMsg.FTS.SubCoreSearch", "Unzip Path%s version=%d", new Object[]{file.getParent(), Integer.valueOf(h.cVT)});
                                        }
                                    } else {
                                        v.i("MicroMsg.FTS.SubCoreSearch", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(h.cVT), Integer.valueOf(intValue)});
                                    }
                                    return false;
                                } catch (Throwable th) {
                                    e = th;
                                    e.c(fileInputStream);
                                    throw e;
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            fileInputStream = null;
                            v.a("MicroMsg.FTS.SubCoreSearch", e, e.getMessage(), new Object[0]);
                            e.c(fileInputStream);
                            intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                            e.e(file3);
                            if (h.cVT < intValue) {
                                v.i("MicroMsg.FTS.SubCoreSearch", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(h.cVT), Integer.valueOf(intValue)});
                            } else {
                                v.i("MicroMsg.FTS.SubCoreSearch", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(h.cVT), Integer.valueOf(intValue)});
                                file4 = new File(h.Ii());
                                e.e(file4);
                                file4.mkdirs();
                                file = new File(file4, ".nomedia");
                                if (file.exists()) {
                                    file.createNewFile();
                                }
                                file = new File(file4, "fts_template.zip");
                                e.p(file2.getAbsolutePath(), file.getAbsolutePath());
                                intValue = be.dB(file.getAbsolutePath(), file.getParent());
                                if (intValue < 0) {
                                    i.bRK();
                                    h.cVT = h.Et();
                                    v.i("MicroMsg.FTS.SubCoreSearch", "Unzip Path%s version=%d", new Object[]{file.getParent(), Integer.valueOf(h.cVT)});
                                } else {
                                    v.e("MicroMsg.FTS.SubCoreSearch", "unzip fail, ret = " + intValue + ", zipFilePath = " + file.getAbsolutePath() + ", unzipPath = " + file.getParent());
                                }
                            }
                            return false;
                        } catch (Throwable th2) {
                            e = th2;
                            fileInputStream = null;
                            e.c(fileInputStream);
                            throw e;
                        }
                        intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                    } else {
                        intValue = 1;
                    }
                    e.e(file3);
                    if (h.cVT < intValue) {
                        v.i("MicroMsg.FTS.SubCoreSearch", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(h.cVT), Integer.valueOf(intValue)});
                        file4 = new File(h.Ii());
                        e.e(file4);
                        file4.mkdirs();
                        file = new File(file4, ".nomedia");
                        if (file.exists()) {
                            file.createNewFile();
                        }
                        file = new File(file4, "fts_template.zip");
                        e.p(file2.getAbsolutePath(), file.getAbsolutePath());
                        intValue = be.dB(file.getAbsolutePath(), file.getParent());
                        if (intValue < 0) {
                            v.e("MicroMsg.FTS.SubCoreSearch", "unzip fail, ret = " + intValue + ", zipFilePath = " + file.getAbsolutePath() + ", unzipPath = " + file.getParent());
                        } else {
                            i.bRK();
                            h.cVT = h.Et();
                            v.i("MicroMsg.FTS.SubCoreSearch", "Unzip Path%s version=%d", new Object[]{file.getParent(), Integer.valueOf(h.cVT)});
                        }
                    } else {
                        v.i("MicroMsg.FTS.SubCoreSearch", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(h.cVT), Integer.valueOf(intValue)});
                    }
                } else {
                    v.e("MicroMsg.FTS.SubCoreSearch", "checkResUpdateListener file not exist");
                }
            }
            return false;
        }
    };
    private com.tencent.mm.model.bq.a hAC = new com.tencent.mm.model.bq.a(this) {
        final /* synthetic */ i iGy;

        {
            this.iGy = r1;
        }

        public final boolean Ae() {
            v.w("MicroMsg.FTS.SubCoreSearch", "HERE UninitForUEH is called! stg:%s ", new Object[]{this.iGy.iGj});
            if (this.iGy.iGj != null) {
                this.iGy.iGj.rollback();
                this.iGy.iGj.close();
            }
            return true;
        }
    };
    c iEF = new c<ps>(this) {
        final /* synthetic */ i iGy;

        {
            this.iGy = r2;
            this.nhz = ps.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.iGy.iGk.a(131072, new com.tencent.mm.modelsearch.r.a(this) {
                final /* synthetic */ AnonymousClass7 iGA;
                String iGz = "";

                {
                    this.iGA = r2;
                }

                public final boolean execute() {
                    i.bRK();
                    this.iGz = u.dJ(aa.getContext());
                    this.iGA.iGy.iGj.f(-3, (long) this.iGz.hashCode());
                    return true;
                }

                public final String toString() {
                    return "LanguageUpdate(\"" + this.iGz + "\")";
                }
            });
            return false;
        }
    };
    a iGj = null;
    d iGk = new d();
    boolean iGl = false;
    boolean iGm = false;
    boolean iGn = false;
    boolean iGo = false;
    c iGp = new c<com.tencent.mm.e.a.i>(this) {
        final /* synthetic */ i iGy;

        {
            this.iGy = r2;
            this.nhz = com.tencent.mm.e.a.i.class.getName().hashCode();
        }

        private boolean a(com.tencent.mm.e.a.i iVar) {
            if (iVar instanceof com.tencent.mm.e.a.i) {
                com.tencent.mm.sdk.c.a.nhr.f(this.iGy.iGp);
                this.iGy.iGo = true;
                v.i("MicroMsg.FTS.SubCoreSearch", "All account post reset");
                this.iGy.aMk();
            }
            return false;
        }
    };
    private c iGq = new c<aq>(this) {
        final /* synthetic */ i iGy;

        {
            this.iGy = r2;
            this.nhz = aq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.iGy.aMl();
            return false;
        }
    };
    c iGr = new c<d>(this) {
        final /* synthetic */ i iGy;

        {
            this.iGy = r2;
            this.nhz = d.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            d dVar = (d) bVar;
            d dVar2 = this.iGy.iGk;
            boolean z = dVar.aWo.aWp;
            if (dVar2.iFw != null) {
                dVar2.iFw.fl(z);
            }
            this.iGy.iGm = !dVar.aWo.aWp;
            return false;
        }
    };
    com.tencent.mm.v.e iGs = new com.tencent.mm.v.e(this) {
        final /* synthetic */ i iGy;

        {
            this.iGy = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            ak.yW();
            if (be.f((Integer) com.tencent.mm.model.c.vf().get(15, null)) != 0) {
                ak.vy().b(138, this.iGy.iGs);
                this.iGy.iGn = true;
                v.i("MicroMsg.FTS.SubCoreSearch", "*** User has finished initializing.");
                this.iGy.aMk();
            }
        }
    };
    private BroadcastReceiver iGt = new BroadcastReceiver(this) {
        final /* synthetic */ i iGy;

        {
            this.iGy = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null) {
                v.i("MicroMsg.FTS.SubCoreSearch", "*** Charging notified: " + intent.getAction());
                if (intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                    this.iGy.iGl = true;
                } else if (intent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                    this.iGy.iGl = false;
                }
            }
        }
    };
    private Runnable iGu = new Runnable(this) {
        final /* synthetic */ i iGy;

        {
            this.iGy = r1;
        }

        public final void run() {
            if (this.iGy.iGj != null) {
                this.iGy.iGj.rollback();
            }
        }
    };
    public long iGv;
    public int searchMode;

    private class a implements Runnable {
        boolean iGB;
        final /* synthetic */ i iGy;

        a(i iVar, boolean z) {
            this.iGy = iVar;
            this.iGB = z;
        }

        public final void run() {
            boolean z = this.iGB;
            File file = new File(h.Ii());
            v.i("MicroMsg.FTS.SubCoreSearch", "copy to path %s", new Object[]{file.getAbsolutePath()});
            if (com.tencent.mm.protocal.d.lWk || com.tencent.mm.protocal.d.lWl) {
                v.i("MicroMsg.FTS.SubCoreSearch", "need to init search template folder %b", new Object[]{Boolean.valueOf(z)});
                e.e(file);
                i.k(file);
            } else {
                h.cVT = h.Et();
                if (z) {
                    v.i("MicroMsg.FTS.SubCoreSearch", "need update assetVersion=%d currentVersion=%d", new Object[]{Integer.valueOf(h.Eu()), Integer.valueOf(h.cVT)});
                    if (h.cVT < h.Eu()) {
                        e.e(file);
                        i.k(file);
                    }
                } else if (h.cVT == 1) {
                    v.i("MicroMsg.FTS.SubCoreSearch", "need init template");
                    e.e(file);
                    i.k(file);
                } else {
                    v.i("MicroMsg.FTS.SubCoreSearch", "currentVersion=%d", new Object[]{Integer.valueOf(h.cVT)});
                }
            }
            e.e(new File(com.tencent.mm.compatible.util.e.cnj, "fts"));
        }
    }

    public static i aMj() {
        i iVar = (i) ak.yP().fY("plugin.search");
        if (iVar != null) {
            return iVar;
        }
        iVar = new i();
        ak.yP().a(com.tencent.mm.p.c.class.getName(), iVar);
        return iVar;
    }

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }

    public final void aG(boolean z) {
        ak.yW();
        this.iGj = new a(com.tencent.mm.model.c.xp());
        d dVar = this.iGk;
        if (dVar.iFw == null || !dVar.iFw.isAlive()) {
            dVar.iFw = new b(dVar);
            v.i("MicroMsg.FTS.SearchDaemon", "***** Search daemon initialized, waiting for starting.");
        } else {
            v.a("MicroMsg.FTS.SearchDaemon", new Throwable(), "Duplicated daemon initialization detected, working queue maybe dirty!", new Object[0]);
        }
        dVar = this.iGk;
        Runnable runnable = this.iGu;
        if (dVar.iFw != null) {
            dVar.iFw.iFH = runnable;
        }
        p.a(this.iGj, this.iGk);
        com.tencent.mm.ui.f.e.a(new com.tencent.mm.plugin.search.ui.h());
        p.a(new com.tencent.mm.modelsearch.a.a());
        p.a(new com.tencent.mm.plugin.search.a.b.a());
        p.a(new com.tencent.mm.plugin.search.a.b.b());
        p.a(new com.tencent.mm.plugin.search.a.b.c());
        Iterator it = p.Ix().iterator();
        while (it.hasNext()) {
            ((n) it.next()).create();
        }
        f fVar = new f();
        c cVar = new c();
        e eVar = new e();
        p.a(1, new g());
        p.a(2, cVar);
        p.a(3, fVar);
        p.a(4, eVar);
        com.tencent.mm.ui.f.e.a(new com.tencent.mm.plugin.search.ui.b.i());
        com.tencent.mm.ui.f.e.a(new com.tencent.mm.plugin.search.ui.b.e());
        com.tencent.mm.ui.f.e.a(new com.tencent.mm.plugin.search.ui.b.c());
        com.tencent.mm.ui.f.e.a(new f());
        com.tencent.mm.ui.f.e.a(new com.tencent.mm.plugin.search.ui.b.h());
        com.tencent.mm.ui.f.e.a(new com.tencent.mm.plugin.search.ui.b.d());
        com.tencent.mm.ui.f.e.a(new com.tencent.mm.plugin.search.ui.b.b());
        com.tencent.mm.ui.f.e.a(new com.tencent.mm.plugin.search.ui.b.g());
        com.tencent.mm.ui.f.e.a(new com.tencent.mm.plugin.search.ui.b.a());
        com.tencent.mm.sdk.c.a.nhr.e(this.iGr);
        Intent registerReceiver = aa.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
            boolean z2 = intExtra == 2 || intExtra == 5;
            this.iGl = z2;
        } else {
            this.iGl = false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        aa.getContext().registerReceiver(this.iGt, intentFilter);
        com.tencent.mm.sdk.c.a.nhr.e(this.iEF);
        com.tencent.mm.sdk.c.a.nhr.e(this.iGq);
        com.tencent.mm.sdk.c.a.nhr.e(this.iGp);
        com.tencent.mm.sdk.c.a.nhr.e(this.gEI);
        p.Iw();
        aMl();
        ak.vz().a(this.hAC);
        aMk();
        com.tencent.mm.sdk.i.e.a(new a(this, z), "CopySearchTemplateTask");
    }

    public final void th() {
        ak.vz().b(this.hAC);
        com.tencent.mm.sdk.c.a.nhr.f(this.iEF);
        aa.getContext().unregisterReceiver(this.iGt);
        com.tencent.mm.sdk.c.a.nhr.f(this.iGr);
        com.tencent.mm.sdk.c.a.nhr.f(this.iGq);
        ak.vy().b(138, this.iGs);
        com.tencent.mm.sdk.c.a.nhr.f(this.iGp);
        com.tencent.mm.sdk.c.a.nhr.f(this.gEI);
        d dVar = this.iGk;
        if (dVar.iFw != null && dVar.iFw.isAlive()) {
            dVar.iFw.quit();
            try {
                dVar.iFw.join();
            } catch (InterruptedException e) {
            }
            dVar.iFw = null;
            v.i("MicroMsg.FTS.SearchDaemon", "***** Search daemon quited.");
        }
        this.iGj.close();
        com.tencent.mm.ui.f.e.bIL();
        p.Ir();
        com.tencent.mm.modelsearch.i.cVV = null;
        this.iGn = false;
        this.iGo = false;
    }

    final void aMk() {
        ak.yW();
        this.iGn = be.f((Integer) com.tencent.mm.model.c.vf().get(15, null)) != 0;
        if (this.iGn) {
            v.i("MicroMsg.FTS.SubCoreSearch", "waitAndStartDaemon user is initialized.");
        } else {
            ak.vy().a(138, this.iGs);
            v.i("MicroMsg.FTS.SubCoreSearch", "waitAndStartDaemon wait for account initialized");
        }
        if (this.iGo) {
            v.i("MicroMsg.FTS.SubCoreSearch", "waitAndStartDaemon all account post reset.");
        } else {
            v.i("MicroMsg.FTS.SubCoreSearch", "waitAndStartDaemon wait for all account post reset.");
        }
        if (this.iGn && this.iGo && !this.iGk.Iz()) {
            this.iGk.start();
        }
    }

    final void aMl() {
        this.iGk.a(65536, new com.tencent.mm.modelsearch.r.a(this) {
            String iGw = u.dJ(aa.getContext());
            boolean iGx = false;
            final /* synthetic */ i iGy;

            {
                this.iGy = r2;
            }

            public final boolean execute() {
                this.iGx = ((int) this.iGy.iGj.e(-3, 0)) != this.iGw.hashCode();
                if (this.iGx) {
                    com.tencent.mm.sdk.c.a.nhr.z(new ps());
                }
                return true;
            }

            public final String toString() {
                return "CheckLanguageUpdate [" + (this.iGx ? "changed: " + this.iGw : "not changed") + "]";
            }
        });
    }

    static void bRK() {
        v.i("MicroMsg.FTS.SubCoreSearch", "clearHotWordConfig");
        ak.yW();
        com.tencent.mm.model.c.vf().set(84, Long.valueOf(0));
        ak.yW();
        com.tencent.mm.model.c.vf().set(85, Integer.valueOf(0));
        ak.yW();
        com.tencent.mm.model.c.vf().set(86, "");
        ak.yW();
        com.tencent.mm.model.c.vf().set(87, Long.valueOf(0));
    }

    static void k(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Throwable e) {
                v.a("MicroMsg.FTS.SubCoreSearch", e, "create nomedia file error", new Object[0]);
            }
        }
        file2 = new File(file, "fts_template.zip");
        if (h.ix(file2.getAbsolutePath())) {
            int dB = be.dB(file2.getAbsolutePath(), file2.getParent());
            if (dB < 0) {
                v.e("MicroMsg.FTS.SubCoreSearch", "unzip fail, ret = " + dB + ", zipFilePath = " + file2.getAbsolutePath() + ", unzipPath = " + file2.getParent());
                return;
            }
            bRK();
            h.cVT = h.Et();
            v.i("MicroMsg.FTS.SubCoreSearch", "Unzip Path%s version=%d", new Object[]{file2.getParent(), Integer.valueOf(h.cVT)});
            return;
        }
        v.i("MicroMsg.FTS.SubCoreSearch", "copy template file from asset fail %s", new Object[]{file2.getAbsolutePath()});
    }
}
