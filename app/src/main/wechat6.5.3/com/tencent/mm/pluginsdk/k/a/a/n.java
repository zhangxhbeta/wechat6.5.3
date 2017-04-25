package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.ipcall.d;
import com.tencent.mm.protocal.c.aqq;
import com.tencent.mm.protocal.c.aqv;
import com.tencent.mm.protocal.c.aqw;
import com.tencent.mm.protocal.c.km;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class n extends k implements j {
    private volatile e cii;
    protected final List<aqw> lDW = new LinkedList();

    protected abstract p bnZ();

    protected abstract km g(p pVar);

    protected abstract String getTag();

    static /* synthetic */ void a(n nVar, int i, aqq com_tencent_mm_protocal_c_aqq) {
        v.i(nVar.getTag(), "resType = %d, subType = %d, res.Oper = %d", Integer.valueOf(i), Integer.valueOf(com_tencent_mm_protocal_c_aqq.mNI), Integer.valueOf(com_tencent_mm_protocal_c_aqq.myO));
        if (com_tencent_mm_protocal_c_aqq.mPV != null) {
            v.i(nVar.getTag(), "resource.Info.FileFlag %d ", Integer.valueOf(com_tencent_mm_protocal_c_aqq.mPV.mQf));
        }
        if (b.tI(com_tencent_mm_protocal_c_aqq.myO)) {
            v.i(nVar.getTag(), "just do nothing");
            return;
        }
        if (b.tJ(com_tencent_mm_protocal_c_aqq.myO)) {
            v.i(nVar.getTag(), "do cache");
            b.lDs.b(i, com_tencent_mm_protocal_c_aqq, false);
        }
        if (b.tK(com_tencent_mm_protocal_c_aqq.myO)) {
            v.i(nVar.getTag(), "do decrypt");
            b.lDs.c(i, com_tencent_mm_protocal_c_aqq, false);
        }
        if (b.tL(com_tencent_mm_protocal_c_aqq.myO)) {
            v.i(nVar.getTag(), "do delete");
            b.lDs.a(i, com_tencent_mm_protocal_c_aqq, false);
        }
    }

    public n() {
        for (int i : i.lDA) {
            if (i != 39 || d.atT()) {
                aqw com_tencent_mm_protocal_c_aqw = new aqw();
                com_tencent_mm_protocal_c_aqw.efm = i;
                this.lDW.add(com_tencent_mm_protocal_c_aqw);
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.d(getTag(), "before dispatch");
        return a(eVar, bnZ(), this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (ak.uz()) {
            long Nh = be.Nh() + 86400;
            ak.yW();
            c.vf().a(a.USERINFO_RES_DOWNLOADER_CHECK_RES_UPDATE_INTERVAL_LONG, Long.valueOf(Nh));
        }
        if (i2 == 0 && i3 == 0) {
            km g = g(pVar);
            String tag = getTag();
            String str2 = "response.Res.size() = %s";
            Object[] objArr = new Object[1];
            objArr[0] = be.bP(g.mmZ) ? "null" : String.valueOf(g.mmZ.size());
            v.i(tag, str2, objArr);
            if (!be.bP(g.mmZ)) {
                final List list = g.mmZ;
                com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                    final /* synthetic */ n lDY;

                    public final void run() {
                        for (aqv com_tencent_mm_protocal_c_aqv : list) {
                            String tag = this.lDY.getTag();
                            String str = "resType(%d) responses.size() = %s";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(com_tencent_mm_protocal_c_aqv.efm);
                            objArr[1] = be.bP(com_tencent_mm_protocal_c_aqv.mQj) ? "null" : String.valueOf(com_tencent_mm_protocal_c_aqv.mQj.size());
                            v.i(tag, str, objArr);
                            if (!be.bP(com_tencent_mm_protocal_c_aqv.mQj)) {
                                Iterator it = com_tencent_mm_protocal_c_aqv.mQj.iterator();
                                while (it.hasNext()) {
                                    n.a(this.lDY, com_tencent_mm_protocal_c_aqv.efm, (aqq) it.next());
                                }
                            }
                        }
                    }
                }, "NetSceneCheckResUpdate-ResponseHandlingThread");
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
