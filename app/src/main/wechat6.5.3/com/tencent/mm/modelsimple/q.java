package com.tencent.mm.modelsimple;

import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.a.pt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ai;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.yf;
import com.tencent.mm.protocal.c.yg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class q extends k implements j {
    private String cYN;
    private b cif;
    private e cii;

    public q(String str) {
        this.cYN = str;
        a aVar = new a();
        aVar.czn = new yf();
        aVar.czo = new yg();
        aVar.uri = "/cgi-bin/micromsg-bin/getprofile";
        this.cif = aVar.Bv();
        ((yf) this.cif.czk.czs).gln = str;
    }

    public final int getType() {
        return 302;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (be.kS(this.cYN)) {
            v.e("MicroMsg.NetSceneGetProfile", "null or empty username");
            return -1;
        }
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + i2 + " errCode=" + i3 + " errMsg=" + str);
        if (i2 == 0 && i3 == 0) {
            yg ygVar = (yg) this.cif.czl.czs;
            com.tencent.mm.sdk.c.b ptVar = new pt();
            ptVar.bqZ.bra = ygVar;
            com.tencent.mm.sdk.c.a.nhr.z(ptVar);
            ptVar = new pr();
            ptVar.bqX.bqY = ygVar.mAe.mYU;
            com.tencent.mm.sdk.c.a.nhr.z(ptVar);
            if (com.tencent.mm.model.k.xF().equals(ygVar.mAd.moM.toString()) && !be.kS(ygVar.mAe.mlZ)) {
                g.vw().vf().a(t.a.USERINFO_SELFINFO_SMALLIMGURL_STRING, ygVar.mAe.mlZ);
            }
            v.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", Integer.valueOf(ygVar.mAd.mJO), Integer.valueOf(ygVar.mAe.mYO));
            g.vw().vf().set(64, Integer.valueOf(ygVar.mAe.may));
            g.vw().vf().set(144385, Integer.valueOf(ygVar.mAe.mYO));
            g.vw().vf().set(40, Integer.valueOf(ygVar.mAd.mJO));
            g.vw().vf().set(339975, Integer.valueOf(ygVar.mAe.mYW));
            v.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", Integer.valueOf(ygVar.mAe.mYW));
            g.vw().vf().a(t.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(ygVar.mAe.mYX));
            v.d("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", Integer.valueOf(ygVar.mAe.mYW), Integer.valueOf(ygVar.mAe.mYX));
            g.vw().vf().set(208903, ygVar.mAe.mgj);
            g.vw().vf().set(274433, ygVar.mAe.mJf);
            g.vw().vf().set(274434, ygVar.mAe.mJe);
            g.vw().vf().set(274436, ygVar.mAe.mYP);
            g.vw().vf().a(t.a.USERINFO_PROFILE_WEIDIANINFO_STRING, be.ah(ygVar.mAe.bCy, SQLiteDatabase.KeyEmpty));
            v.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", ygVar.mAe.bCy);
            ai.cse.J("last_login_use_voice", ygVar.mAd.mJO);
            if (VERSION.SDK_INT < 23) {
                System.putString(aa.getContext().getContentResolver(), "89884a87498ef44f", ygVar.mAe.mYV);
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
