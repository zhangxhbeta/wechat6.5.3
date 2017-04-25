package com.tencent.mm.plugin.zero;

import android.os.Build.VERSION;
import com.tencent.mm.app.c;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.h.e;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.plugin.ProcessProfile;
import com.tencent.mm.plugin.zero.a.a;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.plugin.zero.a.g;
import com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.n;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;

public class b extends com.tencent.mm.kernel.plugin.b implements f {
    private e lxh = new e();
    private a lxi = new a();
    private final c lxj = new c();
    public g lxk;
    public com.tencent.mm.plugin.zero.a.c lxl;
    public com.tencent.mm.plugin.zero.a.e lxm;
    public com.tencent.mm.plugin.zero.a.b lxn;
    public a lxo;

    public String toString() {
        return "plugin-zero";
    }

    public void installed() {
        super.installed();
        alias(f.class);
    }

    public void dependency() {
        dependsOnRoot();
    }

    public void configure(final ProcessProfile processProfile) {
        try {
            String str;
            File file = new File(t.cng);
            if (!file.exists()) {
                file.mkdirs();
                com.tencent.mm.compatible.util.e.dt(null);
            }
            String str2 = com.tencent.mm.compatible.util.e.cni;
            q qVar = new q(t.cng + "SdcardInfo.cfg");
            String str3 = (String) qVar.get(1, SQLiteDatabase.KeyEmpty);
            int intValue = ((Integer) qVar.get(2, Integer.valueOf(0))).intValue();
            int i = VERSION.SDK_INT;
            if (be.kS(str3)) {
                qVar.set(1, str2);
                qVar.set(2, Integer.valueOf(i));
                str = str2;
            } else {
                str = str3;
            }
            v.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", str3, str, str2, Integer.valueOf(intValue), Integer.valueOf(i));
            com.tencent.mm.compatible.util.e.dt(str);
            if (!(intValue == i || com.tencent.mm.compatible.util.f.sj())) {
                if (h.getExternalStorageState().equals("mounted") && new File(h.getExternalStorageDirectory().getAbsolutePath()).canWrite()) {
                    qVar.set(1, str2);
                    qVar.set(2, Integer.valueOf(i));
                    com.tencent.mm.compatible.util.e.dt(str2);
                    v.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", com.tencent.mm.compatible.util.e.cni, Boolean.valueOf(com.tencent.mm.compatible.util.f.sj()));
                } else {
                    v.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", com.tencent.mm.compatible.util.e.cni, Boolean.valueOf(com.tencent.mm.compatible.util.f.sj()), str2);
                }
            }
        } catch (Throwable e) {
            v.a("MicroMsg.PluginZero", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.a("MicroMsg.PluginZero", e, "what happened?", new Object[0]);
        }
        aa.Kh(processProfile.getProcessName());
        com.tencent.mm.kernel.a.b.a("configure [%s], setup broken library handler...", this);
        k.setupBrokenLibraryHandler();
        com.tencent.mm.kernel.a.b.a("configure [%s], init Xlog...", this);
        k.b("stlport_shared", b.class.getClassLoader());
        k.b(com.tencent.mm.sdk.a.nhg, b.class.getClassLoader());
        com.tencent.mm.vending.f.a.a(new com.tencent.mm.vending.f.a.a(this) {
            final /* synthetic */ b lxp;

            {
                this.lxp = r1;
            }

            public final void e(String str, String str2, Object... objArr) {
                v.e(str, str2, objArr);
            }

            public final void w(String str, String str2, Object... objArr) {
                v.w(str, str2, objArr);
            }

            public final void i(String str, String str2, Object... objArr) {
                v.i(str, str2, objArr);
            }

            public final void d(String str, String str2, Object... objArr) {
                v.d(str, str2, objArr);
            }

            public final void a(String str, Throwable th, String str2, Object... objArr) {
                v.a(str, th, str2, objArr);
            }
        });
        if (d.b(processProfile)) {
            com.tencent.mm.kernel.a.b.a("configure [%s], for process[%s]...", this, processProfile.getProcessName());
            com.tencent.mm.kernel.g.a(com.tencent.mm.h.h.class, this.lxh);
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.a.d.class, this.lxi);
            com.tencent.mm.kernel.a.b.a("configure [%s], make worker core...", this);
            com.tencent.mm.kernel.g vx = com.tencent.mm.kernel.g.vx();
            if (!vx.ckP) {
                vx.ckP = true;
                vx.ckB = new com.tencent.mm.kernel.e(vx.cjX, vx.ckN, vx.cjU);
                vx.ckC = new com.tencent.mm.kernel.a(vx.ckK, vx.ckL);
                vx.ckD = new com.tencent.mm.kernel.b(vx.ckM, vx.cjB);
            }
            com.tencent.mm.kernel.g.vx().a(new com.tencent.mm.kernel.api.e(this) {
                final /* synthetic */ b lxp;

                public final void ok() {
                    com.tencent.mm.kernel.a.b.a("startup done [%s], account initialize...", this);
                    if (!com.tencent.mm.kernel.a.uG()) {
                        com.tencent.mm.kernel.g.vu().uL();
                    }
                }

                public final void ah(boolean z) {
                    if (z) {
                        com.tencent.mm.kernel.h.c(processProfile.application(), true);
                        com.tencent.mm.kernel.h.d(processProfile.application(), true);
                    }
                    v.bta();
                }
            });
            com.tencent.mm.kernel.g.vx();
            com.tencent.mm.av.e.doL = new com.tencent.mm.vending.h.h(com.tencent.mm.av.b.b(com.tencent.mm.kernel.g.vA().btx()), "WeChat.WORKER");
            com.tencent.mm.vending.h.g.a("WeChat.WORKER", com.tencent.mm.av.e.doL);
            new com.tencent.mm.plugin.zero.tasks.a().before(this);
        }
        if (d.b(processProfile) || d.a(processProfile, ":push")) {
            new LoadProtocolJNITask().before(this);
        }
        v.i("MicroMsg.PluginZero", "oldversion:%s, newversion:%s, gettime:%d, settime:%d", processProfile.lifeCycle().mOldVersionCode, processProfile.lifeCycle().mNewVersionCode, Long.valueOf(processProfile.lifeCycle().mGetRevTime), Long.valueOf(processProfile.lifeCycle().mSetRevTime));
    }

    public void execute(final ProcessProfile processProfile) {
        if (d.b(processProfile)) {
            com.tencent.mm.kernel.g.vx().ckM.ay(new n.a(this) {
                final /* synthetic */ b lxp;

                public final void a(n nVar, boolean z) {
                }

                public final void a(n nVar) {
                    this.lxp.lxj.ad(processProfile.application());
                }
            });
            NotifyReceiver.pZ();
        }
    }

    public final void a(g gVar) {
        this.lxk = gVar;
    }

    public final void a(com.tencent.mm.plugin.zero.a.c cVar) {
        this.lxl = cVar;
    }

    public final void a(com.tencent.mm.plugin.zero.a.e eVar) {
        v.i("MicroMsg.PluginZero", "setINotifyReceiverDelegate this %s delegate %s ", this, eVar);
        this.lxm = eVar;
    }

    public final void a(com.tencent.mm.plugin.zero.a.b bVar) {
        this.lxn = bVar;
    }

    public final void a(a aVar) {
        this.lxo = aVar;
    }
}
