package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.p;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.atn;
import com.tencent.mm.protocal.c.ato;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.b.b;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class ai extends v {
    public int cmdId;
    private String lBb;

    public ai(String str, int i, String str2) {
        a aVar = new a();
        aVar.czn = new atn();
        aVar.czo = new ato();
        aVar.uri = "/cgi-bin/micromsg-bin/setappsetting";
        this.fut = aVar.Bv();
        atn com_tencent_mm_protocal_c_atn = (atn) this.fut.czk.czs;
        com_tencent_mm_protocal_c_atn.gkz = str;
        com_tencent_mm_protocal_c_atn.mRD = i;
        com_tencent_mm_protocal_c_atn.mRE = str2;
        this.cmdId = i;
        this.lBb = str2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneSetAppSetting", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i2 == 0) {
            ato com_tencent_mm_protocal_c_ato = (ato) this.fut.czl.czs;
            if (com_tencent_mm_protocal_c_ato != null) {
                i bmv = j.a.lxJ.bmv();
                f aC = g.aC(com_tencent_mm_protocal_c_ato.gkz, false);
                if (aC != null) {
                    aC.field_authFlag = com_tencent_mm_protocal_c_ato.mdj;
                    v.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + bmv.a(aC, new String[0]) + ", appId = " + com_tencent_mm_protocal_c_ato.gkz);
                }
            }
        }
    }

    public final byte[] arW() {
        try {
            return ((b) this.fut.Bx()).zf();
        } catch (Exception e) {
            v.e("MicroMsg.NetSceneSetAppSetting", "toProtBuf failed: " + e.getMessage());
            return null;
        }
    }

    public final void ap(byte[] bArr) {
        if (bArr == null) {
            v.e("MicroMsg.NetSceneSetAppSetting", "buf is null");
            return;
        }
        try {
            this.fut.czl.y(bArr);
        } catch (Throwable e) {
            v.e("MicroMsg.NetSceneSetAppSetting", "parse error: " + e.getMessage());
            v.a("MicroMsg.NetSceneSetAppSetting", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public final int getType() {
        return 2;
    }
}
