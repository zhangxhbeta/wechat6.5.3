package com.tencent.mm.kernel;

import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.mm.a.o;
import com.tencent.mm.bg.g;
import com.tencent.mm.compatible.d.k;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.api.d;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class e {
    private static HashMap<Integer, com.tencent.mm.bg.g.c> bXq;
    public String cachePath;
    public final q cjT = va();
    public a cjU;
    public c cjV = new c();
    c cjW = new c();
    public List<com.tencent.mm.kernel.api.a> cjX;
    public List<x> cjY;
    public String cjZ = ve();
    public String cka;
    public g ckb = null;
    public g ckc = null;
    public r ckd;
    az cke;
    bs ckf;
    ConcurrentHashMap<String, SharedPreferences> ckg = new ConcurrentHashMap();
    private long ckh = 0;
    public ac cki = null;
    public volatile Boolean ckj = null;
    public b ckk = new b();
    public long ckl = 0;

    private class b implements Runnable {
        final /* synthetic */ e ckm;

        private b(e eVar) {
            this.ckm = eVar;
        }

        public final void run() {
            this.ckm.vh();
        }
    }

    static class a extends com.tencent.mm.av.a<d> implements d {
        a() {
        }

        public final void aM(final boolean z) {
            a(new com.tencent.mm.av.a.a<d>(this) {
                final /* synthetic */ a cko;

                public final /* synthetic */ void an(Object obj) {
                    ((d) obj).aM(z);
                }
            });
        }

        public final void a(final g gVar, final g gVar2) {
            a(new com.tencent.mm.av.a.a<d>(this) {
                final /* synthetic */ a cko;

                public final /* synthetic */ void an(Object obj) {
                    ((d) obj).a(gVar, gVar2);
                }
            });
        }

        public final void vo() {
            a(new com.tencent.mm.av.a.a<d>(this) {
                final /* synthetic */ a cko;

                {
                    this.cko = r1;
                }

                public final /* synthetic */ void an(Object obj) {
                    ((d) obj).vo();
                }
            });
        }

        public final void dU(final String str) {
            a(new com.tencent.mm.av.a.a<d>(this) {
                final /* synthetic */ a cko;

                public final /* synthetic */ void an(Object obj) {
                    ((d) obj).dU(str);
                }
            });
        }
    }

    static class c extends com.tencent.mm.av.a<com.tencent.mm.bg.g.a> implements com.tencent.mm.bg.g.a {
        c() {
        }

        public final void vl() {
            a(new com.tencent.mm.av.a.a<com.tencent.mm.bg.g.a>(this) {
                final /* synthetic */ c cks;

                {
                    this.cks = r1;
                }

                public final /* synthetic */ void an(Object obj) {
                    ((com.tencent.mm.bg.g.a) obj).vl();
                }
            });
        }

        public final void vm() {
            a(new com.tencent.mm.av.a.a<com.tencent.mm.bg.g.a>(this) {
                final /* synthetic */ c cks;

                {
                    this.cks = r1;
                }

                public final /* synthetic */ void an(Object obj) {
                    ((com.tencent.mm.bg.g.a) obj).vm();
                }
            });
        }

        public final void vn() {
            a(new com.tencent.mm.av.a.a<com.tencent.mm.bg.g.a>(this) {
                final /* synthetic */ c cks;

                {
                    this.cks = r1;
                }

                public final /* synthetic */ void an(Object obj) {
                    ((com.tencent.mm.bg.g.a) obj).vn();
                }
            });
        }
    }

    public e(List<com.tencent.mm.kernel.api.a> list, List<x> list2, a aVar) {
        this.cjX = list;
        this.cjY = list2;
        this.cjU = aVar;
    }

    private static q va() {
        v.i("MMKernel.CoreStorage", "initialize packageInfo:%s version:%x", com.tencent.mm.sdk.platformtools.e.bsN(), Integer.valueOf(com.tencent.mm.protocal.d.lWh));
        File file = new File(t.cng);
        if (!file.exists()) {
            file.mkdirs();
        }
        q qVar = new q(t.cng + "systemInfo.cfg");
        String str = (String) qVar.get(258);
        if (str != null) {
            k.rv().set(258, str);
        }
        try {
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            v.i("MMKernel.CoreStorage", "CheckData path[%s] blocksize:%d blockcount:%d availcount:%d", r0.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()));
        } catch (Exception e) {
            v.e("MMKernel.CoreStorage", "check data size failed :%s", e.getMessage());
        }
        String str2 = t.cng + "alphahold.ini";
        v.i("MMKernel.CoreStorage", "initialize dkalpha client:%x  isapha:%b %s", Integer.valueOf(com.tencent.mm.protocal.d.lWh), Boolean.valueOf(com.tencent.mm.protocal.d.lWk), str2);
        if (com.tencent.mm.protocal.d.lWk || com.tencent.mm.protocal.d.lWl) {
            String value = com.tencent.mm.sdk.h.a.getValue(str2, "noneedhold");
            int i = com.tencent.mm.protocal.d.lWh;
            try {
                i = Integer.decode(BaseBuildInfo.cmV).intValue();
            } catch (Throwable th) {
            }
            if (!String.valueOf(i).equals(value)) {
                v.w("MMKernel.CoreStorage", "dkalpha version need  reset to DefaultAccount , hold it! client:%x  isapha:%b", Integer.valueOf(i), Boolean.valueOf(com.tencent.mm.protocal.d.lWk));
                a(qVar, 0);
                com.tencent.mm.sdk.h.a.X(str2, "noneedhold", String.valueOf(i));
            }
        } else {
            com.tencent.mm.loader.stub.b.deleteFile(str2);
        }
        return qVar;
    }

    final boolean vb() {
        int f = be.f((Integer) this.ckd.get(14, null));
        int i = com.tencent.mm.protocal.d.lWh;
        v.d("MMKernel.CoreStorage", "tryDataTransfer, sVer = " + f + ", cVer = " + i);
        List<w> oL = new x(this) {
            final /* synthetic */ e ckm;

            {
                this.ckm = r1;
            }

            public final List<w> oL() {
                List<w> arrayList = new ArrayList();
                synchronized (this.ckm.cjY) {
                    for (x oL : this.ckm.cjY) {
                        arrayList.addAll(oL.oL());
                    }
                }
                return arrayList;
            }
        }.oL();
        if (com.tencent.mm.platformtools.q.dqb > 0 && com.tencent.mm.platformtools.q.dqc > 0) {
            v.w("MMKernel.CoreStorage", "tryDataTransfer, force data transfer");
        } else if (f == i) {
            v.i("MMKernel.CoreStorage", "tryDataTransfer, no need to transfer, sVer = " + f + ", cVer = " + i);
            return false;
        } else {
            boolean z = false;
            for (w eH : oL) {
                z = eH.eH(f);
                if (z) {
                    break;
                }
            }
            v.d("MMKernel.CoreStorage", "tryDataTransfer, needTransfer = " + z);
            if (!z) {
                return false;
            }
        }
        v.d("MMKernel.CoreStorage", "tryDataTransfer dataTransferList size = " + oL.size());
        v.d("MMKernel.CoreStorage", "tryDataTransfer, threadId = " + Thread.currentThread().getId() + ", name = " + Thread.currentThread().getName());
        long er = this.ckb.er(Thread.currentThread().getId());
        for (w eH2 : oL) {
            long currentTimeMillis = System.currentTimeMillis();
            eH2.transfer(f);
            eH2.crX = System.currentTimeMillis() - currentTimeMillis;
            v.d("MicroMsg.DataTransferBase", "doTransfer, timeConsumed = " + eH2.crX + ", tag = " + eH2.getTag());
        }
        if (!(com.tencent.mm.platformtools.q.dqb == 0 || com.tencent.mm.platformtools.q.dqc == 0)) {
            for (i = 0; i < com.tencent.mm.platformtools.q.dqb; i++) {
                try {
                    Thread.sleep((long) com.tencent.mm.platformtools.q.dqc);
                } catch (Throwable e) {
                    v.e("MMKernel.CoreStorage", "exception:%s", be.e(e));
                }
            }
        }
        if (er > 0) {
            this.ckb.es(er);
        }
        return true;
    }

    final void vc() {
        this.cjU.dU(this.cka);
        File file = new File(this.cka + ".nomedia");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e) {
                v.e("MMKernel.CoreStorage", "exception:%s", be.e(e));
            }
        }
    }

    public final String vd() {
        File file = new File(this.cachePath, "EnMicroMsg.db~");
        if (file.isFile()) {
            return file.getAbsolutePath();
        }
        String[] list = new File(this.cachePath).list(new FilenameFilter(this) {
            final /* synthetic */ e ckm;

            {
                this.ckm = r1;
            }

            public final boolean accept(File file, String str) {
                return str.startsWith("EnMicroMsg.dberr");
            }
        });
        if (list == null || list.length == 0) {
            return null;
        }
        String str = list[0];
        for (int i = 1; i < list.length; i++) {
            String str2 = list[i];
            if (str2.compareTo(str) > 0) {
                str = str2;
            }
        }
        return this.cachePath + '/' + str;
    }

    public final void cQ(String str) {
        if (this.ckc != null) {
            this.ckc.wB();
        }
        if (this.ckb != null) {
            this.ckb.cQ(str);
        }
    }

    public final SharedPreferences dT(String str) {
        g.vx();
        int i = g.vu().uin;
        if (i == 0) {
            return null;
        }
        if (this.ckg.containsKey(str)) {
            return (SharedPreferences) this.ckg.get(str);
        }
        try {
            String str2 = aa.getContext().getFilesDir().getParent() + "/shared_prefs/";
            String str3 = aa.bti() + str + i + ".xml";
            String str4 = aa.bti() + str + i + ".xml.bak";
            File file = new File(str2 + str3);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str2 + str4);
            if (file2.exists()) {
                file2.delete();
            }
        } catch (Exception e) {
        }
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences(aa.bti() + str + z.Kg(i + z.Kg(String.valueOf(i / 2))), 0);
        this.ckg.put(str, sharedPreferences);
        return sharedPreferences;
    }

    private static String ve() {
        String str = t.cng;
        File file = new File(com.tencent.mm.compatible.util.e.cni);
        v.i("MMKernel.CoreStorage", "summer buildSysPath sysPath[" + str + "] SDCARD_ROOT[" + com.tencent.mm.compatible.util.e.cni + "] file.exists:" + file.exists() + " CUtil.isSDCardAvail():" + f.sj());
        if (file.exists() && f.sj()) {
            if (aU(com.tencent.mm.compatible.util.e.cnj)) {
                str = com.tencent.mm.compatible.util.e.cnj;
            }
            file = new File(com.tencent.mm.compatible.util.e.cgg);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.cgh);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.cgj);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.cgk);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.cgh + ".nomedia");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Throwable e) {
                    v.e("MMKernel.CoreStorage", "exception:%s", be.e(e));
                }
            }
        }
        file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        v.i("MMKernel.CoreStorage", "summer buildSysPath ret sysPath: " + str);
        return str;
    }

    private static final boolean aU(String str) {
        if (be.kS(str)) {
            v.i("MMKernel.CoreStorage", "forceMkdirs absolutePath isNullOrNil ret false");
            return false;
        }
        File file = new File(str);
        v.i("MMKernel.CoreStorage", "forceMkdirs absolutePath[%s], f.exists[%b], f.isDirectory[%b]", str, Boolean.valueOf(file.exists()), Boolean.valueOf(file.isDirectory()));
        if (file.exists() && file.isDirectory()) {
            v.i("MMKernel.CoreStorage", "forceMkdirs f is dir and exist ret true");
            return true;
        }
        String[] split = str.split("/");
        if (split == null || split.length < 2) {
            v.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len illegal ret false");
            return false;
        }
        String str2 = "/";
        v.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len: " + split.length);
        for (int i = 0; i < split.length; i++) {
            if (!be.kS(split[i])) {
                str2 = str2 + "/" + split[i];
                File file2 = new File(str2);
                if (file2.isFile() && !file2.renameTo(new File(str2 + "_mmbak"))) {
                    v.i("MMKernel.CoreStorage", "forceMkdirs renameTo false ret false file[%s]", file2.getName());
                    return false;
                } else if (!(file2.exists() || file2.mkdir())) {
                    v.i("MMKernel.CoreStorage", "forceMkdirs mkdir false ret false file[%s]", file2.getName());
                    return false;
                }
            }
        }
        v.i("MMKernel.CoreStorage", "forceMkdirs false ret true");
        return true;
    }

    public static void a(q qVar, int i) {
        v.i("MMKernel.CoreStorage", "setSysUin uin: %d, stack: %s", Integer.valueOf(i), be.bur());
        aa.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("default_uin", i).commit();
        qVar.set(1, Integer.valueOf(i));
    }

    public final r vf() {
        g.vx();
        g.vu().uH();
        return this.ckd;
    }

    public final az vg() {
        g.vx();
        g.vu().uH();
        return this.cke;
    }

    public final void vh() {
        this.ckj = Boolean.valueOf(isSDCardAvailable());
    }

    public final boolean isSDCardAvailable() {
        boolean startsWith = this.cjZ.startsWith(com.tencent.mm.compatible.util.e.cni);
        long Ni = be.Ni();
        long j = Ni - this.ckh;
        if (startsWith) {
            g.vx();
            if (g.vu().uz() && j > 0 && j < 1000 && new File(this.cjZ).exists()) {
                return true;
            }
        }
        this.ckh = Ni;
        boolean sj = f.sj();
        r8 = new Object[5];
        g.vx();
        r8[1] = o.getString(g.vu().uin);
        r8[2] = Long.valueOf(j);
        r8[3] = this.cjZ;
        r8[4] = com.tencent.mm.compatible.util.e.cni;
        v.i("MMKernel.CoreStorage", "isSDCardAvail:%b uin:%s toNow:%d sysPath:[%s] sdRoot:[%s]", r8);
        if (!sj) {
            return false;
        }
        if (startsWith) {
            return true;
        }
        g.vx();
        if (!g.vu().uz()) {
            return true;
        }
        v.i("MMKernel.CoreStorage", "summer isSDCardAvailable accHasReady and remount");
        vi();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void vi() {
        /*
        r7 = this;
        com.tencent.mm.kernel.g.vx();
        r0 = com.tencent.mm.kernel.g.vu();
        r1 = r0.cjn;
        monitor-enter(r1);
        r2 = ve();	 Catch:{ all -> 0x008b }
        r3 = "MMKernel.CoreStorage";
        r4 = "remount begin uin:%d oldpath:[%s] newPath:[%s]";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x008b }
        r6 = 0;
        r0 = r0.uin;	 Catch:{ all -> 0x008b }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x008b }
        r5[r6] = r0;	 Catch:{ all -> 0x008b }
        r0 = 1;
        r6 = r7.cjZ;	 Catch:{ all -> 0x008b }
        r5[r0] = r6;	 Catch:{ all -> 0x008b }
        r0 = 2;
        r5[r0] = r2;	 Catch:{ all -> 0x008b }
        com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);	 Catch:{ all -> 0x008b }
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r2);	 Catch:{ all -> 0x008b }
        if (r0 != 0) goto L_0x012c;
    L_0x0031:
        r0 = r7.cjZ;	 Catch:{ all -> 0x008b }
        r0 = r2.equalsIgnoreCase(r0);	 Catch:{ all -> 0x008b }
        if (r0 == 0) goto L_0x00aa;
    L_0x0039:
        r0 = "MMKernel.CoreStorage";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006f }
        r3 = "testSdcardWritable done ret:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x006f }
        r3 = vj();	 Catch:{ Exception -> 0x006f }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x006f }
        r2 = r2.toString();	 Catch:{ Exception -> 0x006f }
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);	 Catch:{ Exception -> 0x006f }
    L_0x0053:
        r0 = "MMKernel.CoreStorage";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008e }
        r3 = "testSdcardReadable done ret:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x008e }
        r3 = vk();	 Catch:{ Exception -> 0x008e }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x008e }
        r2 = r2.toString();	 Catch:{ Exception -> 0x008e }
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);	 Catch:{ Exception -> 0x008e }
    L_0x006d:
        monitor-exit(r1);	 Catch:{ all -> 0x008b }
    L_0x006e:
        return;
    L_0x006f:
        r0 = move-exception;
        r2 = "MMKernel.CoreStorage";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008b }
        r4 = "testSdcardWritable Exception e: ";
        r3.<init>(r4);	 Catch:{ all -> 0x008b }
        r0 = r0.getMessage();	 Catch:{ all -> 0x008b }
        r0 = r3.append(r0);	 Catch:{ all -> 0x008b }
        r0 = r0.toString();	 Catch:{ all -> 0x008b }
        com.tencent.mm.sdk.platformtools.v.w(r2, r0);	 Catch:{ all -> 0x008b }
        goto L_0x0053;
    L_0x008b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x008b }
        throw r0;
    L_0x008e:
        r0 = move-exception;
        r2 = "MMKernel.CoreStorage";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008b }
        r4 = "testSdcardReadable Exception e: ";
        r3.<init>(r4);	 Catch:{ all -> 0x008b }
        r0 = r0.getMessage();	 Catch:{ all -> 0x008b }
        r0 = r3.append(r0);	 Catch:{ all -> 0x008b }
        r0 = r0.toString();	 Catch:{ all -> 0x008b }
        com.tencent.mm.sdk.platformtools.v.w(r2, r0);	 Catch:{ all -> 0x008b }
        goto L_0x006d;
    L_0x00aa:
        r0 = "MMKernel.CoreStorage";
        r3 = "remount resetSysPath sysPath:[%s] newSysPath:[%s] accPath:[%s] cachePath: [%s]";
        r4 = 4;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x008b }
        r5 = 0;
        r6 = r7.cjZ;	 Catch:{ all -> 0x008b }
        r4[r5] = r6;	 Catch:{ all -> 0x008b }
        r5 = 1;
        r4[r5] = r2;	 Catch:{ all -> 0x008b }
        r5 = 2;
        r6 = r7.cka;	 Catch:{ all -> 0x008b }
        r4[r5] = r6;	 Catch:{ all -> 0x008b }
        r5 = 3;
        r6 = r7.cachePath;	 Catch:{ all -> 0x008b }
        r4[r5] = r6;	 Catch:{ all -> 0x008b }
        com.tencent.mm.sdk.platformtools.v.i(r0, r3, r4);	 Catch:{ all -> 0x008b }
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r2);	 Catch:{ all -> 0x008b }
        if (r0 != 0) goto L_0x0110;
    L_0x00ce:
        r7.cjZ = r2;	 Catch:{ all -> 0x008b }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008b }
        r2 = "mm";
        r0.<init>(r2);	 Catch:{ all -> 0x008b }
        com.tencent.mm.kernel.g.vx();	 Catch:{ all -> 0x008b }
        r2 = com.tencent.mm.kernel.g.vu();	 Catch:{ all -> 0x008b }
        r2 = r2.uin;	 Catch:{ all -> 0x008b }
        r0 = r0.append(r2);	 Catch:{ all -> 0x008b }
        r0 = r0.toString();	 Catch:{ all -> 0x008b }
        r0 = r0.getBytes();	 Catch:{ all -> 0x008b }
        r0 = com.tencent.mm.a.g.m(r0);	 Catch:{ all -> 0x008b }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008b }
        r2.<init>();	 Catch:{ all -> 0x008b }
        r3 = r7.cjZ;	 Catch:{ all -> 0x008b }
        r2 = r2.append(r3);	 Catch:{ all -> 0x008b }
        r0 = r2.append(r0);	 Catch:{ all -> 0x008b }
        r2 = "/";
        r0 = r0.append(r2);	 Catch:{ all -> 0x008b }
        r0 = r0.toString();	 Catch:{ all -> 0x008b }
        r7.cka = r0;	 Catch:{ all -> 0x008b }
        r7.vc();	 Catch:{ all -> 0x008b }
    L_0x0110:
        r0 = r7.cjU;	 Catch:{ all -> 0x008b }
        r0.vo();	 Catch:{ all -> 0x008b }
        r0 = "MMKernel.CoreStorage";
        r2 = "remout isSDCardAvail :[%b] done";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x008b }
        r4 = 0;
        r5 = com.tencent.mm.compatible.util.f.sj();	 Catch:{ all -> 0x008b }
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ all -> 0x008b }
        r3[r4] = r5;	 Catch:{ all -> 0x008b }
        com.tencent.mm.sdk.platformtools.v.i(r0, r2, r3);	 Catch:{ all -> 0x008b }
    L_0x012c:
        monitor-exit(r1);	 Catch:{ all -> 0x008b }
        goto L_0x006e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.e.vi():void");
    }

    private static boolean vj() {
        boolean canWrite;
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        boolean z = false;
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = com.tencent.mm.compatible.util.e.cni.equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            canWrite = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        } catch (Exception e2) {
            v.w("MMKernel.CoreStorage", "testSdcardWritable 1 e: " + e2.getMessage());
            canWrite = false;
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "test_writable");
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write("test".getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                boolean delete = file.delete();
                try {
                    fileOutputStream.close();
                    z = delete;
                } catch (Throwable e3) {
                    v.e("MMKernel.CoreStorage", "exception:%s", be.e(e3));
                    z = delete;
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    v.w("MMKernel.CoreStorage", "testSdcardWritable 2 e: " + e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e5) {
                            v.e("MMKernel.CoreStorage", "exception:%s", be.e(e5));
                        }
                    }
                    v.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.cni + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e52) {
                            v.e("MMKernel.CoreStorage", "exception:%s", be.e(e52));
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            v.w("MMKernel.CoreStorage", "testSdcardWritable 2 e: " + e.getMessage());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            v.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.cni + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        v.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.cni + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
        return z;
    }

    private static boolean vk() {
        boolean canRead;
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = com.tencent.mm.compatible.util.e.cni.equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            canRead = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canRead();
        } catch (Exception e) {
            Exception exception = e;
            canRead = false;
            v.w("MMKernel.CoreStorage", "testSdcardReadable 1 e: " + exception.getMessage());
        }
        File file = new File(com.tencent.mm.compatible.util.e.cnj);
        boolean exists = file.exists();
        if (exists) {
            v.i("MMKernel.CoreStorage", "testSdcardReadable testFile isDirectory:" + file.isDirectory() + " isFile:" + file.isFile());
        }
        v.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.cni + " CConstants.DATAROOT_SDCARD_PATH: " + com.tencent.mm.compatible.util.e.cnj + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canRead: " + canRead + " canTrueRead:" + exists);
        return exists;
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("CONFIG_TABLE".hashCode()), new com.tencent.mm.bg.g.c() {
            public final String[] pS() {
                return r.cic;
            }
        });
    }

    final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        HashMap<Integer, com.tencent.mm.bg.g.c> hashMap = new HashMap();
        hashMap.putAll(bXq);
        synchronized (this.cjX) {
            for (com.tencent.mm.kernel.api.a vD : this.cjX) {
                hashMap.putAll(vD.vD());
            }
        }
        return hashMap;
    }
}
