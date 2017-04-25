package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.offline.a.c;
import com.tencent.mm.plugin.offline.a.i;
import com.tencent.mm.plugin.offline.a.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;

public final class h implements e {
    private boolean hJQ = false;
    private boolean hJR = false;
    private int hJS = 10;
    private int hJT = 0;
    private String hJU = "";
    a hJV;
    private j hJW;
    public Runnable hJX = new Runnable(this) {
        final /* synthetic */ h hKa;

        {
            this.hKa = r1;
        }

        public final void run() {
            v.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
            this.hKa.nN(6);
        }
    };
    int hJY = 14400000;
    ah hJZ = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ h hKa;

        {
            this.hKa = r1;
        }

        public final boolean oU() {
            if (ak.uz()) {
                long j;
                this.hKa.nL(5);
                ah ahVar = this.hKa.hJZ;
                h hVar = this.hKa;
                long aFD = (long) com.tencent.mm.plugin.offline.b.a.aFD();
                if (aFD <= 0) {
                    j = (long) hVar.hJY;
                } else {
                    v.i("MicroMsg.OfflineTokensMgr", "OfflineTokensMgr updateInterval:" + aFD);
                    j = 1000 * aFD;
                }
                ahVar.ea(j);
            } else {
                this.hKa.hJZ.ea((long) this.hKa.hJY);
            }
            return false;
        }
    }, false);
    public ac mHandler = new ac();

    public interface a {
        void aEI();
    }

    public h() {
        long j = 1;
        try {
            com.tencent.mm.wallet_core.b.a.bKZ();
            com.tencent.mm.wallet_core.b.a.init(aa.getContext());
        } catch (Exception e) {
            v.e("MicroMsg.OfflineTokensMgr", "NO MPERMISSION for READ_PHONE_STATE:%s.", new Object[]{e});
        }
        ak.vy().a(385, this);
        j.aEM();
        String nO = j.nO(196649);
        if (TextUtils.isEmpty(nO) || !com.tencent.mm.plugin.offline.b.a.qw(nO)) {
            v.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        } else {
            Object aFr = com.tencent.mm.plugin.offline.b.a.aFr();
            v.i("MicroMsg.OfflineTokensMgr", "genInitInterval: token is not over update interval,lastUpdate is " + aFr);
            long longValue = Long.valueOf(nO).longValue();
            if (TextUtils.isEmpty(aFr)) {
                v.i("MicroMsg.OfflineTokensMgr", "genInitInterval lastUpdate is empty, update token");
            } else {
                j = Long.valueOf(aFr).longValue();
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                v.i("MicroMsg.OfflineTokensMgr", "genInitInterval token is not over update interval,curTime = " + currentTimeMillis + ";");
                j = longValue - (currentTimeMillis - j);
            }
        }
        v.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=" + j);
        this.hJZ.ea(j * 1000);
    }

    public static int aEK() {
        j.aEM();
        String nO = j.nO(196617);
        com.tencent.mm.wallet_core.b.a.bKZ();
        int tokenCount = com.tencent.mm.wallet_core.b.a.getTokenCount(nO, true);
        v.i("MicroMsg.OfflineTokensMgr", "offline tokens count:" + tokenCount);
        return tokenCount;
    }

    public final void nL(int i) {
        if (com.tencent.mm.sdk.platformtools.ak.isNetworkConnected(aa.getContext()) && com.tencent.mm.plugin.offline.b.a.aFk()) {
            v.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
            nN(i);
        }
    }

    public final void aEL() {
        if (!com.tencent.mm.plugin.offline.b.a.aFk()) {
            v.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
        } else if (aEK() < 10) {
            v.i("MicroMsg.OfflineTokensMgr", "getTokenCount < 10, do doNetSceneToken");
            com.tencent.mm.wallet_core.b.a.bKZ();
            int lastError = com.tencent.mm.wallet_core.b.a.getLastError();
            if (lastError != 0) {
                v.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + lastError + ", don't  doNetSceneToken");
                return;
            }
            v.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
            nM(2);
        } else if (com.tencent.mm.plugin.offline.b.a.aFE()) {
            v.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
            nN(5);
        } else if (!com.tencent.mm.plugin.offline.b.a.aFC()) {
            v.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
            nN(3);
        }
    }

    public final void nM(int i) {
        if (aEK() > 2) {
            this.mHandler.postDelayed(new Runnable(this, 2) {
                final /* synthetic */ h hKa;

                public final void run() {
                    this.hKa.nN(2);
                }
            }, 3000);
        } else {
            nN(2);
        }
    }

    public final void nN(int i) {
        if (!this.hJQ) {
            this.hJQ = true;
            ak.vy().a(new j((System.currentTimeMillis() / 1000), i), 0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 6;
        if ((kVar instanceof com.tencent.mm.plugin.offline.a.e) || (kVar instanceof c)) {
            ArrayList arrayList = new ArrayList();
            if (kVar instanceof j) {
                IDKey iDKey = new IDKey();
                iDKey.SetID(135);
                iDKey.SetValue(1);
                iDKey.SetKey(2);
                arrayList.add(iDKey);
                if (!(i == 0 && i2 == 0)) {
                    iDKey = new IDKey();
                    iDKey.SetID(135);
                    iDKey.SetValue(1);
                    iDKey.SetKey(3);
                    arrayList.add(iDKey);
                }
                g gVar = g.iuh;
                g.d(arrayList, true);
            }
            if ((kVar instanceof c) && ((i == 0 && i2 == 0) || i != 0)) {
                v.i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                if (this.hJW != null) {
                    this.hJW.aER();
                    this.hJW = null;
                    if (this.hJV != null) {
                        this.hJV.aEI();
                    }
                }
            }
            if (i == 0 && i2 == 0) {
                if (kVar instanceof j) {
                    this.hJT = 0;
                    this.hJQ = false;
                    this.mHandler.removeCallbacks(this.hJX);
                    this.hJW = (j) kVar;
                    String str2 = this.hJW.hKS;
                    j.aEM();
                    ak.vy().a(new c(str2, j.nO(196617)), 0);
                } else if (kVar instanceof i) {
                    this.hJR = false;
                    this.hJU = ((i) kVar).hJU;
                    if (this.hJV != null) {
                        this.hJV.aEI();
                    }
                } else if (!(kVar instanceof c)) {
                }
            } else if (kVar instanceof j) {
                v.e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
                this.hJT++;
                this.hJQ = false;
                if (i2 == 411) {
                    v.i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
                    com.tencent.mm.plugin.offline.b.a.aFu();
                } else if (this.hJT < this.hJS) {
                    this.mHandler.removeCallbacks(this.hJX);
                    int i4 = this.hJT - 1;
                    if (i4 <= 6) {
                        i3 = i4;
                    }
                    this.mHandler.postDelayed(this.hJX, (long) ((((int) Math.pow(2.0d, (double) i3)) * 60) * 1000));
                }
            } else if (kVar instanceof i) {
                this.hJR = false;
            } else if (kVar instanceof c) {
                this.hJW = null;
            }
        }
    }
}
