package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.e.a.ha;
import com.tencent.mm.e.a.qb;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.a.b.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.b;
import java.io.File;
import java.util.Map;

public final class k extends a implements d {
    public static long a(File file, long j) {
        long j2;
        Throwable e;
        try {
            File[] listFiles = file.listFiles();
            j2 = 0;
            int i = 0;
            while (i < listFiles.length) {
                try {
                    if (listFiles[i].isDirectory()) {
                        j2 += a(listFiles[i], j);
                    } else {
                        if (listFiles[i].length() > j) {
                            v.i("MicroMsg.NetStatMsgExtension", "getFolderSize filesize:%s [%s]", Long.valueOf(listFiles[i].length()), listFiles[i].getPath());
                        }
                        j2 += listFiles[i].length();
                    }
                    i++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            j2 = 0;
            e = th;
            v.e("MicroMsg.NetStatMsgExtension", "getFolderSize :%s", be.e(e));
            return j2;
        }
        return j2;
    }

    public final b b(d.a aVar) {
        if (ak.uz()) {
            String str = aVar.czu.mbW.mQy;
            v.d("MicroMsg.NetStatMsgExtension", "onPreAddMessage %s", str);
            if (!be.kS(str)) {
                v.i("MicroMsg.NetStatMsgExtension", "get ipxx cmd=%s", str);
                Map q = bf.q(str, "cmd");
                if (q != null) {
                    int i = be.getInt((String) q.get(".cmd.trace.$code"), -1);
                    if (i <= 0) {
                        int i2 = be.getInt((String) q.get(".cmd.hprof.$type"), -1);
                        if (i2 > 0) {
                            v.d("MicroMsg.NetStatMsgExtension", "hprof type: %d", Integer.valueOf(i2));
                            com.tencent.mm.bh.b.vp(i2);
                        } else {
                            if ("android".equalsIgnoreCase((String) q.get(".cmd.hotpatch.$os"))) {
                                com.tencent.mm.sdk.c.b haVar = new ha();
                                haVar.bgH.bgI = (String) q.get(".cmd.hotpatch.xml.$url");
                                haVar.bgH.bgJ = (String) q.get(".cmd.hotpatch.xml.$signature");
                                haVar.bgH.bgK = (String) q.get(".cmd.hotpatch.$url");
                                haVar.bgH.bgL = (String) q.get(".cmd.hotpatch.$signature");
                                com.tencent.mm.sdk.c.a.nhr.a(haVar, Looper.myLooper());
                            } else {
                                String str2;
                                i2 = be.getInt((String) q.get(".cmd.clearfile.$fb"), -1);
                                final long j;
                                if (i2 == 1) {
                                    j = (long) be.getInt((String) q.get(".cmd.clearfile.$ps"), 1048576);
                                    ak.vA().x(new Runnable(this) {
                                        final /* synthetic */ k dde;

                                        public final void run() {
                                            long Ni = be.Ni();
                                            ak.yW();
                                            Object[] objArr = new Object[2];
                                            objArr[0] = Long.valueOf(k.a(new File(c.xp()), j));
                                            ak.yW();
                                            objArr[1] = c.xp();
                                            v.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", objArr);
                                            ak.yW();
                                            objArr = new Object[2];
                                            objArr[0] = Long.valueOf(k.a(new File(c.wx()), j));
                                            ak.yW();
                                            objArr[1] = c.wx();
                                            v.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", objArr);
                                            ak.yW();
                                            objArr = new Object[2];
                                            objArr[0] = Long.valueOf(k.a(new File(c.wx()), j));
                                            ak.yW();
                                            objArr[1] = c.wx();
                                            v.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", objArr);
                                            ak.yW();
                                            objArr = new Object[2];
                                            objArr[0] = Long.valueOf(k.a(new File(c.xq()), j));
                                            ak.yW();
                                            objArr[1] = c.xq();
                                            v.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", objArr);
                                            long a = k.a(new File(t.cng), j);
                                            v.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(a), t.cng);
                                            v.i("MicroMsg.NetStatMsgExtension", "clearfile finish %s", Long.valueOf(be.Ni() - Ni));
                                        }
                                    });
                                } else if (i2 == 2) {
                                    str2 = (String) q.get(".cmd.clearfile.$pd");
                                    File file = new File(str2);
                                    String str3 = "MicroMsg.NetStatMsgExtension";
                                    String str4 = "clearfile delete :[%s] length:%s";
                                    Object[] objArr = new Object[2];
                                    objArr[0] = str2;
                                    objArr[1] = Long.valueOf(file.exists() ? file.length() : -1);
                                    v.i(str3, str4, objArr);
                                    com.tencent.mm.loader.stub.b.deleteFile(str2);
                                    file = new File(str2);
                                    String str5 = "MicroMsg.NetStatMsgExtension";
                                    String str6 = "clearfile delete finish :[%s] length:%s";
                                    Object[] objArr2 = new Object[2];
                                    objArr2[0] = str2;
                                    if (file.exists()) {
                                        j = file.length();
                                    } else {
                                        j = -1;
                                    }
                                    objArr2[1] = Long.valueOf(j);
                                    v.i(str5, str6, objArr2);
                                } else if (i2 == 3) {
                                    StringBuilder stringBuilder = new StringBuilder("running  clearfile start:");
                                    ak.yW();
                                    v.i("MicroMsg.NetStatMsgExtension", stringBuilder.append(c.xn()).append(".tem").toString());
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    ak.yW();
                                    com.tencent.mm.loader.stub.b.deleteFile(stringBuilder2.append(c.xn()).append(".tem").toString());
                                    stringBuilder2 = new StringBuilder();
                                    ak.yW();
                                    com.tencent.mm.loader.stub.b.deleteFile(stringBuilder2.append(c.xo()).append(".tem").toString());
                                    stringBuilder = new StringBuilder("running  clearfile end:");
                                    ak.yW();
                                    v.i("MicroMsg.NetStatMsgExtension", stringBuilder.append(c.xn()).append(".tem").toString());
                                }
                                final int i3 = be.getInt((String) q.get(".cmd.updzh.$pt"), -1);
                                str2 = (String) q.get(".cmd.updzh.$pd");
                                v.d("MicroMsg.NetStatMsgExtension", "StackReportUploader pt:%d pd:%s", Integer.valueOf(i3), str2);
                                if (i3 > 0 && !be.kS(str2)) {
                                    ak.vA().x(new Runnable(this) {
                                        final /* synthetic */ k dde;

                                        public final void run() {
                                            StringBuilder stringBuilder;
                                            switch (i3) {
                                                case 1:
                                                    stringBuilder = new StringBuilder();
                                                    ak.yW();
                                                    p.a(stringBuilder.append(c.xq()).append(str2).toString(), com.tencent.mm.model.k.xF(), false, true);
                                                    return;
                                                case 2:
                                                    stringBuilder = new StringBuilder();
                                                    ak.yW();
                                                    p.a(stringBuilder.append(c.xp()).append(str2).toString(), com.tencent.mm.model.k.xF(), false, true);
                                                    return;
                                                case 3:
                                                    p.a(str2, com.tencent.mm.model.k.xF(), false, true);
                                                    return;
                                                default:
                                                    return;
                                            }
                                        }

                                        public final String toString() {
                                            return super.toString() + "|onPreAddMessage";
                                        }
                                    });
                                }
                            }
                        }
                    } else if (i == 6) {
                        com.tencent.mm.sdk.c.a.nhr.z(new qb());
                    } else {
                        com.tencent.mm.bh.c.byp().c(new com.tencent.mm.bh.c.a((String) q.get(".cmd.trace.$class"), i, be.getInt((String) q.get(".cmd.trace.$size"), 0), be.getInt((String) q.get(".cmd.trace.$type"), 0)));
                    }
                }
                v.bta();
                ak.vy().cAa.gT(str);
                try {
                    Thread.sleep(50, 0);
                } catch (Exception e) {
                }
                LogLogic.initIPxxLogInfo();
                MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
            }
        } else {
            v.e("MicroMsg.NetStatMsgExtension", "skip ipxx stat while account not set");
        }
        return null;
    }

    public final void a(int i, int i2, String str, int i3, String str2, boolean z) {
        final int i4 = i;
        final int i5 = i2;
        final String str3 = str;
        final int i6 = i3;
        final String str4 = str2;
        final boolean z2 = z;
        ak.vA().f(new Runnable(this) {
            final /* synthetic */ k dde;

            public final void run() {
                k.c(i4, i5, i6, z2);
            }

            public final String toString() {
                return super.toString() + "|report";
            }
        }, 3000);
    }

    public final void f(int i, int i2, int i3, int i4) {
        if (ak.uz()) {
            v.i("MicroMsg.NetStatMsgExtension", "reportNetFlow wifi[%d, %d] mobile[%d, %d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            if (i <= 0) {
                i = 0;
            }
            if (i2 <= 0) {
                i2 = 0;
            }
            m.s(i, i2, 0);
            if (i3 <= 0) {
                i3 = 0;
            }
            if (i4 <= 0) {
                i4 = 0;
            }
            m.t(i3, i4, 0);
        }
    }

    public static void c(int i, int i2, int i3, boolean z) {
        if (ak.uz()) {
            switch (i) {
                case 4:
                    v.d("MicroMsg.NetStatMsgExtension", "recv bytes flow:" + i3);
                    if (z) {
                        m.s(i3, 0, i2);
                        return;
                    } else {
                        m.t(i3, 0, i2);
                        return;
                    }
                case 5:
                    v.d("MicroMsg.NetStatMsgExtension", "send bytes flow:" + i3);
                    if (z) {
                        m.s(0, i3, i2);
                        return;
                    } else {
                        m.t(0, i3, i2);
                        return;
                    }
                case 8:
                    ab.Ki("dns_failed_report");
                    return;
                default:
                    return;
            }
        }
    }

    public final void d(at atVar) {
    }
}
