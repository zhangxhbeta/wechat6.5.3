package com.tencent.mm.modelbiz.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;

public final class i {
    public static void f(int i, String str, String str2) {
        if ("EnterpriseChatStatus".equals(str)) {
            String[] split = str2.split(";");
            String str3 = split[0];
            String str4 = split[1];
            be.getInt(split[2], 0);
            if (i == 7) {
                T(str4, str3);
            } else if (i == 8) {
                T(str4, str3);
            } else if (i == 9) {
                T(str4, str3);
            }
        }
    }

    private static void T(String str, String str2) {
        long ia = e.ia(str);
        if (ia == -1) {
            v.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", str);
            return;
        }
        int i = u.DB().T(ia).field_newUnReadCount;
        u.DB().V(ia);
        c Z = u.DA().Z(ia);
        ak.yW();
        ab Mh = c.wK().Mh(str2);
        if (Mh == null) {
            v.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", str2);
        } else if (Z.fe(1)) {
            if (Mh.field_unReadMuteCount <= i) {
                Mh.dm(0);
                ak.yW();
                c.wK().a(Mh, str2, true);
                ak.oH().cancelNotification(str2);
                return;
            }
            Mh.dm(Mh.field_unReadMuteCount - i);
            ak.yW();
            c.wK().a(Mh, str2, true);
        } else if (Mh.field_unReadCount <= i) {
            ak.yW();
            c.wK().Mj(str2);
            ak.oH().cancelNotification(str2);
        } else {
            Mh.dl(0);
            Mh.df(Mh.field_unReadCount - i);
            ak.yW();
            c.wK().a(Mh, str2, true);
        }
    }
}
