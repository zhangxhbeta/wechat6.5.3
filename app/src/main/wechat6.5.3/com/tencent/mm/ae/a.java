package com.tencent.mm.ae;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.mm.e.a.jr;
import com.tencent.mm.e.a.s;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import java.lang.ref.WeakReference;
import java.util.Stack;

public final class a implements com.tencent.mm.ae.c.a {
    private a cKO;
    public Stack<Long> cKP;
    long cKQ = 0;
    public int cKR = 0;
    boolean cKS = false;
    public long cKT = 0;
    int cKU = 0;
    boolean cKV = false;
    long cKW = 0;
    long cKX = 0;
    int cKY;
    int cKZ;
    ah cLa = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ a cLd;

        {
            this.cLd = r1;
        }

        public final boolean oU() {
            long uidRxBytes = TrafficStats.getUidRxBytes(this.cLd.cKY);
            long uidTxBytes = TrafficStats.getUidTxBytes(this.cLd.cKY);
            long j = (uidRxBytes - this.cLd.cKW) + (uidTxBytes - this.cLd.cKX);
            v.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + (j / 1024));
            if (j <= 20480) {
                this.cLd.cKV = false;
                this.cLd.start();
            } else {
                this.cLd.cKW = uidRxBytes;
                this.cLd.cKX = uidTxBytes;
                this.cLd.cLa.ea(1000);
            }
            return true;
        }
    }, false);
    c cLb = new c<jr>(this) {
        final /* synthetic */ a cLd;

        {
            this.cLd = r2;
            this.nhz = jr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jr jrVar = (jr) bVar;
            a aVar = this.cLd;
            aVar.cKU = (jrVar.bkd.bke ? 1 : -1) + aVar.cKU;
            if (this.cLd.cKU < 0) {
                this.cLd.cKU = 0;
                v.e("MicroMsg.AutoGetBigImgLogic", "mPauseCnt < 0");
            }
            v.i("MicroMsg.AutoGetBigImgLogic", "req pause: " + jrVar.bkd.bke + " count:" + this.cLd.cKU);
            this.cLd.start();
            return false;
        }
    };
    c cLc = new c<s>(this) {
        final /* synthetic */ a cLd;

        {
            this.cLd = r2;
            this.nhz = s.class.getName().hashCode();
        }

        private boolean a(s sVar) {
            this.cLd.cKZ = sVar.aXf.mode;
            v.d("MicroMsg.AutoGetBigImgLogic", "mode = " + this.cLd.cKZ);
            com.tencent.mm.modelcontrol.c.Eg();
            if (!com.tencent.mm.modelcontrol.c.Eh()) {
                synchronized (this.cLd.cKP) {
                    this.cLd.cKP.clear();
                }
            }
            return false;
        }
    };

    static class a extends ac {
        private WeakReference<a> cLe;

        public a(a aVar, Looper looper) {
            super(looper);
            this.cLe = new WeakReference(aVar);
        }

        public final void handleMessage(Message message) {
            a aVar = (a) this.cLe.get();
            if (aVar != null && 1 == message.what) {
                if (!aVar.cKS && System.currentTimeMillis() - aVar.cKT > 1200000) {
                    v.d("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
                } else if (aVar.cKQ != 0 || aVar.cKP.size() <= 0 || aVar.cKU != 0 || aVar.cKV) {
                    v.d("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + aVar.cKQ + " size: " + aVar.cKP.size() + " cnt: " + aVar.cKU + " pauseOnMonitor: " + aVar.cKV);
                } else {
                    synchronized (aVar.cKP) {
                        aVar.cKQ = ((Long) aVar.cKP.pop()).longValue();
                    }
                    ak.yW();
                    bx ek = com.tencent.mm.model.c.wJ().ek(aVar.cKQ);
                    d ah = n.GH().ah(ek.field_msgSvrId);
                    if (ah.bNt == 1) {
                        v.d("MicroMsg.AutoGetBigImgLogic", aVar.cKQ + " already has hd thumb");
                        aVar.cKQ = 0;
                        aVar.start();
                        return;
                    }
                    v.d("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + aVar.cKQ + "  image_" + ek.field_msgId);
                    g.DZ().cFg.add("image_" + ek.field_msgId);
                    n.GI().a(ah.cLu, ek.field_msgId, Long.valueOf(aVar.cKQ), aVar.cKR, aVar);
                }
            }
        }
    }

    public a(Looper looper) {
        this.cKO = new a(this, looper);
        this.cKP = new Stack();
        this.cKY = Process.myUid();
        ak.yW();
        Integer num = (Integer) com.tencent.mm.model.c.vf().get(327681, null);
        int intValue = (num == null || 3 == num.intValue()) ? 1 : num.intValue();
        this.cKZ = intValue;
        com.tencent.mm.sdk.c.a.nhr.e(this.cLb);
        com.tencent.mm.sdk.c.a.nhr.e(this.cLc);
    }

    public final void start() {
        this.cKO.sendEmptyMessage(1);
    }

    public final void aR(boolean z) {
        v.d("MicroMsg.AutoGetBigImgLogic", "is foreground: " + z);
        this.cKS = z;
        this.cKT = System.currentTimeMillis();
    }

    public final void a(long j, int i, int i2, Object obj, int i3, int i4, k kVar) {
    }

    public static void a(long j, long j2, boolean z) {
        if (!z) {
            v.i("MicroMsg.AutoGetBigImgLogic", "imglocalId " + j + " msglocalid " + j2 + " false");
        } else if (com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
            v.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
        } else {
            ak.yW();
            long a = be.a((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0);
            long KM = be.KM((String) DateFormat.format("M", System.currentTimeMillis()));
            v.d("MicroMsg.AutoGetBigImgLogic", "img " + j + " msgLocalId: " + j2 + " has been downloaded current %d month %d", Long.valueOf(1 + a), Long.valueOf(KM));
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(a + 1));
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(KM));
        }
    }

    public final void a(long j, long j2, int i, Object obj, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            a(j, j2, true);
        } else {
            v.e("MicroMsg.AutoGetBigImgLogic", "img " + j + "msgLocalId " + j2 + " download failed");
        }
        this.cKQ = 0;
        com.tencent.mm.modelcontrol.c.Eg();
        if (com.tencent.mm.modelcontrol.c.Eh()) {
            this.cKW = TrafficStats.getUidRxBytes(this.cKY);
            this.cKX = TrafficStats.getUidTxBytes(this.cKY);
            this.cLa.ea(1000);
            return;
        }
        v.d("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
        synchronized (this.cKP) {
            this.cKP.clear();
        }
    }

    public final void a(long j, Object obj) {
        v.i("MicroMsg.AutoGetBigImgLogic", "img " + j + " has been canceled");
    }
}
