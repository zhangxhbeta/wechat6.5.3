package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.downloader.d;
import com.tencent.mm.pluginsdk.model.downloader.f;
import com.tencent.mm.pluginsdk.model.downloader.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.al;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public ConcurrentHashMap<Long, WeakReference<a>> juZ;
    public ConcurrentHashMap<String, WeakReference<b>> jva;

    public interface a {
        void aTw();

        void aTx();

        void aTy();

        void qt(int i);
    }

    public interface b {
        String aTA();

        String aTz();
    }

    private static final class c {
        public static final a jvc = new a();
    }

    private a() {
        this.juZ = new ConcurrentHashMap();
        this.jva = new ConcurrentHashMap();
        d.bnK();
        com.tencent.mm.pluginsdk.model.downloader.a.a(new l(this) {
            final /* synthetic */ a jvb;

            {
                this.jvb = r1;
            }

            public final void onTaskStarted(long j, String str) {
                this.jvb.x(1, j);
            }

            public final void g(long j, String str) {
                WeakReference weakReference = (WeakReference) this.jvb.juZ.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.aTx();
                        this.jvb.juZ.remove(Long.valueOf(j));
                    }
                    this.jvb.x(3, j);
                }
            }

            public final void q(long j, int i) {
                WeakReference weakReference = (WeakReference) this.jvb.juZ.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.aTy();
                        this.jvb.juZ.remove(Long.valueOf(j));
                    }
                    this.jvb.x(8, j);
                }
            }

            public final void onTaskRemoved(long j) {
                WeakReference weakReference = (WeakReference) this.jvb.juZ.get(Long.valueOf(j));
                if (weakReference != null) {
                    if (((a) weakReference.get()) != null) {
                        this.jvb.juZ.remove(Long.valueOf(j));
                    }
                    this.jvb.x(2, j);
                }
            }

            public final void onTaskPaused(long j) {
                WeakReference weakReference = (WeakReference) this.jvb.juZ.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.aTw();
                    }
                    this.jvb.x(6, j);
                }
            }

            public final void bV(long j) {
                WeakReference weakReference = (WeakReference) this.jvb.juZ.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        f dn = d.bnK().dn(j);
                        if (dn.beD >= 0 && dn.beE > 0) {
                            aVar.qt((int) ((dn.beD * 100) / dn.beE));
                        }
                    }
                }
            }

            public final void bW(long j) {
                WeakReference weakReference = (WeakReference) this.jvb.juZ.get(Long.valueOf(j));
                if (weakReference != null) {
                    weakReference.get();
                    this.jvb.x(7, j);
                }
            }
        });
    }

    public static boolean Bd(String str) {
        f GN = d.bnK().GN(str);
        return (GN == null || TextUtils.isEmpty(GN.path) || !new File(GN.path).exists()) ? false : true;
    }

    public static boolean Ap(String str) {
        f GN = d.bnK().GN(str);
        if (GN == null || GN.status != 1) {
            return false;
        }
        return true;
    }

    public static boolean ar(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return p.o(context, str);
    }

    public static boolean Be(String str) {
        f GN = d.bnK().GN(str);
        return GN != null && GN.status == 2;
    }

    public static void Bf(String str) {
        f GN = d.bnK().GN(str);
        if (GN != null) {
            d.bnK().dm(GN.id);
        }
    }

    public final void x(int i, long j) {
        al ei = ak.yW().wL().ei(j);
        if (ei != null) {
            String str = ei.field_appId;
            ei = ak.yW().wL().GJ(str);
            if (ei == null) {
                v.i("MicroMsg.AdDownloadApkMgr", "downloadinfo not found");
                return;
            }
            b(i, str, ei.field_packageName, ei.field_md5, ei.field_downloadUrl);
        }
    }

    private static String n(Object... objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[15]));
        return stringBuilder.toString();
    }

    public final void b(int i, String str, String str2, String str3, String str4) {
        String str5;
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = "";
        WeakReference weakReference = (WeakReference) this.jva.get(str);
        if (weakReference != null) {
            b bVar = (b) weakReference.get();
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2.replaceAll("\\.", "_");
            }
            str5 = bVar == null ? "" : bVar.aTz() + "." + bVar.aTA() + "." + str2 + ".0.20.0";
        } else {
            str5 = str6;
        }
        v.i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", new Object[]{Integer.valueOf(10737), n(Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis), Integer.valueOf(1), str, Integer.valueOf(5001), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), str3, "", str4, Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(-1), str5)});
        ak.vy().a(new com.tencent.mm.pluginsdk.model.app.ak(10737, str5), 0);
    }
}
