package com.tencent.mm.modelsimple;

import com.tencent.mm.model.bb;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bjl;
import com.tencent.mm.protocal.c.bjm;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class ai extends k implements j {
    private final b cYO;
    private e cii;
    private int retryCount = 3;

    public ai(String str, int i) {
        a aVar = new a();
        aVar.czn = new bjl();
        aVar.czo = new bjm();
        aVar.uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
        aVar.czm = 729;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cYO = aVar.Bv();
        bjl com_tencent_mm_protocal_c_bjl = (bjl) this.cYO.czk.czs;
        com_tencent_mm_protocal_c_bjl.fvz = u.bsY();
        com_tencent_mm_protocal_c_bjl.men = bb.eN(0);
        com_tencent_mm_protocal_c_bjl.ndT = str;
        com_tencent_mm_protocal_c_bjl.gkF = i;
        v.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", com_tencent_mm_protocal_c_bjl.fvz, str, Integer.valueOf(i), be.bur());
    }

    public final int getType() {
        return 729;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cYO, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        bjl com_tencent_mm_protocal_c_bjl = (bjl) this.cYO.czk.czs;
        bjm com_tencent_mm_protocal_c_bjm = (bjm) this.cYO.czl.czs;
        v.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(com_tencent_mm_protocal_c_bjm.ndU), com_tencent_mm_protocal_c_bjm.ndV);
        g gVar;
        Object[] objArr;
        if (i2 == 0 && i3 == 0) {
            if (com_tencent_mm_protocal_c_bjm.ndU == 2 || com_tencent_mm_protocal_c_bjm.ndU == 3) {
                this.retryCount--;
                if (this.retryCount <= 0) {
                    v.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
                    g.iuh.a(322, 2, 1, false);
                    gVar = g.iuh;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(4002);
                    objArr[1] = String.format("%s,%d", new Object[]{com_tencent_mm_protocal_c_bjl.ndT, Integer.valueOf(com_tencent_mm_protocal_c_bjl.gkF)});
                    gVar.h(11098, objArr);
                    this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                    return;
                }
                v.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken do scene again retryCount:%d", Integer.valueOf(this.retryCount));
                a(this.czE, this.cii);
            } else if (com_tencent_mm_protocal_c_bjm.ndU == 1) {
                MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "yyb_pkg_sig_prefs", 4).edit().remove(com_tencent_mm_protocal_c_bjl.ndT).commit();
                g.iuh.a(322, 5, 1, false);
                gVar = g.iuh;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4005);
                objArr[1] = String.format("%s,%d", new Object[]{com_tencent_mm_protocal_c_bjl.ndT, Integer.valueOf(com_tencent_mm_protocal_c_bjl.gkF)});
                gVar.h(11098, objArr);
                v.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", com_tencent_mm_protocal_c_bjm.ndV);
            } else if (com_tencent_mm_protocal_c_bjm.ndU == 4) {
                v.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
                g.iuh.a(322, 4, 1, false);
                gVar = g.iuh;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4004);
                objArr[1] = String.format("%s,%d", new Object[]{com_tencent_mm_protocal_c_bjl.ndT, Integer.valueOf(com_tencent_mm_protocal_c_bjl.gkF)});
                gVar.h(11098, objArr);
            } else {
                v.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", com_tencent_mm_protocal_c_bjm.ndV);
                MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "yyb_pkg_sig_prefs", 4).edit().putString(com_tencent_mm_protocal_c_bjl.ndT, com_tencent_mm_protocal_c_bjm.ndV).commit();
                g.iuh.a(322, 3, 1, false);
                gVar = g.iuh;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4003);
                objArr[1] = String.format("%s,%d,%s", new Object[]{com_tencent_mm_protocal_c_bjl.ndT, Integer.valueOf(com_tencent_mm_protocal_c_bjl.gkF), com_tencent_mm_protocal_c_bjm.ndV});
                gVar.h(11098, objArr);
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        v.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
        g.iuh.a(322, 1, 1, false);
        gVar = g.iuh;
        objArr = new Object[2];
        objArr[0] = Integer.valueOf(4001);
        objArr[1] = String.format("%s,%d,%d,%d", new Object[]{com_tencent_mm_protocal_c_bjl.ndT, Integer.valueOf(com_tencent_mm_protocal_c_bjl.gkF), Integer.valueOf(i2), Integer.valueOf(i3)});
        gVar.h(11098, objArr);
        this.cii.a(i2, i3, str, this);
    }
}
