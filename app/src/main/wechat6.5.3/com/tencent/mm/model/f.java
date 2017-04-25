package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.aw.a;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import junit.framework.Assert;

public final class f {
    public static void ec(String str) {
        Assert.assertTrue(!be.kS(str));
        ak.yW();
        ab LX = c.wH().LX(str);
        if (LX != null && !be.kS(LX.field_username)) {
            LX.setType(LX.field_type | 2048);
            m.r(LX);
            ak.yW();
            if (c.wK().Mh(str) == null && LX.bvm()) {
                if (e.hy(str)) {
                    com.tencent.mm.storage.ab abVar;
                    ak.yW();
                    if (c.wK().Mh("officialaccounts") == null) {
                        abVar = new com.tencent.mm.storage.ab("officialaccounts");
                        abVar.bvG();
                        ak.yW();
                        c.wK().d(abVar);
                    }
                    abVar = new com.tencent.mm.storage.ab(str);
                    abVar.s(System.currentTimeMillis());
                    abVar.cw("officialaccounts");
                    ak.yW();
                    c.wK().d(abVar);
                } else if (e.hA(str) && !e.hC(str)) {
                    com.tencent.mm.storage.ab abVar2;
                    BizInfo hw = e.hw(str);
                    ak.yW();
                    if (c.wK().Mh(hw.field_enterpriseFather) == null) {
                        abVar2 = new com.tencent.mm.storage.ab(hw.field_enterpriseFather);
                        abVar2.bvG();
                        ak.yW();
                        c.wK().d(abVar2);
                    }
                    abVar2 = new com.tencent.mm.storage.ab(str);
                    abVar2.s(System.currentTimeMillis());
                    abVar2.cw(hw.CF());
                    ak.yW();
                    c.wK().d(abVar2);
                }
                v.i("MicroMsg.BizConversationLogic", "setPlacedTop username = " + str);
            }
            ak.yW();
            c.wK().Ml(str);
        }
    }

    public static int a(final String str, final long j, final a aVar) {
        v.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", Long.valueOf(j));
        ak.vA().x(new Runnable() {
            public final void run() {
                Cursor L = ak.yW().cqY.L(str, j);
                if (L.moveToFirst()) {
                    while (!L.isAfterLast() && (aVar == null || !aVar.zp())) {
                        at atVar = new at();
                        atVar.b(L);
                        aw.f(atVar);
                        L.moveToNext();
                    }
                }
                L.close();
                ak.yW().cqY.K(str, j);
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 cry;

                    {
                        this.cry = r1;
                    }

                    public final void run() {
                        if (aVar != null) {
                            aVar.zo();
                        }
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|deleteMsgByTalker";
            }
        });
        return 0;
    }
}
