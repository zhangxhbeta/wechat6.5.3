package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.a.g;
import com.tencent.mm.e.b.cy;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class k extends f<g> {
    public static final String[] cic = new String[]{f.a(g.chq, "VoiceRemindInfo")};
    private static long dhV = 0;
    d cie;
    Map<String, c> kfT = new HashMap();

    public k(d dVar) {
        super(dVar, g.chq, "VoiceRemindInfo", cy.btd);
        this.cie = dVar;
    }

    public static String lb(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(currentTimeMillis));
        if (str != null && str.length() > 1) {
            format = format + g.m(str.getBytes()).substring(0, 7);
        }
        StringBuilder append = new StringBuilder().append(format + (currentTimeMillis % 10000));
        currentTimeMillis = dhV;
        dhV = 1 + currentTimeMillis;
        return append.append(currentTimeMillis).toString();
    }

    public final boolean hc(String str) {
        Assert.assertTrue(str.length() > 0);
        if (this.cie.delete("VoiceRemindInfo", "filename= ?", new String[]{str}) <= 0) {
            v.w("MicroMsg.VoiceRemindStorage", "delete failed, no such file:" + str);
        }
        return true;
    }

    public final void lD(String str) {
        c cVar = (c) this.kfT.get(str);
        if (cVar != null) {
            cVar.Lr();
            this.kfT.remove(str);
        }
    }
}
