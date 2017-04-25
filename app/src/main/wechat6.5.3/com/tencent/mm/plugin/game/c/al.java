package com.tencent.mm.plugin.game.c;

import com.tencent.mm.network.p;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.sn;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.b.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class al extends v {
    public al(String str) {
        a aVar = new a();
        aVar.czn = new sn();
        aVar.czo = new so();
        aVar.uri = "/cgi-bin/micromsg-bin/getauthapplist";
        aVar.czm = 394;
        aVar.czp = 0;
        aVar.czq = 0;
        this.fut = aVar.Bv();
        sn snVar = (sn) this.fut.czk.czs;
        snVar.efm = 1;
        snVar.glC = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        so soVar = (so) this.fut.czl.czs;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneGetAuthAppList", "errType = " + i2 + ", errCode = " + i3 + ", get authlist count = " + soVar.mwk);
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = soVar.mwn;
            if (linkedList != null && linkedList.size() > 0) {
                i bmv = j.a.lxJ.bmv();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    dk dkVar = (dk) it.next();
                    f aC = g.aC(dkVar.gkz, true);
                    if (aC != null) {
                        a(aC, dkVar);
                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneGetAuthAppList", "onGYNetEnd, update ret = " + bmv.a(aC, new String[0]) + ", appId = " + aC.field_appId);
                    } else {
                        aC = new f();
                        aC.field_appId = dkVar.gkz;
                        a(aC, dkVar);
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneGetAuthAppList", "insert game appinfo:" + dkVar.gkz + ", ret = " + bmv.m(aC));
                    }
                }
                return;
            }
            return;
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneGetAuthAppList", "errType = " + i2 + ", errCode = " + i3);
    }

    private static void a(f fVar, dk dkVar) {
        fVar.field_appType = dkVar.mdQ;
        fVar.field_appIconUrl = dkVar.gnp;
        fVar.field_appName = dkVar.hNZ;
        fVar.field_authFlag = dkVar.mdj;
        fVar.bC(dkVar.mdR);
        fVar.bD(dkVar.mdS);
    }

    public final byte[] arW() {
        try {
            return ((b) this.fut.Bx()).zf();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.NetSceneGetAuthAppList", e, "", new Object[0]);
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneGetAuthAppList", "reqToBuf failed: " + e.getMessage());
            return null;
        }
    }

    public final void ap(byte[] bArr) {
        if (bArr == null) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneGetAuthAppList", "buf is null");
            return;
        }
        try {
            this.fut.czl.y(bArr);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneGetAuthAppList", e.getMessage());
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.NetSceneGetAuthAppList", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 3;
    }
}
