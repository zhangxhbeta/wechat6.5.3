package com.tencent.mm.plugin.extqlauncher;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.e.a.ea;
import com.tencent.mm.e.a.kd;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.g;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.model.n;
import com.tencent.mm.plugin.extqlauncher.provider.ExtControlProviderQLauncher;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.List;

public final class b implements ag {
    boolean fIA = false;
    private com.tencent.mm.sdk.h.j.b fIB = new com.tencent.mm.sdk.h.j.b(this) {
        final /* synthetic */ b fIJ;

        {
            this.fIJ = r1;
        }

        public final void a(int i, j jVar, Object obj) {
            v.d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
            if (!this.fIJ.fIA) {
                ak.yW();
                if (jVar != c.wK()) {
                    return;
                }
                if (jVar == null || obj == null) {
                    v.e("MicroMsg.SubCoreExtQLauncher", "onConversationChange, wrong args");
                } else if (aa.getContext() == null || !ak.uz()) {
                    v.w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
                } else {
                    this.fIJ.alh();
                }
            }
        }
    };
    boolean fIC = false;
    long fID = 0;
    private final long fIE = 300000;
    private final long fIF = 4000;
    private final String fIG = "fun1";
    int fIH = 0;
    private ac fII = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ b fIJ;

        @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
        public final void handleMessage(Message message) {
            if (aa.getContext() == null || !ak.uz()) {
                v.w("MicroMsg.SubCoreExtQLauncher", "wrong status");
            } else if (b.a(this.fIJ)) {
                int alg = b.alg();
                if (alg > 0 || alg < this.fIJ.fIH) {
                    v.d("MicroMsg.SubCoreExtQLauncher", "notify unread");
                    Intent intent = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
                    intent.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
                    aa.getContext().sendBroadcast(intent);
                    this.fIJ.fIH = alg;
                }
            }
        }
    };
    private a fIy;
    private b fIz;

    public static class a extends com.tencent.mm.sdk.c.c<ea> {
        public a() {
            this.nhz = ea.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ea eaVar = (ea) bVar;
            if (eaVar instanceof ea) {
                ExtControlProviderQLauncher extControlProviderQLauncher = new ExtControlProviderQLauncher(eaVar.bbV.aWv, eaVar.bbV.bbX, eaVar.bbV.context);
                eaVar.bbW.bbY = extControlProviderQLauncher.query(eaVar.bbV.uri, null, null, eaVar.bbV.selectionArgs, null);
                return true;
            }
            v.f("MicroMsg.SubCoreExtQLauncher", "mismatched event");
            return false;
        }
    }

    private class b extends com.tencent.mm.sdk.c.c<kd> {
        final /* synthetic */ b fIJ;

        private b(b bVar) {
            this.fIJ = bVar;
            this.nhz = kd.class.getName().hashCode();
        }

        /* synthetic */ b(b bVar, byte b) {
            this(bVar);
            this.nhz = kd.class.getName().hashCode();
        }

        private boolean a(kd kdVar) {
            if (!b.a(this.fIJ)) {
                v.e("MicroMsg.SubCoreExtQLauncher", "!isPluginInstall");
                return false;
            } else if (aa.getContext() == null) {
                v.e("MicroMsg.SubCoreExtQLauncher", "MMApplicationContext null");
                return false;
            } else {
                v.d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", new Object[]{Integer.valueOf(kdVar.bkW.bkU), kdVar.bkW.bkZ});
                try {
                    switch (kdVar.bkW.bkU) {
                        case 0:
                            if (be.kS(kdVar.bkW.bkZ) || !kdVar.bkW.bkZ.startsWith("qlauncher://")) {
                                return false;
                            }
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
                            intent.setData(Uri.parse(kdVar.bkW.bkZ));
                            intent.setFlags(268435456);
                            aa.getContext().startActivity(intent);
                            kdVar.bkX.ret = 1;
                            return true;
                        default:
                            return false;
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", new Object[]{e.getMessage()});
                    return false;
                }
            }
        }
    }

    static /* synthetic */ boolean a(b bVar) {
        if (aa.getContext() == null) {
            v.w("MicroMsg.SubCoreExtQLauncher", "isPluginInstall, ApplicationContext null");
            bVar.fIC = false;
            return false;
        } else if (System.currentTimeMillis() - bVar.fID < 300000) {
            return bVar.fIC;
        } else {
            ak.vA().x(new Runnable(bVar) {
                final /* synthetic */ b fIJ;

                {
                    this.fIJ = r1;
                }

                public final void run() {
                    try {
                        this.fIJ.fID = System.currentTimeMillis();
                        List installedApplications = aa.getContext().getPackageManager().getInstalledApplications(128);
                        if (installedApplications == null) {
                            v.e("MicroMsg.SubCoreExtQLauncher", "getInstalledApplications return null");
                            this.fIJ.fIC = false;
                            return;
                        }
                        for (int i = 0; i < installedApplications.size(); i++) {
                            ApplicationInfo applicationInfo = (ApplicationInfo) installedApplications.get(i);
                            if (applicationInfo != null && ((be.ma(applicationInfo.packageName).startsWith("com.tencent.qlauncher") || be.ma(applicationInfo.packageName).startsWith("com.tencent.qqlauncher") || be.ma(applicationInfo.packageName).startsWith("com.tencent.launcher")) && applicationInfo.metaData != null)) {
                                String string = applicationInfo.metaData.getString("qlauncher_wx_coop");
                                if (string == null || string.length() <= 0) {
                                    v.w("MicroMsg.SubCoreExtQLauncher", "qlauncher_wx_coop not found, %s, costTime = %s", new Object[]{applicationInfo.packageName, Long.valueOf(System.currentTimeMillis() - this.fIJ.fID)});
                                    this.fIJ.fIC = false;
                                } else {
                                    String[] split = string.split(",");
                                    if (split != null) {
                                        for (String ma : split) {
                                            if (be.ma(ma).trim().equalsIgnoreCase("fun1")) {
                                                v.d("MicroMsg.SubCoreExtQLauncher", "founded qlauncher, %s", new Object[]{applicationInfo.packageName});
                                                this.fIJ.fIC = true;
                                                return;
                                            }
                                        }
                                    }
                                    this.fIJ.fIC = false;
                                }
                            }
                        }
                        v.d("MicroMsg.SubCoreExtQLauncher", "qlauncher not founded, costTime = %s", new Object[]{Long.valueOf(System.currentTimeMillis() - this.fIJ.fID)});
                    } catch (Exception e) {
                        v.e("MicroMsg.SubCoreExtQLauncher", "exception in getApplicationInfo, %s", new Object[]{e.getMessage()});
                        this.fIJ.fIC = false;
                    }
                }

                public final String toString() {
                    return super.toString() + "|isPluginInstall";
                }
            });
            return bVar.fIC;
        }
    }

    public static b alf() {
        b bVar = (b) ak.yP().fY("plugin.extqlauncher");
        if (bVar != null) {
            return bVar;
        }
        bVar = new b();
        ak.yP().a("plugin.extqlauncher", bVar);
        return bVar;
    }

    public final void aH(boolean z) {
    }

    public final void aG(boolean z) {
        ak.yW();
        c.wK().a(this.fIB);
        if (this.fIy == null) {
            this.fIy = new a();
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.fIy);
        if (this.fIz == null) {
            this.fIz = new b();
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.fIz);
    }

    public final void th() {
        if (this.fIy != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.fIy);
        }
        if (this.fIz != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.fIz);
        }
        ak.yW();
        c.wK().b(this.fIB);
        this.fII.removeMessages(0);
    }

    public static int alg() {
        if (ak.uz()) {
            int fv = n.fv(m.crA);
            int xD = g.xD();
            if ((k.xJ() & 32768) == 0) {
                return fv - xD;
            }
            return fv;
        }
        v.w("MicroMsg.SubCoreExtQLauncher", "getMMUnread account not ready");
        return 0;
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void alh() {
        this.fII.removeMessages(0);
        this.fII.sendEmptyMessageDelayed(0, 4000);
    }
}
