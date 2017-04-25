package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.h.j;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.favorite.b.v.a;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.Iterator;

public final class o implements a {
    public boolean fKK = true;

    public final boolean g(i iVar) {
        if (iVar == null) {
            return true;
        }
        pw n;
        qe qeVar;
        switch (iVar.field_type) {
            case 1:
                return be.kS(iVar.field_favProto.desc);
            case 2:
            case 8:
                return !new File(v.f(v.n(iVar))).exists();
            case 3:
                if (this.fKK) {
                    return true;
                }
                return false;
            case 4:
                n = v.n(iVar);
                if (new File(v.f(n)).exists()) {
                    return false;
                }
                return be.kS(n.mrZ);
            case 5:
                qg qgVar = iVar.field_favProto.mtP;
                qp qpVar = iVar.field_favProto.mtc;
                String str = null;
                if (qpVar != null) {
                    str = qpVar.mur;
                }
                if (qgVar != null && be.kS(r0)) {
                    str = qgVar.cZp;
                }
                return be.kS(str);
            case 6:
                return iVar.field_favProto.mta == null;
            case 7:
                n = v.n(iVar);
                return be.kS(n.mrZ) && be.kS(n.msb) && be.kS(n.msd) && be.kS(n.msd);
            case 10:
                qeVar = iVar.field_favProto.mte;
                return qeVar == null || be.kS(qeVar.info);
            case 11:
                qeVar = iVar.field_favProto.mte;
                return qeVar == null || be.kS(qeVar.info);
            case an.CTRL_INDEX /*14*/:
            case 18:
                if (iVar.field_id <= 0) {
                    return true;
                }
                if (iVar.field_type == 18 && (iVar.field_favProto == null || iVar.field_favProto.mtR.size() <= 1)) {
                    return true;
                }
                if (iVar.field_type == 18 && (be.kS(((pw) iVar.field_favProto.mtR.get(0)).mrS) || be.kS(((pw) iVar.field_favProto.mtR.get(0)).mrU))) {
                    return true;
                }
                Iterator it = iVar.field_favProto.mtR.iterator();
                while (it.hasNext()) {
                    n = (pw) it.next();
                    if (!be.kS(n.mrS) && !be.kS(n.mrU) && !e.aR(v.f(n))) {
                        return true;
                    }
                }
                return false;
            case am.CTRL_INDEX /*15*/:
                qj qjVar = iVar.field_favProto.mtg;
                return qjVar == null || be.kS(qjVar.info);
            case 16:
                if (be.KL(j.sU().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    v.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    return true;
                }
                n = v.n(iVar);
                File file = new File(v.f(n));
                v.v("MicroMsg.FavSendFilter", "type size, favid %d, localid %d, path %s, exist %B", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId), file.getAbsolutePath(), Boolean.valueOf(file.exists())});
                if (!file.exists()) {
                    return true;
                }
                if (Math.abs(n.msn - file.length()) <= 16) {
                    return false;
                }
                String g = g.g(file);
                v.w("MicroMsg.FavSendFilter", "it can not retransmit short video because of file was replaced. file[%d, %s], data[%d, %s]", new Object[]{Long.valueOf(r2), g, Long.valueOf(r4), n.msj});
                return true;
            default:
                return false;
        }
    }

    public static boolean h(i iVar) {
        if (iVar == null) {
            return false;
        }
        if (!v.s(iVar)) {
            return false;
        }
        File file = new File(v.f(v.n(iVar)));
        switch (iVar.field_type) {
            case 2:
            case 8:
                if (!file.exists()) {
                    return true;
                }
                break;
            case 4:
                if (be.kS(v.n(iVar).mrZ) && !file.exists()) {
                    return true;
                }
            case an.CTRL_INDEX /*14*/:
            case 18:
                if (iVar.field_id > 0) {
                    if (iVar.field_favProto != null && iVar.field_favProto.mtR.size() > 1) {
                        Iterator it = iVar.field_favProto.mtR.iterator();
                        while (it.hasNext()) {
                            pw pwVar = (pw) it.next();
                            if (!be.kS(pwVar.mrS) && !be.kS(pwVar.mrU) && !e.aR(v.f(pwVar))) {
                                return true;
                            }
                        }
                        break;
                    }
                    return false;
                }
                return false;
            case 16:
                if (be.KL(j.sU().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    v.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    return false;
                } else if (!file.exists()) {
                    return true;
                }
                break;
        }
        return false;
    }
}
