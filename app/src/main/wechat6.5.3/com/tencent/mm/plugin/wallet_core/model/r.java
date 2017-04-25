package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.e.a.ql;
import com.tencent.mm.e.a.ql.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.wallet_core.b.b.a;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.List;

public final class r extends c<ql> implements e {
    private boolean fTx;
    private ql kQs;

    public r() {
        this.fTx = false;
        this.nhz = ql.class.getName().hashCode();
    }

    private boolean a(ql qlVar) {
        if (qlVar instanceof ql) {
            this.fTx = false;
            this.kQs = qlVar;
            ak.vy().a(385, this);
            ak.vy().a(1518, this);
            if (k.bga().bgu()) {
                v.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
                if (k.xT()) {
                    ak.vy().a(new a(), 0);
                } else {
                    ak.vy().a(new l(null, 1), 0);
                }
            } else {
                long ax = be.ax(k.bga().kQV);
                v.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time " + ax, new Object[]{Long.valueOf(r2.kQV), Long.valueOf(System.currentTimeMillis() / 1000)});
                if (ax > 0) {
                    v.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
                    if (k.xT()) {
                        ak.vy().a(new a(), 0);
                    } else {
                        ak.vy().a(new l(null, 1), 0);
                    }
                } else {
                    this.fTx = true;
                }
                v.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
                a(0, "", null);
            }
            return true;
        }
        v.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if ((kVar instanceof l) || (kVar instanceof a)) {
            ak.vy().b(385, this);
            ak.vy().b(1518, this);
            this.fTx = true;
            a(i2, str, kVar);
        }
    }

    private void a(int i, String str, com.tencent.mm.v.k kVar) {
        boolean z = true;
        if (!(this.kQs == null || this.kQs.bpT == null)) {
            this.kQs.brL.errCode = i;
            this.kQs.brL.biS = str;
            this.kQs.brL.brM = k.bga().bgv();
            b bVar = this.kQs.brL;
            ab bga = k.bga();
            boolean z2 = (bga.kQS != null && bga.kQS.bgn()) || (bga.kGP != null && bga.kGP.size() > 0);
            z2 = z2 ? false : bga.kGO == null || bga.kGO.size() <= 0;
            bVar.brN = z2;
            b bVar2 = this.kQs.brL;
            ab bga2 = k.bga();
            ArrayList arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            bga2.d(arrayList, arrayList2);
            if (!ab.bA(arrayList2)) {
                z = false;
            }
            bVar2.brO = z;
            this.kQs.brL.brP = k.bga().bgz().bgn();
            this.kQs.brL.brQ = k.bga().bgy();
            this.kQs.brL.brR = k.bga().bgB();
            this.kQs.brL.brS = k.bga().bgw();
            this.kQs.brL.brT = k.bga().bgz().bgq();
            this.kQs.brL.brU = "";
            if (kVar != null && (kVar instanceof l)) {
                this.kQs.brL.brU = ((l) kVar).brU;
                this.kQs.brL.brV = ((l) kVar).brV;
                this.kQs.brL.brW = ((l) kVar).brW;
                this.kQs.brL.brX = ((l) kVar).brX;
                this.kQs.brL.brY = ((l) kVar).brY;
            }
            v.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.kQs.brL.brN + " hasNewTips : " + this.kQs.brL.brO + " swipeOn : " + this.kQs.brL.brP);
            this.kQs.bpT.run();
        }
        if (this.fTx) {
            this.kQs = null;
        }
    }
}
