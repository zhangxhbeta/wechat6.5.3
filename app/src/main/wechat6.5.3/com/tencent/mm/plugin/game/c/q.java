package com.tencent.mm.plugin.game.c;

import android.database.Cursor;
import com.tencent.mm.e.a.kg;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.game.c.n.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.t.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class q {
    static boolean a(n nVar, n nVar2) {
        if (nVar.field_weight.compareTo(nVar2.field_weight) >= 0) {
            return true;
        }
        return false;
    }

    public final void a(kg kgVar) {
        n arq = arq();
        if (arq != null) {
            arq.arp();
            af.ui(arq.giU);
            kgVar.blk.aXx = arq.gin.gja;
            kgVar.blk.appId = arq.field_appId;
            kgVar.blk.appName = arq.gin.dVK;
            kgVar.blk.bll = arq.gin.giY;
            kgVar.blk.msgType = arq.field_msgType;
            if (arq.field_msgType == 100) {
                kgVar.blk.msgType = arq.giT;
            }
            kgVar.blk.blm = arq.field_gameMsgId;
            kgVar.blk.bln = arq.giU;
        }
    }

    public static n arq() {
        n bX;
        ak.yW();
        long longValue = ((Long) c.vf().get(a.nra, Long.valueOf(0))).longValue();
        if (longValue != 0) {
            bX = au.asc().bX(longValue);
        } else {
            bX = null;
        }
        if (bX != null && !bX.field_isHidden && !f(bX)) {
            return bX;
        }
        af.ui("");
        return null;
    }

    public static void arr() {
        ak.yW();
        long longValue = ((Long) c.vf().get(a.nra, Long.valueOf(0))).longValue();
        n nVar = null;
        if (longValue != 0) {
            nVar = au.asc().bX(longValue);
        }
        if (nVar != null && !nVar.field_isHidden) {
            ak.yW();
            c.vf().a(a.nra, Long.valueOf(0));
        }
    }

    public static n ars() {
        ak.yW();
        long longValue = ((Long) c.vf().get(a.nre, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            return null;
        }
        n bX = au.asc().bX(longValue);
        if (bX == null || bX.field_isHidden || f(bX)) {
            return null;
        }
        return bX;
    }

    public static void art() {
        ak.yW();
        long longValue = ((Long) c.vf().get(a.nre, Long.valueOf(0))).longValue();
        n nVar = null;
        if (longValue != 0) {
            nVar = au.asc().bX(longValue);
        }
        if (nVar != null && !nVar.field_isHidden) {
            ak.yW();
            c.vf().a(a.nre, Long.valueOf(0));
        }
    }

    public static n aru() {
        ak.yW();
        long longValue = ((Long) c.vf().get(a.nrb, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            return null;
        }
        n bX = au.asc().bX(longValue);
        if (bX == null || bX.field_isHidden || f(bX)) {
            return null;
        }
        return bX;
    }

    public static void arv() {
        ak.yW();
        long longValue = ((Long) c.vf().get(a.nrb, Long.valueOf(0))).longValue();
        n nVar = null;
        if (longValue != 0) {
            nVar = au.asc().bX(longValue);
        }
        if (nVar != null && !nVar.field_isHidden) {
            ak.yW();
            c.vf().a(a.nrb, Long.valueOf(0));
        }
    }

    public static n arw() {
        ak.yW();
        return au.asc().bX(((Long) c.vf().get(a.nrd, Long.valueOf(0))).longValue());
    }

    public static void arx() {
        ak.yW();
        if (au.asc().bX(((Long) c.vf().get(a.nrd, Long.valueOf(0))).longValue()) != null) {
            ak.yW();
            c.vf().a(a.nrd, Long.valueOf(0));
        }
    }

    private static boolean f(n nVar) {
        return nVar.field_expireTime < System.currentTimeMillis() / 1000;
    }

    static void g(n nVar) {
        if (!be.kS(nVar.field_mergerId)) {
            n nVar2;
            r asc = au.asc();
            String str = "select * from GameRawMessage where msgType=" + nVar.field_msgType + " and mergerId= \"" + nVar.field_mergerId + "\" order by createTime desc limit 1";
            n nVar3 = new n();
            Cursor rawQuery = asc.rawQuery(str, new String[0]);
            if (rawQuery == null) {
                nVar2 = null;
            } else {
                if (rawQuery.moveToFirst()) {
                    nVar3.b(rawQuery);
                }
                rawQuery.close();
                nVar2 = nVar3;
            }
            if (nVar2 != null) {
                nVar2.arp();
                if (!be.bP(nVar2.gil)) {
                    nVar.arp();
                    Object linkedList = new LinkedList(nVar2.gil);
                    if (!be.bP(nVar.gil)) {
                        String str2 = ((g) nVar.gil.get(0)).userName;
                        if (!be.kS(str2)) {
                            Iterator it = nVar2.gil.iterator();
                            while (it.hasNext()) {
                                g gVar = (g) it.next();
                                if (gVar.userName.equals(str2)) {
                                    linkedList.remove(gVar);
                                    break;
                                }
                            }
                        }
                    }
                    if (!be.bP(linkedList)) {
                        nVar.field_rawXML = ag.a(nVar.field_rawXML, linkedList, nVar2.giq);
                    }
                    au.asc().c(nVar2, new String[0]);
                }
            }
        }
    }
}
