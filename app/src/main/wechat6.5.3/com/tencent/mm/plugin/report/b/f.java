package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.uy;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class f extends k implements j {
    private static boolean aHp = false;
    private static Object lock = new Object();
    private b cif;
    private e cii;
    private uy itA = null;

    public static boolean isRunning() {
        boolean z;
        synchronized (lock) {
            z = aHp;
        }
        return z;
    }

    private static void fe(boolean z) {
        synchronized (lock) {
            aHp = z;
        }
    }

    public f() {
        fe(true);
        this.itA = SmcProtoBufUtil.toMMGetStrategyReq();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (ak.vy() == null || ak.vy().cAa == null) {
            v.f("MicroMsg.NetSceneGetCliKVStrategy", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.cii.a(i2, i3, str, this);
        } else if (i2 != 0) {
            v.e("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
            SmcLogic.OnStrategyResp(i2, i3, null, 1);
            SmcLogic.OnStrategyResp(i2, i3, null, 2);
            this.cii.a(i2, i3, str, this);
            fe(false);
        } else {
            v.d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
            uz uzVar = (uz) this.cif.czl.czs;
            try {
                com.tencent.mm.protocal.a.a.f toSmcKVStrategyResp = SmcProtoBufUtil.toSmcKVStrategyResp(uzVar);
                c toSmcIdkeyStrategyResp = SmcProtoBufUtil.toSmcIdkeyStrategyResp(uzVar);
                SmcLogic.OnStrategyResp(0, 0, toSmcKVStrategyResp.toByteArray(), 1);
                SmcLogic.OnStrategyResp(0, 0, toSmcIdkeyStrategyResp.toByteArray(), 2);
            } catch (Throwable e) {
                v.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), be.e(e));
            }
            this.cii.a(i2, i3, str, this);
            fe(false);
        }
    }

    public final int getType() {
        return (!be.bl(ak.uT()) ? 1 : null) != null ? 988 : 989;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i;
        this.cii = eVar2;
        if (be.bl(ak.uT())) {
            boolean z = false;
        } else {
            i = 1;
        }
        if (i == 0) {
            this.itA.mnp = com.tencent.mm.ba.b.aT(be.buh());
        }
        a aVar = new a();
        aVar.czr = false;
        aVar.czn = this.itA;
        aVar.czo = new uz();
        aVar.uri = i != 0 ? "/cgi-bin/micromsg-bin/getkvidkeystrategy" : "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa";
        aVar.czm = getType();
        this.cif = aVar.Bv();
        if (i == 0) {
            this.cif.a(ad.brH());
            this.cif.brn = 1;
        }
        i = a(eVar, this.cif, this);
        if (i < 0) {
            v.i("MicroMsg.NetSceneGetCliKVStrategy", "mark all failed. do scene %d", Integer.valueOf(i));
            try {
                SmcLogic.OnStrategyResp(3, -1, null, 1);
                SmcLogic.OnStrategyResp(3, -1, null, 2);
                fe(false);
            } catch (Throwable e) {
                v.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), be.e(e));
            }
        }
        return i;
    }
}
