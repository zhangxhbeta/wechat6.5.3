package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

final class e {
    private static long ngo = 125829120;
    private static long ngp = 314572800;
    ah aSW = new ah(new a(this) {
        final /* synthetic */ e ngu;

        {
            this.ngu = r1;
        }

        public final boolean oU() {
            this.ngu.is(true);
            return true;
        }
    }, true);
    private boolean cit = false;
    boolean fMm = false;
    private long ngq = 0;
    private long ngr = 0;
    private String ngs = null;
    private i ngt;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ e ngu;
        final /* synthetic */ long ngv;

        AnonymousClass2(e eVar, long j) {
            this.ngu = eVar;
            this.ngv = j;
        }

        public final void run() {
            v.d("MicroMsg.TrafficStatistic", "onUpstreamTraffic upstream : %s", Long.valueOf(this.ngv));
            e.a(this.ngu, Math.max(0, this.ngv));
            this.ngu.is(false);
        }
    }

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ e ngu;
        final /* synthetic */ long ngw;

        AnonymousClass3(e eVar, long j) {
            this.ngu = eVar;
            this.ngw = j;
        }

        public final void run() {
            v.d("MicroMsg.TrafficStatistic", "onDownstreamTraffic downstream : %s", Long.valueOf(this.ngw));
            e.b(this.ngu, Math.max(0, this.ngw));
            this.ngu.is(false);
        }
    }

    static /* synthetic */ long a(e eVar, long j) {
        long j2 = eVar.ngq + j;
        eVar.ngq = j2;
        return j2;
    }

    static /* synthetic */ long b(e eVar, long j) {
        long j2 = eVar.ngr + j;
        eVar.ngr = j2;
        return j2;
    }

    public e(i iVar) {
        this.ngt = iVar;
    }

    public final void bD(String str, int i) {
        if (!be.kS(str)) {
            if (!str.equals(this.ngs)) {
                stop();
            }
            v.i("MicroMsg.TrafficStatistic", "pack size: " + i);
            v.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", Long.valueOf(ngo));
            ngo = Math.max((long) (i * 4), ngo);
            ngo = Math.min(ngp, ngo);
            v.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", Long.valueOf(ngo));
            if (!this.cit) {
                if (this.ngt.mContext != null) {
                    this.fMm = ak.isWifi(this.ngt.mContext);
                }
                this.aSW.ea(30000);
                this.cit = true;
                this.ngs = str;
            }
        }
    }

    public final void stop() {
        is(true);
        this.aSW.QI();
        this.cit = false;
    }

    final void is(boolean z) {
        long j = 0;
        if (z || this.ngq + this.ngr >= 524288) {
            if (this.ngq + this.ngr > 0) {
                Intent intent = new Intent();
                intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
                intent.putExtra("intent_extra_flow_stat_upstream", this.ngq);
                intent.putExtra("intent_extra_flow_stat_downstream", this.ngr);
                if (this.ngt.mContext != null) {
                    this.fMm = ak.isWifi(this.ngt.mContext);
                }
                intent.putExtra("intent_extra_flow_stat_is_wifi", this.fMm);
                if (this.ngt.mContext != null) {
                    this.ngt.mContext.sendBroadcast(intent, "com.tencent.mm.permission.MM_MESSAGE");
                }
            }
            if (be.kS(this.ngs)) {
                v.e("MicroMsg.TrafficStatistic", "traffic is null!");
            } else {
                long f = h.f(this.ngs, this.ngq, this.ngr);
                this.ngq = 0;
                this.ngr = 0;
                j = f;
            }
            if (j >= ngo && this.ngt.jHv == 2) {
                v.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
                this.ngt.cancel();
            }
        }
    }

    public static boolean JL(String str) {
        if (h.JN(str) <= ngo) {
            return false;
        }
        v.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
        return true;
    }
}
