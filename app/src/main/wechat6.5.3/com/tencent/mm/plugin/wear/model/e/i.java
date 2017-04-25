package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.mm.e.a.qw;
import com.tencent.mm.e.a.qx;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.bhl;
import com.tencent.mm.protocal.c.bhm;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class i extends a {
    public bhl lcb;

    public final List<Integer> bhU() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11002));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        if (i != 11002) {
            return null;
        }
        a.cL(1, 0);
        a.sy(0);
        qw qwVar = new qw();
        qwVar.bsA.bsB = aa.getContext().getResources().getStringArray(2131296279);
        qwVar.bsA.aYt = 1;
        com.tencent.mm.sdk.c.a.nhr.z(qwVar);
        byte[] aO = com.tencent.mm.plugin.wear.model.a.bhH().laR.aO(bArr);
        if (aO == null) {
            return null;
        }
        try {
            bhl com_tencent_mm_protocal_c_bhl = new bhl();
            com_tencent_mm_protocal_c_bhl.az(aO);
            bhm com_tencent_mm_protocal_c_bhm = new bhm();
            int i2 = 20;
            String str = null;
            while (i2 > 0) {
                str = k.xF();
                if (be.kS(str)) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    i2--;
                }
            }
            if (be.kS(str)) {
                return null;
            }
            com_tencent_mm_protocal_c_bhm.mdw = str;
            str = u.e(aa.getContext().getSharedPreferences(aa.bti(), 0));
            String bsY = u.bsY();
            if (str.equals("language_default")) {
                com_tencent_mm_protocal_c_bhm.fvz = bsY;
            } else {
                com_tencent_mm_protocal_c_bhm.fvz = str;
            }
            aO = com.tencent.mm.plugin.wear.model.a.bhH().laR.aP(com_tencent_mm_protocal_c_bhm.toByteArray());
            if (aO == null) {
                return null;
            }
            this.lcb = com_tencent_mm_protocal_c_bhl;
            qx qxVar = new qx();
            qxVar.bsC.aYt = 9;
            com.tencent.mm.sdk.c.a.nhr.a(qxVar, Looper.getMainLooper());
            return aO;
        } catch (Throwable e2) {
            v.a("MicroMsg.Wear.HttpLoginServer", e2, "", new Object[0]);
            return null;
        }
    }
}
