package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.e.b.ab;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.b;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ay;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class w {
    public static at a(dx dxVar, HashMap<String, Integer> hashMap, HashSet<String> hashSet) {
        String str = (String) b.Vd().vf().get(2, null);
        au wJ = b.Vd().wJ();
        String str2 = dxVar.mbU.mQy;
        Object obj = dxVar.mbV.mQy;
        v.i("MicroMsg.RecoverMsgLogic", "recoverMsg, type:%d, from:%s, to:%s", Integer.valueOf(dxVar.efm), str2, obj);
        z Vd = b.Vd();
        if (Vd.uin == 0) {
            throw new b();
        }
        Object obj2;
        ay ayVar = Vd.eke;
        aa wH = b.Vd().wH();
        Object obj3 = (ayVar.has(str2) || str.equals(str2)) ? 1 : null;
        if (obj3 != null) {
            obj2 = obj;
        } else {
            String str3 = str2;
        }
        hashSet.add(obj2);
        List Vw = g.Vw();
        if (Vw.contains(str2) || Vw.contains(obj)) {
            v.w("MicroMsg.RecoverMsgLogic", "hit the blockList: " + str2 + " " + obj);
            return null;
        } else if (be.kS(str2) || be.kS(obj)) {
            v.w("MicroMsg.RecoverMsgLogic", "form or to username is null");
            return null;
        } else {
            if (dxVar.mcb == 0 && dxVar.mbT != 0) {
                dxVar.mcb = (long) dxVar.mbT;
            }
            if (dxVar.mcb != 0) {
                bx S = wJ.S(str.equals(str2) ? obj : str2, dxVar.mcb);
                if (S.field_msgId != 0) {
                    v.i("MicroMsg.RecoverMsgLogic", "msg exist");
                    return null;
                }
                if (dxVar.mcb != 0) {
                    S.y(dxVar.mcb);
                }
                S.B((long) dxVar.meW);
                if (dxVar.meX != 0) {
                    S.z(dxVar.meX);
                } else {
                    S.z(((long) dxVar.meP) * 1000);
                }
                S.dr(dxVar.meY);
                S.setType(dxVar.efm);
                ab LX;
                if (obj3 != null) {
                    LX = wH.LX(obj);
                    if (LX == null || be.kS(LX.field_username) || !LX.bvm()) {
                        S.di(1);
                        S.cH(obj);
                        S.dh(dxVar.meO);
                    } else {
                        v.w("MicroMsg.RecoverMsgLogic", "hit the blockList: " + obj);
                        return null;
                    }
                }
                LX = wH.LX(str2);
                if (LX == null || be.kS(LX.field_username) || !LX.bvm()) {
                    S.di(0);
                    S.cH(str2);
                    S.dh(4);
                    if (dxVar.meO == 3) {
                        hashMap.put(str2, Integer.valueOf(be.a((Integer) hashMap.get(str2), 0) + 1));
                    }
                } else {
                    v.w("MicroMsg.RecoverMsgLogic", "hit the blockList: " + str2);
                    return null;
                }
                if (obj3 == null) {
                    String str4 = str2;
                }
                hashMap.put(obj, Integer.valueOf(be.a((Integer) hashMap.get(str2), 0)));
                l lVar = b.if(dxVar.efm);
                if (lVar == null) {
                    v.i("MicroMsg.RecoverMsgLogic", "unknow type ");
                    return null;
                }
                lVar.a(str, dxVar, S);
                return S;
            }
            v.w("MicroMsg.RecoverMsgLogic", "drop the item server id < 0");
            return null;
        }
    }
}
