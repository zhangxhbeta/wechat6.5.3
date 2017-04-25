package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.offline.a.l;
import com.tencent.mm.plugin.offline.h.a;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class e extends a<b> {
    public String hJK = "";
    private a hJL = new a(this) {
        final /* synthetic */ e hJM;

        {
            this.hJM = r1;
        }

        public final void aEI() {
            this.hJM.Yj();
        }
    };

    public final void Yj() {
        if (this.hJH != null) {
            for (int i = 0; i < this.hJH.size(); i++) {
                WeakReference weakReference = (WeakReference) this.hJH.get(i);
                if (weakReference != null) {
                    b bVar = (b) weakReference.get();
                    if (bVar != null) {
                        bVar.ZN();
                    }
                }
            }
        }
    }

    public e() {
        j.aEM();
        if (j.aEP() != null) {
            j.aEM();
            j.aEP().hJV = this.hJL;
        }
    }

    private static void aEG() {
        j.aEM();
        j.aEP().nN(1);
    }

    public final String cc(int i, int i2) {
        int aEH = aEH();
        if (aEH > 0) {
            if (aEH < 10) {
                v.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount < 10");
                j.aEM();
                j.aEP().nM(2);
            }
            j.aEM();
            String nO = j.nO(196617);
            if (TextUtils.isEmpty(nO)) {
                v.e("MicroMsg.OfflineCodesMgr", "generateKey_V3 cn is null, the csr is not exist! cn:" + nO);
                return "";
            }
            com.tencent.mm.wallet_core.b.a.bKZ();
            nO = com.tencent.mm.wallet_core.b.a.getToken(nO);
            if (TextUtils.isEmpty(nO)) {
                aEG();
                v.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null");
                return "";
            }
            if (nO != null) {
                v.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code length : " + nO.length());
            }
            ak.vy().a(new l(aEH - 1, i, i2), 0);
            v.d("MicroMsg.OfflineCodesMgr", "doNetSceneShowCode count " + (aEH - 1));
            LinkedList xt = com.tencent.mm.plugin.offline.b.a.xt(com.tencent.mm.plugin.offline.b.a.aFy());
            if (xt == null || xt.size() == 0) {
                v.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 cardList is null");
                aEG();
                return "";
            } else if (nO == null || !com.tencent.mm.plugin.offline.b.a.qw(nO)) {
                v.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null or is not isNumeric");
                return "";
            } else {
                long longValue = Long.valueOf(nO, 10).longValue();
                long j = 0;
                int i3 = 0;
                while (i3 < xt.size()) {
                    com.tencent.mm.plugin.offline.b.a.a aVar = (com.tencent.mm.plugin.offline.b.a.a) xt.get(i3);
                    long j2 = (aVar == null || aVar.hMu == null || !aVar.hMu.equals(this.hJK)) ? j : (long) aVar.hMs;
                    i3++;
                    j = j2;
                }
                String valueOf = String.valueOf((j << 48) | longValue);
                if (valueOf.length() == 15) {
                    valueOf = "0" + valueOf;
                } else if (valueOf.length() == 14) {
                    valueOf = "00" + valueOf;
                } else if (valueOf.length() == 13) {
                    valueOf = "000" + valueOf;
                } else if (valueOf.length() == 12) {
                    valueOf = "0000" + valueOf;
                }
                return !TextUtils.isEmpty(com.tencent.mm.plugin.offline.b.a.aFA()) ? com.tencent.mm.plugin.offline.b.a.aFA() + valueOf : "12" + valueOf;
            }
        } else {
            aEG();
            v.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount is 0");
            return "";
        }
    }

    public static int aEH() {
        j.aEM();
        j.aEP();
        return h.aEK();
    }
}
