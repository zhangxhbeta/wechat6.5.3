package com.tencent.mm.plugin.game.c;

import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class x {
    public static c a(d dVar) {
        c cVar = null;
        if (dVar == null) {
            v.e("MicroMsg.GamePBData", "Invalid pb object");
        } else if (be.kS(dVar.gkz)) {
            v.e("MicroMsg.GamePBData", "No AppID field, abort");
        } else {
            v.i("MicroMsg.GamePBData", "Parsing AppID: %s", new Object[]{dVar.gkz});
            cVar = new c();
            cVar.field_appId = dVar.gkz;
            cVar.field_appName = dVar.gkB;
            cVar.field_appIconUrl = dVar.gkA;
            cVar.field_appType = ",1,";
            cVar.field_packageName = dVar.gkE;
            cVar.field_appVersion = dVar.efl;
            cVar.field_appInfoFlag = dVar.gkH;
            if (dVar.gkG != null) {
                cVar.bE(dVar.gkG.gld);
                cVar.bH(dVar.gkG.gle);
                cVar.cN(dVar.gkG.glh);
                cVar.bI(dVar.gkG.glf);
            }
            if (!(dVar.gkG == null || dVar.gkG.glg == null)) {
                cVar.bN(dVar.gkG.glg.gld);
                cVar.bO(dVar.gkG.glg.gop);
                cVar.bL(dVar.gkG.glg.goq);
                cVar.bM(dVar.gkG.glg.gor);
                cVar.cO(dVar.gkG.glg.got);
            }
            cVar.ghn = dVar.gkC;
            cVar.ghm = dVar.gkD;
            cVar.status = dVar.eeO;
            cVar.ghp = dVar.gkv;
            cVar.versionCode = dVar.gkF;
            cVar.bln = dVar.gkx;
            cVar.ghr = dVar.gkI;
            cVar.ghz = dVar.gkN;
            if (!(dVar.gkG == null || dVar.gkG.glg == null)) {
                cVar.ghs = dVar.gkG.glg.gos;
                cVar.ght = dVar.gkG.glg.gou;
                cVar.ghu = dVar.gkG.glg.gov;
            }
        }
        return cVar;
    }
}
