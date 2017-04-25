package com.tencent.mm.pluginsdk.k.a.c;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class j implements c {
    private final ac lEj;
    public final SparseArray<List<d>> lEk = new SparseArray();
    public final Object lEl = new Object();

    j(ac acVar) {
        this.lEj = acVar;
    }

    public final void a(f fVar, final m mVar) {
        v.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = " + mVar);
        r Hg;
        final List He;
        final String bnQ;
        switch (mVar.status) {
            case 2:
                Hg = a.lED.Hg(mVar.lCO);
                if (Hg != null) {
                    Hg.field_status = 2;
                    a.lED.e(Hg);
                }
                v.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + fVar.Pa());
                He = He(fVar.Pa());
                if (be.bP(He)) {
                    v.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
                    return;
                }
                v.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + He.size());
                bnQ = fVar.bnQ();
                this.lEj.post(new Runnable(this) {
                    final /* synthetic */ j lEn;

                    public final void run() {
                        for (d dVar : He) {
                            if (be.ma(dVar.Pa()).equals(mVar.lEs)) {
                                dVar.a(bnQ, mVar);
                            }
                        }
                    }
                });
                return;
            case 3:
                Hg = a.lED.Hg(mVar.lCO);
                if (Hg != null) {
                    Hg.field_status = 3;
                    a.lED.e(Hg);
                }
                He = He(fVar.Pa());
                if (!be.bP(He)) {
                    bnQ = fVar.bnQ();
                    this.lEj.post(new Runnable(this) {
                        final /* synthetic */ j lEn;

                        public final void run() {
                            for (d dVar : He) {
                                if (be.ma(dVar.Pa()).equals(mVar.lEs)) {
                                    dVar.b(bnQ, mVar);
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            case 4:
                Hg = a.lED.Hg(mVar.lCO);
                if (Hg != null) {
                    Hg.field_status = 4;
                    a.lED.e(Hg);
                }
                He = He(fVar.Pa());
                if (!be.bP(He)) {
                    bnQ = fVar.bnQ();
                    this.lEj.post(new Runnable(this) {
                        final /* synthetic */ j lEn;

                        public final void run() {
                            for (d dVar : He) {
                                if (be.ma(dVar.Pa()).equals(mVar.lEs)) {
                                    dVar.Ev(bnQ);
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void j(String str, int i, int i2) {
        v.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        r Hg = a.lED.Hg(str);
        if (Hg != null) {
            Hg.field_maxRetryTimes = i;
            Hg.field_retryTimes = i2;
            a.lED.e(Hg);
        }
    }

    public final void m(String str, long j) {
        r Hg = a.lED.Hg(str);
        if (Hg != null) {
            Hg.field_contentLength = j;
            a.lED.e(Hg);
        }
    }

    private List<d> He(String str) {
        List<d> list;
        int hashCode = str.hashCode();
        synchronized (this.lEl) {
            list = (List) this.lEk.get(hashCode);
        }
        return list;
    }
}
