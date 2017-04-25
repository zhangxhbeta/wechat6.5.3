package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.pb.common.c.c;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class e implements b {
    private static e ppp = null;
    private Vector<d> cAb = new Vector();
    private Vector<d> cAc = new Vector();
    private final Handler handler = new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ e pps;

        public final void handleMessage(Message message) {
            this.pps.a((d) message.obj);
        }
    };
    private final SparseArray<Set<b>> ppq = new SparseArray();
    private d ppr = null;

    private e() {
    }

    public static e bLT() {
        if (ppp == null) {
            synchronized (e.class) {
                if (ppp == null) {
                    ppp = new e();
                }
            }
        }
        return ppp;
    }

    public final void a(int i, b bVar) {
        if (this.ppq.get(i) == null) {
            this.ppq.put(i, new HashSet());
        }
        if (!((Set) this.ppq.get(i)).contains(bVar)) {
            ((Set) this.ppq.get(i)).add(bVar);
        }
    }

    public final boolean a(d dVar) {
        if (!h.isNetworkConnected()) {
            int type = dVar.getType();
            if (type == MMGIFException.D_GIF_ERR_READ_FAILED || type == MMGIFException.D_GIF_ERR_NO_SCRN_DSCR || type == MMGIFException.D_GIF_ERR_NOT_GIF_FILE) {
                c.i("MicroMsg.Voip", "doScene do retain mReissueNetScene");
                this.ppr = dVar;
            }
        }
        Assert.assertTrue(true);
        if (dVar == null) {
            return false;
        }
        a(dVar, 0);
        return true;
    }

    private void a(final d dVar, int i) {
        if (bLU()) {
            int i2;
            this.cAb.add(dVar);
            if (dVar.pph == null) {
                c.i("MicroMsg.Voip", dVar.ppf, "dosene reqData is null cmd=" + dVar.ppj);
                i2 = -1;
            } else {
                dVar.ppg = this;
                i2 = f.bLW().a(null, new i(dVar), dVar.ppj, dVar.bLS(), dVar.pph, dVar.ppl);
                if (i2 >= 0) {
                    dVar.mHandler.postDelayed(dVar.cAx, 60000);
                }
                c.d("MicroMsg.Voip", "NETTASK_SEND dosene:cmd ", dVar.bLS(), Integer.valueOf(i2));
            }
            if (i2 < 0) {
                c.i("MicroMsg.Voip", "doSceneImp do scene failed, ret %d,", Integer.valueOf(i2));
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ e pps;

                    public final void run() {
                        this.pps.cAb.remove(dVar);
                        this.pps.a(2, -1, "doScene failed", dVar);
                    }
                });
            }
        } else {
            this.cAc.add(dVar);
        }
        BN();
    }

    public final void a(int i, int i2, String str, d dVar) {
        this.cAb.remove(dVar);
        BN();
        final d dVar2 = dVar;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        this.handler.post(new Runnable(this) {
            final /* synthetic */ e pps;

            public final void run() {
                Set set = (Set) this.pps.ppq.get(dVar2.getType());
                if (set != null && set.size() > 0) {
                    Set<b> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (b bVar : hashSet) {
                        if (bVar != null && set.contains(bVar)) {
                            bVar.a(i3, i4, str2, dVar2);
                        }
                    }
                }
            }
        });
    }

    private void BN() {
        if (this.cAc.size() > 0) {
            d dVar = (d) this.cAc.get(0);
            for (int i = 1; i < this.cAc.size(); i++) {
                this.cAc.get(i);
            }
            if (bLU()) {
                this.cAc.remove(dVar);
                a(dVar, 0);
            }
        }
    }

    private boolean bLU() {
        if (this.cAb.size() >= 20) {
            return false;
        }
        return true;
    }
}
