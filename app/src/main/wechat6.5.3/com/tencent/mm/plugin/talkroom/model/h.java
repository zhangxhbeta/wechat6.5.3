package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.u;

public final class h {
    private static final int kjH = a.kjH;

    public static String au(Context context, String str) {
        if (be.kS(str)) {
            return null;
        }
        ak.yW();
        u LX = c.wH().LX(str);
        if (LX == null) {
            return null;
        }
        if (!m.dE(str)) {
            return l.er(str);
        }
        if (be.kS(LX.field_nickname)) {
            return context.getString(2131235634);
        }
        return LX.tT();
    }
}
