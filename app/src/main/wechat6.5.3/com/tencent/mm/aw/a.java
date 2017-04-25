package com.tencent.mm.aw;

import android.content.Context;
import com.tencent.mm.ar.l;
import com.tencent.mm.ay.c;
import com.tencent.mm.h.j;
import com.tencent.mm.sdk.platformtools.be;

public final class a {
    public static boolean bmn() {
        Object value = j.sU().getValue("EnableStrangerChat");
        String str = "1";
        if (be.kS(value)) {
            value = "0";
        }
        return str.equals(value);
    }

    public static void cU(Context context) {
        if (bmn() || l.KE().Kw() <= 0) {
            c.w(context, "nearby", ".ui.NearbyFriendsUI");
        } else {
            c.w(context, "nearby", ".ui.NearbyFriendShowSayHiUI");
        }
    }
}
