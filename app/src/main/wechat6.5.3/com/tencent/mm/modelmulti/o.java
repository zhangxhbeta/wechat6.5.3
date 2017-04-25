package com.tencent.mm.modelmulti;

import android.database.Cursor;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.an;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class o implements ag {
    private b cSm;

    public final HashMap<Integer, c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }

    public final void aG(boolean z) {
        Object obj = Hq().cSm;
        if (obj != null) {
            ak.yW().xx().a(obj, ak.vA().htb.getLooper());
            ak.vA().x(new Runnable(obj) {
                final /* synthetic */ b cQI;

                {
                    this.cQI = r1;
                }

                public final void run() {
                    Cursor Kp = ak.yW().xx().Kp();
                    if (Kp != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        if (Kp.moveToFirst()) {
                            while (!Kp.isAfterLast()) {
                                an anVar = new an();
                                anVar.b(Kp);
                                if (anVar.field_originSvrId != 0) {
                                    if (currentTimeMillis > 604800000 + (anVar.field_createTime * 1000)) {
                                        arrayList.add(anVar);
                                        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr get syscmdinfo from db originSvrId[%d] but expired and delete", Long.valueOf(anVar.field_originSvrId));
                                    } else {
                                        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr get syscmdinfo from db originSvrId[%d]", Long.valueOf(anVar.field_originSvrId));
                                        this.cQI.cQH.put(Long.valueOf(anVar.field_originSvrId), anVar);
                                    }
                                }
                                Kp.moveToNext();
                            }
                        }
                        Kp.close();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            an anVar2 = (an) it.next();
                            ak.yW().xx().a((com.tencent.mm.sdk.h.c) anVar2, false, SQLiteDatabase.KeyEmpty);
                        }
                    }
                }
            });
        }
    }

    public static p Ho() {
        return ((d) g.f(d.class)).Ho();
    }

    public static b Hp() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (Hq().cSm == null) {
            Hq().cSm = new b();
        }
        return Hq().cSm;
    }

    private static o Hq() {
        o oVar = (o) ak.yP().fY(o.class.getName());
        if (oVar != null) {
            return oVar;
        }
        Object oVar2 = new o();
        ak.yP().a(o.class.getName(), oVar2);
        return oVar2;
    }

    public final void th() {
        a aVar = Hq().cSm;
        if (aVar != null) {
            v.i("MicroMsg.GetChatRoomMsgService", "clear clearList.size:%d needGetInfosMap.size:%d respList.size:%d, currentListener:%s", Integer.valueOf(aVar.cQF.size()), Integer.valueOf(aVar.cQE.size()), Integer.valueOf(aVar.cKe.size()), aVar.cQG);
            aVar.cKi.QI();
            aVar.cKj.QI();
            aVar.cQF.clear();
            aVar.cQE.clear();
            aVar.cKe.clear();
            aVar.cQG = null;
            aVar.cxK = false;
            ak.yW().xx().d(aVar);
        }
    }
}
